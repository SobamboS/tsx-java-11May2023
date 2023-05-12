package com.tsxjava.tsx;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
//@ImportResource("classpath:logback.xml")
public class TsxApplication {

	public static void main(String[] args) {


				SpringApplication.run(TsxApplication.class, args);
	}

}
