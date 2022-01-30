package software.assessment.league.domain;

/**
 * @author Mark Andrews
 */
public class Result {

    private Score leftScore;

    private Score rightScore;

    public Result(final String scoreLineString) {

        String[] scores = scoreLineString.split(", ");

        leftScore = new Score(scores[0]);
        rightScore = new Score(scores[1]);
    }

    public Score getLeftScore() {
        return leftScore;
    }

    public void setLeftScore(final Score leftScore) {
        this.leftScore = leftScore;
    }

    public Score getRightScore() {
        return rightScore;
    }

    public void setRightScore(final Score rightScore) {
        this.rightScore = rightScore;
    }
}
