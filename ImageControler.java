package com.example.demo.web;

import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;





@RestController
public class ImageControler {
    @RequestMapping(method = RequestMethod.POST, value = "/image/add")
    public JSONObject addImage(HttpServletRequest requestEntity) throws Exception{

       return Controller.setImage(requestEntity.getInputStream());

    }
@RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable String id)throws Exception {
        return Controller.getImage(id); }


        @RequestMapping(method = RequestMethod.DELETE, value = "/image/{id}")
        public String Delete(@PathVariable String id)throws Exception {
            return Controller.Delete(id); }

    @RequestMapping(method = RequestMethod.GET, value = "/image/{id}/size")
    public JSONObject Size(@PathVariable String id)throws Exception {
        return Controller.Size(id); }
   @RequestMapping(value = "/grey/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] Grey(@PathVariable String id)throws Exception {
        return Controller.Grey(id); }
    @RequestMapping(value = "/hist/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public JSONObject  hist(@PathVariable String id)throws Exception {
        return Controller.histogram(id); }
    @RequestMapping(value = "/image/{id}/blur/{radius}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] gaus(@PathVariable String id,@PathVariable float radius)throws Exception {
        return Controller.Gaus(id, radius); }
}




