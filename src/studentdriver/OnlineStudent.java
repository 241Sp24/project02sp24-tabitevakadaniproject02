/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentdriver;

/**
 *
 * @author S554271
 */
public class OnlineStudent extends StudentFees{

    public OnlineStudent(String studentName, int studentID, boolean isEnrolled) {
        super(studentName, studentID, isEnrolled);
    }

    @Override
    public double getPayableAmount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
