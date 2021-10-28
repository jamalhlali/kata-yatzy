import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class YatzyAggregator implements ArgumentsAggregator {

    class YatzyTestCase {
        private Yatzy yatzy;
        private int expected;

        public YatzyTestCase(ArgumentsAccessor argumentsAccessor) {
            yatzy = new Yatzy(argumentsAccessor.getInteger(1), argumentsAccessor.getInteger(2),
                    argumentsAccessor.getInteger(3), argumentsAccessor.getInteger(4), argumentsAccessor.getInteger(5));
            expected = argumentsAccessor.getInteger(0);
        }

        public Yatzy getYatzy() {
            return yatzy;
        }

        public int getExpected() {
            return expected;
        }
    }

    @Override
    public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
        return new YatzyTestCase(argumentsAccessor);
    }

}
