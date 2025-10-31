package Lab1.Builder;

public class CakeBuilder implements ICakeBuilder {
    private Cake cake;

    public CakeBuilder() { reset(); }

    @Override
    public void reset() { cake = new Cake(); }

    @Override
    public void setBase(String base) { cake.setBase(base); }
    @Override
    public void setCream(String cream) { cake.setCream(cream); }
    @Override
    public void setDecoration(String decoration) { cake.setDecoration(decoration); }
    @Override
    public void setWeightGrams(int grams) { cake.setWeightGrams(grams); }

    public Cake getProduct() {
        Cake built = cake;
        reset();
        return built;
    }
}
