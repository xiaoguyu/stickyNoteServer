package com.cppdebug.stickyNoteServer.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wjw
 * @description: 用户访问日志
 * @title: UserVisitLog
 * @date 2022/6/6 15:25
 */
@Data
@TableName("user_visit_log")
public class UserVisitLog implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String guid;

    private String ip;

    private String version;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
