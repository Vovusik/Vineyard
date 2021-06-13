package com.vineyard.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class PreparationDialogModel implements Serializable {

    public PreparationDialogModel() {

    }
    private int id;
    private String shorter;
    private String longer;


    public PreparationDialogModel(int id, String shorter, String longer) {
        this.id = id;
        this.shorter = shorter;
        this.longer = longer;
    }


    public int getId() {
        return id;
    }


    public String getShorter() {
        return shorter;
    }


    public String getLonger() {
        return longer;
    }

//    public static List<PreparationDialogModel> getPreparatyDialog() {
//        List<PreparationDialogModel> preparatyModels = new ArrayList<>();
//
//        preparatyModels.add(new PreparationDialogModel(1, "A", "Gingerbread"));
//        preparatyModels.add(new PreparationDialogModel(2, "B", "Gingerbread"));
//        preparatyModels.add(new PreparationDialogModel(3, "C", "Ice cream Sandwich"));
//        preparatyModels.add(new PreparationDialogModel(4, "D", "Ice cream Sandwich"));
//        preparatyModels.add(new PreparationDialogModel(5, "E", "Jelly Bean"));
//        preparatyModels.add(new PreparationDialogModel(6, "F", "Jelly Bean"));
//
//
//        return preparatyModels;
//    }
}
