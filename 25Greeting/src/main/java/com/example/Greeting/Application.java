package com.example.Greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class Application {

	public AtomicLong counter =new AtomicLong();
	//public SimpleDateFormat sdf =new SimpleDateFormat("HH:MM:SS");
	public SimpleDateFormat sdf =new SimpleDateFormat("YY:MM:DD");

	@Value("${server.port}")
	public int port;

	public static void main(String[] args) {


		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/{name}")
	public Greeting hello(@PathVariable String name){

		List<String> lst= Arrays.asList("java","php","dot","net");
		Random r=new Random();
		String item= lst.get(r.nextInt(lst.size));
		return new Greeting(String.format("Hello %s",name),port,counter.incrementAndGet(),item,sdf.format(new Date()));

	}

}
