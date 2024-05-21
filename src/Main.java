import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Policia policia = null;
        Arma arma = null;

        int opcion;
        do {
            System.out.println("*****************************");
            System.out.println("*-- JEFATURA DE POLICIA 3F --*");
            System.out.println("*****************************");
            System.out.println("1. Cargar datos de policía");
            System.out.println("2. Cargar datos de arma para un policía");
            System.out.println("3. Ver detalles del policía y su arma");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del policía: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido del policía: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese legajo del policía: ");
                    int legajo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada

                    policia = new Policia(nombre, apellido, legajo);
                    System.out.println("Datos de policía cargados.");
                    break;
                case 2:
                    if (policia == null) {
                        System.out.println("#########################################");
                        System.out.println("Primero debe cargar los datos del policía.");
                        System.out.println("#########################################");
                        break;
                    }

                    System.out.print("Ingrese la cantidad de municiones del arma: ");
                    int municiones = scanner.nextInt();
                    System.out.print("Ingrese el alcance del arma en metros: ");
                    double alcance = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    System.out.print("Ingrese la marca del arma: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el calibre del arma: ");
                    int calibre = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    System.out.print("Ingrese el estado del arma (NUEVA, EN MANTENIMIENTO, EN USO): ");
                    String estado = scanner.nextLine();

                    System.out.println("¿El arma es corta o larga? (corta/larga)");
                    String tipoArma = scanner.nextLine();
                    if (tipoArma.equalsIgnoreCase("corta")) {
                        System.out.print("¿El arma es automática? (si/no): ");
                        boolean esAutomatica = scanner.nextLine().equalsIgnoreCase("si");
                        // Limpiar el buffer de entrada no es necesario porque nextLine() ya lo hace
                        arma = new Corta(municiones, alcance, marca, calibre, estado, esAutomatica);
                    } else if (tipoArma.equalsIgnoreCase("larga")) {
                        System.out.print("Ingrese la justificación de uso del arma: ");
                        String justifUso = scanner.nextLine();
                        System.out.print("Ingrese el nivel del arma (del 1 al 5): ");
                        int nivelArma = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer de entrada
                        System.out.print("¿El arma tiene sello del RENAR? (si/no): ");
                        boolean tieneSello = scanner.nextLine().equalsIgnoreCase("si");
                        arma = new Larga(municiones, alcance, marca, calibre, estado, justifUso, nivelArma, tieneSello);
                    } else {
                        System.out.println("Opción no válida. Debe ingresar 'corta' o 'larga'.");
                        break; // Añadimos un break para salir del switch
                    }

                    // Asociar el arma al policía
                    policia.setArma(arma);

                    System.out.println("Datos de arma cargados.");
                    break;
                case 3:
                    if (policia == null || policia.getArma() == null) {
                        System.out.println("*************************************************************************");
                        System.out.println("No hay suficientes datos para mostrar los detalles del policía y su arma.");
                        System.out.println("*************************************************************************");
                    } else {
                        System.out.println("Detalles del policía:");
                        System.out.println(policia);
                        System.out.println("Detalles del arma:");
                        System.out.println(policia.getArma());
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
