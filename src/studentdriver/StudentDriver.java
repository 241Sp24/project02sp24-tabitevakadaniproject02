/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdriver;

import java.util.*;

public class StudentDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of UG students: ");
        int numUGStudents = scanner.nextInt();

        System.out.print("Enter the number of Graduate students: ");
        int numGradStudents = scanner.nextInt();

        System.out.print("Enter the number of online students: ");
        int numOnlineStudents = scanner.nextInt();

        System.out.println("\n**********Undergraduate students list**********");
        UGStudent[] ugStudents = new UGStudent[numUGStudents];
        for (int i = 0; i < numUGStudents; i++) {
            scanner.nextLine();
            System.out.println("Enter details for UG Student " + (i + 1));
            System.out.print("Student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Student id: ");
            int studentID = scanner.nextInt();
            System.out.print("Enrolled: ");
            boolean isEnrolled = scanner.nextBoolean();
            System.out.print("Scholarship: ");
            boolean hasScholarship = scanner.nextBoolean();
            double scholarshipAmount = 0.0;
            if (hasScholarship) {
                System.out.print("Scholarship amount: ");
                scholarshipAmount = scanner.nextDouble();
            }
            System.out.print("Courses enrolled: ");
            int coursesEnrolled = scanner.nextInt();

            ugStudents[i] = new UGStudent(studentName, studentID, isEnrolled, hasScholarship, scholarshipAmount, coursesEnrolled);
        }

        System.out.println("\n**********Graduate students list**********");
        GraduateStudent[] gradStudents = new GraduateStudent[numGradStudents];
        for (int i = 0; i < numGradStudents; i++) {
            scanner.nextLine();
            System.out.println("Enter details for Graduate Student " + (i + 1));
            System.out.print("Student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Student id: ");
            int studentID = scanner.nextInt();
            System.out.print("Enrolled: ");
            boolean isEnrolled = scanner.nextBoolean();
            System.out.print("Graduate assistant: ");
            boolean isGraduateAssistant = scanner.nextBoolean();
            scanner.nextLine();
            String graduateAssistantType = "";
            if (isGraduateAssistant) {
                System.out.print("Graduate assistant type: ");
                graduateAssistantType = scanner.nextLine();
            }
            System.out.print("Courses enrolled: ");
            int coursesEnrolled = scanner.nextInt();

            gradStudents[i] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, graduateAssistantType, coursesEnrolled);
        }

        System.out.println("\n**********Online students list**********");
        OnlineStudent[] onlineStudents = new OnlineStudent[numOnlineStudents];
        for (int i = 0; i < numOnlineStudents; i++) {
            scanner.nextLine();
            System.out.println("Enter details for Online Student " + (i + 1));
            System.out.print("Student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Student id: ");
            int studentID = scanner.nextInt();
            System.out.print("Enrolled: ");
            boolean isEnrolled = scanner.nextBoolean();
            System.out.print("No of months: ");
            int noOfMonths = scanner.nextInt();

            onlineStudents[i] = new OnlineStudent(studentName, studentID, isEnrolled, noOfMonths);
        }

        System.out.println("\n**********Undergraduate Students details**********");
        double ugTotalFee = 0.0;
        int scholarshipCount = 0;
        int totalCourses = 0;
        for (UGStudent ugStudent : ugStudents) {
            System.out.println(ugStudent);
            ugTotalFee += ugStudent.getPayableAmount();
            if (ugStudent.isHasScholarship()) {
                scholarshipCount++;
            }
            totalCourses += ugStudent.getCoursesEnrolled();
        }
        double ugAverageFee = ugTotalFee / numUGStudents;
        System.out.println("\nAverage Students fee: " + ugAverageFee);
        System.out.println("Scholarship count: " + scholarshipCount);
        System.out.println("Total number of courses: " + totalCourses);

        System.out.println("\n**********Graduate Students details**********");
        double gradTotalFee = 0.0;
        int graduateAssistantCount = 0;
        totalCourses = 0;
        for (GraduateStudent gradStudent : gradStudents) {
            System.out.println(gradStudent);
            gradTotalFee += gradStudent.getPayableAmount();
            if (gradStudent.isGraduateAssistant()) {
                graduateAssistantCount++;
            }
            totalCourses += gradStudent.getCoursesEnrolled();
        }
        double gradAverageFee = gradTotalFee / numGradStudents;
        System.out.println("\nAverage Students fee: " + gradAverageFee);
        System.out.println("Graduate assistant count: " + graduateAssistantCount);
        System.out.println("Total number of courses: " + totalCourses);

        System.out.println("\n**********Online Students details**********");
        double onlineTotalFee = 0.0;
        int totalMonths = 0;
        for (OnlineStudent onlineStudent : onlineStudents) {
            System.out.println(onlineStudent);
            onlineTotalFee += onlineStudent.getPayableAmount();
            totalMonths += onlineStudent.getNoOfMonths();
        }
        double onlineAverageFee = onlineTotalFee / numOnlineStudents;
        System.out.println("\nAverage Students fee: " + onlineAverageFee);
        System.out.println("Total number of months: " + totalMonths);
    }
}
