#!/bin/bash
curl --location --request GET 'http://localhost:8080/screenings/' -v

curl --location --request GET 'http://localhost:8080/screenings/sorted/date?startDate=2021-06-01_15:00&endDate=2021-06-03_21:00' -v

curl --location --request GET 'http://localhost:8080/screenings/sorted/title?startDate=2021-06-01_15:00&endDate=2021-06-03_21:00' -v

curl --location --request GET 'http://localhost:8080/screenings/sorted/dateTitle?startDate=2021-06-01_15:00&endDate=2021-06-03_21:00' -v

curl --location --request GET 'http://localhost:8080/screenings/5' -v

curl --location --request GET 'http://localhost:8080/screenings/5/screeningRoom' -v

curl --location --request GET 'http://localhost:8080/screenings/5/tableOfSeats' -v

curl --location --request POST 'http://localhost:8080/tickets/' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
    "screeningId": 5,
    "typeOfTicket": "NORMAL",
    "numberOfRow": 2,
    "numberOfSeatInRow": 3,
    "name": "Adam",
    "surname": "Żuber"
    },
    {
    "screeningId": 5,
    "typeOfTicket": "CHILD",
    "numberOfRow": 2,
    "numberOfSeatInRow": 2,
    "name": "Adam",
    "surname": "Żuber"
    }
]' -v

curl --location --request GET 'http://localhost:8080/tickets/summary?price=37.5&screeningId=5' -v

