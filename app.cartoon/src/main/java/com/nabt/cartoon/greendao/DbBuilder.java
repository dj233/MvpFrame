package com.nabt.cartoon.greendao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DbBuilder {

    public static void main(String[] arg){
        int version=1;
        String defaultPackage="com.nabt.db.bean";
        //创建模式对象，指定版本号和自动生成的bean对象的包名
        Schema schema=new Schema(version,defaultPackage);
        //指定自动生成的dao对象的包名,不指定则都DAO类生成在"test.greenDAO.bean"包中
        schema.setDefaultJavaPackageDao("com.nabt.db.dao");

        //添加实体
        addBookEntity(schema);

        String outDir="D:\\dev\\workspace\\github\\app.cartoon\\src\\main\\java";
        //调用DaoGenerator().generateAll方法自动生成代码到之前创建的java-gen目录下
        try {
            new DaoGenerator().generateAll(schema,outDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void addBookEntity(Schema schema){
        Entity entity = schema.addEntity("DBook");
        entity.addStringProperty("name").primaryKey();
        entity.addStringProperty("type");
        entity.addStringProperty("area");
        entity.addStringProperty("des");
        entity.addBooleanProperty("finish");
        entity.addIntProperty("lastUpdate");
        entity.addStringProperty("coverImg");
    }
}
