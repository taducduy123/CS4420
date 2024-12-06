package com.example.trainingcentermanagement.Services;

import com.example.trainingcentermanagement.Repository.ProfileRepo;
import com.example.trainingcentermanagement.Utils.UserContext;

public class ProfileService {

    private final ProfileRepo profileRepo;

    //----------------------------------------------------------------

    public ProfileService() {
        this.profileRepo = new ProfileRepo();
    }

    public void updateNameByRole(String role, String first_name, String middle_name, String last_name) {
        if(role.compareToIgnoreCase("student") == 0){
            profileRepo.updateStudentName(UserContext.getInstance().getUser_id(), first_name, middle_name, last_name);
        }
        else if(role.compareToIgnoreCase("instructor") == 0){
            profileRepo.updateInstructorName(UserContext.getInstance().getUser_id(), first_name, middle_name, last_name);
        }
        else if(role.compareToIgnoreCase("manager") == 0){
            profileRepo.updateManagerName(UserContext.getInstance().getUser_id(), first_name, middle_name, last_name);
        }
    }

    public void updateEmailByRole(String role, String newEmail){
        if(role.compareToIgnoreCase("student") == 0){
            profileRepo.updateStudentEmail(UserContext.getInstance().getUser_id(), newEmail);
        }
        else if(role.compareToIgnoreCase("instructor") == 0){
            profileRepo.updateInstructorEmail(UserContext.getInstance().getUser_id(), newEmail);
        }
        else if(role.compareToIgnoreCase("manager") == 0){
            profileRepo.updateManagerEmail(UserContext.getInstance().getUser_id(), newEmail);
        }
    }

    public void updatePhoneByRole(String role, String newPhone){
        if(role.compareToIgnoreCase("student") == 0){
            profileRepo.updateStudentPhone(UserContext.getInstance().getUser_id(), newPhone);
        }
        else if(role.compareToIgnoreCase("instructor") == 0){
            profileRepo.updateInstructorPhone(UserContext.getInstance().getUser_id(), newPhone);
        }
        else if(role.compareToIgnoreCase("manager") == 0){
            profileRepo.updateManagerPhone(UserContext.getInstance().getUser_id(), newPhone);
        }
    }
}
