import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Зона переменных
        int x;//Вводимый делитель
        int y;//Будущее значение функции
        int m;//Переменная для выбора функции меню


        // Создание объекта Scanner для чтения данных с клавиатуры
        Scanner scanner = new Scanner(System.in);
        // Создаем BufferedReader для чтения с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Создаем PrintWriter для вывода на консоль
        PrintWriter writer = new PrintWriter(System.out, true);


        m = scanner.nextInt();// Ввод М с проверкой на целочисленность








        try {
            writer.println("Введите значение X:");
            x = scanner.nextInt();

            y=285/x;
            writer.println("Результат функции  y = 285 / "+ x+" равен:"+ y);
            // Закрытие Scanner
            scanner.close();
        } catch (ArithmeticException zero) {
        // перехватить исключение
            System.out.println("Ты ШАЙТАН делишь на ноль!");
        }


    }

    public static void Menu(int funk) {
        switch (funk) {
            case '1':
            case '2':
            case '3':
            case 'X':
            default:
                System.out.println("Неправильный номер! \nДопустимые номера: \n1 - 1 задание\n2 - 2 задание \n3 - 3 задание \nX для выхода\"");

        }
    }
}