package com.pharmacy.entities;

public enum CategoryEnum {
    OINTMENT("Ointment"),
    AEROSOL("Aerosol"),
    INTRAVENOUS("Intravenous"),
    EYEDROPS("Eyedrops"),
    SPRAY("Spray"),
    ORAL("Oral medicine");

    private String displayName;

    CategoryEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
