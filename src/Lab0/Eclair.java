package Lab0;

class Eclair implements IProduct, IRecipe {
    @Override
    public String getName() { return "Eclair"; }
    @Override
    public double price() { return 6.5; }
    @Override
    public int grams() { return 90; }
    @Override
    public void recipe() {
        System.out.println("Eclair recipe: choux pastry (flour, water, butter, eggs), pastry cream, chocolate glaze. Pipe, bake, fill, glaze.");
    }
}
