/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nabil.springboot.service;

import com.nabil.springboot.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author Xyraclius
 */
public interface MahasiswaService {

    List<Mahasiswa> listMahasiswa();

    Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);

    Mahasiswa getIdMahasiswa(Integer id);
    
    void hapus(Integer id);
}
