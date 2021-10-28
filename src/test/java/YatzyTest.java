import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


public class YatzyTest {

    @ParameterizedTest
    @CsvSource({
            "15, 2, 3, 4, 5, 1",
            "16, 3, 3, 4, 5, 1"
    })
    public void chance(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().chance());
    }

    @ParameterizedTest
    @CsvSource({
            "50, 4, 4, 4, 4, 4",
            "50, 6, 6, 6, 6, 6",
            "0, 6, 6, 6, 6, 3"
    })
    public void yatzy(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().yatzy());
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2, 3, 4, 5",
            "2, 1, 2, 1, 4, 5",
            "0, 6, 2, 2, 4, 5",
            "4, 1, 2, 1, 1, 1"
    })
    public void ones(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().ones());
    }

    @ParameterizedTest
    @CsvSource({
            "4, 1, 2, 3, 2, 6",
            "10, 2, 2, 2, 2, 2",
            "0, 1, 3, 5, 4, 4"
    })
    public void tows(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().twos());
    }

    @ParameterizedTest
    @CsvSource({
            "6, 1, 2, 3, 2, 3",
            "12, 2, 3, 3, 3, 3"
    })
    public void threes(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().threes());
    }

    @ParameterizedTest
    @CsvSource({
            "12, 4, 4, 4, 5, 5",
            "8, 4, 4, 5, 5, 5",
            "4, 4, 1, 5, 5, 5",
            "0, 2, 2, 5, 5, 5",
    })
    public void fours(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().fours());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 4, 4, 4, 5, 5",
            "15, 4, 4, 5, 5, 5",
            "20, 4, 5, 5, 5, 5"
    })
    public void fives(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().fives());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 4, 4, 4, 5, 5",
            "6, 4, 4, 6, 5, 5",
            "18, 6, 5, 6, 6, 5"
    })
    public void sixes(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().sixes());
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 4, 3, 5, 6",
            "10,5, 3, 3, 3, 5",
            "12,5, 3, 6, 6, 5",
            "0, 2, 3, 6, 1, 5",
    })
    public void pair(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().pair());
    }

    @ParameterizedTest
    @CsvSource({
            "16,3, 3, 5, 4, 5",
            "16,3, 3, 5, 5, 5",
            "8, 1, 1, 2, 3, 3",
            "0, 1, 1, 2, 3, 4",
            "6, 1, 1, 2, 2, 2",
            "0, 2, 3, 6, 1, 5"
    })
    public void twoPairs(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().twoPairs());
    }

    @ParameterizedTest
    @CsvSource({
            "9,3, 3, 3, 4, 5",
            "9,3, 3, 3, 3, 1",
            "0,3, 3, 4, 5, 6"
    })
    public void threeOfAKind(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().threeOfAKind());
    }

    @ParameterizedTest
    @CsvSource({
            "8, 2, 2, 2, 2, 5",
            "0, 2, 2, 2, 5, 5",
            "8, 2, 2, 2, 2, 2"
    })
    public void fourOfAKind(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().fourOfAKind());
    }

    @ParameterizedTest
    @CsvSource({
            "15, 1, 2, 3, 4, 5",
            "15, 2, 3, 4, 5, 1",
            "0, 1, 2, 2, 4, 5"
    })
    public void smallStraight(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().smallStraight());
    }

    @ParameterizedTest
    @CsvSource({
            "20, 6, 2, 3, 4, 5",
            "20, 2, 3, 4, 5, 6",
            "0, 1, 2, 2, 4, 5"
    })
    public void largeStraight(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().largeStraight());
    }

    @ParameterizedTest
    @CsvSource({
            "18, 6, 2, 2, 2, 6",
            "0, 2, 3, 4, 5, 6"
    })
    public void fullHouse(@AggregateWith(YatzyAggregator.class) YatzyAggregator.YatzyTestCase yatzyTestCase) {
        assertEquals(yatzyTestCase.getExpected(), yatzyTestCase.getYatzy().fullHouse());
    }

    @Test
    public void score() {
        assertEquals(18, new Yatzy(6, 2, 2, 2, 6).score(Category.FULLHOUSE));
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).score(Category.LARGESTRAIGHT));
    }

    @Test
    void dicesMustNotExceedSixItems() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Yatzy(1, 2, 2, 2, 6, 3, 8);
        });
    }

    @Test
    void diceMustNotExceedSix() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Yatzy(7, 2, 2, 2, 3);
        });
    }
}
