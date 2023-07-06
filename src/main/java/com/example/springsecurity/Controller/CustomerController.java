package com.example.springsecurity.Controller;

import com.example.springsecurity.Service.CustomerService;
import com.example.springsecurity.common.CommonStatus;
import com.example.springsecurity.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/signup")
    public ResponseEntity<CommonStatus> signUpCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(customerService.signUpCustomer(customerDTO));
    }
}
