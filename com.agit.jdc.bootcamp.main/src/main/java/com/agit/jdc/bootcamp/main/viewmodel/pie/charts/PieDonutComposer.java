package com.agit.jdc.main.viewmodel.pie.charts;

import java.util.List;
import java.util.Map;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Color;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class PieDonutComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        chart.getYAxis().setTitle("Total percent market share");
        chart.getPlotOptions().getPie().setShadow(false);
        chart.getPlotOptions().getPie().setCenter("50%", "50%");
        chart.getTooltip().setValueSuffix("%");
        initSeries();
    }

    private void initSeries() {
        Series browser = chart.getSeries();
        Series version = chart.getSeries(1);
        browser.setName("Browsers");
        List<Color> colors = chart.getColors();
        int i = 0;
        for (Map.Entry<String, Double> browserEntry : PieDonutData.getBrowsers().entrySet()) {
            String key = browserEntry.getKey();
            double browserValue = browserEntry.getValue();
            Point browserPoint = new Point(key, browserValue);
            browserPoint.setColor(colors.get(i));
            if (browserValue < 5) {
                browserPoint.getDataLabels().setEnabled(false);
            }
            browser.addPoint(browserPoint);
            for (Map.Entry<String, Double> versionEntry : PieDonutData.getVersions(key).entrySet()) {
                double versionValue = versionEntry.getValue();
                Point versionPoint = new Point(versionEntry.getKey(), versionValue);
                versionPoint.setColor(colors.get(i));
                if (versionValue < 1) {
                    versionPoint.getDataLabels().setEnabled(false);
                }
                version.addPoint(versionPoint);
            }
            i += 1;
        }
        PiePlotOptions browserPlotOptions = new PiePlotOptions();
        browserPlotOptions.setSize("60%");
        browser.setPlotOptions(browserPlotOptions);
        DataLabels browserLabels = browser.getDataLabels();
        browserLabels.setFormat("{point.name}");
        browserLabels.setColor("white");
        browserLabels.setDistance(-30);
        PiePlotOptions versionPlotOptions = new PiePlotOptions();
        versionPlotOptions.setSize("80%");
        versionPlotOptions.setInnerSize("60%");
        version.setPlotOptions(versionPlotOptions);
        version.getDataLabels().setFormat("<b>{point.name}:</b> {point.y}%");
    }
}
