package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public void ingresar(VehiculoTO vehiculoTo) {
		// TODO Auto-generated method stub

		this.vehiculoRepository.insertar(this.convertirANormal(vehiculoTo));

	}

	@Override
	public List<VehiculoTO> buscarTodos() {
		// TODO Auto-generated method stub
		List<Vehiculo> lista = this.vehiculoRepository.seleccionarTodos();
		List<VehiculoTO> listaFinal = new ArrayList();

		for (Vehiculo vehiculo : lista) {
			listaFinal.add(this.convertirATO(vehiculo));
		}

		return listaFinal;
	}

	// convertir a To
	public VehiculoTO convertirATO(Vehiculo vehiculo) {
		VehiculoTO vehiTo = new VehiculoTO();
		vehiTo.setId(vehiculo.getId());
		vehiTo.setPlaca(vehiculo.getPlaca());
		vehiTo.setMarca(vehiculo.getMarca());
		vehiTo.setModelo(vehiculo.getModelo());
		vehiTo.setColor(vehiculo.getColor());
		vehiTo.setPrecio(vehiculo.getPrecio());
		return vehiTo;

	}

	// convertir a normal
	// 
	public Vehiculo convertirANormal(VehiculoTO vehiculoTo) {
		Vehiculo vehi = new Vehiculo();
		vehi.setId(vehiculoTo.getId());
		vehi.setPlaca(vehiculoTo.getPlaca());
		vehi.setMarca(vehiculoTo.getMarca());
		vehi.setModelo(vehiculoTo.getModelo());
		vehi.setColor(vehiculoTo.getColor());
		vehi.setPrecio(vehi.getPrecio());
		return vehi;

	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorPlaca(placa);
	}

}
