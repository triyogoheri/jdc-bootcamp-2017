package com.agit.jdc.bootcamp.main.model.data;

import org.zkoss.chart.Series;
import org.zkoss.chart.model.DefaultXYZModel;
import org.zkoss.chart.model.XYZModel;

/**
 *
 * @author bayutridewanto
 */
public class DataMinMax {

    /* attribut for geting posisi */
    private double minJanuari;
    private double maxJanuari;
    private double minFebruari;
    private double maxFebruari;
    private double minMaret;
    private double maxMaret;
    private double minApril;
    private double maxApril;
    private double minMei;
    private double maxMei;
    private double minJuni;
    private double maxJuni;
    private double minJuli;
    private double maxJuli;
    private double minAgustus;
    private double maxAgustus;
    private double minSeptember;
    private double maxSeptember;
    private double minOktober;
    private double maxOktober;
    private double minNopember;
    private double maxNopember;
    private double minDesember;
    private double maxDesember;

    public DataMinMax() {
    }

    public DataMinMax(double minJanuari, double maxJanuari, double minFebruari, double maxFebruari, double minMaret, double maxMaret, double minApril, double maxApril, double minMei, double maxMei, double minJuni, double maxJuni, double minJuli, double maxJuli, double minAgustus, double maxAgustus, double minSeptember, double maxSeptember, double minOktober, double maxOktober, double minNopember, double maxNopember, double minDesember, double maxDesember) {
        this.minJanuari = minJanuari;
        this.maxJanuari = maxJanuari;
        this.minFebruari = minFebruari;
        this.maxFebruari = maxFebruari;
        this.minMaret = minMaret;
        this.maxMaret = maxMaret;
        this.minApril = minApril;
        this.maxApril = maxApril;
        this.minMei = minMei;
        this.maxMei = maxMei;
        this.minJuni = minJuni;
        this.maxJuni = maxJuni;
        this.minJuli = minJuli;
        this.maxJuli = maxJuli;
        this.minAgustus = minAgustus;
        this.maxAgustus = maxAgustus;
        this.minSeptember = minSeptember;
        this.maxSeptember = maxSeptember;
        this.minOktober = minOktober;
        this.maxOktober = maxOktober;
        this.minNopember = minNopember;
        this.maxNopember = maxNopember;
        this.minDesember = minDesember;
        this.maxDesember = maxDesember;
    }

    public XYZModel getModelMinMax() {
        XYZModel model = new DefaultXYZModel();
        model.addValue("MinMax", getMinJanuari(), getMaxJanuari());
        model.addValue("MinMax", getMinFebruari(), getMaxFebruari());
        model.addValue("MinMax", getMinMaret(), getMaxMaret());
        model.addValue("MinMax", getMinApril(), getMaxApril());
        model.addValue("MinMax", getMinMei(), getMaxMei());
        model.addValue("MinMax", getMinJuni(), getMaxJuni());
        model.addValue("MinMax", getMinJuli(), getMaxJuli());
        model.addValue("MinMax", getMinAgustus(), getMaxAgustus());
        model.addValue("MinMax", getMinSeptember(), getMaxSeptember());
        model.addValue("MinMax", getMinOktober(), getMaxOktober());
        model.addValue("MinMax", getMinNopember(), getMaxNopember());
        model.addValue("MinMax", getMinDesember(), getMaxDesember());
        return model;
    }

    public Series getSeriesMinMax() {
        Series series = new Series();
        series.setName("Min Max");
        series.setType("errorbar");
        series.setColor("red");
        series.setLineWidth(1);
        series.addPoint(getMinJanuari(), getMaxJanuari());
        series.addPoint(getMinFebruari(), getMaxFebruari());
        series.addPoint(getMinMaret(), getMaxMaret());
        series.addPoint(getMinApril(), getMaxApril());
        series.addPoint(getMinMei(), getMaxMei());
        series.addPoint(getMinJuni(), getMaxJuni());
        series.addPoint(getMinJuli(), getMaxJuli());
        series.addPoint(getMinAgustus(), getMaxAgustus());
        series.addPoint(getMinSeptember(), getMaxSeptember());
        series.addPoint(getMinOktober(), getMaxOktober());
        series.addPoint(getMinNopember(), getMaxNopember());
        series.addPoint(getMinDesember(), getMaxDesember());
        series.getPlotOptions().getTooltip().setPointFormat(" (range value : {point.low} - {point.high})<br/>");
        return series;
    }

    public double getMinJanuari() {
        return minJanuari;
    }

    public void setMinJanuari(double minJanuari) {
        this.minJanuari = minJanuari;
    }

    public double getMaxJanuari() {
        return maxJanuari;
    }

    public void setMaxJanuari(double maxJanuari) {
        this.maxJanuari = maxJanuari;
    }

    public double getMinFebruari() {
        return minFebruari;
    }

    public void setMinFebruari(double minFebruari) {
        this.minFebruari = minFebruari;
    }

    public double getMaxFebruari() {
        return maxFebruari;
    }

    public void setMaxFebruari(double maxFebruari) {
        this.maxFebruari = maxFebruari;
    }

    public double getMinMaret() {
        return minMaret;
    }

    public void setMinMaret(double minMaret) {
        this.minMaret = minMaret;
    }

    public double getMaxMaret() {
        return maxMaret;
    }

    public void setMaxMaret(double maxMaret) {
        this.maxMaret = maxMaret;
    }

    public double getMinApril() {
        return minApril;
    }

    public void setMinApril(double minApril) {
        this.minApril = minApril;
    }

    public double getMaxApril() {
        return maxApril;
    }

    public void setMaxApril(double maxApril) {
        this.maxApril = maxApril;
    }

    public double getMinMei() {
        return minMei;
    }

    public void setMinMei(double minMei) {
        this.minMei = minMei;
    }

    public double getMaxMei() {
        return maxMei;
    }

    public void setMaxMei(double maxMei) {
        this.maxMei = maxMei;
    }

    public double getMinJuni() {
        return minJuni;
    }

    public void setMinJuni(double minJuni) {
        this.minJuni = minJuni;
    }

    public double getMaxJuni() {
        return maxJuni;
    }

    public void setMaxJuni(double maxJuni) {
        this.maxJuni = maxJuni;
    }

    public double getMinJuli() {
        return minJuli;
    }

    public void setMinJuli(double minJuli) {
        this.minJuli = minJuli;
    }

    public double getMaxJuli() {
        return maxJuli;
    }

    public void setMaxJuli(double maxJuli) {
        this.maxJuli = maxJuli;
    }

    public double getMinAgustus() {
        return minAgustus;
    }

    public void setMinAgustus(double minAgustus) {
        this.minAgustus = minAgustus;
    }

    public double getMaxAgustus() {
        return maxAgustus;
    }

    public void setMaxAgustus(double maxAgustus) {
        this.maxAgustus = maxAgustus;
    }

    public double getMinSeptember() {
        return minSeptember;
    }

    public void setMinSeptember(double minSeptember) {
        this.minSeptember = minSeptember;
    }

    public double getMaxSeptember() {
        return maxSeptember;
    }

    public void setMaxSeptember(double maxSeptember) {
        this.maxSeptember = maxSeptember;
    }

    public double getMinOktober() {
        return minOktober;
    }

    public void setMinOktober(double minOktober) {
        this.minOktober = minOktober;
    }

    public double getMaxOktober() {
        return maxOktober;
    }

    public void setMaxOktober(double maxOktober) {
        this.maxOktober = maxOktober;
    }

    public double getMinNopember() {
        return minNopember;
    }

    public void setMinNopember(double minNopember) {
        this.minNopember = minNopember;
    }

    public double getMaxNopember() {
        return maxNopember;
    }

    public void setMaxNopember(double maxNopember) {
        this.maxNopember = maxNopember;
    }

    public double getMinDesember() {
        return minDesember;
    }

    public void setMinDesember(double minDesember) {
        this.minDesember = minDesember;
    }

    public double getMaxDesember() {
        return maxDesember;
    }

    public void setMaxDesember(double maxDesember) {
        this.maxDesember = maxDesember;
    }

}
