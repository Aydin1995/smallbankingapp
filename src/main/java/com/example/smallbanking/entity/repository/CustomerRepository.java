package com.example.smallbanking.entity.repository;

import com.example.smallbanking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
