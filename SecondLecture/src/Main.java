public class Main {
    public static void main(String[] args) {
    Animal myre = new Ant();

    System.out.println(myre.getLegs());
    }
}

abstract class Animal {
    public static void main(String[] args) {
    }
    int getLegs() {
        int legs = 0;

        return legs;
    }
}

class Human extends Animal {
    @Override
    int getLegs() {
        int legs = 2;

        return legs;
    }
}

class Horse extends Animal {
    @Override
    int getLegs() {
        int legs = 4;

        return legs;
    }
}

class Fish extends Animal {
    @Override
    int getLegs() {
        int legs = 0;

        return legs;
    }
}

class Insect extends Animal {
    @Override
    int getLegs() {
        int legs = 6;

        return legs;
    }
}

class Ant extends Insect {
    @Override
    int getLegs() {
        return super.getLegs();
    }
}
