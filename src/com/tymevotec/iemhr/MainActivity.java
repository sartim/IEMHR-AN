package com.tymevotec.iemhr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	Button btnLogout;
	EditText etUserName, etEmail, etFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etUserName = (EditText) findViewById(R.id.UserNameEditText);
		etEmail = (EditText) findViewById(R.id.EmailEditText);
		etFullName = (EditText) findViewById(R.id.FullNameEditText);
		btnLogout = (Button) findViewById(R.id.LogoutButton);
		
		btnLogout.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
			case R.id.LogoutButton:
				
				startActivity(new Intent(this, LoginActivity.class));
				
			break;
		
		}
		
	}
    
}
