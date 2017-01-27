package org.zjye.report.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;

import static java.util.Arrays.asList;

@RestController
public class FooReportController {


    @RequestMapping(value = "foo", method = RequestMethod.GET)
    public void getFoo() throws Exception {
        try {

            JasperReport report = JasperCompileManager.compileReport(
                    new ClassPathResource("reports/rpt_foo.jrxml")
                    .getInputStream());

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(asList(
                    new SimpleDetail("MY", "foo"),
                    new SimpleDetail("AU", "bar")
            ));

            JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), beanColDataSource);


            JRCsvExporter exporter = new JRCsvExporter();
            exporter.setExporterOutput(new SimpleWriterExporterOutput(new File("e://reports/simple_report.csv")));
            exporter.setExporterInput(new SimpleExporterInput(print));
            exporter.exportReport();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

