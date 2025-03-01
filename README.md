Employee Performence Advisor Application is a Spring-Boot Application, it exposes api's to
add,get,delete,bulk add of employee ratings.
And it also exposes api's to get actuals percentage, deviation from standards and
advice on employee performence rating.

Before Running spring-boot application, update following properties in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee-performance?createDatabaseIfNotExist=true
spring.datasource.username=acharya
spring.datasource.password=acharya


1.Upload Employee Rating
curl --location 'http://localhost:8080/ratings/bulk' \
--header 'Content-Type: application/json' \
--data '[
{
"empName": "Harry 1",
"rate": "A"
},
{
"empName": "Harry 3",
"rate": "B"
},
{
"empName": "Harry 4",
"rate": "B"
},
{
"empName": "Harry 2",
"rate": "C"
},
{
"empName": "Harry 5",
"rate": "C"
},
{
"empName": "Harry 7",
"rate": "C"
},
{
"empName": "Harry 12",
"rate": "C"
},
{
"empName": "Harry 8",
"rate": "D"
},
{
"empName": "Harry 9",
"rate": "D"
},
{
"empName": "Harry 10",
"rate": "E"
}
]'

2. Get Actuals
   Request
   curl --location 'http://localhost:8080/ratings/actuals'

Response
{"D":20.0,"A":10.0,"C":40.0,"B":20.0,"E":10.0}

3. Get deviations
   Request
   curl --location 'http://localhost:8080/ratings/deviation'

Response
{"A":0.0,"B":0.0,"C":0.0,"D":0.0,"E":0.0}

4. Get Advice on emloyee perfomence appraisal
   Request
   curl --location 'http://localhost:8080/ratings/advice'

Response
{}
Note: Since there are no devaitions from standards response is empty.

CASE 2:Deviation Exist

1.Upload Employee Rating
curl --location 'http://localhost:8080/ratings/bulk' \
--header 'Content-Type: application/json' \
--data '[
{
"empName": "Harry 1",
"rate": "B"
},
{
"empName": "Harry 3",
"rate": "B"
},
{
"empName": "Harry 4",
"rate": "B"
},
{
"empName": "Harry 2",
"rate": "C"
},
{
"empName": "Harry 5",
"rate": "C"
},
{
"empName": "Harry 7",
"rate": "C"
},
{
"empName": "Harry 12",
"rate": "C"
},
{
"empName": "Harry 8",
"rate": "D"
},
{
"empName": "Harry 9",
"rate": "D"
},
{
"empName": "Harry 10",
"rate": "D"
}
]'

2. Get Actuals
   Request
   curl --location 'http://localhost:8080/ratings/actuals'

Response
{"D":30.0,"B":30.0,"C":40.0}

3. Get deviations
   Request
   curl --location 'http://localhost:8080/ratings/deviation'

Response
{"A":-10.0,"B":10.0,"C":0.0,"D":10.0,"E":-10.0}

4. Get Advice on emloyee perfomence appraisal
   Request
   curl --location 'http://localhost:8080/ratings/advice'

Response
{"D → E":10.0,"B → A":10.0}
Note: Response is telling move 10% of resources from D to E. And 10% of resources from B to A.

