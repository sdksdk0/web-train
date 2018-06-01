package cn.sogoucloud.web.controller;

import java.util.List;
import java.util.Map;

import cn.sogoucloud.framework.annotation.Autowired;
import cn.sogoucloud.framework.annotation.Controller;
import cn.sogoucloud.framework.annotation.RequestMapping;
import cn.sogoucloud.framework.bean.Data;
import cn.sogoucloud.framework.bean.Param;
import cn.sogoucloud.framework.bean.View;
import cn.sogoucloud.web.model.Customer;
import cn.sogoucloud.web.service.CustomerService;

/**
 * 处理客户管理相关请求
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 进入 客户列表 界面
     */
    @RequestMapping("get:/customer")
    public View index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    /**
     * 显示客户基本信息
     */
    @RequestMapping("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    /**
     * 进入 创建客户 界面
     */
    @RequestMapping("get:/customer_create")
    public View create(Param param) {
        return new View("customer_create.jsp");
    }

    /**
     * 处理 创建客户 请求
     */
    @RequestMapping("post:/customer_create")
    public Data createSubmit(Param param) {
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    /**
     * 进入 编辑客户 界面
     */
    @RequestMapping("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    /**
     * 处理 编辑客户 请求
     */
    @RequestMapping("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    /**
     * 处理 删除客户 请求
     */
    @RequestMapping("delete:/customer_edit")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}