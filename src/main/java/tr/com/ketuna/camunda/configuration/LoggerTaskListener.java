package tr.com.ketuna.camunda.configuration;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;


/**
 * This is an easy listener implementation
 * illustrating how a Task Listener can be used
 * from within a BPMN 2.0 User Task.
 */
@Slf4j
@Component("loggerTaskListener")
public class LoggerTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        log.info("\n\n  ... LoggerDelegate invoked by "
                + "activityName='" + task.getExecution().getCurrentActivityName() + "'"
                + ", activityId=" + task.getExecution().getCurrentActivityId()
                + ", processDefinitionId=" + task.getProcessDefinitionId()
                + ", processInstanceId=" + task.getProcessInstanceId()
                + ", businessKey=" + task.getExecution().getProcessBusinessKey()
                + ", executionId=" + task.getId()
                + ", variables=" + task.getVariables()
                + " \n\n");
    }

}
