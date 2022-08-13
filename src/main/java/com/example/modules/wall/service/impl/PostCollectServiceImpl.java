package com.example.modules.wall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.modules.wall.entity.po.PostCollect;
import com.example.modules.wall.mapper.PostCollectMapper;
import com.example.modules.wall.service.PostCollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCollectServiceImpl extends ServiceImpl<PostCollectMapper, PostCollect> implements PostCollectService {

    @Autowired
    PostCollectMapper postCollectMapper;

    @Override
    public void addCollect(String userId, String postId) {
        PostCollect postCollect = new PostCollect();
        postCollect.setPostId(postId);
        postCollect.setUserId(userId);
        postCollectMapper.insert(postCollect);
    }

    @Override
    public void deleteCollect(String userId, String postId) {
        QueryWrapper<PostCollect> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("post_id", postId);
        postCollectMapper.delete(wrapper);
    }
}
