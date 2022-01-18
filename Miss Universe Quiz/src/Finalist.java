
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Finalist {

    private String name;
    private String password;
    private String pic;
    private String country;
    private String flag;
    private int score;

    public Finalist(String name, String password, String pic, String flag) {
        this.name = name;
        this.password = password;
        this.pic = pic;
        this.flag = flag;
    }

    public Finalist(String name, int score, String pic) {
        this.name = name;
        this.score = score;
        this.pic = pic;
    }

    public Finalist() {

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPic() {
        return pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
