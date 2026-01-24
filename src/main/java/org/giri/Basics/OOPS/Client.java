package main.java.org.giri.Basics.OOPS;

public class Client {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        paymentService.addPaymentMethod("GiridharCreditCard", new CreditCard("1234", "Giridhar"));
        paymentService.addPaymentMethod("GiridharDebitCard", new DebiCard("34143", "Giridhar"));
        paymentService.addPaymentMethod("GiridharUPI", new UPI("9847"));
        paymentService.addPaymentMethod("GiridharWallet", new Wallet("9347"));

        paymentService.makePayment("GiridharCreditCard");
        paymentService.makePayment("GiridharDebitCard");
        paymentService.makePayment("GiridharUPI");
        paymentService.makePayment("GiridharWallet");
    }
}
