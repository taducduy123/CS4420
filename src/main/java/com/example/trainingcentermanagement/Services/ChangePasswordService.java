package com.example.trainingcentermanagement.Services;

import com.example.trainingcentermanagement.Repository.ChangePasswordRepo;

public class ChangePasswordService {

    private final ChangePasswordRepo changePasswordRepo;
    //-----------------------------------------------------------

    public ChangePasswordService() {
        this.changePasswordRepo = new ChangePasswordRepo();
    }

    public void updateUserPasswordByUsername(String role, String username, String newPassword) {

        if(role.compareToIgnoreCase("student") == 0){
            changePasswordRepo.updateStudentPasswordByUsername(username, newPassword);
        }
        else if(role.compareToIgnoreCase("instructor") == 0){
            changePasswordRepo.updateInstructorPasswordByUsername(username, newPassword);
        }
        else if(role.compareToIgnoreCase("manager") == 0){
            changePasswordRepo.updateManagerPasswordByUsername(username, newPassword);
        }
    }
}
