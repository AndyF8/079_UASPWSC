/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasC2023.uas2023;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author acer
 */
@Entity
@Table(name = "uas")
@NamedQueries({
    @NamedQuery(name = "Uas.findAll", query = "SELECT u FROM Uas u"),
    @NamedQuery(name = "Uas.findById", query = "SELECT u FROM Uas u WHERE u.id = :id"),
    @NamedQuery(name = "Uas.findByName", query = "SELECT u FROM Uas u WHERE u.name = :name"),
    @NamedQuery(name = "Uas.findByAddress", query = "SELECT u FROM Uas u WHERE u.address = :address"),
    @NamedQuery(name = "Uas.findByNik", query = "SELECT u FROM Uas u WHERE u.nik = :nik")})
public class Uas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "NIK")
    private Integer nik;

    public Uas() {
    }

    public Uas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uas)) {
            return false;
        }
        Uas other = (Uas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uasC2023.uas2023.Uas[ id=" + id + " ]";
    }
    
}
