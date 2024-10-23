package com.example.coach.modele;

import junit.framework.TestCase;

public class ProfilTest extends TestCase {

    private Profil profil = new Profil(67,165,35,0);

    private float img = (float) 32.2;

    private String message = "Vous êtes trop élevé";

    public void testGetMessage() {
        assertEquals(img, profil.getImg(), (float) 0.1);
    }

    public void testSetMessage() {
        assertEquals(message, profil.getMessage());
    }
}