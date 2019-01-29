package com.example.lib_common.base.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * @author: tianhuaye
 * @date: 2019/1/28 15:54
 * @description:
 */
@Entity
public class Alarm {
    @Id
    private Long id;
    @Property
    private Integer hour;
    @Property
    private Integer minute;
    @Property
    private Integer mode;
    @Property
    private String ringPath;
    @Property
    private String msg;

    @Generated(hash = 2111888946)
    public Alarm(Long id, Integer hour, Integer minute, Integer mode,
            String ringPath, String msg) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
        this.mode = mode;
        this.ringPath = ringPath;
        this.msg = msg;
    }
    @Generated(hash = 1972324134)
    public Alarm() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getHour() {
        return this.hour;
    }
    public void setHour(Integer hour) {
        this.hour = hour;
    }
    public Integer getMinute() {
        return this.minute;
    }
    public void setMinute(Integer minute) {
        this.minute = minute;
    }
    public Integer getMode() {
        return this.mode;
    }
    public void setMode(Integer mode) {
        this.mode = mode;
    }
    public String getRingPath() {
        return this.ringPath;
    }
    public void setRingPath(String ringPath) {
        this.ringPath = ringPath;
    }
    public String getMsg() {
        return this.msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}