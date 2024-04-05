/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author S554271
 */
public class OnlineStudent extends StudentFees{
    private int noOfMonths;
    private static final double MONTHLY_FEE = 1245.25;

    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
    }

    @Override
    public double getPayableAmount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "OnlineStudent{" + "noOfMonths=" + noOfMonths + '}';
    }
}
