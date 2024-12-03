1. Controller: Java file that holds the endpoints
2. Endpoints are methods that are mapped to a URL 
3. When this URL is called from the outside, the method is executed
4. In the controller, we don't want business logic
5. From within the controller, we call the service for business logic
6. In the service, we deal with any specific requirements
7. In the service, we use the repository as a datasource / dao
8. The repository is automagically created when it extends the correct interface