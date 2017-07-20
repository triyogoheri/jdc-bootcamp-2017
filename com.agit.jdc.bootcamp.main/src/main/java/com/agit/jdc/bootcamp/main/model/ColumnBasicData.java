package com.agit.jdc.bootcamp.main.model;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.ChartsModel;
import org.zkoss.chart.model.DefaultCategoryModel;

/**
 *
 * @author bayutridewanto
 */
public class ColumnBasicData {

    /* attribut for geting posisi */
    private double posisiJanuari;
    private double posisiFebruari;
    private double posisiMaret;
    private double posisiApril;
    private double posisiMei;
    private double posisiJuni;
    private double posisiJuli;
    private double posisiAgustus;
    private double posisiSeptember;
    private double posisiOktober;
    private double posisiNopember;
    private double posisiDesember;

    public ColumnBasicData(double posisiJanuari, double posisiFebruari, double posisiMaret, double posisiApril, double posisiMei, double posisiJuni, double posisiJuli, double posisiAgustus, double posisiSeptember, double posisiOktober, double posisiNopember, double posisiDesember) {
        this.posisiJanuari = posisiJanuari;
        this.posisiFebruari = posisiFebruari;
        this.posisiMaret = posisiMaret;
        this.posisiApril = posisiApril;
        this.posisiMei = posisiMei;
        this.posisiJuni = posisiJuni;
        this.posisiJuli = posisiJuli;
        this.posisiAgustus = posisiAgustus;
        this.posisiSeptember = posisiSeptember;
        this.posisiOktober = posisiOktober;
        this.posisiNopember = posisiNopember;
        this.posisiDesember = posisiDesember;
    }

    public CategoryModel getCategoryModel() {
        CategoryModel model = new DefaultCategoryModel();
        model.setValue("Posisi", "Jan", getPosisiJanuari());
        model.setValue("Posisi", "Feb", getPosisiFebruari());
        model.setValue("Posisi", "Mar", getPosisiMaret());
        model.setValue("Posisi", "Apr", getPosisiApril());
        model.setValue("Posisi", "May", getPosisiMei());
        model.setValue("Posisi", "Jun", getPosisiJuni());
        model.setValue("Posisi", "Jul", getPosisiJuli());
        model.setValue("Posisi", "Aug", getPosisiAgustus());
        model.setValue("Posisi", "Sep", getPosisiSeptember());
        model.setValue("Posisi", "Oct", getPosisiOktober());
        model.setValue("Posisi", "Nov", getPosisiNopember());
        model.setValue("Posisi", "Dec", getPosisiDesember());
        return model;
    }

    public double getPosisiJanuari() {
        return posisiJanuari;
    }

    public void setPosisiJanuari(double posisiJanuari) {
        this.posisiJanuari = posisiJanuari;
    }

    public double getPosisiFebruari() {
        return posisiFebruari;
    }

    public void setPosisiFebruari(double posisiFebruari) {
        this.posisiFebruari = posisiFebruari;
    }

    public double getPosisiMaret() {
        return posisiMaret;
    }

    public void setPosisiMaret(double posisiMaret) {
        this.posisiMaret = posisiMaret;
    }

    public double getPosisiApril() {
        return posisiApril;
    }

    public void setPosisiApril(double posisiApril) {
        this.posisiApril = posisiApril;
    }

    public double getPosisiMei() {
        return posisiMei;
    }

    public void setPosisiMei(double posisiMei) {
        this.posisiMei = posisiMei;
    }

    public double getPosisiJuni() {
        return posisiJuni;
    }

    public void setPosisiJuni(double posisiJuni) {
        this.posisiJuni = posisiJuni;
    }

    public double getPosisiJuli() {
        return posisiJuli;
    }

    public void setPosisiJuli(double posisiJuli) {
        this.posisiJuli = posisiJuli;
    }

    public double getPosisiAgustus() {
        return posisiAgustus;
    }

    public void setPosisiAgustus(double posisiAgustus) {
        this.posisiAgustus = posisiAgustus;
    }

    public double getPosisiSeptember() {
        return posisiSeptember;
    }

    public void setPosisiSeptember(double posisiSeptember) {
        this.posisiSeptember = posisiSeptember;
    }

    public double getPosisiOktober() {
        return posisiOktober;
    }

    public void setPosisiOktober(double posisiOktober) {
        this.posisiOktober = posisiOktober;
    }

    public double getPosisiNopember() {
        return posisiNopember;
    }

    public void setPosisiNopember(double posisiNopember) {
        this.posisiNopember = posisiNopember;
    }

    public double getPosisiDesember() {
        return posisiDesember;
    }

    public void setPosisiDesember(double posisiDesember) {
        this.posisiDesember = posisiDesember;
    }

}
