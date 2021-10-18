package tr.com.ketuna.camunda.handler.rating;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CandidateRatingHandler implements JavaDelegate {

    Logger logger = Logger.getLogger("CandidateRatingHandler");

    @Override
    public void execute(DelegateExecution delegateExecution) {

        int candidateScore = (int) delegateExecution.getVariable("candidateScore");

        logger.log(Level.INFO, "Processing candidate Score received {0}", new Object[]{ candidateScore});
    }
}
