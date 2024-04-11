package studentdriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StudentDriver {

    public static void main(String[] args) throws FileNotFoundException {
    	
Scanner input = new Scanner(System.in);
        

        System.out.println();
        
        System.out.print("Enter the No of UG Students: ");
        int numUGStudents = input.nextInt();
        
        System.out.print("Enter the No of Graduate Students: ");
        int numGradStudents = input.nextInt();
        
        System.out.print("Enter the No of Online Students: ");
        int numOnlineStudents = input.nextInt();
        
       
        
        
        StudentFees[] students = new StudentFees[12];
        File file = new File("input.csv");
        Scanner fs = new Scanner(file);

        String[] data = new String[6];
        int i = 0;
        int count = 0;
        while(fs.hasNext()) {
            data = fs.next().split(",");
            
            if(count < numUGStudents){
                students[i] = new UGStudent(data[1], Integer.parseInt(data[0]), 
                            Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[4]),
                            Double.parseDouble(data[5]), Integer.parseInt(data[3]));
            }
            else if(count >= numUGStudents && count < numUGStudents + numGradStudents){
                if(data[4].equals("false")){
                    students[i] = new GraduateStudent(data[1], Integer.parseInt(data[0]), 
                            Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[4]),
                            Integer.parseInt(data[3]));
                }
                else{
                    students[i] = new GraduateStudent(data[1], Integer.parseInt(data[0]), 
                            Boolean.parseBoolean(data[2]), Boolean.parseBoolean(data[4]),
                            data[5], Integer.parseInt(data[3]));
                }
            }
            else if( count >= numUGStudents + numGradStudents){
                students[i] = new OnlineStudent(data[1],Integer.parseInt(data[0]),
                        Boolean.parseBoolean(data[2]),Integer.parseInt(data[3]));
            }
            count += 1;
            i += 1;
        }
        
        fs.close();
        
        int scholarship = 0;
        int UGcourses = 0;
        int UGstudentsZeroPay = 0;
        int gradAssist = 0;
        int graduateCourses = 0;
        double ugFee = 0.0;
        double gradFee = 0.0;
        double onlineFee = 0.0;
        count = 0;
        for (StudentFees s: students) {
            
            if(count == 0){
                System.out.println("*******Undergraduate students list*******");
            }
            if(count == numGradStudents+1){
                System.out.println("*******Graduate students list*******");
            }
            if(count == numUGStudents + numGradStudents){
                System.out.println("*******Online students list*******");
            }
            if(s instanceof UGStudent){
                System.out.println(s);
                ugFee += ((UGStudent) s).getPayableAmount();
                if(((UGStudent) s).getPayableAmount()==0) {
                	UGstudentsZeroPay +=1;
                }
                System.out.println(ugFee);
                UGcourses += ((UGStudent) s).getCoursesEnrolled();
                if(((UGStudent) s).isHasScholarship()){
                    scholarship += 1;
                }
            }
          else if(s instanceof GraduateStudent){
                System.out.println(s);
                gradFee += ((GraduateStudent) s).getPayableAmount();
                graduateCourses += ((GraduateStudent) s).getCoursesEnrolled();
                if(((GraduateStudent) s).isGraduateAssistant()){
                    gradAssist += 1;
                }
            }
            else if(s instanceof OnlineStudent){
                System.out.println(s);
                onlineFee += ((OnlineStudent) s).getPayableAmount();
            }
            System.out.println();
            count += 1;
        }
        
        System.out.println("**********Undergraduate Students details**********");
        System.out.printf("Average Student fee: %.1f\n", ugFee / (numUGStudents-UGstudentsZeroPay));
        System.out.println("Scholarship count: " + scholarship);
        System.out.println("Total number of courses: " + UGcourses);
        System.out.println();
        
        System.out.println("**********Graduate Students details**********");
        System.out.printf("Average Student fee: %.2f\n", gradFee / numGradStudents);
        System.out.println("Graduate Assistantship count: " + gradAssist);
        System.out.println("Total number of courses: " + graduateCourses);
        System.out.println();
        
        System.out.println("**********Online Students details**********");
        System.out.printf("Average Student fee: %.2f\n", onlineFee / numOnlineStudents);
    }
}
        
        