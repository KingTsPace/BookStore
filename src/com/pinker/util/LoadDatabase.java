package com.pinker.util;


import java.util.List;

public class LoadDatabase {

    public static String getDatabaseType(){
        String path="E:\\MyCode\\Tyrone\\BookStore\\conf\\config.xml";
        String tagName="databaseType";
        List<String> list=LoadConfig.load(path,tagName);
        String databaseType=list.get(0);
        return databaseType;
    }
}
