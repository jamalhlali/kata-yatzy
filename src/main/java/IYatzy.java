public interface IYatzy {
    int chance();

    int yatzy();

    int ones();

    int twos();

    int threes();

    int fives();

    int sixes();

    int fours();

    int pair();

    int twoPairs();

    int threeOfAKind();

    int fourOfAKind();

    int smallStraight();

    int largeStraight();

    int fullHouse();

    int calculate(Score score);
}

