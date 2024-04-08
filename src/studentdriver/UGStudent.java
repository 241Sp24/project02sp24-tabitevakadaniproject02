/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author S554271
 */
public class UGStudent extends StudentFees {

    private boolean hasScholarship;
    private double scholarshipAmount;
    private int coursesEnrolled;
    public static final double ADDITIONAL_FEE = 820.70;

    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    public double getPayableAmount() {
        double tuitionFee = coursesEnrolled * CREDITS_PER_COURSE * PER_CREDIT_FEE;
        double totalFee = tuitionFee + 1000; // Additional fee
        if (hasScholarship) {
            totalFee -= scholarshipAmount;
        }
        return totalFee;
    }

    @Override
    public String toString() {
        return "UGStudent{" + "hasScholarship=" + hasScholarship + ", scholarshipAmount=" + scholarshipAmount + ", coursesEnrolled=" + coursesEnrolled + '}';
    }
}
