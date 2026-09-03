package INF100labs;

/**
 * Implement the methods multiplesOfSevenUpTo, multiplicationTable and crossSum.
 * These programming tasks was part of lab3 in INF100 fall 2022/2023. You can find them here: https://inf100h22.stromme.me/lab/3/
 */
public class Lab3 {
    
    public static void main(String[] args) {
        multiplesOfSevenUpTo(49);
        multiplicationTable(5);
        int result = crossSum(123);
        System.out.println(result);
    }

    public static void multiplesOfSevenUpTo(int n) {
        for(int i = 1; i <= n; i++) {
            if (i % 7 == 0){
                System.out.println(i);
            }
        }
    }

    public static void multiplicationTable(int n) {
        for(int i = 1; i <= n; i++){
            System.out.print(i + ": ");

            for(int j = 1; j <= n; j++){
                System.out.print(i * j);
                if(j < n){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static int crossSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;   // hent siste siffer
            num = num / 10;      // fjern siste siffer
        }
        return sum;
    }

}