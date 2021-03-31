package org.infosystema.pdfgenerationservice.model;


public class CorrectionForm {

    private final long id;
    private final String content;

    public CorrectionForm(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}