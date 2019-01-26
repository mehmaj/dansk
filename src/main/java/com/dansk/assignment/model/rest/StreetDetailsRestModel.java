package com.dansk.assignment.model.rest;

import lombok.Getter;

import java.util.List;

@Getter
public class StreetDetailsRestModel {
    private String navn;
    private List<MunicipalityRestModel> kommuner;
}
