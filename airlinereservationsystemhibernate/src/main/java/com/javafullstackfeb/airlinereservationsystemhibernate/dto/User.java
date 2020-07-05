package com.javafullstackfeb.airlinereservationsystemhibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="user")
public class User implements Serializable{
	
	@Id
	@Column
    private int id;
	@Column
    private String name;
	@Column(name="email_id")
    private String emailId;
	@Column(name="mobilenumber")
    private long mobileNumber;
    @ToString.Exclude
    @Column
    private String password;
    @Column
    private String role;
}
