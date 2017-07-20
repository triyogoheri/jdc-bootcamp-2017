package com.agit.jdc.bootcamp.main.model.data;

import org.zkoss.chart.Series;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;

/**
 *
 * @author bayutridewanto
 */
public class DataAkumulasi {

    /* attribut for geting posisi */
    private double akumulasiJanuari;
    private double akumulasiFebruari;
    private double akumulasiMaret;
    private double akumulasiApril;
    private double akumulasiMei;
    private double akumulasiJuni;
    private double akumulasiJuli;
    private double akumulasiAgustus;
    private double akumulasiSeptember;
    private double akumulasiOktober;
    private double akumulasiNopember;
    private double akumulasiDesember;

    public DataAkumulasi() {
    }

    public DataAkumulasi(double akumulasiJanuari, double akumulasiFebruari, double akumulasiMaret, double akumulasiApril, double akumulasiMei, double akumulasiJuni, double akumulasiJuli, double akumulasiAgustus, double akumulasiSeptember, double akumulasiOktober, double akumulasiNopember, double akumulasiDesember) {
        this.akumulasiJanuari = akumulasiJanuari;
        this.akumulasiFebruari = akumulasiFebruari;
        this.akumulasiMaret = akumulasiMaret;
        this.akumulasiApril = akumulasiApril;
        this.akumulasiMei = akumulasiMei;
        this.akumulasiJuni = akumulasiJuni;
        this.akumulasiJuli = akumulasiJuli;
        this.akumulasiAgustus = akumulasiAgustus;
        this.akumulasiSeptember = akumulasiSeptember;
        this.akumulasiOktober = akumulasiOktober;
        this.akumulasiNopember = akumulasiNopember;
        this.akumulasiDesember = akumulasiDesember;
    }

    public CategoryModel getModelPersenAkumulasi() {
        CategoryModel model = new DefaultCategoryModel();
        model.setValue("% Akumulasi", "Jan", getAkumulasiJanuari());
        model.setValue("% Akumulasi", "Feb", getAkumulasiFebruari());
        model.setValue("% Akumulasi", "Mar", getAkumulasiMaret());
        model.setValue("% Akumulasi", "Apr", getAkumulasiApril());
        model.setValue("% Akumulasi", "May", getAkumulasiMei());
        model.setValue("% Akumulasi", "Jun", getAkumulasiJuni());
        model.setValue("% Akumulasi", "Jul", getAkumulasiJuli());
        model.setValue("% Akumulasi", "Aug", getAkumulasiAgustus());
        model.setValue("% Akumulasi", "Sep", getAkumulasiSeptember());
        model.setValue("% Akumulasi", "Oct", getAkumulasiOktober());
        model.setValue("% Akumulasi", "Nov", getAkumulasiNopember());
        model.setValue("% Akumulasi", "Dec", getAkumulasiDesember());
        return model;
    }

    public Series getSeriesAkumulasi() {
        Series series = new Series();
        series.setName("% Akumulasi ");
        series.setType("spline");
        series.setData(
                getAkumulasiJanuari(),
                getAkumulasiFebruari(),
                getAkumulasiMaret(),
                getAkumulasiApril(),
                getAkumulasiMei(),
                getAkumulasiJuni(),
                getAkumulasiJuli(),
                getAkumulasiAgustus(),
                getAkumulasiSeptember(),
                getAkumulasiOktober(),
                getAkumulasiNopember(),
                getAkumulasiDesember());
        series.getPlotOptions().getTooltip().setPointFormat("<span style=\"font-weight: bold;"
                + "color: {series.color}\">{series.name}</span>: <b>{point.y:.1f} %</b>");
        return series;
    }

    public double getAkumulasiJanuari() {
        return akumulasiJanuari;
    }

    public void setAkumulasiJanuari(double akumulasiJanuari) {
        this.akumulasiJanuari = akumulasiJanuari;
    }

    public double getAkumulasiFebruari() {
        return akumulasiFebruari;
    }

    public void setAkumulasiFebruari(double akumulasiFebruari) {
        this.akumulasiFebruari = akumulasiFebruari;
    }

    public double getAkumulasiMaret() {
        return akumulasiMaret;
    }

    public void setAkumulasiMaret(double akumulasiMaret) {
        this.akumulasiMaret = akumulasiMaret;
    }

    public double getAkumulasiApril() {
        return akumulasiApril;
    }

    public void setAkumulasiApril(double akumulasiApril) {
        this.akumulasiApril = akumulasiApril;
    }

    public double getAkumulasiMei() {
        return akumulasiMei;
    }

    public void setAkumulasiMei(double akumulasiMei) {
        this.akumulasiMei = akumulasiMei;
    }

    public double getAkumulasiJuni() {
        return akumulasiJuni;
    }

    public void setAkumulasiJuni(double akumulasiJuni) {
        this.akumulasiJuni = akumulasiJuni;
    }

    public double getAkumulasiJuli() {
        return akumulasiJuli;
    }

    public void setAkumulasiJuli(double akumulasiJuli) {
        this.akumulasiJuli = akumulasiJuli;
    }

    public double getAkumulasiAgustus() {
        return akumulasiAgustus;
    }

    public void setAkumulasiAgustus(double akumulasiAgustus) {
        this.akumulasiAgustus = akumulasiAgustus;
    }

    public double getAkumulasiSeptember() {
        return akumulasiSeptember;
    }

    public void setAkumulasiSeptember(double akumulasiSeptember) {
        this.akumulasiSeptember = akumulasiSeptember;
    }

    public double getAkumulasiOktober() {
        return akumulasiOktober;
    }

    public void setAkumulasiOktober(double akumulasiOktober) {
        this.akumulasiOktober = akumulasiOktober;
    }

    public double getAkumulasiNopember() {
        return akumulasiNopember;
    }

    public void setAkumulasiNopember(double akumulasiNopember) {
        this.akumulasiNopember = akumulasiNopember;
    }

    public double getAkumulasiDesember() {
        return akumulasiDesember;
    }

    public void setAkumulasiDesember(double akumulasiDesember) {
        this.akumulasiDesember = akumulasiDesember;
    }

}
