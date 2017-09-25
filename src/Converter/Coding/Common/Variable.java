package Converter.Coding.Common;

public class Variable {

    private BaseType type;
    private String variableName;
    private String variableValue;

    public Variable(BaseType type, String variableName, String variableValue) {
        this.type = type;
        this.variableName = variableName;
        this.variableValue = variableValue;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public BaseType getType() {
        return type;
    }

    public void setType(BaseType type) {
        this.type = type;
    }

    public String toString () {
        switch (type) {
            case INT:
                return "int "+this.variableName+" = "+this.variableValue+";";
            case FLOAT:
                return "float "+this.variableName+" = "+this.variableValue+";";
            case STRING:
                return "String "+this.variableName+" = "+this.variableValue+";";
            case BOOLEAN:
                return "boolean "+this.variableName+" = "+this.variableValue+";";
            default:
                return "";
        }
    }

    public String toMinimizeString () {
        switch (type) {
            case INT:
                return "int "+this.variableName+" = "+(this.variableValue.equals("0") ? this.variableValue : "1")+";";
            case FLOAT:
                return "float "+this.variableName+" = "+(this.variableValue.equals("0") ? this.variableValue : "1")+";";
            case STRING:
                return "String "+this.variableName+" = "+this.variableValue +";";
            case BOOLEAN:
                return "boolean "+this.variableName+" = "+this.variableValue +";";
            default:
                return "";
        }
    }
}
