package lab1.story.classes.Instruments;

import java.util.ArrayList;

public class ArrayListFromArray {

    public static <T> ArrayList<T> convert(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; ++i) {
            arrayList.add(array[i]);
        }

        return arrayList;
    }
}
