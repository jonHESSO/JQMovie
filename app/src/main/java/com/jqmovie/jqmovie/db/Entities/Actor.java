package com.jqmovie.jqmovie.db.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.IgnoreExtraProperties;
import com.jqmovie.jqmovie.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jonathan on 17.04.2018.
 */

/**
 * Entity model for Actor
 */


@IgnoreExtraProperties
public class Actor {
    private String Parent;
    private String actorId ;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String biography ;
    private int picture;

    public Actor(String actorId, String firstname, String lastname, String birthdate, String biography, int picture) {
        this.actorId=actorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.biography = biography;
        this.picture = picture;
    }

    public Actor(){}

    public String getParent() {
        return Parent;
    }

    public void setParent(String parent) {
        Parent = parent;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    //Method for populating database on first run
    public static List<Actor> populateData()
    {
        List<Actor> actorList = new ArrayList<>();

        actorList.add(new Actor("1","Leonardo","DiCaprio", "11.11.1974", "Born in 1974 in Los Angeles, California, Leonardo DiCaprio is an actor known for his edgy, unconventional roles. He started out in television before moving on to film, scoring an Oscar nomination for his role in What's Eating Gilbert Grape (1993). In 1997, DiCaprio starred in James Cameron's epic drama Titanic, which made him a huge star. The actor has also paired up with iconic director Martin Scorsese for several projects, including The Aviator (2004) and The Departed (2006). His more recent films include Inception (2010), Django Unchained (2012), The Wolf of Wall Street (2013) and The Revenant (2015), winning his first Oscar for the latter.", R.mipmap.dicaprio)) ;
        actorList.add(new Actor("2","Kate","Winsley", "05.10.1975", "Born on October 5, 1975, in Reading, England, Kate Winslet started acting at age 7. She starred on the British stage until the mid-1990s, when she appeared in her first film, Heavenly Creatures. In 1997 she had the lead in Titanic, which propelled her to international stardom. She has since starred in several offbeat films and has won the best actress Oscar for The Reader. She has also received several Golden Globes, including wins for Revolutionary Road, Mildred Pierce and Steve Jobs.",R.mipmap.winslet)) ;
        actorList.add(new Actor("3","Tom","Hanks", "09.07.1956", "Born on July 9, 1956, in Concord, California, actor Tom Hanks began performing with the Great Lakes Shakespeare Festival in 1977, later moving to New York City. He starred in the television sitcom Bosom Buddies, but became far more known when he starred in the Ron Howard film Splash. He went on to star in many more popular and acclaimed movies, including Big, Forrest Gump and Cast Away, en route to becoming one of the most powerful and well-respected actors in Hollywood.",R.mipmap.hanks)) ;
        actorList.add(new Actor("4","Matt","Damon", "08.10.1970", "Born on October 8, 1970, in Cambridge, Massachusetts, Matt Damon's acting career took off after starring in and writing 1997's Good Will Hunting with friend Ben Affleck. The duo won an original screenplay Oscar for the project. Damon has since acted in a wide range of movies, including the popular Ocean's Eleven series and the Jason Bourne thrillers. Other major projects on his roster have included The Talented Mr. Ripley, The Adjustment Bureau, Behind the Candelabra and the Golden Globe-winning blockbuster The Martian, directed by Ridley Scott.",R.mipmap.damon)) ;
        actorList.add(new Actor("5","Edward","Burns", "29.01.1968", "Born in Queens, New York, in 1968, Ed Burns is a moviemaking triple threat, as he directs, acts and stars in his own films. He began his career by making film shorts in college and achieved success with his 1995 indie flick, The Brothers McMullen. He's been creating films ever since. Burns is married to supermodel Christy Turlington and the couple have two children.",R.mipmap.burns)) ;
        actorList.add(new Actor("6","Anne","Hathaway", "12.11.1982", "Actress Anne Hathaway was born in Brooklyn, New York, on November 12, 1982. As a youngster, she was accepted into The Barrow Group theater company. In 1999, she got her first big break on the short-lived television series Get Real. Shortly after the series ended, Hathaway took landed the role that made her famous, playing Mia Thermopolis in The Princess Diaries. In 2006, she found huge success with the film The Devil Wears Prada (2006). In 2007, she starred in Becoming Jane, a film about Jane Austen. Hathaway then garnered both critical and commerical attention for her role in 2010's Love and Other Drugs, due in no small part to her nude scenes in the film, and went on to win acclaim or later film appearances, including those in The Dark Knight Rises and Les Miserables (both released in 2012).",R.mipmap.hathaway)) ;
        actorList.add(new Actor("7","Matthew","McConaughey", "04.11.1969", "Matthew McConaughey was born on November 4, 1969, in Uvalde, Texas. He graduated from the University of Texas at Austin and got his first big break with the 1993 film Dazed and Confused. He later starred in A Time to Kill (1996) and Amistad (1997), among many others. Named People magazine's \"Sexiest Man Alive\" in 2005, McConaughey more recently starred in Mud (2012) and Dallas Buyers Club (2013), which earned him the Academy Award for Best Actor. McConaughey came on strong in 2014 with his starring role on the HBO series True Detective, a project that propelled him even further on his star trajectory.",R.mipmap.mcconaughey)) ;
        actorList.add(new Actor("8","Jessica","Chastain", "24.04.1977", "Born on March 24, 1977, in Sacramento, California, Jessica Chastain attended Juilliard and then began landing roles on TV shows such as ER and Veronica Mars. Her acting career took off in 2011 when she appeared in the blockbuster The Help, earning a supporting actress Oscar nod for the role, and the lauded Tree of Life. She has since won a Golden Globe and earned another Academy Award nomination, specifically for lead actress in the Kathryn Bigelow film Zero Dark Thirty. Additional projects include Interstellar, A Most Violent Year and Crimson Peak.",R.mipmap.chastain)) ;
        actorList.add(new Actor("9","Bill","Irwin", "11.04.1950", "William Mills Irwin is an American actor, clown, and comedian. He began as a vaudeville-style stage performer and has been noted for his contribution to the renaissance of American circus during the 1970s. He has also made a number of appearances on film and television, and he won a Tony Award for his role in Who's Afraid of Virginia Woolf on Broadway. He is also known as Mr. Noodle on the Sesame Street spinoff Elmo's World, has appeared in the Sesame Street film short Does Air Move Things?, and regularly appears as a therapist on Law and Order: SVU.",R.mipmap.irwin)) ;
        actorList.add(new Actor("10","Ellen","Burstyn", "07.12.1932", "Born Edna Rae Gillooly, Ellen Burstyn found her breakthrough role in 1971's The Last Picture Show. She solidified her career with an iconic part in The Exorcist, and a best actress Oscar for Martin Scorsese's Alice Doesn't Live Here Anymore. Burstyn also won a Tony Award in 1975, served as president of Actor's Equity, and headed the Actors Studio for several years.",R.mipmap.burstyn)) ;
        actorList.add(new Actor("11","Michael","Caine", "14.03.1933", "Born on March 14, 1933, in London, Sir Michael Caine went on to pursue a varied acting career. His first acclaimed role was as agent Harry Palmer in 1965's The Ipcress File, and he went on to be featured in films like Alfie, The Italian Job, Sleuth, Dirty Rotten Scoundrels, Christopher Nolan�s Dark Knight series and many more. He�s won two Oscars, one for Hannah and Her Sisters and the other for The Cider House Rules.",R.mipmap.caine)) ;
        return actorList ;
    }

}
