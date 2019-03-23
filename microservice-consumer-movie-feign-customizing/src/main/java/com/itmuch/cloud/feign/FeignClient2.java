package com.itmuch.cloud.feign;

import com.itmuch.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.itmuch.config.Configuration2;

/**
 * 不写名字，指定一个访问服务的url路径
 * 配置了url 属性，@FeignClient()的name就会失效，
 *
 * http://localhost:8761/
 * 也可访问里面默认提供的服务，如：/health,等等。
 */
//@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class)
//public interface FeignClient2 {
//  @RequestMapping(value = "/eureka/apps/{serviceName}")
//  public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
//}

/**
 * 一个消费端访问到另外一个消费端   movie ---> user
 * 注：即使movie 和 user 不注册到Eureka 上，movie也可访问到user服务，
 */
@FeignClient(name = "xxxx", url = "http://localhost:7900/", configuration = Configuration2.class)
public interface FeignClient2 {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User postUser(@RequestBody User user);

}

