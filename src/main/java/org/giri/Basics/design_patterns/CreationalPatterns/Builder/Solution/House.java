package main.java.org.giri.Basics.design_patterns.CreationalPatterns.Builder.Solution;


public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarden;
    private boolean hasSwimmingPool;
    private boolean hasGarage;

    // we have to create multiple constructures if we want to handle with optional params
    public House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.hasGarden = builder.hasGarden; // optional
        this.hasSwimmingPool = builder.hasSwimmingPool; // optional
        this.hasGarage = builder.hasGarage; // optional
    }

    public String toString() {
        return "House {" +
                "foundation='" + foundation + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", hasGarden='" + hasGarden + '\'' +
                ", hasSwimmingPool='" + hasSwimmingPool + '\'' +
                ", hasGarage='" + hasGarage + "}";
    }

    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private boolean hasGarden;
        private boolean hasSwimmingPool;
        private boolean hasGarage;

        public HouseBuilder(String foundation, String structure, String roof) {
            this.foundation = foundation;
            this.structure = structure;
            this.roof = roof;
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public HouseBuilder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public House build(){
            return new House(this);
        }
    }
}
