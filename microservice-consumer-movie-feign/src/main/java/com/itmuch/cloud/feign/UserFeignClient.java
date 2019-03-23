package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.itmuch.cloud.entity.User;

/**
 * @FeignClient(name="SPRING-PRODUCER-SERVER/spring")：用于通知Feign组件对该接口进行代理(不需要编写接口实现)，
 *                                                     name属性指定我们要调用哪个服务。使用者可直接通过@Autowired注入。
   @RequestMapping表示在调用该方法时需要向/group/{groupId}发送GET请求。
   @PathVariable与SpringMVC中对应注解含义相同。
 */
@FeignClient("microservice-provider-user")
public interface UserFeignClient {
  @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public User postUser(@RequestBody User user);    //字符串形式的


  // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
  // 如勘误，请@lilizhou2008  eacdy0000@126.com
  @RequestMapping(value = "/get-user", method = RequestMethod.GET)
  public User getUser(User user);


//  @RequestMapping(value = "/user",method = RequestMethod.PUT)
//  public Integer putUser(@RequestParam("id") Integer id);
}
