package com.vineyard.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BugModel implements Serializable {

    private int id;
    private String bug;
    private String bugImage;
    private String bugDescription;
    private String bugSings;
    private String bugPreparation;

    public BugModel() {
    }

    BugModel(int id, String bug, String bugImage, String bugDescription, String bugSings, String bugPreparation) {
        this.id = id;
        this.bug = bug;
        this.bugImage = bugImage;
        this.bugDescription = bugDescription;
        this.bugSings = bugSings;
        this.bugPreparation = bugPreparation;
    }

    public int getId() {
        return id;
    }

    public String getBug() {
        return bug;
    }

    public String getBugImage() {
        return bugImage;
    }

    public String getBugDescription() {
        return bugDescription;
    }

    public String getBugSings() {
        return bugSings;
    }

    public String getBugPreparation() {
        return bugPreparation;
    }

    public static List<BugModel> dataSource(){
        List<BugModel> data = new ArrayList<>();
        data.add(new BugModel(1, "мілдью", "live.staticflickr.com/65535/50434337188_6e8ff109ab_o.png", "Опис мілдью", "Ознаки мілдью", "Методи боротьби мілдью"));
        data.add(new BugModel(2,"мілдью", "live.staticflickr.com/65535/50435030161_aa070bd933_o.png","Опис мілдью", "Ознаки мілдью", "Методи боротьби мілдью"));
        data.add(new BugModel(3, "мілдью","live.staticflickr.com/65535/50435199962_9427bde927_o.png", "Опис мілдью", "Ознаки мілдью", "Методи боротьби мілдью"));
        data.add(new BugModel(4, "оїдіум", "live.staticflickr.com/65535/50434337188_6e8ff109ab_o.png", "Опис мілдью", "Ознаки мілдью", "Методи боротьби мілдью"));
        data.add(new BugModel(5,"оїдіум", "live.staticflickr.com/65535/50435030161_aa070bd933_o.png","Опис мілдью", "Ознаки мілдью", "Методи боротьби мілдью"));
        data.add(new BugModel(6, "оїдіум","live.staticflickr.com/65535/50435199962_9427bde927_o.png", "Опис мілдью", "Ознаки мілдью", "Методи боротьби мілдью"));












        return data;
    }
}
