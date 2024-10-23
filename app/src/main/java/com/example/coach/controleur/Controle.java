package com.example.coach.controleur;

import com.example.coach.modele.Profil;

public final class Controle {
    private static Controle instance = null;
    private Profil profil;

    private Controle(){
        super();
    }

    public static final Controle getInstance(){
        if(Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * Crée un profil avec les valeurs renseignées
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 0 pour homme, 1 pour femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){
        this.profil = new Profil(poids,taille,age,sexe);
    }

    /**
     * Retourne l'image calculée
     * @return
     */
    public float getImg(){
        return this.profil.getImg();
    }

    /**
     * Retourne le message calculé
     * @return
     */
    public String getMessage(){
        return this.profil.getMessage();
    }
}
