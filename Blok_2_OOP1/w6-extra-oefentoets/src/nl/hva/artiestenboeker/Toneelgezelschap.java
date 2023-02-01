package nl.hva.artiestenboeker;

import java.util.ArrayList;

/**
 * Sub-Klasse van Artiest. Bevat alle informatie van een toneelgezelschap.
 *
 * @see Artiest
 * @author timknops
 */
public class Toneelgezelschap extends Artiest {

    private String naam;
    private int jaarOprichting;
    private ArrayList<Acteur> acteurs;

    /**
     * Constructor.
     *
     * @param genre           genre van de toneelgezelschap
     * @param naam            naam van de toneelgezelschap
     * @param jaarOprichting  jaar dat de toneelgezelschap is opgericht
     */
    public Toneelgezelschap(String genre, String naam, int jaarOprichting) {
        super(genre);
        this.naam = naam;
        this.jaarOprichting = jaarOprichting;
        this.acteurs = new ArrayList<>();
    }

    /**
     * Voegt een acteur toe aan de toneelgezelschap.
     *
     * @param acteur  acteur die moet worden toegevoegd
     */
    public void voegActeurToe(Acteur acteur) {
        acteurs.add(acteur);
    }

    /** Returns het jaar dat de toneelgezelschap is opgericht */
    public int getJaarOprichting() {
        return jaarOprichting;
    }

    /** Returns naam van de toneelgezelschap */
    @Override
    public String krijgNaam() {
        return naam;
    }

    /** Returns string waarde van de toneelgezelschap */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s(%s), aantal boekingen: %d, oprichtingsjaar: %d\n  Acteurs: ",
                krijgNaam(), getGenre(), krijgAantalBoekingen(), jaarOprichting));

        for (Acteur acteur : acteurs) {
            sb.append(acteur).append(" ");
        }

        return sb.toString();
    }
}
