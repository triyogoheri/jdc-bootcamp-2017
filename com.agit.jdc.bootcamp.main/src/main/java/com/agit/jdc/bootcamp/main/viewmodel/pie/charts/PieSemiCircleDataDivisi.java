package com.agit.jdc.main.viewmodel.pie.charts;

/**
 *
 * @author bayutridewanto
 */
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;

public class PieSemiCircleDataDivisi {

    private static final PieModel model;

    static {
        model = new DefaultPieModel();
        model.setValue("DKI JAKARTA", 45.0);
        model.setValue("Jawa Barat", 20.8);
        model.setValue("Jawa Tengah", 12.8);
        model.setValue("Jawa Timur", 8.5);
        model.setValue("DIY Yogyakarta", 8.2);
        model.setValue("Sumatera Barat", 8.0);
        model.setValue("Sumatera Selatan", 7.0);
        model.setValue("Others", 4.7);
    }

    public static PieModel getPieModel() {
        return model;
    }
}
