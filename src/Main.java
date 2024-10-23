import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Зона переменных
        int m;//Переменная для выбора функции меню


        // Создаем BufferedReader для чтения с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Создаем PrintWriter для вывода на консоль
        PrintWriter writer = new PrintWriter(System.out, true);



        writer.println("Выберите функцию: \nДопустимые номера: \n1 - 1 задание\n2 - 2 задание \n3 - 3 задание \n4 для выхода");
        m = reader.read();// Ввод М с проверкой на целочисленность
        Menu(m);


    }

    public static void Menu(int funk) {
        switch (funk) {
            case '1':
                //Зона переменных
                int x;//Вводимый делитель
                int y;//Будущее значение функции

                // Создаем BufferedReader для чтения с консоли
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                // Создаем PrintWriter для вывода на консоль
                PrintWriter writer = new PrintWriter(System.out, true);


                try {
                    writer.println("Введите значение X:");
                    x = Integer.parseInt(reader.readLine());

                    y = 285 / x;
                    writer.println("Результат функции  y = 285 / " + x + " равен:" + y);

                } catch (ArithmeticException zero) {
                    // перехватить исключение
                    System.out.println("Ты ШАЙТАН делишь на ноль!");
                } catch (IOException e) {
                    System.out.println("Ошибка ввода: " + e.getMessage());
                }

            case '2':
            case '3':
            case '4':
                break;
            default:
                System.out.println("Неправильный номер! \nДопустимые номера: \n1 - 1 задание\n2 - 2 задание \n3 - 3 задание \n4 для выхода");

        }
    }
}