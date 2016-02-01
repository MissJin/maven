package com.hcj.spring.web.dao;

import com.hcj.spring.core.generic.GenericDao;
import com.hcj.spring.web.bean.Permission;
import com.hcj.spring.web.bean.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper extends GenericDao<Permission,Long> {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 通过角色Id,获取 权限列表
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionByRoleId(Long roleId);
}