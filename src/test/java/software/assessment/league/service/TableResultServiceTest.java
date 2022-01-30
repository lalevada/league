package software.assessment.league.service;

import org.junit.jupiter.api.Test;
import software.assessment.league.domain.Result;

import java.io.PrintWriter;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static software.assessment.league.domain.Points.DRAW;
import static software.assessment.league.domain.Points.LOSE;
import static software.assessment.league.domain.Points.WIN;

/**
 * @author Mark Andrews
 */
public class TableResultServiceTest {

    @Test
    void testProcessResultsLeftWin() {

        var table = mock(LeagueTable.class);
        var tableResultService = new TableResultService(table);
        var result1 = new Result("Arsenal 11, Chelsea 0");

        tableResultService.processResult(result1);

        verify(table).addPointsAward("Arsenal", WIN);
        verify(table).addPointsAward("Chelsea", LOSE);
        reset(table);

        var result2 = new Result("Manchester United 1, Bristol Rovers 7");

        tableResultService.processResult(result2);

        verify(table).addPointsAward("Manchester United", LOSE);
        verify(table).addPointsAward("Bristol Rovers", WIN);
        reset(table);

        var result3 = new Result("Spurs 0, Leyton Orient 0");

        tableResultService.processResult(result3);

        verify(table).addPointsAward("Spurs", DRAW);
        verify(table).addPointsAward("Leyton Orient", DRAW);
    }

    @Test
    void testPrintTable() {

        var table = mock(LeagueTable.class);
        var tableResultService = new TableResultService(table);

        try {
            tableResultService.printTable();
        } catch (Exception e) {
            fail("There should be no Exception");
        }

        verify(table).print(isA(PrintWriter.class));
    }
}