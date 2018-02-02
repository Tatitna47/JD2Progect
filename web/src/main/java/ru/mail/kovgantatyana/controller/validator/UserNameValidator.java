package ru.mail.kovgantatyana.controller.validator;

import java.util.List;

public class UserNameValidator {
    public static List<String> checkUserName(String un, String pw, List<String> errors) {
        String username = un.trim();
        String password = pw.trim();

        if (username.length() > 20) {
            errors.add("Length of username is not valid. Need les then 20 symbols");
        }

        if (username.length() < 1) {
            errors.add("You didn't enter name");
        } else {
            int countSpacesInName = 0;
            for (int i = 0; i < username.length(); i++) {
                int index = username.indexOf(" ", i);
                if (index != -1) {
                    countSpacesInName++;
                    i = index;
                } else {
                    break;
                }
            }
            if (countSpacesInName == username.length()) {
                errors.add("Name can't contain only spaces");
            }
        }

        if (password.length() < 1) {
            errors.add("You didn't enter password");
        } else {
            int countSpacesInPassword = 0;
            for (int i = 0; i < password.length(); i++) {
                int index = password.indexOf(" ", i);
                if (index != -1) {
                    countSpacesInPassword++;
                    i = index;
                } else {
                    break;
                }
            }
            if (countSpacesInPassword == password.length()) {
                errors.add("Password can't contain only spaces");
            }
        }

        return errors;
    }
}
