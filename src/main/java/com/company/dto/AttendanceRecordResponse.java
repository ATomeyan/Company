package com.company.dto;

import com.company.model.AttendanceRecord;

import java.util.List;

public class AttendanceRecordResponse extends SingleResponse{

    private List<AttendanceRecord> attendanceRecords;

    public List<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }
}