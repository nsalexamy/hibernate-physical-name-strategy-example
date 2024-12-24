package com.alexamy.example.hibernate.naming.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PharmanetDrug {
    private String din;
    private String genericName;
    private String maximumDailyDosage;
    private String dateDispensed;
    private String directions;
    private String prescriberID;
    private String prescriberLastName;
    private String comment;
    private String quantity;
    private String rxStatus;
    private String ingredientCode;
    private String ingredientName;
    private String interventionCode;
    private String prescriberIDRef;
    private String sameStoreIndicator;
    private String drugDiscontinuedDate;
    private String drugDiscontinuedSource;
    private String practitionerIDRef;
    private String practitionerID;
    private String dateEntered;
}
