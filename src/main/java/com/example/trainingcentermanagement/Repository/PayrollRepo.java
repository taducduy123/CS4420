package com.example.trainingcentermanagement.Repository;

import com.example.trainingcentermanagement.Controller.PayrollController;
import com.example.trainingcentermanagement.Model.Payroll;
import com.example.trainingcentermanagement.Model.Course;
import com.example.trainingcentermanagement.Utils.DBConnect;

import java.util.ArrayList;
import java.util.List;

public class PayrollRepo {

    private DBConnect dbConnect = DBConnect.getInstance();
    
    
    
    //---------------------------------------------------------------
    
    public PayrollRepo(){
        
    }

    public List<Payroll> getPayrollBy(String instructor_id){
        List<Payroll> list = new ArrayList<>();

        String sql = """
                        with session_attendances_instructor_x as
                         	(select *
                              from ins_attend
                              where instructor_id = ?
                         	 ),
                         info_instructor_x as
                             (select *
                              from instructor
                              where instructor_id = ?
                              )
                         select   i.instructor_id,
                                  i.first_name,
                                  i.middle_name,
                                  i.last_name,
                                  i.level,
                                  c.course_id,
                                  c.name as course_name,
                                  c.rate as course_rate,
                         	  sum(case
                         			when sa.check_attend = true then 1
                                    else 0
                                   end
                         		  ) as numAttend,
                         	   (c.rate * i.level * sum(case
                         						        when sa.check_attend = true then 1
                         						        else 0
                         					           end)
                         		) as total
                         from session_attendances_instructor_x sa,
                         	  info_instructor_x i,
                              session se,
                              course c
                         where (sa.session_id, se.course_id) = (se.session_id, c.course_id)
                         group by c.course_id,
                                  i.instructor_id,
                                  i.first_name,
                                  i.middle_name,
                                  i.last_name,
                                  i.level,
                                  c.name,
                                  c.rate
                         order by c.course_id;
                     """;

        list = dbConnect.executeReturnQuery(sql, Payroll.class, instructor_id, instructor_id);
        return list;
    }


    public List<Course> getCourseTaughtBy(String instructor_id){
        List<Course> list = new ArrayList<>();

        String sql = """
                        select c.*
                        from course c, teaches t
                        where (c.course_id, t.instructor_id) = (t.course_id, ?)
                     """;

        list = dbConnect.executeReturnQuery(sql, Course.class, instructor_id);
        return list;
    }



    // Embedded Main for testing
    public static void main(String[] args) {
        PayrollRepo payrollRepo = new PayrollRepo();
        List<Payroll> list = payrollRepo.getPayrollBy("1");

        for(Payroll payroll : list){
            System.out.println(payroll);
        }
    }
}
