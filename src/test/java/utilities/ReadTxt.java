package utilities;



import pojos.Appointment;
import pojos.Country2;
import pojos.Physician;
import pojos.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {



    public static List<String> getSSNIDs(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigReader.getProperty("database_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){

                String ssn = line.split(",")[0];
                list.add(ssn);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }




    public static List<String> getAPISSNIDs(){
        List <String > list = new ArrayList<>();


        try{

            //identify file location
            FileReader fileReader = new FileReader(ConfigReader.getProperty("api_all_registrant_data"));

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();//856-45-6789,

            while(line != null){

                String ssn = line.split(",")[2];
                list.add(ssn);

                line = br.readLine();

            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return list;
    }


    public static List<Object> returnAppointmentsIDsList(String filePath){
        List <Object > list = new ArrayList<>();

        try(BufferedReader br= new BufferedReader(new FileReader(filePath))){
            StringBuilder sb= new StringBuilder();
            String line=br.readLine();
            System.out.println(line);

            int i=0;
            while(line != null){
                Appointment appointment=new Appointment();
                appointment.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

                list.add(appointment.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static List<Object> returnPhysicianIDsList(String filePath){
        List<Object>all = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Physician physician = new Physician();
                physician.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();

//                System.out.println(i++);

                all.add(physician.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnCountryIDsList(String filePath) {

        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                Country2 country = new Country2();
                country.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(country.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnStateIDsList(String filePath) {

        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                State state = new State();
                state.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(state.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }


    public static List<Object> returnStateNamesList(String filePath) {

        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                State state = new State();
                state.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(state.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }

    public static List<Object> returnCountryNamesList(String filePath) {

        List<Object> all = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            System.out.println(line);
            int i = 0;
            while (line != null) {
                State state = new State();
                state.setId(Integer.parseInt(line.split(",")[0]));
                sb.append(System.lineSeparator());
                line = br.readLine();
                all.add(state.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return all;
    }



}
