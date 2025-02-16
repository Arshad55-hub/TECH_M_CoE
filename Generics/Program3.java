import java.util.List;

class Program3 {
    public static <T> int findIndex(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> names = List.of("Pencil", "Rubber", "Sharpner");
        System.out.println(findIndex(names, "Rubber"));
        System.out.println(findIndex(names, "Sharpner"));
    }
}
