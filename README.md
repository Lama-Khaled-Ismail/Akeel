# Akeel
## Overview
Al-Akeel is an online order management platform.That platform generally allows users to make online orders to a specific restaurant from a registered restaurant list. 
It also tracks and delivers such orders from the restaurant's locations to the customer.The platform serves clients from either a dedicated mobile application, web app or assisted from
customer service over the phone. The platform allows restaurant staff to manage their restaurants
specific orders. 
## Technologies Used

- **Java EE**: The project utilizes Java EE (Enterprise Edition) for building enterprise-level applications.
- **JBoss**: The application is deployed and runs on the JBoss application server, providing a robust and scalable environment.

## System functionalities
  User can have 3 different roles Customer, RestaurantOwner, Runner roles
  Restaurant owner, customer, runner  
  <br>● Sign up and Login for each role
 
  <br>● Restaurant owner:
  <br> ■ Create restaurant menu
  <br> ■ Edit restaurant: change menu meals for each restaurant
  <br> ■ Get restaurant details by id
  <br> ■ Create restaurant report: given a restaurant id print
  how much the restaurant earns (summation of total amount of all completed
  orders) , Number of completed orders, Number of canceled orders
  
  <br>● Customer:
  <br>
  <br>■ Create order by customer
  <br>Exceptations: imagine a normal restaurant receipt
  
  <br>Order details should contains date ,restaurant name, items list , delivery fees,
  <br>runner name, total receipt value (summation of items prices , delivery fees )
  <br>list orders by customer id
  <br>■ When creating an order select a random available runner from db and assign it to
  <br>an order and convert his status to busy
  <br>■ Edit order [change an order’s items] make sure an order is not canceled and it is
  <br>in the preparing state to be edited
  <br>■ List all restaurants
  <br>
  <br>● Runner:
  
  <br>■ Runner can mark an order is delivered and his status to available
  <br>■ Get number of trips completed by a runner make sure orders are not canceled
  <br>and marked as completed
