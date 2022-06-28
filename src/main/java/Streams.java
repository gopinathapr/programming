import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        //Variable should be final or effectively final so num cannot be modified in
        // lambda method or inside the collections operation

        int num = 10;
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(10);
        numbers.add(5);
        Integer res = 1;
       /* System.out.println(Arrays.toString(numbers.stream().map(n -> {
            num = num + 2;
            return n * num;
        }).toArray()));*/
        System.out.println(Arrays.toString(numbers.stream().map(n -> n * num).toArray()));

        Stream.Builder<Integer> builder = Stream.builder();
        for (int i = 0; i < 10; i++) {
            builder.add(i);
        }
        Stream<Integer> s = builder.build();
        System.out.println(Arrays.toString(s.toArray()));

        System.out.println(Arrays.toString(Stream.generate(() -> 1).limit(10).toArray()));
        IntStream intStream = IntStream.range(1, 10);

        System.out.println("testme".chars());

        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("z"));
        Optional<String> anyElement = stream.findAny();
        System.out.println(anyElement.isPresent());

        List<String> list = Arrays.asList("abc1", "2", "3");
        Stream<String> str = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });

        System.out.println(counter);

        Optional<String> str2 = list.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        }).findFirst();
        System.out.println(counter);

        Optional<Integer> reduced = Arrays.asList(1, 3, 4, 5).stream().reduce(Integer::sum);
        Optional<Integer> reduced2 = Arrays.asList(1, 3, 4, 5).stream().reduce((a, b) -> a * b);
        System.out.println(reduced);
        System.out.println(reduced2);
    }

    private static long counter;

    static void wasCalled() {
        counter++;
    }
}
