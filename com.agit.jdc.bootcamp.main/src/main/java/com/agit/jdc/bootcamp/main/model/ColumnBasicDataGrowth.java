package com.agit.jdc.bootcamp.main.model;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;

/**
 *
 * @author bayutridewanto
 */
public class ColumnBasicDataGrowth {

    private Double posisi2016;
    private Double posisi2017;

    public ColumnBasicDataGrowth(Double posisi2016, Double posisi2017) {

        this.posisi2016 = posisi2016;
        this.posisi2017 = posisi2017;
    }

    public CategoryModel getCategoryModel() {
        CategoryModel model = new DefaultCategoryModel();
        model.setValue("Posisi", "2016", getPosisi2016());
        model.setValue("Posisi", "2017", getPosisi2017());
        return model;
    }

    public Double getPosisi2016() {
        return posisi2016;
    }

    public void setPosisi2016(Double posisi2016) {
        this.posisi2016 = posisi2016;
    }

    public Double getPosisi2017() {
        return posisi2017;
    }

    public void setPosisi2017(Double posisi2017) {
        this.posisi2017 = posisi2017;
    }

}
