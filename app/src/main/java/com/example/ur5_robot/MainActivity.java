package com.example.ur5_robot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton connectButton = (ImageButton)findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openConnectActivity(); }
        });
        ImageButton controlsButton = (ImageButton)findViewById(R.id.controlsButton);
        controlsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openControlsActivity(); }
        });
        ImageButton commandsButton = (ImageButton)findViewById(R.id.commandsButton);
        commandsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openCommandsActivity(); }
        });
        ImageView info = (ImageView) findViewById(R.id.infoRobot);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openPDFViewer(); }
        });
    }
    public void openConnectActivity() {
        Intent intent = new Intent(this, ConnectActivity.class);
        startActivity(intent);
    }
    public void openControlsActivity() {
        Intent intent = new Intent(this, ControlsActivity.class);
        startActivity(intent);
    }
    public void openCommandsActivity() {
        Intent intent = new Intent(this, CommandsActivity.class);
        startActivity(intent);
    }
    public void openPDFViewer() {
        Intent intent = new Intent(this, PDFActivity.class);
        intent.putExtra("pdf_url", "https://www.universal-robots.com/media/50588/ur5_en.pdf");
        startActivity(intent);
    }
}