package sorter.project.entity;

import java.util.Comparator;

import sorter.project.service.interfaces.Autobuilder;

public class Animal {
    private static Comparator<Animal> comparator = (a1, a2) -> a1.type.compareTo(a2.type);
    private String type;
    private String eyeColor;
    private boolean wool;

    public Animal(AnimalBuilder animalBuilder) {
        this.type = animalBuilder.type;
        this.eyeColor = animalBuilder.eyeColor;
        this.wool = animalBuilder.wool;
    }

    public static class AnimalBuilder implements Autobuilder {
        private String type;
        private String eyeColor;
        private boolean wool;

        public AnimalBuilder(String type, String eyeColor, boolean wool) {
            this.type = type;
            this.eyeColor = eyeColor;
            this.wool = wool;
        }

        @Override
        public Autobuilder randomAutoset() {
            // TODO Auto-generated method stub
            return this;
        }

        @Override
        public Autobuilder fromFileAutoset() {
            // TODO Auto-generated method stub
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }

    }

    @Override
    public String toString() {
        return "Animal{" + "type='" + type + '\'' + ", eyeColor='" + eyeColor + '\'' + ", wool=" + wool + '}';
    }

    public static Comparator<Animal> getComparator() {
        return comparator;
    }

}
