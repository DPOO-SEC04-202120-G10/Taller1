package uniandes.dpoo.consola;
import java.util.ArrayList;

import uniandes.dpoo.modelo.Combo;
import uniandes.dpoo.modelo.Ingrediente;
import uniandes.dpoo.modelo.Pedido;
import uniandes.dpoo.modelo.ProductoAjustado;
import uniandes.dpoo.modelo.ProductoMenu;
import uniandes.dpoo.modelo.Restaurante;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Aplicacion {
private static int idPedido;
private static Scanner inputScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicio de ejecuci�n de la aplicaci�n");
		Restaurante elRestaurante= new Restaurante();
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.ejecutarAplicacion(elRestaurante, aplicacion);
		
	}
	public void ejecutarAplicacion(Restaurante elRestaurante, Aplicacion aplicacion)
	{
		System.out.println("Bienvenido al Restaurante\n");
		
		try {
			elRestaurante.cargarInformacionRestaurante("data/ingredientes.txt","data/menu.txt","data/combos.txt" );
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		idPedido= 0;
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();

		        inputScanner.useDelimiter(System.lineSeparator());
		        System.out.println("Ingrese la opcion");
		        int opcion_seleccionada = inputScanner.nextInt();
		        
	
				if (opcion_seleccionada == 1)
					aplicacion.ejecutarMostrarMenu(elRestaurante);
				else if (opcion_seleccionada == 2)
					aplicacion.ejecutarMostrarCombo(elRestaurante);
				//else if (opcion_seleccionada == 3)
					//ejecutarMostrarIngredientes();
				else if (opcion_seleccionada == 3)
					aplicacion.ejecutarNuevoPedido(elRestaurante, idPedido, aplicacion);
				else if (opcion_seleccionada == 4)
					aplicacion.ejecutarCerrarPedido(elRestaurante);
				else if (opcion_seleccionada == 5)
					aplicacion.ejecutarVerPedidoPasado(elRestaurante);
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Ver el Menu");
		System.out.println("2. Ver el Combo");
		System.out.println("3. Iniciar Un nuevo Pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5.Consultar pedido pasado\n");
		System.out.println("6. Salir de la aplicación\n");
	}

	private void ejecutarMostrarMenu(Restaurante elRestaurante)
	{
		
		var menuBase = elRestaurante.getMenuBase();
		for (int i = 0; i < menuBase.size(); i++){
			System.out.println(String.valueOf(i) + " " + menuBase.get(i).getNombre());
			
		}
			
		}
	private void ejecutarMostrarIngredientes(Restaurante elRestaurante)
	{
	System.out.println("\n" + "Ingredientes Adicionales" + "\n");
	int a= 0;
	for (Ingrediente i:elRestaurante.getIngredientes()) {
		int b= a+1;
		System.out.println(String.valueOf(b) +" " + i.getNombre());
		a=a+1;
	}
}

	
	private void ejecutarMostrarCombo(Restaurante elRestaurante)
	{
		System.out.println("\n" + "Combo" + "\n");
		int a= 0;
		for (Combo i:elRestaurante.getCombo())
		{
			int b= a+1;
		System.out.println(String.valueOf(b) + " " + i.getNombre());
		a=a+1;
		}
}
	private ProductoAjustado anadirElementos(ProductoMenu elProducto, Restaurante elRestaurante, Aplicacion aplicacion)
	{
		ProductoAjustado elProductoAjustado= new ProductoAjustado(elProducto);
		inputScanner.useDelimiter(System.lineSeparator());
	    System.out.println("Quiere añadir igredientes al producto?:"+ "\n 1. Si "
				+ "\n 2. No");
	    int suma = inputScanner.nextInt();
		
		if (suma==1)
		{
			
			aplicacion.ejecutarMostrarIngredientes(elRestaurante);
			System.out.println("Ingrese el numero del ingrediente que quiere anadir");
			int ajuste = inputScanner.nextInt();
			var elIngrediente = elRestaurante.getIngredientes().get(ajuste-1);
			elProductoAjustado.anadirIngrediente(elIngrediente);

		}
		
		System.out.println("Quiere eliminar igredientes al producto?:"+ "\n 1. Si "
				+ "\n 2. No");
		int resta = inputScanner.nextInt();
		
		if (resta==1)
		{
			aplicacion.ejecutarMostrarIngredientes(elRestaurante);
			
			System.out.println("Ingrese el numero del ingrediente que quiere eliminar");
			int ajuste = inputScanner.nextInt();
			var elIngrediente = elRestaurante.getIngredientes().get(ajuste-1);
			elProductoAjustado.eliminarIngrediente(elIngrediente);
			
		}
		
		return elProductoAjustado;
	}


	private void ejecutarNuevoPedido(Restaurante elRestaurante, int idPedido, Aplicacion aplicacion)
	{
		
        inputScanner.useDelimiter(System.lineSeparator());
        System.out.println("Por favor ingrese su nombre");
        String cliente = inputScanner.next();
        System.out.println("Por favor ingrese su direccion");
        String direccion = inputScanner.next();
		
		elRestaurante.iniciarPedido(cliente, direccion, idPedido);
		
		Pedido elPedido= elRestaurante.getPedidoEnCurso();
		
		ejecutarAgregarElemento(elPedido, elRestaurante, aplicacion);
		
		
	}

	private void ejecutarAgregarElemento(Pedido elPedido, Restaurante elRestaurante, Aplicacion aplicacion)
	{
		
		boolean mas= true;
		while (mas==true)
		{	
			inputScanner.useDelimiter(System.lineSeparator());
			System.out.println("Por favor ingrese tipo de pedido: \n 1. Menu \n 2. Combo ");
			int tipo = inputScanner.nextInt();
			
			
				if (tipo==1)
				{
					
					aplicacion.ejecutarMostrarMenu(elRestaurante);
					
					System.out.println("Por favor ingrese el numero del Producto.");
					String pedidot= inputScanner.next();
					
					int e=Integer.parseInt(pedidot);
					var elProducto = elRestaurante.getMenuBase().get(e);
					var elProductoAjustado = aplicacion.anadirElementos(elProducto, elRestaurante,aplicacion);
					elPedido.agregarProducto(elProductoAjustado);
		
		
							
				}
				if (tipo==2)
				{
					inputScanner.useDelimiter(System.lineSeparator());
					aplicacion.ejecutarMostrarCombo(elRestaurante);
					
					System.out.println("Por favor ingrese el numero del Combo.");
					String pedidot = inputScanner.next();
		
					int e=Integer.parseInt(pedidot);
					var elCombo = elRestaurante.getCombo().get(e-1);
					elPedido.agregarProducto(elCombo);
						
				}
				System.out.println("Quiere añadir otro producto?:"	+ "\n 1. Si "
						+ "\n 2. No");
				int otro = inputScanner.nextInt();
				
				if (otro==2)
				{
					mas=false;
				}
					
				
				
				
	
	}
		}
	private void ejecutarCerrarPedido(Restaurante elRestaurante)
	{
		elRestaurante.cerrarYGuardarPedido();
		idPedido=1+ idPedido;
	}
	private void ejecutarVerPedidoPasado(Restaurante elRestaurante)
	{
		String id =input ("Ingrese el id de su pedido");
		int id1=Integer.parseInt(id);
		;
		for (Pedido i:(elRestaurante.getPedidosCerrados()));
		
		
	}
	
	private String input(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

