package org.example.proyecto2_progra4.logic;

import java.util.Objects;

public class Cliente {
    String id;
    String name;
    String lastName;
    String phone;
    String email;
    String address;
    String type; // FISICO O JURIDICO

    public Cliente() {
        this.id="";
        this.name="";
        this.lastName="";
        this.phone="";
        this.email="";
        this.address="";
        this.type="";
    }

    public Cliente(String id, String name, String lastName, String phone, String email, String address, String type) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.type=type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
