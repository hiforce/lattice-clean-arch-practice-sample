package org.hiforce.sample.buynow.web.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rocky Yu
 * @since 2022/10/8
 */
@Configuration
@SpringBootApplication
public class BuyNowWebStarter {
    public static void main(String[] args) {
        SpringApplication.run(BuyNowWebStarter.class, args);
    }
}
