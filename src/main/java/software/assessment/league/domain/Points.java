package software.assessment.league.domain;

/**
 * @author Mark Andrews
 */
public enum Points {
    WIN(3),
    DRAW(1),
    LOSE(0);

    private final int value;

    Points(final int pointsValue) {
        value = pointsValue;
    }

    public int getValue() {
        return value;
    }
}
