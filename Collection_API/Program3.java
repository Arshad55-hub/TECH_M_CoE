import java.util.ArrayList;

class Program3 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Green");
        colors.add(0, "Red");
        System.out.println(colors);
    }
}
