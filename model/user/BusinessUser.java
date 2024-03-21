package model.user;

import java.util.ArrayList;

import model.Page;
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

    @Override
    public void publishPost(String title, String msg, PostType type) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'publishPost'");
    }

   
}
