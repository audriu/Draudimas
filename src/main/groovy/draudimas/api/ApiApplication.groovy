package draudimas.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["draudimas.api"])
class ApiApplication {
    static void main(String[] args) {
        SpringApplication.run(ApiApplication, args)
    }
}
