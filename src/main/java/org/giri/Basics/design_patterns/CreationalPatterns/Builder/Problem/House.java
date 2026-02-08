package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Builder.Problem;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarden;
    private boolean hasSwimmingPool;
    private boolean hasGarage;

    // we have to create multiple constructures if we want to handle with optional params
    public House(String foundation, String structure, String roof, boolean hasGarage, boolean hasGarden, boolean hasSwimmingPool) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        this.hasGarden = hasGarden; // optional
        this.hasSwimmingPool = hasSwimmingPool; // optional
        this.hasGarage = hasGarage; // optional
    }

    public String toString() {
        return "House {" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", hasGarden='" + hasGarage + '\'' +
                ", hasSwimmingPool='" + hasSwimmingPool + '\'' +
                ", hasGarage='" + hasGarage + "}";
    }
}
