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
public class RECEIPT {
    private String MAKH;
    private String MAVanChuyen;
    private String MASP;
    private Double SOLUONG;
    private String GHICHU;

    public RECEIPT() {
    }

    public RECEIPT(String MAKH, String MAVanChuyen, String MASP, Double SOLUONG, String GHICHU) {
        this.MAKH = MAKH;
        this.MAVanChuyen = MAVanChuyen;
        this.MASP = MASP;
        this.SOLUONG = SOLUONG;
        this.GHICHU = GHICHU;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getMAVanChuyen() {
        return MAVanChuyen;
    }

    public void setMAVanChuyen(String MAVanChuyen) {
        this.MAVanChuyen = MAVanChuyen;
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public Double getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(Double SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }
    
    
}
