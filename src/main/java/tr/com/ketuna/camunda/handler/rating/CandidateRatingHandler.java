package tr.com.ketuna.camunda.handler.rating;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ExternalTaskSubscription("candidateRating")
public class CandidateRatingHandler implements ExternalTaskHandler {

    Logger logger = Logger.getLogger("CandidateRatingHandler");
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        int candidateScore = externalTask.getVariable("candidateScore");

        //Logic to process based on rating goes here

        externalTaskService.complete(externalTask);

        logger.log(Level.INFO, "Processing candidate Score received {0}", new Object[]{ candidateScore});

    }

}
