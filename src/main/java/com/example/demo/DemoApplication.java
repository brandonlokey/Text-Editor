package com.example.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
    	//write_new("ASDFFFF");
    	//append_file("1234.txt", "fsdasdadasdsadsad");
        SpringApplication.run(DemoApplication.class, args);
    }

    
    
    //working
    public static void write_new(String body) throws IOException {
    	String fileName = "1234.txt"; //Needs to be more dynamic this is just to test
    	BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
        w.write(body);
        w.close();
    }
    
    //working
    public static void append_file(String fileName, String body) throws IOException {
    	
    	String str = "Hello World";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(' ');
        writer.append(str);
        writer.close();
    	
    }
    
}
