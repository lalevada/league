package software.assessment.league.service;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Mark Andrews
 */
public class LocalFileProcessorServiceTest {

    @Test
    void testProcessResultFile() {

        var resultService = mock(ResultService.class);
        var processorService = new LocalFileProcessorService(resultService);

        processorService.processResultFile("src/test/resources/input.txt");

        verify(resultService, times(3)).processResult(any());
    }
}
