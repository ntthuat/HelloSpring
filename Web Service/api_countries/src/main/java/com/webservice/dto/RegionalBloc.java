package com.webservice.dto;

import java.util.List;

public class RegionalBloc {
    private String acronym;
    private String name;
    private List otherAcronyms;
    private List otherNames;

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getOtherAcronyms() {
        return otherAcronyms;
    }

    public void setOtherAcronyms(List otherAcronyms) {
        this.otherAcronyms = otherAcronyms;
    }

    public List getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List otherNames) {
        this.otherNames = otherNames;
    }
}