package com.nabt.cook.dao.entity;

import java.io.Serializable;
import java.util.List;
import com.nabt.cook.dao.db.DaoSession;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

import com.nabt.cook.dao.db.BookDao;
import com.nabt.cook.dao.db.StepDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "BOOK".
 */
public class Book implements Serializable{

    /** Not-null value. */
    private String id;
    private String title;
    private String tags;
    private String imtro;
    private String ingredients;
    private String burden;
    private String album;
    private String[] albums;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BookDao myDao;

    private List<Step> steps;

    public Book() {
    }

    public Book(String id) {
        this.id = id;
    }

    public Book(String id, String title, String tags, String imtro, String ingredients, String burden, String album) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.imtro = imtro;
        this.ingredients = ingredients;
        this.burden = burden;
        this.album = album;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookDao() : null;
    }

    /** Not-null value. */
    public String getId() {
        return id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getImtro() {
        return imtro;
    }

    public void setImtro(String imtro) {
        this.imtro = imtro;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getBurden() {
        return burden;
    }

    public void setBurden(String burden) {
        this.burden = burden;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String[] getAlbums() {
        if(albums == null){
            albums = new String[]{album};
        }
        return albums;
    }

    public void setAlbums(String[] albums) {
        this.albums = albums;
        this.album = this.albums[0];
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Step> getSteps() {
        if (steps == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StepDao targetDao = daoSession.getStepDao();
            List<Step> stepsNew = targetDao._queryBook_Steps(id);
            synchronized (this) {
                if(steps == null) {
                    steps = stepsNew;
                }
            }
        }
        return steps;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetSteps() {
        steps = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}