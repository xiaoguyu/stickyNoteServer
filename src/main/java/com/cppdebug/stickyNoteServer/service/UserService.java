package com.cppdebug.stickyNoteServer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cppdebug.stickyNoteServer.entity.UserVisitLog;
import com.cppdebug.stickyNoteServer.entity.VersionInfo;
import com.cppdebug.stickyNoteServer.mapper.UserVisitLogMapper;
import com.cppdebug.stickyNoteServer.mapper.VersionInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author wjw
 * @description: 用户service
 * @title: UserService
 * @date 2022/6/6 15:17
 */
@Service
public class UserService {

    @Autowired
    private UserVisitLogMapper userVisitLogMapper;
    @Autowired
    private VersionInfoMapper versionInfoMapper;

    /**
     * @param request
     * @param guid
     * @param version
     * @return
     * @apiNote 保存访问日志
     * @author wjw
     * @date 2022/6/6 15:35
     */
    public void saveVisitLog(HttpServletRequest request, String guid, String version) {
        // 获取ip
        String ip = null;
        if (request.getHeader("x-forwarded-for") == null) {
            ip = request.getRemoteAddr();
        } else {
            ip = request.getHeader("x-forwarded-for");
        }
        // 保存日志
        UserVisitLog visitLog = new UserVisitLog();
        visitLog.setGuid(guid);
        visitLog.setVersion(version);
        visitLog.setIp(ip);
        visitLog.setCreateTime(LocalDateTime.now());
        userVisitLogMapper.insert(visitLog);
    }

    /**
     * @return
     * @apiNote 获取最新的版本信息
     * @author wjw
     * @date 2022/6/6 15:36
     */
    public VersionInfo getVersionInfo() {
        // 根据时间倒序获取最新版本信息
        QueryWrapper<VersionInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        wrapper.last("limit 1");
        List<VersionInfo> versionInfoList = versionInfoMapper.selectList(wrapper);
        if (null != versionInfoList && !versionInfoList.isEmpty()) {
            return versionInfoList.get(0);
        }
        return null;
    }
}
