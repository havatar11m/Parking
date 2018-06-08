import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        int filas, columnas, menu, lleno, recaudacion;
        filas = 5;
        columnas = 10;
        menu = 0;
        lleno = 0;
        recaudacion = 0;
        char[][] parking = new char[filas][columnas];
        int[] puntos = new int[2];




        iniciarParking(parking, filas, columnas);

        do {
            System.out.println("\n"
                    + "+----------PARKING----------+\n"
                    + "| 1. Ver Parking            |\n"
                    + "| 2. Entrada de un coche    |\n"
                    + "| 3. Entrada de una moto    |\n"
                    + "| 4. Entrada de un autobús  |\n"
                    + "| 5. Salida de vehículo     |\n"
                    + "| 6. Ver recaudación        |\n"
                    + "| 7. Salir del programa     |\n"
                    + "+---------------------------+\n");

            try {
                System.out.print("Introduce la opción: ");
                menu = escaner.nextInt();
            } catch (Exception exception) {
                System.out.println("Introduce valores numéricos");
            }
            switch (menu) {

                case 1:
                    System.out.println();

                    mostrarParking(parking, filas, columnas);
                    break;

                case 2:
                    Coordenadas(puntos);
                    if (lleno < 24) {
                        if (Entrada(parking, puntos)) {

                            parking[puntos[0]][puntos[1]] = 'C';
                            recaudacion += 5;
                            lleno++;
                        } else
                            System.out.println("Posicion ocupada por vehículo o columnas");
                    } else
                        System.out.println("PARKING LLENO INTENTE TRAS SACAR ALGÚN VEHÍCULO");
                    break;

                case 3:
                    Coordenadas(puntos);
                    if (lleno < 24) {
                        if (Entrada(parking, puntos)) {
                            parking[puntos[0]][puntos[1]] = 'M';
                            recaudacion += 3;
                            lleno++;
                        } else
                            System.out.println("Posicion ocupada por vehículo o columnas");
                    } else
                        System.out.println("PARKING LLENO INTENTE TRAS SACAR ALGÚN VEHÍCULO");
                    break;

                case 4:
                    Coordenadas(puntos);
                    if (lleno < 24) {
                        if (Entrada(parking, puntos)) {

                            parking[puntos[0]][puntos[1]] = 'A';
                            recaudacion += 10;
                            lleno++;
                        } else
                            System.out.println("Posicion ocupada por vehículo o columnas");
                    } else
                        System.out.println("PARKING LLENO INTENTE TRAS SACAR ALGÚN VEHÍCULO");

                    break;

                case 5:
                    Coordenadas(puntos);
                    Integer integer = Salida(parking, puntos);
                    if (integer == 0) {
                        parking[puntos[0]][puntos[1]] = '\0';
                    } else if (integer == 1)
                        System.out.println("Introduce una posición con un vehículo existente");

                    break;

                case 6:
                    System.out.println("La recaudación del parking es de " + recaudacion);
                    break;

                case 7:
                    System.out.println("Fin de Programa");
                    break;
                default:
                    System.out.println("Solo números del 1 al 7");
                    break;

            }
        } while (menu != 7);
    }


    private static void mostrarParking(char[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();

            System.out.println();
        }
    }

    private static void iniciarParking(char[][] matriz, int filas, int columnas) {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if ((i == 0 && j == 0) ||
                    (i == 0 && j == 9) ||
                    (i == 4 && j == 0) ||
                    (i == 4 && j == 9) ||
                    (i == 2 && j == 0))
                    matriz[i][j] = 'X';
                else if (i == 1 && j == 0)
                    matriz[i][j] = 'E';
                else if (i == 3 && j == 0)
                    matriz[i][j] = 'S';
                else if ((i == 0 && j == 1) || (i == 0 && j == 2) || (i == 0 && j == 3) ||
                        (i == 0 && j == 4) || (i == 0 && j == 5) || (i == 0 && j == 6) ||
                        (i == 0 && j == 7) || (i == 0 && j == 8) || (i == 4 && j == 1) ||
                        (i == 4 && j == 2) || (i == 4 && j == 3) || (i == 4 && j == 4) ||
                        (i == 4 && j == 5) || (i == 4 && j == 6) || (i == 4 && j == 7) ||
                        (i == 4 && j == 8) || (i == 1 && j == 9) || (i == 2 && j == 9) ||
                        (i == 3 && j == 9))
                    matriz[i][j] = 'P';
            }
        }
    }

    private static boolean Entrada(char[][] parking, int[] coordenadas) {

        try {
            return parking[coordenadas[0]][coordenadas[1]] == '\0';
        } catch (Exception ex) {
            System.out.println("Coordenadas no válidas para parking");
            return false;
        }
    }

    private static Integer Salida(char[][] parking, int[] coordenadas) {

        try {
            if (parking[coordenadas[0]][coordenadas[1]] == 'C' ||
                parking[coordenadas[0]][coordenadas[1]] == 'M' ||
                parking[coordenadas[0]][coordenadas[1]] == 'A')
                return 0;
            else
                return 1;

        } catch (Exception ex) {
            System.out.println("Coordenadas no válidas para parking");
            return 2;
        }

    }

    private static int[] Coordenadas(int[] coordenadas) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("Introduce fila [Del 1 al 3]: ");
            coordenadas[0] = teclado.nextInt();
            System.out.print("Introduce columna[Del 1 al 8]: ");
            coordenadas[1] = teclado.nextInt();
            return coordenadas;
        } catch (InputMismatchException ex) {
            System.out.println("Introduce valores numéricos");
            return coordenadas;
        }
    }
}