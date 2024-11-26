package solid.dip.solution;

public class ShoppingMall {
    BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }
    public void doPurchaseSomething(long amount){
        bankCard.doPayment(amount);
    }

    public static void main(String[] args) {
        //DebitCard debitCard1 = new DebitCard();
        BankCard bankCard1 = new CreditCard();
        ShoppingMall shoppingMall = new ShoppingMall(bankCard1);
        shoppingMall.doPurchaseSomething(5000);
    }
}
