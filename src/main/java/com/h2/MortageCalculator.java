package com.h2;

import java.text.DecimalFormat;

public class MortageCalculator {
    private long loanAmount;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }
    private int getNumberOfPayments() {
        return termInYears*12;
    }
    private float getMonthlyInterestRate() {
        float interestrate = annualRate/100;
        interestrate /= 12;
        return interestrate;
    }
    public void calculateMonthlyPayment() {
        long P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        double M = P*(((r* Math.pow(1+r,n))) / ((Math.pow((1+r), n)) - 1));
        monthlyPayment = M;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);

        MortageCalculator calculator = new MortageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();

        System.out.println(calculator.toString());
    }
}
