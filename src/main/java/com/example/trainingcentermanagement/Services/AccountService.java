package com.example.trainingcentermanagement.Services;

import com.example.trainingcentermanagement.Model.Account;
import com.example.trainingcentermanagement.Model.Instructor;
import com.example.trainingcentermanagement.Model.Manager;
import com.example.trainingcentermanagement.Model.Student;
import com.example.trainingcentermanagement.Repository.AccountRepo;
import com.example.trainingcentermanagement.Utils.UserContext;

public class AccountService {

    private final AccountRepo accountRepo;

    //---------------------------------------

    public AccountService() {
        accountRepo = new AccountRepo();
    }


    public boolean checkLoginSuccess(Account account) {
        boolean isSuccess = false;

        switch (account.getRole()) {
            case "student":
                Student student = accountRepo.getStudentBy_UsernameAndPassword(account.getUsername(), account.getPassword());
                System.out.println(student);
                if (student != null) {
                    isSuccess = true;

                    // Store authorized user details
                    UserContext.getInstance().setRole("student");
                    UserContext.getInstance().setUsername(account.getUsername());
                    UserContext.getInstance().setPassword(account.getPassword());
                    UserContext.getInstance().setUser_id(student.getStudent_id());
                    UserContext.getInstance().setFirst_name(student.getFirst_name());
                    UserContext.getInstance().setMiddle_name(student.getMiddle_name());
                    UserContext.getInstance().setLast_name(student.getLast_name());
                    UserContext.getInstance().setEmail(student.getEmail());
                    UserContext.getInstance().setPhone(student.getPhone());
                }
                break;

            case "instructor":
                Instructor instructor = accountRepo.getInstructorBy_UsernameAndPassword(account.getUsername(), account.getPassword());
                System.out.println(instructor);
                if (instructor != null) {
                    isSuccess = true;

                    // Store authorized user details
                    UserContext.getInstance().setRole("instructor");
                    UserContext.getInstance().setUsername(account.getUsername());
                    UserContext.getInstance().setPassword(account.getPassword());
                    UserContext.getInstance().setUser_id(instructor.getInstructor_id());
                    UserContext.getInstance().setFirst_name(instructor.getFirst_name());
                    UserContext.getInstance().setMiddle_name(instructor.getMiddle_name());
                    UserContext.getInstance().setLast_name(instructor.getLast_name());
                    UserContext.getInstance().setEmail(instructor.getEmail());
                    UserContext.getInstance().setPhone(instructor.getPhone());
                }
                break;

            case "manager":
                Manager manager = accountRepo.getManagerBy_UsernameAndPassword(account.getUsername(), account.getPassword());
                System.out.println(manager);
                if (manager != null) {
                    isSuccess = true;

                    // Store authorized user details
                    UserContext.getInstance().setRole("manager");
                    UserContext.getInstance().setUsername(account.getUsername());
                    UserContext.getInstance().setPassword(account.getPassword());
                    UserContext.getInstance().setUser_id(manager.getManager_id());
                    UserContext.getInstance().setFirst_name(manager.getFirst_name());
                    UserContext.getInstance().setMiddle_name(manager.getMiddle_name());
                    UserContext.getInstance().setLast_name(manager.getLast_name());
                    UserContext.getInstance().setEmail(manager.getEmail());
                    UserContext.getInstance().setPhone(manager.getPhone());
                }
                break;

            default:
                break;

        }

        return isSuccess;
    }


}
