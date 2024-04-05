/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author udaykiran 
 */
public class StudentDriver {
    public static void main(String[] args) {
        // Create arrays to hold different types of students
        StudentFees[] students;
        
        // Read input file and populate students array
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.csv"));
            String line;
            int totalStudents = 0;
            
            // Calculate the total number of students
            while ((line = reader.readLine()) != null) {
                totalStudents++;
            }
            reader.close();
            
            // Initialize the students array
            students = new StudentFees[totalStudents];
            
            // Read the file again to populate the students array
            reader = new BufferedReader(new FileReader("input.csv"));
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int studentID = Integer.parseInt(data[0]);
                String studentName = data[1];
                boolean isEnrolled = Boolean.parseBoolean(data[2]);
                
                // Check the type of student and create the appropriate object
                if (data.length == 6) { // Undergraduate Student
                    boolean hasScholarship = Boolean.parseBoolean(data[3]);
                    double scholarshipAmount = data[4].equalsIgnoreCase("full") ? Double.POSITIVE_INFINITY : Double.parseDouble(data[4]);
                    int coursesEnrolled = Integer.parseInt(data[5]);
                    students[index] = new UGStudent(studentName, studentID, isEnrolled, hasScholarship, scholarshipAmount, coursesEnrolled);
                } else if (data.length == 5) { // Graduate Student
                    boolean isGraduateAssistant = Boolean.parseBoolean(data[3]);
                    String graduateAssistantType = data[4];
                    int coursesEnrolled = Integer.parseInt(data[5]);
                    students[index] = new GraduateStudent(studentName, studentID, isEnrolled, isGraduateAssistant, graduateAssistantType, coursesEnrolled);
                } else { // Online Student
                    int noOfMonths = Integer.parseInt(data[3]);
                    students[index] = new OnlineStudent(studentName, studentID, isEnrolled, noOfMonths);
                }
                index++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        
        // Display student data
        System.out.println("**********Undergraduate students list**********");
        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                System.out.println(student);
            }
        }
        
        System.out.println("\n**********Graduate students list**********");
        for (StudentFees student : students) {
            if (student instanceof GraduateStudent) {
                System.out.println(student);
            }
        }
        
        System.out.println("\n**********Online students list**********");
        for (StudentFees student : students) {
            if (student instanceof OnlineStudent) {
                System.out.println(student);
            }
        }
        
        // Calculate and display average of UG students fee, number of students who got scholarship, total no of courses enrolled by all UG students.
        double totalUGFee = 0;
        int scholarshipCount = 0;
        int totalUGCourses = 0;
        int totalUGStudents = 0;
        for (StudentFees student : students) {
            if (student instanceof UGStudent) {
                totalUGFee += student.getPayableAmount();
                totalUGCourses += ((UGStudent) student).getCoursesEnrolled();
                if (((UGStudent) student).isHasScholarship()) {
                    scholarshipCount++;
                }
                totalUGStudents++;
            }
        }
        double avgUGFee = totalUGFee / totalUGStudents;
        System.out.println("\n**********Undergraduate Students details**********");
        System.out.println("Average Students fee: " + avgUGFee);
        System.out.println("Scholarship count: " + scholarshipCount);
        System.out.println("Total number of courses: " + totalUGCourses);
        
        // Calculate and display average of graduate student’s fee, number of students who got graduate assistantship, total number of courses enrolled by graduate students.
        double totalGraduateFee = 0;
        int graduateAssistantCount = 0;
        int totalGraduateCourses = 0;
        int totalGraduateStudents = 0;
        for (StudentFees student : students) {
            if (student instanceof GraduateStudent) {
                totalGraduateFee += student.getPayableAmount();
                totalGraduateCourses += ((GraduateStudent) student).getCoursesEnrolled();
                if (((GraduateStudent) student).isIsGraduateAssistant()) {
                    graduateAssistantCount++;
                }
                totalGraduateStudents++;
            }
        }
        double avgGraduateFee = totalGraduateFee / totalGraduateStudents;
        System.out.println("\n**********Graduate Students details**********");
        System.out.println("Average Students fee: " + avgGraduateFee);
        System.out.println("Graduate Assistantship count: " + graduateAssistantCount);
        System.out.println("Total number of courses: " + totalGraduateCourses);
        
        // Calculate and display average of online student’s fee.
        double totalOnlineFee = 0;
        int totalOnlineStudents = 0;
        for (StudentFees student : students) {
            if (student instanceof OnlineStudent) {
                totalOnlineFee += student.getPayableAmount();
                totalOnlineStudents++;
            }
        }
        double avgOnlineFee = totalOnlineFee / totalOnlineStudents;
        System.out.println("\n**********Online Students details**********");
        System.out.println("Average Students fee: " + avgOnlineFee);
    }
}

