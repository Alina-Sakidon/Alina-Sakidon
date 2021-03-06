package conteiners;

public class FinanceCalculator extends Calculator{
   public FinanceCalculator(String name)
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
    public Double divideOfValues(String... values) {
        double resultOfDevide=super.divideOfValues(values);
        return accountRound(resultOfDevide);
    }


    private double accountRound (double value){
        return (double) Math.round(value * 10000) / 10000;
    }
}
