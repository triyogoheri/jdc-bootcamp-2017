package com.agit.jdc.main.viewmodel.map.charts;

import org.zkoss.chart.Charts;
import org.zkoss.chart.ChartsEvents;
import org.zkoss.chart.ColorAxis;
import org.zkoss.chart.Legend;
import org.zkoss.chart.Series;
import org.zkoss.chart.YAxis;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.json.JavaScriptValue;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */

public class HeatmapComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        YAxis yaxis = chart.getYAxis();
        ColorAxis cAxis = chart.getColorAxis();
        Legend legend = chart.getLegend();
        Series series = chart.getSeries();
        DataLabels labels = series.getDataLabels();

        chart.setModel(HeatMapData.getXYZModel());
        chart.setMarginTop(40);
        chart.setMarginBottom(80);
        chart.setPlotBorderWidth(1);
        chart.getXAxis().setCategories(new String[]{"Alexander", "Marie", "Maximilian", "Sophia", "Lukas", "Maria", "Leon", "Anna", "Tim", "Laura"});
        yaxis.setCategories(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
        yaxis.setTitle("");
        cAxis.setMin(new Integer(0));
        cAxis.setMinColor("#FFFFFF");
        cAxis.setMaxColor(chart.getColors().get(0));
        legend.setAlign("right");
        legend.setLayout("vertical");
        legend.setMargin(new Integer(0));
        legend.setVerticalAlign("top");
        legend.setY(new Integer(25));
        legend.setSymbolHeight(new Integer(280));
        chart.getTooltip().addExtraAttr("formatter", new JavaScriptValue("function () { return '<b>' + this.series.xAxis.categories[this.point.x]"
                + " + '</b> sold <br><b>' + this.point.value"
                + " + '</b> items on <br><b>' + this.series.yAxis.categories[this.point.y] + '</b>'; }"));
        series.setBorderWidth(new Integer(1));
        labels.setEnabled(true);
        labels.setColor("black");
        chart.addEventListener(0, ChartsEvents.ON_PLOT_THEME_CHANGE, new EventListener() {
            public void onEvent(Event event) throws Exception {
                chart.getColorAxis().setMaxColor(chart.getColors().get(0));
            }
        });
    }
}
