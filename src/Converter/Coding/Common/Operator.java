package Converter.Coding.Common;

public class Operator {

    public static String AssignValue (String variableName, String Value) {
        StringBuilder Assig = new StringBuilder();
            Assig.append(variableName).append(" = ").append(Value).append(";");
        return Assig.toString();
    }

    public static String Add (String variableName , String value1 , String value2) {
        StringBuilder op = new StringBuilder();
        op.append(variableName).append(" = ").append(value1).append(" + ").append(value2).append(";");
        return op.toString();
    }

    public static String Minus (String variableName , String value1 , String value2) {
        StringBuilder op = new StringBuilder();
        op.append(variableName).append(" = ").append(value1).append(" - ").append(value2).append(";");
        return op.toString();
    }

    public static String Compare (String value1 , String value2 , String compare) {
        StringBuilder comp = new StringBuilder();
        comp.append(value1).append(" ").append(compare).append(" ").append(value2);
        return comp.toString();
    }
}
