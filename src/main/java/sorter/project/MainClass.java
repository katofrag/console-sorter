package sorter.project;

import java.util.Scanner;

import sorter.project.entity.WorkingCollection;
import sorter.project.service.FillFromConsole;
import sorter.project.service.FillFromFile;
import sorter.project.service.FillFromRandom;

public class MainClass {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнить коллекцию");
            System.out.println("2. Сортировать коллекцию");
            System.out.println("3. Найти элемент");
            System.out.println("4. Записать в файл");
            System.out.println("5. Вывести в консоль");
            System.out.println("6. Выход");

            // TODO Auto-generated method stub

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    fillingNewOrOld();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    for (Object o : WorkingCollection.addedCollection()) {
                        System.out.println(o.toString());
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор!");
            }
        }

    }

    private static void fillingNewOrOld() {
        System.out.println("Выберите действие:");
        System.out.println("1. Заполнить новую коллекцию");
        System.out.println("2. Заполнить существующую коллекцию");
        System.out.println("3. На главную");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                if (WorkingCollection.addedCollection() != null) {
                    WorkingCollection.deleteColection();
                }
                filling(choice);
                break;
            case 2:
                filling(choice);
                break;
            case 3:

                break;
            default:
                System.out.println("Неверный выбор!");
        }

    }

    private static void filling(int lastChoice) {
        System.out.println("Выберите действие:");
        System.out.println("1. Заполнить объектами Human");
        System.out.println("2. Заполнить объектами Animal");
        System.out.println("3. Заполнить объектами Barrel");
        System.out.println("4. На главную");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fillingType("Human");
                break;
            case 2:
                fillingType("Animal");
                break;
            case 3:
                fillingType("Barrel");
                break;
            case 4:
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private static void fillingType(String lastChoice) {
        System.out.println("Выберите действие:");
        System.out.println("1. Заполнить из консоли");
        System.out.println("2. Заполнить из файла");
        System.out.println("3. Заполнить случайными значениями");
        System.out.println("4. На главную");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                WorkingCollection.addInCollection(FillFromConsole.fill(lastChoice));
                break;
            case 2:
                System.out.println("Введите количество считываемых строк:");
                int choiceCountFile = scanner.nextInt();
                WorkingCollection.addInCollection(FillFromFile.fill(choiceCountFile, lastChoice));
                break;
            case 3:
                System.out.println("Введите количество генерируемых объектов:");
                int choiceCountRandom = scanner.nextInt();
                WorkingCollection.addInCollection(FillFromRandom.fill(choiceCountRandom, lastChoice));
                break;
            case 4:
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }
}