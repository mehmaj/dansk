package com.dansk.assignment.model.ajax;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StreetNameAutoCompleteAjaxDTO {
    private Set<String> textList;
}
