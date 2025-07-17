import java.util.Scanner;

public class clinic {

    String name;
    patient[] patients;
    int index = 0;

    public clinic(String n, int num) {
        this.name = n;
        patients = new patient[num];
    }

    public boolean exists(patient p) {
        for (int i = 0; i < index; i++) {
            if (p.equals(patients[i])) {
                return true;
            }
        }
        return false;
    }

    public void addPatient(patient p) {
        if (exists(p)) {
            System.out.println(p.getName() + " already has an appointment.");
        } else {
            patients[index++] = p;
        }
    }

    public void find(String name) {
        for (int i = 0; i < index; i++) {
            if (patients[i].getName().equalsIgnoreCase(name)) {
                System.out.println(patients[i]);
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < index; i++) {
            System.out.println(patients[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        clinic Clinic = new clinic("City Clinic", 100);

        patient p1 = new patient("John", 15.05, 13.00, "Teeth");
        patient p2 = new patient("John", 15.07, 9.30, "Knee Pain");
        patient p3 = new patient("Alice", 22.06, 13.00, "Stomach");

        Clinic.addPatient(p1);
        Clinic.addPatient(p2);
        Clinic.addPatient(p3);
        Clinic.addPatient(p3);

        System.out.println("password:");
        String pw = scan.nextLine();

        while (pw.equals("admin")) {

            System.out.println("1. Add Patient");
            System.out.println("2. Find patient by name");
            System.out.println("3. See all patients");
            System.out.println("4. Exit");
            String task = scan.nextLine();

            switch (task) {
                case "1":
                    System.out.println("Patient name:");
                    String Name = scan.nextLine();

                    double date;
                    while (true) {
                        System.out.println("Date (d.mm):");
                        if (scan.hasNextDouble()) {
                            date = scan.nextDouble();
                            if (date >= 1.01 && date <= 31.12) {
                                scan.nextLine(); 
                                break;
                            } else {
                                System.out.println("Invalid date. Try again.");
                            }
                        } else {
                            System.out.println("Invalid input. Enter a number like 15.07.");
                            scan.next(); 
                        }
                    }

                    double time;
                    while (true) {
                        System.out.println("Clock (8.0 - 24.0):");
                        if (scan.hasNextDouble()) {
                            time = scan.nextDouble();
                            if (time >= 8.0 && time <= 24.0) {
                                scan.nextLine(); 
                                break;
                            } else {
                                System.out.println("Invalid time. Try again.");
                            }
                        } else {
                            System.out.println("Invalid input. Enter a number like 13.30.");
                            scan.next(); 
                        }
                    }

                    System.out.println("Case:");
                    String Type = scan.nextLine();

                    patient newPatient = new patient(Name, date, time, Type);
                    Clinic.addPatient(newPatient);
                    break;

                case "2":
                    System.out.println("Find patient by name:");
                    String n = scan.nextLine();
                    Clinic.find(n);
                    break;

                case "3":
                    Clinic.printAll();
                    break;

                case "4":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scan.close();
    }
}
