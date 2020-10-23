package db_demo.db_demo.controller;

import db_demo.db_demo.model.Customers;
import db_demo.db_demo.model.OrderStatuses;
import db_demo.db_demo.model.Orders;
import db_demo.db_demo.repository.CustomersRepository;
import db_demo.db_demo.repository.OrderStatusesRepository;
import db_demo.db_demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    OrderStatusesRepository orderStatusesRepository ;

    @PostMapping("/orders")
    public ResponseEntity<Orders> createTutorial(@RequestBody Orders order) {

        int customerId = order.getCustomersByCustomerId().getCustomerId();
        Customers customer = customersRepository.findById(customerId).get();

        byte orderStatusId = order.getOrderStatusesByStatus().getOrderStatusId();
        OrderStatuses orderStatus = orderStatusesRepository.findById(orderStatusId).get();

        Orders orderNew = new Orders();
        orderNew.setOrderDate(order.getOrderDate());
        orderNew.setComments(order.getComments());
        orderNew.setShippedDate(order.getShippedDate());
        orderNew.setCustomersByCustomerId(customer);
        orderNew.setOrderStatusesByStatus(orderStatus);

        ordersRepository.save(orderNew);
        return new ResponseEntity<>(orderNew, HttpStatus.CREATED);
    }



}