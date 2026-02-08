package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Facade.Solution;


public class APIGateway {
    private UserService userService;
    private OrderService orderService;
    private PaymentService paymentService;

    public APIGateway() {
        this.userService = new UserService();
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
    }

    public String getFullOrderDetails(String userId, String orderId, String paymentId) {

        return "User id: " + userId + ", Order id: " + orderId + ", Payment id: " + paymentId;
    }
}
