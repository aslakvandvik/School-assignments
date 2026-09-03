package no.uib.oop.calculator.expression;

public class Number implements Expression {
    
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    public Number(int value) {
        this.value = (double) value;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public String getOperator() {
        throw new IllegalStateException("This expression is a number.");
    }

    @Override
    public double getNumberValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Number other = (Number) obj;
        return this.getNumberValue() == other.getNumberValue();
    }
}
