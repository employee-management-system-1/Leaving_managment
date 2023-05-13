package com.example.leave.repositories;

import com.example.leave.beans.Leavetbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leavetbl, Integer>       //<bean class name, table primary key data type>
                                                                                // this class automatically get all data from the database.
{

}
