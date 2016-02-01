package com.hcj.spring.web.service.impl;

import com.hcj.spring.core.feature.orm.mybatis.Page;
import com.hcj.spring.core.generic.GenericDao;
import com.hcj.spring.core.generic.GenericServiceImpl;
import com.hcj.spring.web.bean.Admin;
import com.hcj.spring.web.bean.AdminExample;
import com.hcj.spring.web.dao.AdminMapper;
import com.hcj.spring.web.service.AdminService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * admin 的Service实现类
 * Created by Administrator on 2015/12/8.
 */
@Service
public class AdminServiceImpl  extends GenericServiceImpl<Admin, Long> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    /*******************base method**************************************************************/

    /*    增删查改*/
    @Override
    public  int insert(Admin model){
        return adminMapper.insertSelective(model);
    }

    /**
     * 为什么没有重载  @Override
     * @param id
     * @return
     */
    public  int delete(Integer id){
        return adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 为什么没有重载  @Override
     * @param id
     * @return
     */
    public  Admin selectById(Integer id){
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public  int update(Admin model){
        return adminMapper.updateByPrimaryKey(model);
    }

    @Override
    public GenericDao<Admin, Long> getDao() {
        return adminMapper;
    }

    /************************************extend method****************************************/

    /**
     * 权限验证(登录用的 )
     * @param admin
     * @return
     */
    @Override
    public Admin authentication(Admin admin) {
        return adminMapper.authentication(admin);
    }

    /**
     * 根据用户名查找用户
     * @param adminName
     * @return
     */
    @Override
    public Admin selectByAdminName(String adminName) {
        AdminExample example = new AdminExample();
        example.createCriteria().andUserNameEqualTo(adminName);
        final List<Admin> list = adminMapper.selectByExample(example);
        return list.get(0);
    }
    /**
     *获取所有人员
     */
    public List<Admin> selectList(){
        AdminExample example = new AdminExample();
        final List<Admin> list = adminMapper.selectByExample(example);
        return list;
    }

    /**
     * 分页
     * @param start
     * @param pagesize
     * @return
     * */
    public List<Admin> selectAdminByPage(int start,int pagesize){
        Page<Admin> page = new Page<>(start,pagesize);
        AdminExample example = new AdminExample();
//        剔除离职的人员
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(200);
//        example.createCriteria().andStatusNotIn(list);
        int count = adminMapper.countByExample(example);
        page.setTotalCount(count);

        List<Admin> admins = adminMapper.selectByExampleAndPage(page, example);
        return admins;
    }



}
