package com.example.trainingcentermanagement.Services;

import com.example.trainingcentermanagement.Repository.ChangePasswordRepo;

public class ChangePasswordService {

    private ChangePasswordRepo changePasswordRepo;
    //-----------------------------------------------------------

    public ChangePasswordService() {
        this.changePasswordRepo = new ChangePasswordRepo();
    }
}
