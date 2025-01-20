package com.scaler.EComProductService.repository;

import com.scaler.EComProductService.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {
}