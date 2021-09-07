package uniandes.dpoo.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import uniandes.dpoo.modelo.Combo;
import uniandes.dpoo.modelo.Ingrediente;
import uniandes.dpoo.modelo.ProductoMenu;

public class LoaderInformacionArchivos {

	/**
	 * Lectura del archivo de Productos Menu
	 * @param rutaArchivo ruta de la ubicacion del archivo de productos menu en memoria secuendaria
	 * @return Lista de ProductoMenu cargados desde el archivo de productos menu
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<ProductoMenu> leerInfoArchivoProductosMenu(String rutaArchivo) throws FileNotFoundException, IOException
	{
		ArrayList<ProductoMenu> productosMenu = new ArrayList<ProductoMenu>();
		// "Abrir" el archivo de ProductoMenu y leerlo linea por linea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine();   // Leer la linea con el primer ProductoMenu en el archivo   
		// Un ProductoMenu tiene la forma: nombre;precioBase
		while (linea != null) // Cuando se llegue al final del archivo, linea tendra el valor null
		{
			// Separar los valores que estan en la linea por el caracter ';'
			String[] partes = linea.split(";");
			
			ProductoMenu nuevoProducto = new ProductoMenu(partes[0], Integer.parseInt(partes[1]));   // Creacion de un objeto ProductoMenu con su nombre y precio base
			nuevoProducto.anadirCalorias(Integer.parseInt(partes[2]));
			productosMenu.add( nuevoProducto );

			linea = br.readLine(); // leer la proxima linea en el archivo con un nuevo ProductoMenu 
		}
		br.close();
		return productosMenu;
	}

	/**
	 * Lectura del archivo de Combos
	 * @param rutaArchivo ruta de la ubicacion del archivo de combos en memoria secuendaria
	 * @param productosMenu Lista con productos menu disponibles. Cada combo puede contener productos menu de esta lista. 
	 * @return Lista de Combos cargados desde el archivo de combos
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<Combo> leerInfoArchivoCombos(String rutaArchivo, ArrayList<ProductoMenu> productosMenu) throws FileNotFoundException, IOException
	{
		ArrayList<Combo> combos = new ArrayList<Combo>();
		// "Abrir" el archivo de Combos y leerlo linea por linea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine();   // Leer la linea con el primer combo en el archivo   
		// Un combo tiene la forma: nombre;porcentaje;productoMenu1;productoMenu2;productoMenu3;...
		while (linea != null) // Cuando se llegue al final del archivo, linea tendra el valor null
		{
			// Separar los valores que estan en la linea por el caracter ';'
			String[] partes = linea.split(";");
			double porcentaje = Double.parseDouble( partes[1].substring(0, partes[1].length()-1)); 

			Combo nuevoCombo = new Combo(partes[0], porcentaje);   // creacion de un objeto Combo con su nombre y porcentaje de descuento

			for (int i = 2; i < partes.length; i++)
			{
				String parte = partes[i];
				
				for (int e = 0; e < productosMenu.size(); e++){
					var elProductoMenu = productosMenu.get(e);
					var nombreProducto = elProductoMenu.getNombre();
					if (nombreProducto == parte) {
						nuevoCombo.agregarItemACombo(elProductoMenu); 
					}
				}
				
				   // SIMPLIFICACION: se agrega el nombre de un "productoMenu" a un combo
				                                          // MEJORA: Buscar y agregar el ProductoMenu con el nombre en la lista productosMenu (parametro)
			}

			combos.add( nuevoCombo );

			linea = br.readLine(); // leer la proxima linea en el archivo con un nuevo Combo 
		}
		br.close();
		return combos;
		
		
	}
	
	public static ArrayList<Ingrediente> leerInfoArchivoIngredientes(String rutaArchivo) throws FileNotFoundException, IOException
	{
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine();  
		
		while (linea != null) 
		{
			
			String[] partes = linea.split(";");
			
			Ingrediente nuevoIngrediente = new Ingrediente(partes[0], Integer.parseInt(partes[1]));  
			nuevoIngrediente.anadirCalorias(Integer.parseInt(partes[2]));
			ingredientes.add(nuevoIngrediente);

			linea = br.readLine(); 
		}
		br.close();
		return ingredientes;
	}

}
