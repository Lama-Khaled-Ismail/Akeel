# Akeel
## Overview
Al-Akeel is an online order management platform.That platform generally allows users to make online orders to a specific restaurant from a registered restaurant list. 
It also tracks and delivers such orders from the restaurant's locations to the customer.The platform serves clients from either a dedicated mobile application, web app or assisted from
customer service over the phone. The platform allows restaurant staff to manage their restaurants
specific orders. 

## System functionalities
  User can have 3 different roles Customer, RestaurantOwner, Runner roles
  Restaurant owner, customer, runner  ● Sign up and Login for each role
    Note: when creating runner account let user enter delivery fees per order , this value will be
    reused when calculating the total order value
    ● Restaurant owner:
  
  ■ Create restaurant menu
  ■ Edit restaurant: change menu meals for each restaurant
  ■ Get restaurant details by id
  ■ Create restaurant report: given a restaurant id print
  how much the restaurant earns (summation of total amount of all completed
  orders) , Number of completed orders, Number of canceled orders
  
  ● Customer:
  
  ■ Create order by customer
  Exceptations: imagine a normal restaurant receipt
  
  Order details should contains date ,restaurant name, items list , delivery fees,
  runner name, total receipt value (summation of items prices , delivery fees )
  list orders by customer id
  ■ When creating an order select a random available runner from db and assign it to
  an order and convert his status to busy
  ■ Edit order [change an order’s items] make sure an order is not canceled and it is
  in the preparing state to be edited
  ■ List all restaurants
  
  ● Runner:
  
  ■ Runner can mark an order is delivered and his status to available
  ■ Get number of trips completed by a runner make sure orders are not canceled
  and marked as completed
