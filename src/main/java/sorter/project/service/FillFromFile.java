package sorter.project.service;

import sorter.project.entity.Animal;
import sorter.project.entity.Barrel;
import sorter.project.entity.Human;
import sorter.project.service.interfaces.Fill;
import sorter.project.utils.Validation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class FillFromFile implements Fill {
    private static List list = new ArrayList<>();

    private FillFromFile() {
        throw new UnsupportedOperationException();
    }

    public static List fill(int count, String type) {
        switch (type) {
            case "Human": {
                try {
                    list = createMan(count);
                } catch (IOException e) {
                    System.out.println("ошибка файла");
                }
                break;
            }
            case "Animal": {
                try {
                    list = createAnimal(count);
                } catch (IOException e) {
                    System.out.println("ошибка файла");
                }
                break;
            }
            case "Barrel": {
                try {
                    list = createBarrel(count);
                } catch (IOException e) {
                    System.out.println("ошибка файла");
                }
                break;
            }
            default:
                System.out.println("Не получилось");
        }
        return list;
    }

    private static List createAnimal(int count) throws IOException {
        List<Object> list = new ArrayList<>();
        String s = "src\\main\\java\\sorter\\project\\object_addition\\animal.txt";
        Path path = Path.of(s).toAbsolutePath();
        List<String> lines = Files.readAllLines(path);
        int countOfError = 0;
        for (int i = 0; (i < count) && (i < lines.size()); i++) {
            if (Validation.generalValidation(lines.get(i))) {
                if (Validation.animalValidation(lines.get(i))) {
                    int first = lines.get(i).indexOf(" ");
                    int second = lines.get(i).indexOf(" ", first + 1);
                    String types = lines.get(i).substring(0, first);
                    boolean wool = Boolean.parseBoolean(lines.get(i).substring(first + 1, second));
                    String eyeColor = lines.get(i).substring(second);
                    Animal animal = new Animal.AnimalBuilder(types, eyeColor, wool).build();
                    list.add(animal);
                } else {
                    System.out.println("Ошибка валидации2");
                    countOfError++;
                }
            } else {
                System.out.println("Ошибка валидации");
                countOfError++;
            }
        }
        System.out.println("Ошибок валидации: " + countOfError);
        return list;
    }

    private static List createMan(int count) throws IOException {
        List<Object> list = new ArrayList<>();
        String s = "src\\main\\java\\sorter\\project\\object_addition\\man.txt";
        Path path = Path.of(s).toAbsolutePath();
        List<String> lines = Files.readAllLines(path);
        int countOfError = 0;
        for (int i = 0; (i < count) && (i < lines.size()); i++) {
            if (Validation.generalValidation(lines.get(i))) {
                if (Validation.manValidation(lines.get(i))) {
                    int first = lines.get(i).indexOf(" ");
                    int second = lines.get(i).indexOf(" ", first + 1);
                    String lastName = lines.get(i).substring(0, first);
                    int age = Integer.parseInt(lines.get(i).substring(first + 1, second));
                    String gender = lines.get(i).substring(second);
                    Human man = new Human.HumanBuilder(gender, age, lastName).build();
                    list.add(man);
                } else {
                    System.out.println("Ошибка валидации2");
                    countOfError++;
                }
            } else {
                System.out.println("Ошибка валидации");
                countOfError++;
            }
        }
        System.out.println("Ошибок валидации: " + countOfError);
        return list;
    }

    private static List createBarrel(int count) throws IOException {
        List<Object> list = new ArrayList<>();
        String s = "src\\main\\java\\sorter\\project\\object_addition\\barrel.txt";
        Path path = Path.of(s).toAbsolutePath();
        List<String> lines = Files.readAllLines(path);
        int countOfError = 0;
        for (int i = 0; (i < count) && (i < lines.size()); i++) {
            if (Validation.generalValidation(lines.get(i))) {
                if (Validation.barrelValidation(lines.get(i))) {
                    int first = lines.get(i).indexOf(" ");
                    int second = lines.get(i).indexOf(" ", first + 1);
                    float volume = Float.parseFloat(lines.get(i).substring(0, first));
                    String material = lines.get(i).substring(first + 1, second);
                    String storedMaterial = lines.get(i).substring(second);
                    Barrel barrel = new Barrel.BarrelBuilder(volume, storedMaterial, material).build();
                    list.add(barrel);
                } else {
                    System.out.println("Ошибка валидации2");
                    countOfError++;
                }
            } else {
                System.out.println("Ошибка валидации");
                countOfError++;
            }
        }
        System.out.println("Ошибок валидации: " + countOfError);
        return list;
    }
}