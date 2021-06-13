package com.vineyard.models;

import java.io.Serializable;

public class StructureModel implements Serializable {

    private int id;
    private String photoStructure;
    private String descriptionStructure;
    private String structure;

    public StructureModel() {
    }

    public StructureModel(int id, String photoStructure, String descriptionStructure, String structure) {
        this.id = id;
        this.photoStructure = photoStructure;
        this.descriptionStructure = descriptionStructure;
        this.structure = structure;
    }

    public int getId() {
        return id;
    }

    public String getPhotoStructure() {
        return photoStructure;
    }

    public String getDescriptionStructure() {
        return descriptionStructure;
    }

    public String getStructure() {
        return structure;
    }
}

