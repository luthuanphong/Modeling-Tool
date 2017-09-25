package Converter.Coding.Common;

import java.util.ArrayList;
import java.util.List;

public class Code {
    private List<Variable> variables;

    public Code () {
        variables = new ArrayList<>();
    }

    public List<Variable> getVariables() {
        return variables;
    }
}
