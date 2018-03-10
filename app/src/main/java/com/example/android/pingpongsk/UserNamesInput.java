package com.example.android.pingpongsk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UserNamesInput extends AppCompatActivity {
    // Initialize the user names Edit texts objects.
    EditText leftName, rightName;
    // Initialize the Start button object.
    Button start;
    // Initialize LinearLayout object.
    LinearLayout logoLv, startLv;
    // Initialize the animation objects.
    Animation upToDown, downToUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_names_input);
        // Assign the LinearLayout views to be animated to their ids in the activity_user_names_input.xml file.
        logoLv = findViewById(R.id.welcome_logo);
        startLv = findViewById(R.id.user_start_lv);
        // Load animations from anim folder in resources.
        upToDown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downToUp = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        // Assign animation to each view object.
        logoLv.setAnimation(upToDown);
        startLv.setAnimation(downToUp);
        // Assign the user Edit text views to their id in the activity_user_names_input.xml file.
        leftName = findViewById(R.id.left_name);
        rightName = findViewById(R.id.right_name);
        // Assign the Start button to its id in the activity_user_names_input.xml file.
        start = findViewById(R.id.startBtn);
        // Set OnClickListener to the start button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the EditText Views empty then
                if ((leftName.getText().toString().trim().equals(""))
                        || rightName.getText().toString().trim().equals("")) {
                    // Show warning Toast
                    Toast.makeText(getApplicationContext(), "One OR Both Names Are Empty!", Toast.LENGTH_SHORT).show();
                } else {
                    // Initialize an intent to pass user sides names to MainActivity.
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    // Save what user entered in the Edit Text Views in 2 keys to be called in the MainActivity class.
                    intent.putExtra("LEFT INPUT", leftName.getText().toString());
                    intent.putExtra("RIGHT INPUT", rightName.getText().toString());
                    // Start the MainActivity class.
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    // Overriding the onBackPressed method to show a "Close App" AlertDialog with Yes & No buttons.
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder closeAppDialog = new AlertDialog.Builder(UserNamesInput.this);
        // Setting Dialog Title.
        closeAppDialog.setTitle(R.string.close_the_app);
        // Setting Dialog Message.
        closeAppDialog.setMessage("Won't you play now ?");
        // Setting Icon to Dialog.
        closeAppDialog.setIcon(R.drawable.ppsk_logo);
        // Setting Positive "Yes" Btn.
        closeAppDialog.setPositiveButton(R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        // Congratulations dialog toast.
                        Toast.makeText(getApplicationContext(),
                                R.string.bye_bye, Toast.LENGTH_LONG)
                                .show();
                    }
                })
                // Setting Negative "No" Btn.
                .setNegativeButton(R.string.no,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Congratulations dialog toast.
                                Toast.makeText(getApplicationContext(),
                                        "So, Enter the 2 sides Names", Toast.LENGTH_LONG)
                                        .show();
                                dialog.dismiss();
                            }
                        });
        // Showing Alert Dialog.
        closeAppDialog.show();
    }
}
