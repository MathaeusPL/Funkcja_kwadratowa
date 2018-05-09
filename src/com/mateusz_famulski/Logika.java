package com.mateusz_famulski;

import java.util.Scanner;

public class Logika {

    private double a,b,c,delta;
    private Scanner scan = new Scanner(System.in);

    /**
     * Użytkownik wprowadza 10 wartości korzystając z metody userInputNoZero();
     * @return tablica z 10 wartościami określającymi dziedzinę funkcji.
     */
        double[] tab1 (){
        double[] tabx = new double[10];
        System.out.println("\nPodaj dziesięć wartości dziedziny funkcji.");
        for (int i=0; i<10; i++){
            System.out.println("Podaj wartość dla x"+(i+1));
            tabx[i]= userInputNoZero();
        }
        return tabx;
    }

    /**
     * Metodla oblicza i wyświeta wartości jakie przyjmuje fukncja dla określonych elementów jej dziedziny.
     * @param x tablica z dziedziną funkcji określoną prze użytkownika.
     */
    public void fxCount (double x[]){
            double result;
        System.out.println("\nDla funkcji f(x)=ax2+bx+c\nPrzy a="+a+", b="+b+", c="+c+"\n");
        for (int i=0; i<10; i++){
            result= (a*(Math.pow(x[i],2))+(b*x[i])+c);
            System.out.println("f("+(x[i]+") = "+result));
        }
    }

    /**
     * Metoda odbiera od użytkownika wartość liczbową i sprawdza poprawność jej wpisania.
     * @return liczba typu double podana przez użytkownika.
     */
    private double userInput () {
            boolean isNumberOk;
        double userNumber=0;
        do {
            try {
                userNumber = scan.nextDouble()*1;
                isNumberOk=false;
            } catch (Exception exception) {
                System.out.println("Niepoprawne dane, spróbuj ponownie: ");
                scan.nextLine();
                isNumberOk=true;
            }
        } while (isNumberOk);
        return userNumber;
    }

    /**
     * Metoda odbiera od użytkownika wartość liczbową i sprawdza poprawność jej wpisania.
     * Pry pobraniu wartości od użytkownika wykorzystano metodę userInput() wraz z instrukcją warunkową if.
     * @return liczba typu double podana przez użytkownika (różna od 0).
     */
    private double userInputNoZero () {
        double x;
        do {
            x = userInput();
            if (x==0) {
                System.out.println("Wprowadź inną liczbę niż 0 !!!");
            }
        } while (x==0);
        return x;
    }

    /**
     * Metoda w której użytkownik wpisuje wartości funkcji a,b,c po czym wyliczana i wyświetlana jest z nich delta.
     * Dla odbierania wartości od użytkownika wykorzystano metody userInputNpZero() oraz userInput.
     */
    public void delta (){
        System.out.println("Obliczamy deltę dla f(x) = ax2+bx+c\nWprowadź liczbę odpowiadającą a: ");
        a=userInputNoZero();
        System.out.println("Wprowadź liczbę odpowiadającą b: ");
        b=userInput();
        System.out.println("Wprowadź liczbę odpowiadającą c: ");
        c=userInput();
        delta=(Math.pow(b,2))-(4*a*c);
        System.out.println("\nDelta wynosi: "+delta+"\n");
    }

    /**
     *  Na podstawie delty sprawdzana jest liczba pierwiatków dla funkcji, następnie są one wyliczane i wyświetlane.
     *  Wykorzystano instrucję warunkową if,else a przy obliczeniach z klasy Math.
     */
    public void roots () {
            double styczna1;
            double styczna2;
        if (delta>0){
            System.out.println("Mamy dwie styczne z osią X");
            styczna1 = (-b-Math.sqrt(delta))/2*a;
            styczna2 = (-b+Math.sqrt(delta))/2*a;
            System.out.println("Styczna 1 = "+styczna1+"\nStyczna 2 = "+styczna2);

        } else if (delta==0){
            System.out.println("Jedna styczna z osią X");
            styczna1 = -b/(2*a);
            System.out.println("Styczna 1 = "+styczna1);
        } else {
            System.out.println("Brak stycznych z osią X");
        }
    }

    /**
     * Metoda wyświetla zapytanie o kontynuację działania programu bądź jego zakończenie, użytkownik podejmuje decyzję T/N.
     * Wykorzystano instrukcję warunkową if,else oraz pętlę do while.
     * @return wartość boolowska true aby kontynuować, false aby zakończyć program.
     */
    public boolean quitOrNot () {
            String answer;
            boolean quit;
            do {
                System.out.println("\nChcesz dokonać kolejnych obliczeń?\nOdpowiedz: T/N");
                answer=scan.next().toUpperCase();
                if (answer.equals("T")){
                    return true;
                } else if (answer.equals("N")){
                    scan.close();
                    return false;
                } else {
                    System.out.println("Wpisano niepoprawną wartość, proszę spróbować ponownie!");
                    quit=true;
                }
            } while (quit);
            return true;
    }
    }