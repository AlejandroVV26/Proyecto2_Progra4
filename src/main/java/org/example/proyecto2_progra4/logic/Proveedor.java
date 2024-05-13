package org.example.proyecto2_progra4.logic;

import java.util.Objects;

public class Proveedor {
    String id;
    String name;
    String lastName;
    String phone;
    String email;
    Usuario user;

    public Proveedor() {
        this.id="";
        this.name="";
        this.lastName="";
        this.phone="";
        this.email="";
        this.user = new Usuario();
    }

    public Proveedor(String id, String name, String lastName, String phone, String email, Usuario user) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.user=user;
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
