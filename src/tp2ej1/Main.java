package tp2ej1;

import java.io.File;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Main {
	private static Scanner entrada;
	
	public static void main(String[] args) {
		File archivo= new File("db4o.db");
		
		if (archivo.exists()) {
			//ejecuto el main con el case
			entrada = new Scanner(System.in);
			ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"db4o.db");
			//llamo al menu principal pasandole la bd
			menu(bd);
		} else {
			//creo el archivo de bd
			new File("db4o.db");
			entrada = new Scanner(System.in);
			ObjectContainer bd=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"db4o.db");
			//ahora con la base de datos creada ejecutamos el menu principal con la bd
			menu(bd);
		}
	}

	public static void menu(ObjectContainer bd) {
		System.out.println("-------------[ MENU ]----------------");
		System.out.println();
		System.out.println("1) Listar Clientes");
		System.out.println("2) Listar Facturas");
		System.out.println("3) ABM Clientes");
		System.out.println("4) AMB Facturas");
		System.out.println("5) Realizar Consultas");
		System.out.println("0) Salir ");
		System.out.println();
		
		System.out.println("Ingrese Una Opcion");
		String opcion = entrada.nextLine();
		
		switch (opcion) {
		case "1": 
			listarCliente(bd);
			menu(bd);
			break;
		case "2": 
			listarFacturas(bd);
			menu(bd);
			break;
		case "3": 
			menuABMCliente(bd);
			break;
		case "4": 
			menuABMFactura(bd);
			break;
		case "5": 
			menuConsultas(bd);
			break;
		case "0": 
			bd.close();
			entrada.close();
			System.exit(0);
			break;
		default: menu(bd);	
		}
	}
	
	public static void menuABMFactura (ObjectContainer bd) {
		System.out.println("-------------[ MENU ABM FACTURAS]----------------");
		System.out.println();
		System.out.println("1) Listar Facturas");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
		System.out.println("Ingrese Una Opcion");
		
		String opcion = entrada.nextLine();
		
		switch (opcion) {
		
		case "1":
			listarFacturas(bd);
			menuABMFactura(bd);
			break;
		case "2":
			altaFactura(bd);
			menuABMFactura(bd);
			break;
		case "3":
			bajaFactura(bd);
			menuABMFactura(bd);
			break;
		case "4":
			modificarFactura(bd);
			menuABMFactura(bd);
			break;
		case "0" : menu(bd);
		default: menuABMFactura(bd);
		}
	}
	
	public static void menuABMCliente(ObjectContainer bd) {
		System.out.println("-------------[ MENU ABM CLIENTE]----------------");
		System.out.println();
		System.out.println("1) Listar Clientes");
		System.out.println("2) Alta ");
		System.out.println("3) Baja");
		System.out.println("4) Modificacion");
		System.out.println("0) Volver al Menu Anterior" );
		System.out.println("Ingrese Una Opcion");
		String opcion = entrada.nextLine();
		switch (opcion) {
		case "1":
			listarCliente(bd);
			menuABMCliente(bd);
			break;
		case "2":
			altaCliente(bd);
			menuABMCliente(bd);
			break;
		case "3":
			bajaCliente(bd);
			menuABMCliente(bd);
			break;
		case "4":
			modificarCliente(bd);
			menuABMCliente(bd);
			break;
		case "0" : menu(bd);
		default: menuABMCliente(bd);
		}
	}
	
	public static void menuConsultas (ObjectContainer db) {
		System.out.println("-------------[MENU CONSULTAS]----------------");
		System.out.println("1) Ordenar Facturas de Manera Ascendente");
		System.out.println("2) Ordenar Facturas de Manera Descendente");
		System.out.println("3) Listar Facturas de un Cliente ");
		System.out.println("4) Seleccionar Facturas con un importe especifico ");
		System.out.println("5) Ordenar Clientes de Manera Ascendente");
		System.out.println("6) Ordenar Clientes de Manera Descendente");
		System.out.println("0) Volver Al Menu Anterior");
		System.out.println("Ingrese Una Opcion");
		String opcion = entrada.nextLine();
		switch (opcion) {
		case "1":
			ordenarFacturasAscenId(db);
			menuConsultas(db);
			break;
		case "2":
			ordenarFacturasDescenId(db);
			menuConsultas(db);
			break;
		case "3":
			listarFacturasCliente(db);
			menuConsultas(db);
			break;
		case "4":
			seleccionImporteFactura(db);
			menuConsultas(db);
			break;
		case "5":
			ordenarClientesAscenId(db);
			menuConsultas(db);
			break;
		case "6":
			ordenarClientesDescenId(db);
			menuConsultas(db);
			break;
		case "0":
			menu(db);
			break;		
		default: menuConsultas(db);
		}
	}
	
	public static void listarCliente (ObjectContainer db) {
    	System.out.println("Listar Clientes");
    	CLIENTE proto = new CLIENTE();
        ObjectSet<CLIENTE> result = db.queryByExample(proto);
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();
	    }
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	public static void listarFacturas (ObjectContainer db) {
    	System.out.println("Listar Facturas");
    	FACTURA proto=new FACTURA();
        ObjectSet<FACTURA> result = db.queryByExample(proto);
        
        while(result.hasNext()) {
	        System.out.println(result.next());
	        System.out.println();
	    }
        System.out.println("");
        System.out.println("______________________");
        System.out.println("");
    }
	
	// ABM CLIENTE
	
	public static void altaCliente(ObjectContainer db) {
		
		System.out.println("Ingrese Id Cliente");
		String opcion = entrada.nextLine();
		int numero = Integer.parseInt(opcion);

		ObjectSet<CLIENTE> resul = db.queryByExample(new CLIENTE(numero));
		
		if (resul.size()>0 ){
			System.out.println("Id Existente");
		}else
			{
				
			System.out.println("Ingrese Nombre");
			opcion = entrada.nextLine();
			CLIENTE cliente = new CLIENTE(numero,opcion);
			//Guardamos un Cliente en la BD
			db.store(cliente); 
			}
	}
	
	public static void bajaCliente(ObjectContainer db){
	
		System.out.println("Ingrese Id A Eliminar");
		String opcion = entrada.nextLine();
		int numero = Integer.parseInt(opcion);
		ObjectSet<CLIENTE> result = db.queryByExample(new CLIENTE(numero));
		
		if (result.size()>0) {
			CLIENTE cliente = (CLIENTE) result.next();
			db.delete(cliente);
		}else {
				System.out.println("Cliente Inexistente");
			  }

	}
	
	public static void modificarCliente (ObjectContainer db) {

		System.out.println("Ingrese Id A Modificar");
		String opcion = entrada.nextLine();
		int numero = Integer.parseInt(opcion);
		
		ObjectSet<CLIENTE> result = db.queryByExample(new CLIENTE(numero));
		
		if (result.size()>0) {
		CLIENTE cliente = (CLIENTE) result.next();
		System.out.println("Ingrese Nueva Descripcion");
		opcion = entrada.nextLine();
		cliente.setDescripcion(opcion);
		db.store(cliente);
		}else {
			System.out.println("Id inexistente");
		}
	}
	
	// ABM FACTURA
	public static void altaFactura (ObjectContainer db) {
		System.out.println("Ingrese Id Factura");
		String opcion = entrada.nextLine();
		
		int numeroFac = Integer.parseInt(opcion);
		
		System.out.println("Ingrese Id CLiente");
		opcion = entrada.nextLine();
		
		int numeroId = Integer.parseInt(opcion);
		// Primero ingreamos el id del cliente para asignarlo a una factura,pero debe de existir
		
		ObjectSet<CLIENTE> resul = db.queryByExample(new CLIENTE(numeroId));
		
		if (resul.size()>0) {
			//el cliente existe, por lo tanto podemos craer la factura si no existe ya ese id
			CLIENTE cliente = (CLIENTE) resul.next();
			
			resul = db.queryByExample(new FACTURA(numeroFac));
			if (resul.size()==0) {
				//No existe esa factura, por lo tanto podemos crearla
				//seteamos a la factura el cliente que encontramos con el id.
				FACTURA factura = new FACTURA(numeroFac);
				factura.setCliente(cliente);
				db.store(factura);
				System.out.println("Alta Exitosa!!");
			}else {
				System.out.println("Factura Existente");	
				} 
			
		}else {
			System.out.println("Cliente Inexistente");
		}
	}
	
	
	public static void bajaFactura (ObjectContainer db) {

		System.out.println("Ingrese Id Factura");
		String opcion = entrada.nextLine();
		int numero = Integer.parseInt(opcion);
		
		ObjectSet<FACTURA> result = db.queryByExample(new FACTURA(numero));
		
		if (result.size()>0) {
			FACTURA factura = (FACTURA) result.next();
			db.delete(factura);
		}else {
				System.out.println("Factura Inexistente");
			  }
		
	}
	
	public static void modificarFactura (ObjectContainer db) {
		
		System.out.println("Ingrese Id Factura");
		String opcion = entrada.nextLine();
		
		int numeroFac = Integer.parseInt(opcion);
		
		ObjectSet<FACTURA> result = db.queryByExample(new FACTURA(numeroFac));
		
		if (result.size()>0) {
			//existe la factura
			FACTURA factura = (FACTURA)result.next();
			System.out.println("Ingrese Monto Factura");
			opcion = entrada.nextLine();
			float monto = Float.parseFloat(opcion);
			if (monto>0) {
				factura.setImporte(monto);
				db.store(factura);
			}else {
				System.out.println("No puede ser monto negativo");
			}
				
		}
		
		
	}

	//CONSULTAS
	public static void ordenarFacturasAscenId (ObjectContainer db){
		Query qry = db.query();
		qry.constrain(FACTURA.class);
		qry.descend("nro").orderAscending();
		ObjectSet<FACTURA> result = qry.execute();
		listar(result);
	}
	
	public static void ordenarFacturasDescenId (ObjectContainer db) {
		Query qry = db.query();
		qry.constrain(FACTURA.class);
		qry.descend("nro").orderDescending();
		ObjectSet<FACTURA> result=qry.execute();
		listar(result);
	}
	public static void listarFacturasCliente (ObjectContainer db) {
		System.out.println("Ingrese Id del cliente A listar Facturas");
		String opcion = entrada.nextLine();
		
		ObjectSet<CLIENTE> result = db.queryByExample(new CLIENTE(Integer.parseInt(opcion)));
		if (result.size()>0) {
			  CLIENTE cliente = (CLIENTE)result.next();
			  
			  Query qry = db.query();
			  qry.constrain(FACTURA.class);
			  // db.queryByExample(new FACTURA(new cliente)) probar
			  qry.descend("cliente").constrain(cliente);
			  result = qry.execute();
			  listar(result);  
		}else {
			System.out.println("Cliente Inexistente!!");
		}
	}
	public static void seleccionImporteFactura (ObjectContainer db) {
		System.out.println("Ingrese Importe, Mostara las facturas con el Importe Ingresado");
		
		String opcion = entrada.nextLine();
		float numero = Float.parseFloat(opcion);
		if (numero >= 0) {
		Query qry = db.query();
		qry.constrain(FACTURA.class);
		qry.descend("importe").constrain(numero);
		ObjectSet<FACTURA> result= qry.execute();
		listar(result);
		} else {
			System.out.println("Dato incorrecto");
		}
	}
	public static void ordenarClientesAscenId (ObjectContainer db){
		Query qry = db.query();
		qry.constrain(CLIENTE.class);
		qry.descend("id").orderAscending();
		ObjectSet<CLIENTE> result = qry.execute();
		listar(result);
	}
	public static void ordenarClientesDescenId (ObjectContainer db) {
		Query qry = db.query();
		qry.constrain(CLIENTE.class);
		qry.descend("id").orderDescending();
		ObjectSet<CLIENTE> result=qry.execute();
		listar(result);
	}
	public static void listar (ObjectSet<?> result) {
		 while(result.hasNext()) {
		        System.out.println(result.next());
		    }
	        System.out.println("");
	        System.out.println("______________________");
	        System.out.println("");
	}
	
	
	
}
