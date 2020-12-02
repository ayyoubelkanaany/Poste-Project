package com.example.application;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.application.bean.Utilisateur;
import com.example.application.filesUpload.FileStorageProperties;
import com.example.application.service.impl.PosteServiceImpl;
import com.example.application.service.impl.UtilisateurServiceImpl;

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
