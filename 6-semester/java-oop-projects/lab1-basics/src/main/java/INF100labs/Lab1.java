package INF100labs;

import java.util.Scanner;

/**
 * Implement the methods task1, and task2.
 * These programming tasks was part of lab1 in INF100 fall 2022/2023. You can find them here: https://inf100h22.stromme.me/lab/1/
 */
public class Lab1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Call the methods here to test them on different inputs
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("Hei, det er meg, datamaskinen.");
        System.out.println("Hyggelig å se deg her.");
        System.out.println("Lykke til med OOP!");
    }

    public static void task2() {
        sc = new Scanner(System.in); // Do not remove this line
        String navn = readInput("Hva er ditt navn?");
        String addresse = readInput("Hva er din adresse?");
        String post = readInput("Hva er ditt postnummer og poststed?");

        System.out.println(navn + "s adresse er:");
        System.out.println();

        System.out.println(navn);
        System.out.println(addresse);
        System.out.println(post);
}
    

    /**
     * Reads input from console with given prompt
     * @param prompt
     * @return string input answer from user
     */
    private static String readInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }


}
