public class Main {
  public static void main(String[] args) {
    String name = "John";
    System.out.println("Hello " + name);

    Vehiculo objVehiculo = new Vehiculo("NISSAN");
    System.out.println("La marca de mi auto es ... "  + objVehiculo.getMarca());

    Coche objCoche = new Coche("TOYOTA");
    System.out.println("La marca de mi coche es ... "  + objCoche.getMarca());

    Vehiculo objVehiculo2 = new Vehiculo();
    System.out.println("La marca de mi auto es ... "  + objVehiculo2.getMarca());

    Coche objCoche2 = new Coche();
    System.out.println("La marca de mi coche es ... "  + objCoche2.getMarca());
  }
}