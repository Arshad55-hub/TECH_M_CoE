class Program2 {
    static void checkEven(int num) {
        if (num % 2 != 0) {
            throw new IllegalArgumentException("Odd number not allowed");
        }
    }

    public static void main(String[] args) {
        try {
            checkEven(3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
