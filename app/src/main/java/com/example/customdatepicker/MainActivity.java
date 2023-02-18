package com.example.customdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







    }




    public void showAlertDialogButtonClicked(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Date");

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.date_picker_dialogue, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("Select", (dialog, which) -> {
            // send data from the AlertDialog to the Activity
            DatePicker date = customLayout.findViewById(R.id.datePicker);
            sendDialogDataToActivity(date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear());
            //filter(editText.getText().toString());
        }).setNegativeButton("Cancel", (dialog, which) -> {
            // send data from the AlertDialog to the Activity
//            EditText editText = customLayout.findViewById(R.id.edit_search);
//            sendDialogDataToActivity(editText.getText().toString());
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Do something with the data coming from the AlertDialog
    private void sendDialogDataToActivity(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }





}