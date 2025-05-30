package knu.motoo.tradingapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "knu.motoo")
@EntityScan("knu.motoo.commondb")
@EnableJpaRepositories("knu.motoo.commondb")
public class TradingApiApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(TradingApiApplication.class, args);
    }
}
