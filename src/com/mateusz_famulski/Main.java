package com.mateusz_famulski;

/**
 * Program oblicza wartości jakie przyjmuje funkcja f(x) = ax2+bx+c.
 * Zarówno dziedzina funkcji jak i jej parametry podaje użytkownik.
 * Projekt zawiera się w dwóch klasach Main oraz Logika.
 * Program testowany na poprawnych danych wejściowych nie ujawnił błędów.Zastosowano obsługę wyjątków w przypadku
 * wprowadzenia przez użytkownika błędnego rodzaju danych w tym 0 (dla dziedziny i parametru a).
 * Przetestowano program przy błędnych danych - program dobrze obsługuje błędy.
 * Program pisany w IntelliJ IDEA na Windows 10. Wersja javy "1.8.0_144".
 *
 *  @author Mateusz Famulski
 *  @version 0.1
 */

public class Main {

    public static void main(String[] args) {
        boolean exit;

        do {
            System.out.println("Witaj w programie obliczającym wartość funkcji f(x) = ax2+bx+c\n" +
                    "Wyliczymy deltę, pierwiastki i wartości funkcji dla podanej dziedziny, zaczynamy :)\n");
            Logika log = new Logika();
            log.delta();
            log.roots();
            log.fxCount(log.tab1());
            exit = log.quitOrNot();
        } while (exit);

    }
}
