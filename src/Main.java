import java.io.*;

public class Main {
    public static void main(String[] args) {
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

            y=285/x;
            writer.println("Результат функции  y = 285 / "+ x+" равен:"+ y);
        } catch (ArithmeticException zero) {
        // перехватить исключение
            System.out.println("Ты ШАЙТАН делишь на ноль!");
        } catch (IOException e) {
            // Перехват исключений при чтении с консоли
            System.out.println("Произошла ошибка ввода.");
        } catch (NumberFormatException e) {
            // Перехват исключений неверного формата числа
            System.out.println("Шайтан! Введи целое число");
        }
    }
}