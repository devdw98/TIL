package dw.study.lookie.ilbi.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties
public class MailConfig {
   @Bean
    public JavaMailSenderImpl mailSender(){
       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

       javaMailSender.setProtocol("smtp");
       javaMailSender.setHost("127.0.0.1");
       javaMailSender.setPort(25);
       return javaMailSender;
   }
}
