package com.vineyard.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PreparationModel implements Serializable {

    private int id;
    private String preparation;
    private String spektr_dii;
    private String virobnyk;
    private String kratnist;
    private String strok;
    private String rechovina;

    public String type;
    public String[] data;

    public PreparationModel(String type) {
        this.type = type;
        data = null;
    }

    public PreparationModel() {
    }

    public PreparationModel(String preparat,
                            String spektr_dii,
                            String virobnyk,
                            String kratnist,
                            String strok,
                            String rechovina) {
        this.type = null;
        data = new String[]{
                preparat,
                spektr_dii,
                virobnyk,
                kratnist,
                strok,
                rechovina};
    }

    public int getId() {
        return id;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getRechovina() {
        return rechovina;
    }

    public void setRechovina(String rechovina) {
        this.rechovina = rechovina;
    }

    public String getVirobnyk() {
        return virobnyk;
    }

    public void setVirobnyk(String virobnyk) {
        this.virobnyk = virobnyk;
    }

    public String getSpektr_dii() {
        return spektr_dii;
    }

    public void setSpektr_dii(String spektr_dii) {
        this.spektr_dii = spektr_dii;
    }

    public String getKratnist() {
        return kratnist;
    }

    public void setKratnist(String kratnist) {
        this.kratnist = kratnist;
    }

    public String getStrok() {
        return strok;
    }

    public void setStrok(String strok) {
        this.strok = strok;
    }

    public boolean isSection() {
        return data == null;
    }

    public static List<PreparationModel> getPreparaty() {

        List<PreparationModel> preparatyModels = new ArrayList<>();


        preparatyModels.add(new PreparationModel("Делан", "М","Basf",  "3", "30", "дитіанон"));
        preparatyModels.add(new PreparationModel("Полірам ДФ", "М", "Basf", "2", "30", "метирам"));
        preparatyModels.add(new PreparationModel("Кумулюс ДФ", "О","Basf",  "2", "30", "сірка"));
        preparatyModels.add(new PreparationModel("Орвего", "М","Basf",  "3", "30", "аметоктрадин, диметоморф"));
        preparatyModels.add(new PreparationModel("Стробі", "О, М","Basf",  "3", "50", "крезоксим-метил"));
        preparatyModels.add(new PreparationModel("Акробат МЦ", "М","Basf",  "3", "30", "диметоморф, манкоцеб"));


        preparatyModels.add(new PreparationModel("Делан", "М","Basf",  "3", "30", "дитіанон"));
        preparatyModels.add(new PreparationModel("Полірам ДФ", "М", "Basf", "2", "30", "метирам"));
        preparatyModels.add(new PreparationModel("Кумулюс ДФ", "О","Basf",  "2", "30", "сірка"));
        preparatyModels.add(new PreparationModel("Орвего", "М","Basf",  "3", "30", "аметоктрадин, диметоморф"));
        preparatyModels.add(new PreparationModel("Стробі", "О, М","Basf",  "3", "50", "крезоксим-метил"));
        preparatyModels.add(new PreparationModel("Акробат МЦ", "М","Basf",  "3", "30", "диметоморф, манкоцеб"));
        preparatyModels.add(new PreparationModel("Делан", "М","Basf",  "3", "30", "дитіанон"));
        preparatyModels.add(new PreparationModel("Полірам ДФ", "М", "Basf", "2", "30", "метирам"));
        preparatyModels.add(new PreparationModel("Кумулюс ДФ", "О","Basf",  "2", "30", "сірка"));
        preparatyModels.add(new PreparationModel("Орвего", "М","Basf",  "3", "30", "аметоктрадин, диметоморф"));
        preparatyModels.add(new PreparationModel("Стробі", "О, М","Basf",  "3", "50", "крезоксим-метил"));
        preparatyModels.add(new PreparationModel("Акробат МЦ", "М","Basf",  "3", "30", "диметоморф, манкоцеб"));
        preparatyModels.add(new PreparationModel("Делан", "М","Basf",  "3", "30", "дитіанон"));
        preparatyModels.add(new PreparationModel("Полірам ДФ", "М", "Basf", "2", "30", "метирам"));
        preparatyModels.add(new PreparationModel("Кумулюс ДФ", "О","Basf",  "2", "30", "сірка"));
        preparatyModels.add(new PreparationModel("Орвего", "М","Basf",  "3", "30", "аметоктрадин, диметоморф"));
        preparatyModels.add(new PreparationModel("Стробі", "О, М","Basf",  "3", "50", "крезоксим-метил"));
        preparatyModels.add(new PreparationModel("Акробат МЦ", "М","Basf",  "3", "30", "диметоморф, манкоцеб"));












//        preparatyModels.add(new PreparatyModel("Колліс", "О", "Basf",  "3", "50","крезоксим-метил, боскалід"));
//        preparatyModels.add(new PreparatyModel("Кабріо Топ", "О, М, А", "Basf",  "3", "30","пiраклостробiн, метирам"));
//        preparatyModels.add(new PreparatyModel("Акробат Топ", "М","дитіанон, диметоморф", "Basf",  "3", "30"));
//
//
//        preparatyModels.add(new PreparatyModel("Топаз", "О","пенконазол", "Syngenta",  "4", "20"));
//        preparatyModels.add(new PreparatyModel("Діналі (новий)", "О, ЧГ, КР","дифеноконазол, цифлуфенамід", "Syngenta",  "3", "30"));
//        preparatyModels.add(new PreparatyModel("Дітан М-45", "М","манкоцеб", "Syngenta",  "5", "30"));
//        preparatyModels.add(new PreparatyModel("Ридоміл Голд", "М","манкоцеб, металаксил-М", "Syngenta",  "3", "25"));
//        preparatyModels.add(new PreparatyModel("Пергадо R (новий)", "М, А","мандіпропамід, оксихлорид міді", "Syngenta",  "3", "30"));
//        preparatyModels.add(new PreparatyModel("Тіовіт Джет", "О, ПК","сірка вододисперсна", "Syngenta",  "4", "30"));
//        preparatyModels.add(new PreparatyModel("Квадріс", "М, О, СГ, ЧП, А","азоксистробін", "Syngenta",  "3", "25"));
//        preparatyModels.add(new PreparatyModel("Світч", "Г, М","ципродиніл, флудиоксоніл", "Syngenta",  "1-2", "7"));
//        preparatyModels.add(new PreparatyModel("Хорус", "М, О, СГ", "ципродиніл", "Syngenta", "3", "7"));
//        preparatyModels.add(new PreparatyModel("Натіво", "О, К, СГ", "трифлоксістробін", "Bayer", "2", "20"));
//        preparatyModels.add(new PreparatyModel("Мелоді Дуо", "М","пробінеб, іпровалікарб", "Bayer",  "2", "50"));
//        preparatyModels.add(new PreparatyModel("Фалькон", "О", "тебуконазол, тридеаменол, спіроксамін", "Bayer", "4", "30"));
//        preparatyModels.add(new PreparatyModel("Флінт Стар", "О, СГ","трифлоксістробін, піриметаніл", "Bayer",  "3", "20"));
//        preparatyModels.add(new PreparatyModel("Пасадобль", "М","флуопіколід, пропінеб", "Bayer",  "3", "50"));
//        preparatyModels.add(new PreparatyModel("Тельдор", "СГ","фенгексамід", "Bayer",  "4", "15"));
//        preparatyModels.add(new PreparatyModel("Антракол", "ЧП, М, А","пропінеб", "Bayer",  "3", "50"));
//        preparatyModels.add(new PreparatyModel("Наутіл", "М","цимоксаніл", "Bayer",  "2", "30"));
//        preparatyModels.add(new PreparatyModel("Блу Бордо", "М","сульфат міді", "Bayer",  "4", "30"));
//        preparatyModels.add(new PreparatyModel("Скала", "СГ", "піриметаніл", "Bayer", "3", "30"));
//        preparatyModels.add(new PreparatyModel("Танос", "М","цимоксаніл, фамоксадон", "Dupont",  "3", "30"));
//        preparatyModels.add(new PreparatyModel("Талендо", "О","проквіназид", "Dupont",  "3", "30"));
//        preparatyModels.add(new PreparatyModel("Талендо Екстра", "О","проквіназид, тетраконазол", "Dupont",  "3", "30"));
//        preparatyModels.add(new PreparatyModel("Курзат М", "М","цимоксаніл, манкоцеб", "Dupont",  "3", "30"));
//        preparatyModels.add(new PreparatyModel("Косайд 2000", "М","гідроксид міді", "Dupont",  "3", "30"));
//
//
//        preparatyModels.add(new PreparatyModel("Масаї", "К","тебуфенпірад", "Basf",  "2", "30"));
//        preparatyModels.add(new PreparatyModel("Номолт", "ГЛ","тефлубензурон", "Basf",  "2", "30"));
//        preparatyModels.add(new PreparatyModel("Воліам Флексі", "ВЛ, СК, СО", "тіаметоксам, хлорантраніліпрол", "Syngenta", "2", "35"));
//        preparatyModels.add(new PreparatyModel("Матч", "ГЛ", "люфенурон", "Syngenta", "3", "30"));
//        preparatyModels.add(new PreparatyModel("Люфокс", "ГЛ","феноксикарб, люфенурон", "Syngenta",  "2", "30"));
//        preparatyModels.add(new PreparatyModel("Карате Зеон", "ВЛ, КВ", "лямбда-цигалотрин", "Syngenta", "2", "20"));
//        preparatyModels.add(new PreparatyModel("Дурсбан", "ВЛ, КЛ, П","хлорпірифос", "Syngenta",  "2", "40"));
//        preparatyModels.add(new PreparatyModel("Проклейм", "ГЛ", "емамектин бензоату", "Syngenta", "2", "14"));
//        preparatyModels.add(new PreparatyModel("Енжіо", "ЛФ, Т, СК","тіаметоксам, лямбда-цигалотрин", "Syngenta",  "2", "20"));
//        preparatyModels.add(new PreparatyModel("Актеллік", "ЛФ", "піриміфос–метилу", "Syngenta", "2", "0"));
//        preparatyModels.add(new PreparatyModel("Децис f-Люкс", "ВЛ","дельтаметрин", "Bayer",  "2", "20"));
//
//
//        preparatyModels.add(new PreparatyModel("Ураган Форте", "Б","калійної солі гліфосату", "Syngenta",  "0", "0"));
//        preparatyModels.add(new PreparatyModel("Фюзілад Форте", "З, Б","флуазифоп–П–бутилу", "Syngenta",  "1", "0"));
//        preparatyModels.add(new PreparatyModel("Реглон Форте", "Б","дикват іону", "Syngenta",  "2", "0"));
//        preparatyModels.add(new PreparatyModel("Люмакс", "Б","метолахлор, тербутилазин, мезотріон", "Syngenta",  "2", "0"));
//        preparatyModels.add(new PreparatyModel("Баста", "Б","глюфосинат амонію", "Bayer",  "2", "0"));
//
//
//        preparatyModels.add(new PreparatyModel("Ізабіон", "ПП","амінокислота, пептид", "Syngenta",  "3", "0"));
//
//
//        preparatyModels.add(new PreparatyModel("Мовенто", "Ц, Т, Ф, Ч","спіротетрамат", "Bayer",  "2", "0"));


        return preparatyModels;
    }
}