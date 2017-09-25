package Converter.Coding.Program;

import Converter.Coding.Common.CommonVariable;

public class MainProgram{

    /**
     *
     * @return
     */
    public static String getCode() {
        StringBuilder pro =  new StringBuilder();

        pro.append("main").append(" ").append("{").append(System.lineSeparator());
        pro.append("search(").append(CommonVariable.CONGESTION).append(");").append(System.lineSeparator());
        pro.append("}").append(System.lineSeparator());
        pro.append(System.lineSeparator());
        return pro.toString();
    }
}
