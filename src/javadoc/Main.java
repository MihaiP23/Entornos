package javadoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

	public class Main {
		static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

		public static void main(String[] args) {
			CCuenta cuenta1;
			double saldoActual;
			int opcion = 0;
			cuenta1 = new CCuenta("Juan L�pez", "1000-2365-85-123456789", 2500, 0);
			do {
				try {
					System.out.println("MEN� DE OPERACIONES");
					System.out.println("-------------------");
					System.out.println("1 - Ingresar");
					System.out.println("2 - Retirar");
					System.out.println("3 - Finalizar");
					opcion = Integer.parseInt(dato.readLine());
					if (opcion == 1) {
						System.out.println("�Cu�nto desea ingresar?: ");
						float ingresar = Integer.parseInt(dato.readLine());
						operativa_cuenta(cuenta1, ingresar, opcion);
					} else if (opcion == 2) {
						System.out.println("�Cu�tno desea retirar?: ");
						float retirar = Integer.parseInt(dato.readLine());
						operativa_cuenta(cuenta1, retirar, opcion);
					} else if (opcion == 3) {
						System.out.println("Finalizamos la ejecuci�n");
					} else {
						System.err.println("Opci�n err�nea");
					}
	/*               switch(opcion){
	                case 1:
	                    System.out.println("�Cu�nto desea ingresar?: ");
	                    float ingresar=Integer.parseInt(dato.readLine());
	                    operativa_cuenta(cuenta1,ingresar,opcion);
	                    break;
	                case 2:
	                    System.out.println("�Cu�tno desea retirar?: ");
	                    float retirar=Integer.parseInt(dato.readLine());
	                    operativa_cuenta(cuenta1,retirar,opcion);
	                    break;
	                case 3:
	                    System.out.println("Finalizamos la ejecuci�n");
	            }
	*/
				} catch (IOException ex) {
					System.out.println("Error: " + ex.getMessage());
				}
			} while (opcion != 3);
			saldoActual = cuenta1.estado();
			System.out.println("El saldo actual es: " + saldoActual);
		}

		public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
			if (opcion == 2) {
				try {
					cuenta1.retirar(cantidad);
					/**
					 * si queremos sacar m�s dinero del que tenemos, nos saldr� un fallo
					 */
				} catch (Exception e) {
					System.out.println("Fallo al retirar");
				}
			} else if (opcion == 1) {
				/**
				 * Ingresamos dinero
				 */
				try {
					System.out.println("Ingreso en cuenta");
					cuenta1.ingresar(cantidad);
					/**
					 * Si la cantidad es negativa, nos da fallo
					 */
				} catch (Exception e1) {
					System.out.println("Fallo al ingresar");
				}
			}
		}
	}


