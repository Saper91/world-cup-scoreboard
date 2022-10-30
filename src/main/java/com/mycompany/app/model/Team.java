package com.mycompany.app.model;

import com.neovisionaries.i18n.CountryCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Team {
    private String name;
    private CountryCode isoCode;

    public Team(CountryCode isoCode) {
        this.isoCode = isoCode;
        this.setName(isoCode.getName());
    }
}
