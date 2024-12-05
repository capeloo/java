package model.frogs;

import java.util.Date;

public class Frogs {
    private int id;
    private String name;
    private String photo;
    private Date date;
            
    public int getId(){
        return id;
    }        
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getPhoto(){
        return photo;
    }
    
    public void setPhoto(String photo){
        this.photo = photo;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
}
