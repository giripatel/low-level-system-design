package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Builder.Solution;

public class WithBuilderPattern {
    public static void main(String[] args) {
        House house = new House.HouseBuilder("Concrete", "Steel", "Shingles")
                .setGarage(true)
                     .setGarden(true)
                     .build();
        System.out.println(house);
    }
}
