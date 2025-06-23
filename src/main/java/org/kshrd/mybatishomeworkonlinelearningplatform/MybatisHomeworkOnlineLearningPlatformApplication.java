package org.kshrd.mybatishomeworkonlinelearningplatform;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Online Learning Platform", version = "1.0", description = "Education is the spark that ignites curiosity and fuels lifelong learning, transcending the mere accumulation of knowledge."))
public class MybatisHomeworkOnlineLearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisHomeworkOnlineLearningPlatformApplication.class, args);
    }

}
