package com.company.model;

import java.sql.Time;

public class AttendanceRecord {

    private int id;
    private Time entranceTime;
    private Time exitTime;
    private int employeeId;

    public AttendanceRecord(){}

    public AttendanceRecord(int id, Time entranceTime, Time exitTime, int employeeId) {
        this.id = id;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Time entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Time getExitTime() {
        return exitTime;
    }

    public void setExitTime(Time exitTime) {
        this.exitTime = exitTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "id=" + id +
                ", entranceTime=" + entranceTime +
                ", exitTime=" + exitTime +
                ", employeeId=" + employeeId +
                '}';
    }
}