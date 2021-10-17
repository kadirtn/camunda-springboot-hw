# camunda-springboot-hw
Camunda 'Hello World' app with Spring boot



1. Deploy
2. 'POST' request to URL: http://localhost:8080/engine-rest/process-definition/key/externalTaskClientProcess/start
   1. using header: `Content-Type: application/json`
   2. using body:
    ```json
    {
        "variables": {}
    }
    ```
3. Use Camunda Modeler for modifying the bpmn flow.