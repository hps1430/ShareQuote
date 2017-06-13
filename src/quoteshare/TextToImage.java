/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoteshare;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author harsh singh
 */
class TextToImage {
    

    public TextToImage(String newquote) {
        
        String quote = newquote;
               System.out.println(newquote);
               
        quote = dividequote(quote);       
 
               
               
       
   //        Because font metrics is based on a graphics context, we need to create
     //      a small, temporary image so we can ascertain the width and height
       //    of the final image
       
        
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.PLAIN, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(quote);
        int height =fm.getHeight();                                                              //this will convert the text of quote to                                
        g2d.dispose();                                                                            //image and that would be converted to image stored as a file

        System.out.println(width);
        System.out.println(height);
        
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLUE);
        g2d.drawString(quote, 0, fm.getAscent());
        g2d.dispose();
        try {
            ImageIO.write(img, "png", new File("F:\\quote.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private String dividequote(String quote) {
    
        
            String str = quote;
        
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
            if (i > 0 && (i % 15 == 0)) {
            sb.append(" \n");
            System.lineSeparator();
            }

            sb.append(str.charAt(i));
            }

            str = sb.toString();

    
              
            return str;
    
    
    
    }

  

               
        
        
        
        
        
        
        
        
        
    }
    

