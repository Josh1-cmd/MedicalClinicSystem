import java.util.Scanner;
// shows patient
class Patient {
    String name;

    //new patient
    public Patient(String patientName) {
        name = patientName;
    }
}
//shows doctor
class Doctor {
    String name;

    
    public Doctor(String doctorName) {
        name = doctorName;
    }
}
//shows appointment of patient

class Appointment {
    String time;
    Patient patient;
    Doctor doctor;

    //to create a new appointment
    public Appointment(String appointmentTime, Patient appointmentPatient, Doctor appointmentDoctor) {
        time = appointmentTime;
        patient = appointmentPatient;
        doctor = appointmentDoctor;
    }

    // shows appointment information
    public void displayInfo() {
        System.out.println("Appointment Time: " + time);
        System.out.println("Patient: " + patient.name);
        System.out.println("Doctor: " + doctor.name);
    }
}
//shows prescription for patient
class Prescription {
    String medicine;
    String dosage;

    // shows new prescription
    public Prescription(String medicineName, String dosageAmount) {
        medicine = medicineName;
        dosage = dosageAmount;
    }

    // show prescription information
    public void displayInfo() {
        System.out.println("Medicine: " + medicine);
        System.out.println("Dosage: " + dosage);
    }
}

public class SimpleMedicalClinicSystem {
    public static void main(String[] args) {
        
        Patient patient = null;
        Doctor doctor = null;
        Appointment appointment = null;
        Prescription prescription = null;

        Scanner scanner = new Scanner(System.in);

       
        while (true) {
            System.out.println("\nSimple Medical Clinic System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. Add Prescription");
            System.out.println("5. View Appointment");
            System.out.println("6. View Prescription");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a new patient
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    patient = new Patient(patientName);
                    System.out.println("Patient added!");
                    break;

                case 2:
                    // Add a new doctor
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    doctor = new Doctor(doctorName);
                    System.out.println("Doctor added!");
                    break;

                case 3:
                    // Schedule an appointment
                    if (patient != null && doctor != null) {
                        System.out.print("Enter Appointment Time: ");
                        String appointmentTime = scanner.nextLine();
                        appointment = new Appointment(appointmentTime, patient, doctor);
                        System.out.println("Appointment scheduled!");
                    } else {
                        System.out.println("Please add a patient and a doctor first!");
                    }
                    break;

                case 4:
                    // Add a prescription for the patient
                    if (patient != null) {
                        System.out.print("Enter Medicine Name: ");
                        String medicineName = scanner.nextLine();
                        System.out.print("Enter Dosage: ");
                        String dosageAmount = scanner.nextLine();
                        prescription = new Prescription(medicineName, dosageAmount);
                        System.out.println("Prescription added!");
                    } else {
                        System.out.println("Please add a patient first!");
                    }
                    break;

                case 5:
                    // View appointment details
                    if (appointment != null) {
                        System.out.println("\nAppointment Details:");
                        appointment.displayInfo();
                    } else {
                        System.out.println("No appointment scheduled yet.");
                    }
                    break;

                case 6:
                    // for prescription details
                    if (prescription != null) {
                        System.out.println("\nPrescription Details:");
                        prescription.displayInfo();
                    } else {
                        System.out.println("No prescription added yet.");
                    }
                    break;

                case 7:
                    // Exit  
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Try again.");
                    break;
            }
        }
    }
}
