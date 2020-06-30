package com.rwapp.interviewapp.models;

/**
 * Purpose: Parse UnitApi response
 */
public class PageWrapper {

    UnitPage page;

    public PageWrapper(UnitPage unitPage) {
        this.page = unitPage;
    }

    public UnitPage getUnitPage() {
        return page;
    }
}
