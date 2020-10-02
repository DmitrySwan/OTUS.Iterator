import static org.apache.commons.io.FileUtils.contentEqualsIgnoreEOL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FibonacciTest {
    private static final String TARGET_TEST_RESOURCES_PATH = "target/test-classes/";

    @DataProvider
    public Object[][] fibonacciTestData() {
        return new Object[][]{
                {Main.FIBONACCI, "outputFibonacci.txt", "outputFibonacciExpected.txt"},
                {Main.REVERSE, "outputFibonacciReverse.txt", "outputFibonacciReverseExpected.txt"}
        };
    }

    @Test(description = "", dataProvider = "fibonacciTestData")
    public void fibonacciTest(String iteratorType, String outputFilePath, String outputFileExpectedPath) throws IOException {
        String targetOutputFilePath = TARGET_TEST_RESOURCES_PATH + outputFilePath;
        Main.main(
                new String[]{
                        "-o", targetOutputFilePath,
                        "-i", iteratorType,
                        "-c", "15",
                        "-b", "20",
                        "-t", "150"
                });
         Assert.assertTrue(contentEqualsIgnoreEOL(
                 new File(targetOutputFilePath),
                 new File(TARGET_TEST_RESOURCES_PATH + outputFileExpectedPath),
                 "UTF-8"
         ));
    }
}
