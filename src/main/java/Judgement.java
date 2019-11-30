public class Judgement {
    private int holdCount;

    public Judgement(int holdCount) {
        this.holdCount = holdCount;
    }

    public boolean checkResult(Integer[] player, Integer[] rival) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < player.length; i++) {
            if (player[i].equals(rival[i])) {
                strike++;
            } else if (isBall(player[i], i, rival)) {
                ball++;
            }
        }

        printState(strike, ball);
        return (strike == holdCount);
    }

    private boolean isBall(int value, int index, Integer[] input) {
        for (int i = 0; i < input.length; i++) {
            if (index != i && value == input[i]) {
                return true;
            }
        }

        return false;
    }

    private void printState(int strike, int ball) {
        int nothing = holdCount - (strike + ball);

        if (nothing == holdCount) {
            System.out.println("nothing");
        } else {
            System.out.println(strike + " strike, " + ball + " ball");
        }
    }
}
