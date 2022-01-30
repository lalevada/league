package software.assessment.league.service;

import software.assessment.league.domain.Points;
import software.assessment.league.domain.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mark Andrews
 */
public class TableResultService implements ResultService {

    private final LeagueTable table;

    private final static String filename = "LeagueTable.out";

    public TableResultService(final LeagueTable table) {
        this.table = table;
    }

    @Override
    public void processResult(final Result result) {

        var leftTeam = result.getLeftScore().getTeam();
        var rightTeam = result.getRightScore().getTeam();
        var leftGoals = result.getLeftScore().getGoals();
        var rightGoals = result.getRightScore().getGoals();

        if (leftGoals > rightGoals) {
            table.addPointsAward(leftTeam, Points.WIN);
            table.addPointsAward(rightTeam, Points.LOSE);
        } else if (leftGoals < rightGoals) {
            table.addPointsAward(leftTeam, Points.LOSE);
            table.addPointsAward(rightTeam, Points.WIN);
        } else {
            table.addPointsAward(leftTeam, Points.DRAW);
            table.addPointsAward(rightTeam, Points.DRAW);
        }
    }

    @Override
    public void printTable() throws IOException {

        try (var fileWriter = new FileWriter(filename); var printWriter = new PrintWriter(fileWriter)) {
            table.print(printWriter);
        }
    }
}
