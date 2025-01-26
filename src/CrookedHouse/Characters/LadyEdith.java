package CrookedHouse.Characters;

public class LadyEdith extends Character {
    /** Constructor */
    public LadyEdith(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("Lady Edith");
    }
}
