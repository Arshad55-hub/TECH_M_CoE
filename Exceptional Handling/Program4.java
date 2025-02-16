class Program4 {
    static void checkNumber(int num) {
        if (num > 0) {
            throw new IllegalArgumentException("Positive numbers not allowed");
        }
    }

    public static void main(String[] args) {
        try {
            checkNumber(5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
