/*
 * Copyright (C) 2015 The Android Open Source Project
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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zteman.app.mvp_demo.MainActivity;
import com.zteman.app.mvp_demo.R;
import com.zteman.app.mvp_demo.model.AccountModel;

import static android.support.v4.util.Preconditions.checkNotNull;


/**
 * Main UI for the login screen.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

    private static final String TAG = "LoginFragment";

    private LoginContract.Presenter mPresenter;

    private AppCompatEditText mAccountView;

    private AppCompatEditText mPasswordView;

    private AppCompatButton mLoginView;

    public static LoginFragment newInstance() {
        Bundle arguments = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        setHasOptionsMenu(true);
        mAccountView = (AppCompatEditText) root.findViewById(R.id.input_mobile);
        mPasswordView = (AppCompatEditText) root.findViewById(R.id.input_auth_code);
        mLoginView = (AppCompatButton) root.findViewById(R.id.btn_login);
        mLoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(getUserName(), getPassword());
            }
        });
        return root;
    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public String getUserName() {
        return mAccountView.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordView.getText().toString();
    }

    @Override
    public void toMainActivity(AccountModel accountModel) {
        getActivity().finish();
        MainActivity.actionMain(getContext(), accountModel);
    }

    @Override
    public void showFailedError() {
        Toast.makeText(getContext(), "登录失败", Toast.LENGTH_SHORT).show();
    }
}
