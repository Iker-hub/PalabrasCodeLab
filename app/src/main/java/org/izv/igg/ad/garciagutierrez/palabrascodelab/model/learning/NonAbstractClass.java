package org.izv.igg.ad.garciagutierrez.palabrascodelab.model.learning;

public class NonAbstractClass extends AbstractClass implements ExampleInterface {

    public NonAbstractClass(int number) {
        super(number);
    }

    @Override
    public void metodoSinImplementar() {

    }

    @Override
    public int getLengthTimes3(String string) {
        return string.length() * 3;
    }

    public static void main(String[] args) {
        NonAbstractClass object = new NonAbstractClass(1);

        // Interface
        object.getLengthTimes3("qqq");

        // Herencia de la clase abstracta y lo he implementado
        object.metodoSinImplementar();

        // Herencia de la clase abstracta
        object.getNumber();
    }
}
