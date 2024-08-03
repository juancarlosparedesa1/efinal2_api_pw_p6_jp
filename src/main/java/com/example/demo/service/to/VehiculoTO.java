package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoTO extends RepresentationModel<VehiculoTO> implements Serializable {

	private Integer id;

	private String placa;

	private String marca;

	private String modelo;

	private String Color;

	private Integer Precio;

	// SET Y GET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public Integer getPrecio() {
		return Precio;
	}

	public void setPrecio(Integer precio) {
		Precio = precio;
	}

}
