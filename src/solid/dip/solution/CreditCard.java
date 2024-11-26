package solid.dip.solution;

public class CreditCard implements BankCard{
    @Override
    public void doPayment(long amount) {
        System.out.println("Payment using credit card");
    }
}
