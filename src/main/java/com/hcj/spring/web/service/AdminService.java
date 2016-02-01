package com.hcj.spring.web.service;

import com.hcj.spring.core.generic.GenericService;
import com.hcj.spring.web.bean.Admin;

import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public interface AdminService extends GenericService<Admin, Long> {
    Admin authentication(Admin admin);
    Admin selectByAdminName(String adminName);
    List<Admin> selectList();
    List<Admin> selectAdminByPage(int start, int pagesize);
}
