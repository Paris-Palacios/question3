How to run:

-execute jar file

make a POST request to localhost:8080/updateSupply with a Json Body as follows:

{
"productId":"Product2","updateTimeStamp":
"2021-03-16T08:49:48.616Z","quantity":5}

you should get the following response: 
{"productId":"Product2","updateTimeStamp":"Mar 16, 2021, 8:49:48 AM","quantity":5.0,"status":"Out of Sync Update"}

-----------------------------------------------------------------

make another post request with this body Json

{"productId": "Product4",
"updateTimeStamp": "2021-03-
16T09:15:48.616Z", "quantity": 20}

you should get the following response: 
{"productId":"Product4","updateTimeStamp":"Mar 16, 2021, 9:15:48 AM","quantity":40.0,"status":"Updated"}


dependecies are Spring web and Lombok
