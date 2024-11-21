package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String firstName;
    String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Full Name: " + getFullName();
    }
}

class StudentManagement {

    private static final ArrayList<Student> studentList = new ArrayList<Student>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Enter student list");
            System.out.println("2. Find student by last name");
            System.out.println("3. Find and edit student by full name");
            System.out.println("4. End");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Ending program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int numOfStudents = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng dư sau khi nhập số lượng sinh viên

        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            // Thêm sinh viên vào danh sách
            studentList.add(new Student(firstName, lastName));

            // Thông báo nhập tên thành công
            System.out.println("Student " + firstName + " " + lastName + " added successfully!");
        }
    }


    private static void findStudentByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        boolean found = false;

        for (Student student : studentList) {
            if (student.lastName.equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with the last name " + lastName);
        }
    }

    private static void findAndEditStudentByFullName() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println("Student found: " + student);
                System.out.println("Enter new first name: ");
                student.firstName = scanner.nextLine();
                System.out.println("Enter new last name: ");
                student.lastName = scanner.nextLine();
                System.out.println("Student updated: " + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No student found with the full name " + fullName);
        }
    }
}
