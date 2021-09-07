package uniandes.dpoo.modelo;

public class Bebida {

	private String nombre;
	private int precioBase;
	private int calorias;
	
	public Bebida(String nombre, int precioBase)
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	public String getNombre()
	{
		return nombre;
	}
	public double getPrecio()
	{
		return precioBase;
	}
	public String generarTextoFactura()
	{
		String textoFactura;
		textoFactura = getNombre() + ": " + getPrecio();
		return textoFactura;
	}
	
	public void anadirCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int getCalorias() {
		return calorias;
	}
}
