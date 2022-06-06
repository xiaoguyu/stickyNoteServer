package com.cppdebug.stickyNoteServer.controller;

import com.cppdebug.stickyNoteServer.common.response.CommonResult;
import com.cppdebug.stickyNoteServer.entity.VersionInfo;
import com.cppdebug.stickyNoteServer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wjw
 * @description: 用户接口
 * @title: UserController
 * @date 2022/6/6 14:45
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/autoUpdate")
    public CommonResult<VersionInfo> autoUpdate(HttpServletRequest request, String guid, String currentVersion) {
        // 保存访问日志
        userService.saveVisitLog(request, guid, currentVersion);
        // 获取最新版本信息并返回
        VersionInfo versionInfo = userService.getVersionInfo();
        if (null != versionInfo) {
            versionInfo.setId(null);
            return CommonResult.ok(versionInfo);
        }
        return CommonResult.fail("暂无版本信息！");
    }

}
