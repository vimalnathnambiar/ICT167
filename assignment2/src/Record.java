/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Record.java
 * 
 * Purpose:
 * 1. This is class to handle the storing and manipulation of student enrolment records
 * 
 * Assumptions/Conditions:
 * 1. Overall average mark of coursework students are calculated as an overall across all coursework units instead of specific unit ID
 */

// Import libraries
import java.util.*;

public class Record {
    private static ArrayList<Student> studentRecord = new ArrayList<>();

    // Method to retrieve enrolment record
    public static ArrayList<Student> getStudentRecord() {
        return studentRecord;
    }

    // Method to add record
    public static void add(Student student) {
        studentRecord.add(student);
    }

    // Method to remove record
    public static void remove(long studentID) {
        boolean recordFound = false;
        Iterator<Student> iterator = studentRecord.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getStudentID() == studentID) {
                recordFound = true;
                System.out.println("\nRecord deleted:\nStudent ID: " + student.getStudentID()
                        + "\nName: " + student.getFirstName() + " " + student.getLastName());
                iterator.remove();
            }
        }

        if (!recordFound) {
            System.out.println("\nNo such record exists");
        }
    }

    // Method to display all records
    public static void displayAllRecordDetail() {
        for (Student record : studentRecord) {
            if (record instanceof Student_Course) {
                ((Student_Course) record).recordDetail();
            }

            if (record instanceof Student_Research) {
                ((Student_Research) record).recordDetail();
            }
        }
    }

    // Method to calculate average overall mark and display the total number of
    // course work students that scored higher/equal and lower than the average
    public static void displayOverallMarkRange_Course() {
        System.out.print("\nDisplay Overall Mark Range for Coursework Students\n---");

        double average = calculateAverageOverallMark_Course();
        System.out.println("\nOverall mark (Average): " + average);

        int highEqualCount = countNumberOfStudents_HighEqualOverallCourseMark(average);
        System.out.println("Number of students with an overall mark >= Average: " + highEqualCount);

        int lowCount = countNumberOfStudents_LowOverallCourseMark(average);
        System.out.println("Number of students with an overall mark < Average: " + lowCount);
    }

    // Method to calculate average overall mark of course work students
    public static double calculateAverageOverallMark_Course() {
        int recordLength = 0;
        double totalSum = 0;

        for (Student record : studentRecord) {
            if (record instanceof Student_Course) {
                recordLength++;
                Unit unit = ((Student_Course) record).getUnit();
                totalSum += ((Unit_Course) unit).getOverallMark();
            }
        }

        return totalSum / recordLength;
    }

    // Method to count how many course work students with overall mark equal to or
    // above average overall mark
    public static int countNumberOfStudents_HighEqualOverallCourseMark(double averageMark) {
        int recordLength = 0;

        for (Student record : studentRecord) {
            if (record instanceof Student_Course) {
                Unit unit = ((Student_Course) record).getUnit();

                if (((Unit_Course) unit).getOverallMark() >= averageMark) {
                    recordLength++;
                }
            }
        }

        return recordLength;
    }

    // Method to count how many course work students with overall mark less than
    // average overall mark
    public static int countNumberOfStudents_LowOverallCourseMark(double averageMark) {
        int recordLength = 0;

        for (Student record : studentRecord) {
            if (record instanceof Student_Course) {
                Unit unit = ((Student_Course) record).getUnit();

                if (((Unit_Course) unit).getOverallMark() < averageMark) {
                    recordLength++;
                }
            }
        }

        return recordLength;
    }

    // Method to display grade report
    public static void reportGrade(long studentID) {
        boolean recordFound = false;

        for (Student record : studentRecord) {
            if (record.getStudentID() == studentID) {
                recordFound = true;

                record.reportGrade();
            }
        }

        if (!recordFound) {
            System.out.println("\nNo such record exists");
        }
    }

    // Method to sort and display records
    public static void sortAndDisplayRecordDetail() {
        System.out.print("\nSort and Display All Record Details\n---");

        sortRecordsAscendingOrder();
        displayAllRecordDetail();
    }

    // Method to sort the records into ascending order of student number (ID)
    public static void sortRecordsAscendingOrder() {
        Collections.sort(studentRecord, new Comparator<Student>() {
            @Override
            public int compare(Student obj1, Student obj2) {
                return Long.compare(obj1.getStudentID(), obj2.getStudentID());
            }
        });
    }
}
