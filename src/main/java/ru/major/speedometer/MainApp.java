package ru.major.speedometer;

import org.apache.commons.cli.*;

public class MainApp {

    public static void main(String[] args) throws ParseException {
        //Сделать валидацию всех входящих параметров
        //Если в параметрах приходят неверные значения указать какой параметр неверный и вывести сообщение на экран


        Options options = new Options();
        options.addOption("p1", "point1", true, "Точка А")
                .addOption("p2", "point2", true, "Точка Б")
                .addOption("t", "time", true, "Время в секундах")
                .addOption("h", "help", false, "Помощь");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("h")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Speedometer by major", options);
            System.exit(1);
        }


        if (isAllParamsValid(cmd)) {

            calculateSpeed(parsePoint(cmd, "p1"), parsePoint(cmd, "p2"), cmd.getOptionValue("t"));


        } else {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Speedometer by major", options);

        }


    }

    public static void calculateSpeed(Double[] point1, Double[] point2, String time) {

        double length;
        double timeInHours;
        int speedInHours;
        double timeInSeconds;

        length = Math.sqrt(Math.pow((point2[0] - point1[0]), 2) + Math.pow((point2[1] - point1[1]), 2)) * 100;
        timeInSeconds = Integer.parseInt(time);
        timeInHours = timeInSeconds / 60 / 60;
        speedInHours = (int) (length / timeInHours);

        System.out.println("Пройденное расстояние в км: " + length);
        System.out.println("Скорость в км/ч: " + speedInHours);

    }

    public static boolean isAllParamsValid(CommandLine cmd) {

        boolean flag = isValidPoint(cmd, "p1") && isValidPoint(cmd, "p2");

        if (!cmd.hasOption("t") || cmd.getOptionValue("t").isEmpty()) {

            flag = false;
            System.out.println("Не заполнен параметр: t");
        }

        return flag;
    }

    public static Double[] parsePoint(CommandLine cmd, String optionName) {


        String[] points = cmd.getOptionValue(optionName).split(",");
        double latPoint = Double.parseDouble(points[0]);
        double lngPoint = Double.parseDouble(points[1]);
        Double[] point = new Double[2];
        point[0] = latPoint;
        point[1] = lngPoint;


        return point;


    }

    public static boolean isValidPoint(CommandLine cmd, String optionName) {

        boolean flag = true;

        if (cmd.hasOption(optionName) && !cmd.getOptionValue(optionName).isEmpty()) {
            Double[] point = parsePoint(cmd, optionName);

            if (!isInRange(point[0], point[1])) {

                flag = false;
                System.out.println("Неверно заполнено значение: " + cmd.getOptionValue(optionName));
            }

        } else {
            flag = false;
            System.out.println("Не заполнен параметр: " + optionName);


        }

        return flag;
    }

    /**
     * Метод проверяет попадает ли точка в допустимы географический диапазон
     *
     * @param latitude  широта
     * @param longitude долгота
     * @return
     */
    public static boolean isInRange(double latitude, double longitude) {

        if (-90 <= latitude && latitude <= 90 && -180 <= longitude && longitude <= 180) {
            return true;

        }

        return false;
    }


}
