package com.mx.pokeapi.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "records", schema = "pokeapi")
public class RecordsEntity implements Serializable {

	private static final long serialVersionUID = -621440883749644037L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "ip_origin", nullable = false)
	private String ipOrigin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "request_date", nullable = false)
	private Date requestDate;

	@Column(name = "request_method", nullable = false)
	private String requestMethod;
	

}
