package AdapterDesignPattern;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentAdapter(new PayPalAPI());
        paymentProcessor.pay(100);

//        Paying 100.0 using PayPal.
//        Payment of 100 processed using PaymentAdapter.
    }
}
