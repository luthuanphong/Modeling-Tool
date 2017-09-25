package Converter.Coding.Common;

public class Condition {

    public static String createIFCondition (String condition, String command) {
        StringBuilder cond = new StringBuilder();
        cond.append("if (").append(condition).append(") {").append(System.lineSeparator())
                .append(command).append(System.lineSeparator())
                .append("}");
        return cond.toString();
    }

    public static String createELSECondition (String command) {
        StringBuilder cond = new StringBuilder();
         cond.append("else {").append(System.lineSeparator())
                 .append(command)
                 .append("}");
         return cond.toString();
    }
}
