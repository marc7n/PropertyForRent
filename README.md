Property For Renty

Simple rest api

Curl:

add new reservation:

curl --location --request POST 'http://localhost:8080/api/add' \
--header 'Content-Type: application/json' \
--data-raw '{
"startReservation": "2011-05-18",
"endReservation": "2011-06-14",
"property": {
"id":4
},
"tenant": {
"tenantName": "Walt Kowalsky"
},
"landlord": {
"name" : "Mr. Bean"
}

update:

curl --location --request PUT 'http://localhost:8080/api/update/1' \
--header 'Content-Type: application/json' \
--data-raw '{
"startReservation": "2011-05-18",
"endReservation": "2011-07-14",
"property": {
"id":4
},
"tenant": {
"tenantName": "Walt Kowalsky"
},
"landlord": {
"name" : "Mr. Bean"
}
}'

getting all reservation by tenant name:

curl --location --request GET 'http://localhost:8080/api/name/Walt Kowalsky' \
--header 'Content-Type: application/json' \
--data-raw '{
"startReservation": "2019-05-18",
"endReservation": "2019-06-14",
"property": {
"id": 4
},
"tenant": {
"tenantName": "jjjj"
},
"landlord": {
"name" : "joe"
}
}'

getting all reservation by properties

curl --location --request GET 'http://localhost:8080/api/id/2' \
--header 'Content-Type: application/json' \
--data-raw '{
"startReservation": "2019-05-18",
"endReservation": "2019-06-14",
"property": {
"id": 4
},
"tenant": {
"tenantName": "jjjj"
},
"landlord": {
"name" : "joe"
}
}'
