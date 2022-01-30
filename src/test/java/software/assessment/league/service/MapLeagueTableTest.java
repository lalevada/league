package software.assessment.league.service;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static software.assessment.league.domain.Points.DRAW;
import static software.assessment.league.domain.Points.WIN;

/**
 * @author Mark Andrews
 */
class MapLeagueTableTest {

    @Test
    void testAddPointsAward() {

        String arsenal = "Arsenal";

        var table = new MapLeagueTable();

        table.addPointsAward(arsenal, WIN);

        assertThat(table.resultStore).hasSize(1);
        assertThat(table.resultStore.get(arsenal).get()).isEqualTo(WIN.getValue());
    }

    @Test
    void testMultiplePointsAward() {

        String arsenal = "Arsenal";

        var table = new MapLeagueTable();

        table.addPointsAward(arsenal, WIN);
        table.addPointsAward(arsenal, DRAW);

        assertThat(table.resultStore).hasSize(1);
        assertThat(table.resultStore.get(arsenal).get()).isEqualTo(WIN.getValue() + DRAW.getValue());
    }

    @Test
    void testMultipleTeamsPointsAward() {

        String arsenal = "Arsenal";
        String spurs = "Spurs";

        var table = new MapLeagueTable();

        table.addPointsAward(arsenal, WIN);
        table.addPointsAward(arsenal, DRAW);
        table.addPointsAward(spurs, DRAW);

        assertThat(table.resultStore).hasSize(2);
        assertThat(table.resultStore.get(arsenal).get()).isEqualTo(WIN.getValue() + DRAW.getValue());
        assertThat(table.resultStore.get(spurs).get()).isEqualTo(DRAW.getValue());
    }

    @Test
    void testPrint() throws IOException {

        var filename = "output.txt";
        var table = new MapLeagueTable();
        populateMap(table.resultStore);

        try (FileWriter fileWriter = new FileWriter(filename); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            table.print(printWriter);
        }

        var builder = new StringBuilder();
        try (var stream = Files.lines(Paths.get(filename))) {
            stream.forEach(builder::append);
        }
        catch (Exception e) {
            fail("There should be no Exception");
        }

        assertThat(builder.toString()).isEqualTo(expectedFileContent());

        Files.deleteIfExists(Paths.get(filename));
    }

    private void populateMap(final Map<String, AtomicInteger> map) {

        map.put("Brentford", new AtomicInteger(5));
        map.put("Saints", new AtomicInteger(11));
        map.put("Manchester United", new AtomicInteger(9));
        map.put("manchester City", new AtomicInteger(9));
        map.put("Arsenal", new AtomicInteger(12));
        map.put("Spurs", new AtomicInteger(1));
        map.put("Wolves", new AtomicInteger(10));
        map.put("Chelsea", new AtomicInteger(9));
    }

    private String expectedFileContent() {

        var builder = new StringBuilder("1. Arsenal, 12 pts");
        builder.append("2. Saints, 11 pts")
               .append("3. Wolves, 10 pts")
               .append("4. Chelsea, 9 pts")
               .append("4. manchester City, 9 pts")
               .append("4. Manchester United, 9 pts")
               .append("7. Brentford, 5 pts")
               .append("8. Spurs, 1 pt");

        return builder.toString();
    }
}
