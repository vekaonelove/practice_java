import task.Material;
import task.Subject;

public class Runner {
    public static void main(String[] args) {
        final Material STEEL = new Material("steel", 7850.0);
        Subject wire = new Subject("wire",STEEL, 0.03);
        System.out.println(wire);

        final Material COPPER = new Material("copper", 8500.0);
        wire.setMaterial(COPPER);
        System.out.println("This " + wire.getName() + " mass is " + wire.getMass() + " kg");
    }
}