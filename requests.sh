curl -X POST \
  http://localhost:8080/doctors \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: a8e04d0c-154d-472c-be02-d15f39ec53d4' \
  -H 'cache-control: no-cache' \
  -d '{
	"fName" : "John",
	"lName" : "Dorian",
	"specialization" : "Internal Medicine"
}'

curl -X GET \
  http://localhost:8080/doctors \
  -H 'Postman-Token: 9150daaf-8d3d-492d-a244-f0e9a3195e97' \
  -H 'cache-control: no-cache'

curl -X POST \
  http://localhost:8080/clinics \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 0dec8820-1f80-48ab-930e-889814b5b4a7' \
  -H 'cache-control: no-cache' \
  -d '{
	"name" : "Sacred Heart",
	"city" : "North Hollywood",
	"streetAddress" : "12629 Riverside Drive"
}'

curl -X GET \
  http://localhost:8080/clinics \
  -H 'Postman-Token: 71e936ba-5fe6-494b-938a-b53dec91fec6' \
  -H 'cache-control: no-cache'