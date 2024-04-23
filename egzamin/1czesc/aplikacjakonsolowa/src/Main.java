import java.util.Scanner;

public class Main {
     static int[] tab = new int[10];


     static private void sort(){
         int n = tab.length;
         for (int i = 0; i < n - 1; i++) {
             int max = i;
             for (int j = i + 1; j < n; j++) {
                 if (tab[j] > tab[max]) {
                     max = j;
                 }
             }
             int temp = tab[max];
             tab[max] = tab[i];
             tab[i] = temp;
         }

         for (int i = 0; i < n - 1; i++) {
             System.out.print(tab[i] + " ");
         }
     }

     static private void GetNumsFromUser(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Podaj 10 liczb do posortownaia: ");
         for(int i = 0; i < tab.length; i++) {
             System.out.print("Liczba nr " + (i+1) + ": ");
             tab[i] = sc.nextInt();
         }
     }


    public static void main(String[] args) {
        GetNumsFromUser();
         sort();
    }
}