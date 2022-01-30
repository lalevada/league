package software.assessment.league.domain;

/**
 * @author Mark Andrews
 */
public class Score {

    private String team;

    private Integer goals;

    /* Construct a <code>Score</code> from a <code>String</code> containing a
     * team name and the number of goals scored.
     *
     * @param score String The String containing team name and goals scored.
     */
    public Score(final String scoreString) {

        var separator =scoreString.lastIndexOf(' ');

        goals = Integer.valueOf(scoreString.substring(separator + 1));
        team = scoreString.substring(0, separator);
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(final String team) {
        this.team = team;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(final Integer goals) {
        this.goals = goals;
    }
}
