package Calculator;

import java.util.Scanner;

class Calculate {
    Scanner sc = new Scanner(System.in);

    double menu()
    {       while (true) {
            System.out.println("MENU BAR");

            System.out.println("1.Addition");
            System.out.println("2.Subtract");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.println("5.Exit");

            System.out.println("Enter choice");
            int choice = sc.nextInt();
            if (choice >= 5) {
                System.out.println("Exit successfully");
                break;
            }
        System.out.println("Enter number");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();

        double result = 0;
            switch (choice) {

                case 1-> result = add(n1, n2);
                case 2 -> result = Sub(n1, n2);
                case 3 -> result = Multiply(n1, n2);
                case 4 -> result = divide(n1, n2);
                default -> {
                    System.out.println("Invalid Choice!");
                    continue;
                }
            }
            System.out.println("Result " + result);
            System.out.println();
        }
        sc.close();
        return 0;
    }


public static  double add(double n1,double n2)
    {
        return n1+n2;
    }
    public static  double Sub(double n1,double n2)
    {
        return n1-n2;
    }
    public static  double Multiply(double n1,double n2)
    {
        return n1*n2;
    }
    public static  double divide(double n1,double n2) {
        if(n2!=0)
        {
            return n1/n2;
        }
        else {
            System.out.println("Error divide by zero");
            return Double.NaN;
        }
    }
    }
    public  class Calculator
    {
        public  static  void  main(String []args)
        {

            Calculate obj=new Calculate();

            @SuppressWarnings("unused")
			double k=obj.menu();
        }
    }







