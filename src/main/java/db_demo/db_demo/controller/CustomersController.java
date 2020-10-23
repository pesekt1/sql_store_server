package db_demo.db_demo.controller;

import db_demo.db_demo.model.Customers;
import db_demo.db_demo.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomersController {

    @Autowired
    CustomersRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getAllTutorials() {
        List<Customers> customers = new ArrayList<Customers>();
        customers.addAll(customerRepository.findAll());

        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
