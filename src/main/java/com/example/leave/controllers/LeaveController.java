package com.example.leave.controllers;

import com.example.leave.beans.Leavetbl;
import com.example.leave.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @GetMapping("/getleaves")
    public List<Leavetbl> getLeaves(){

        return leaveService.getAllLeaves();
    }

    @GetMapping("/getleaves/{leaveid}")
    public ResponseEntity<Leavetbl> getLeaveById(@PathVariable(value = "leaveid")int leaveId){

        try {
            Leavetbl leave = leaveService.getLeavebyID(leaveId);
            return new ResponseEntity<Leavetbl>(leave, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getleaves/empid")
    public ResponseEntity<Leavetbl> getEmpByID(@RequestParam(value = "empid")String empId){

        try {
            Leavetbl leave = leaveService.getEmpbyID(empId);
            return new ResponseEntity<Leavetbl>(leave,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/addleave")
    public Leavetbl addLeave(@RequestBody Leavetbl leave){

        return leaveService.addLeave(leave);
    }

    @PutMapping("/updateleave/{leaveid}")
    public ResponseEntity<Leavetbl> updateLeavey(@PathVariable(value = "leaveid") int leaveId, @RequestBody Leavetbl leave){

        try {

            Leavetbl existLeave = leaveService.getLeavebyID(leaveId);

            existLeave.setEmpId(leave.getEmpId());
            existLeave.setStartDate(leave.getStartDate());
            existLeave.setEndDate(leave.getEndDate());
            existLeave.setLeaveType(leave.getLeaveType());
            existLeave.setReason(leave.getReason());


            Leavetbl updated_leave = leaveService.updateLeave(existLeave);
            return new ResponseEntity<Leavetbl>(updated_leave, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping("/deleteleave/{leaveid}")
    public AddResponse deleteCountry(@PathVariable(value = "leaveid")int leaveId){

        return leaveService.deleteLeave(leaveId);
    }

}
