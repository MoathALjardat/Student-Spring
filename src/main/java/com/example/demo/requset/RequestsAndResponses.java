package com.example.demo.requset;

import com.example.demo.student.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class RequestsAndResponses {

    public static int requestForCount() throws IOException {

       URL url = new URL("http://localhost:9191/count");
        URLConnection connection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String inputLine;

        int count = 0;
        while ((inputLine = bufferedReader.readLine()) != null)
            count = Integer.parseInt(inputLine);
        bufferedReader.close();
        return count ;
    }


    public static double requestForGpa(int id) throws IOException {

        URL url = new URL("http://localhost:9191/getGpa/" + id);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        StringBuilder jsonString = new StringBuilder("");

        while ((inputLine = in.readLine()) != null)
           jsonString.append(inputLine);


        Gson gson = new Gson();

        Student student = gson.fromJson(jsonString.toString(), Student.class);


        in.close();
        return student.getGpa();

    }

    public static List<Student> getStudentsThierMarkesAbove50() throws IOException {

        URL url = new URL("http://localhost:9191/getGpa/above50");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        StringBuilder jsonString = new StringBuilder("");

        while ((inputLine = in.readLine()) != null)
            jsonString.append(inputLine);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter();

        List<Student> studentsAbove50 = null;

        try {
            studentsAbove50 = objectMapper.readValue(jsonString.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        in.close();
        return studentsAbove50;

    }

    public static Student requestForMaxGpa() throws IOException {

        URL url = new URL("http://localhost:9191/getGpa/max");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        StringBuilder jsonString = new StringBuilder("");

        while ((inputLine = in.readLine()) != null)
            jsonString.append(inputLine);


        Gson gson = new Gson();

        Student student = gson.fromJson(jsonString.toString(), Student.class);


        in.close();

        return student;

    }



}
