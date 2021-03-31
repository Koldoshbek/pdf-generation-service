package org.infosystema.pdfgenerationservice.services;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;


@Service
public class PdfService {
    public void getPdf(Map context) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(new ClassPathResource("forms/form_14.pdf").getInputStream());
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("src/main/resources/pdf/form14.pdf"));

        Font font = FontFactory.getFont("fonts/DejaVuSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        AcroFields form = stamper.getAcroFields();
        form.addSubstitutionFont(font.getBaseFont());
        form.setField("inn", (String) context.get("inn"));
        form.setField("fio", (String) context.get("fio"));
        form.setField("divCode", (String) context.get("div_code"));
        form.setField("divName", (String) context.get("div_name"));

        form.setField("correctionCode", (String) context.get("correction_code"));
        form.setField("correctionName", (String) context.get("correction_name"));

        form.setField("fromDay", (String) context.get("from_day"));
        form.setField("fromMonth", (String) context.get("from_month"));
        form.setField("fromYear", (String) context.get("from_year"));

        form.setField("toDay", (String) context.get("to_day"));
        form.setField("toMonth", (String) context.get("to_month"));
        form.setField("toYear", (String) context.get("to_year"));

        form.setField("paymentCode", (String) context.get("payment_code"));
        form.setField("paymentName", (String) context.get("payment_name"));

        form.setField("penalty", (String) context.get("penalty"));
        form.setField("fine", (String) context.get("fine"));

        form.setField("manager", (String) context.get("manager"));
        form.setField("director", (String) context.get("director"));

        form.setField("day", (String) context.get("day"));
        form.setField("month", (String) context.get("month"));
        form.setField("year", (String) context.get("year"));

        form.setField("inspector", (String) context.get("inspector_inn"));

        stamper.setFormFlattening(true);
        stamper.close();
    }

}
