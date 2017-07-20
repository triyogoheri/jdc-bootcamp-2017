package com.agit.jdc.main.viewmodel.min.max;

import org.zkoss.chart.Charts;
import org.zkoss.chart.ChartsEvents;
import org.zkoss.chart.Series;
import org.zkoss.chart.YAxis;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
public class MinMaxComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart2;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        chart2.getXAxis().setCategories("Jan", "Feb", "Mar", "Apr", "May",
                "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        chart2.setChart(null);

        // Primary y Axis
        YAxis yAxis1 = chart2.getYAxis(1);
        yAxis1.getLabels().setFormat("Rp {value}");
        yAxis1.getLabels().setStyle("color: " + chart2.getColors().get(0).stringValue());
        yAxis1.setTitle("Surplus");
        yAxis1.getTitle().setStyle("color: " + chart2.getColors().get(0).stringValue());

        // Secondary y Axis
        YAxis yAxis2 = chart2.getYAxis();
        yAxis2.setTitle("% Akumulasi");
        yAxis2.setMin(0);
        yAxis2.setMax(100);
        yAxis2.getTitle().setStyle("color: " + chart2.getColors().get(1).stringValue());
        yAxis2.getLabels().setFormat("{value} %");
        yAxis2.getLabels().setStyle("color: " + chart2.getColors().get(1).stringValue());
        yAxis2.setOpposite(true);

        chart2.getTooltip().setShared(true);

        Series series1 = chart2.getSeries();
        series1.setName("Surplus");
        series1.setType("column");
        series1.setYAxis(1);
        series1.setData(1000.0, 2000.0, 3000.0, 4000.0, 5000.0, 6000.0, 7000.0, 8000.0,
                9000.0, 10000.0, 11000.0, 12000.0);
        series1.getPlotOptions().getTooltip().setPointFormat("<span style=\"font-weight: bold; color:"
                + "{series.color}\">{series.name}</span>: <b>Rp {point.y:.1f}</b>  ");

        Series series2 = chart2.getSeries(1);
        series2.setName("Rainfall error");
        series2.setType("errorbar");
        series2.setYAxis(1);

        Series series3 = chart2.getSeries(2);
        series3.setName("Akumulasi ");
        series3.setType("spline");
        series3.setData(10.0, 12.9, 15.5, 20.5, 25.2, 27.5, 29.2, 35.5, 45.3,
                50.3, 65.9, 100.0);
        series3.getPlotOptions().getTooltip().setPointFormat("<span style=\"font-weight: bold;"
                + "color: {series.color}\">{series.name}</span>: <b>{point.y:.1f} %</b>");

        Series series4 = chart2.getSeries(3);
        series4.setName("Temperature error");
        series4.setType("errorbar");
        series4.setColor("red");
        series4.setLineWidth(1);
        series4.addPoint(6, 8);
        series4.addPoint(5, 10);
        series4.addPoint(5, 15);
        series4.addPoint(7.1, 25);
        series4.addPoint(20, 30);
        series4.addPoint(21.0, 34.0);
        series4.addPoint(23.2, 35.3);
        series4.addPoint(26.1, 37.8);
        series4.addPoint(23.2, 33.9);
        series4.addPoint(18.0, 31.1);
        series4.addPoint(12.9, 24.0);
        series4.addPoint(7.6, 15.0);
        series4.getPlotOptions().getTooltip().setPointFormat(" (range value : {point.low} - {point.high})<br/>");

        chart2.addEventListener(0, ChartsEvents.ON_PLOT_THEME_CHANGE, new EventListener() {
            public void onEvent(Event event) throws Exception {
                YAxis yAxis1 = chart2.getYAxis();
                YAxis yAxis2 = chart2.getYAxis(1);
                String color1 = chart2.getColors().get(0).stringValue();
                String color2 = chart2.getColors().get(1).stringValue();
                yAxis1.getLabels().setStyle("color: '" + color2 + "'");
                yAxis1.getTitle().setStyle("color: '" + color2 + "'");
                yAxis2.getLabels().setStyle("color: '" + color1 + "'");
                yAxis2.getTitle().setStyle("color: '" + color1 + "'");
            }
        });
    }

}
