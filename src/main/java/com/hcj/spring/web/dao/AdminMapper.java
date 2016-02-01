package com.hcj.spring.web.dao;

import com.hcj.spring.core.feature.orm.mybatis.Page;
import com.hcj.spring.core.generic.GenericDao;
import com.hcj.spring.web.bean.Admin;
import com.hcj.spring.web.bean.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends GenericDao<Admin, Long> {

    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 登录验证
     * @param admin
     * @return
     */
    Admin authentication(@Param("record") Admin admin);
    /**
     * 分页查询
     * @param page
     * @param example
     * @return
     */
    List<Admin> selectByExampleAndPage(Page<Admin> page, AdminExample example);


}