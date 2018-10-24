package com.example.nikhar.mst04v10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Modes extends AppCompatActivity {

    private Button recordAndAnnnotateButton, auditButton;
    private CheckBox speechCheckBox, videoCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes);

        recordAndAnnnotateButton = this.findViewById(R.id.buttonRecordAndAnnotate);
        auditButton = this.findViewById(R.id.buttonAudit);
        speechCheckBox = this.findViewById(R.id.checkBoxSpeech);
        videoCheckBox = this.findViewById(R.id.checkBoxVideo);

        recordAndAnnnotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(speechCheckBox.isChecked()){
                    Intent recordIntent = new Intent(Modes.this,RecordActivity.class);
                    startActivity(recordIntent);
                }
                else if(videoCheckBox.isChecked()){
                    Intent recordIntent = new Intent(Modes.this,VideoRecordActivity.class);
                    startActivity(recordIntent);
                }
                else {
                    Toast.makeText(Modes.this, "Please select speech or video", Toast.LENGTH_LONG).show();
                }
            }
        });

        auditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(speechCheckBox.isChecked()){
                    Intent auditIntent = new Intent(Modes.this,AuditSpeechActivity.class);
                    startActivity(auditIntent);
                }
                else if(videoCheckBox.isChecked()){
                    Intent auditIntent = new Intent(Modes.this,VideoAuditActivity.class);
                    startActivity(auditIntent);
                }
                else {
                    Toast.makeText(Modes.this, "Please select speech or video", Toast.LENGTH_LONG).show();
                }
            }
        });

        speechCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoCheckBox.setChecked(false);
            }
        });

        videoCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speechCheckBox.setChecked(false);
            }
        });
    }
}