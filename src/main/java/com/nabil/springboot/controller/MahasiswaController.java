package com.nabil.springboot.controller;

import com.nabil.springboot.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.nabil.springboot.service.MahasiswaService;

@Controller
public class MahasiswaController {

    private final String username = System.getProperty("user.name");

    @RequestMapping("/")
    public String home(ModelMap mm) {
        mm.put("yourPC", this.username);
        return "home";
    }

    private MahasiswaService mservice;

    @Autowired
    public void setMservice(MahasiswaService mservice) {
        this.mservice = mservice;
    }

    @RequestMapping("/mahasiswa")
    public String MahasiswaList(Model model) {
        model.addAttribute("getAllMahasiswa", mservice.listMahasiswa());
        return "mahasiswa"; //Menampilkan Semua Data
    }

    @RequestMapping(value = "/mahasiswa/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model) {
        model.addAttribute("showFormMahasiswa", new Mahasiswa());
        return "formMahasiswa"; //Menampilkan Form Tambah Data
    }

    @RequestMapping(value = "/mahasiswa/create", method = RequestMethod.POST)
    public String simpanDataMahasiswa(Model model, Mahasiswa mahasiswa) {
        mservice.saveOrUpdate(mahasiswa);
        return "redirect:/mahasiswa"; //Simpan Data
    }

    @RequestMapping(value = "/mahasiswa/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model) {
        model.addAttribute("showFormMahasiswa", mservice.getIdMahasiswa(id));
        return "formMahasiswa"; //Ubah Data
    }

    @RequestMapping(value = "/mahasiswa/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        mservice.hapus(id); //Menhapus Data
        return "redirect:/mahasiswa";
    }
}
