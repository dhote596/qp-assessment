# qp-assessment
Demo project for Grocery Booking


1.  Grocery Booking API has 2 Roles:
- Admin
- User

2. Postman Collections is also attached along with this project.

3. Following API'S are exposed in this project:- 

Admin API's :- 
  1. GET http://localhost:8080/api/grocery-items
  2. POST http://localhost:8080/api/grocery-items
    {
    "name" : "Salt",
    "price" : 20.00,
    "quantity": 2
    }
  4. DELETE http://localhost:8080/api/grocery-items/{itemId}
  5. PUT http://localhost:8080/api/grocery-items
    {
    "name" : "Salt",
    "price" : 20.00,
    "quantity": 2
    }


User API'S:- 
  1. POST http://localhost:8080/api/orders/createOrder
     [
       {
    "name" : "Salt",
    "price" : 20.00,
    "quantity": 2
    },
 
     {
       "name" : "Sugar",
       "price" : 20.00,
       "quantity": 2
     }
    ]
  3. GET http://localhost:8080/api/grocery-items
