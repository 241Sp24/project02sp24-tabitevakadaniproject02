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
        double tuitionFee = coursesEnrolled * CREDITS_PER_COURSE * PER_CREDIT_FEE;
        double totalFee = tuitionFee + ADDITIONAL_FEE;
        if (isGraduateAssistant) {
            if (graduateAssistantType.equalsIgnoreCase("full")) {
                totalFee -= tuitionFee;
            } else if (graduateAssistantType.equalsIgnoreCase("half")) {
                totalFee -= tuitionFee * HALF_ASSISTANTSHIP;
            }
        }
        return totalFee;
    }


    
    @Override
    
    public String toString() {
      return String.format("Student Name: %s\nStudent ID: %d\nEnrolled: %b\nGraduate Assistant: %b\n" +
          "Graduate Assistant Type: %s\nCouses Enrolled: %d\nPayable Amount: %.2f",
          super.getStudentName(), super.getStudentID(), super.isEnrolled(), isGraduateAssistant(),
          graduateAssistantType, getCoursesEnrolled(), getPayableAmount());
    }
}
