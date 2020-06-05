package com.example.sampleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
public class SampleController {
  public static void main(String[] args) {
    try(ConfigurableApplicationContext ctx = SpringApplication.run(SampleController.class, args)) {
      ctx.getBean(SampleController.class).sendMail();
    }
  }
  @Autowired
  private MailSender sender;

  public void sendMail() {
    SimpleMailMessage msg = new SimpleMailMessage();

    msg.setFrom("test@mail.com");
    msg.setTo("sumkakkyo@gmail.com");
    msg.setSubject("test mail");
    msg.setText("Spring Boot test mail");

    this.sender.send(msg);
  }
}