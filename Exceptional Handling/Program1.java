
class Program1 {
    public static void main(String[] args) {
        try {
            int result = 5 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }
}
