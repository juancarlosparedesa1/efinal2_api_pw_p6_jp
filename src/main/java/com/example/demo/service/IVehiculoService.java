package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

public interface IVehiculoService {

	public void ingresar(VehiculoTO vehiculo);

	public List<VehiculoTO> buscarTodos();

	public Vehiculo buscarPorPlaca(String placa);
}
