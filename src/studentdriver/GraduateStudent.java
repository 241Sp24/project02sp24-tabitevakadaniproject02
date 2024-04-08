/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author S554271
 */
public class GraduateStudent extends StudentFees {

    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private int coursesEnrolled;
    private static final double ADDITIONAL_FEES = 654.45;

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;
    }

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
    }

    public boolean isGraduateAssistant() {
        return isGraduateAssistant;
    }

    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    @Override
    public double getPayableAmount() {
        double tuitionFee = coursesEnrolled * PER_CREDIT_FEE;
        if (isGraduateAssistant) {
            if (graduateAssistantType.equals("full")) {
                return 0; // Full waiver
            } else if (graduateAssistantType.equals("half")) {
                double HALF_ASSISTANTSHIP_WAIVER = 0;
                return tuitionFee * HALF_ASSISTANTSHIP_WAIVER; // Half waiver
            }
        }
        return tuitionFee;
    }

    @Override
    public String toString() {
        return "GraduateStudent{" + "isGraduateAssistant=" + isGraduateAssistant + ", graduateAssistantType=" + graduateAssistantType + ", coursesEnrolled=" + coursesEnrolled + '}';
    }
}
