package knu.motoo.tradingapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TradingApiApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(TradingApiApplication.class, args);
    }
}
