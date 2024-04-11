package studentdriver;

public class OnlineStudent extends StudentFees {

    private int noOfMonths;

    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }

    public int getNoOfMonths() {
        return noOfMonths;
    }

    public void setNoOfMonths(int noOfMonths) {
        this.noOfMonths = noOfMonths;
    }

    @Override
    public double getPayableAmount() {
        final double MONTHLY_FEE = 1245.25;
        return MONTHLY_FEE * getNoOfMonths();

    }

    @Override
    public String toString() {
        return "Student name: " + getStudentName() + "\n"
                + "Student id: " + getStudentID() + "\n"
                + "Enrolled: " + isEnrolled() + "\n"
                + "No of months: " + noOfMonths + "\n"
                + "Payable amount: " + String.format("%.2f", getPayableAmount());

    }

}
