

import java.util.Scanner;

public class SalariedEmployee extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double commisstionRate, grossSales, basicSalary;
	Scanner sc = new Scanner(System.in);
	public SalariedEmployee() {
		super();
	}
	public SalariedEmployee(double commisstionRate, double grossSales, double basicSalary) {
		super();
		this.commisstionRate = commisstionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}
	public double getCommisstionRate() {
		return commisstionRate;
	}

	public void setCommisstionRate(double commisstionRate) {
		this.commisstionRate = commisstionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
//	@Override
//	public void input() {
//		super.input();
//        System.out.print("Commisstion Rate: ");
//        commisstionRate = sc.nextDouble();
//        System.out.print("Gross Sales: ");
//        grossSales = sc.nextDouble();
//        System.out.print("Basic Salary: ");
//        basicSalary = sc.nextDouble();
//	}
	@Override
	public String toString() {
		return super.toString()+"\n, Commisstion Rate: "+this.commisstionRate+"\n, Gross Sales: "+this.grossSales+"\n, basic Salary: "+this.basicSalary;
	}
	@Override
	public void getPaymentAmount() {
		// TODO Auto-generated method stub
		
	}
	
}
