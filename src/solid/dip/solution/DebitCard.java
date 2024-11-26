package solid.dip.solution;

public class DebitCard implements BankCard{
    @Override
    public void doPayment(long amount) {
        System.out.println("Payment using debit card");
    }
}
