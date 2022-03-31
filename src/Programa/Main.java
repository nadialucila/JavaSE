package Programa;
import java.util.Scanner;

import Articulos.*;
import Util.*;
import Usuario.*;

public class Main {

	public static void main(String[] args) {
		/* INICIO CARRITO, CARGAR STOCK, INICIO SCANNER, INICIO-CARGA USUARIOS, INICIO CONTADOR BUCLE (MENU EMPELADOS), INICIO MODULO BANCARIO (CLIENTES) */
		Carrito.getInstance();
		Stock.cargar();
		Usuarios.cargar();
		Modulo mod = new Modulo();
		Scanner sc = new Scanner(System.in);
		int i = 0, j = 0;
		/*BUCLE LOGUEO*/
		while(true) {
			Menues.menuUsuarios();
			String opcionUsuario = sc.next();
			/*REGISTRARSE*/
			if(opcionUsuario.equals("1")) {
				Menues.crearUsuario(sc);
			} 
			/*LOGUEARSE*/
			else if (opcionUsuario.equals("2")) {
				i = 0; 
				Menues.iniciarSesion(sc);
				/*MENU DE EMPLEADOS*/
				if (Usuarios.getInstance().getUsuario(Menues.username).getTipoDeUsuario().toLowerCase().equals("empleado")) {
					while(i == 0) {
						Menues.menuEmpleados();
						switch(sc.next()) {
						case "1" : Menues.empleadosOpcionUno(); break;
						case "2" : Menues.empleadosOpcionDos(sc); break;
						case "3" : Menues.empleadosOpcionTres(sc); break;
						case "4" : Menues.empleadosOpcionCuatro(sc); break;
						case "5": i = 1; break;
						}
					}
				}
				
				else if (Usuarios.getInstance().getUsuario(Menues.username).getTipoDeUsuario().toLowerCase().equals("cliente")) {
					j=0;
					while(j==0) {
						Menues.menuClientes();
						String opcion = sc.next();
						switch(opcion) {
							case "1": Stock.getInstance().verArticulos(); break;
							case "2": Menues.clientesOpcionDos(sc); break;
							case "3": Menues.clientesOpcionTres(); break;
							case "4": Menues.clientesOpcionCuatro(sc); break;
							case "5": Menues.moduloBancarioMenu(sc, mod); break;
							case "6": j = Menues.clientesOpcionSeis(sc); break;	
						}
					}
				}
			} 
			else if (opcionUsuario.equals("3")) {
				System.out.println("Gracias por utilizar nuestro servicio");
				break;
			} 
			else System.err.println("Opción incorrecta.");
		}
	}
}
