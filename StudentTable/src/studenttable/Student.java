
package studenttable;

import java.text.ParseException;
import java.util.Date;
import java.io.Serializable;

import java.text.SimpleDateFormat;
public class Student implements Serializable
{
    private String name, address, id, email;
    private int phone;
    private Date bird;
    private float mark;
    public String getName()
    {
        return this.name;
    }
    public String getAddress()
    {
        return this.address;
    }
    public String getId()
    {
        return this.id;
    }
    public String getEmail()
    {
        return this.email;
    }
    public int getPhone()
    {
        return this.phone;
    }
    public Date getBird()
    {
        return this.bird;
    }
    public float getMark()
    {
        return this.mark;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPhone(int phone)
    {
        this.phone = phone;
    }
    public void setBird(String stringbird)
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            this.bird = formatter.parse(stringbird);

        }catch(ParseException e)
        {
            System.out.print("LOi!!");
        }
    }
    public void setMark(float mark)
    {
        this.mark = mark;
    }
    public static void main(String[] args) {
        
    }

    
}
