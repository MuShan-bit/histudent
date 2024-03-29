package com.example.modules.market.controller;

import com.example.modules.market.entity.dto.WritCommentDTO;
import com.example.modules.market.entity.vo.CommentVo;
import com.example.modules.market.service.CommodityCommentService;
import com.example.modules.user.pojo.po.User;
import com.example.modules.user.service.UserService;
import com.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market/comment")
public class CommodityCommentController {

    @Autowired
    CommodityCommentService commodityCommentServiceImpl;


    //查看商品所有评论
    @GetMapping("/getAllComment/{commodityId}")
    @CrossOrigin
    public R<List<CommentVo>> getAllCom(@PathVariable("commodityId") String commodityId){
        try {
            List<CommentVo> allCommBycIdSer = commodityCommentServiceImpl.getAllCommBycIdSer(commodityId);
            return R.success(allCommBycIdSer);
        }catch (Exception r){
            return R.error();
        }
    }

    //写评论
    @PostMapping("/addComment/{commodityId}")
    @CrossOrigin
    public R<String> addCommentCont(@PathVariable("commodityId") String commodityId,@RequestBody WritCommentDTO writCommentDTO){
        try {
            writCommentDTO.setCommodityId(commodityId);
            commodityCommentServiceImpl.WriteCommentServiec(writCommentDTO);
            return R.success("写评论成功");
        }catch (Exception e){
            return R.error();
        }
    }

    //删除评论// 1成功 0没有权限 2报错
    @DeleteMapping("/deleteComment/{commentId}")
    @CrossOrigin
    public R<String> deleteCommentCont(@PathVariable("commentId") String commentId){
        try {
            Integer integer = commodityCommentServiceImpl.deleteComment(commentId);
            if (integer==1){
                return R.success("删除成功");
            }else if (integer==0){
                return R.success("没有权限");
            }else {
                return R.error();
            }
        }catch (Exception e){
            return R.error();
        }
    }

}
