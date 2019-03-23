package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * How to Use Ribbon Without Eureka
 *
 * Eureka是一个方便的方式去抽象远程服务发现，所以你不需要在客户端硬编码他们的URLS。但是如果你不想用eureka，Ribbon和Feign仍然可用。
 * 假设你已经在“stores”定义了@RibbOnClient,而且没有使用Eureka（没有在classpath中）。Ribbon client默认要配置server list,
 * stores:
     ribbon:
       listOfServers: example.com.google.com
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMovieRibbonApplication {

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
  }
}
