/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseGrades;

/**
 *
 * @author leannekim
 */

public class Main {
    public static void main(String[] args) {
        GradeBook user = new GradeBook();
        user.getGrades();
        user.showGrades(2);
        user.studentAvg(3);
        user.testAvg(1);
    }
}

