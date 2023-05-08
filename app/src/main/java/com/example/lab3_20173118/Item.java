package com.example.lab3_20173118;

public class Item {

    private int image;
    private String name;
    private String gen;
    private String person;
    private String dni;
    private String description;
    private String ruta;


    public Item(String name, String gen, int image, String person, String dni, String description, String ruta) {
        this.setName(name);
        this.setGen(gen);
        this.setImage(image);
        this.setPerson(person);
        this.setDni(dni);
        this.setDescription(description);
        this.setRuta(ruta);
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
