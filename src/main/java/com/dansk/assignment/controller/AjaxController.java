package com.dansk.assignment.controller;

import com.dansk.assignment.model.ajax.PointAjaxDTO;
import com.dansk.assignment.service.AjaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/ajax")
public class AjaxController {

    final private
    AjaxService ajaxService;

    @Autowired
    public AjaxController(AjaxService ajaxService) {
        this.ajaxService = ajaxService;
    }


    @GetMapping(value = "/street/auto-complete", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<com.dansk.assignment.model.ajax.StreetNameAutoCompleteAjaxDTO> streetNameAutoComplete(
            @RequestParam("q") String q
    ) {
        return new ResponseEntity<>(ajaxService.streetNameAutoComplete(q), HttpStatus.OK);
    }

    @GetMapping(value = "/street/details", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<java.util.Set<PointAjaxDTO>> streetNameDetails(
            @RequestParam("q") String q
    ) {
        return new ResponseEntity<>(ajaxService.streetNameDetails(q), HttpStatus.OK);
    }

    @GetMapping(value = "/building/details", produces = {"application/json"})
    @ResponseBody
    ResponseEntity<Object> buildingDetails(
            @RequestParam("street-name") String streetName,
            @RequestParam("municipality-code") int municipalityCode
    ) {
        return new ResponseEntity<>(ajaxService.buildingDetails(streetName, municipalityCode), HttpStatus.OK);
    }


}
