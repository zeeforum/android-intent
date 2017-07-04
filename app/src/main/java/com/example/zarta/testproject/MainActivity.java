package com.example.zarta.testproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        EditText text = (EditText) findViewById(R.id.inputforintent);
        // used later
        String value = text.getText().toString();
        // TODO 1 create new Intent(context, class)
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra("value1", value);

        // TODO 2 start second activity with
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data.hasExtra("return_data")) {
                String returnValue = data.getExtras().getString("return_data");
                if (returnValue != null && returnValue.length() > 0) {
                    Toast.makeText(this, returnValue, Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void shareData(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "REPLACE WITH YOUR TEXT");
        startActivity(sharingIntent);
    }

    public void visitUrl(View view) {
        String url = "http://dailypakistani.com/";
        Intent sharingIntent = new Intent(Intent.ACTION_SEND, Uri.parse(url));
        startActivity(sharingIntent);
    }
}
