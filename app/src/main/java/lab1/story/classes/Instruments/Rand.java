package lab1.story.classes.Instruments;

import java.util.ArrayList;

public class Rand {

    public static int randInt(int low, int high) {
        return (int)(Math.random() * (high-low+1)) + low;
    }

    public static <T> T randChoice(ArrayList<T> arrayList) {
        int idx = randInt(0, arrayList.size() - 1);
        return arrayList.get(idx);
    }
}
