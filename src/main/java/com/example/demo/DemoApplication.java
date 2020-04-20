package com.example.demo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) throws IOException {
    	//write_file("ASDFFFF");
    	//append_file("1234.txt", "fsdasdadasdsadsad");
        SpringApplication.run(DemoApplication.class, args);
    }
    
    //working
    public static void write_file(String id, String body) throws IOException {
    	BufferedWriter w = new BufferedWriter(new FileWriter(id));
        w.write(body);
        w.close();
    }
    
    //working
    public static void append_file(String fileName, String body) throws IOException {
    	
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(' ');
        writer.append(body);
        writer.close();
    	
    }
    
    public static String load_file(String id) throws FileNotFoundException {
    	File curFile = new File(id);
    	String data = "";
    	try {
			Scanner fr = new Scanner(curFile);
			while(fr.hasNextLine()) {
				return data = data + fr.nextLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data = "There was an error";
		}
		return data;
    	
    }

    @RequestMapping("/greeting")
    public void testFunc() {
        System.out.println("This is a test");
    }
    
    @RequestMapping("/writeFile")
    @CrossOrigin(maxAge = 3600)
    @ResponseBody
    public void writeFile(HttpServletResponse response, @RequestParam("id") String id,
                        @RequestParam("body") String body) throws IOException {
        response.getWriter().println("SUCCESS");
        String fileName = id + ".txt";
        write_file(fileName, body);
        System.out.println("File saved");
        //Example URL http://localhost:8080/writeFile?id=2345&body=abc
        
    }
    
    @RequestMapping("/loadFile")
    @CrossOrigin(maxAge = 3600)
    @ResponseBody
    public void loadFile(HttpServletResponse response, @RequestParam("id") String id) throws IOException {
       
        String fileName = id + ".txt";
        String data = load_file(fileName);
        response.getWriter().println(data);
        //Example URL http://localhost:8080/loadFile?id=1234
        
    }
    
    
}
