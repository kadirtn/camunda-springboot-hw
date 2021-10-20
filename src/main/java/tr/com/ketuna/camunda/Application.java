package tr.com.ketuna.camunda;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@EnableScheduling
@EnableProcessApplication
@SpringBootApplication
public class Application {

    @Autowired
    private RuntimeService runtimeService;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }


    @Scheduled(initialDelay = 5, fixedRate = 1, timeUnit = TimeUnit.SECONDS)
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("externalTaskClientProcess");
    }
}