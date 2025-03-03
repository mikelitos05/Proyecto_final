package edu.proyectofinal.data;

public abstract class User {
    protected String name;
    protected int age;
    protected int activeLend;

    //agrego activelend y modifico la forma en la que id se maneja

    /**
     * Metodo constructor de User
     * @param name Nombre del usuario
     * @param age Edad del usuario
     * @param activeLend Numero de préstamos activos.
     */
    public User(String name,int age, int activeLend) {
        this.name = name;
        this.age = age;
        this.activeLend = activeLend;
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
            throw new IllegalArgumentException("Error en la edad");
        }else {
            this.age = age;
        }
    }

    /**
     * Obtiene el número de préstamos activos.
     * @return Número de préstamos activos.
     */
    public int getActiveLend() {
        return activeLend;
    }

    /**
     * Establece el número de préstamos activos.
     * @param activeLend Número de préstamos activos.
     */
    public void setActiveLend(int activeLend) {
        this.activeLend = activeLend;
    }

    /**
     * Obtiene el máximo de préstamos permitidos para el usuario.
     * @return Máximo de préstamos.
     */
    public abstract int getMaxLoans();

    /**
     * Obtiene la duración del préstamo en días.
     * @return Duración en días.
     */
    public abstract int getLoanDurationDays();

    /**
     * Obtiene el tipo de usuario (Jr, Teen, Adult, VIP).
     * @return Tipo de usuario.
     */
    public abstract String getUserType();

}
