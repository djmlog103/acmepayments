package com.dilupa.acmepayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories
public class AcmepaymentApplication {

  public static void main(String[] args) {
    SpringApplication.run(AcmepaymentApplication.class, args);
  }

}
