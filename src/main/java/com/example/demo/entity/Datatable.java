package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "datatable")
public class Datatable {

    @Id
    private ObjectId id;
    private long econimic;
    private long keyfield;
    private String Name;
    private String Region;
    private Timestamp Date;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public long getEconimic() {
        return econimic;
    }

    public void setEconimic(long econimic) {
        this.econimic = econimic;
    }

    public long getKeyfield() {
        return keyfield;
    }

    public void setKeyfield(long keyfield) {
        this.keyfield = keyfield;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(Timestamp date) {
        Date = date;
    }
}
