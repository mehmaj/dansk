package com.dansk.assignment.converter;

import com.dansk.assignment.model.ajax.PointAjaxDTO;
import com.dansk.assignment.model.rest.MunicipalityDetailsRestModel;
import com.dansk.assignment.model.rest.MunicipalityRestModel;
import com.dansk.assignment.model.rest.StreetDetailsRestModel;
import com.dansk.assignment.utils.MakeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StreetNameDetailsDtoConverter implements Converter<StreetDetailsRestModel[], Set<PointAjaxDTO>> {
    final private
    MakeRequest makeRequest;

    @Autowired
    public StreetNameDetailsDtoConverter(MakeRequest makeRequest) {
        this.makeRequest = makeRequest;
    }

    @Override
    public Set<PointAjaxDTO> convert(StreetDetailsRestModel[] fromList) {
        Set<PointAjaxDTO> tmp = new HashSet<>();
        for (MunicipalityRestModel m : fromList[0].getKommuner()) {
            try {
                MunicipalityDetailsRestModel mdr = (MunicipalityDetailsRestModel) makeRequest.getReq(m.getHref(), MunicipalityDetailsRestModel.class);
                tmp.add(new PointAjaxDTO(m.getNavn(), m.getKode(), mdr.getVisueltcenter().get(0), mdr.getVisueltcenter().get(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return tmp;
    }
}
