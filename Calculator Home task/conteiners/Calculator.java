package conteiners;

public class Calculator {
    private String name;

    public Calculator(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    protected Double[] parseStrings(String... values) {
        Double[] convertedValues = new Double[values.length];
        int i = 0;
        for (String value :
                values) {
            convertedValues[i] = Double.parseDouble(value);
            i++;
        }
        return convertedValues;
    }

    public Double sumOfValues(String... values) {
        Double sum = 0d;
        Double[] arrayDoubles = parseStrings(values);
        for (Double value :
                arrayDoubles) {
            //Double doubleValue = Double.parseDouble(value);
            sum += value;
        }
        return sum;
    }


    public Double minusOfValues(String... values) {
        Double result = 0d;
        Double[] arrayDoubles = parseStrings(values);
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                result = arrayDoubles[0];
            } else {
                result -= arrayDoubles[i];
            }
        }
        return result;
    }

    public Double multiplicationOfValues(String... values) {
        Double multiplication = 0d;
        Double[] arrayDoubles = parseStrings(values);
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                multiplication = arrayDoubles[0];
            } else {
                multiplication *= arrayDoubles[i];
            }
        }
        return multiplication;
    }

    public Double devideOfValues(String... values) {
        Double devide = 0d;
        Double[] arrayDoubles = parseStrings(values);
        for (int i = 0; i < values.length; i++) {
            if (arrayDoubles[i] == 0) {
                System.out.println("restricted devide by zero");
                break;
            }
            if (i == 0) {
                devide = arrayDoubles[0];
                continue;
            }
            devide /= arrayDoubles[i];
        }
        return devide;
    }
}
