package Lab1.Builder;

public class Director {

    public void constructBirthdayTemplate(ICakeBuilder builder) {
        builder.setBase("Vanilla");
        builder.setCream("Chocolate");
        builder.setDecoration("Sprinkles");
        setWeight(builder);
    }

    public void constructHalloweenTemplate(ICakeBuilder builder) {
        builder.setBase("Pumpkin Spice");
        builder.setCream("Orange Buttercream");
        builder.setDecoration("Chocolate Spider Web");
        setWeight(builder);
    }

    public void constructChristmasTemplate(ICakeBuilder builder) {
        builder.setBase("Gingerbread");
        builder.setCream("Cinnamon Cream");
        builder.setDecoration("Snowflake Icing");
        setWeight(builder);
    }

    private void setWeight(ICakeBuilder builder) {
        if (builder instanceof CakeBuilder) {
            builder.setWeightGrams(1200);
        } else if (builder instanceof CupcakeBuilder) {
            builder.setWeightGrams(150);
        } else {
            builder.setWeightGrams(100);
        }
    }
}
