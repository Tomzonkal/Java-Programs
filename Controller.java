package com.example.demo.web;
import com.jhlabs.image.GaussianFilter;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import org.jfree.data.statistics.HistogramDataset;
public class Controller {
    static Map<String, BufferedImage> map=new HashMap<>();
    static Integer count=0;

    public static JSONObject  setImage(InputStream in) throws IOException {
        BufferedImage bImage = ImageIO.read(in);
        in.close();
        map.put(count.toString(),bImage);
        Images temp= new Images(bImage,count.toString());

       JSONObject obj=new JSONObject();
       obj.put("id",count);
      //  obj.put("width",map.get(count).getWidth());
       // obj.put("height",map.get(count).getHeight());

        count ++;
        return obj;

    }
    public static byte[] getImage(String id) throws IOException {


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (map.get(id)==null){
            return "404".getBytes();
        }
        else
        ImageIO.write(map.get(id), "jpg", baos);
        System.out.println("Sended a file");
        return baos.toByteArray();

    }

    public static String Delete(String id) throws IOException {


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (map.get(id)==null){
            return "404";
        }
        else
            map.remove(id);
        return "Object deleted";

    }


    public static JSONObject histogram(String id) throws IOException {
         final int BINS = 256;
        JSONObject obj = new JSONObject();
        HistogramDataset dataset =new HistogramDataset();
        Raster raster = map.get(id).getRaster();
        if (map.get(id)==null){
            obj.put("error","404");
            return obj;
        }
        final int w = map.get(id).getWidth();
        final int h = map.get(id).getHeight();
        double[] r = new double[w * h];
        r = raster.getSamples(0, 0, w, h, 0, r);
        dataset.addSeries("Red", r, BINS);
        r = raster.getSamples(0, 0, w, h, 1, r);
        dataset.addSeries("Green", r, BINS);
        r = raster.getSamples(0, 0, w, h, 2, r);
        dataset.addSeries("Blue", r, BINS);
    obj.put("Histo",dataset);
    return obj;
    }

    public static JSONObject Size(String id) throws IOException {

        JSONObject obj = new JSONObject();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (map.get(id)==null){
            obj.put("error","404");
            return obj;
        }

        obj.put("width",map.get(id).getWidth());
        obj.put("height",map.get(id).getHeight());
        return obj;

    }

    public static byte[] Gaus(String id ,float radius) throws IOException {
        BufferedImage temp=null;
        if (map.get(id)==null){
            return "404".getBytes();

        }
        if(radius<1)
            return "wrong radious".getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GaussianFilter g=new GaussianFilter();
        g.setRadius(radius);
        temp=g.filter(map.get(id),temp);


        ImageIO.write(temp, "jpg", baos);
        System.out.println("Sended a file gaus");
        return baos.toByteArray();
    }

    public static byte[] Grey(String id) throws IOException {




        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (map.get(id)==null){
            return "404".getBytes();
        }


        int width = map.get(id).getWidth();
        int height = map.get(id).getHeight();



            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    int p = map.get(id).getRGB(x,y);

                    int a = (p>>24)&0xff;
                    int r = (p>>16)&0xff;
                    int g = (p>>8)&0xff;
                    int b = p&0xff;


                    int avg = (r+g+b)/3;


                    p = (a<<24) | (avg<<16) | (avg<<8) | avg;

                    map.get(id).setRGB(x, y, p);
                }
            }
            ImageIO.write(map.get(id), "jpg", baos);
        System.out.println("Sended a file");
        return baos.toByteArray();



    }




}
