package com.example.application.ws;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.application.filesUpload.UploadFileResponse;
import com.example.application.service.impl.FileStorageServiceImpl;
import com.google.common.io.Files;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FilesRest {

    private static final Logger logger = LoggerFactory.getLogger(FilesRest.class);

    @Autowired
    private FileStorageServiceImpl fileStorageService;
    
    @RequestMapping(value = "/file",method = RequestMethod.POST,consumes = { "multipart/form-data" })
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    
   /* 
    @RequestMapping(value = "/files",method = RequestMethod.POST)
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
*/
    @RequestMapping(value = "/file/{fileName:.+}",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = (Resource) fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
    @RequestMapping(value = "/file/get/{fileName:.+}",method = RequestMethod.GET,produces = "application/json")
    public byte[] getFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
    	 Resource resource;
    	try {
    		 resource = (Resource) fileStorageService.loadFileAsResource(fileName);
    	     System.out.println("llllllllllll"+resource.getFile().getAbsolutePath());
    	     return Files.toByteArray(resource.getFile());
		} catch (Exception e) {
			// TODO: handle exception
		}
    	 return null;
    }
}