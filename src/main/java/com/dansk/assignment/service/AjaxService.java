package com.dansk.assignment.service;

import com.dansk.assignment.converter.BuildingDetailsDtoConverter;
import com.dansk.assignment.converter.StreetNameAutoCompleteDtoConverter;
import com.dansk.assignment.converter.StreetNameDetailsDtoConverter;
import com.dansk.assignment.model.ajax.PointAjaxDTO;
import com.dansk.assignment.model.ajax.StreetNameAutoCompleteAjaxDTO;
import com.dansk.assignment.model.rest.AccessAddressRestModel;
import com.dansk.assignment.model.rest.StreetDetailsRestModel;
import com.dansk.assignment.model.rest.StreetNameRestModel;
import com.dansk.assignment.utils.MakeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AjaxService {

    final private
    MakeRequest makeRequest;
    final private
    Environment environment;
    final private
    StreetNameAutoCompleteDtoConverter streetNameAutoCompleteDtoConverter;
    final private StreetNameDetailsDtoConverter streetNameDetailsDtoConverter;
    final private BuildingDetailsDtoConverter buildingDetailsDtoConverter;

    @Autowired
    public AjaxService(MakeRequest makeRequest, Environment environment, StreetNameAutoCompleteDtoConverter streetNameAutoCompleteDtoConverter, StreetNameDetailsDtoConverter streetNameDetailsDtoConverter, BuildingDetailsDtoConverter buildingDetailsDtoConverter) {
        this.makeRequest = makeRequest;
        this.environment = environment;
        this.streetNameAutoCompleteDtoConverter = streetNameAutoCompleteDtoConverter;
        this.streetNameDetailsDtoConverter = streetNameDetailsDtoConverter;
        this.buildingDetailsDtoConverter = buildingDetailsDtoConverter;
    }

    @Cacheable(value = "mapCache")
    public StreetNameAutoCompleteAjaxDTO streetNameAutoComplete(String q) {
        StreetNameRestModel[] list = makeRequest.getStreetNameAutoCompleteRest(String.format(environment.getProperty("config.street.name.autocomplete.url"), q));
        return streetNameAutoCompleteDtoConverter.convert(list);
    }

    @Cacheable(value = "mapCache")
    public Set<PointAjaxDTO> streetNameDetails(String q) {
        StreetDetailsRestModel[] streetDetailsRestModel = makeRequest.getStreetNameDetailsRest(String.format(environment.getProperty("config.street.name.details.url"), q));
        return streetNameDetailsDtoConverter.convert(streetDetailsRestModel);
    }


    @Cacheable(value = "mapCache")
    public Object buildingDetails(String streetName, int municipalityCode) {
        AccessAddressRestModel[] accessAddressRestModels = makeRequest.getBuildingDetailsRest(String.format(environment.getProperty("config.building.search.url"), streetName, municipalityCode));
        return buildingDetailsDtoConverter.convert(accessAddressRestModels);
    }
}
