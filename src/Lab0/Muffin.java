package Lab0;

class Muffin implements IProduct, IRecipe {
    @Override
    public String getName() { return "Muffin"; }
    @Override
    public double price() { return 5.25; }
    @Override
    public int grams() { return 100; }
    @Override
    public void recipe() {
        System.out.println("Muffin recipe: flour, sugar, eggs, milk, baking powder, butter. Mix, scoop, bake.");
    }
}
