package com.example.nikhar.mst04v10;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

public class DataPackager {

    String Username, Password, Language1, Language2, Language3, FirstName, LastName,  Email;

    /*
    SECTION 1.RECEIVE ALL DATA WE WANNA SEND
     */
    public DataPackager(String Username, String Password, String Language1,	String Language2, String Language3, String FirstName, String LastName, String Email) {
        this.Username = Username;
        this.Password = Password;
        this.Language1 = Language1;
        this.Language2 = Language2;
        this.Language3 = Language3;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
    }

    /*
   SECTION 2
   1.PACK THEM INTO A JSON OBJECT
   1. READ ALL THIS DATA AND ENCODE IT INTO A FROMAT THAT CAN BE SENT VIA NETWORK
    */
    public String packData()
    {
        JSONObject jo=new JSONObject();
        StringBuffer packedData=new StringBuffer();

        try
        {
            jo.put("Username", Username);
            jo.put("Password", Password);
            jo.put("Language1", Language1);
            jo.put("Language2", Language2);
            jo.put("Language3", Language3);
            jo.put("FirstName", FirstName);
            jo.put("LastName", LastName);
            jo.put("Email", Email);

            Boolean firstValue=true;

            Iterator it=jo.keys();

            do {
                String key=it.next().toString();
                String value=jo.get(key).toString();

                if(firstValue)
                {
                    firstValue=false;
                }else
                {
                    packedData.append("&");
                }

                packedData.append(URLEncoder.encode(key,"UTF-8"));
                packedData.append("=");
                packedData.append(URLEncoder.encode(value,"UTF-8"));

            }while (it.hasNext());

            return packedData.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }


}
