package org.infosystema.pdfgenerationservice.controllers;

import com.itextpdf.text.DocumentException;
import com.sun.net.httpserver.HttpServer;
import org.infosystema.pdfgenerationservice.services.PdfService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class CorrectionFormController {
    private final PdfService pdfService  = new PdfService();

    public CorrectionFormController() {

    }

//    @PostMapping("/correction_card")
//    ResponseEntity<String> generation_pdf(@RequestBody Map context, HttpServletRequest request)
//            throws IOException, DocumentException {
//        pdfService.getPdf(context);
//        return new ResponseEntity<>("/content/form14.pdf", HttpStatus.OK);
//    }

    @GetMapping("/correction_card")
    ResponseEntity<InputStreamResource> generation_pdf(@RequestBody Map context, HttpServletRequest request)
            throws IOException, DocumentException {
        System.out.println(context);
        String filePath = pdfService.getPdf(context);
        File file = new File(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        String name = filePath.substring(filePath.lastIndexOf("/"));
        headers.add("content-disposition", "inline;filename=" +name);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);

//        Map<String,String> map = new HashMap<>();
//        map.put("inn","55555555555555");
//        String filePath = pdfService.getPdf(map);
//        File file = new File(filePath);
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .contentLength(file.length()) //
//                .body(resource);
    }


}