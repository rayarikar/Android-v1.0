package com.input.userdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class UserDetailsInputActivity extends OrmLiteBaseActivity<DBHelper> {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_details_input);
	}

	public void onNextClick(View v) {

		EditText firstNameEditText = (EditText) findViewById(R.id.firstName);
		String firstName = firstNameEditText.getText().toString();

		EditText lastNameEditText = (EditText) findViewById(R.id.lastName);
		String lastName = lastNameEditText.getText().toString();

		EditText emailIdEditText = (EditText) findViewById(R.id.emailId);
		String emailId = emailIdEditText.getText().toString();

		EditText passwordEditText = (EditText) findViewById(R.id.password);
		String password = passwordEditText.getText().toString();
		
		createUser(firstName, lastName, emailId, password);
		
		Intent intent = new Intent(this, UserDetailsActivity.class);
        startActivity(intent);      
        finish();

	}

	public void createUser(String fn, String ln, String emailId, String pass) {
		// here we try inserting data in the on-create as a test
		RuntimeExceptionDao<UserDetails, Integer> dao = getHelper().getSimpleDataDao();
		// create some entries in the onCreate
		UserDetails simple = new UserDetails(fn, ln,
				emailId, pass);
		dao.create(simple);
	}

}
