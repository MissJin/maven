package com.hcj.spring.web.service;

import com.hcj.spring.core.generic.GenericService;

import com.hcj.spring.web.bean.Role;

import java.util.List;

/**
 * Created by HCJ on 2016/1/11.
 */
public interface RoleService extends GenericService<Role, Long> {
    /**
     * 通过adminId,获取 角色列表
     * @param adminID
     * @return
     */
    List<Role> selectRoleByAdminId(long adminID);
}
