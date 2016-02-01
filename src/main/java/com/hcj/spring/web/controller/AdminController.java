package com.hcj.spring.web.controller;

import com.hcj.spring.core.feature.orm.mybatis.Page;
import com.hcj.spring.core.util.JSONResult;
import com.hcj.spring.web.bean.Admin;
import com.hcj.spring.web.bean.AdminExample;
import com.hcj.spring.web.service.AdminService;
import com.hcj.spring.web.service.impl.AdminServiceImpl;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.*;

/**
 * Created by HCJ on 2015/12/10.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private AdminServiceImpl adminServiceImpl;

    /**
     * 表单提交数据，
     *
     * @param admin
     * @param result
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Admin admin, BindingResult result, Model model, HttpServletRequest request) {
        /*为什么他直接能接受一个对象呢*/
        System.out.println("用户名：" + admin.getUserName() + "密码=" + admin.getPassword() + "路径=" + request.getContextPath() + "/");
        Subject subject = SecurityUtils.getSubject();
//        SecurityUtils.getSubject().login(new UsernamePasswordToken(admin.getUserName(),admin.getPassword()));
        // 已登陆则 跳到首页
        if (subject.isAuthenticated()) {
            System.out.println("subject.hasRole(\"admin\")");
            return "redirect:/index";
        }

        if (result.hasErrors()) {
            model.addAttribute("error", "参数错误");
        }
        subject.login(new UsernamePasswordToken(admin.getUserName(), admin.getPassword()));
        final Admin authAdminInfo = adminService.selectByAdminName(admin.getUserName());
        request.getSession().setAttribute("adminInfo", authAdminInfo);
        if (authAdminInfo == null) {
            System.out.println("return \"login\";");
            return "login";
        }
        System.out.println("return \"main\";");
        return "index";
    }

    /**
     * 用户登出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("adminInfo");
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }


    @RequestMapping("/getIndexPage")
    public String getIndexPage() {

        return "index";
    }

    /**
     * getPage类型
     *
     * @return
     */

    @RequestMapping(value = "/test", method = RequestMethod.GET)

    /* 有这个标识的@ResponseBody 返回的数据就是 string 的值*/
    public String index() {
        System.out.println("测试adminService");
        List<Admin> adminList = adminService.selectList();
        for (Admin admin : adminList) {
            System.out.println(admin.toString());
        }
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("admin")) {
            System.err.println(subject.toString());
        }

        return "json";
    }

    /**
     * 正确的接口调用方式
     * ServiceInterface service = new SerciceInterfaceImplments();
     * 有点像函数的
     *
     * @return
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String index1() {
        System.out.println("测试adminServiceImpl");
        List<Admin> adminList = adminServiceImpl.selectList();
        for (Admin admin : adminList) {
            System.out.println(admin.toString());
        }
        // request.getSession().setAttribute("adminList",adminList);
        return "json";
    }

    /**
     * 测试json
     * 和页面的交互
     */
    @RequestMapping(value = "/testJson", method = RequestMethod.GET)
    public String testJson() {
        List<Admin> adminList = adminServiceImpl.selectList();
        System.out.println(adminList.toString());
        Map map = new HashMap<List<Objects>, Objects>();
        map.put("adminList", adminList);
        List<Admin> adminList1 = (List<Admin>) map.get("adminList");
        for (Admin admin : adminList1) {
            System.out.println(admin.toString());
        }

        return "json";
    }

    /**
     * 测试Model，
     * 结果：成功
     * 和页面的交互
     */
    @RequestMapping(value = "/testModel", method = RequestMethod.GET)
    public String testModel(Model model) {
        List<Admin> adminList = adminServiceImpl.selectList();
        //spring的Model对象传递参数
        model.addAttribute("adminList", adminList);
        System.out.println(adminList.toString());
        return "json";
    }

    /**
     * 测试Map，
     * 结果：成功
     * 和页面的交互
     */
    @RequestMapping(value = "/testMap", method = RequestMethod.GET)
    public String testMap(Map<String, List<Admin>> map) {
        List<Admin> adminList = adminServiceImpl.selectList();
        //  map传递参数
        map.put("adminList", adminList);
        System.err.println(adminList.toString());
        List<Admin> adminList1 = map.get("adminList");
        for (Admin admin : adminList1) {
            System.out.println(admin.toString());
        }
        return "json";
    }

    /**
     * 测试Map，的ajax请求
     * 结果：成功
     * 和页面的交互
     */
    @RequestMapping(value = "/testMapAjax", method = RequestMethod.GET)
    public JSONResult<Map> testMapAjax(Map<String, List<Admin>> map) throws IOException {
        List<Admin> adminList = adminServiceImpl.selectList();
        //  map传递参数
        map.put("adminList", adminList);
        System.err.println(adminList.toString());
        List<Admin> adminList1 = map.get("adminList");
        for (Admin admin : adminList1) {
            System.out.println(admin.toString());
        }
        JSONResult<Map> jo = new JSONResult<>();
        jo.setData(map);
        jo.setMessage("测试信息");
        jo.setSuccess(true);
        jo.setStatusCode(110);
        System.out.println("testMapAjax============" + jo.getData().toString());
        return jo;
    }


    /**
     * ajax get请求测试 或 form表单的提交
     * data:{string:key,string:key}
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/testLogin", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView testLogin(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        System.out.println("testLogin==" + "get帐号：" + userName);
        System.out.println("testLogin==" + "get密码：" + password);
        JSONObject jo = new JSONObject();
        jo.put("userName", userName);
        jo.put("password", password);
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(jo.toString());
        return null;
    }


    /**
     * getPage类型的测试
     * data 要为json 格式
     *
     * @param admin
     * @return
     */
    @RequestMapping(value = "/testLogin1", method = RequestMethod.POST)
//    @ResponseBody
    public ModelAndView testLoginPage(@RequestBody Admin admin, HttpServletResponse response) throws IOException {
        System.out.println("testLogin1==" + "post帐号：" + admin.getUserName());
        System.out.println("testLogin1==" + "post密码：" + admin.getPassword());
        JSONObject jo = new JSONObject();
        jo.put("userName", admin.getUserName());
        jo.put("password", admin.getPassword());
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(jo.toString());
        return null;
    }


    /**
     * 测试成功，登录成后跳转到主页面
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/testLogin2", method = RequestMethod.GET)
    public ModelAndView testLogin2(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        System.out.println("testLogin2==" + "get帐号：" + userName);
        System.out.println("testLogin2==" + "get密码：" + password);
        return new ModelAndView("redirect:/index");
    }
//    @RequestMapping
//    public String getIndex(HttpServletResponse response){
////        ActionContext context = ActionContext.getContext();
////        HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
//        response.setContentType("text/html; charset=utf-8");
//        Writer out= response.getWriter();
//        out.toString();
//    }

    /**
     * 基于角色 标识的权限控制案例
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    @RequiresRoles(value = "admin1")
    public String admin() {
        return "拥有admin角色,能访问";
    }

    /**
     * 基于权限标识的权限控制案例
     */
    @RequestMapping(value = "/create")
    @ResponseBody
    @RequiresPermissions(value = "user:create1")
    public String create() {
        return "拥有user:create权限,能访问";
    }

    @RequestMapping(value = "/showAllAdmin")
//    @ResponseBody
    public String showAllAdmin(Model model) {
        List<Admin> adminList = adminServiceImpl.selectList();
        //spring的Model对象传递参数
        model.addAttribute("adminList", adminList);
        System.out.println(adminList.toString());

//        return adminList.toString();
        return "json";
    }

    /**
     * 表格测试：用表格显示信息
     *
     * @return
     */
    @RequestMapping(value = "getAdminListPage")
    public String getAdminListPage(Model model) {
        List<Admin> adminList = adminServiceImpl.selectList();
        //spring的Model对象传递参数
        model.addAttribute("adminList", adminList);
        System.out.println(adminList.toString());
        return "adminListPage";
    }

    @RequestMapping(value = "getAdminList")
    @ResponseBody
    public String getAdminList() throws IOException {

        List<Admin> adminList = adminServiceImpl.selectList();
        int rowCount = adminList.size();
        int pageIndex = 1;

        JSONObject jo = new JSONObject();
        jo.put("pageCount", rowCount);
        jo.put("CurrentPage", pageIndex);
        jo.put("adminList", adminList.toString());
        System.err.println(jo.toString());
        return jo.toString();
    }

    @RequestMapping(value = "getAdminListByPage")
    @ResponseBody
    public String getAdminListByPage(@RequestParam("pageNO") String pageNo,@RequestParam("pageSize") String pageSize) throws IOException {
        System.err.println("pageNo="+pageNo+"  pageSize="+pageSize);
        List<Admin> adminList = adminServiceImpl.selectAdminByPage(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
        JSONObject jo = new JSONObject();
        jo.put("isSuccuss",1);
        jo.put("adminListTemp", adminList.toString());
        System.err.println(jo.toString());
        return jo.toString();
    }


}

