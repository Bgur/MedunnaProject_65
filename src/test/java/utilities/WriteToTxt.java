package utilities;


import pojos.Appointment;
import pojos.Registrant;
import pojos.US25_appointment;
import pojos.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToTxt {

//    public static void saveRegistrantData(Registrant registrant, String fileName){
//
//        try {
//
//            FileWriter fileWriter = new FileWriter(fileName, true);
//            //src/resource/feature/testdata/PatientData
//
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void saveRegistrantData(Registrant registrant){

        try {
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("registrantFile"), true);


            BufferedWriter writer = new BufferedWriter(fileWriter);

//            writer.append(registrant.getFirstName() + "," + registrant.getLastName() + ","
//                            + registrant.getUsername() + "," + registrant.getEmail() + ","
//                            + registrant.getPassword() + "," + registrant.getSSN() + ", \n");

            writer.append(registrant.toString() + ", \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveRegistrantApiData(User user){

        try {
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("registrantApiFile"), true);


            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(user.toString() + ", \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    public static void savePatientdata(pojos.Patients_US015 patients_us015) {
//        try {
//            //src/resources/testdata/Registrantdata.txt
//            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("PatientData_Path"), true);
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//            writer.append(patients_us015 + "\n");
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public static void saveAppointmentIds(String fileName, List<Object> id){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");

            writer.close();

        } catch (IOException e) {
        }

    }
    public static void savePhysician(String fileName, List<Object> id){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

            for (int i=0; i< id.size(); i++)
                writer.append(id.get(i).toString()+",\n");

            writer.close();

        } catch (IOException e) {
        }

    }

    public static void saveAppointmentDatalar(US25_appointment us25appointment){

        try{

            //src/test/resources/testdata/AppointmentDatalar.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("AppointmentDatalar"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(us25appointment+"\n");


            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void saveAppointmentApiDatalar(US25_appointment us25appointment){

        try{

            //src/test/resources/testdata/AppointmentDatalar.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("AppointmentApiDatalar"), true);

            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(us25appointment+"\n");

            writer.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
