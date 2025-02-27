package edu.proyectofinal.data;

public class User {



    private int id;
    private String name;
    private int age;


    /**
     * Metodo constructor de User
     * @param name nombre del usuario
     */
    public User(int id,String name,int age) {
        this.name = name;
        this.age = age;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 140){
            throw new IllegalArgumentException("La edad no puede ser menor que 0 o mayor que 140");
        }else {
            this.age = age;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
