/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseGrades;


import java.util.*;

/**
 *
 * @author leannekim
 */
public class GradeBook {
    private int[][] grades;
    
    /**
     * constructor
     * pre: none
     * post: Object GradeBook has been created.
     */
    public GradeBook(){
        grades = new int[5][12];   // 5 rows, 12 columns
    }
    
    /**
     * Prompt user for the test grades for each student
     * pre: none
     * post: tests scores are assigned for each students.
     */
    public void getGrades(){
        Scanner input = new Scanner(System.in);
        int user;
        
        for(int col = 0; col < grades[0].length; col++){      // column
            System.out.print("Student " + (col+1) + ": ");
            for(int row = 0; row < grades.length; row++){     // row
                System.out.print("\nEnter grade: ");
                user = input.nextInt();
                grades[row][col] = user;
            }
        }
    }
    
    /**
     * Display grades for the class
     * pre: none
     * post: grades for the class has been displayed.
     * @param classNum
     */
    public void showGrades(int classNum){
        for(int i = 0; i < grades[classNum].length; i++) 
            System.out.println(grades[classNum][i]); 
    }
    
    /**
     * Return average grade of a student (average of a column)
     * pre: none
     * post: Average grade of a student has been returned.
     * @param studentNum
     * @return 
     */
    public int studentAvg(int studentNum){
        int grd = 0;
        int avg = 0;
        for(int i = 0; i < grades[0].length; i++){
            grades[i][studentNum] = grd;
            grd += avg;
        }
        return avg/5;
    }
    
    /**
     * Return average grade of a class (average of a row)
     * pre: none
     * post: Average grade of a class has been returned.
     * @param classNum
     * @return 
     */
    public int testAvg(int classNum){
        int grd = 0;
        int avg = 0;
        for(int i = 0; i < grades.length; i++){
            grades[classNum][i] = grd;
            grd += avg;
        }
        return avg/5;
    }
    
}
