package com.github.adt.startone.jakartaee.tutorials.faces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UserBean {
    private String username;
    private boolean submitted;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public String submit() {
        // ユーザ入力を処理したり、必要なアクションを実行します
        this.submitted = true;
        return null; // 同じページへ遷移し画面を更新します
    }
}
