import java.util.ArrayList;

class Program5 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.set(0, "Yellow");
        System.out.println(colors);
    }
}
