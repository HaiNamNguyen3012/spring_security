package com.example.springsecurity.Service;

import com.example.springsecurity.Repository.CustomerRepository;
import com.example.springsecurity.common.CommonStatus;
import com.example.springsecurity.dto.CustomerDTO;
import com.example.springsecurity.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    public CommonStatus signUpCustomer(CustomerDTO customerDTO){
        String encodedPassword = passwordEncoder.encode(customerDTO.getPassword());
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setPassword(encodedPassword);

        customerRepository.save(customer);

        CommonStatus commonStatus = new CommonStatus();
        commonStatus.setStatus("200");
        commonStatus.setResponse("200");
        return commonStatus;
    }
}
