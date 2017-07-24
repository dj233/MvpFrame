package com.dao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DaoBuilder {

    public static void main(String[] args) throws Exception{

        Schema schema = new Schema(1, "com.dao.entity");
        schema.setDefaultJavaPackageDao("com.dao.db");

        addNodes(schema);

        new DaoGenerator().generateAll(schema,"E:\\dev\\as_code\\MvpFrame\\app.healthy\\src\\main\\java");
    }

    private static void addNodes(Schema schema) {
        addTaskStateNode(schema);
    }

    private static void addTaskStateNode(Schema schema){
        Entity detail = schema.addEntity("DbDetail");
        detail.addIntProperty("id").unique();
        detail.addIntProperty("count");
        detail.addIntProperty("fcount");
        detail.addIntProperty("loreclass");
        detail.addIntProperty("rcount");
        detail.addStringProperty("img");
        detail.addLongProperty("time");
        detail.addStringProperty("keywords");
        detail.addStringProperty("description");
        detail.addStringProperty("message");
        detail.addStringProperty("title");

    }
}
