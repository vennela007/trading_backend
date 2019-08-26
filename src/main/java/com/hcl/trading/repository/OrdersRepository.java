package com.hcl.trading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.trading.dto.TrendingResponseDto;
import com.hcl.trading.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findByUserId(Integer userId);

	@Query("select New com.hcl.trading.dto.TrendingResponseDto (o.stockId,s.stockName, count(o.stockId) as count) from Orders o,Stocks s where o.stockStatus='C' and o.stockId=s.stockId group by o.stockId")
	List<TrendingResponseDto> getToptrendings();

}
