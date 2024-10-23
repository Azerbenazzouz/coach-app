package com.example.coach.modele;

public class Profil {

    private static final Integer minFemme = 15;
    private static final Integer maxFemme = 30;
    private static final Integer minHomme = 10;
    private static final Integer maxHomme = 25;

    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public void setSexe(Integer sexe) {
        this.sexe = sexe;
    }

    public float getImg() {
        return img;
    }

    public void setImg(float img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void calculIMG(){
        float tailleM = (float) taille / 100;
        this.img = (float) (1.2 * poids / (tailleM * tailleM) +( 0.23 * age) - (10.83 * sexe) - 5.4);
    }

    private void resultIMG(){
        Integer min;
        Integer max;
        if(sexe == 1){
            min = minHomme;
            max = maxHomme;
        }else{
            min = minFemme;
            max = maxFemme;
        }

        message = "Vous êtes en normal";
        if(img < min){
            message = "Vous êtes trop faible";
        }else {
            if(img > max){
                message = "Vous êtes trop élevé";
            }
        }
    }
}
