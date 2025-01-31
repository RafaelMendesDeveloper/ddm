package com.example.contador.taco;

public class Alimento {
    private String nome;
    private float energia;

    public Alimento(String nome, float energia) {
        this.nome = nome;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public float getEnergia() {
        return energia;
    }
}

