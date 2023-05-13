package com.example.leave.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Leavetbl")
public class Leavetbl {

    @Id
    @Column(name = "leave_id")
    int leaveId;

    @Column(name = "emp_id")
    String empId;

    @Column(name = "start_date")
    String startDate;

    @Column(name = "end_date")
    String endDate;

    @Column(name = "leave_type")
    String leaveType;

    @Column(name = "reason")
    String reason;

    public Leavetbl(){

    }

    public Leavetbl(int leaveId, String empId, String startDate, String endDate, String leaveType, String reason) {
        this.leaveId = leaveId;
        this.empId = empId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.reason = reason;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
