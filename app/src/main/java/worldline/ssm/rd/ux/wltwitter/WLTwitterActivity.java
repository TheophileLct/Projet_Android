package worldline.ssm.rd.ux.wltwitter;

import androidx.appcompat.app.AppCompatActivity;

import worldline.ssm.rd.ux.wltwitter.utils.Constants;
import worldline.ssm.rd.ux.wltwitter.utils.PreferenceUtils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class WLTwitterActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.logoutButton).setOnClickListener(this);

        if(intentLoading() == true)
            return;

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("fileName", Context.MODE_PRIVATE);
        String login = prefs.getString("username", "");
        if (login == "")
            return;
        getActionBar().setSubtitle(login);

        /*

        Intent fromIntent = getIntent();
        String username ="";

        if(fromIntent != null){
            if(fromIntent.getExtras() != null) {
                username = fromIntent.getExtras().getString(Constants.Login.EXTRA_LOGIN);
            }
            getSupportActionBar().setTitle(username);
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected boolean intentLoading()
    {
        String login = getIntent().getExtras().getString("username");
        if(login == null)
            return false;
        getSupportActionBar().setTitle(login);

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("fileName", Context.MODE_PRIVATE);
        prefs.edit().putString("username", login).commit();
        return true;
    }


    @Override
    public void onClick(View v) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("fileName", Context.MODE_PRIVATE);
        prefs.edit().putString("username", "").commit();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
