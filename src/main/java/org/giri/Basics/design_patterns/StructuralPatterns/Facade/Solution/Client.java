package main.java.org.giri.Basics.design_patterns.StructuralPatterns.Facade.Solution;

public class Client {
    public static void main(String[] args) {

        APIGateway apiGateway = new APIGateway();
        System.out.println(apiGateway.getFullOrderDetails("98347jdfjakl", "9r8dlajfl", "048kldf"));
    }
}
