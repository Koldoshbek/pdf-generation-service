package org.infosystema.pdfgenerationservice.controllers;
import com.itextpdf.text.DocumentException;
import org.infosystema.pdfgenerationservice.services.PdfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.Map;


@RestController
public class CorrectionFormController {
    private final PdfService pdfService;

    public CorrectionFormController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/correction_card")
    ResponseEntity<String> generation_pdf(@RequestBody Map context)
            throws IOException, DocumentException {
        pdfService.getPdf(context);
        return new ResponseEntity<>("127.0.0.1:8080/resources/pdf/form14.pdf", HttpStatus.OK);
    }
}