import java.io.*;

public class Main {
    public static void main(String[] args) {
        //Зона переменных
        int x=0;//Вводимый делитель
        int y;//Будущее значение функции

        // Создаем BufferedReader для чтения с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Создаем PrintWriter для вывода на консоль
        PrintWriter writer = new PrintWriter(System.out, true);

        try {
            //writer.println("Введите значение X:");


            y=285/x;
            writer.println("Результат функции  y = 285 / "+ x+" равен:"+ y);
        } catch (ArithmeticException zero) {
        // перехватить исключение
            System.out.println("Ты ШАЙТАН делишь на ноль!");
        }


    }
}