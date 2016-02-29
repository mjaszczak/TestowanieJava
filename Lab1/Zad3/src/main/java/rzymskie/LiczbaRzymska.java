package main.java.rzymskie;


public class LiczbaRzymska {
    private int liczba;


    public LiczbaRzymska(int wartosc) {
        liczba = wartosc;
    }

    public String toString() {
        if (liczba <= 0)
            throw new NumberFormatException();

        String wynik = "";
        int krok = liczba;

        String rzymskie[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int wartosci[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


        for (int i = 0; liczba > 0; i++) {
            krok = liczba / wartosci[i];
            for (int j = 1; j <= krok; j++) {
                wynik += rzymskie[i];
            }
            liczba = liczba % wartosci[i];
        }

        return wynik;
    }

}
