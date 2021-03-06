package generics.collections.comparable.comparator;

import java.util.Comparator;

public class ComparatorTest2 {
}

class Squirrel {
    private int weight;
    private String species;

    public Squirrel(String theSpecies) {
        if (theSpecies == null) throw new IllegalArgumentException();
        species = theSpecies;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }
}

class MultiFieldComparator implements Comparator<Squirrel> {
    public int compare(Squirrel s1, Squirrel s2) {
        int result = s1.getSpecies().compareTo(s2.getSpecies());
        if (result != 0) return result;
        return s1.getWeight() - s2.getWeight();
    }
}

class ChainingComparator implements Comparator<Squirrel> { // Check again
    public int compare(Squirrel s1, Squirrel s2) {
        Comparator<Squirrel> c = Comparator.comparing(Squirrel::getSpecies); // sort by species
        c = c.thenComparing(Squirrel::getWeight); // sort by weight
        return c.compare(s1, s2); // pass above condition to compare
    }
}