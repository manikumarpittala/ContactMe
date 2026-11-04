package com.portfolio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.model.HireMessage;

public interface MessageRepository extends JpaRepository<HireMessage, Integer>{

}
