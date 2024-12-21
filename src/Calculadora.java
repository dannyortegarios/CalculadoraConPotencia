import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menú para elegir la figura
            System.out.println("Elige una figura:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.print("Elige una opción (1-5): ");
            int figura = Integer.parseInt(scanner.nextLine());

            // Menú para elegir la operación
            System.out.println("Elige una operación:");
            System.out.println("1. Área");
            System.out.println("2. Perímetro");
            System.out.println("3. Potencia");
            System.out.print("Elige una opción (1-3): ");
            int operacion = Integer.parseInt(scanner.nextLine());

            // Realizar la operación elegida
            double resultado = 0;

            if (operacion == 1 || operacion == 2) {
                // Leer los datos según la figura
                double[] datos = pedirDatos(figura, scanner);

                if (operacion == 1) {  // Área
                    resultado = calcularArea(figura, datos);
                } else if (operacion == 2) {  // Perímetro
                    resultado = calcularPerimetro(figura, datos);
                }
            } else if (operacion == 3) {  // Potencia
                System.out.print("Introduce la base: ");
                double base = Double.parseDouble(scanner.nextLine());
                System.out.print("Introduce el exponente: ");
                int exponente = Integer.parseInt(scanner.nextLine());
                resultado = calcularPotencia(base, exponente);
            }

            // Mostrar el resultado
            System.out.println("Resultado: " + resultado);

            // Preguntar si desea realizar otra operación
            System.out.print("¿Deseas realizar otra operación? (sí/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                break;
            }
        }

        scanner.close();
    }

    // Función para pedir los datos necesarios para cada figura
    public static double[] pedirDatos(int figura, Scanner scanner) {
        double[] datos = new double[2];  // Usamos un arreglo para los datos
        switch (figura) {
            case 1: // Círculo
                System.out.print("Introduce el radio: ");
                datos[0] = Double.parseDouble(scanner.nextLine());
                break;
            case 2: // Cuadrado
                System.out.print("Introduce el lado: ");
                datos[0] = Double.parseDouble(scanner.nextLine());
                break;
            case 3: // Triángulo
                System.out.print("Introduce la base: ");
                datos[0] = Double.parseDouble(scanner.nextLine());
                System.out.print("Introduce la altura: ");
                datos[1] = Double.parseDouble(scanner.nextLine());
                break;
            case 4: // Rectángulo
                System.out.print("Introduce el largo: ");
                datos[0] = Double.parseDouble(scanner.nextLine());
                System.out.print("Introduce el ancho: ");
                datos[1] = Double.parseDouble(scanner.nextLine());
                break;
            case 5: // Pentágono
                System.out.print("Introduce el lado: ");
                datos[0] = Double.parseDouble(scanner.nextLine());
                break;
            default:
                System.out.println("Figura no válida.");
        }
        return datos;
    }

    // Función para calcular el área de las figuras
    public static double calcularArea(int figura, double[] datos) {
        switch (figura) {
            case 1: // Círculo
                return Math.PI * datos[0] * datos[0];
            case 2: // Cuadrado
                return datos[0] * datos[0];
            case 3: // Triángulo
                return (datos[0] * datos[1]) / 2;
            case 4: // Rectángulo
                return datos[0] * datos[1];
            case 5: // Pentágono
                return (5 * datos[0] * datos[0]) / (4 * Math.tan(Math.PI / 5));
            default:
                return 0;
        }
    }

    // Función para calcular el perímetro de las figuras
    public static double calcularPerimetro(int figura, double[] datos) {
        switch (figura) {
            case 1: // Círculo
                return 2 * Math.PI * datos[0];
            case 2: // Cuadrado
                return 4 * datos[0];
            case 3: // Triángulo
                return 3 * datos[0]; // Asumimos un triángulo equilátero
            case 4: // Rectángulo
                return 2 * (datos[0] + datos[1]);
            case 5: // Pentágono
                return 5 * datos[0];
            default:
                return 0;
        }
    }

    // Función recursiva para calcular la potencia
    public static double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;  // Caso base
        }
        return base * calcularPotencia(base, exponente - 1);  // Llamada recursiva
    }
}
