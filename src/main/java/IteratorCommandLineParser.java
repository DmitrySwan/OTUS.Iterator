import org.apache.commons.cli.*;

public class IteratorCommandLineParser {
    public static final String ITERATOR = "iterator";
    public static final String OUTPUT = "output";
    public static final String COUNT = "count";
    public static final String BOTTOM = "bottom";
    public static final String TOP = "top";

    private static Options options = new Options();

    /*$> java -jar target/my-utility.jar -i asd
    Missing required option: o

    usage: utility-name
    -i,--input <arg>    input file path
    -o,--output <arg>   output file*/
    public static CommandLine parseCMDArgs(String[] args) {
        configureOption("o", OUTPUT, "output file path");
        configureOption("c", COUNT, "count of fibonacci numbers");
        configureOption("i", ITERATOR, "iterator type");
        configureOption("b", BOTTOM, "bottom limit");
        configureOption("t", TOP, "top limit");

        CommandLine cmd = null;
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        return cmd;
    }

    private static void configureOption(String opt, String longOpt, String description) {
        Option option = new Option(opt, longOpt, true, description);
        option.setRequired(true);
        options.addOption(option);
    }
}
