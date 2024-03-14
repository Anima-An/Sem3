package model;

import java.time.LocalDateTime;

public class Post {
    // 1.variables
    private String title;
    private String msg;
    private LocalDateTime dateTime = LocalDateTime.now();
    //TODO pārtaisī uz User sarakstu
    private int countOfLikes = 0;

    //2.get and set

    public String getTitle(String title) {
        this.title = title;
        return title;
    }

    public void setTitle(String title) {
        if (title != null && title.length() > 5 && title.length() < 50)
            this.title = title;
        else
            this.title = "-----";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        if(msg!=null&&msg.length() > 5 && msg.length() < 1000)
            this.msg = msg;
        else
            this.msg = "-----";
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void incrementCountOfLikes() {
        this.countOfLikes++;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    //3.constuctor

    public Post() {
        setTitle("Test Title");
        setMsg("Test Description");
    }

    public Post(String title, String msg) {
        setTitle(title);
        setMsg(msg);
    }

    //4.toString

    public String toString() {
        return title + "(" + dateTime +")" + msg + "[" + countOfLikes + "]";
    }

    //
    

}
    


