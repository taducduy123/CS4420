package com.example.trainingcentermanagement.Services;

import com.example.trainingcentermanagement.Repository.ForgotPasswordRepo;

public class ForgotPasswordService {

    private final ForgotPasswordRepo forgotPasswordRepo;
    //--------------------------------------------------------

    public ForgotPasswordService() {
        forgotPasswordRepo = new ForgotPasswordRepo();
    }


    public boolean checkMatching(String role, String username, String email) {
        boolean isMatching = false;

        switch (role) {
            case "student":
                if (forgotPasswordRepo.getStudentBy_UsernameAndEmail(username, email) != null) {
                    isMatching = true;
                }
                break;

            case "instructor":
                if (forgotPasswordRepo.getInstructorBy_UsernameAndEmail(username, email) != null) {
                    isMatching = true;
                }
                break;

            case "manager":
                if (forgotPasswordRepo.getManagerBy_UsernameAndEmail(username, email) != null) {
                    isMatching = true;
                }
                break;
        }
        return isMatching;
    }


    public void resetUserPassword(String role, String username, String newPassword) {
        switch (role) {
            case "student":
                forgotPasswordRepo.updateStudentPassword(username, newPassword);
                break;

            case "instructor":
                forgotPasswordRepo.updateInstructorPassword(username, newPassword);
                break;

            case "manager":
                forgotPasswordRepo.updateManagerPassword(username, newPassword);
                break;
        }
    }
}
