package com.example.hiaward.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("test")
public class httpControl {

    @RequestMapping("testPost2")
    public ResponseEntity<String> testPost1(HttpServletRequest req, HttpServletResponse res) throws Exception{
        BufferedReader bufferReader = req.getReader();//获取头部参数信息
        StringBuffer buffer = new StringBuffer();
        String line = " ";
        while ((line = bufferReader.readLine()) != null) {
            buffer.append(line);
        }
        String postData = buffer.toString();
        System.out.println(postData);
        String fileName = postData.substring(0,4);
        InputStream inn = new FileInputStream("C:/HTTP" + java.io.File.separator + fileName + ".txt");
        byte[] bb = new byte[1024];
        int len = inn.read(bb);
        inn.close();
        byte[] sendbyte = new String(bb,"GBK").getBytes();
        String response = new String(sendbyte);
        System.out.println("返回报文:"+response);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    private static String test() throws IOException {

        String fileName = "2510";
        FileReader fr = new FileReader("C:/HTTP" + java.io.File.separator + fileName + ".txt");
        char[] buf = new char[1024];
        int len = fr.read(buf);
        while((len=fr.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }

        System.out.println(new String(buf,52,50));
        String s = String.valueOf(buf);
        System.out.println("返回报文:"+s);

        InputStream inn = new FileInputStream("C:/HTTP" + java.io.File.separator + fileName + ".txt");
        byte[] bb = new byte[1024];
        int len1 = inn.read(bb);
        inn.close();
        byte[] sendbyte = new String(bb,52,50,"GBK").getBytes();
        String response = new String(sendbyte);
        System.out.println("返回报文2:"+response);
        return s;
    }

    public static void main(String[] args) throws IOException {
        test();
    }
}
