package software.assessment.league.service;

import software.assessment.league.domain.Points;
import java.io.PrintWriter;

/**
 * @author Mark Andrews
 */
public interface LeagueTable {

    /**
     * Append the points awarded to the underlying table.
     *
     * @param team String, the name of the team to award point.
     * @param points The points to award.
     */
    void addPointsAward(final String team, final Points points);

    /**
     * Instruct LeagueTable to print itself using the internally defined format.
     *
     * @param writer The writer to print to.
     */
    void print(final PrintWriter writer);
}
