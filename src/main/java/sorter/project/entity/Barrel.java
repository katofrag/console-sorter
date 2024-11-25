package sorter.project.entity;

import java.util.Comparator;

import sorter.project.service.interfaces.Autobuilder;

public class Barrel {
    private static Comparator<Barrel> comparator = (b1, b2) -> (int) (b1.volume - b2.volume);
    private double volume;
    private String storedMaterial;
    private String material;

    public Barrel(BarrelBuilder barrelBuilder) {
        this.volume = barrelBuilder.volume;
        this.storedMaterial = barrelBuilder.storedMaterial;
        this.material = barrelBuilder.material;
    }

    public static class BarrelBuilder implements Autobuilder {
        private double volume;
        private String storedMaterial;
        private String material;

        public BarrelBuilder(double volume, String storedMaterial, String material) {
            this.volume = volume;
            this.storedMaterial = storedMaterial;
            this.material = material;
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

        public Barrel build() {
            return new Barrel(this);
        }

    }

    public static Comparator<Barrel> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        return "Barrel{" + "volume=" + volume + ", storedMaterial='" + storedMaterial + '\'' + ", material='" + material
                + '\'' + '}';
    }

}