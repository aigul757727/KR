import java.util.Random;

public class Main {
    private static final Emloyee[] EMLOYEES = new Emloyee[10];

    public static void main(String[] args) {
        fillEmloyees();
        printFullInfo();
        System.out.println("Сумма ЗП:" + totalSalaries());
        System.out.println("Сотрудник с мин ЗП: "+ findEmloyeeWithMinSalary());
        System.out.println("Сотрудник с макс ЗП: "+ findEmloyeeWithMaxSalary());
        System.out.println("Среднее ЗП: " + findAverageSalary());
        printFullNameInfo();
    }

    private static void fillEmloyees() {
        Random random = new Random();
        for (int i = 0; i < EMLOYEES.length; i++) {
            EMLOYEES[i] = new Emloyee(
                    "Сотрудник " + (i + 1),
                    random.nextInt(1, 6),
                    random.nextInt(60_000, 120_000)
            );
        }
    }
    private static void printFullInfo() {
        for (Emloyee emloyee : EMLOYEES) {
            System.out.println(emloyee);
        }
    }

    private static int totalSalaries (){
        int sum =0;
        for (Emloyee employee: EMLOYEES) {
            sum += employee.getSalary();
        } return  sum;
    }
    private  static  Emloyee findEmloyeeWithMinSalary (){
        int min = Integer.MAX_VALUE;
        Emloyee emloyee=null;
        for (Emloyee emp: EMLOYEES) {
            if (emp.getSalary()<min) {
                min = emp.getSalary();
                emloyee =emp;}
        } return emloyee;
    }
    private  static  Emloyee findEmloyeeWithMaxSalary (){
        int max = Integer.MIN_VALUE;
        Emloyee emloyee=null;
        for (Emloyee emp: EMLOYEES) {
            if (emp.getSalary()>max) {
                max = emp.getSalary();
                emloyee =emp;}
        } return emloyee;
    }

    private  static  double findAverageSalary (){
        return totalSalaries()/ (double) EMLOYEES.length;
    }
    private static void printFullNameInfo () {
        for (Emloyee employee : EMLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
}