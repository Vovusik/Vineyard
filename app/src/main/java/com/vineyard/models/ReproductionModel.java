package com.vineyard.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReproductionModel implements Serializable {

    private int id;
    private String reproductionTitle;
    private String reproductionDescription;
    private String reproductionImage;

    public ReproductionModel() {
    }

    public ReproductionModel(int id, String reproductionTitle, String reproductionDescription, String reproductionImage) {
        this.id = id;
        this.reproductionTitle = reproductionTitle;
        this.reproductionDescription = reproductionDescription;
        this.reproductionImage = reproductionImage;
    }

    public int getId() {
        return id;
    }

    public String getReproductionTitle() {
        return reproductionTitle;
    }

    public String getReproductionDescription() {
        return reproductionDescription;
    }

    public String getReproductionImage() {
        return reproductionImage;
    }

    public static ArrayList<ReproductionModel> getMildiu() {

        ArrayList<ReproductionModel> places = new ArrayList<>();

        places.add(new ReproductionModel(1, "Монако", "В Столице суверенного княжества Монако живет больше миллионеров, чем настройщиков роялей", "http://media.globalchampionstour.com/cache/750x429/assets/monaco_2016.jpg"));
        places.add(new ReproductionModel(2, "Прага", "Культурная столица восточной европы - город, который хорош в любое время года", "http://www.pragueczechtravel.com/images/prague_banner.jpg"));


        return places;
    }


}
