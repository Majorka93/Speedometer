package ru.major.speedometer;

import org.apache.commons.cli.*;


public class MainApp {

    public static void main(String[] args) throws ParseException {


        Options options = new Options();
        options.addOption("p1", "point1", true, "Точка А")
                .addOption("p2", "point2", true, "Точка Б")
                .addOption("t", "time", true, "Время в секундах")
                .addOption("h", "help", false, "Помощь");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        Calculating calc = new Calculating();


        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Speedometer by major", options);
            System.exit(1);
        }


        if (isAllParamsValid(cmd)) {

            CalculatingPoint point1 = new CalculatingPoint(cmd.getOptionValue("p1"));
            CalculatingPoint point2 = new CalculatingPoint(cmd.getOptionValue("p2"));
            point2.minus(point1);
            Result result = calc.calculating(point2, Integer.parseInt(cmd.getOptionValue("t")));

            System.out.println("Пройденное расстояние: " + result.getLength());
            System.out.println("Скорость прохождение: " + result.getSpeed());


        } else {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Speedometer by major", options);

        }


    }

    public static boolean isAllParamsValid(CommandLine cmd) {

        boolean flag = isValidPoint(cmd, "p1") && isValidPoint(cmd, "p2");

        if (!cmd.hasOption("t") || cmd.getOptionValue("t").isEmpty()) {

            flag = false;
            System.out.println("Не заполнен параметр: t");
        }

        return flag;
    }


    public static boolean isValidPoint(CommandLine cmd, String optionName) {


        boolean flag = true;

        if (cmd.hasOption(optionName) && !cmd.getOptionValue(optionName).isEmpty()) {
            Point point = new Point(cmd.getOptionValue(optionName));

            if (!point.isInRange()) {

                flag = false;
                System.out.println("Неверно заполнено значение: " + cmd.getOptionValue(optionName));
            }

        } else {
            flag = false;
            System.out.println("Не заполнен параметр: " + optionName);


        }

        return flag;
    }


}
