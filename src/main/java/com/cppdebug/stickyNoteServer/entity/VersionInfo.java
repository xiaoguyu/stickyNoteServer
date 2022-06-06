package com.cppdebug.stickyNoteServer.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wjw
 * @description: 版本信息
 * @title: VersionInfo
 * @date 2022/6/6 15:32
 */
@Data
@TableName("version_info")
public class VersionInfo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 更新内容
     */
    private String versionDesc;

    private String downloadUrl;

    private String version;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
