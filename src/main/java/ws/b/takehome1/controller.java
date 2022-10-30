/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.takehome1;

import java.io.IOException;
import java.sql.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dwi Aprilya
 */
@Controller
public class controller {
    
    @RequestMapping(value="/data", method=RequestMethod.POST)
    public String getData(@RequestParam (value="inputname") String getName,
                          @RequestParam (value="inputdate") Date getDate,
                          @RequestParam (value="inputimage") MultipartFile getImage,
                          Model model)throws IOException{
        
        byte[] inputimages = getImage.getBytes();
        String base64Image = Base64.encodeBase64String(inputimages);
        String linkimage = "data:image/png;base64,".concat(base64Image);
        
        String getDataName = "Name : " + getName;
        String getDataDate = "Date of Birth : " + getDate;
        
        model.addAttribute("postName", getDataName);
        model.addAttribute("postDate", getDataDate);
        model.addAttribute("postImage", linkimage);
        return"main";
    }
}
