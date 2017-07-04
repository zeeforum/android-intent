package com.example.zarta.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        String value1 = extras.getString("value1");
        if (value1 != null) {
            TextView txt = (TextView) findViewById(R.id.displayintentextra);
            txt.setText(value1);
        }
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("return_data", ((EditText) findViewById(R.id.returnValue)).getText().toString());
        setResult(RESULT_OK, data);
        super.finish();
    }
}
