package Lab1.Builder;

public class Cake {
    private String base;
    private String cream;
    private String decoration;
    private int weightGrams;
    private double price;

    // Getters and setters
    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }

    public String getCream() { return cream; }
    public void setCream(String cream) { this.cream = cream; }

    public String getDecoration() { return decoration; }
    public void setDecoration(String decoration) { this.decoration = decoration; }

    public int getWeightGrams() { return weightGrams; }
    public void setWeightGrams(int weightGrams) {
        this.weightGrams = weightGrams;
        calculatePrice();
    }

    public double getPrice() { return price; }

    // Simple price calculation
    private void calculatePrice() {
        double basePrice = 10.0; // default
        if (base != null) {
            switch (base.toLowerCase()) {
                case "chocolate": basePrice = 15.0; break;
                case "red velvet": basePrice = 18.0; break;
            }
        }
        price = Math.round((basePrice + weightGrams * 0.02) * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("Cake [Base: %s, Cream: %s, Decoration: %s, Weight: %dg, Price: $%.2f]",
                base, cream, decoration, weightGrams, price);
    }
}
