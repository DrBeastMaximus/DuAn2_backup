package com.example.backend_final_project;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BackendFinalProjectApplication {
    private static ConfigurableApplicationContext context;
    private static ApplicationArguments argsz;
    public static void main(String[] args) {
        context=SpringApplication.run(BackendFinalProjectApplication.class, args);
        argsz = context.getBean(ApplicationArguments.class);
    }
    public static void restart() {

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(BackendFinalProjectApplication.class, argsz.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }
}