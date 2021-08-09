/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PICHAU
 */
public class URL {
    private int id;
    private int id_usuario;
    private String url_original;
    private String url_gerada;
    private String data_gerada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUrl_original() {
        return url_original;
    }

    public void setUrl_original(String url_original) {
        this.url_original = url_original;
    }

    public String getUrl_gerada() {
        return url_gerada;
    }

    public void setUrl_gerada(String url_gerada) {
        this.url_gerada = url_gerada;
    }

    public String getData_gerada() {
        return data_gerada;
    }

    public void setData_gerada(String data_gerada) {
        this.data_gerada = data_gerada;
    }

    public URL(int id, int id_usuario, String url_original, String url_gerada, String data_gerada) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.url_original = url_original;
        this.url_gerada = url_gerada;
        this.data_gerada = data_gerada;
    }
    
    
}
