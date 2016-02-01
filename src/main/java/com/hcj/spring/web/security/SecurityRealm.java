package com.hcj.spring.web.security;

import com.hcj.spring.web.bean.Admin;
import com.hcj.spring.web.bean.Permission;
import com.hcj.spring.web.bean.Role;
import com.hcj.spring.web.service.AdminService;
import com.hcj.spring.web.service.PermissionService;
import com.hcj.spring.web.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户身份验证，角色验证
 * Created by HCJ on 2016/1/12.
 */
@Component(value = "SecurityRealm")
public class SecurityRealm extends AuthorizingRealm {
    @Resource
    private AdminService adminService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;

    /**
     * 权限验证 Authorization：授权
     * 既为当前登入的subject 授予角色和权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String userName = String.valueOf(principals.getPrimaryPrincipal());

        final Admin admin = adminService.selectByAdminName(userName);
        final List<Role> roles = roleService.selectRoleByAdminId(admin.getId());
        for(Role role :roles){
            System.out.println(role);
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleSign());
            //添加权限
            final  List<Permission> permissions = permissionService.getPermissionByRoleId(role.getId());
            for (Permission permission : permissions){
                System.out.println(permission);
                simpleAuthorizationInfo.addStringPermission(permission.getPermissionSign());
            }
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 登入验证 Authentication：身份验证
     * 既验证当前的 subject
     * @param token
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        //通过一个函数来验证authentication : select * from admin where user_name='' and password='' ,参数类型是map
        //从数据库中得到该用户
        final Admin authentication =adminService.authentication(new Admin(userName, password));
        if(authentication == null)
        {
            throw new AuthenticationException("用户名或密码错误.");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(authentication.getUserName(), authentication.getPassword(), getName());
        return authenticationInfo;
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     * 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
     * @param key
     * @param value
     */
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }
}
