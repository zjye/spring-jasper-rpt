package org.zjye.report.sample;

import org.zjye.report.controller.SimpleDetail;
import org.zjye.report.controller.SimpleFooter;
import org.zjye.report.controller.SimpleHeader;
import org.zjye.report.controller.SimpleReport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

public class SampleDataSourceFactory {
    public static Collection<SimpleReport> generate() {
        SimpleReport report = new SimpleReport();
        report.setDetails(generateDetails(100));
        report.setFooter(new SimpleFooter());
        report.setHeader(new SimpleHeader());
        return asList(report);
    }

    private static List<SimpleDetail> generateDetails(int count) {
        List<SimpleDetail> details = new ArrayList<SimpleDetail>();

        for(int i=0;i<count;i++) {
            details.add(new SimpleDetail("MY", "foo" + i));
        }

        return details;
    }

}
