package model.user;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends RegisteredUser {

    //1. variables
    private String VATNo; //LV90000362426
    private ArrayList<Page> allUserPages = new ArrayList<Page>();

    //2. get and set
    public String getVATNo() {
        return VATNo;
    }

    public void setVATNo(String vATNo) {
        if(vATNo != null && vATNo.matches("[A-Z]{2}[0-9]{11}"))
            VATNo = vATNo;
        else
            VATNo = "----------";
        
    }

    public ArrayList<Page> getAllUserPages() {
        return allUserPages;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ0-9.,:'@&%+=]{2,40}"))
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        else
            super.nameAndSurnameOrTitle = "----------";
    }


    //3. consstruc

    public  BusinessUser(){
        super(); //tiek izssaukts RegisteredUser() constru
        setNameAndSurnameOrTitle("SIA Autoserviss");
        setUsername();
        setVATNo("LV90000362426");
    }

    public BusinessUser(String title, String password, String VATNo) {
        super(password); //tiks izsaukts  RegisteredUser(password) konstruktoram
        setNameAndSurnameOrTitle(title);
        setUsername();
        setVATNo(VATNo);
    }

    //4. toString

    public String toString() {
        return super.toString() + "[" + VATNo + "]";
    }

    //5. other funtions

    public void addPage(String title, String description) throws Exception {
        //TODO ja nepieciesams, parbauda ievades parametrus uz not null
        
        for(Page tempP: allUserPages) {
            if(tempP.getTitle().toLowerCase().equals(title.toLowerCase())) {
                throw new Exception("Page already exists");
            }
        }

        Page newPage = new Page(title, description);
        allUserPages.add(newPage);
    }


    public void publicPostInPage(String postTitle, String msg, String pageTitle, PostType type) throws  Exception{ 
        //TODO ja nepieciesams, parbauda ievades parametrus uz not null

        //TODO atrast konkreto lapu un caur publish Post funkciju pieliek lapa sludinajumi

        for(Page tempP : allUserPages) {
            if(tempP.getTitle().toLowerCase().equals(postTitle.toLowerCase())) {
                Post newPost = publishPost(postTitle, msg, type);
                if(type.equals(PostType.privatePost))
                    tempP.getPrivatePosts().add(newPost);
                else if(type.equals(PostType.publicPost))
                    tempP.getPublicPosts().add(newPost);
                
                return;
            }

    }

    throw new Exception("Page not found");

}
    @Override
    public Post publishPost(String title, String msg, PostType type) throws Exception {
        // TODO Auto-generated method stub
        Post p = new Post(title, msg);
        return newPost;
    
    }
}  

