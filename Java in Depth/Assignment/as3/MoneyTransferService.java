public class MoneyTransferService {
    
private final CurrencyConverter cc = new CurrencyConverter();

    public static void main(String[] args) {

        MoneyTransferService transferService = new MoneyTransferService();

        double transferAmount = transferService.computeTransferAmount(0, 1000);

        double transferFee = transferService.computeTransferFee(0, 1000);

        System.out.println("Transfer Amount: " + transferAmount);

        System.out.println("Transfer Fee: " + transferFee);

    }

    private double computeTransferAmount(int countryIndex,double amount) {
        return cc.computeTransferAmount(countryIndex, amount);
    }

    private double computeTransferFee(int countryIndex, double amount) {
        return computeTransferAmount(countryIndex, amount)*0.02;
    }
}
