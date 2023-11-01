/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Helper.java
 * 
 * Purpose:
 * 1. This is class to provide helper methods for general utilization
 * 
 * Assumptions/Conditions:
 * 1. One student is associated to only one enrolment type and a associated unit of similar enrolment type
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Helper {
    // Method to read CSV file
    public static void readCSV(String fileName) throws IOException {
        BufferedReader inputReader = new BufferedReader(new FileReader(fileName));
        String line;

        System.out.println("Reading/Parsing CSV file...");
        try {
            // Loop through CSV file (line by line)
            while ((line = inputReader.readLine()) != null) {
                // Split data record of each line
                String[] data = line.split(",\\s*");
                Student student;
                Unit unit;

                // Check if record is of appropriate enrolment type
                if (data.length >= 1 && (data[0].equalsIgnoreCase("C") || data[0].equalsIgnoreCase("R"))) {
                    // Check for valid first name, last name and student ID, and create student
                    // object
                    if (data.length >= 4 && isValidName(data[1]) && isValidName(data[2]) && isValidStudentID(data[3])) {
                        if (data[0].equalsIgnoreCase("C")) {
                            student = new Student_Course(data[1], data[2], Long.parseLong(data[3]));
                        } else {
                            student = new Student_Research(data[1], data[2], Long.parseLong(data[3]));
                        }

                        // Check for duplicate record
                        boolean foundDuplicate = checkDuplicate(student);
                        if (!foundDuplicate) {
                            // Validate unit information
                            if (student instanceof Student_Course && data.length == 9 && isValidUnit(data[4])
                                    && isValidInteger(data[5]) && isValidMark(data[6]) && isValidMark(data[7])
                                    && isValidMark(data[8])) {
                                // Create unit object
                                unit = new Unit_Course(data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]),
                                        Integer.parseInt(data[7]), Integer.parseInt(data[8]));

                                // Set unit to student object
                                Student_Course tmpStudent_Course = (Student_Course) student;
                                tmpStudent_Course.setUnit(unit);

                                // Add student object to record
                                Record.add(tmpStudent_Course);
                                System.out.println("Added to Record: " + line);
                            } else if (student instanceof Student_Research && data.length == 6 && isValidMark(data[4])
                                    && isValidMark(data[5])) {
                                // Create unit object
                                unit = new Unit_Research(Integer.parseInt(data[4]), Integer.parseInt(data[5]));

                                // Set unit to student object
                                Student_Research tmpStudent_Research = (Student_Research) student;
                                tmpStudent_Research.setUnit(unit);

                                // Add student object to record
                                Record.add(tmpStudent_Research);
                                System.out.println("Added to Record: " + line);
                            } else {
                                System.out.println(
                                        "Skipped: Invalid format or missing required fields for record - " + line);
                            }
                        } else {
                            System.out.println("Skipped: A record with the same student ID already exists - " + line);
                        }
                    } else {
                        System.out.println("Skipped: Insufficient/Invalid student information - " + line);
                    }
                } else {
                    System.out.println("Skipped: Invalid enrolment type - " + line);
                }
            }
            System.out.println("CSV file read/parsed successfully");
        } finally {
            inputReader.close();
        }
    }

    // Method to validate name
    private static boolean isValidName(String name) {
        String regex = "^[A-Za-z]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        return matcher.matches();
    }

    // Method to validate name
    private static boolean isValidStudentID(String studentID) {
        String regex = "^[0-9]{8}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(studentID);

        return matcher.matches();
    }

    // Method to check for duplicate student in enrolment record
    private static boolean checkDuplicate(Student student) {
        for (Student record : Record.getStudentRecord()) {
            if (record.equals(student)) {
                return true;
            }
        }
        return false;
    }

    // Method to validate unit name
    private static boolean isValidUnit(String unitName) {
        String regex = "^[A-Z]{3}[0-9]{3}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(unitName);

        return matcher.matches();
    }

    // Method to validate integer input
    private static boolean isValidInteger(String integerData) {
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(integerData);

        return matcher.matches();
    }

    // Method to validate integer input
    private static boolean isValidMark(String markData) {
        if (isValidInteger(markData)) {
            int markValue = Integer.parseInt(markData);

            return (markValue > 0 && markValue <= 100);
        }
        return false;
    }

    // Method to display initial menu
    public static void displayMenu(Scanner kb) throws IOException {
        int input;
        boolean sorted = false;

        while (true) {
            System.out.println("\nMenu\n---");
            System.out.println("1. Quit (Exit Program)");
            System.out.println("2. Add more records (Read from CSV file)");
            System.out.println("3. Remove student record");
            System.out.println("4. Output all records");
            System.out.println(
                    "5. Display students that scored above and below average overall marks (Course works students only)");
            System.out.println("6. Report grade information");
            System.out.println("7. Sort records (by student ID)");

            if (sorted) {
                System.out.println("8. Output sorted record to CSV file");
            }

            System.out.print("\nEnter your selection (1 - " + (sorted ? "8" : "7") + "): ");
            String menuInput = kb.next().trim();

            if (isValidInteger(menuInput)) {
                input = Integer.parseInt(menuInput);

                boolean exitMenu = executeMenuOption(kb, input, sorted);
                if (exitMenu) {
                    break;
                } else if (input == 7) {
                    sorted = true;
                }
            }
        }
    }

    // Method to execute initial menu options
    private static boolean executeMenuOption(Scanner kb, int input, boolean sorted) throws IOException {
        switch (input) {
            case 1:
                return true;
            case 2:
                addRecord(kb);
                break;
            case 3:
                removeRecord(kb);
                break;
            case 4:
                System.out.print("\nDisplay All Records\n---");
                Record.displayAllRecordDetail();
                break;
            case 5:
                Record.displayOverallMarkRange_Course();
                break;
            case 6:
                getGradeReport(kb);
                break;
            case 7:
                Record.sortAndDisplayRecordDetail();
                break;
            case 8:
                if (sorted) {
                    Record.sortRecordsAscendingOrder();
                    outputToCSV();
                } else {
                    System.out.println("Invalid input. Please try again...");
                }
                break;

            default:
                System.out.println("Invalid input. Please try again...");
                break;
        }
        return false;
    }

    // Method to add record by a specified file
    private static void addRecord(Scanner kb) {
        System.out.print("\nAdd Record\n---");
        try {
            System.out.print("\nPlease enter the name of the CSV file to read from: ");
            String fileName = kb.next();

            if (fileName.endsWith(".csv") || fileName.endsWith(".CSV")) {
                System.out.println();
                readCSV(fileName);
            } else {
                throw new Exception(
                        "Extension not recognised/Invalid file format. Ensure file ends with .csv\nPlease try again...");
            }
        } catch (IOException e) {
            System.out.println("Error accessing record: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    // Method to ask user for student ID to remove from records
    private static void removeRecord(Scanner kb) {
        System.out.print("\nRemove Record\n---");

        System.out.print("\nPlease enter the student number (ID) of the record you want to remove: ");
        String studentID = kb.next();

        if (isValidStudentID(studentID)) {
            if (askConfirmation(kb)) {
                Record.remove(Long.parseLong(studentID));
            } else {
                System.out.println("\nConfirmation was not provided: No records were removed.");
            }
        } else {
            System.out.println(
                    "\nStudent number (ID) is not in the right format - It should be 7 digits long\nPlease try again...");
        }
    }

    // Method to ask user confirmation for proceeding
    private static boolean askConfirmation(Scanner kb) {
        char confirmation;

        while (true) {
            System.out.print("Are you sure? [Y/N]: ");
            confirmation = kb.next().toUpperCase().charAt(0);

            if (confirmation != 'Y' && confirmation != 'N') {
                System.out.println("Invalid input. Please try again.\n");
            } else {
                break;
            }
        }

        if (confirmation == 'Y') {
            return true;
        }
        return false;
    }

    // Method to ask user for student ID to report grade
    private static void getGradeReport(Scanner kb) {
        System.out.print("\nGrade Report\n---");

        System.out.print("\nPlease enter the student number (ID) of the record you want a grade report for: ");
        String studentID = kb.next();

        if (isValidStudentID(studentID)) {
            Record.reportGrade(Long.parseLong(studentID));
        } else {
            System.out.println(
                    "\nStudent number (ID) is not in the right format - It should be 7 digits long\nPlease try again...");
        }
    }

    // Method to write to CSV file
    public static void outputToCSV() throws IOException {
        PrintWriter outputWriter = new PrintWriter(new FileWriter("recordOutput.csv"));

        System.out.println("Writing sorted record to CSV file (recordOutput.csv)");
        try {
            outputWriter.println(
                    "Enrolment Type, First Name, Last Name, Student Number (ID), Unit ID, Unit Level, Assignment 1 Mark, Assignment 2 Mark, Final Exam Mark, Proposal Mark, Dissertation Mark, Overall Mark, Final Grade");

            for (Student record : Record.getStudentRecord()) {
                if (record instanceof Student_Course) {
                    Unit unit = ((Student_Course) record).getUnit();

                    outputWriter.println(((Student_Course) record).getEnrolmentType() + ", "
                            + record.getFirstName() + ", "
                            + record.getLastName() + ", "
                            + record.getStudentID() + ", "
                            + ((Unit_Course) unit).getUnitID() + ", "
                            + ((Unit_Course) unit).getUnitLevel() + ", "
                            + ((Unit_Course) unit).getAssignmentMark1() + ", "
                            + ((Unit_Course) unit).getAssignmentMark2() + ", "
                            + ((Unit_Course) unit).getFinalExamMark() + ", "
                            + "NA, NA, "
                            + ((Unit_Course) unit).getOverallMark() + ", "
                            + ((Unit_Course) unit).getFinalGrade());
                }

                if (record instanceof Student_Research) {
                    Unit unit = ((Student_Research) record).getUnit();

                    outputWriter.println(((Student_Research) record).getEnrolmentType() + ", "
                            + record.getFirstName() + ", "
                            + record.getLastName() + ", "
                            + record.getStudentID() + ", "
                            + "NA, NA, NA, NA, NA, "
                            + ((Unit_Research) unit).getProposalMark() + ", "
                            + ((Unit_Research) unit).getDissertationMark() + ", "
                            + ((Unit_Research) unit).getOverallMark() + ", "
                            + ((Unit_Research) unit).getFinalGrade());
                }
            }
            System.out.println("Output CSV file (recordOutput.csv) written successfully");
        } finally {
            outputWriter.close();
        }
    }
}
