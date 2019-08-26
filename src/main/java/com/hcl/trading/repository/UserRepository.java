/**
 * 
 */
package com.hcl.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trading.entity.User;

/**
 * @author Gurpreet Singh
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
