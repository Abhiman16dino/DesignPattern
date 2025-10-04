package AdapterDesignPattern;

public class PaymentAdapter implements PaymentProcessor {
    PayPalAPI payPalAPI;

    public PaymentAdapter(PayPalAPI payPalAPI) {
        this.payPalAPI = payPalAPI;
    }

    @Override
    public void pay(int amount) {
        payPalAPI.makePayement((double) amount);
        System.out.println("Payment of " + amount + " processed using PaymentAdapter.");
    }
}
