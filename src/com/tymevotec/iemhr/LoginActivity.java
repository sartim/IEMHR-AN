package com.tymevotec.iemhr;

import android.os.Bundle;
import android.app.Activity;
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
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
		case R.id.LoginButton:
			
			break;
			
		case R.id.RegisterTextView:
			
			startActivity(new Intent(this, RegisterActivity.class));
			
			break;
		}
		
	}

}
