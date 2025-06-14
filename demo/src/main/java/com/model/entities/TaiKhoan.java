package com.model.entities;

public class TaiKhoan {
    private String idtk;
    private String username;
    private String password;
    private String idnv;
    private String vaiTro;

    public TaiKhoan() {}

    public TaiKhoan(String idtk, String username, String password, String idnv, String vaiTro) {
        this.idtk = idtk;
        this.username = username;
        this.password = password;
        this.idnv = idnv;
        this.vaiTro = vaiTro;
    }

    public String getIdtk() { return idtk; }
    public void setIdtk(String idtk) { this.idtk = idtk; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getIdnv() { return idnv; }
    public void setIdnv(String idnv) { this.idnv = idnv; }
    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }
}
