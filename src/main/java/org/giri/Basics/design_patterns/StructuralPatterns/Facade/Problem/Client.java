package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Facade.Problem;

public class Client {
    public static void main(String[] args) {
        UserService user = new UserService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        System.out.println(user.getUserDetails("dlfjaslf"));
        System.out.println(orderService.getOrderDetails("kldjflaj"));
        System.out.println(paymentService.getPaymentDetails("lasdjfa"));
    }
}
