package org.example;
import java.math.BigInteger;
import java.util.PriorityQueue;

final class hummingUretme {
    private static BigInteger THREE = BigInteger.valueOf(3);
    private static BigInteger FIVE = BigInteger.valueOf(5);

    private static void updateFrontier(BigInteger x,
                                       PriorityQueue<BigInteger> pq) {
        pq.offer(x.shiftLeft(1));
        pq.offer(x.multiply(THREE));
        pq.offer(x.multiply(FIVE));
    }

    public static BigInteger hamming(int n) {
        PriorityQueue<BigInteger> frontier = new PriorityQueue<BigInteger>();
        updateFrontier(BigInteger.ONE, frontier);
        BigInteger lowest = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            lowest = frontier.poll();
            while (frontier.peek().equals(lowest))
                frontier.poll();
            updateFrontier(lowest, frontier);
        }
        return lowest;
    }
}

