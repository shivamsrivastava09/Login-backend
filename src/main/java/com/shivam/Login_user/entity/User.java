package com.shivam.Login_user.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Column(nullable = false)
	private int id;
	@Column(nullable = false)
	private String name;
	@Id
	@Column(nullable = false)
	private String userName;
	@Column(length = 15, nullable = false)
	private String password;
	private LocalDate date;

}
