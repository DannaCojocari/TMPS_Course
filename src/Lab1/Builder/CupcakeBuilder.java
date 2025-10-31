package Lab1.Builder;

public class CupcakeBuilder implements ICakeBuilder {
    private Cupcake cupcake;

    public CupcakeBuilder() { reset(); }

    @Override
    public void reset() { cupcake = new Cupcake(); }

    @Override
    public void setBase(String base) { cupcake.setBase(base); }
    @Override
    public void setCream(String cream) { cupcake.setCream(cream); }
    @Override
    public void setDecoration(String decoration) { cupcake.setDecoration(decoration); }
    @Override
    public void setWeightGrams(int grams) { cupcake.setWeightGrams(grams); }

    public Cupcake getProduct() {
        Cupcake built = cupcake;
        reset();
        return built;
    }
}

