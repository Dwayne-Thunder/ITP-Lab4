import java.io.*;

class LetterOutRange extends Exception{
    public LetterOutRange(String mes){ //КОнструктор с сообщением об ошибке
        super(mes); // Обращение к родительскому классу
    }
}

public class Main {
    public static void main(String[] args) throws IOException {

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

    public static char shiftLetterChar(char letter){
        PrintWriter writer = new PrintWriter(System.out, true);
        int shift_char_code;

        if (Character.isUpperCase(letter)) {
            // Сдвиг заглавной буквы на 2 разряда влево
            shift_char_code = letter << 2;
            //writer.println("Сдвиг заглавной буквы на 2 разряда влево. Десятичное значение: " + shift_char_code);
        } else if (Character.isLowerCase(letter)) {
            // Сдвиг строчной буквы на 1 разряд вправо
            shift_char_code = letter >> 1;
            //writer.println("Сдвиг строчной буквы на 1 разряд вправо. Десятичное значение: " + shift_char_code);
        } else {
            // Если символ не является буквой, возвращаем его без изменений
            writer.println("Символ не является заглавной или строчной буквой. " + letter);
            return letter;
        }

        return (char) shift_char_code;
    }

    public static void Menu(int funk) {
        // Создаем BufferedReader для чтения с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Создаем PrintWriter для вывода на консоль
        PrintWriter writer = new PrintWriter(System.out, true);

        switch (funk) {
            case '1':
                //Зона переменных
                int x;//Вводимый делитель
                int y;//Будущее значение функции

                try {
                    writer.println("Введите значение X:");
                    x = Integer.parseInt(reader.readLine());//Если это гуано не парсить то получится дичь

                    y = 285 / x;// Наша функция
                    writer.println("Результат функции  y = 285 / " + x + " равен:" + y);

                } catch (ArithmeticException zero) {
                    // перехватить исключение
                    writer.println("Ты ШАЙТАН делишь на ноль!");
                } catch (IOException e) {
                    writer.println("Ошибка ввода: " + e.getMessage());
                } catch (NumberFormatException nfe){
                    writer.println("Ошибка: введено не число. Пожалуйста, введите целое число.");
                }
                break;

            case '2':
                // Создаем символьный массив
                char[] charArray = new char[5]; // массив на 5 символов
                try {
                    // Вызываем метод для заполнения массива
                    enterArray(charArray);
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Обрабатываем исключение выхода за границы массива
                    writer.println("Ошибка: Выход за пределы массива! Позиция: " + e.getMessage());
                } catch (IOException e) {
                    // Обрабатываем исключение ввода-вывода
                    writer.println("Ошибка ввода: " + e.getMessage());
                }

                // Вывод массива
                writer.println("Массив символов: ");
                for (char c : charArray) {//Для каждого элемента c в массиве charArray выполните следующее
                    writer.print(c + " ");//выводит текущий символ (c) с добавлением пробела после него
                }
                writer.flush();
                break;
            case '3':

                char upperLetter = 'J';  // Заглавная буква
                char lowerLetter = 'c';  // Строчная буква

                char shiftedUpper = shiftLetterChar(upperLetter);
                char shiftedLower = shiftLetterChar(lowerLetter);

                writer.println("Заданная заглавная буква: " + upperLetter + " Код заглавной буквы: " + (int) upperLetter);
                writer.println("Преобразованная заглавная буква: " + shiftedUpper + " Код преобразованной буквы: " + (int) shiftedUpper);

                writer.println(" ");

                writer.println("Заданная строчная буква: " + lowerLetter + " Код строчной буквы: " + (int) lowerLetter);
                writer.println("Преобразованная строчная буква: " + shiftedLower + " Код преобразованной буквы: " + (int) shiftedLower);

                //Проверка диапазона
                try
                {
                    boolean upperOORan = (int)shiftedUpper < 32 || (int)shiftedUpper > 175;
                    boolean lowerOORan = (int)shiftedLower < 32 || (int)shiftedLower > 175;

                    if (upperOORan && lowerOORan) {
                        throw new LetterOutRange("Обе буквы вне диапазона");
                    } else if (upperOORan) {
                        throw new LetterOutRange("Первая буква вне диапазона");
                    } else if (lowerOORan) {
                        throw new LetterOutRange("Вторая буква вне диапазона");
                    }
                } catch (LetterOutRange e) {
                    writer.println("Ошибка: " + e.getMessage());
                }

                break;
            case '4':
                break;
            default:
                writer.println("Неправильный номер! \nДопустимые номера: \n1 - 1 задание\n2 - 2 задание \n3 - 3 задание \n4 для выхода");

        }
    }
}