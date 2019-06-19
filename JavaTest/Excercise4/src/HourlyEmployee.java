

import java.util.Scanner;

public class HourlyEmployee extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double wage, workingHours;
	static Scanner sc = new Scanner(System.in);
	public HourlyEmployee() {
		super();
	}
	public HourlyEmployee(double wage, double workingHours) {
		super();
		this.setWage(wage);
		this.workingHours = workingHours;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public double getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
//	@Override
//	public void input() {
//		super.input();
//		System.out.print("Wage: ");
//		wage = sc.nextDouble();
//		System.out.print("Working Hours: ");
//		workingHours = sc.nextDouble();
//	}
	@Override
	public String toString() {
		return super.toString()+"\n, Wage: "+this.wage+"\n, Working Hours: "+this.workingHours;
	}
	@Override
	public void getPaymentAmount() {
		// TODO Auto-generated method stub
		
	}
}
