package com.example.store.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.model.Sales;

public interface StoreRepo extends JpaRepository<Sales, Integer> {

}
