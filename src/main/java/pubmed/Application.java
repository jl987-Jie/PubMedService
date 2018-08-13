package pubmed;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAsync
@EnableDynamoDBRepositories("reciter.database.dynamodb")
@ComponentScan("reciter")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
