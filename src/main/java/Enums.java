import java.util.Arrays;

public class Enums {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Direction.values()));


    }
}

enum Direction {
    EAST,
    WEST,
    NORTH,
    SOUTH;

}