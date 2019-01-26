package com.dansk.assignment.utils;

import com.dansk.assignment.model.rest.AccessAddressRestModel;
import com.dansk.assignment.model.rest.StreetDetailsRestModel;
import com.dansk.assignment.model.rest.StreetNameRestModel;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MakeRequest {

    public StreetNameRestModel[] getStreetNameAutoCompleteRest(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate
                    .getMessageConverters()
                    .add(new MappingJackson2HttpMessageConverter());
            return restTemplate.getForObject(url, StreetNameRestModel[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StreetDetailsRestModel[] getStreetNameDetailsRest(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate
                    .getMessageConverters()
                    .add(new MappingJackson2HttpMessageConverter());
            return restTemplate.getForObject(url, StreetDetailsRestModel[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AccessAddressRestModel[] getBuildingDetailsRest(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate
                    .getMessageConverters()
                    .add(new MappingJackson2HttpMessageConverter());
            return restTemplate.getForObject(url, AccessAddressRestModel[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object getReq(String url, Class res) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate
                    .getMessageConverters()
                    .add(new MappingJackson2HttpMessageConverter());
            return restTemplate.getForObject(url, res);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
