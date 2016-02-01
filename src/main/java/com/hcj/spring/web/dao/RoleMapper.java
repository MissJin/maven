package com.hcj.spring.web.dao;

import com.hcj.spring.core.generic.GenericDao;
import com.hcj.spring.web.bean.Role;
import com.hcj.spring.web.bean.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper extends GenericDao<Role,Long> {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //根据用户id，获得权限
    List<Role> selectByAdminId(Long adminId);
}