package com.agit.jdc.main.viewmodel.combo.charts;

/**
 *
 * @author bayutridewanto
 */
public class ComboChartData {

    private String[] categories;
    private Number[] posisi, growth;

    private Double posisiJanuari;
    private Double posisiFebruari;
    private Double posisiMaret;
    private Double posisiApril;
    private Double posisiMei;
    private Double posisiJuni;
    private Double posisiJuli;
    private Double posisiAgustus;
    private Double posisiSeptember;
    private Double posisiOktober;
    private Double posisiNovember;
    private Double posisiDesember;

    private Double growthJanuari;
    private Double growthFebruari;
    private Double growthMaret;
    private Double growthApril;
    private Double growthMei;
    private Double growthJuni;
    private Double growthJuli;
    private Double growthAgustus;
    private Double growthSeptember;
    private Double growthOktober;
    private Double growthNovember;
    private Double growthDesember;

    public ComboChartData(String[] categories, Number[] posisi, Number[] growth, Double posisiJanuari, Double posisiFebruari, Double posisiMaret, Double posisiApril, Double posisiMei, Double posisiJuni, Double posisiJuli, Double posisiAgustus, Double posisiSeptember, Double posisiOktober, Double posisiNovember, Double posisiDesember, Double growthJanuari, Double growthFebruari, Double growthMaret, Double growthApril, Double growthMei, Double growthJuni, Double growthJuli, Double growthAgustus, Double growthSeptember, Double growthOktober, Double growthNovember, Double growthDesember) {
        this.categories = categories;
        this.posisi = posisi;
        this.growth = growth;
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
        this.posisiNovember = posisiNovember;
        this.posisiDesember = posisiDesember;
        this.growthJanuari = growthJanuari;
        this.growthFebruari = growthFebruari;
        this.growthMaret = growthMaret;
        this.growthApril = growthApril;
        this.growthMei = growthMei;
        this.growthJuni = growthJuni;
        this.growthJuli = growthJuli;
        this.growthAgustus = growthAgustus;
        this.growthSeptember = growthSeptember;
        this.growthOktober = growthOktober;
        this.growthNovember = growthNovember;
        this.growthDesember = growthDesember;
    }

    public String[] getChartsCategory() {
        categories = new String[]{
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
        };
        return categories;
    }

    public Number[] getChartsGrowth() {
        growth = new Double[]{
            getGrowthJanuari(), getGrowthFebruari(), getGrowthMaret(), getGrowthApril(),
            getGrowthMei(), getGrowthJuni(), getGrowthJuli(), getGrowthAgustus(),
            getGrowthSeptember(), getGrowthOktober(), getGrowthNovember(), getGrowthDesember()};
        return growth;
    }

    public Number[] getChartsPosisi() {
        posisi = new Double[]{
            getPosisiJanuari(), getPosisiFebruari(), getPosisiMaret(), getPosisiApril(),
            getPosisiMei(), getPosisiJuni(), getPosisiJuli(), getPosisiAgustus(),
            getPosisiSeptember(), getPosisiOktober(), getPosisiNovember(), getPosisiDesember()};
        return posisi;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public Number[] getPosisi() {
        return posisi;
    }

    public void setPosisi(Number[] posisi) {
        this.posisi = posisi;
    }

    public Number[] getGrowth() {
        return growth;
    }

    public void setGrowth(Number[] growth) {
        this.growth = growth;
    }

    public Double getPosisiJanuari() {
        return posisiJanuari;
    }

    public void setPosisiJanuari(Double posisiJanuari) {
        this.posisiJanuari = posisiJanuari;
    }

    public Double getPosisiFebruari() {
        return posisiFebruari;
    }

    public void setPosisiFebruari(Double posisiFebruari) {
        this.posisiFebruari = posisiFebruari;
    }

    public Double getPosisiMaret() {
        return posisiMaret;
    }

    public void setPosisiMaret(Double posisiMaret) {
        this.posisiMaret = posisiMaret;
    }

    public Double getPosisiApril() {
        return posisiApril;
    }

    public void setPosisiApril(Double posisiApril) {
        this.posisiApril = posisiApril;
    }

    public Double getPosisiMei() {
        return posisiMei;
    }

    public void setPosisiMei(Double posisiMei) {
        this.posisiMei = posisiMei;
    }

    public Double getPosisiJuni() {
        return posisiJuni;
    }

    public void setPosisiJuni(Double posisiJuni) {
        this.posisiJuni = posisiJuni;
    }

    public Double getPosisiJuli() {
        return posisiJuli;
    }

    public void setPosisiJuli(Double posisiJuli) {
        this.posisiJuli = posisiJuli;
    }

    public Double getPosisiAgustus() {
        return posisiAgustus;
    }

    public void setPosisiAgustus(Double posisiAgustus) {
        this.posisiAgustus = posisiAgustus;
    }

    public Double getPosisiSeptember() {
        return posisiSeptember;
    }

    public void setPosisiSeptember(Double posisiSeptember) {
        this.posisiSeptember = posisiSeptember;
    }

    public Double getPosisiOktober() {
        return posisiOktober;
    }

    public void setPosisiOktober(Double posisiOktober) {
        this.posisiOktober = posisiOktober;
    }

    public Double getPosisiNovember() {
        return posisiNovember;
    }

    public void setPosisiNovember(Double posisiNovember) {
        this.posisiNovember = posisiNovember;
    }

    public Double getPosisiDesember() {
        return posisiDesember;
    }

    public void setPosisiDesember(Double posisiDesember) {
        this.posisiDesember = posisiDesember;
    }

    public Double getGrowthJanuari() {
        return growthJanuari;
    }

    public void setGrowthJanuari(Double growthJanuari) {
        this.growthJanuari = growthJanuari;
    }

    public Double getGrowthFebruari() {
        return growthFebruari;
    }

    public void setGrowthFebruari(Double growthFebruari) {
        this.growthFebruari = growthFebruari;
    }

    public Double getGrowthMaret() {
        return growthMaret;
    }

    public void setGrowthMaret(Double growthMaret) {
        this.growthMaret = growthMaret;
    }

    public Double getGrowthApril() {
        return growthApril;
    }

    public void setGrowthApril(Double growthApril) {
        this.growthApril = growthApril;
    }

    public Double getGrowthMei() {
        return growthMei;
    }

    public void setGrowthMei(Double growthMei) {
        this.growthMei = growthMei;
    }

    public Double getGrowthJuni() {
        return growthJuni;
    }

    public void setGrowthJuni(Double growthJuni) {
        this.growthJuni = growthJuni;
    }

    public Double getGrowthJuli() {
        return growthJuli;
    }

    public void setGrowthJuli(Double growthJuli) {
        this.growthJuli = growthJuli;
    }

    public Double getGrowthAgustus() {
        return growthAgustus;
    }

    public void setGrowthAgustus(Double growthAgustus) {
        this.growthAgustus = growthAgustus;
    }

    public Double getGrowthSeptember() {
        return growthSeptember;
    }

    public void setGrowthSeptember(Double growthSeptember) {
        this.growthSeptember = growthSeptember;
    }

    public Double getGrowthOktober() {
        return growthOktober;
    }

    public void setGrowthOktober(Double growthOktober) {
        this.growthOktober = growthOktober;
    }

    public Double getGrowthNovember() {
        return growthNovember;
    }

    public void setGrowthNovember(Double growthNovember) {
        this.growthNovember = growthNovember;
    }

    public Double getGrowthDesember() {
        return growthDesember;
    }

    public void setGrowthDesember(Double growthDesember) {
        this.growthDesember = growthDesember;
    }

}
