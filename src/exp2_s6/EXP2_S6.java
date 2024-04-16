
package exp2_s6;

import java.util.Scanner;

public class EXP2_S6 {
  
  class variablesGlobales {
    static String nombreTeatro = "Teatro Moro";
    static int capacidadAsientosTeatro = 225;
    static int capacidadAsientosVIP = 25;
    static int capacidadAsientosPlateaBaja = 50;
    static int capacidadAsientosPlateaAlta = 75 ;
    static int capacidadAsientosPalco = 75;
    static int opcionMenu = 0;
  }
  
  static int asientosOcupadosVIP = (int)(Math.random() * 25 + 1);
  static int asientosOcupadosPlateaBaja = (int)(Math.random() * 50 + 1);
  static int asientosOcupadosPlateaAlta = (int)(Math.random() * 75 + 1);
  static int asientosOcupadosPalco = (int)(Math.random() * 75 + 1);
  
  static int asientosDisponiblesVIP = variablesGlobales.capacidadAsientosVIP - asientosOcupadosVIP;
  static int asientosDisponiblesPlateaBaja = variablesGlobales.capacidadAsientosPlateaBaja - asientosOcupadosPlateaBaja;
  static int asientosDisponiblesPlateaAlta = variablesGlobales.capacidadAsientosPlateaAlta - asientosOcupadosPlateaAlta;
  static int asientosDisponiblesPalco = variablesGlobales.capacidadAsientosPalco - asientosOcupadosPalco;
  static int totalPagarEntradas = 0;
  static int entradasVendidas = 0;
  
  static int cantidadEntradasParaComprar = 0;
  
  public static void main(String[] args) {

    Scanner entradaUsuario = new Scanner(System.in);
    
    /* MENU GESTION ENTRADAS */
    do {
      System.out.println("-----------------------------------------------------------");
      System.out.println("MENÚ VENTA ENTRADAS " + variablesGlobales.nombreTeatro.toUpperCase());
      System.out.println("-----------------------------------------------------------");
      System.out.println("Ingresa en número correspondiente a la acción que quieres realizar.");
      System.out.println("[1]Revisar asientos disponibles");
      System.out.println("[2]Comprar Entradas");
      System.out.println("[3]Salir");
      System.out.println("-----------------------------------------------------------");

      variablesGlobales.opcionMenu = entradaUsuario.nextInt();
      
      if(variablesGlobales.opcionMenu < 1 || variablesGlobales.opcionMenu > 3){
        System.out.println("Has ingresado un número incorrecto para ejecutar la acción");
      }
      
    } while ( variablesGlobales.opcionMenu < 1 || variablesGlobales.opcionMenu > 3 );
    
    
    do{
      int opcionUbicacion = 0;
      int precioEntrada = 0;
      String ubicacionTexto = "";
      int totalResumen = 0;
      
      switch ( variablesGlobales.opcionMenu ) {
        
        // ENTRADAS DISPONIBLES
        case 1:
          System.out.println("\nAsientos disponibles");
          System.out.println("---------------------------");
          System.out.println("El " + variablesGlobales.nombreTeatro + " tiene una capacidad de: " + variablesGlobales.capacidadAsientosTeatro + " asientos");
          System.out.println("Para la zona VIP existe una disponibilidad de: " + asientosDisponiblesVIP + " asientos");
          System.out.println("Para Platea Baja existe una disponibilidad de: " + asientosDisponiblesPlateaBaja + " asientos");
          System.out.println("Para Platea Alta existe una disponibilidad de: " + asientosDisponiblesPlateaAlta + " asientos");
          System.out.println("Para Palco existe una disponibilidad de: " + asientosDisponiblesPalco + " asientos");
          
          do {
            System.out.println("\n[2]Comprar entradas [3]Salir");
            variablesGlobales.opcionMenu = entradaUsuario.nextInt();
            if(variablesGlobales.opcionMenu != 2 && variablesGlobales.opcionMenu != 3){
              System.out.println("Has ingresado un número incorrecto. Intenta nuevamente");
            }
          
          } while (variablesGlobales.opcionMenu != 2 && variablesGlobales.opcionMenu != 3);
          
          break;
        
        // COMPRAR ENTRADAS  
        case 2:
          do {
            System.out.println("\nElige la ubicación");
            System.out.println("Ingresa el número correspondiente a la ubicación");
            System.out.println("------------------------------------------------");
            System.out.println("[1]VIP [2]Platea Baja [3]Platea Alta [4]Palco");
            opcionUbicacion = entradaUsuario.nextInt();
            
            if(opcionUbicacion <= 0 || opcionUbicacion > 4){
              System.out.println("Has ingresado un número incorrecto para elegir la entrada. Intenta nuevamente");
            }
          
          } while(opcionUbicacion <= 0 || opcionUbicacion > 4);

          switch (opcionUbicacion){
            
            case 1:
              precioEntrada = 25000;
              ubicacionTexto = "VIP";
              
              if(asientosDisponiblesVIP != 0){
                do {
                  System.out.println("El valor de la entrada para la ubicación " + ubicacionTexto + " es : $" + precioEntrada);
                  System.out.println("Existen " + asientosDisponiblesVIP + " asientos disponibles.");
                  System.out.println("¿Cuántas entradas " + ubicacionTexto + " quieres comprar?");
                  cantidadEntradasParaComprar = entradaUsuario.nextInt();
                }
                while (cantidadEntradasParaComprar == 0 || cantidadEntradasParaComprar > asientosDisponiblesVIP);

                asientosDisponiblesVIP -= cantidadEntradasParaComprar;

                }

              break;

            case 2:
              precioEntrada = 19000;
              ubicacionTexto = "Platea Baja";
              
              if(asientosDisponiblesPlateaBaja != 0){
                do {
                  System.out.println("El valor de la entrada para la ubicación " + ubicacionTexto + " es : $" + precioEntrada);
                  System.out.println("Existen " + asientosDisponiblesPlateaBaja + " asientos disponibles.");
                  System.out.println("¿Cuántas entradas " + ubicacionTexto + " quieres comprar?");
                  cantidadEntradasParaComprar = entradaUsuario.nextInt();
                }
                while (cantidadEntradasParaComprar == 0 || cantidadEntradasParaComprar > asientosDisponiblesPlateaBaja);

                asientosDisponiblesPlateaBaja -= cantidadEntradasParaComprar;

                }
              
              break;

            case 3:
              precioEntrada = 11000;
              ubicacionTexto = "Platea Alta";
              
              if(asientosDisponiblesPlateaAlta != 0){
                do {
                  System.out.println("El valor de la entrada para la ubicación " + ubicacionTexto + " es : $" + precioEntrada);
                  System.out.println("Existen " + asientosDisponiblesPlateaAlta + " asientos disponibles.");
                  System.out.println("¿Cuántas entradas " + ubicacionTexto + " quieres comprar?");
                  cantidadEntradasParaComprar = entradaUsuario.nextInt();
                }
                while (cantidadEntradasParaComprar == 0 || cantidadEntradasParaComprar > asientosDisponiblesPlateaAlta);

                asientosDisponiblesPlateaAlta -= cantidadEntradasParaComprar;
                }
              
              break;

            case 4:
              precioEntrada = 7200;
              ubicacionTexto = "Palco";
              
              if(asientosDisponiblesPalco != 0){
                do {
                  System.out.println("El valor de la entrada para la ubicación " + ubicacionTexto + " es : $" + precioEntrada);
                  System.out.println("Existen " + asientosDisponiblesPalco + " asientos disponibles.");
                  System.out.println("¿Cuántas entradas " + ubicacionTexto + " quieres comprar?");
                  cantidadEntradasParaComprar = entradaUsuario.nextInt();
                }
                while (cantidadEntradasParaComprar == 0 || cantidadEntradasParaComprar > asientosDisponiblesPalco);

                asientosDisponiblesPalco -= cantidadEntradasParaComprar;

                }
              
              break;
              
          }
          
          totalResumen = cantidadEntradasParaComprar * precioEntrada;
          entradasVendidas += cantidadEntradasParaComprar;
          
          if(totalResumen != 0){
            

            System.out.println("Resumen entrada actual");
            System.out.println("-------------------------------------");
            System.out.println("Ubicación: " + ubicacionTexto);
            System.out.println("Precio Entrada: $" + precioEntrada);
            System.out.println("Subtotal por " + cantidadEntradasParaComprar + " entradas es: $" + totalResumen);

            totalPagarEntradas += totalResumen;  
          } else {
            System.out.println("Esta ubicación no tiene asientos disponibles");
          }
             
              
          //Menú para comprar otra entrada o pagar
          do {
            System.out.println("\n[2]Comprar más entrada [3]Terminar el proceso de compra");
            variablesGlobales.opcionMenu = entradaUsuario.nextInt();
            if(variablesGlobales.opcionMenu != 2 && variablesGlobales.opcionMenu != 3){
              System.out.println("Has ingresado un número incorrecto para continuar. Intenta nuevamente");
            }
          
          } while (variablesGlobales.opcionMenu != 2 && variablesGlobales.opcionMenu != 3);
          
          break;
      }
    
    } while(variablesGlobales.opcionMenu != 3); 
    
    System.out.println("Entradas vendidas" + entradasVendidas);
    
    if(entradasVendidas == 0){
      System.out.println("Has salido de la aplicación");
    
    } else {
      
      
      System.out.println("---------------------------------------------------------------------");
      System.out.println("                                 BOLETA                              ");
      System.out.println("---------------------------------------------------------------------");
      System.out.println("El total a pagar por las " + entradasVendidas + " entradas es de: ");
      System.out.println("$" + totalPagarEntradas);
      System.out.println("---------------------------------------------------------------------");
      System.out.println(" Disfruta de la obra de teatro \n");
    }
  }
}