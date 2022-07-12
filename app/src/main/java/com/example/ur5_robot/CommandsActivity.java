package com.example.ur5_robot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CommandsActivity extends AppCompatActivity {
    static String command = null;
    TextView console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commands);

        console = (TextView) findViewById(R.id.console);
        console.setMovementMethod(new ScrollingMovementMethod());

        Button type = (Button) findViewById(R.id.type);
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (console.getText().toString().matches("")) {
                    command = GetCommand();
                    console.append(command);
                    CommandSender cs = new CommandSender();
                    cs.execute(command);
                }
                else {
                    command = GetCommand();
                    console.append("\n" + command);
                    CommandSender cs = new CommandSender();
                    cs.execute(command);
                }
            }
        });
    }
    public String GetCommand() {
        EditText commandBox = (EditText) findViewById(R.id.commandBox);
        return commandBox.getText().toString();
    }
    /*@Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("console", console.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
         String text = savedInstanceState.getString("console", null);
         console.append(text);
    }*/
}