package tr.com.ketuna.camunda.handler.rating;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;

import java.util.logging.Level;
import java.util.logging.Logger;

//@Component
//@ExternalTaskSubscription("candidateRejected")
public class CandidateRejectedHandler implements ExternalTaskHandler {

    Logger logger = Logger.getLogger("CandidateRejectedHandler");
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        int candidateScore = externalTask.getVariable("candidateScore");

        //Logic to process based on rating goes here

        externalTaskService.complete(externalTask);

        logger.log(Level.INFO, "Candidate rejected! Processing candidate Score received {0}", new Object[]{ candidateScore});

    }

}
