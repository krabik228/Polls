package com.rschir.kursach.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getOtv1() {
        return otv1;
    }

    public void setOtv1(String otv1) {
        this.otv1 = otv1;
    }

    public String getOtv2() {
        return otv2;
    }

    public void setOtv2(String otv2) {
        this.otv2 = otv2;
    }

    private String title, text, otv1, otv2;
    private int stats1, stats2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStats1() {
        return stats1;
    }

    public void setStats1(int stats1) {
        this.stats1 = stats1;
    }

    public int getStats2() {
        return stats2;
    }

    public void setStats2(int stats2) {
        this.stats2 = stats2;
    }

    public Opros() {
    }

    public Opros(String title, String text, String otv1, String otv2) {
        this.title = title;
        this.text = text;
        this.otv1 = otv1;
        this.otv2 = otv2;
    }
}
