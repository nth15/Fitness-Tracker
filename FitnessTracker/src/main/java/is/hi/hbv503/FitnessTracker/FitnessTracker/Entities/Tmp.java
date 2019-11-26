package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import java.util.Date;

public class Tmp {

    private Double duration;

    private Date date;
    private String title;

    public Tmp() {

    }

    public Tmp(Tmp tmp) {
        this.duration = tmp.duration;
        this.date = tmp.date;
        this.title = tmp.title;
    }

    public static Tmp copyTmp(Tmp tmp) {
        return new Tmp(tmp);
    }

    public Double getDuration() {
        return duration;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
