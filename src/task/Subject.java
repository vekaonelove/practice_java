package task;

public class Subject {
    private String name;
    private Material material;
    private double volume;

    public Subject() {
        this.name = "default name";
        this.material = new Material();
        this.volume = 0;
    }

    public Subject(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) { this.material = material; }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass() {
        return volume * material.getDensity();
    }

    @Override
    public String toString() {
        return name + ";" + material + ";" + volume + ";" + getMass();
    }
}