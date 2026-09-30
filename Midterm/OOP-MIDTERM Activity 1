    import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Helper Student class for Program 6
final class Student {
    private String studentName;
    private int tariffPoints;
    public static int noOfStudents = 0;

    public String getStudentName() { return studentName; }
    public int getTariffPoints() { return tariffPoints; }
    
    public void setTariffPoints(int points) {
        if (points < 20 || points > 280) throw new IllegalArgumentException("Points must be 20-280");
        this.tariffPoints = points;
    }

    // Default Constructor - Updated to use GregorianCalendar to remove the deprecation warning
    public Student() {
        this("not known", "not known", 
             new GregorianCalendar(1995, Calendar.JANUARY, 1).getTime(), 
             20);
    }

    // Parameterized Constructor
    public Student(String no, String name, Date dob, int points) {
        this.studentName = name;
        setTariffPoints(points);
        noOfStudents++;
    }
}

public class LabActivity {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char choice;
        do {
            System.out.println("\nFINAL OUTPUT :");
            System.out.println("Choose the program you want to run");
            System.out.println("Number 1");
            System.out.println("Number 2");
            System.out.println("Number 3");
            System.out.println("Number 4");
            System.out.println("Number 5");
            System.out.println("Number 6");
            System.out.println("Number 7");
            System.out.print("Enter selection (1-7): ");
            
            int programNum = sc.nextInt();
            
            switch (programNum) {
                case 1: runProgram1(); break;
                case 2: runProgram2(); break;
                case 3: runProgram3(); break;
                case 4: runProgram4(); break;
                case 5: runProgram5(); break;
                case 6: runProgram6(); break;
                case 7: runProgram7(); break;
                default: System.out.println("Invalid selection!");
            }

            System.out.print("\nDo you want to continue ? Y/N: ");
            choice = sc.next().toUpperCase().charAt(0);
        } while (choice == 'Y');
        
        System.out.println("Program Terminated");
    }

    // 1) Read 10 real numbers and process separate calculations
    private static void runProgram1() {
        double[] arr = new double[10];
        System.out.println("Enter 10 real numbers:");
        for (int i = 0; i < 10; i++) arr[i] = sc.nextDouble();

        // Loop 1: Positive sum and average
        double sum = 0; int posCount = 0;
        for (double x : arr) {
            if (x > 0) { sum += x; posCount++; }
        }
        System.out.println("Sum: " + sum + ", Average: " + (posCount > 0 ? sum / posCount : 0));

        // Loop 2: Negative count
        int negCount = 0;
        for (double x : arr) if (x < 0) negCount++;
        System.out.println("Negative Count: " + negCount);

        // Loop 3: Minimum value
        double min = arr[0];
        for (double x : arr) if (x < min) min = x;
        System.out.println("Minimum Value: " + min);
    }

    // 2) Read 8 integers, remove duplicates, find 2nd boundaries
    private static void runProgram2() {
        int[] numbers = new int[8];
        System.out.println("Enter 8 integers:");
        for (int i = 0; i < 8; i++) numbers[i] = sc.nextInt();

        int[] unique = Arrays.stream(numbers).distinct().sorted().toArray();
        System.out.println("Array without duplicates: " + Arrays.toString(unique));

        if (unique.length >= 2) {
            System.out.println("Second Smallest: " + unique[1]);
            System.out.println("Second Largest: " + unique[unique.length - 2]);
        } else {
            System.out.println("Not enough unique elements.");
        }
    }

    // 3) Delete an item from an array via structural index pos
    private static void runProgram3() {
        int[] arr = new int[5];
        System.out.print("Enter Data in Array: ");
        for (int i = 0; i < 5; i++) arr[i] = sc.nextInt();

        System.out.print("Enter poss. of Element to Delete: ");
        int pos = sc.nextInt();

        System.out.print("New data in Array: ");
        for (int i = 0; i < 5; i++) {
            if (i != pos) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 4) Sort inputs out onto custom Odd or Even console rows
    private static void runProgram4() {
        System.out.print("Enter Size of Array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) arr[i] = sc.nextInt();

        System.out.print("Even Elements: ");
        for (int x : arr) if (x % 2 == 0) System.out.print(x + " ");

        System.out.print("\nOdd Elements: ");
        for (int x : arr) if (x % 2 != 0) System.out.print(x + " ");
        System.out.println();
    }

    // 5) Build nested loop tracking dynamic char print matrices
    private static void runProgram5() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j == i ? "*" : "*A");
            }
            System.out.println();
        }
    }

    // 6) Model object tracking instances
    private static void runProgram6() {
        Student s1 = new Student();
        Student s2 = new Student("S12", "John Doe", new Date(), 250);
        System.out.println("Student 1 Name: " + s1.getStudentName() + ", Points: " + s1.getTariffPoints());
        System.out.println("Student 2 Name: " + s2.getStudentName() + ", Points: " + s2.getTariffPoints());
        System.out.println("Total Students Created: " + Student.noOfStudents);
    }

    // 7) Read data record lines from tab-delimited file to DB batches
    private static void runProgram7() {
        String url = "jdbc:mysql://localhost:3306/university_db";
        String q = "INSERT INTO students (eno, ename, mobile) VALUES (?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"));
             Connection conn = DriverManager.getConnection(url, "root", "password");
             PreparedStatement pstmt = conn.prepareStatement(q)) {

            String line = br.readLine(); // Skip structural header labels
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                if (data.length >= 3) {
                    pstmt.setInt(1, Integer.parseInt(data[0].trim()));
                    pstmt.setString(2, data[1].trim());
                    pstmt.setString(3, data[2].trim());
                    pstmt.addBatch();
                }
            }
            pstmt.executeBatch();
            System.out.println("Data transferred successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: 'data.txt' file was not found. Please create it first.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
