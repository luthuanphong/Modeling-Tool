package Converter.Coding.Common;

public class Variable {

    private BaseType type;
    private String variableName;
    private String variableValue;
    private boolean isConstant = false;

    public Variable(BaseType type, String variableName, String variableValue) {
        this.type = type;
        this.variableName = variableName;
        this.variableValue = variableValue;
    }
    
    public Variable (BaseType type, String variableName, String variableValue, boolean isConstant) {
    	this.type = type;
        this.variableName = variableName;
        this.variableValue = variableValue;
        this.isConstant = isConstant;
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
            	if(isConstant) {
            		return "const int "+this.variableName+" = "+this.variableValue+";";
            	}
            	
                return "int "+this.variableName+" = "+this.variableValue+";";
            case FLOAT:
            	if(isConstant) {
            		return "const float "+this.variableName+" = "+this.variableValue+";";
            	}
            	
                return "float "+this.variableName+" = "+this.variableValue+";";
            case STRING:
            	if(isConstant) {
            		return "const String "+this.variableName+" = "+this.variableValue+";";
            	}
            	
                return "String "+this.variableName+" = "+this.variableValue+";";
            case BOOLEAN:
            	if(isConstant) {
            		return "const boolean "+this.variableName+" = "+this.variableValue+";";
            	}
            	
                return "boolean "+this.variableName+" = "+this.variableValue+";";
            default:
                return "";
        }
    }

    public String toMinimizeString () {
        switch (type) {
            case INT:
            	if(isConstant) {
            		return "const int "+this.variableName+" = "+(this.variableValue.equals("0") ? this.variableValue : "1")+";";
            	}
            	
                return "int "+this.variableName+" = "+(this.variableValue.equals("0") ? this.variableValue : "1")+";";
            case FLOAT:
            	if(isConstant) {
            		return "const float "+this.variableName+" = "+(this.variableValue.equals("0") ? this.variableValue : "1")+";";
            	}
            	
                return "float "+this.variableName+" = "+(this.variableValue.equals("0") ? this.variableValue : "1")+";";
            case STRING:
            	if(isConstant) {
            		return "const String "+this.variableName+" = "+this.variableValue +";";
            	}
            	
                return "String "+this.variableName+" = "+this.variableValue +";";
            case BOOLEAN:
            	if(isConstant) {
            		return "const boolean "+this.variableName+" = "+this.variableValue +";";
            	}
            	
                return "boolean "+this.variableName+" = "+this.variableValue +";";
            default:
                return "";
        }
    }
}
