/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoteshare;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.restfb.BinaryAttachment;
import com.restfb.*;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.FacebookType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 *
 * @author harsh singh
 */
public class QuoteShare {
    private static Object Unirest;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnirestException {
     
        
        getquotes();
        PostToFacebook();
        
        
        
        
    }

    private static void PostToFacebook() throws FileNotFoundException {

        
                String Access_Token = "EAABq3wMYTHABAD7LzpQY32RtVPDGHWQCoKtLvvygkSYwnr5NiBn34Lq5fPWGV0kxs8xnj5heAyfylMbJ2pxELm189ZBCDolgNz1xsFQpRtTtgXu8JkBEdKAfVj45VMObBTTOR2w2o3uGnHm7vmZCWoiZBMTWs1R4HZBr6lZBmsZBwFRWhdZBZCPuZBGXwMaEuqI8ZD";

                FacebookClient fbclient = new DefaultFacebookClient(Access_Token);


                File file = new File("F:\\harsh.jpg");

                FileInputStream fileInputStream = new FileInputStream(file);
                FacebookType response = fbclient.publish("me/photos", FacebookType.class, BinaryAttachment.with("harsh.jpg", fileInputStream),
                Parameter.with("message", "Here is today's Quote :) "));

                System.out.println("fb.com/"+response.getId());
                
                

    }

    private static void getquotes() throws UnirestException {
       
   
                String URL = "https://andruxnet-random-famous-quotes.p.mashape.com/?cat=famous&count=1";
        
 
                HttpResponse<JsonNode> response = Unirest.get(URL)
                .header("X-Mashape-Key", "JNUFPIzOmEmsh7B9ZzUJy6wbguuCp1Kk6MTjsnat6zaeandSnc")
                .header("Accept", "application/json")
                .asJson();
    
                
                String fulljson = response.getBody().getObject().toString();
    
    
    
    }
    
}
