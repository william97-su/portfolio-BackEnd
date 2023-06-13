package com.portfolio.wmg.Security.Controller;

public class Mensaje {

    private String mensage;

    //Constructor
    public Mensaje() {
    }

    public Mensaje(String mensage) {
        this.mensage = mensage;
    }
    //Getter & Setter

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

}
