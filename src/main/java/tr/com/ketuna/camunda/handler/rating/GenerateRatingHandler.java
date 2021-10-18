package tr.com.ketuna.camunda.handler.rating;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenerateRatingHandler implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {

        String candidateId = "IN-" + (Math.random() * 100);
        int candidateScore = (int) (Math.random() * 11);

        delegateExecution.setVariable("candidateId", candidateId);
        delegateExecution.setVariable("candidateScore", candidateScore);

        log.info("NOPE Rating Genrator External task is completed for Candidate {} with rating {}", candidateId, candidateScore);

    }
}