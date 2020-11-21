package com.example.application.service.facad;
import com.example.application.filesUpload.FileStorageProperties;
import org.springframework.core.io.Resource;

import org.springframework.web.multipart.MultipartFile;


public interface FileStorageService {
	 public void FileStorageService(FileStorageProperties fileStorageProperties);
	 public String storeFile(MultipartFile file);
	 public Resource loadFileAsResource(String fileName);
}
