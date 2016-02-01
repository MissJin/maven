package com.hcj.spring.web.service.impl;


import com.hcj.spring.core.generic.GenericDao;
import com.hcj.spring.core.generic.GenericServiceImpl;
import com.hcj.spring.web.bean.Permission;
import com.hcj.spring.web.dao.PermissionMapper;
import com.hcj.spring.web.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by HCJ on 2016/1/11.
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Long> implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public GenericDao<Permission, Long> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> getPermissionByRoleId(Long roleId) {
        return permissionMapper.selectPermissionByRoleId(roleId);
    }
}
