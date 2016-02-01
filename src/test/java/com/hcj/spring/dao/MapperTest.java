package com.hcj.spring.dao;

import com.hcj.spring.core.feature.orm.mybatis.Page;
import com.hcj.spring.core.feature.test.TestTransactionSupport;
import com.hcj.spring.web.bean.*;
import com.hcj.spring.web.dao.AdminMapper;
import com.hcj.spring.web.dao.PermissionMapper;
import com.hcj.spring.web.dao.RoleMapper;
import com.hcj.spring.web.service.AdminService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HCJ on 2015/12/4.
 */
public class MapperTest extends TestTransactionSupport{
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private AdminService adminService;

    /**
     * 测试分页
     */
    @Test
    public void test_selectByExamplePage(){
        //记录开始测试的时间
        start();
        Page<Admin> page = new Page<>(1,3);

        AdminExample example = new AdminExample();
        List<Integer> list = new ArrayList<Integer>();
        list.add(200);example.createCriteria().andStatusNotIn(list);

        int count = adminMapper.countByExample(example);
        page.setTotalCount(count);
        System.err.println("count="+count);
        System.err.println(example.createCriteria().andIdGreaterThan(1).toString());
        final List<Admin> admins = adminMapper.selectByExampleAndPage(page, example);
        for (Admin admin : admins){
            System.err.println(admin);
        }
        end();
    }

    /**
     * 测试用户角色
     */
    @Test
    public void test_selectByAdminId(){
        //记录开始测试的时间
        start();
        RoleExample example = new RoleExample();
        System.err.println(example.createCriteria().andIdGreaterThan(1L).toString());
        final List<Role> roles = roleMapper.selectByAdminId(1L);
        for (Role role : roles){
            System.err.println(role);
        }
        end();
    }

    /**
     * 测试用户权限
     */
    @Test
    public void test_selectByRoleId(){
        //记录开始测试的时间
        start();
        PermissionExample example = new PermissionExample();
        System.err.println(example.createCriteria().andIdGreaterThan(1L).toString());
        final List<Permission> permissions = permissionMapper.selectPermissionByRoleId(1l);
        for (Permission permission : permissions){
            System.err.println(permission);
        }
        end();
    }
}
