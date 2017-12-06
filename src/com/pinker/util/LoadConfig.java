package com.pinker.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class LoadConfig {
    /**
     * 通过标签名取得节点列表
     *
     * @param configPath 配置文件路径
     * @param tagName    标签名
     * @return 节点列表
     */
    public static NodeList load(String configPath, String tagName) {
        NodeList nodeList = null;
        try {
            File file = new File(configPath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            nodeList = document.getElementsByTagName(tagName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nodeList;
    }
}
