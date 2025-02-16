class PrimeSumThread extends Thread {
    int start, end;
    int sum = 0;

    PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) sum += i;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

class Program5 {
    public static void main(String[] args) {
        int limit = 50;
        PrimeSumThread t1 = new PrimeSumThread(1, limit / 2);
        PrimeSumThread t2 = new PrimeSumThread((limit / 2) + 1, limit);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = t1.sum + t2.sum;
        System.out.println("Sum of prime numbers up to " + limit + ": " + totalSum);
    }
}
