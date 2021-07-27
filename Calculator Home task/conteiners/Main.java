package conteiners;

public class Main {
    public static void main(String[] args) {
       Calculator simpleCalculator = new Calculator("Simple calc");
       AccountCalculator accountCalculator = new AccountCalculator("Account calc");
       FinanceCalculator financeCalculator=new FinanceCalculator("Financial calc");
       Calculator[] calculators = new Calculator[] {simpleCalculator, accountCalculator,financeCalculator};
       String[] inputDate=new String[] {"-1","2","2"};

        for (Calculator calc:
             calculators) {
            System.out.println(calc.getName());
            System.out.println("Sum of values " +calc.sumOfValues(inputDate));
            System.out.println("Minus of values "+calc.minusOfValues(inputDate));
            System.out.println("multiplication of Values"+calc.multiplicationOfValues(inputDate));
            System.out.println("devide Of Values "+calc.devideOfValues(inputDate));
        }
    }
}
