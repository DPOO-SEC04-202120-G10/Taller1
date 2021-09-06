package uniandes.dpoo.modelo;

public class Ingrediente {
	
	private String nombre;
	
	private int costoAdicional;
	
	private int calorias;
	
	public Ingrediente(String nombre, int costoAdicional) {
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCostoAdicional() {
		return costoAdicional;
	}
	
	public void anadirCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int getCalorias() {
		return calorias;
	}

}
