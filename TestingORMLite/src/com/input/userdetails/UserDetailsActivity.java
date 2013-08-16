package com.input.userdetails;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Sample Android UI activity which displays a text window when it is run.
 */
public class UserDetailsActivity extends OrmLiteBaseActivity<DBHelper> {

	private final String LOG_TAG = getClass().getSimpleName();

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(LOG_TAG, "creating " + getClass() + " at " + System.currentTimeMillis());
		TextView tv = new TextView(this);
		doSampleDatabaseStuff("onCreate", tv);
		setContentView(tv);
	}

	/**
	 * Do our sample database stuff.
	 */
	private void doSampleDatabaseStuff(String action, TextView tv) {
		// get our dao
		RuntimeExceptionDao<UserDetails, Integer> simpleDao = getHelper().getSimpleDataDao();
		// query for all of the data objects in the database
		List<UserDetails> list = simpleDao.queryForAll();
		// our string builder for building the content-view
		StringBuilder sb = new StringBuilder();
		sb.append("got ").append(list.size()).append(" entries in ").append(action).append("\n");

		// if we already have items in the database
		int simpleC = 0;
		for (UserDetails simple : list) {
			sb.append("------------------------------------------\n");
			sb.append("[").append(simpleC).append("] = ").append(simple).append("\n");
			simpleC++;
		}
		sb.append("------------------------------------------\n");
		for (UserDetails simple : list) {
			simpleDao.delete(simple);
			sb.append("deleted id ").append(simple.id).append("\n");
			Log.i(LOG_TAG, "deleting simple(" + simple.id + ")");
			simpleC++;
		}

		tv.setText(sb.toString());
		Log.i(LOG_TAG, "Done with page at " + System.currentTimeMillis());
	}
}