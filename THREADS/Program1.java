class Program1 extends Thread {
    public void run() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        Program1 t1 = new Program1();
        t1.start();
    }
}
