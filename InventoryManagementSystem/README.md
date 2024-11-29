#  API Documentation for Inventory and Order Management

## Overview
This API Allows users to manage products to create, update, delete(soft delete) and retrieve products.
Also API allows users to manage sales orders containing multiple products, including creating, updating, retrieving, and deleting orders. 
Each order contains products with quantities, pricing, and total cost.

---
## Project Set up:
* Open your terminal and create a new folder for your project.
  ```mkdir IMS_project ```
  ```cd IMS_project```
  down load zip file and extract to IMS_project folder.
* Use Intellij Idea or suitable IDE to open the project.
* Go to ``src/main/resources/application.properties`` file
* Change password to your workbench password.
* Open your MySQL work bench and start root server on port 3306
* Use SQL command to create database:
 ```
 CREATE DATABASE inventory_management;
 ```
* Run project on IDE.

# Brief about Project:
* Entities created: product, Order, OrderItem
* DTO(Data Transfer Objects) created : ProductDto, OrderDto, ProductUpdateDTo, OrderItemDto
* Mappers used to map entities to DTO's and vice versa
* JPA Repositories created : productRepository, OrderRepository, OrderItemRepository
*  Order table related with orderItem table by OneTOMany Relationship. Each Order can contains multiple items.
*  OrderItem table related with order tabley by ManyToOne Relationship. Each Item can part of Orders.
*  Used bidirectional Mapping between these 2 tables.
*  Service Layer includes all the business logic.
*  Controller Layer handles all API endpoints.
### Product Management APIs:
* Create a product:
   Add a new product with fields such as name, SKU, price, and quantity in stock.
* Update a product: Modify an existing product's details.
* List all products: Fetch a paginated list of all products (support basic search by
  name or SKU).
* Delete a product: Soft delete a product (mark it as inactive, don’t delete from the
database).

#### Schema
![image](https://github.com/user-attachments/assets/260ca4bd-6f7b-4a84-b433-a83c163471ee)


### **Endpoint**: `POST /IMS/product/createProduct`
* creates a new product containing product id, sku , price, quantity and active.
* Active field is used to show the product is avaliable or not.
* Request Body Example:
* @PostMapping("/createProduct")

{
  
    "sku": "PREDATOR-123",
    "name": "Predator 23",
    "price": 14100.0,
    "quantity": 116,
    "active": true
  
}

* Response :
  ![image](https://github.com/user-attachments/assets/593b276c-66cf-4988-9451-6a9d21c4d018)

### **Endpoint**: `PUT /IMS/product/{id}/updateProduct`

* Only these fields can be updated name, price, quantity, active.
* Request body  ``` ProductUpdateDto``` as a Data transfer object.
* Request Body Example:

{
    "name" : "MAC book",
    "price" : 112000.00,
    "active": true
}

* Response :
  ![image](https://github.com/user-attachments/assets/49a3152e-eb19-4aaf-bd42-706f50405966)

### **Endpoint**: `GET /IMS/product/allProducts`
* Uses GET mapping annotation
*  Fetch a paginated list of all products (support basic search by
    name or SKU)
* Fetches all products from products table using pagination.
* To implement Pagination- It uses Pageable Interface from spring data dependency.
* End point takes Query parameter as String to be search.
* Example:
  http://localhost:8080/IMS/product/allProducts?search=Mac
  
* Response :
  ```
  {
    "content": [
        {
            "id": 1,
            "sku": "SKU001",
            "name": "MAC book",
            "price": 112000.0,
            "quantity": 98,
            "active": true
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 1,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}



### **Endpoint**: `DELETE /IMS/product//delete/{id}`
using DeleteMapping Annotation.
* Delete a product: Soft delete a product (mark it as inactive, don’t delete from the
database).
* Request url: http://localhost:8080/IMS/product/delete/6
* Response :
{
  Product has been deleted successfully 6
}

 
## Order Management APIs
* Create an order: Create a sales order that contains multiple products, their quantities ordered, price at the time of placing order and the total price.
* Get order details: Retrieve the details of a specific sales order, including the products, quantities, and total amount.
* List all orders: Fetch a paginated list of all orders (with basic pagination).
* Schema :
* ![image](https://github.com/user-attachments/assets/7264c189-07b5-498b-957d-9ee01071e265)

* OrderItem table schema:
* ![image](https://github.com/user-attachments/assets/fee7ddef-e010-4045-89c0-ae0b8c210415)

 ### **Endpoint**: `POST /IMS/order/createOrder`
* Request Body Example:
* @PostMapping("/createOrder")
```

{
  "productIds": [
    {
      "productId": 9,
      "quantity": 2
    },
    {
      "productId":12 , 
      "quantity": 1
    }
  ]
   
}
```
Response: 

```
{
    "id": 4,
    "totalPrice": 174101.98,
    "createdAt": "2024-11-30T01:45:32.3401787",
    "items": [
        {
            "id": 7,
            "productDto": {
                "id": 9,
                "sku": "MOTO-5G-123",
                "name": "Moto B2",
                "price": 80000.99,
                "quantity": 77,
                "active": true
            },
            "quantity": 2,
            "price": 80000.99
        },
        {
            "id": 8,
            "productDto": {
                "id": 12,
                "sku": "PREDATOR-123",
                "name": "Predator 23",
                "price": 14100.0,
                "quantity": 115,
                "active": true
            },
            "quantity": 1,
            "price": 14100.0
        }
    ]
}
```
### **Endpoint**: `GET /IMS/order/{id}`
 * URL : http://localhost:8080/IMS/order/3
 Response : 
 ```
 {
    "id": 3,
    "totalPrice": 174101.98,
    "createdAt": "2024-11-29T22:49:56.052848",
    "items": [
        {
            "id": 5,
            "productDto": {
                "id": 9,
                "sku": "MOTO-5G-123",
                "name": "Moto B2",
                "price": 80000.99,
                "quantity": 75,
                "active": true
            },
            "quantity": 2,
            "price": 80000.99
        },
        {
            "id": 6,
            "productDto": {
                "id": 12,
                "sku": "PREDATOR-123",
                "name": "Predator 23",
                "price": 14100.0,
                "quantity": 114,
                "active": true
            },
            "quantity": 1,
            "price": 14100.0
        }
    ]
}
```
### **Endpoint**: `GET /IMS/order/allOrders`
* Implemented pagination to efficient load of data from server.
* URL : http://localhost:8080/IMS/order/allOrders
* Response :
```
{
    "content": [
        {
            "id": 1,
            "totalPrice": 109.97,
            "createdAt": "2024-11-29T21:17:59.245869",
            "items": [
                {
                    "id": 1,
                    "productDto": {
                        "id": 1,
                        "sku": "SKU001",
                        "name": "MAC book",
                        "price": 112000.0,
                        "quantity": 98,
                        "active": true
                    },
                    "quantity": 2,
                    "price": 29.99
                },
                {
                    "id": 2,
                    "productDto": {
                        "id": 4,
                        "sku": "SKU004",
                        "name": "Product 4",
                        "price": 49.99,
                        "quantity": 79,
                        "active": true
                    },
                    "quantity": 1,
                    "price": 49.99
                }
            ]
        },
        {
            "id": 2,
            "totalPrice": 236414.97000000003,
            "createdAt": "2024-11-29T21:49:35.803616",
            "items": [
                {
                    "id": 3,
                    "productDto": {
                        "id": 9,
                        "sku": "MOTO-5G-123",
                        "name": "Moto B2",
                        "price": 80000.99,
                        "quantity": 75,
                        "active": true
                    },
                    "quantity": 2,
                    "price": 80000.99
                },
                {
                    "id": 4,
                    "productDto": {
                        "id": 11,
                        "sku": "HP-LAPTOP-123",
                        "name": "Hp laptop pavilian",
                        "price": 76412.99,
                        "quantity": 140,
                        "active": true
                    },
                    "quantity": 1,
                    "price": 76412.99
                }
            ]
        },
        {
            "id": 3,
            "totalPrice": 174101.98,
            "createdAt": "2024-11-29T22:49:56.052848",
            "items": [
                {
                    "id": 5,
                    "productDto": {
                        "id": 9,
                        "sku": "MOTO-5G-123",
                        "name": "Moto B2",
                        "price": 80000.99,
                        "quantity": 75,
                        "active": true
                    },
                    "quantity": 2,
                    "price": 80000.99
                },
                {
                    "id": 6,
                    "productDto": {
                        "id": 12,
                        "sku": "PREDATOR-123",
                        "name": "Predator 23",
                        "price": 14100.0,
                        "quantity": 114,
                        "active": true
                    },
                    "quantity": 1,
                    "price": 14100.0
                }
            ]
        },
        {
            "id": 4,
            "totalPrice": 174101.98,
            "createdAt": "2024-11-30T01:45:32.340179",
            "items": [
                {
                    "id": 7,
                    "productDto": {
                        "id": 9,
                        "sku": "MOTO-5G-123",
                        "name": "Moto B2",
                        "price": 80000.99,
                        "quantity": 75,
                        "active": true
                    },
                    "quantity": 2,
                    "price": 80000.99
                },
                {
                    "id": 8,
                    "productDto": {
                        "id": 12,
                        "sku": "PREDATOR-123",
                        "name": "Predator 23",
                        "price": 14100.0,
                        "quantity": 114,
                        "active": true
                    },
                    "quantity": 1,
                    "price": 14100.0
                }
            ]
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 4,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 4,
    "empty": false
}
```


