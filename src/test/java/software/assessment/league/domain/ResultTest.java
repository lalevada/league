package software.assessment.league.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Mark Andrews
 */
class ResultTest {

    @Test
    void testConstructor() {

        var resultString = "Arsenal 11, Tottenham HotSpur 0";
        var result = new Result(resultString);

        assertThat(result.getLeftScore()).isNotNull();
        assertThat(result.getRightScore()).isNotNull();
        assertThat(result.getRightScore().getGoals()).isEqualTo(0);
        assertThat(result.getRightScore().getTeam()).isEqualTo("Tottenham HotSpur");
        assertThat(result.getLeftScore().getGoals()).isEqualTo(11);
        assertThat(result.getLeftScore().getTeam()).isEqualTo("Arsenal");
    }
}
