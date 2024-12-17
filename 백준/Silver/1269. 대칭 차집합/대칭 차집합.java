import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aSize = sc.nextInt();
        int bSize = sc.nextInt();

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        for (int i = 0; i < aSize; i++) {
            setA.add(sc.nextInt());
        }

        for (int i = 0; i < bSize; i++) {
            setB.add(sc.nextInt());
        }

        HashSet<Integer> aMinusB = new HashSet<>(setA);
        aMinusB.removeAll(setB);

        HashSet<Integer> bMinusA = new HashSet<>(setB);
        bMinusA.removeAll(setA);

        int size = aMinusB.size() + bMinusA.size();
        System.out.println(size);
    }
}