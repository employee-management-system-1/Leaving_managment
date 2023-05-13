package com.example.leave.services;

import com.example.leave.beans.Leavetbl;
import com.example.leave.controllers.AddResponse;
import com.example.leave.repositories.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    public List<Leavetbl> getAllLeaves(){

        return leaveRepository.findAll();
    }

    public Leavetbl getLeavebyID(int leaveid){

        return leaveRepository.findById(leaveid).get();     // using 'get' we can get related record.
    }

    public Leavetbl getEmpbyID(String empId){

        List<Leavetbl> leaves = leaveRepository.findAll();
        Leavetbl leave = null;

        for(Leavetbl lea:leaves)   //loop
        {
            if(lea.getEmpId().equalsIgnoreCase(empId))
                leave = lea;
        }
        return leave;
    }

    public Leavetbl addLeave(Leavetbl leave){

        leave.setLeaveId(getMAxId());          //generate next id
        leaveRepository.save(leave);
        return leave;                     //save empid
    }

    //Utility method to get max id
    public int getMAxId(){

        return leaveRepository.findAll().size()+1;    //give total number of rows in a table +1
    }

    public Leavetbl updateLeave(Leavetbl leave){

        leaveRepository.save(leave);
        return leave;
    }

    public AddResponse deleteLeave(int leaveid){

        leaveRepository.deleteById(leaveid);

        AddResponse res = new AddResponse();
        res.setMsg("Leave Deleted!...");
        res.setId(leaveid);
        return res;
    }
}
