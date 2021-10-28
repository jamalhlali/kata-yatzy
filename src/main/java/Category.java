public enum Category {
    CHANCE {
        public int score(Yatzy yatzy) {
            return yatzy.chance();
        }
    },
    YATZY {
        public int score(Yatzy yatzy) {
            return yatzy.yatzy();
        }
    },
    ONES {
        public int score(Yatzy yatzy) {
            return yatzy.ones();
        }
    },
    TWOS {
        public int score(Yatzy yatzy) {
            return yatzy.twos();
        }
    },
    THREES {
        public int score(Yatzy yatzy) {
            return yatzy.threes();
        }
    },
    FOURS {
        public int score(Yatzy yatzy) {
            return yatzy.fours();
        }
    },
    FIVES {
        public int score(Yatzy yatzy) {
            return yatzy.fives();
        }
    },
    SIXES {
        public int score(Yatzy yatzy) {
            return yatzy.sixes();
        }
    },
    PAIR {
        public int score(Yatzy yatzy) {
            return yatzy.pair();
        }
    },
    TWOPAIRS {
        public int score(Yatzy yatzy) {
            return yatzy.twoPairs();
        }
    },
    THREEOFAKIND {
        public int score(Yatzy yatzy) {
            return yatzy.threeOfAKind();
        }
    },
    FOUROFAKIND {
        public int score(Yatzy yatzy) {
            return yatzy.fourOfAKind();
        }
    },
    SMALLSTRAIGHT {
        public int score(Yatzy yatzy) {
            return yatzy.smallStraight();
        }
    },
    LARGESTRAIGHT {
        public int score(Yatzy yatzy) {
            return yatzy.largeStraight();
        }
    },
    FULLHOUSE {
        public int score(Yatzy yatzy) {
            return yatzy.fullHouse();
        }
    };

    public abstract int score(Yatzy yatzy);

}
