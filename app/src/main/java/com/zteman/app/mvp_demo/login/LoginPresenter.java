/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zteman.app.mvp_demo.login;

import android.support.annotation.NonNull;

import com.zteman.app.mvp_demo.model.AccountModel;

import static android.support.v4.util.Preconditions.checkNotNull;


/**
 * Listens to user actions from the UI ({@link LoginFragment}), retrieves the data and updates
 * the UI as required.
 */
public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View mLoginView;

    public LoginPresenter(@NonNull LoginContract.View loginView) {
        mLoginView = checkNotNull(loginView, "loginView cannot be null!");

        mLoginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void login(String username, String password) {
        //模拟登录成功
        if ("zteman".equals(username) && "123".equals(password)) {
            AccountModel accountModel = new AccountModel();
            accountModel.setAccount(username);
            accountModel.setPassword(password);
            mLoginView.toMainActivity(accountModel);
        } else {
            mLoginView.showFailedError();
        }
    }
}
