package com.jqmovie.jqmovie.db.Entities;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 17.04.2018.
 */

/**
 * Entity model for Director
 */

@IgnoreExtraProperties
public class Director {
    @Exclude
    private String directorid ;

    private String Firstname;
    private String Lastname;
    private String Birthdate;
    private String Biography ;
    private String Picture;

    public Director(String directorid, String firstname, String lastname, String birthdate, String biography, String picture) {
        this.directorid = directorid;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.Birthdate = birthdate;
        this.Biography = biography;
        this.Picture = picture;
    }
    public Director(){

    }

    @Exclude
    public String getDirectorid() {
        return directorid;
    }

    public void setDirectorid(String directorid) {
        this.directorid = directorid;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.Birthdate = birthdate;
    }

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        this.Biography = biography;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        this.Picture = picture;
    }

    //method for populating database on first run
    @Exclude
    public static List<Director> populateData()
    {
        List<Director> directorList = new ArrayList<>();

        /*
        directorList.add(new Director("1","James","Cameron", "16.08.1954", "James Francis Cameron was born on August 16, 1954 in Kapuskasing, Ontario, Canada. He moved to the United States in 1971. The son of an engineer, he majored in physics at California State University before switching to English, and eventually dropping out. He then drove a truck to support his screenwriting ambition. He landed his first professional film job as art director, miniature-set builder, and process-projection supervisor on Roger Corman's Les mercenaires de l'espace (1980) and had his first experience as a director with a two week stint on Piranha 2 - Les tueurs volants (1981) before being fired. In 1984, he wrote and directed Terminator (1984), a futuristic action-thriller starring Arnold Schwarzenegger, Michael Biehn and Linda Hamilton. It was a huge success. After this came a string of successful science-fiction action films such as Aliens - Le retour (1986), Abyss (1989) and Terminator 2 - Le jugement dernier (1991). In 1990, Cameron formed his own production company, Lightstorm Entertainment. In 1997, he wrote and directed Titanic (1997), a romance epic about two young lovers from social classes who meet on board the famous ship. The movie went on to break all box office records and earned eleven Academy Awards. It became the highest grossing movie of all time. The rest is history. James Cameron is now one of the most sought-after directors in Hollywood. He was formerly married to producer Gale Anne Hurd, who produced several of his films. In 2000, he married actress Suzy Amis, who appeared in Titanic, and they have three children.", "cameron")) ;
        directorList.add(new Director("2","Steven","Spielberg", "18.12.1946", "Steven Allan Spielberg is an American film director, screenwriter, film producer, video game designer and studio executive. In a career spanning four decades, Spielberg's films have covered many themes and genres. Spielberg's early science-fiction and adventure films were seen as an archetype of modern Hollywood blockbuster filmmaking. In later years, his films began addressing such issues as the Holocaust, slavery, war and terrorism. He is considered one of the most influential filmmakers in the history of cinema. He is also one of the founders of DreamWorks movie studio.", "spielberg")) ;
        directorList.add(new Director("3","Christopher","Nolan", "30.07.1970", "Christopher Edward Nolan is a British-American director, writer, editor and film producer. He made his name in the late 1990s with his first feature film, Following (1998), shot in black and white. His second film, Memento (2000), brought him fame, which allowed him to obtain for the third, Insomnia (2002), the collaboration of Al Pacino and Robin Williams. He was then chosen to direct the Batman trilogy: Batman Begins (2005), The Dark Knight: The Black Knight (2008) and The Dark Knight Rises (2012). While working on this saga, he directed Le Prestige (2006), and two science fiction films, Inception (2010) and Interstellar (2014).", "nolan")) ;
        */
        return directorList ;
    }
}
