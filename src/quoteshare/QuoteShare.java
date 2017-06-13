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
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnirestException {
     
        String gen_quote="And they have no respect for the status quo. You can quote them, disagree with them, glorify or vilify them."; 
        
      //  String gen_quote = getquotes();                               //Here we would get new qoutes on each call 
       
          new TextToImage(gen_quote);                                  //this helps in conversion of parsed data to image       
        
          PostToFacebook();                                           // with the help of this function we can call facebook graph api using restfb to post our image on fb
        
        
        
        
    }

    private static void PostToFacebook() throws FileNotFoundException {

        
                String Access_Token = "EAABq3wMYTHABANGkgKZBAWPWD3lVUnX6aU3L8YfjkCd0q3bf8SgmTVqINZCytYTMZBiMwbyg5Jv7AK0fYytqfeQWAwM9VFXadub0dV8YO4ODWKp1CexVAV9JXc2fg1OOgTtxZBWST4AvSyCjjLM1vDY7FsvJQmZAVnVtOHTilLLlvWgJh4ZBPHfSaxIXEkeRwZD";

                FacebookClient fbclient = new DefaultFacebookClient(Access_Token);


                File file = new File("F:\\quote.png");

                FileInputStream fileInputStream = new FileInputStream(file);
                FacebookType response = fbclient.publish("me/photos", FacebookType.class, BinaryAttachment.with("Quote.png", fileInputStream),
                Parameter.with("message", "Here is today's Quote :) "));                //this would publish the stored file image on facebook on my timeline

                System.out.println("fb.com/"+response.getId());                         //this would print the url of newly posted image on facebook
                
                

    }

    static String getquotes() throws UnirestException {
       
   
                String URL = "https://andruxnet-random-famous-quotes.p.mashape.com/?cat=famous&count=1";
        
 
                HttpResponse<JsonNode> response = Unirest.get(URL)
                .header("X-Mashape-Key", "JNUFPIzOmEmsh7B9ZzUJy6wbguuCp1Kk6MTjsnat6zaeandSnc")
                .header("Accept", "application/json")
                .asJson();
                                                                                            //this would generate a json file containing 1 quote from mashape
                
                String fulljson = response.getBody().getObject().toString();
 
                
                String newquote = newquote(fulljson);                       //this will parse json data 
           
                
                
                 
                
                return newquote;
    

           
        
                
                
    }

    private static String newquote(String fulljson) {
        
        
                
        
        
        
        
        
        
        return null;
        
    }
    
}
