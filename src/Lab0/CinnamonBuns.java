package Lab0;

class CinnamonBuns implements IProduct, IRecipe {
    @Override
    public String getName() { return "Cinnamon Buns"; }
    @Override
    public double price() { return 7.75; }
    @Override
    public int grams() { return 120; }
    @Override
    public void recipe() {
        System.out.println("Cinnamon Buns recipe: flour, yeast, milk, sugar, butter, cinnamon. Knead, proof, roll, fill, bake.");
    }
}