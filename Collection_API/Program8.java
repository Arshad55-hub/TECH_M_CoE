import java.util.ArrayList;
import java.util.Collections;

class Program8 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Red");
        colors.add("Green");
        Collections.sort(colors);
        System.out.println(colors);
    }
}
