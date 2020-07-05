package com.javafullstack.airlinereservationjdbc.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@SuppressWarnings(value = { "serial" })
@Data
public class UserInfo implements Serializable{

	private int userId;
	private String userName;
	private String emailId;
	@ToString.Exclude
	private String password;
	private long mobileNumber;
	private String role;
}
