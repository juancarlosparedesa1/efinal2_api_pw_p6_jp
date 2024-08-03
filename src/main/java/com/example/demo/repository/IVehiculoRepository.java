package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo);

	public List<Vehiculo> seleccionarTodos();

	public Vehiculo seleccionarPorPlaca(String placa);

	public void eliminar(String placa);
}
