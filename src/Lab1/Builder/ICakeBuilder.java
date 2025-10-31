package Lab1.Builder;

public interface ICakeBuilder {
    void reset();
    void setBase(String base);
    void setCream(String cream);
    void setDecoration(String decoration);
    void setWeightGrams(int grams);
}
