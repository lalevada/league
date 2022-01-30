package software.assessment.league.service;

import software.assessment.league.domain.Result;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Mark Andrews
 */
public class LocalFileProcessorService implements FileProcessorService {

    private final ResultService resultService;

    public LocalFileProcessorService(final ResultService resultService) {
        this.resultService = resultService;
    }

    @Override
    public void processResultFile(final String filename) {

        try (var stream = Files.lines(Paths.get(filename))) {
            stream.forEach(line -> resultService.processResult(new Result(line)));
        } catch (Exception e) {
            System.console().writer().println(String.format("An error occurred loading the results file : %s", filename));
        }

        try {
            resultService.printTable();
        } catch (Exception e) {
            System.console().writer().println("An error occurred printing the League Table. ");
        }
    }
}
