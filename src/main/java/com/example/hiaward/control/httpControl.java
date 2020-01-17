package com.example.hiaward.control;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

@Controller
@RequestMapping("test")
public class httpControl {

    @RequestMapping("message")
    public String dealRequest(){

        String date = "    0   02017042819304300110107688010126200112166001测试客户                                          99111.11       0.0            0.0                   18991231189912310.3        4001";
        return date;
    };

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

        Document docRe = DocumentHelper.createDocument();
        Element SyncAppOrderResp = docRe.addElement("reXML").addNamespace("", "http://www.javacui.com/xml/schemas/");
        SyncAppOrderResp.addElement("status").addText("0");
        return new ResponseEntity(docRe.asXML(), HttpStatus.OK);
    }
}
