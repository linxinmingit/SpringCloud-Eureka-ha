package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;

@RestController
public class MovieController {

  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable("id") Long id) {
    return this.userFeignClient.findById(id);
  }

  @GetMapping("/test")
  public User testPost(User user) {
    user.setName("linxinmin");
    user.setUsername("ADMIN");
    user.setId(1L);
    return this.userFeignClient.postUser(user);
  }

  @GetMapping("/test-get")
  public User testGet(User user) {
    return this.userFeignClient.getUser(user);
  }

//  @PutMapping("put/{id}")
//  public Integer putUser(@RequestParam("id") Integer id)
//  {
//    System.out.println("=========================");
//    return  this.userFeignClient.putUser(id);
//  }
}
