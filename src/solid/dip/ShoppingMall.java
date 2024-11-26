package solid.dip;

public class ShoppingMall {
    DebitCard debitCard;

    public ShoppingMall(DebitCard debitCard) {
        this.debitCard = debitCard;
    }
    public void doPurchaseSomething(long amount){
        debitCard.doPayment(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard1 = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(debitCard1);
        shoppingMall.doPurchaseSomething(5000);
    }
}
/* Here ShoppingMall is titled coupled with DebitCard, Now let's say
    debit card is not working, and we want to use credit card then we
    have to do lot of change in shopping mall class. so it is not good.
    It is not following dependency inversion principle.
 */
