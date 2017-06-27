package com.lubao.forbackend.domain;

import java.io.Serializable;

import org.springframework.stereotype.Service;
@Service
public class MedMsg implements Serializable{
    private String medId;
    private String medName;
    private  String medName_f;
    private  String medNmae_p;
    private  String medStruct;
    private  String medDet;
    private  String medUnit;
    private  String medClass;
    private  String med_before;
    private  String medDate;
    private  String medPositionSeq;
    private  String img;
    private String medJuice;
    public String getMedId() {
        return medId;
    }
    public void setMedId(String medId) {
        this.medId = medId;
    }
    public String getMedName() {
        return medName;
    }
    public void setMedName(String medName) {
        this.medName = medName;
    }
    public String getMedName_f() {
        return medName_f;
    }
    public void setMedName_f(String medName_f) {
        this.medName_f = medName_f;
    }
    public String getMedNmae_p() {
        return medNmae_p;
    }
    public void setMedNmae_p(String medNmae_p) {
        this.medNmae_p = medNmae_p;
    }
    public String getMedStruct() {
        return medStruct;
    }
    public void setMedStruct(String medStruct) {
        this.medStruct = medStruct;
    }
    public String getMedDet() {
        return medDet;
    }
    public void setMedDet(String medDet) {
        this.medDet = medDet;
    }
    public String getMedUnit() {
        return medUnit;
    }
    public void setMedUnit(String medUnit) {
        this.medUnit = medUnit;
    }
    public String getMedClass() {
        return medClass;
    }
    public void setMedClass(String medClass) {
        this.medClass = medClass;
    }
    public String getMed_before() {
        return med_before;
    }
    public void setMed_before(String med_before) {
        this.med_before = med_before;
    }
    public String getMedDate() {
        return medDate;
    }
    public void setMedDate(String medDate) {
        this.medDate = medDate;
    }
    public String getMedPositionSeq() {
        return medPositionSeq;
    }
    public void setMedPositionSeq(String medPositionSeq) {
        this.medPositionSeq = medPositionSeq;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getMedJuice() {
        return medJuice;
    }
    public void setMedJuice(String medJuice) {
        this.medJuice = medJuice;
    }
}
