package com.example.ujjwal.broker.Login.Presenter;

import com.example.ujjwal.broker.Login.Data.LoginDataResponse;
import com.example.ujjwal.broker.Login.LoginCallback;
import com.example.ujjwal.broker.Login.Model.LoginBaseClassHelper;
import com.example.ujjwal.broker.Login.Model.RetrofitLoginHelper;

import com.example.ujjwal.broker.Login.View.LoginMain;
import com.example.ujjwal.broker.Login.View.LoginMainImp;

/**
 * Created by ujjwal on 13/10/16.
 */
public class LoginDataImp implements LoginData{
	private LoginBaseClassHelper loginBaseClassHelper;
	 private LoginMain login;

	public LoginDataImp(LoginMainImp login, RetrofitLoginHelper retrofitLoginHelper) {
		this.login=login;
		this.loginBaseClassHelper=retrofitLoginHelper;

	}


	@Override
	public void getLoginData(String mobile, final String firm, String name) {

	login.showProgressBar(true);


		loginBaseClassHelper.loginData(mobile,firm,name,new LoginCallback(){

			@Override
			public void onLoginSuccess(LoginDataResponse loginResponse) {
				login.showProgressBar(false);
				login.showLoginStatus(true);
			}

			@Override
			public void onLoginFailure(String error) {
				login.showError(error);
				login.showProgressBar(true);
				login.showLoginStatus(false);

			}
		} )
		;


	}
}
