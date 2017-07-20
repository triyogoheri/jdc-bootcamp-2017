package com.agit.jdc.main.viewmodel.pie.charts;

/**
 *
 * @author bayutridewanto
 */
import org.zkoss.chart.Chart;
import org.zkoss.chart.Charts;
import org.zkoss.chart.Title;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;


public class PieSemiCircleComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;
    
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        
        chart.setModel(PieSemiCircleData.getPieModel());
        
        Chart chartOptional = chart.getChart();
        chartOptional.setPlotBorderWidth(0);
        chartOptional.setPlotShadow(false);
        
        Title title = chart.getTitle();
        title.setText("Acction<br>Plan");
        title.setAlign("center");
        title.setVerticalAlign("middle");
        title.setY(50);
        
        chart.getTooltip().setPointFormat("{series.name}: <b>{point.percentage:.1f}%</b>");
        
        PiePlotOptions poltOptions = chart.getPlotOptions().getPie();
        
        DataLabels dataLabels = poltOptions.getDataLabels();
        dataLabels.setEnabled(true);
        dataLabels.setDistance(-50);
        dataLabels.setStyle("fontWeight: 'bold'; color: 'white'; textShadow: '0px 1px 2px black'");
        poltOptions.setStartAngle(-90);
        poltOptions.setEndAngle(90);
        poltOptions.setCenter("50%", "75%");
        poltOptions.setInnerSize("50%");
        
        chart.getSeries().setName("Browser share");
    }
}
