package com.example.financetracker;

import directories.UserDirectory;
import javafx.stage.Stage;

public class AccountController {

    UserDirectory userDirectory;
    Stage stage;
    public AccountController(UserDirectory userDirectory, Stage stage, String vignesh) {
        this.stage = stage;
        this.userDirectory = userDirectory;
    }
}
