package com.agit.jdc.main.viewmodel.combo.charts;

import com.agit.jdc.bootcamp.main.model.ComboData;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Color;
import org.zkoss.chart.LabelsItem;
import org.zkoss.chart.Marker;
import org.zkoss.chart.Series;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

public class ComboComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        List<Color> colors = chart.getColors();

        chart.getXAxis().setCategories(ComboData.getCategories());

        chart.getTooltip().setHeaderFormat("{point.key}: ");
        chart.getTooltip().setPointFormat("{point.y}");

        LabelsItem item = new LabelsItem("Giro");
        item.setStyle("left: '40px'; top: '8px'; color: 'black'");

        chart.getLabels().setItems(Arrays.asList(item));

        for (Entry<String, Integer[]> entry : ComboData.getConsumption().entrySet()) {
            Series series = new Series(entry.getKey());
            series.setType("column");
            series.setData(entry.getValue());
            chart.addSeries(series);
        }
        Series average = new Series("Average");
        average.setType("spline");
        average.setData(ComboData.getAverage());
        Marker marker = average.getMarker();
        marker.setLineWidth(2);
        marker.setLineColor(chart.getColors().get(3));
        marker.setFillColor("white");
        chart.addSeries(average);

//        Series total = new Series("Total consumption");
//        total.setType("pie");
//        int i = 0;
//        for (String person : ComboData.getConsumption().keySet()) {
//            Point point = new Point(person, ComboData.getSum(person));
//            point.setColor(colors.get(i++));
//            total.addPoint(point);
//        }
//        PiePlotOptions plotOptions = new PiePlotOptions();
//        plotOptions.setCenter(100, 80);
//        plotOptions.setSize(100);
//        plotOptions.setShowInLegend(false);
//        plotOptions.getDataLabels().setEnabled(false);
//        plotOptions.getTooltip().setPointFormat("{point.y} fruits");
//        total.setPlotOptions(plotOptions);
//        chart.addSeries(total);
    }
}
