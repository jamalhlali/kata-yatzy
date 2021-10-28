import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Yatzy implements IYatzy {

    private List<Integer> dices;

    public Yatzy(Integer... elements) {
        if (elements.length > 6) {
            throw new IllegalArgumentException("dices must not exceed 6 items");
        }
        if (Arrays.stream(elements).anyMatch(e -> e.intValue() > 6)) {
            throw new IllegalArgumentException("dice must not exceed 6");
        }
        dices = List.of(elements);
    }

    @Override
    public int chance() {
        return dices.stream().reduce(0, Integer::sum);
    }

    @Override
    public int yatzy() {
        if (dices.stream().distinct().count() != 1) {
            return 0;
        }
        return 50;
    }

    @Override
    public int ones() {
        return sumOfNbElement(1);
    }

    @Override
    public int twos() {
        return sumOfNbElement(2);
    }

    @Override
    public int threes() {
        return sumOfNbElement(3);
    }

    @Override
    public int fours() {
        return sumOfNbElement(4);
    }

    @Override
    public int fives() {
        return sumOfNbElement(5);
    }

    @Override
    public int sixes() {
        return sumOfNbElement(6);
    }

    @Override
    public int pair() {
        return xOfKind(2);
    }

    @Override
    public int twoPairs() {
        Map<Integer, Integer> dicesToMapElementValue = dicesToMapElementValue();
        try {
            Stream<Map.Entry<Integer, Integer>> filterStream = dicesToMapElementValue.entrySet().stream().filter(e -> e.getValue() >= 2);
            if (filterStream.count() > 1) {
                return dicesToMapElementValue.entrySet().stream().filter(e -> e.getValue() >= 2).mapToInt(i -> i.getKey()).sum() * 2;
            }
            return 0;

        } catch (NoSuchElementException e) {
            return 0;
        }

    }

    @Override
    public int threeOfAKind() {
        return xOfKind(3);
    }

    @Override
    public int fourOfAKind() {
        return xOfKind(4);
    }

    @Override
    public int smallStraight() {
        if (xOfStraight(6)) {
            return 15;
        }
        return 0;
    }

    @Override
    public int largeStraight() {
        if (xOfStraight(1)) {
            return 20;
        }
        return 0;

    }

    @Override
    public int fullHouse() {
        Map<Integer, Integer> dicesToMapElementValue = dicesToMapElementValue();
        if (dicesToMapElementValue.entrySet().stream().allMatch(e -> e.getValue() == 2 || e.getValue() == 3)) {
            return dicesToMapElementValue.entrySet().stream().mapToInt(e -> e.getValue() * e.getKey()).sum();
        }
        return 0;
    }

    @Override
    public int score(Category category) {
        return category.score(this);
    }

    private int xOfKind(int value) {
        try {
            Map<Integer, Integer> dicesToMapElementValue = dicesToMapElementValue();
            return dicesToMapElementValue.entrySet().stream().filter(e -> e.getValue() >= value).max(Map.Entry.comparingByKey()).get().getKey() * value;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    private boolean xOfStraight(int value) {
        Map<Integer, Integer> dicesToMapElementValue = dicesToMapElementValue();
        return dicesToMapElementValue.entrySet().stream().allMatch(e -> e.getValue() == 1 && e.getKey() != value);
    }

    private Integer sumOfNbElement(int element) {
        return dices.stream().filter(n -> n == element).reduce(0, Integer::sum);
    }

    private Map<Integer, Integer> dicesToMapElementValue() {
        return dices.stream().sorted().
                collect(Collectors.toMap(
                        w -> w, w -> 1, Integer::sum));
    }

}



