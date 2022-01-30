package software.assessment.league.service;

/**
 * @author Mark Andrews
 */
public interface FileProcessorService {

    /**
     * Read a result file and inform the result service of the outcome.
     *
     * @param filename The name of the results file.
     */
    void processResultFile(String filename);
}
