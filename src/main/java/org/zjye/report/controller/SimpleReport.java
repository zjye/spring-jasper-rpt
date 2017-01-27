package org.zjye.report.controller;

import java.util.List;

public class SimpleReport {
    private SimpleHeader header;
    private SimpleFooter footer;
    private List<SimpleDetail> details;

    public SimpleHeader getHeader() {
        return header;
    }

    public void setHeader(SimpleHeader header) {
        this.header = header;
    }

    public SimpleFooter getFooter() {
        return footer;
    }

    public void setFooter(SimpleFooter footer) {
        this.footer = footer;
    }

    public List<SimpleDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SimpleDetail> details) {
        this.details = details;
    }

}
