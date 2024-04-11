
package studentdriver;

/**
 *
 * @author S554271
 */
public class UGStudent extends StudentFees {

	 private double scholarshipAmount;
	    private boolean hasScholarship;
	    private int coursesEnrolled;
	    private static final double ADDITIONAL_FEE = 820.70;
	    private static final double PER_CREDIT_FEE = 275.50;
	    private static final int CREDITS_PER_COURSE = 3;

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
    public double getPayableAmount(){
        double tuition = ((coursesEnrolled * super.getCREDITS_PER_COURSE()) 
                * super.getPER_CREDIT_FEE() + ADDITIONAL_FEE) - scholarshipAmount;
        if(!super.isEnrolled()){
            tuition = 0;
        }
        return tuition;
    }
    @Override
    public String toString(){
        return "Student Name: " + super.getStudentName() 
                + "\nStudent id: " + super.getStudentID() 
                + "\nEnrolled: " + super.isEnrolled() 
                + "\nScholarship: "  + isHasScholarship() 
                + "\nScholarship amount: " + getScholarshipAmount() 
                + "\nCouses enrolled: " + getCoursesEnrolled() 
                + "\nPayable amount: " + getPayableAmount();
    }}
