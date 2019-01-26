package com.dansk.assignment.model.rest;

import lombok.Getter;

import java.util.List;

@Getter
public class MunicipalityDetailsRestModel {
    private String navn;
    private String kode;
    private List<Double> visueltcenter;
}
