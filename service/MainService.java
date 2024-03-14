package service;

import java.util.ArrayList;

import model.Post;
import model.PostType;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.user.RegisteredUser;


public class MainService {

    private ArrayList<Post> privatePosts = new ArrayList<Post>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<RegisteredUser> followers = new ArrayList<RegisteredUser>();

    public static void main(String[] args) {

        GuestUser gU1 = new GuestUser();
        PrivateUser pU1 = new PrivateUser("Kristers", "Berents", "1234");

        try {
            pU1.publishPost("First Post ", " I do like phrogs", PostType.publicPost);
            pU1.publishPost("Second Post ", " I do like trains", PostType.privatePost);
            pU1.publishPost("Third Post ", " I do like car", PostType.privatePost);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        System.out.println(gU1);
        System.out.println(pU1);

        System.out.println("Private Posts");
        System.out.println(pU1.getPrivatePosts());
        System.out.println("Public Posts");
        System.out.println(pU1.getPublicPosts());




}

}
