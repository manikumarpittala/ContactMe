package com.portfolio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hire_message")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HireMessage {
  
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="hire_number")
	 private int id;
	 
	 @Column(nullable=false)
	 private String name;

	 @Column(nullable=false)																												
	 private String email;
	 
	 @Column(nullable=false)
	 private String subject;
	 
	 @Column(nullable=false)
	 private String message;
	 	
}
