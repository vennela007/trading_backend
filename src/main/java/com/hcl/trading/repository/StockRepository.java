package com.hcl.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.trading.entity.Stocks;

public interface StockRepository extends JpaRepository<Stocks, Integer>{

}
