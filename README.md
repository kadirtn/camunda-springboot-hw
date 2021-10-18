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
4. Use URL for accessing Camunda APP 
`http://localhost:8080/camunda/app/welcome/default/#!/login`

5. username and password: `demo:demo`


## TODO List
1. Process içerisinde DMN denenmeli
2. REST API security doğrulanmalı(mikroservis projesine taşındıktan sonra)
3. Yazılımsal olarak process run edilebilmeli.