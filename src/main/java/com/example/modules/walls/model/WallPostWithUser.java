package com.example.modules.walls.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

/**
 * @author mushan
 * @date 8/4/2022
 * @apiNote
 */
public class WallPostWithUser {
    private static final long serialVersionUID = 1L;

    /**
     * 帖子编号
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @JSONField(name = "id")
    private String id;

    /**
     * 用户编号
     */
    @JSONField(name = "user_id")
    private String userId;

    private String headaddress;

    private String nickname;

    /**
     * 标题
     */
    @JSONField(name = "title")
    private String title;

    /**
     * 内容
     */
    @JSONField(name = "content")
    private String content;

    /**
     * 喜欢数量
     */
    @JSONField(name = "like_count")
    private Integer likeCount;

    /**
     * 评论数量
     */
    @JSONField(name = "comments_count")
    private Integer commentsCount;

    /**
     * 乐观锁
     */
    @Version
    @JSONField(name = "version")
    private Integer version;

    /**
     * 创建时间
     */
    @JSONField(name = "gmt_create")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @JSONField(name = "gmt_modified")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
