package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	private String loginpage = "./resources/html/login.html";
	private String registration = "./resources/html/registration.html";

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/login")
    public String loginPage(){	
    	try {return readFile(loginpage);}
    	catch (FileNotFoundException e) {}
    	catch (IOException e) {}
		
    	return "";   	    	
    }
    
    @RequestMapping("/registration")
    public String registrationPage(){	
    	try {return readFile(registration);}
    	catch (FileNotFoundException e) {}
    	catch (IOException e) {}
		
    	return "";   	    	
    }

	private String readFile(String filepath) throws FileNotFoundException, IOException {
		StringBuilder sb = new StringBuilder();
		File f = new File(filepath);
		BufferedReader br = new BufferedReader(new FileReader(f));		
		
		String line = "";
		
		while((line = br.readLine()) != null)
			sb.append(line);
		
		return sb.toString();
	}
}
