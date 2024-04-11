
 
package studentdriver;

/**
 *
 * @author S554271
 */
public class GraduateStudent extends StudentFees {

	private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private int coursesEnrolled;
    private static final double ADDITIONAL_FEE = 654.75;
    private static final double FULL_ASSISTANTSHIP = 1.0;
    private static final double HALF_ASSISTANTSHIP = 0.5;
    private static final double PER_CREDIT_FEE = 305.50;
    private static final int CREDITS_PER_COURSE = 4;

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
        double tuition = (getCoursesEnrolled() * super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE()) ;
        if (isGraduateAssistant && graduateAssistantType.equalsIgnoreCase("full")) {
            return 0 + ADDITIONAL_FEE; // Full tuition waiver
        } else if (isGraduateAssistant && graduateAssistantType.equalsIgnoreCase("half")) {
            return (tuition / 2)+ADDITIONAL_FEE; // Half tuition waiver
        } else {
            return tuition+ADDITIONAL_FEE; // No assistantship
        }
    }

    
    @Override
    
    public String toString() {
      return String.format("Student Name: %s\nStudent ID: %d\nEnrolled: %b\nGraduate Assistant: %b\n" +
          "Graduate Assistant Type: %s\nCouses Enrolled: %d\nPayable Amount: %.2f",
          super.getStudentName(), super.getStudentID(), super.isEnrolled(), isGraduateAssistant(),
          graduateAssistantType, getCoursesEnrolled(), getPayableAmount());
    }
}
