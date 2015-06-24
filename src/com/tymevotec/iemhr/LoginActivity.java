package com.tymevotec.iemhr;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener {
	
	Button btnLogin;
	EditText etUsername, etPassword;
	TextView tvRegister;
	UserLocalStore userLocalStore;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		etUsername = (EditText) findViewById(R.id.lUserNameEditText);
		etPassword = (EditText) findViewById(R.id.lPasswordEditText);
		
		tvRegister = (TextView) findViewById(R.id.RegisterTextView);
		
		btnLogin = (Button) findViewById(R.id.LoginButton);
		
		tvRegister.setOnClickListener(this);
		
		btnLogin.setOnClickListener(this);
		
		userLocalStore = new UserLocalStore(this); 
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
		case R.id.LoginButton:
			
			String username = etUsername.getText().toString();
			String password = etPassword.getText().toString();
			
			User user = new User(username, password);
			
			authenticate(user);
			
			break;
			
		case R.id.RegisterTextView:
			
			startActivity(new Intent(this, RegisterActivity.class));
			
			break;
		}
	}
		private void authenticate(User user) {
			ServerRequests serverRequests = new ServerRequests(this);
			serverRequests.fetchUserDataInBackground(user, new GetUserCallback(){
			
				@Override
				public void done(User returnedUser) {
					if (returnedUser == null) {
						showErrorMessage();
					}else{
						logUserIn(returnedUser);
					}
				}
		});
	}
		
		private void showErrorMessage() {
			AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);
			dialogBuilder.setMessage("Incorrect user details");
			dialogBuilder.setPositiveButton("OK", null);
			dialogBuilder.show();
		}
		
		private void logUserIn(User returnedUser) {
			userLocalStore.storeUserData(returnedUser);
			userLocalStore.setUserLoggedIn(true);
			
			startActivity(new Intent(this, MainActivity.class));
		}

}
