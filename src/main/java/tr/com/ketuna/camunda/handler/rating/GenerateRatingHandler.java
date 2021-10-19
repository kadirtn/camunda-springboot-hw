package tr.com.ketuna.camunda.handler.rating;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenerateRatingHandler implements JavaDelegate {

//    https://camunda.com/best-practices/invoking-services-from-the-process/#_understanding_and_using_strong_java_delegates_strong

    @Override
    public void execute(DelegateExecution delegateExecution) {

        String candidateId = "IN-" + (Math.random() * 100);
        int candidateScore = (int) (Math.random() * 11);

        delegateExecution.setVariable("candidateId", candidateId);
        delegateExecution.setVariable("candidateScore", candidateScore);

        log.info("NOPE Rating Genrator External task is completed for Candidate {} with rating {}", candidateId, candidateScore);

    }
}