package conteiners;

public class AccountCalculator extends Calculator{

    public AccountCalculator(String name)
    {
        super(name);
    }

    @Override
    public Double sumOfValues(String... values) {
        double sum = super.sumOfValues(values);
        return accountRound(sum);
    };

    @Override
    public Double minusOfValues(String... values) {
        double resultOfMinus =super.minusOfValues(values);
        return accountRound(resultOfMinus);
    }

    @Override
    public Double multiplicationOfValues(String... values) {
        double resultOfMultiplication = super.multiplicationOfValues(values);
        return accountRound(resultOfMultiplication);
    }

    @Override
    public Double divideOfValues(String... values) {
        double resultOfDivide=super.divideOfValues(values);
        return accountRound(resultOfDivide);
        }


    private double accountRound (double value){
        return (double) Math.round(value * 100) / 100;
    }
}

