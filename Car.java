
class Car {

    public void start() {
        System.out.println("start");
    }

    public void stop() {
        System.out.println("stop");
    }

    public void move() {
        System.out.println("move");
    }
}

class Maruti extends Car {
    public void autoDrive() {
        System.out.println("autoDrive");
    }

    public static void main(String[] args) {
        Maruti m = new Maruti();
        System.out.println("Maruti");
        m.start();
        m.stop();
        m.move();
        m.autoDrive();
    }
}

class Bmw extends Car {
    public void autoDrive() {
        System.out.println("autoDrive");
    }

    public void switchPetrolToDissel() {
        System.out.println("switchPetrolToDissel");
    }

    public static void main(String[] args) {
        Bmw b = new Bmw();
        b.start();
        b.stop();
        b.move();
        b.autoDrive();
        b.switchPetrolToDissel();
    }
}
