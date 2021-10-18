package tr.com.ketuna.camunda.handler.rating;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class GenerateRatingHandler implements JavaDelegate {

    Logger logger = Logger.getLogger("GenerateRatingHandler");


    @Override
    public void execute(DelegateExecution delegateExecution) {

        String candidateId = "IN-" + (Math.random() * 100);
        int candidateScore = (int) (Math.random() * 11);

        delegateExecution.setVariable("candidateId", candidateId);
        delegateExecution.setVariable("candidateScore", candidateScore);

        logger.log(Level.INFO, "NOPE Rating Genrator External task is completed for Candidate {0} with rating {1}", new Object[]{candidateId, candidateScore});

    }
}