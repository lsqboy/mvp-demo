package com.zteman.app.mvp_demo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lsqboy on 2017/9/13.
 */

public class AccountModel implements Parcelable{

    public AccountModel() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String account;
    private String password;

    protected AccountModel(Parcel in) {
        account = in.readString();
        password = in.readString();
    }

    public static final Creator<AccountModel> CREATOR = new Creator<AccountModel>() {
        @Override
        public AccountModel createFromParcel(Parcel in) {
            return new AccountModel(in);
        }

        @Override
        public AccountModel[] newArray(int size) {
            return new AccountModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(account);
        parcel.writeString(password);
    }
}
