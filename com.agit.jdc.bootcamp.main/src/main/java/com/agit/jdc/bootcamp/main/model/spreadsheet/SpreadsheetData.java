package com.agit.jdc.bootcamp.main.model.spreadsheet;

/**
 *
 * @author bayutridewanto
 */
import java.util.ArrayList;
import java.util.List;

public class SpreadsheetData {

    private final List<Year> years = new ArrayList<Year>();

    public SpreadsheetData() {
        years.add(new Year(2014));
    }

    public List<Year> getYears() {
        return years;
    }

    public List<Month> getMonths() {
        List<Month> allMonths = new ArrayList<Month>();

        for (Year yr : getYears()) {
            for (Quarter q : yr.getQuarters()) {
                allMonths.addAll(q.getMonths());
            }
        }

        return allMonths;
    }
}
