package at.fhtw.disys.samples.presentationModels;

import java.io.Serializable;

/**
 * Every instance represents the basic information about a person.
 */
public class Person implements Serializable, Comparable<Person> {
    // Attributes
    private int nr;
    private String vorname;
    private String nachname;
    private int alter;

    // Constructors
    public Person() {
        nr = 0;
        alter = 0;
    }

    public Person(int nr, String vorname, String nachname, int alter) {
        this.nr = nr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
    }

    // Getters- & Setters
    public int getNr() {
        return nr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) { this.alter = alter; }

    // Methods
    public String name() {
        return nachname + " " + vorname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nr=" + nr +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", alter=" + alter +
                '}';
    }

    // from Comparable<Person>
    @Override
    public int compareTo(Person that) {
        return this.alter - that.alter;
    }
}
