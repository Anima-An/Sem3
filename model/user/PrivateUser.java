package model.user;

import java.util.ArrayList;

import model.Post;
import model.PostType;

public class PrivateUser extends RegisteredUser{

    //1. variable
    private ArrayList<Post> privatePosts = new ArrayList<Post>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<RegisteredUser> followers = new ArrayList<RegisteredUser>();

    //2. get and set
        public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }

    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }

    public ArrayList<RegisteredUser> getFollowers() {
        return followers;
    }

     @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]{2,20} [A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]{2,30}"))
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        else
            super.nameAndSurnameOrTitle = "---------";
    }

    //3. construc

    public PrivateUser() {
        super(); //te izsaucas RegisteredUser() construc
        setNameAndSurnameOrTitle("Jānis Bērziņš");
        setUsername();
    }

    public PrivateUser(String name, String surname, String password) {
        super(password); // tiks izsaukts RegisteredUser(String password) conmstuc
        setNameAndSurnameOrTitle(name + " " + surname);
        setUsername(); 
    }

    //4. toString
    public String toString() {
        return super.toString() + "[" + (privatePosts.size() + publicPosts.size()) + " posts]";
    }


    //5. other funk  




    @Override
    public void publishPost(String title, String msg, PostType type) throws Exception {
        if(title == null || msg == null || type == null) throw new Exception("Problem with input parameter");
    
            Post newPost = new Post(title, msg);

            if(type.equals(PostType.privatePost)) 
                privatePosts.add(newPost);
            else publicPosts.add(newPost);
    }

    


}
