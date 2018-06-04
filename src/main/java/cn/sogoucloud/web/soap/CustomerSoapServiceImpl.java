package cn.sogoucloud.web.soap;

import cn.sogoucloud.framework.annotation.Autowired;
import cn.sogoucloud.framework.annotation.Service;
import cn.sogoucloud.plugin.soap.Soap;
import cn.sogoucloud.web.model.Customer;
import cn.sogoucloud.web.service.CustomerService;

/**
 * 客户 SOAP 服务接口实现
 *
 * @author 
 * @since 1.0.0
 */
@Soap
@Service
public class CustomerSoapServiceImpl implements CustomerSoapService {

    @Autowired
    private CustomerService customerService;

    public Customer getCustomer(long customerId) {
        return customerService.getCustomer(customerId);
    }
}
