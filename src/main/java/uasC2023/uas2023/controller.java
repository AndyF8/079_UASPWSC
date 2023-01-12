/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasC2023.uas2023;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */

@RestController
@CrossOrigin
@RequestMapping("/uas") //membuat request mapping untuk menghubungkan controller dengan html
public class controller {
    
    Uas raes = new Uas();
    UasJpaController rust = new UasJpaController();

    @GetMapping("/{id}") //membuat method get untuk mencari data
    public List<Uas> getNameById(@PathVariable("id") int id) {
        List<Uas> dummy = new ArrayList<>(); // 
        try {
            raes = rust.findUas(id); 
            dummy.add(raes); 
        } catch (Exception e) {
            dummy = List.of(); 
        }
        return dummy;
    }

    @GetMapping
    public List<Uas> getAll() {
        List<Uas> dummy = new ArrayList<>();
        try {
            dummy = rust.findUasEntities();
        } catch (Exception e) {
            dummy = List.of();
        }
        return dummy;
    }

    @PostMapping() //membuat method post untuk menambah data
    public String createData(HttpEntity<String> paket) {
        String message = "";

        try {
            String json_receive = paket.getBody();

            ObjectMapper map = new ObjectMapper();

            Uas ras02 = new Uas();

            ras02 = map.readValue(json_receive, Uas.class);

            rust.create(ras02);
            message = ras02.getName() + " berhasil Tersimpan"; //membuat message tersimpan apablia data berhasil disimpan

        } catch (Exception e) {
            message = "Gagal disimpan"; //membuat message gagal tersimpan apablia data gagal disimpan
        }

        return message;
    }

    @PutMapping()
    public String editData(HttpEntity<String> kiriman) {
        String message = "gagal"; //membuat message gagal diedit apablia data gagal diubah
        try {
            String json_receive = kiriman.getBody();
            ObjectMapper mapper = new ObjectMapper();

            Uas nras03 = new Uas();

            nras03 = mapper.readValue(json_receive, Uas.class);
            rust.edit(nras03);
            message = nras03.getName() + " berhasil diupdate"; //membuat message berhasil diedit apablia data berhasil diubah
        } catch (Exception e) {
        }
        return message;
    }

    @DeleteMapping()
    public String deleteData(HttpEntity<String> kiriman) {
        String message = "gagal"; //membuat message gagal dihapus apablia data gagal dihapus
        try {
            String json_receive = kiriman.getBody();
            ObjectMapper mapper = new ObjectMapper();

            Uas nras04 = new Uas();

            nras04 = mapper.readValue(json_receive, Uas.class);
            rust.destroy(nras04.getId());

            message = "berhasil dihapus"; //membuat message berhasil dihapus apablia data berhasil fihapus
        } catch (Exception e) {
        }
        return message;
    }
    
}
