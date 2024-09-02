package com.sitemate.challenge.bahattin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class IssueManagerApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(IssueManagerApplication.class).run(args);
  }
}
