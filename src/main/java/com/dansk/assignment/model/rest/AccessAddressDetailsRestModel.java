package com.dansk.assignment.model.rest;


import lombok.Getter;

@Getter
public class AccessAddressDetailsRestModel {
    private String id;
    private String href;
    private String vejnavn;
    private String husnr;
    private String supplerendebynavn;
    private int postnr;
    private String postnrnavn;
    private String stormodtagerpostnr;
    private String stormodtagerpostnrnavn;
}
