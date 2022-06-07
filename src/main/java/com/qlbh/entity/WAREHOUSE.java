/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlbh.entity;

/**
 *
 * @author pc
 */
public class WAREHOUSE {
    private String MASP;
    private String TENSP;
    private Double SOLUONG;
    private Double DONGIA;
    private String HINH;
    private String GHICHU;

    public WAREHOUSE() {
    }

    public WAREHOUSE(String MASP, String TENSP, Double SOLUONG, Double DONGIA, String HINH, String GHICHU) {
        this.MASP = MASP;
        this.TENSP = TENSP;
        this.SOLUONG = SOLUONG;
        this.DONGIA = DONGIA;
        this.HINH = HINH;
        this.GHICHU = GHICHU;
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public String getTENSP() {
        return TENSP;
    }

    public void setTENSP(String TENSP) {
        this.TENSP = TENSP;
    }

    public Double getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(Double SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public Double getDONGIA() {
        return DONGIA;
    }

    public void setDONGIA(Double DONGIA) {
        this.DONGIA = DONGIA;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }
    
    
    
    
    
}
