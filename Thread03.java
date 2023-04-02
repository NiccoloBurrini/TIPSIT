package esercizio_03_thread;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Thread03 {
    public static void main(String[] args) throws InterruptedException {
        Scanner Input = new Scanner(System.in);

        try{
            System.out.println("Inserisci n: ");
            int n = Input.nextInt();
            System.out.println("Inserisci k: ");
            int k = Input.nextInt();
            Fattoriale T1 = new Fattoriale("N!", n);
            Fattoriale T2 = new Fattoriale("K!", k);
            Fattoriale T3 = new Fattoriale("(N-K)!", n - k);

            T1.start();
            T2.start();
            T3.start();

            T1.join();
            T2.join();
            T3.join();

            int combinazione = T1.getVal() / (T2.getVal() * T3.getVal());
            System.out.println("C(n, k) = n! / ( k! * (n-k)! ): " + combinazione);


        } catch (InputMismatchException e) {
            System.out.println("ERRORE: input non valido");
        }

        
    }
        

        

        
}