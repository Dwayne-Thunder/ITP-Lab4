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


    // Метод для заполнения символьного массива
    public static void enterArray(char[] array) throws IOException, ArrayIndexOutOfBoundsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < array.length + 1; i++) { // Намеренная ошибка (i < array.length + 1) для выброса исключения
            System.out.print("Введите символ для позиции " + i + ": ");
            array[i] = reader.readLine().charAt(0); // Чтение первого символа из введённой строки
        }
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
                    x = Integer.parseInt(reader.readLine());//Если это гуано не парсить то получится дичь

                    y = 285 / x;// Наша функция
                    writer.println("Результат функции  y = 285 / " + x + " равен:" + y);

                } catch (ArithmeticException zero) {
                    // перехватить исключение
                    System.out.println("Ты ШАЙТАН делишь на ноль!");
                } catch (IOException e) {
                    System.out.println("Ошибка ввода: " + e.getMessage());
                }

            case '2':
                // Создаем символьный массив
                char[] charArray = new char[5]; // массив на 5 символов
                try {
                    // Вызываем метод для заполнения массива
                    enterArray(charArray);
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Обрабатываем исключение выхода за границы массива
                    System.out.println("Ошибка: Выход за пределы массива! Позиция: " + e.getMessage());
                } catch (IOException e) {
                    // Обрабатываем исключение ввода-вывода
                    System.out.println("Ошибка ввода: " + e.getMessage());
                }

                // Вывод массива
                System.out.println("Массив символов: ");
                for (char c : charArray) {//Для каждого элемента c в массиве charArray выполните следующее
                    System.out.print(c + " ");//выводит текущий символ (c) с добавлением пробела после него
                }
            case '3':
            case '4':
                break;
            default:
                System.out.println("Неправильный номер! \nДопустимые номера: \n1 - 1 задание\n2 - 2 задание \n3 - 3 задание \n4 для выхода");

        }
    }
}