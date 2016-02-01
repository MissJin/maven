package com.hcj.spring.web.service;

import com.hcj.spring.core.generic.GenericService;
import com.hcj.spring.web.bean.Permission;

import java.util.List;

/**
 * Created by HCJ on 2016/1/11.
 */
public interface PermissionService extends GenericService<Permission,Long>{
    /**
     * 通过角色Id,获取 权限列表
     * @return
     */
    List<Permission> getPermissionByRoleId(Long roleId);
}
