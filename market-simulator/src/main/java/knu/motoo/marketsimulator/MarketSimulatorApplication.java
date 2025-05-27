package knu.motoo.marketsimulator;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        exclude = {
                org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
                org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class
        }
)
public class MarketSimulatorApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(MarketSimulatorApplication.class, args);
    }
}
