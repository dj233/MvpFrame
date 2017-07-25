package com.nabt.cook.dao;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by 14K on 2017/7/25.
 */

public class DaoBuilder {

    public static void main(String[] args) throws Exception {
        int version = 1;
        String entityPath = "com.nabt.cook.dao.entity";
        String daoPath = "com.nabt.cook.dao.db";
        Schema schema = new Schema(version,entityPath);
        schema.setDefaultJavaPackageDao(daoPath);
        addEntitys(schema);
        String outDir = "D:\\dev\\workspace\\github\\CookBook\\src\\main\\java";
        new DaoGenerator().generateAll(schema,outDir);
    }

    private static void addEntitys(Schema schema) {
        //分类
        Entity type = schema.addEntity("Type");
        type.addStringProperty("id").primaryKey().notNull();
        type.addStringProperty("name");
        type.addStringProperty("parentId");
        //菜单
        Entity bookEntity = schema.addEntity("Book");
        bookEntity.addStringProperty("id").primaryKey().notNull();
        bookEntity.addStringProperty("title");
        bookEntity.addStringProperty("tags");
        bookEntity.addStringProperty("imtro");
        bookEntity.addStringProperty("ingredients");
        bookEntity.addStringProperty("burden");
        bookEntity.addStringProperty("album");
        //步骤
        Entity stepEntity = schema.addEntity("Step");
        stepEntity.addStringProperty("img");
        stepEntity.addStringProperty("step");
        //建立多对一外键约束
        Property foreignKey = stepEntity.addStringProperty("bookId").getProperty();
        stepEntity.addToOne(bookEntity,foreignKey);
        bookEntity.addToMany(stepEntity,foreignKey).setName("steps");
    }
}
