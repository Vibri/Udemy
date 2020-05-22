public class CurrencyConverter {

    private int rupee = 63;
    private int dirham = 3;
    private int _yen = 107;
    private int $australian = 2;
    private int real = 3;
    private int chilean_peso = 595;
    private int mexican_peso = 18;
    private int dollar;
    private int Rupee = 63;

    private void printCurrencies() {
        System.out.println("rupee: " + rupee);
        System.out.println("dirham: " + dirham);
        System.out.println("_yen: " + _yen);
        System.out.println("$autralian: " + $australian);
        System.out.println("real: " + real);
        System.out.println("chilean_peso: " + chilean_peso);
        System.out.println("mexican_peso: " + mexican_peso);
        System.out.println("dollar: " + dollar);
        System.out.println("Rupee: " + Rupee);
    }

    public static void main(String[] args) {
        CurrencyConverter cc = new CurrencyConverter();
        cc.printCurrencies();
    }
}