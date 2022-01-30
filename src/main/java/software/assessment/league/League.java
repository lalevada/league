package software.assessment.league;

import software.assessment.league.service.LocalFileProcessorService;
import software.assessment.league.service.MapLeagueTable;
import software.assessment.league.service.TableResultService;

import java.util.Arrays;

/**
 * @author Mark Andrews
 * Main class for the League application.
 */
public class League {

    /**
     * Main method.
     *
     * @param args String[] Array of result file names.
     */
    public static void main(final String[] args) {

        if (args.length >= 1) {

            var leagueTable = new MapLeagueTable();
            var resultService = new TableResultService(leagueTable);
            var fileReaderService = new LocalFileProcessorService(resultService);

            Arrays.stream(args).forEach(fileReaderService::processResultFile);
        } else {
            System.console().writer().println("At least one results filename must be specified. ");
        }
    }
}
