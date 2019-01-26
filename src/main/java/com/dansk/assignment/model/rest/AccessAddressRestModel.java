package com.dansk.assignment.model.rest;

import lombok.Getter;

@Getter
public class AccessAddressRestModel {
    private String id;
    private String kvh;
    private AccessPointResModel adgangspunkt;
    private BuildingPostCode postnummer;
}
