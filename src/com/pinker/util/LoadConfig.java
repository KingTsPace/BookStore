package com.pinker.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LoadConfig {
    /**
     * 通过标签名取得节点列表
     *
     * @param configPath 配置文件路径
     * @param tagName    标签名
     * @return 节点列表
     */
    public static List<String> load(String configPath, String tagName) {
        List<String> list=new ArrayList<String>();
        try {
            File file = new File(configPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName(tagName);
            for (int i = 0; i <nodeList.getLength() ; i++) {
                list.add(document.getElementsByTagName(tagName).item(i).getFirstChild().getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
