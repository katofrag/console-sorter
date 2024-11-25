package sorter.project.entity;

import java.util.Comparator;

import sorter.project.service.interfaces.Autobuilder;

public class Human {
    private static Comparator<Human> comparator = (h1, h2) -> h1.age - h2.age;
    private String sex;
    private int age;
    private String surname;

    public Human(HumanBuilder humanBuilder) {
        this.sex = humanBuilder.sex;
        this.age = humanBuilder.age;
        this.surname = humanBuilder.surname;
    }

    public static class HumanBuilder implements Autobuilder {
        private String sex;
        private int age;
        private String surname;

        public HumanBuilder(String sex, int age, String surname) {
            this.sex = sex;
            this.age = age;
            this.surname = surname;
        }

        @Override
        public Autobuilder randomAutoset() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public Autobuilder fromFileAutoset() {
            // TODO Auto-generated method stub
            return null;
        }

        public Human build() {
            return new Human(this);
        }

    }

    public static Comparator<Human> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        return "Human{" + "sex='" + sex + '\'' + ", age=" + age + ", surname='" + surname + '\'' + '}';
    }

}
