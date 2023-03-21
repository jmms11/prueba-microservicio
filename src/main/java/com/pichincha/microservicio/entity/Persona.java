package com.pichincha.microservicio.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@Data
@MappedSuperclass
public class Persona implements Serializable {

	@Column
	private String nombre;

	@Column
	private String genero;

	@Column
	private Integer edad;

	@Column
	private String identificacion;

	@Column
	private String direccion;

	@Column
	private String telefono;

}

