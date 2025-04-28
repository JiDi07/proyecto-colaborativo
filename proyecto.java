import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class proyecto {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      System.out.println("=== Calendario Interactivo ===");
      System.out.print("Ingresa un número del 1 (Lunes) al 7 (Domingo): ");
      int numeroDia = scanner.nextInt();
      if (numeroDia < 1 || numeroDia > 7) {
        System.out.println("Número inválido. Debe ser entre 1 y 7.");
        return;
      }

      DayOfWeek diaSeleccionado = DayOfWeek.of(numeroDia % 7 + 0); // Ajuste por diferencia de indexado

      System.out.println("¿Qué deseas hacer?");
      System.out.println("1. Ver si hoy es ese día");
      System.out.println("2. Calcular qué día será en X días");
      int opcion = scanner.nextInt();

      switch (opcion) {
        case 1:
          DayOfWeek hoy = LocalDate.now().getDayOfWeek();
          if (hoy.equals(diaSeleccionado)) {
            System.out.println("¡Hoy es " + diaEnEspanol(hoy) + "!");
          } else {
            System.out.println("Hoy es " + diaEnEspanol(hoy) + ", no " + diaEnEspanol(diaSeleccionado) + ".");
          }
          break;

        case 2:
          System.out.print("¿Cuántos días quieres avanzar?: ");
          int diasAdelante = scanner.nextInt();
          LocalDate fechaFutura = LocalDate.now().plusDays(diasAdelante);
          DayOfWeek diaFuturo = fechaFutura.getDayOfWeek();
          System.out.println("En " + diasAdelante + " días será: " + diaEnEspanol(diaFuturo));
          break;

        default:
          System.out.println("Opción no válida.");
          break;
      }

    } catch (Exception e) {
      System.out.println("Error en la entrada. Asegúrate de ingresar números válidos.");
    } finally {
      scanner.close();
    }
  }

  private static String diaEnEspanol(DayOfWeek dia) {
    switch (dia) {
      case MONDAY:
        return "Lunes";
      case TUESDAY:
        return "Martes";
      case WEDNESDAY:
        return "Miércoles";
      case THURSDAY:
        return "Jueves";
      case FRIDAY:
        return "Viernes";
      case SATURDAY:
        return "Sábado";
      case SUNDAY:
        return "Domingo";
      default:
        return "";
    }
  }
}
