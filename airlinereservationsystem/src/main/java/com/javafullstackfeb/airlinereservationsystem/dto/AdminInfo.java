package com.javafullstackfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@SuppressWarnings(value = { "serial" })
@Data
public class AdminInfo implements Serializable {

	private int id;
	private String name;
	private String emailId;
	@ToString.Exclude
	private String password;
	private long mobileNo;
}
