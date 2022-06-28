import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;


public class JavaBasics {

    public static void main(String[] args) {
        String s1 = "Hello";
        s1 += "World";

        String s2 = "Hello";
        s2 += "";
        s2 += "World";

        String s3 = s1.intern();
        String s4 = s2.intern();

        boolean b1 = s3 == s4;
        boolean b2 = s3.equals(s4);
        System.out.println(b1 + "  " + b2);

        myValue<String> ob1 = new myValue<>("hello");
        myValue<Integer> ob2 = new myValue<>(1234);
        System.out.print(ob1.getValue());
        System.out.print(ob2.getValue());

        Integer value = ob2.getValue();

        value++;

        assert value == null && value >= 10;
        System.out.println(value);

        int[] arr = {1, 2, 4, 3, 5, 7};

        int result = Arrays.stream(arr).filter(i -> i % 2 == 0).map(i -> i * 2).sum();
        System.out.println(result);

        Comparator<Integer> comp = (Integer num1, Integer num2) -> num2.compareTo(num1);

        Integer[] arr2 = {1, 2, 4, 3, 5, 7};
        Arrays.sort(arr2, comp);
        System.out.println(Arrays.toString(arr2));

        Test t = new Test();
        System.out.println(t.num);

        FuncInterface fun = (a, b) -> a * b;
        Function<Integer, Integer> fun2 = a -> a * a;


        fun2.apply(10);

        System.out.println(fun.compute(10, 20));

        // here in the right side angular braces i can only have a class
        //which is a subclass of IOException
        Set<? extends IOException> mySet = new HashSet<>();

        Consumer<String> printer = (name) -> System.out.println("hello " + name + "!");
        Consumer<String> welcome = (name) -> System.out.println("Welcome to java programming");

        printer.andThen(welcome).accept("Programmer");

        List<Integer> nums = Arrays.asList(4, 3, 2, 1, 9, 4);

        nums.forEach(System.out::println);

        //Method reference
        nums.forEach(JavaBasics::fun);
        nums.forEach(new JavaBasics()::fun2);

        //Function interface
        Function<Integer, Integer> func = (i) -> i * i;
        int output = func.apply(10);
        System.out.println(output);
        output = func.andThen(func).apply(2);
        System.out.println(output);

        new JavaBasics().fileOp();
    }

    static void fun(int i) {
        System.out.print(" printing something " + i);
    }

    void fun2(int i) {
        System.out.print(" printing something " + i);
    }

    void fileOp() {
        try (PrintWriter p = new PrintWriter("test.txt")) {
            p.println();
            int abc;
            abc = 123;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class myValue<T> {
    T value;

    myValue(T val) {
        value = val;
    }

    public T getValue() {
        return value;
    }
}


class Test {

    // p3
    int num = 10;

    //p1
    //overwrites the value
    Test() {
        num = 20;
    }

    //p2
    //first priority if there is no constructor
    {
        num = 30;
    }
}

@FunctionalInterface()
interface FuncInterface {
    int abc = 0;
    int abcd = 1;

    int compute(int a, int b);

    default int computeSomething() {
        System.out.println("hello");
        return abc;
    }

    static void somethingstatic() {
        System.out.println("something static ->" + abc);
    }
}
