class Calculater {
    public int addition(int num1, int num2) {
        int add = num1 + num2;
        System.out.println(add);
        return add;

    }

    public double addition(double num1, double num2) {
        double add = num1 + num2;
        System.out.println(add);
        return add;
    }

    public String addition(String num1, String num2) {
        String add = num1 + num2;
        System.out.println(num1 + num2);
        return add;
    }

}

class Addition {

    public static void main(String[] args) {
        Calculater cal = new Calculater();
        cal.addition(22, 11);
        cal.addition(22, 11);
        cal.addition("prasanna", "mohanta");

    }

}