# Payment Service

### How to run the service

1. Clone the repository from git.
2. Run `mvn clean spring-boot:run` command.
4. Use Postman, post `localhost:8080/generate-plan` using payload below:
{
	"loanAmount": "5000",
	"nominalRate": "5.0",
	"duration": 24,
	"startDate": "2018-01-01T00:00:01Z"
}