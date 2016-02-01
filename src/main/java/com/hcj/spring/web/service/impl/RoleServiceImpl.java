package com.hcj.spring.web.service.impl;

import com.hcj.spring.core.generic.GenericDao;
import com.hcj.spring.core.generic.GenericServiceImpl;
import com.hcj.spring.web.bean.Role;
import com.hcj.spring.web.dao.RoleMapper;
import com.hcj.spring.web.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HCJ on 2016/1/11.
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role,Long> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public GenericDao<Role, Long> getDao() {
        // RoleMapper extends GenericDao,既 子承父业，java的返射
        return roleMapper;
    }

    @Override
    public List<Role> selectRoleByAdminId(long adminId) {
        return roleMapper.selectByAdminId(adminId);
    }

}
