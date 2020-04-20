package com.example.demo;
import java.io.*;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
public class Server {

    public static void main(String[] args) throws IOException {
    	//write_file("ASDFFFF");
    	//append_file("1234.txt", "fsdasdadasdsadsad");
        SpringApplication.run(Server.class, args);
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

    /* Returns a json of all text files in currently in directory
        Currently retrieves names of text files correctly, not returning JSON yet
     */
    @RequestMapping(path = "/getFiles", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public static JsonArray fileReturn() {
        String[] pathnames;
        File f = new File(System.getProperty("user.dir"));
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            }
        };

        pathnames = f.list(filter);

        for (String pathname : pathnames) {
            System.out.println(pathname);
        }

        JsonArray json_array= new JsonArray();
        for (int i = 0; i < pathnames.length; i++) {
            json_array.add(pathnames[i]);
        }
        return json_array;
    }
}
