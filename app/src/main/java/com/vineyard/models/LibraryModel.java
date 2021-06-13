package com.vineyard.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LibraryModel implements Serializable {

    private int id;
    private String image;
    private String title;
    private String author;
    private String link;

    public LibraryModel() {

    }

    public LibraryModel(int id, String image, String title, String author, String link) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.author = author;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }


    public static List<LibraryModel> getLibrary() {

        List<LibraryModel> listLibrary = new ArrayList<>();

        listLibrary.add(new LibraryModel(
                1, "https://live.staticflickr.com/65535/50435435093_1e8d0062cb.jpg", "Книга 1", "Автор 1", "https://storage.googleapis.com/db_sommelier/%D0%92%D0%B8%D0%BD%D0%BE%D0%B4%D0%B5%D0%BB%D0%B8%D0%B5.pdf"));
        listLibrary.add(new LibraryModel(
                2, "https://live.staticflickr.com/65535/50436127251_58ffea5d72.jpg","Книга 2", "Автор 2",  "https://storage.googleapis.com/db_sommelier/%D0%92%D0%B8%D0%BD%D0%BE%D0%B3%D1%80%D0%B0%D0%B4.%20%D0%92.%D0%A2.%20%D0%93%D0%B0%D0%BB%D1%83%D1%89%D0%B5%D0%BD%D0%BA%D0%BE.%202004.pdf"));
        listLibrary.add(new LibraryModel(
                3, "https://live.staticflickr.com/65535/50435435213_23ac35146b.jpg","Книга 3", "Автор 3",  "https://storage.googleapis.com/db_sommelier/MindOrks_Android_Online_Professional_Course-Syllabus.pdf"));

        return listLibrary;
    }
}
