import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        PriorityQueue<Integer> twoEvenSquares = numbers.stream().parallel().filter(n -> {
            System.out.println(Thread.currentThread().getName() + " filtering " + n);
            return n % 2 == 0;
        }).map(n -> {
            System.out.println(Thread.currentThread().getName() + " mapping " + n);
            return n * n;
        }).limit(4)
//            .collect(Collectors.toList());
                .collect(Collectors.toCollection(PriorityQueue::new));

        for(Integer i : twoEvenSquares)
        {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
