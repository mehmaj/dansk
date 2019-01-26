package com.dansk.assignment.converter;

import com.dansk.assignment.model.ajax.PointAjaxDTO;
import com.dansk.assignment.model.rest.AccessAddressRestModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BuildingDetailsDtoConverter implements Converter<AccessAddressRestModel[], Set<PointAjaxDTO>> {
    @Override
    public Set<PointAjaxDTO> convert(AccessAddressRestModel[] fromList) {
        Set<PointAjaxDTO> tmp = new HashSet<>();
        for (AccessAddressRestModel m : fromList) {
            try {
                tmp.add(new PointAjaxDTO(m.getPostnummer().getNavn(), m.getKvh(), m.getAdgangspunkt().getKoordinater().get(0), m.getAdgangspunkt().getKoordinater().get(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return tmp;
    }
}
