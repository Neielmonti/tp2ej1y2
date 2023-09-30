package tp2ej1.EJ2;

import java.util.Calendar;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import com.db4o.query.Constraint;
import com.db4o.query.Query;

public class Main {
	private static Scanner miScanner;
	
	public static void main(String[] args) {
	try {
		miScanner = new Scanner(System.in);
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"db4oej2.db");	
		menuPrincipal(db);
	}catch(Exception ex) {
        System.err.println(ex.getMessage());
    	}
	}	
	
	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}
	
//-----------------------------------------[MENUS]------------------------------------------	
	public static void menuPrincipal (ObjectContainer db) {
		clearConsole();
		System.out.println("-------------[Menu Principal]----------------");
		System.out.println();
		System.out.println("1) Listar Clientes");
		System.out.println("2) Listar Facturas");
		System.out.println("3) Listar Detalles");
		System.out.println("4) Listar Productos");
		System.out.println("5) ABM Clientes");
		System.out.println("6) AMB Facturas");
		System.out.println("7) ABM Detalles");
		System.out.println("8) ABM Productos");
		System.out.println("9) Realizar Consultas");
		System.out.println("0) Salir ");
		System.out.println();
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		
		switch (opcion) {
		case "1": 
			listarCliente(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuPrincipal(db);
			break;
		case "2": 
			listarFactura(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuPrincipal(db);
			break;
		case "3": 
			listarDetalle(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuPrincipal(db);
			break;
		case "4": 
			listarProducto(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuPrincipal(db);
			break;
		case "5": 
			menuABMCliente(db);
			break;
		case "6": 
			menuABMFactura(db);
			break;
		case "7": 
			menuABMDetalle(db);
			break;
		case "8": 
			menuABMProducto(db);
			break;
		case "9": 
			menuConsultas(db);
			break;
		case "0": 
			db.close();
			miScanner.close();
			System.exit(0);
			clearConsole();
			System.out.println("Nos vemos!");
			break;
		default: menuPrincipal(db);	
		}

	}

	public static void menuABMCliente(ObjectContainer db) {
		clearConsole();
		System.out.println("-------------[Menu ABM de CLIENTE]----------------");
		System.out.println();
		System.out.println("1) Listar Clientes");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Principal" );
		System.out.println("Ingrese una opcion");
		String opcion = miScanner.nextLine();
		switch (opcion) {
		case "1":
			listarCliente(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuABMCliente(db);
			break;
		case "2":
			altaCliente(db);
			menuABMCliente(db);
			break;
		case "3":
			bajaCliente(db);
			menuABMCliente(db);
			break;
		case "4":
			modificarCliente(db);
			menuABMCliente(db);
			break;
		case "0" : menuPrincipal(db);
		default: menuABMCliente(db);
		}
	} 

	public static void menuABMFactura (ObjectContainer db) {
		clearConsole();
		System.out.println("-------------[Menu ABM de FACTURA]----------------");
		System.out.println();
		System.out.println("1) Listar Facturas");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
		System.out.println("Ingrese una opcion");
		String opcion = miScanner.nextLine();
		switch (opcion) {
		case "1":
			listarFactura(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuABMFactura(db);
			break;
		case "2":
			altaFactura(db);
			menuABMFactura(db);
			break;
		case "3":
			bajaFactura(db);
			menuABMFactura(db);
			break;
		case "4":
			modificarFactura(db);
			menuABMFactura(db);
			break;
		case "0" : menuPrincipal(db);
		default: menuABMFactura(db);
		}
	}

	public static void menuABMDetalle(ObjectContainer db) {
		clearConsole();
		System.out.println("-------------[Menu ABM de DETALLES]----------------");
		System.out.println();
		System.out.println("1) Listar Detalles");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		switch (opcion) {
		case "1":
			listarDetalle(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuABMDetalle(db);
			break;
		case "2":
			altaDetalle(db);
			menuABMDetalle(db);
			break;
		case "3":
			bajaDetalle(db);
			menuABMDetalle(db);
			break;
		case "4":
			modificarDetalle(db);
			menuABMDetalle(db);
			break;
		case "0" : menuPrincipal(db);
		default: menuABMDetalle(db);
		}
	}

	public static void menuABMProducto(ObjectContainer db) {
		clearConsole();
		System.out.println("-------------[Menu ABM de PRODUCTO]----------------");
		System.out.println();
		System.out.println("1) Listar productos");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Principal" );
		System.out.println("Ingrese una opcion");
		String opcion = miScanner.nextLine();
		switch (opcion) {
		case "1":
			listarProducto(db);
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
			menuABMProducto(db);
			break;
		case "2":
			altaProducto(db);
			menuABMProducto(db);
			break;
		case "3":
			bajaProducto(db);
			menuABMProducto(db);
			break;
		case "4":
			modificarProducto(db);
			menuABMProducto(db);
			break;
		case "0" : menuPrincipal(db);
		default: menuABMProducto(db);
		}
	}

	
	
	public static void menuConsultas (ObjectContainer db) {
		clearConsole();
		System.out.println("---------------[Menu de consultas]----------------");
		System.out.println("1) Listar facturas de un cliente");
		System.out.println("2) Listar facturas finalizadas");
		System.out.println("3) Listar producto con un rango de stock");
		System.out.println("4) Listar detalles de una factura");
		System.out.println("0) Volver al Menu Principal");
		System.out.println("Ingrese Una Opcion");
		String opcion = miScanner.nextLine();
		switch (opcion) {
		case "1":
			listarFacturasdeCliente(db);
			menuConsultas(db);
			break;
		case "2":
			listarFacturasFinalizadas(db);
			menuConsultas(db);
			break;
		case "3":
			listarProductoConStock(db);
			menuConsultas(db);
			break;
		case "4":
			listarDetallesFactura(db);
			menuConsultas(db);
			break;
		case "0":
			menuPrincipal(db);
			break;	
		default: menuConsultas(db);
		}
	}
	
//-----------------------------------------[LISTAR]------------------------------------------	
	public static void listarCliente (ObjectContainer db) {
		clearConsole();
		System.out.println("______________________");
    	System.out.println("Listar Clientes");
    	Query qry = db.query();
    	qry.constrain(Cliente.class);
    	ObjectSet<Factura> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();}
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	public static void listarFactura (ObjectContainer db) {
		clearConsole();
		System.out.println("______________________");
    	System.out.println("Listar Factura");
    	Query qry = db.query();
    	qry.constrain(Factura.class);
    	ObjectSet<Factura> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();
	    }
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	public static void listarDetalle (ObjectContainer db) {
		clearConsole();
		System.out.println("______________________");
    	System.out.println("Listar Detalle");
    	Query qry = db.query();
    	qry.constrain(Detalle.class);
    	ObjectSet<Detalle> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();}
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	public static void listarProducto (ObjectContainer db) {
		clearConsole();
		System.out.println("______________________");
    	System.out.println("Listar Productos");
    	Query qry = db.query();
    	qry.constrain(Producto.class);
    	ObjectSet<Producto> result=qry.execute();
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();}
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	

//-----------------------------------------[ABM CLIENTE]------------------------------------------	

	public static void altaCliente(ObjectContainer db) {
		System.out.println("Ingrese el Id del Cliente");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		ObjectSet<Cliente> resul = db.queryByExample(new Cliente(numero));
		if (resul.size()>0 ){
			System.out.println("Id Existente");}
		else{
			System.out.println("Ingrese el Nombre");
			opcion = miScanner.nextLine();
			Cliente cliente = new Cliente(numero,opcion);
			db.store(cliente); 
			System.out.println("Alta Exitosa");}
		System.out.println("Presione ENTER para continuar");
		miScanner.nextLine();
	}
	
	public static void bajaCliente(ObjectContainer db){
		System.out.println("Ingrese el Id del cliente a dar de baja");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		ObjectSet<Cliente> result = db.queryByExample(new Cliente(numero));
		if (result.size()>0) {
			Cliente cliente = (Cliente) result.next();
			db.delete(cliente);
			System.out.println("Baja exitosa");}
		else{
			System.out.println("Cliente Inexistente");}
		System.out.println("Presione ENTER para continuar");
		miScanner.nextLine();
	}
	
	public static void modificarCliente (ObjectContainer db) {
		System.out.println("Ingrese el Id del cliente a Modificar");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		ObjectSet<Cliente> result = db.queryByExample(new Cliente(numero));
		if (result.size()>0) {
			Cliente cliente = (Cliente) result.next();
			System.out.println("Ingrese nueva descripcion");
			opcion = miScanner.nextLine();
			cliente.setRazonSocial(opcion);
			db.store(cliente);
			System.out.println("Modificacion exitosa");}
		else {
			System.out.println("Id inexistente");}
		System.out.println("Presione ENTER para continuar");
		miScanner.nextLine();
	}

//-----------------------------------------[ABM FACTURA]------------------------------------------		
	public static void altaFactura (ObjectContainer db) {
		System.out.println("Ingrese Id Factura");
		String opcion = miScanner.nextLine();
		int numeroFac = Integer.parseInt(opcion);
		System.out.println("Ingrese el Id del cliente");
		opcion = miScanner.nextLine();
		int numeroId = Integer.parseInt(opcion);
		ObjectSet<Cliente> resul = db.queryByExample(new Cliente(numeroId));
		
		if (resul.size()>0) {
			Cliente cliente = (Cliente)resul.next();
			Query qry = db.query();
			qry.constrain(Factura.class);
			qry.descend("idFactura").constrain(numeroFac);
			ObjectSet<Factura> resulFactura = qry.execute(); 
			
			if (resulFactura.size()==0) {
				Calendar fecha = Calendar.getInstance();
				Factura factura = new Factura(numeroFac,fecha.getTime());
				factura.setCliente(cliente);
				db.store(factura);
				System.out.println("Alta Exitosa");
				System.out.println();
				
			}else {
				System.out.println("Factura existente");	
				} 
			
		}else {
			System.out.println("Cliente inexistente");
		}
		System.out.println("Presione ENTER para continuar");
		miScanner.nextLine();
	}
	
	
	public static void bajaFactura (ObjectContainer db) {
		System.out.println("Ingrese el Id de la Factura");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		
		Query qryFac = db.query();
		qryFac.constrain(Factura.class);
		qryFac.descend("idFactura").constrain(numero);
		ObjectSet<Factura> result = qryFac.execute();

		if (result.size()>0) {
			Factura factura = result.next();
			Query qry = db.query();
			qry.constrain(Detalle.class);
			qry.descend("idFactura").constrain(factura);
			ObjectSet<Detalle> resultDetalle = qry.execute();
	
				while (resultDetalle.hasNext()) {
					Detalle detalle = resultDetalle.next();
					if (factura.getEstado() == Estado.INICIALIZADA) {
						Query qry1 = db.query();
						qry1.constrain(Producto.class);
						qry1.constrain(detalle.getIdProducto());
						ObjectSet<Producto> resultproductos = qry1.execute();

						while (resultproductos.hasNext()) {
							int stock = 0;
							Producto producto = (Producto) resultproductos.next();
							stock = producto.getStock() + detalle.getCantidad(); 
							producto.setStock(stock);
							db.store(producto);
							}
						}
					db.delete(detalle);
			}
			db.delete(factura);
			System.out.println("Eliminacion exitosa");
			System.out.println("");
		}else {
				System.out.println("Factura inexistente");
			  }
		System.out.println("Presione ENTER para continuar");
		miScanner.nextLine();
	}
	
	public static void modificarFactura (ObjectContainer db) {
		System.out.println("Ingrese el Id de la Factura");
		String opcion = miScanner.nextLine();
		int numero = Integer.parseInt(opcion);
		
		ObjectSet<Factura> result = db.queryByExample(new Factura(numero));
		if (result.size()>0) {
			Factura factura = result.next();
			System.out.println("Desea Cambiar Estado a FINALIZADA?");
			System.out.println("1) Si");
			System.out.println("0) NO");
			opcion = miScanner.nextLine();
			if (Integer.parseInt(opcion) == 1) {
				factura.setEstado(Estado.FINALIZADA);
				db.store(factura);
				System.out.println("Modificacion exitosa");}}
		else {
			System.out.println("Id inexistente");}
		System.out.println("Presione ENTER para continuar");
		miScanner.nextLine();
	}
	
//-----------------------------------------[ABM DETALLE]------------------------------------------		
	public static void altaDetalle (ObjectContainer db) {
		System.out.println("Ingrese Id Factura");
		String opcion = miScanner.nextLine();
		int idFactura = Integer.parseInt(opcion);
		ObjectSet<Factura> resultFactura = db.queryByExample(new Factura(idFactura));
		if (resultFactura.size()>0) {
				Factura factura = resultFactura.next();
				System.out.println("Ingrese Id Producto");
				opcion = miScanner.nextLine();
				int idProducto = Integer.parseInt(opcion);
				ObjectSet<Producto> resultProducto = db.queryByExample(new Producto(idProducto));
				if (resultProducto.size()>0) {
					Producto producto = resultProducto.next();
					Query qry = db.query();
					qry.constrain(Detalle.class);
					qry.descend("idFactura").constrain(factura).and(qry.descend("idProducto").constrain(producto));
					ObjectSet<Detalle> resultDetalle = qry.execute();
					if (resultDetalle.size()==0) {
						System.out.println("Ingrese Cantidad de Producto");
						opcion = miScanner.nextLine();
						
						int stock = Integer.parseInt(opcion);
						if (stock>0) {
							if (stock <= producto.getStock()){
								int totalStock = producto.getStock() - stock;
								System.out.println("Ingrese Precio de Producto");
								opcion = miScanner.nextLine();
								
								float precio = Float.parseFloat(opcion);
								if (precio >= producto.getPrecioBase()) {
									float totalFac = factura.getImporte() + (stock*precio);
									factura.setImporte(totalFac);
									producto.setStock(totalStock);
									Detalle detalle = new Detalle (factura,producto,stock,precio);
									db.store(factura);
									db.store(producto);
									db.store(detalle);
									System.out.println("Alta exitosa");
									System.out.println("");

								}else {
									System.out.println("Precio menor al precio base del producto");
								}
								
							}else {
								System.out.println("Stock insuficiente");
							}
								
						}else {
							System.out.println("El stock no puede ser negativo");
						}

					}else {
						System.out.println("Detalle existente");
					}

				}else {
					System.out.println("Producto inexistente");
				}
		}else {
			System.out.println("Factura inexistente");
			} 
		System.out.println("Presione ENTER para continuar");
		miScanner.nextLine();
		}
			
	 public static void bajaDetalle (ObjectContainer db) {
			System.out.println("Ingrese el Id del detalle a eliminar ");
			String opcion = miScanner.nextLine();
			int idDetalle = Integer.parseInt(opcion);
			
			System.out.println("Ingrese el Id del producto a eliminar ");
			opcion = miScanner.nextLine();
			int idProducto = Integer.parseInt(opcion);
			
			Query qry = db.query();
			
			qry.constrain(Detalle.class);
			/*
			qry.descend("idFactura").constrain(new Factura(idDetalle)).and(qrypro.constrain(new Producto(idProducto)));
			*/
			
			Constraint qrypro = qry.descend("idProducto").descend("id").constrain(idProducto);
			qry.descend("idFactura").descend("idFactura").constrain(idDetalle).and(qrypro);
			
			ObjectSet<Detalle> resultDetalle = qry.execute();
			
			if (resultDetalle.size()>0) {
				Detalle detalle = resultDetalle.next();
				Query qryFac = db.query();
				qryFac.constrain(Factura.class);
				qryFac.descend("idFactura").constrain(idDetalle);
				ObjectSet<Factura> resultFactura = qryFac.execute();
				System.out.println("Longitud de resultados de FACTURA"+ resultFactura.size());
				Factura factura = resultFactura.next();
				
				System.out.println("Id Producto: "+ idProducto);
				
				Query qryPro = db.query();
				qryPro.constrain(Producto.class);
				qryPro.descend("id").constrain(idProducto);
				ObjectSet<Producto> resultProducto = qryPro.execute();
				System.out.println("Longitud de resultados de PRODUCTO"+ resultProducto.size());
				
				Producto producto = resultProducto.next();
				
				if (factura.getEstado() == Estado.INICIALIZADA) {
					int stocktotal = producto.getStock() + detalle.getCantidad();
					float importeTotal = factura.getImporte() - (detalle.getCantidad()*detalle.getPrecio());
					producto.setStock(stocktotal);
					factura.setImporte(importeTotal);
					db.store(producto);
					db.store(factura);
					db.delete(detalle);
					System.out.println("Baja exitosa");
				}else {
					System.out.println("No se puede dar baja el detalle, Factura FINALIZADA");
					}
			}else {
				System.out.println("Detalle Inexistente");
			}
			System.out.println("Presione ENTER para continuar");
			miScanner.nextLine();
	 }
	 
		
	 public static void modificarDetalle (ObjectContainer db) {
		 	
			System.out.println("Ingrese el Id de la factura del detalle a modificar ");
			String opcion = miScanner.nextLine();
			int idDetalle = Integer.parseInt(opcion);
			System.out.println("Ingrese el Id del producto del detalle a modificar ");
			opcion = miScanner.nextLine();
			int idProducto = Integer.parseInt(opcion);
			
			Query qry = db.query();
			qry.constrain(Detalle.class);
			qry.descend("idFactura").constrain(new Factura(idDetalle)).and(qry.descend("idProducto").constrain(new Producto(idProducto)));
			
			ObjectSet<Detalle> resultDetalle = qry.execute();
			
			System.out.println(""+resultDetalle.size());
			if (resultDetalle.size()>0) {
				 
				Detalle detalle = resultDetalle.next();
				Query qryFac = db.query();
				qryFac.constrain(Factura.class);
				qryFac.descend("idFactura").constrain(idDetalle);
				ObjectSet<Factura> resultFactura = qryFac.execute();
				Factura factura = resultFactura.next();
				
				System.out.println("FACTURA "+factura);
				Query qryPro = db.query();
				qryPro.constrain(Producto.class);
				qryPro.constrain(new Producto(idProducto));
				ObjectSet<Producto> resultProducto = qryPro.execute();
				Producto producto = resultProducto.next();
				
				if (factura.getEstado() == Estado.INICIALIZADA) {
					subMenuModificacion(producto,detalle,factura);
					db.store(producto);
					db.store(factura);
					db.store(detalle);
					System.out.println("Modificacion exitosa");
				}else {
					System.out.println("No se puede modificar el detalle, Factura FINALIZADA");
					}
			}else {
				System.out.println("Detalle inexistente");
			}
			System.out.println("Presione ENTER para continuar");
			miScanner.nextLine();
	 }
	 
	 private static void subMenuModificacion (Producto producto, Detalle detalle,Factura factura) {
		 	
		 	System.out.println("Ingrese el Id del producto a modificar ");
			System.out.println("1) Cantidad ");
			System.out.println("2) Precio");
			System.out.println("");
			String opcion = miScanner.nextLine();
			switch (opcion) {
			case "1":
				System.out.println("Ingrese Cantidad ");
				opcion = miScanner.nextLine();
				int cantidad = Integer.parseInt(opcion);
				
				if (cantidad > 0) {
					if (cantidad <= producto.getStock()) {
						float importetotal;
						int stocktotal;
						if (cantidad>detalle.getCantidad()) {
							cantidad = cantidad -detalle.getCantidad();
							 importetotal = factura.getImporte() + (detalle.getPrecio()*cantidad);
							 stocktotal = producto.getStock() - cantidad;
						}else {
								cantidad = detalle.getCantidad()- cantidad;
								importetotal = factura.getImporte() - (detalle.getPrecio()*cantidad);
							    stocktotal = producto.getStock() + cantidad;
							  }
						factura.setImporte(importetotal);
						producto.setStock(stocktotal); 
					}else {
						System.out.println("Stock insuficiente");
						}
				}else {
						System.out.println("Cantidad invalida");
						}
					break;
			
			case "2": 
				System.out.println("Ingrese precio");
				opcion = miScanner.nextLine();
				int precio = Integer.parseInt(opcion);
				if ((precio < 0) || (precio < producto.getPrecioBase())){
					System.out.println("Precio invalido");
				}
				producto.setPrecioBase(precio);
				break;
			default: subMenuModificacion(producto,detalle,factura);	
			}
			System.out.println("Presione ENTER para continuar");
			miScanner.nextLine();
	 }
//-----------------------------------------[ABM PRODUCTO]------------------------------------------		

	 public static void altaProducto(ObjectContainer db) {
			
			System.out.println("Ingrese Id Producto");
			String opcion = miScanner.nextLine();
			int numero = Integer.parseInt(opcion);

			ObjectSet<Producto> resul = db.queryByExample(new Producto(numero));
			
			if (resul.size()>0 ){
				System.out.println("Id existente");
			}else
				{
					
				System.out.println("Descripcion");
				String descripcion = miScanner.nextLine();
				
				System.out.println("Stock");
				opcion = miScanner.nextLine();
				int stock = Integer.parseInt(opcion);
				if (stock <0) {
					System.out.println("Stock no permitido");
				}
				
				System.out.println("Precio base");
				opcion = miScanner.nextLine();
				float precio = Float.parseFloat(opcion);
				if (precio <0) {
					System.out.println("Precio no permitido");
				}
				
				Producto producto = new Producto(numero,descripcion,stock,precio);
				db.store(producto); 
				System.out.println("Alta exitosa");
				}
			System.out.println("Presione ENTER para continuar");
			miScanner.nextLine();
		}
		
		public static void bajaProducto (ObjectContainer db){
			
			System.out.println("Ingrese el Id del producto a eliminar");
			String opcion = miScanner.nextLine();
			int numero = Integer.parseInt(opcion);
			
			ObjectSet<Producto> result = db.queryByExample(new Producto(numero));
			
			if (result.size()>0) {
				Producto producto= (Producto) result.next();
				db.delete(producto);

				System.out.println("Eliminacion exitosa");
				System.out.println("");
			}else {
					System.out.println("Cliente inexistente");
				  }
			System.out.println("Presione ENTER para continuar");
			miScanner.nextLine();
		}
		
		public static void modificarProducto (ObjectContainer db){
			
			System.out.println("Ingrese el Id del producto a modificar");
			String opcion = miScanner.nextLine();
			int numero = Integer.parseInt(opcion);
			
			ObjectSet<Producto> result = db.queryByExample(new Producto(numero));
			if (result.size()>0) {
				Producto producto = (Producto) result.next();
				subMenuModicacionModificacionProducto(producto);
				
				db.store(producto);
				
				System.out.println("Modificacion exitosa");
				System.out.println("");
			}else {
					System.out.println("Cliente inexistente");
				  }
			System.out.println("Presione ENTER para continuar");
			miScanner.nextLine();
		}



		private static void subMenuModicacionModificacionProducto(Producto producto) {
		
		 	System.out.println("Ingrese el Id del Producto a Modificar ");
			System.out.println("1) Descripcion");
			System.out.println("2) Cantidad ");
			System.out.println("3) Precio");
			System.out.println("0) Salir y confirmar");
			System.out.println("");
			String opcion = miScanner.nextLine();
			switch (opcion) {
			case "1":
				System.out.println("Ingrese la nueva descripcion");
				System.out.println("");
				opcion = miScanner.nextLine();
				producto.setDescripcion(opcion);
				subMenuModicacionModificacionProducto(producto);
				break;
				
			case "2":

				System.out.println("Ingrese el nuevo stock");
				System.out.println("");
				opcion = miScanner.nextLine();
				int stock = Integer.parseInt(opcion);
				if (stock >0) {
					producto.setStock(stock);
				}
				subMenuModicacionModificacionProducto(producto);
				break;
				
			case "3":
				System.out.println("Ingrese el nuevo precio");
				System.out.println("");
				opcion = miScanner.nextLine();
				float precio = Float.parseFloat(opcion);
				if (precio >0) {
					producto.setPrecioBase(precio);
				}
				subMenuModicacionModificacionProducto(producto);
				break;
				
			case "0": 
				break;		
			}
		}



//-----------------------------------------[Consultas]------------------------------------------	

		private static void listar (ObjectSet result) {
			System.out.println("______________________");
		  while(result.hasNext()) {
		        System.out.println(result.next());
		        System.out.println();
		    }
	        System.out.println("");
	        System.out.println("______________________");
	        System.out.println("");
	    }
		
		public static void listarFacturasdeCliente(ObjectContainer db) {
		 	System.out.println("Ingrese Id que desea Saber las Facturas ");
		 	int idCliente = Integer.parseInt(miScanner.nextLine());
		    Query qryFac = db.query();
		 	qryFac.constrain(Factura.class);
		 	qryFac.descend("cliente").descend("id").constrain(idCliente);
		 	ObjectSet<Factura> resultFacturas = qryFac.execute();
		 	System.out.println("Facturas Del Cliente : "+ idCliente);
		 	System.out.println("");

		 	if (resultFacturas.size()>0) {
			 	listar(resultFacturas);	
		 	}else {
		 		System.out.println("El cliente no tiene facturas ");
		 		System.out.println();
		 		  }
		 	System.out.println("Presione enter para continuar.");
		 	miScanner.nextLine();
		}

		public static void listarFacturasFinalizadas(ObjectContainer db) {
			Query qryFac = db.query();
		 	qryFac.constrain(Factura.class);
		 	qryFac.descend("estado").constrain(Estado.FINALIZADA);
		 	ObjectSet<Factura> resultFacturas = qryFac.execute();
		 	System.out.println("Facturas con estado finalizado : ");
		 	System.out.println("");
		 	
		 	if (resultFacturas.size()>0) {
			 	listar(resultFacturas);	
		 	}else {
		 		System.out.println("No hay facturas finalizadas");
		 		System.out.println();
		 		  }
		 	System.out.println("Presione enter para continuar.");
		 	miScanner.nextLine();
		}
		
		public static void listarProductoConStock (ObjectContainer db) {
			System.out.println("Ingrese un stock minimo ");
		 	float min = Float.parseFloat(miScanner.nextLine());
		 	System.out.println("Ingrese un stock maximo ");
		 	float max = Float.parseFloat(miScanner.nextLine());
		 	
		 	Query qryPro = db.query();
		 	qryPro.constrain(Producto.class);
		 	qryPro.descend("stock").constrain(min).greater().and(qryPro.descend("stock").constrain(max).smaller());
		 	ObjectSet<Producto> resultProductos = qryPro.execute();
		 	System.out.println("Productos con stock mayor a : "+min + "  y menor a : "+max);
		 	System.out.println("");
		 	if (resultProductos.size()>0) {
		 		clearConsole();
			 	listar(resultProductos);	
		 	}else {
		 		System.out.println("No hay productos con dicho stock");
		 		System.out.println();
		 		  }
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
		}
		
		public static void listarDetallesFactura(ObjectContainer db) {
		 	System.out.println("Ingrese el id de la factura de la que quiere conocer los detalles ");
		 	int idFactura = Integer.parseInt(miScanner.nextLine());
		    Query qryDet = db.query();
		 	qryDet.constrain(Detalle.class);
		 	qryDet.descend("idFactura").descend("idFactura").constrain(idFactura);
		 	ObjectSet<Factura> resultDetalles = qryDet.execute();
		 	System.out.println("Detalles de la factura : "+ idFactura);
		 	System.out.println("");
		 	
		 	if (resultDetalles.size()>0) {
			 	listar(resultDetalles);	
		 	}else {
		 		System.out.println("La factura ingresada no tiene detalles.");
		 		System.out.println();
		 		  }
		 	System.out.println("Presione ENTER para continuar.");
		 	miScanner.nextLine();
		}
}

