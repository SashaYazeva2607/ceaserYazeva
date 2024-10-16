import java.util.Scanner;

public class Main {

    // Метод для шифрования текста
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            char base;

            if (Character.isLowerCase(character)) {
                if (character >= 'а' && character <= 'я') {
                    base = 'а';
                } else if (character >= 'a' && character <= 'z') {
                    base = 'a';
                } else {
                    result.append(character);
                    continue;
                }
            } else if (Character.isUpperCase(character)) {
                if (character >= 'А' && character <= 'Я') {
                    base = 'А';
                } else if (character >= 'A' && character <= 'Z') {
                    base = 'A';
                } else {
                    result.append(character);
                    continue;
                }
            } else {
                result.append(character);
                continue;
            }

        // Применяем сдвиг и обрабатываем переполнение
            character = (char) ((character + shift - base) % (26 + 32) + base);
            result.append(character);
        }
        return result.toString();
    }

    // Метод для работы с пользовательским вводом
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие: (1) Зашифровать (2) Расшифровать");
        int chislo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите текст:");
        String text = scanner.nextLine();
        System.out.println("Введите сдвиг (положительное число - вправо, отрицательное - влево):");
        int shift = scanner.nextInt();

        String result = "";
        if (chislo == 1) {
            result = encrypt(text, shift);
            System.out.println("Зашифрованный текст: " + result);
        } else if (chislo == 2) {
            result = encrypt(text, -shift);
            System.out.println("Расшифрованный текст: " + result);
        } else {
            System.out.println("Неверный выбор действия.");
        }
        scanner.close();
    }
}