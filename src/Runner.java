import task.Material;
import task.Subject;

public class Runner {
    public static void main(String[] args) {
        Subject wire = new Subject("wire", new Material("steel", 7850.0), 0.03);

        System.out.println("------------------1--------------------");
        System.out.println(wire);

        wire.setMaterial(new Material("copper", 8500.0));

        System.out.println("------------------2--------------------");
        System.out.println("This " + wire.getName() + " mass is " + wire.getMass() + " kg");
    }
}