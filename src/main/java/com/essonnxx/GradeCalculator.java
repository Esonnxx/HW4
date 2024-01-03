package com.essonnxx;

/**
 * ClassName: GradeConverter
 * Package: com.essonnxx
 * Description:
 *
 * @Author Esonnxx
 * @Create 2024/1/3 下午 12:55
 * @Version 1.0
 */


public class GradeCalculator {
    public static char letterGrade(int score) {
        char grade;
        if (score < 0 || score > 100)
            grade = 'X';
        else if (score >= 90 && score <= 100)
            grade = 'A';
        else if (score >= 80 && score < 90)
            grade = 'B';
        else if (score >= 70 && score < 80)
            grade = 'C';
        else if (score >= 60 && score < 70)
            grade = 'D';
        else
            grade = 'F';
        return grade;
    }

    public static void main(String[] args) {

        System.out.println("新增Main Func");
    }
}
