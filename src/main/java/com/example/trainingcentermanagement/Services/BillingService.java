package com.example.trainingcentermanagement.Services;

import com.example.trainingcentermanagement.Model.Billing;
import com.example.trainingcentermanagement.Repository.BillingRepo;

import java.util.List;

public class BillingService {

    private  BillingRepo billingRepo;

    //------------------------------------------------------------------

    public BillingService() {
        this.billingRepo = new BillingRepo();
    }

    public List<Billing> getBillBy(String studentID) {
        return billingRepo.getBillBy(studentID);
    }

    public boolean checkBillExistFor(String student_id){
        if(billingRepo.getCourseBy(student_id).isEmpty()){
            return false;
        }
        return true;
    }

}
