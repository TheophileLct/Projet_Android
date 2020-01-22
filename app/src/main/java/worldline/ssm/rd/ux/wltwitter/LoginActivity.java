package worldline.ssm.rd.ux.wltwitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import worldline.ssm.rd.ux.wltwitter.utils.Constants;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        findViewById(R.id.loginButton).setOnClickListener(this);

        SharedPreferences prefs = getApplicationContext().getSharedPreferences("fileName", Context.MODE_PRIVATE);
        String login = prefs.getString("username", "");
        if(login != "")
            startActivity(getHomeIntent(login));
        /*
        Button loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(this);*/
    }

    @Override
    public void onClick(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        if (TextUtils.isEmpty(usernameEditText.getText())) {
            Toast.makeText(getApplicationContext(), getText(R.string.username_empty_error), Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(passwordEditText.getText())) {
            Toast.makeText(getApplicationContext(), getText(R.string.password_empty_error), Toast.LENGTH_LONG).show();
            return;
        }

        startActivity(getHomeIntent(usernameEditText.getText().toString()));
    }
    private Intent getHomeIntent(String userName){
        final Intent homeIntent = new Intent (this,WLTwitterActivity.class);
        final Bundle extras = new Bundle();
        extras.putString("username", userName);
        homeIntent.putExtras(extras);
        return homeIntent;
    }

}
