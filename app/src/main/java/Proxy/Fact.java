package Proxy;

public class Fact {

    private final int id;
    private final String animal;
    private final String fact;

    public Fact(int id, String animal, String fact) {
        this.id = id;
        this.animal = animal;
        this.fact = fact;
    }

    public int getId() {
        return this.id;
    }

    public String getAnimal() {
        return animal;
    }

    public String getFact() {
        return fact;
    }
}
