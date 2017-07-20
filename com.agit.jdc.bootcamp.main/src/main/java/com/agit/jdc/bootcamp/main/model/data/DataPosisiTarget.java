package com.agit.jdc.bootcamp.main.model.data;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;

/**
 *
 * @author bayutridewanto
 */
public class DataPosisiTarget {

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

    /* attribut for geting target */
    private double targetJanuari;
    private double targetFebruari;
    private double targetMaret;
    private double targetApril;
    private double targetMei;
    private double targetJuni;
    private double targetJuli;
    private double targetAgustus;
    private double targetSeptember;
    private double targetOktober;
    private double targetNopember;
    private double targetDesember;

    public DataPosisiTarget(double posisiJanuari, double posisiFebruari, double posisiMaret, double posisiApril, double posisiMei, double posisiJuni, double posisiJuli, double posisiAgustus, double posisiSeptember, double posisiOktober, double posisiNopember, double posisiDesember, double targetJanuari, double targetFebruari, double targetMaret, double targetApril, double targetMei, double targetJuni, double targetJuli, double targetAgustus, double targetSeptember, double targetOktober, double targetNopember, double targetDesember) {
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
        this.targetJanuari = targetJanuari;
        this.targetFebruari = targetFebruari;
        this.targetMaret = targetMaret;
        this.targetApril = targetApril;
        this.targetMei = targetMei;
        this.targetJuni = targetJuni;
        this.targetJuli = targetJuli;
        this.targetAgustus = targetAgustus;
        this.targetSeptember = targetSeptember;
        this.targetOktober = targetOktober;
        this.targetNopember = targetNopember;
        this.targetDesember = targetDesember;
    }

    public CategoryModel getModelPosisiTarget() {
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
        model.setValue("Target", "Jan", getTargetJanuari());
        model.setValue("Target", "Feb", getTargetFebruari());
        model.setValue("Target", "Mar", getTargetMaret());
        model.setValue("Target", "Apr", getTargetApril());
        model.setValue("Target", "May", getTargetMei());
        model.setValue("Target", "Jun", getTargetJuni());
        model.setValue("Target", "Jul", getTargetJuli());
        model.setValue("Target", "Aug", getTargetAgustus());
        model.setValue("Target", "Sep", getTargetSeptember());
        model.setValue("Target", "Oct", getTargetOktober());
        model.setValue("Target", "Nov", getTargetNopember());
        model.setValue("Target", "Dec", getTargetDesember());
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

    public double getTargetJanuari() {
        return targetJanuari;
    }

    public void setTargetJanuari(double targetJanuari) {
        this.targetJanuari = targetJanuari;
    }

    public double getTargetFebruari() {
        return targetFebruari;
    }

    public void setTargetFebruari(double targetFebruari) {
        this.targetFebruari = targetFebruari;
    }

    public double getTargetMaret() {
        return targetMaret;
    }

    public void setTargetMaret(double targetMaret) {
        this.targetMaret = targetMaret;
    }

    public double getTargetApril() {
        return targetApril;
    }

    public void setTargetApril(double targetApril) {
        this.targetApril = targetApril;
    }

    public double getTargetMei() {
        return targetMei;
    }

    public void setTargetMei(double targetMei) {
        this.targetMei = targetMei;
    }

    public double getTargetJuni() {
        return targetJuni;
    }

    public void setTargetJuni(double targetJuni) {
        this.targetJuni = targetJuni;
    }

    public double getTargetJuli() {
        return targetJuli;
    }

    public void setTargetJuli(double targetJuli) {
        this.targetJuli = targetJuli;
    }

    public double getTargetAgustus() {
        return targetAgustus;
    }

    public void setTargetAgustus(double targetAgustus) {
        this.targetAgustus = targetAgustus;
    }

    public double getTargetSeptember() {
        return targetSeptember;
    }

    public void setTargetSeptember(double targetSeptember) {
        this.targetSeptember = targetSeptember;
    }

    public double getTargetOktober() {
        return targetOktober;
    }

    public void setTargetOktober(double targetOktober) {
        this.targetOktober = targetOktober;
    }

    public double getTargetNopember() {
        return targetNopember;
    }

    public void setTargetNopember(double targetNopember) {
        this.targetNopember = targetNopember;
    }

    public double getTargetDesember() {
        return targetDesember;
    }

    public void setTargetDesember(double targetDesember) {
        this.targetDesember = targetDesember;
    }

}
