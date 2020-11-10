import java.util.*;

public class GuitarSound implements Instrument {
    ArrayList<LinkedList<Double>> sounds = new ArrayList<LinkedList<Double>>();
    String alphabet = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    int CONCERT_A = 440;

    public GuitarSound() {
        for (int i = 0; i < 37; i++) {
            Double frequency = CONCERT_A * Math.pow(2.0, (i - 24) / 12.0);
            int size = (int) (44100 / frequency);

            LinkedList<Double> a = new LinkedList<Double>();
            while (a.size() < size) {
                a.add(0.0);
            }
            sounds.add(a);

        }
    }

    public void pluck(char key) {
        int temp = key % 37;
        if (temp == -1) {
            return;
        }
        for (int i = 0; i < sounds.get(temp).size(); i++) {
            double randomDouble = Math.random() - 0.5;
            sounds.get(temp).set(i, randomDouble);

        }

    }

    public void tick() {
        for (int i = 0; i < sounds.size(); i++) {
            Double average;
            LinkedList<Double> listA = sounds.get(i);
            average = (listA.get(0) + listA.get(1)) / 2;
            average = average * 0.994;
            listA.addLast(average);
            listA.remove(0);

        }

    }

    public double superposition() {
        Double sum = 0.0;
        int numOfLists = 0;
        for (int i = 0; i < sounds.size(); i++) {
            LinkedList<Double> listB = new LinkedList<Double>();
            listB = sounds.get(i);

            sum += listB.get(0);

        }
        return sum;

    }
}