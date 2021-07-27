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
        double resultOfminus=super.minusOfValues(values);
        return accountRound(resultOfminus);
    }

    @Override
    public Double multiplicationOfValues(String... values) {
        double resultOfmultiplication= super.multiplicationOfValues(values);
        return accountRound(resultOfmultiplication);
    }

    @Override
    public Double devideOfValues(String... values) {
        double resultOfDevide=super.devideOfValues(values);
        return accountRound(resultOfDevide);
        }


    private double accountRound (double value){
        return (double) Math.round(value * 100) / 100;
    }
}

