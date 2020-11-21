package com.example.application;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.application.filesUpload.FileStorageProperties;

import javassist.expr.NewArray;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class PosteProjectApplication {

	public static void main(String[] args) {
		System.out.println("Date fromDate main calss"+new Date());
		SpringApplication.run(PosteProjectApplication.class, args);
	}

}
