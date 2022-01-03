package com.iset.kadhytii;

public class model {
    String name,age,car,image;

    model(){

    }
    public model(String name, String age, String car, String image) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCar() {
        return car;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
