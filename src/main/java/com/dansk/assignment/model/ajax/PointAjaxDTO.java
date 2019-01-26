package com.dansk.assignment.model.ajax;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PointAjaxDTO {
    private String text;
    private String code;
    private double lon;
    private double lat;

}
