package org.scrabble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MotSurPlateauTest {
    private Tuile tuileD;
    private Tuile tuileR;
    private Tuile tuileI;
    private Tuile tuileV;
    private Tuile tuileE;
    private Tuile tuileN;
    private MotSurPlateau motSurPlateau;

    @BeforeEach
    void setUp() {
        // given des tuiles permettant de compose un mot
        tuileD = new Tuile('D',2);
        tuileR = new Tuile('R', 1);
        tuileI = new Tuile('I', 1);
        tuileV = new Tuile('V', 4);
        tuileE = new Tuile('E', 1);
        tuileN = new Tuile('N', 1);
        // and un mot pret à être initialisé
        motSurPlateau = new MotSurPlateau();
    }

    @Test
    void calculeScore_MotSansLettrePrimee() {
        // given: un mot sans lettre primée
        motSurPlateau.addTuileToMot(tuileD);
        motSurPlateau.addTuileToMot(tuileR);
        motSurPlateau.addTuileToMot(tuileI);
        motSurPlateau.addTuileToMot(tuileV);
        motSurPlateau.addTuileToMot(tuileE);
        motSurPlateau.addTuileToMot(tuileN);
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient la somme des points de chaque lettre
        assertEquals(10,res);
    }

    @Test
    void calculeScore_MotAvecLettresDoubles() {
        // given: un mot avec lettre primée double
        motSurPlateau.addTuileToMot(tuileD);
        motSurPlateau.addTuileToMot(tuileR, Prime.LETTRE_DOUBLE);
        motSurPlateau.addTuileToMot(tuileI);
        motSurPlateau.addTuileToMot(tuileV, Prime.LETTRE_DOUBLE);
        motSurPlateau.addTuileToMot(tuileE);
        motSurPlateau.addTuileToMot(tuileN);
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient le score attendu
        assertEquals(15,res);
    }

    @Test
    void calculeScore_MotAvecLettresTriples() {
        // given: un mot avec lettres primées triple
        motSurPlateau.addTuileToMot(tuileD);
        motSurPlateau.addTuileToMot(tuileR, Prime.LETTRE_TRIPLE);
        motSurPlateau.addTuileToMot(tuileI);
        motSurPlateau.addTuileToMot(tuileV, Prime.LETTRE_TRIPLE);
        motSurPlateau.addTuileToMot(tuileE);
        motSurPlateau.addTuileToMot(tuileN);
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient le score attendu
        assertEquals(20,res);
    }

    @Test
    void calculeScore_MotAvecLettresDoublesEtTriples() {
        // given: un mot avec lettres primées triples et doubles
        motSurPlateau.addTuileToMot(tuileD, Prime.LETTRE_DOUBLE);
        motSurPlateau.addTuileToMot(tuileR, Prime.LETTRE_TRIPLE);
        motSurPlateau.addTuileToMot(tuileI);
        motSurPlateau.addTuileToMot(tuileV, Prime.LETTRE_TRIPLE);
        motSurPlateau.addTuileToMot(tuileE, Prime.LETTRE_DOUBLE);
        motSurPlateau.addTuileToMot(tuileN);
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient le score attendu
        assertEquals(23,res);
    }

    @Test
    void calculeScore_MotAvecMotDouble() {
        // given: un mot avec lettres primées mot double
        motSurPlateau.addTuileToMot(tuileD);
        motSurPlateau.addTuileToMot(tuileR, Prime.MOT_DOUBLE);
        motSurPlateau.addTuileToMot(tuileI);
        motSurPlateau.addTuileToMot(tuileV, Prime.MOT_DOUBLE);
        motSurPlateau.addTuileToMot(tuileE);
        motSurPlateau.addTuileToMot(tuileN);
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient le score attendu
        assertEquals(40,res);
    }

    @Test
    void calculeScore_MotAvecMotTriple() {
        // given: un mot avec lettres primées mot triple
        motSurPlateau.addTuileToMot(tuileD);
        motSurPlateau.addTuileToMot(tuileR, Prime.MOT_TRIPLE);
        motSurPlateau.addTuileToMot(tuileI);
        motSurPlateau.addTuileToMot(tuileV, Prime.MOT_TRIPLE);
        motSurPlateau.addTuileToMot(tuileE);
        motSurPlateau.addTuileToMot(tuileN);
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient le score attendu
        assertEquals(90,res);
    }

    @Test
    void calculeScore_MotAvecMixTotal() {
        // given: un mot avec lettres primées variées
        motSurPlateau.addTuileToMot(tuileD, Prime.LETTRE_DOUBLE);
        motSurPlateau.addTuileToMot(tuileR, Prime.MOT_DOUBLE);
        motSurPlateau.addTuileToMot(tuileI);
        motSurPlateau.addTuileToMot(tuileV, Prime.MOT_TRIPLE);
        motSurPlateau.addTuileToMot(tuileE, Prime.LETTRE_DOUBLE);
        motSurPlateau.addTuileToMot(tuileN);
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient le score attendu
        assertEquals(78,res);
    }

    @Test
    void calculeScore_MotVide() {
        // given: un mot vide
        // when: on calcule le score
        int res = motSurPlateau.calculeScore();
        // then: on obtient le score attendu
        assertEquals(0,res);
    }

}