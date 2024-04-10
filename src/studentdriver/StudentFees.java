
package studentdriver;

/**
 *
 * @author S554271
 */
public abstract class StudentFees {

    private String studentName;
    private int studentID;
    private boolean isEnrolled;

    static final int CREDITS_PER_COURSE = 3;
    static final double PER_CREDIT_FEE = 543.50;

    // Constructor
    public StudentFees(String studentName, int studentID, boolean isEnrolled) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public int getCREDITS_PER_COURSE() {
        return CREDITS_PER_COURSE;
    }

    public double getPER_CREDIT_FEE() {
        return PER_CREDIT_FEE;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    public abstract double getPayableAmount();

    
}
