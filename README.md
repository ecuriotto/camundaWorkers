# Example of a distributed worker application for Camunda 7

This kubernetes application is using the Camunda platform run distribution available on docker.
Three workers containers will pull the jobs and execute them.
The use case is the one explained in the training, the Payment process (simple version without messages)

## Prerequisites

Kubernetes cluster available
Create an ingress.yml file (not provided here), and a secret if required by your kubernetes provider. This last step may not be necessary.

## Deploy
kubectl apply -f camundaPlatform.yml,camundaService.yml,configMaps.yml,ingress.yml,secret.yml,workerDeploy.yml

## Verify deployment successful
Verify that all the resources have been created properly.
Try to access your camunda platform web applications (i.e. cockpit) from the url you configured on your ingress.

## Create instances

- Deploy the camunda7-order-process-app/src/main/resources/payment_process.bpmn process on your newly installed camunda platform
- Start a couple of process instances with the following payload:
{
    "orderTotal": {
      "value": 49.99,
      "type": "Double"
    },
    "customerId": {
      "value": "cust30",
      "type": "String"
    },
    "cardNumber": {
      "value": "1234 5678"
    },
    "CVC": {
      "value": "123"
    }, 
    "expiryDate": {
      "value": "09/24"
    }
}

## Verify that workers ... work
- get the workers pods names: `kubectl get pod`
- inspect the logs: `kubectl logs <pod_name>`
- you should see lines like the following in at least one pod (should be more):

2023-06-05 14:15:13.702  INFO 1 --- [criptionManager] c.c.training.services.CustomerService    : customer cust30 has credit of 30.0
2023-06-05 14:15:13.705  INFO 1 --- [criptionManager] c.c.training.services.CustomerService    : charged 30.0 from the credit, open amount is 19.990000000000002
2023-06-05 14:15:13.706  INFO 1 --- [criptionManager] c.c.training.services.CustomerService    : customer cust30 has credit of 30.0