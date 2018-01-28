package com.nabil.springboot.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Mahasiswa")
public class Mahasiswa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "nama_mahasiswa")
    private String nama;
    private String jurusan;
    private String nim;

    @Version
    @Column(name = "opt_version", columnDefinition = "integer DEFAULT=0")
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
