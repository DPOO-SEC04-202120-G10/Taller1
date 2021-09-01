package uniandes.dpoo.modelo;

public class ProductoAjustado implements Producto {
	public ProductoAjustado(ProductoMenu base);
	{
		
	}
	public String getNombre()
	{
		return nombre;
			
	}
	public int getPrecio()
	{
		return precio;
	}
	public String generarTextoFactura()
	{
		return factura;
	}

}
