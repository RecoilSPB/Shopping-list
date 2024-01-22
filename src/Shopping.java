import java.util.Arrays;
import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {

        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[8];// Объявите массив shoppingList через длину
        int productCount = 0; // переменная для подсчёта добавленных товаров

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            //заменил тип данных для комманд, для избежания исключения.
            String actionNumber = scanner.nextLine();

            switch (actionNumber) {
                case "1":
                    //добавление товара в список
                    System.out.println("Укажите наименованеи товара");
                    String product = scanner.next();
                    if (!Arrays.asList(shoppingList).contains(product)) {
                        if (shoppingList.length == productCount) {
                            //Arrays.copyOf - позваляет изменить размер массива
                            shoppingList = Arrays.copyOf(shoppingList, productCount * 2);
                        }
                        shoppingList[productCount] = product;
                        productCount++;
                        System.out.println("Товар " + product + " добавлен в список под номером " + productCount);
                    } else {
                        System.out.println("Такой товар уже есть в списке");
                    }
                    break;
                case "2":
                    // вывод списка товаров
                    for (int index = 0; index < shoppingList.length; index++) {
                        if (shoppingList[index] == null && index == 0) {
                            System.out.println("Список товаров пуст");
                            break;
                        }
                        if (shoppingList[index] != null) {
                            System.out.println((index + 1) + ". " + shoppingList[index]);
                        } else {
                            break;
                        }
                    }
                    break;
                case "3":
                    // очистка списка товаров
                    //Arrays.fill - позваляет все злементам массива задать одинаковое значение.
                    Arrays.fill(shoppingList, null);
                    productCount = 0;
                    break;
                case "4":
                    // выход из программы
                    return;
                default:
                    System.out.println("Неизвестная команда!");
            }
        }
    }
} 