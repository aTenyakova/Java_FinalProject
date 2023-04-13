import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Notebook> laptops = new ArrayList<>();
        laptops.add(new Notebook(8, 500, "Windows", "Черный"));
        laptops.add(new Notebook(8, 1000, "Windows", "Серый"));
        laptops.add(new Notebook(16, 1000, "Windows", "Черный"));
        laptops.add(new Notebook(16, 2000, "Windows", "Белый"));
        laptops.add(new Notebook(32, 3000, "Ubuntu", "Серый"));
        laptops.add(new Notebook(64, 5000, "Windows", "Белый"));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filter = new HashMap<>();
        System.out.println("Критерии фильтрации: ");
        System.out.println("1: ОЗУ");
        System.out.println("2: Объем ЖД");
        System.out.println("3: Операционная система");
        System.out.println("4: Цвет");
        System.out.println("Введите цифру, соответствующую необходимому критерию: ");
        int criteria = scanner.nextInt();
        switch (criteria) {
            case 1 -> {
                System.out.println("Введите минимальный объем ОЗУ: ");
                filter.put("ram", scanner.nextInt());
                break;
            }
            case 2 -> {
                System.out.println("Введите минимальный объем ЖД: ");
                filter.put("hdd", scanner.nextInt());
                break;
            }
            case 3 -> {
                System.out.println("Введите название операционной системы (Windows, Ubuntu): ");
                filter.put("os", scanner.next());
                break;
            }
            case 4 -> {
                System.out.println("Введите желаемый цвет (Черный, Серый, Белый): ");
                filter.put("color", scanner.next());
                break;
            }
            default -> {
                System.out.println("Неверный ввод");
                break;
            }
        }
        List<Notebook> filteredNotebook = new ArrayList<>();
        for (Notebook laptop : laptops) {
            boolean matchesFilter = true;
            for (Map.Entry<String, Object> entry : filter.entrySet()) {
                switch (entry.getKey()) {
                    case "ram" -> {
                        if (laptop.getRam() < (int) entry.getValue()) {
                            matchesFilter = false;
                        }
                        break;
                    }
                    case "hdd" -> {
                        if (laptop.getHdd() < (int) entry.getValue()) {
                            matchesFilter = false;
                        }
                        break;
                    }
                    case "os" -> {
                        if (!laptop.getOs().equals(entry.getValue())) {
                            matchesFilter = false;
                        }
                        break;
                    }
                    case "color" -> {
                        if (!laptop.getColor().equals(entry.getValue())) {
                            matchesFilter = false;
                        }
                        break;
                    }
                    default -> {
                        System.out.println("Неверный ввод");
                        break;
                    }
                }
            }
            if (matchesFilter) {
                filteredNotebook.add(laptop);
            }
        }
        for (Notebook laptop : filteredNotebook) {
            System.out.println("Оперативная память: " + laptop.getRam() + ", Жёсткий диск: " + laptop.getHdd() + ", Операционная система: " + laptop.getOs() + ", Цвет: " + laptop.getColor());
        }
    }
}

