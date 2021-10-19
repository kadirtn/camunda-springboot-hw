package tr.com.ketuna.camunda;

import org.camunda.bpm.consulting.process_test_coverage.ProcessTestCoverage;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.assertions.bpmn.ProcessInstanceAssert;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import tr.com.ketuna.camunda.handler.rating.CandidateRatingHandler;
import tr.com.ketuna.camunda.handler.rating.CandidateRejectedHandler;
import tr.com.ketuna.camunda.handler.rating.GenerateRatingHandler;

import java.util.Map;

import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;

@ExtendWith(MockitoExtension.class)
public class RatingProcessTest {

    @Rule
    public ProcessEngineRule processEngineRule = new ProcessEngineRule();
//
//    @Mock // Mockito mock instantiated by PowerMockRunner
//    private TweetPublicationService tweetPublicationService;

    @Before
    public void setup() {
        GenerateRatingHandler generateRatingHandler = new GenerateRatingHandler();
//        tweetPublicationDelegate.setTweetService(tweetPublicationService);

        Mocks.register("generateRatingHandler", generateRatingHandler);
        Mocks.register("candidateRatingHandler", new CandidateRatingHandler());
        Mocks.register("candidateRejectedHandler", new CandidateRejectedHandler());
    }

    @Test
    @Deployment(resources = "rating.bpmn")
    public void testTweetApproved() {
        // given
        ProcessInstance processInstance = startProcess(
                "externalTaskClientProcess", Map.of()
//                , withVariables(TwitterDemoProcessConstants.VAR_NAME_TWEET, TWEET)
        );
        assertThat(processInstance).isEnded();

        assertThat(processInstance)
                .hasPassed("end_event_id")
//                .hasNotPassed("end_event_tweet_rejected")
//                .hasVariables(TwitterDemoProcessConstants.VAR_NAME_TWEET);
                .isEnded();

//        verify(tweetPublicationService).tweet(TWEET);
//        verifyNoMoreInteractions(tweetPublicationService);
    }

    @After
    public void teardown() {
        Mocks.reset();
    }
    @After
    public void calculateProcessTestCoverage() {
        ProcessTestCoverage.calculate(processEngine());
    }

    ProcessInstance startProcess(String key, Map<String, Object> variables) {
        ProcessInstance processInstance = runtimeService().startProcessInstanceByKey(
                key, variables
        );
        ProcessInstanceAssert processInstanceAssert = assertThat(processInstance)
                .isStarted();

        variables.keySet().forEach(processInstanceAssert::hasVariables);

        return processInstance;
    }
}
