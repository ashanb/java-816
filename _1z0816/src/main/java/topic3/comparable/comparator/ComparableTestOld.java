package topic3.comparable.comparator;

public class ComparableTestOld {
}

class OldAnimal implements Comparable {
    private int id;

    @Override
    public int compareTo(Object o) {  // Method excepts Object
        return (id - ((OldAnimal) o).id);
    }

    public static void main(String[] args) {
        OldAnimal a1 = new OldAnimal();
        OldAnimal a2 = new OldAnimal();
        a1.id = 5;
        a2.id = 7;
        System.out.println(a1.compareTo(a2)); // -2
        System.out.println(a1.compareTo(a1)); // 0
        System.out.println(a2.compareTo(a1)); // 2
    }
}