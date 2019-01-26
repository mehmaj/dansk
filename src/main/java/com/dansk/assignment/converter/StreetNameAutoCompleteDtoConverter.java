package com.dansk.assignment.converter;

import com.dansk.assignment.model.ajax.StreetNameAutoCompleteAjaxDTO;
import com.dansk.assignment.model.rest.StreetNameRestModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class StreetNameAutoCompleteDtoConverter implements Converter<StreetNameRestModel[], StreetNameAutoCompleteAjaxDTO> {
    @Override
    public StreetNameAutoCompleteAjaxDTO convert(StreetNameRestModel[] streetNameRestModels) {
        Set<String> temp = new HashSet<>();
        for (StreetNameRestModel a : streetNameRestModels
                ) {
            temp.add(a.getTekst());
        }
        return new StreetNameAutoCompleteAjaxDTO(temp);
    }
}
