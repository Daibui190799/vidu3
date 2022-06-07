/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlbh.entity;

import java.util.Date;

/**
 *
 * @author pc
 */
public class DELIVERY extends QLNV{
    private String MAVanChuyen;
    private Date NgVanchuyen;
    private String TINHTRANG;

    public DELIVERY() {
    }

    public DELIVERY(String MAVanChuyen, Date NgVanchuyen, String TINHTRANG) {
        this.MAVanChuyen = MAVanChuyen;
        this.NgVanchuyen = NgVanchuyen;
        this.TINHTRANG = TINHTRANG;
    }

    public DELIVERY(String MAVanChuyen, Date NgVanchuyen, String TINHTRANG, String MANV, String HOTENNV, boolean GIOITINH, String SDT, String DIACHI, boolean VAITRO, String HINH, String STORY, Double LUONG, String MATKHAU) {
        super(MANV, HOTENNV, GIOITINH, SDT, DIACHI, VAITRO, HINH, STORY, LUONG, MATKHAU);
        this.MAVanChuyen = MAVanChuyen;
        this.NgVanchuyen = NgVanchuyen;
        this.TINHTRANG = TINHTRANG;
    }

    public String getMAVanChuyen() {
        return MAVanChuyen;
    }

    public void setMAVanChuyen(String MAVanChuyen) {
        this.MAVanChuyen = MAVanChuyen;
    }

    public Date getNgVanchuyen() {
        return NgVanchuyen;
    }

    public void setNgVanchuyen(Date NgVanchuyen) {
        this.NgVanchuyen = NgVanchuyen;
    }

    public String getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }
   
}
