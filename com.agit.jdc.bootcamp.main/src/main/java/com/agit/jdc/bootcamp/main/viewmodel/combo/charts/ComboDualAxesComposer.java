package com.agit.jdc.main.viewmodel.combo.charts;

import com.agit.jdc.bootcamp.main.model.WeatherData;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Legend;
import org.zkoss.chart.Series;
import org.zkoss.chart.YAxis;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 *
 * @author bayutridewanto
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ComboDualAxesComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        chart.getXAxis().setCategories(WeatherData.getCategories());
        chart.getXAxis().setCrosshair(true);

        // Primary y axis
        YAxis yAxis1 = chart.getYAxis();
        yAxis1.getLabels().setFormat("Rp {value}");
        yAxis1.getLabels().setStyle("color: " + chart.getColors().get(1).stringValue());
        yAxis1.setTitle("Unit Name");
        yAxis1.getTitle().setStyle("color: " + chart.getColors().get(1).stringValue());

        // Secondary y axis
        YAxis yAxis2 = chart.getYAxis(1);
        yAxis2.setTitle("% Growth");
        yAxis2.getTitle().setStyle("color: " + chart.getColors().get(0).stringValue());
        yAxis2.getLabels().setFormat("{value} mm");
        yAxis2.getLabels().setStyle("color: " + chart.getColors().get(0).stringValue());
        yAxis2.setOpposite(true);

        chart.getTooltip().setShared(true);

        Legend legend = chart.getLegend();
        legend.setLayout("vertical");
        legend.setAlign("left");
        legend.setX(120);
        legend.setVerticalAlign("top");
        legend.setY(100);
        legend.setFloating(true);
        legend.setBackgroundColor("white");
        initSeries();
    }

    private void initSeries() {
        Series rainfall = new Series("% Growth");
        rainfall.setName("% Growth");
        rainfall.setType("column");
        rainfall.setYAxis(1);
        rainfall.setData(WeatherData.getRainfall());
        chart.addSeries(rainfall);
        chart.getPlotOptions().getColumn().getTooltip().setValueSuffix(" mm");

        Series temperature = new Series("Posisi");
        temperature.setName("Posisi");
        temperature.setType("spline");
        temperature.setData(WeatherData.getTemperature());
        chart.addSeries(temperature);
        chart.getPlotOptions().getSpline().getTooltip().setValueSuffix(" Rp");
    }
}
