package model;

import java.util.ArrayList;

import model.user.RegisteredUser;

public class Page {

    //1. variables
    private  String title;
    private String description;

    private ArrayList<RegisteredUser> followers; 
    private ArrayList<Post> postsInPage;

    //2. get and set

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<RegisteredUser> getFollowers() {
        return followers;
    }
    public void setFollowers(ArrayList<RegisteredUser> followers) {
        this.followers = followers;
    }
    public ArrayList<Post> getPostsInPage() {
        return postsInPage;
    }
    public void setPostsInPage(ArrayList<Post> postsInPage) {
        this.postsInPage = postsInPage;
    }
    
    
    
}
