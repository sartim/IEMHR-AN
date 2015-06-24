package com.tymevotec.iemhr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity implements OnClickListener {
	
	Button btnRegister;
	EditText etUserName, etPassword, etEmail, etFullName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		etUserName = (EditText) findViewById(R.id.rUserNameEditText);
		etPassword = (EditText) findViewById(R.id.rPasswordEditText);
		etEmail = (EditText) findViewById(R.id.rEmailEditText);
		etFullName = (EditText) findViewById(R.id.rFullNameEditText);
		btnRegister = (Button) findViewById(R.id.RegisterButton);
		
		btnRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.RegisterButton:
			
			String username = etUserName.getText().toString();
			String password = etPassword.getText().toString();
			String email = etEmail.getText().toString();
			String name = etFullName.getText().toString();
			
			User user = new User(username, password, email, name);
			
			registerUser(user);
			
			break;
		}
		
	}

	private void registerUser(User user) {
		
		ServerRequests serverRequests = new ServerRequests(this);
		serverRequests.storeUserDataInBackground(user, new GetUserCallback() {
			@Override
			public void done(User retuenedUser) {
				startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
			}
		});
	}

}
