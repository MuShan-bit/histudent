package com.example.modules.notice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.modules.notice.entity.po.Notice;
import com.example.modules.notice.mapper.NoticeMapper;
import com.example.modules.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    NoticeMapper noticeMapperImpl;

    @Override
    public List<Notice> getAll() {
        try {
            LambdaQueryWrapper<Notice> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(Notice::getName,"Hi!同学");
            List<Notice> notices = noticeMapperImpl.selectList(queryWrapper);
            return notices;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void insertNotice() {
        Notice notice=new Notice();
        notice.setContent("13486");
        notice.setImg("http://121.41.227.139:9000/test/test_1663936090709_2022-09-23_497.jpg");
        notice.setTitle("敲代码");
        noticeMapperImpl.insert(notice);
    }
}
