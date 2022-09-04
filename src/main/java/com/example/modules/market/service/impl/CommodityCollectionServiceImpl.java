package com.example.modules.market.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.modules.market.entity.po.CommodityCollection;
import com.example.modules.market.entity.vo.CommodityVO;
import com.example.modules.market.mapper.CommodityCollectionMapper;
import com.example.modules.market.service.CommodityCollectionService;
import com.example.modules.market.service.CommodityCommentService;
import com.example.modules.market.service.CommodityImageService;
import com.example.modules.market.service.RedisLtService;
import com.example.modules.user.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityCollectionServiceImpl extends ServiceImpl<CommodityCollectionMapper, CommodityCollection> implements CommodityCollectionService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    CommodityCollectionMapper commodityCollectionMapperImpl;

    @Autowired
    CommodityImageService commodityImageServiceImpl;

    @Autowired
    CommodityCommentService commodityCommentServiceImpl;

    @Autowired
    RedisLtService redisLtServiceImpl;

    //点击收藏
    @Override
    public boolean addCollectionSer(String commodityId) {
        try {
            ValueOperations<String,String> redis = redisTemplate.opsForValue();
            String userId = redis.get(Consts.REDIS_USER);
            CommodityCollection commodityCollection=new CommodityCollection();
            commodityCollection.setCommodityId(commodityId);
            commodityCollection.setUserId(userId);
            commodityCollectionMapperImpl.insert(commodityCollection);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //取消收藏
    @Override
    public boolean cancleCollectionSer(String collectionId) {
        try {
            commodityCollectionMapperImpl.deleteById(collectionId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //查看我的收藏
    @Override
    public List<CommodityVO> getAllSer() {
        ValueOperations<String,String> redis = redisTemplate.opsForValue();
        String userId = redis.get(Consts.REDIS_USER);

        List<CommodityVO> commodityVOList=new ArrayList<>();
        commodityVOList=commodityCollectionMapperImpl.getMyCollection(userId);

        try {
            for (int i=0;i<commodityVOList.size();i++){
                List<String> allImg= commodityImageServiceImpl.getAllImgService(commodityVOList.get(i).getId());
                commodityVOList.get(i).setAllImg(allImg);
                commodityVOList.get(i).setTotalImage(allImg.get(0));
                Integer commentCount = commodityCommentServiceImpl.getCommentCount(commodityVOList.get(i).getId());
                commodityVOList.get(i).setCommentCount(commentCount);
                Integer likedCountFromRedisByPostId = redisLtServiceImpl.getLikedCountFromRedisByPostId(commodityVOList.get(i).getId());
                if (likedCountFromRedisByPostId==null || likedCountFromRedisByPostId==0){

                }else {
                    commodityVOList.get(i).setWant(likedCountFromRedisByPostId);
                }

                //收藏数量
                Integer commodityCollectionCount =getCommodityCollectionCount(commodityVOList.get(i).getId());
                commodityVOList.get(i).setCollectionCount(commodityCollectionCount);
            }
            return commodityVOList;
        }catch (Exception e){
            return commodityVOList;
        }finally {
            return commodityVOList;
        }
    }

    //查询商品收藏的个数
    @Override
    public Integer getCommodityCollectionCount(String commodityId) {
        try {
            Integer count = commodityCollectionMapperImpl.getCommodityCountMapper(commodityId);
            return count;
        }catch (Exception e){
            return 0;
        }
    }
}