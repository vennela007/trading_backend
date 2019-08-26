package com.hcl.trading.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trading.entity.LatestPrice;

@Repository
public interface LatestPriceRepository extends JpaRepository<LatestPrice, Integer>{
	Optional<LatestPrice> findByStockId(Integer stockId);

}
