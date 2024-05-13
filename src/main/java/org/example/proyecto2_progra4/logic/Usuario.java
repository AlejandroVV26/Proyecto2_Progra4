package org.example.proyecto2_progra4.logic;

import java.util.Objects;

public class Usuario {
    String id;
    String password;
    String type; // ADMIN O PROVEEDOR
    boolean access;

    public Usuario() {
        this.id="";
        this.password="";
        this.type="";
        this.access=false;
    }

    public Usuario(String id, String password, String type) {
        this.id = id;
        this.password = password;
        this.type = type;
        this.access = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
