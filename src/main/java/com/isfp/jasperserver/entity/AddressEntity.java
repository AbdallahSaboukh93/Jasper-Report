package com.isfp.jasperserver.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "addresses")
public class AddressEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1187912690158492668L;

	@Id
	@GeneratedValue
	private long id;
//
//	@Column(length = 30, nullable = false)
//	private String addressId;
//
//	@Column(length = 15, nullable = false)
//	private String city;
//
//	@Column(length = 15, nullable = false)
//	private String country;
//
//	@Column(length = 100, nullable = false)
//	private String streetName;
//
//	@Column(length = 7, nullable = false)
//	private String postalCode;
//
//	@Column(length = 10, nullable = false)
//	private String type;

	@ManyToOne()
	@JoinColumn(name = "users_id", referencedColumnName = "id")
	private UserEntity userDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}

}
