/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 181810115
 */
public class Carro {
    private String marca;
    private String modelo;
    private int anoFab;
    private int anoMod;
    private String cor;
    private String tpCambio;
    private String combustivel;
    private Pessoa proprietario;// Agregação de classe model Pessoa com Carro

    public Carro() {
    }
    
    public Carro(String marca, String modelo, int anoFab, int anoMod, String cor, String tpCambio, String combustivel, Pessoa proprietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.anoMod = anoMod;
        this.cor = cor;
        this.tpCambio = tpCambio;
        this.combustivel = combustivel;
        this.proprietario = proprietario;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFab() {
        return anoFab;
    }

    public int getAnoMod() {
        return anoMod;
    }

    public String getCor() {
        return cor;
    }

    public String getTpCambio() {
        return tpCambio;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    @Override
    public String toString() {
        return "\n----\t" + "\nMarca:\t" + marca + "\nModelo:\t" + modelo 
                + "\nAno Fab:\t" + anoFab + "\nAno Mod\t" + anoMod + "\nCor:\t" + cor 
                + "\nTipo de Cambio:\t" + tpCambio + "\nCombustivel:\t" + combustivel 
                + "\nProprietario:\t" + proprietario + '}';
    }
    
}
