import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {


        Basket basket = new Basket();

        basket.saveTxt(new File("basket.txt"));
        //для бинарного формата
        basket.saveBin(new File("basket.txt"));

        Basket basket1 = Basket.loadFromTxtFile(new File("basket.txt"));


        Scanner scanner = new Scanner(System.in);

        System.out.println("Список возможных товаров для покупки");

        String[] products = {"Хлеб", "Яблоки", "Молоко"};

        int[] prices = {100, 200, 300};

        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + " " + products[i] + " " + prices[i] + " руб/шт");

        }

        int[] productsCount = new int[products.length];


        while (true) {

            System.out.println("Выберите товар и количество или введите `end`");
            String inputString = scanner.nextLine();

            if (inputString.equals("end")) {

                break;
            }

            String[] parts = inputString.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            productsCount[productNumber] += productCount;

        }
        int sumProducts = 0;
        for (int i = 0; i < productsCount.length; i++) {
            if (productsCount[i] > 0) {
                System.out.println(products[i] + " " + prices[i] + " руб/шт., "
                        + (productsCount[i] * prices[i]) + " руб в сумме.");

                sumProducts += prices[i] * productsCount[i];
            }
        }
        System.out.println("Итого: " + sumProducts + " руб");
    }
}








