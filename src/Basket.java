import java.io.*;
import java.util.Scanner;

//public class Basket implements Serializable {
public class Basket {

    protected String[] names;
    protected int[] prices;
    protected int[] amounts;


    //конструктор, принимающий массив цен и названий продуктов;
    public Basket() {
        this.names = names;
        this.prices = prices;
        this.amounts = new int[names.length];

    }

    //метод добавления amount штук продукта номер productNum в корзину;
    public void addToBasket(int productNum, int amount) {
        amounts[productNum] += amount;
    }

    //вывод карзины
    public void printCart() {

    }

    //метод сохранения корзины в текстовый файл; использовать встроенные сериализаторы нельзя;
    public void saveTxt(File textFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(textFile);) {
            writer.println(names.length); // определить размер необходимый для массива
            for (int i = 0; i < names.length; i++) {
                writer.println(names[i] + "\t" + prices[i] + "\t" + amounts[i]);

            }
        }
    }


    /*статический(!) метод восстановления объекта корзины из текстового
     файла, в который ранее была она сохранена;*/
    public static Basket loadFromTxtFile(File textFile) throws IOException {
        String[] names = null;
        int[] prices = null;
        int[] amounts = null;

        try (Scanner scanner = new Scanner(new FileInputStream(textFile));) {
            int size = Integer.parseInt(scanner.nextLine());// считать размер места для массив
            names = new String[size];
            prices = new int[size];
            amounts = new int[size];

            for (int i = 0; i < size; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                names[i] = parts[0];
                prices[i] = Integer.parseInt(parts[1]);
                amounts[i] = Integer.parseInt(parts[2]);

            }
        }


        Basket basket = new Basket();
        basket.names = names;
        basket.prices = prices;
        basket.amounts = amounts;

        return basket;


    }
// задача 2

    public void saveBin(File textFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(textFile));) {
            out.writeObject(this);

        }
    }
        public static Basket loadFromBin (File textFile) throws IOException, ClassNotFoundException {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(textFile));) {
                return (Basket) in.readObject();


        }
    }
}
