// ============================================================
//  OOP Four Pillars Demo — Animal Kingdom
//  All classes in one file. Only Main class is public.
//  Compile : javac OOPDemo.java
//  Run     : java Main
// ============================================================

// ─────────────────────────────────────────
// 1. ABSTRACTION
//    Abstract class hides internal details
//    and forces subclasses to implement speak()
// ─────────────────────────────────────────
abstract class Animal {
    private String name;   // private = hidden from outside (Encapsulation too)
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    // Abstract method — subclasses MUST implement this
    public abstract void speak();

    // Concrete shared method
    public void breathe() {
        System.out.println(name + " is breathing.");
    }

    // Getters (Encapsulation: controlled access to private fields)
    public String getName() { return name; }
    public int    getAge()  { return age;  }

    @Override
    public String toString() {
        return name + " (age " + age + ")";
    }
}

// ─────────────────────────────────────────
// 2. INHERITANCE
//    Dog and Cat inherit from Animal.
//    They reuse breathe() and get name/age.
// ─────────────────────────────────────────
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);       // call Animal constructor
        this.breed = breed;
    }

    // 3. POLYMORPHISM — overriding speak()
    @Override
    public void speak() {
        System.out.println(getName() + " says: Woof! Woof!");
    }

    public void fetch() {
        System.out.println(getName() + " the " + breed + " fetches the ball!");
    }
}

class Cat extends Animal {
    private boolean isIndoor;

    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    // 3. POLYMORPHISM — same method name, different behaviour
    @Override
    public void speak() {
        System.out.println(getName() + " says: Meow~");
    }

    public void showType() {
        System.out.println(getName() + " is an " + (isIndoor ? "indoor" : "outdoor") + " cat.");
    }
}

class Bird extends Animal {
    private double wingSpanCm;

    public Bird(String name, int age, double wingSpanCm) {
        super(name, age);
        this.wingSpanCm = wingSpanCm;
    }

    @Override
    public void speak() {
        System.out.println(getName() + " says: Tweet! Tweet!");
    }

    public void fly() {
        System.out.println(getName() + " is flying with " + wingSpanCm + "cm wingspan!");
    }
}

// ─────────────────────────────────────────
// 4. ENCAPSULATION
//    AnimalShelter hides its internal list.
//    Outside code can only add/remove/show
//    animals through defined methods.
// ─────────────────────────────────────────
class AnimalShelter {
    private String shelterName;
    private Animal[] animals;   // hidden internal array
    private int count;

    public AnimalShelter(String shelterName, int capacity) {
        this.shelterName = shelterName;
        this.animals     = new Animal[capacity];
        this.count       = 0;
    }

    public void addAnimal(Animal a) {
        if (count < animals.length) {
            animals[count++] = a;
            System.out.println("  Added: " + a.getName());
        } else {
            System.out.println("  Shelter is full!");
        }
    }

    // Polymorphism in action: each animal's speak() is called
    // without knowing the exact type at compile time
    public void makeAllSpeak() {
        System.out.println("\n--- All animals speak ---");
        for (int i = 0; i < count; i++) {
            animals[i].speak();
        }
    }

    public void listAnimals() {
        System.out.println("\n--- Animals in " + shelterName + " ---");
        for (int i = 0; i < count; i++) {
            System.out.println("  " + (i + 1) + ". " + animals[i]);
        }
    }

    public int getCount() { return count; }
}

// ─────────────────────────────────────────
//  MAIN — entry point
// ─────────────────────────────────────────
class AnimalKingdom {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   OOP Four Pillars — Animal Kingdom   ");
        System.out.println("========================================");

        // Create animals (Inheritance + Abstraction)
        Dog  dog  = new Dog("Bruno",  3, "Labrador");
        Cat  cat  = new Cat("Luna",   2, true);
        Bird bird = new Bird("Tweety", 1, 15.5);

        // Encapsulation: interact through shelter methods only
        AnimalShelter shelter = new AnimalShelter("Happy Paws", 10);

        System.out.println("\n[ Adding animals to shelter ]");
        shelter.addAnimal(dog);
        shelter.addAnimal(cat);
        shelter.addAnimal(bird);

        // List all
        shelter.listAnimals();

        // Polymorphism: speak() behaves differently per type
        shelter.makeAllSpeak();

        // Calling subclass-specific methods
        System.out.println("\n--- Special actions ---");
        dog.fetch();
        cat.showType();
        bird.fly();

        // Shared method from Animal (Inheritance)
        System.out.println("\n--- Breathing (inherited method) ---");
        dog.breathe();
        cat.breathe();
        bird.breathe();

        System.out.println("\n========================================");
        System.out.println("  Total animals in shelter: " + shelter.getCount());
        System.out.println("========================================");
    }
}