package com.example.trainingcentermanagement.Repository;

import com.example.trainingcentermanagement.Controller.BillingController;
import com.example.trainingcentermanagement.Model.Billing;
import com.example.trainingcentermanagement.Model.Course;
import com.example.trainingcentermanagement.Utils.DBConnect;

import java.util.ArrayList;
import java.util.List;

public class BillingRepo {

    private DBConnect dbConnect = DBConnect.getInstance();

    //----------------------------------------------------------------

    public BillingRepo() {

    }


    public List<Billing> getBillBy(String student_id){
        List<Billing> list = new ArrayList<>();

        String sql = """
                        with session_attendances_student_x as
                         	(select *
                              from stu_attend
                              where student_id = ?
                         	 ),
                         info_student_x as
                             (select *
                              from student
                              where student_id = ?
                              )
                         select   i.student_id,
                                  i.first_name,
                                  i.middle_name,
                                  i.last_name,
                                  c.course_id,
                                  c.name as course_name,
                                  c.rate as course_rate,
                         	  sum(case
                         			when sa.check_attend = true then 1
                                    else 0
                                   end
                         		  ) as numAttend,
                         	   (c.rate * sum(case
                         						when sa.check_attend = true then 1
                         						else 0
                         					 end)
                         		) as total
                         from session_attendances_student_x sa,
                         	  info_student_x i,
                              session se,
                              course c
                         where (sa.session_id, se.course_id) = (se.session_id, c.course_id)
                         group by c.course_id,
                                  i.student_id,
                                  i.first_name,
                                  i.middle_name,
                                  i.last_name,
                                  c.name,
                                  c.rate
                         order by c.course_id;
                     """;

        list = dbConnect.executeReturnQuery(sql, Billing.class, student_id, student_id);
        return list;
    }


    public List<Course> getCourseBy(String student_id){
        List<Course> list = new ArrayList<>();

        String sql = """
                        select c.*
                        from course c, registers r
                        where (c.course_id, r.student_id) = (r.course_id, ?)
                     """;

        list = dbConnect.executeReturnQuery(sql, Course.class, student_id);
        return list;
    }



    // Embedded Main for testing
    public static void main(String[] args) {
        BillingRepo billingRepo = new BillingRepo();
        List<Billing> list = billingRepo.getBillBy("1");

        for(Billing bill : list){
            System.out.println(bill);
        }
    }
}
