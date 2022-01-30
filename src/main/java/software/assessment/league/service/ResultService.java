package software.assessment.league.service;

import software.assessment.league.domain.Result;

/**
 * @author Mark Andrews
 */
public interface ResultService {

    /**
     * Process a game result.
     *
     * @param result Result The result of a game.
     */
    void processResult(Result result);

    /**
     * Print the content of a league table to a location defined in this service.
     *
     * @throws Exception An error occurred that should be acted upon by the caller.
     */
    void printTable() throws Exception;
}
