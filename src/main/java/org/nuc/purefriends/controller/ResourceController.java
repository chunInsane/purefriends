package org.nuc.purefriends.controller;

import org.apache.commons.lang3.StringUtils;
import org.nuc.purefriends.exception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by zhangliang on 15/11/15.
 */
@Controller
@RequestMapping( value = "/etc")
public class ResourceController {

    @RequestMapping( value = "/{filename}/{suffix}")
    public void getResources( @PathVariable String filename, @PathVariable String suffix, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank( filename) || StringUtils.isBlank(suffix))
            throw new UserException("the argument can't be null!");
        String path = request.getRealPath("");
        response.setContentType( "application/" + suffix);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new InputStreamReader( new FileInputStream( path + "/resources/etc/" + filename + "." + suffix)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(response.getOutputStream()));
        String str = null;
        while ((str = reader.readLine()) != null) {
            writer.write( str);
        }
        writer.flush();
        writer.close();
    }
}
