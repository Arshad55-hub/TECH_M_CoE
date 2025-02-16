import java.util.ArrayList;
import java.util.Collections;

class Program10 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        Collections.shuffle(colors);
        System.out.println(colors);
    }
}
