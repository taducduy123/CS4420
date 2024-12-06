package com.example.trainingcentermanagement.Services;

import com.example.trainingcentermanagement.Model.Billing;
import com.example.trainingcentermanagement.Model.Payroll;
import com.example.trainingcentermanagement.Repository.PayrollRepo;

import java.util.List;

public class PayrollService {

    PayrollRepo payrollRepo;

    //----------------------------------------------------


    public PayrollService(){
        this.payrollRepo = new PayrollRepo();
    }

    public List<Payroll> getPayrollBy(String instructor_id) {
        return payrollRepo.getPayrollBy(instructor_id);
    }

    public boolean checkPayrollExistFor(String instructor_id){
        if(payrollRepo.getCourseTaughtBy(instructor_id).isEmpty()){
            return false;
        }
        return true;
    }
}
