package com.example.android.pingpongsk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Declaring the pre wining point and assign the value to 20.
    public static int maxMatchScore = 20;
    public TextView leftScoreTv;
    public TextView rightScoreTv;
    // Declaring some objects like TextViews, LinearLayout, Animation, ImageButton, Boolean.,.. etc.
    TextView leftName;
    TextView rightName;
    TextView leftWrongTv;
    TextView rightWrongTv;
    LinearLayout leftSideLinearViewObj;
    LinearLayout rightSideLinearViewObj;
    Animation leftToRightAnimationObj;
    Animation rightToLeftAnimationObj;
    Animation leftRToLeftAnimationObj;
    Animation rightLToRightAnimationObj;
    ImageButton swap;
    ImageButton reset;
    ImageButton standings;
    ImageButton incLeft;
    ImageButton decLeft;
    ImageButton incRight;
    ImageButton decRight;
    Button leftWrong;
    Button rightWrong;
    Boolean leftIsLeft = true;
    int leftMatchScore;
    int rightMatchScore;
    int leftWrongScore;
    int rightWrongScore;
    // For the reset & standings popup windows declaring the popup window objects,
    // Context variable,
    // The activity variable "which will be the bkg for the reset popup window,
    // The main parent RelativeLayout view group.
    PopupWindow resetPopupWindow;
    Context mContext;
    Activity mActivity;
    RelativeLayout mainParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create an object to the tool bar and assign it to the id in the activity_main.xml THEN
        // set the suport to it as an action bar.
        Toolbar toolbar = findViewById(R.id.tool_bar_view);
        setSupportActionBar(toolbar);
        /*
        Assign the leftName & tightName TV objects to their ids in the activity_main.xml THEN:
        Use the setSelected method So keep the names mooves inside their bkg,
        Create a Bundle of sidesNamesBundle to get the extra data in the intent in the UserNamesInput.java class AND:
        If the bundle NOT null THEN:
        Create 2 String objects by getting the Strings inside the sidesNamesBundle with the assigned key for each side THEN:
        Use .setText method on the side names TVs with the keys values inside the 2 String objects.
         */
        leftName = findViewById(R.id.left_name_tv);
        findViewById(R.id.left_name_tv).setSelected(true);
        rightName = findViewById(R.id.right_name_tv);
        findViewById(R.id.right_name_tv).setSelected(true);
        Bundle sidesNamesBundle = getIntent().getExtras();
        if (sidesNamesBundle != null) {
            String leftInput = sidesNamesBundle.getString("LEFT INPUT");
            leftName.setText(leftInput);
            String rightInput = sidesNamesBundle.getString("RIGHT INPUT");
            rightName.setText(rightInput);

        }
        /*
        Here are the Swap button code for the animation by:
        Assigning the 2 text views objects to their id in the activity_main.xml AND:
         Assigning the 2 animation objects to the animation sets @ the anim folder AND:
         Assigning the swap button object to the swap button view in the activity_main.xml THEN:
         Setting an on click listenet with a new View AND:
          If:
          leftIsLeft Boolean object is true:
           Make the Boolean value to false &
           Start the left to right anim FOR the left LinearLayout
           Start the right to left anim FOR the right LinearLayout
          else:
          Back the Boolean value to true &
           Start the left to left anim FOR the left LinearLayout
           Start the right to right anim FOR the right LinearLayout
         */
        leftSideLinearViewObj = findViewById(R.id.left_linear_view);
        rightSideLinearViewObj = findViewById(R.id.right_linear_view);
        leftToRightAnimationObj = AnimationUtils.loadAnimation(this, R.anim.left_ltor);
        leftRToLeftAnimationObj = AnimationUtils.loadAnimation(this, R.anim.left_rtol);
        rightToLeftAnimationObj = AnimationUtils.loadAnimation(this, R.anim.right_rtol);
        rightLToRightAnimationObj = AnimationUtils.loadAnimation(this, R.anim.right_ltor);
        swap = findViewById(R.id.swap_btn);
        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftIsLeft) {
                    leftIsLeft = false;
                    leftSideLinearViewObj.startAnimation(leftToRightAnimationObj);
                    rightSideLinearViewObj.startAnimation(rightToLeftAnimationObj);
                } else {
                    leftIsLeft = true;
                    leftSideLinearViewObj.startAnimation(leftRToLeftAnimationObj);
                    rightSideLinearViewObj.startAnimation(rightLToRightAnimationObj);
                }
            }
        });
        // Assigning the m Context & Activity variables to the needed values to be used in the reset popup Inflater object.
        mContext = getApplicationContext();
        mActivity = MainActivity.this;
        // Assigning the mainParent view group object to the id in the activity_main.xml.
        mainParent = findViewById(R.id.main_parent_layout);
        reset = findViewById(R.id.reset_btn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize a new instance of LayoutInflater service
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                // Inflate the custom layout/view
                assert inflater != null;
                @SuppressLint("InflateParams") View resetView = inflater.inflate(R.layout.reset_popup, null);
                setTheme(R.style.Theme_AppCompat_Dialog);
                /*
                public PopupWindow (View contentView, int width, int height)
                Create a new non focusable popup window which can display the contentView.
                The dimension of the window must be passed to this constructor.
                The popup does not provide any background. This should be handled by
                the content view.
                    Parameters
                        contentView : the popup's content
                        width : the popup's width
                        height : the popup's height
                */
                // Initialize a new instance of popup window
                resetPopupWindow = new PopupWindow(
                        resetView,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                // Set an elevation value for popup window if android system less than 21V
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    resetPopupWindow.setElevation(5.0f);
                }
                // reset both sides to 15
                Button resetToFifteen = resetView.findViewById(R.id.fifteen_for_both);
                resetToFifteen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        leftMatchScore = 15;
                        rightMatchScore = 15;
                        displayForLeft(leftMatchScore);
                        displayForRight(rightMatchScore);
                        resetPopupWindow.dismiss();
                    }
                });
                // reset both sides to 17
                Button resetToSeventeen = resetView.findViewById(R.id.seventeen_for_both);
                resetToSeventeen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        leftMatchScore = 17;
                        rightMatchScore = 17;
                        displayForLeft(leftMatchScore);
                        displayForRight(rightMatchScore);
                        resetPopupWindow.dismiss();
                    }
                });
                // reset both sides to 0
                Button resetToZero = resetView.findViewById(R.id.zero_for_both);
                resetToZero.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        leftMatchScore = 0;
                        rightMatchScore = 0;
                        displayForLeft(leftMatchScore);
                        displayForRight(rightMatchScore);
                        resetPopupWindow.dismiss();
                    }
                });
                // Back button
                Button back = resetView.findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resetPopupWindow.dismiss();
                    }
                });
                /*
                public void showAtLocation (View parent, int gravity, int x, int y)
                Display the content view in a popup window at the specified location. If the
                popup window cannot fit on screen, it will be clipped.
                (((I NEED TO Learn MORE ABOUT WindowManager.LayoutParams for more information on how gravity and the x
                and y parameters are related.)))
                Specifying a gravity of NO_GRAVITY is similar to specifying Gravity.LEFT | Gravity.TOP.
                    Parameters
                        parent : a parent view to get the getWindowToken() token from
                        gravity : the gravity which controls the placement of the popup window
                        x : the popup's x location offset
                        y : the popup's y location offset
                */
                // Finally, show the popup window at the center location of root relative layout
                resetPopupWindow.showAtLocation(mainParent, Gravity.CENTER, 0, 0);
            }
        });
        // Assigning the values of all buttons.
        incLeft = findViewById(R.id.inc_left_one);
        decLeft = findViewById(R.id.dec_left_one);
        incRight = findViewById(R.id.inc_right_one);
        decRight = findViewById(R.id.dec_right_one);
        leftScoreTv = findViewById(R.id.left_score_tv);
        rightScoreTv = findViewById(R.id.right_score_tv);
        // Assigning the wrong tvs.
        leftWrongTv = findViewById(R.id.left_wrong_tv);
        rightWrongTv = findViewById(R.id.right_wrong_tv);
        // Assigning the wrong btns THEN thier on click listeners.
        leftWrong = findViewById(R.id.left_wrong_btn);
        rightWrong = findViewById(R.id.right_wrong_btn);
        leftWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftWrongScore++;
                displayLeftWrongs(leftWrongScore);
                rightMatchScore++;
                displayForRight(rightMatchScore);
            }
        });
        rightWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightWrongScore++;
                displayRightWrongs(rightWrongScore);
                leftMatchScore++;
                displayForLeft(leftMatchScore);
            }
        });
        // Left side increment button
        incLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftMatchScore >= maxMatchScore) {
                    // Confirmation AlertDialog builder "So when user press No left score back to 20"
                    AlertDialog.Builder isLeftWonDialog = new AlertDialog.Builder(MainActivity.this);
                    // Setting Dialog Title.
                    isLeftWonDialog.setTitle("");
                    // Setting Dialog Message, "I used the Activity.this.getString() method to avoid showing numbers instead of the string resources.
                    isLeftWonDialog.setMessage(MainActivity.this.getString(R.string.is) + "\u0020" + leftName.getText().toString() + "\u0020" + MainActivity.this.getString(R.string.won));
                    // Setting Icon to Dialog.
                    isLeftWonDialog.setIcon(R.drawable.ppsk_logo);
                    // Setting Positive "Yes" Btn.
                    isLeftWonDialog.setPositiveButton(R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent newGame = new Intent(getApplicationContext(), UserNamesInput.class);
                                    startActivity(newGame);
                                    // TO DO will reset all scores values to Zero.
                                    finish();
                                    // Congratulations dialog toast.
                                    Toast.makeText(getApplicationContext(),
                                            R.string.New_Names_Needed_To_Start, Toast.LENGTH_LONG)
                                            .show();
                                }
                            })
                            // Setting Negative "No" Btn.
                            .setNegativeButton(R.string.no,
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            leftMatchScore--;
                                            displayForLeft(leftMatchScore);
                                        }
                                    });
                    // Showing Alert Dialog.
                    isLeftWonDialog.show();
                }

                leftMatchScore++;
                displayForLeft(leftMatchScore);
            }
        });
        // Right side increment button
        incRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightMatchScore >= maxMatchScore) {
                    // Confirmation AlertDialog builder "So when user press No right score back to 20"
                    AlertDialog.Builder isRightWonDialog = new AlertDialog.Builder(MainActivity.this);
                    // Setting Dialog Title.
                    isRightWonDialog.setTitle(R.string.congratulation);
                    // Setting Dialog Message.
                    isRightWonDialog.setMessage(MainActivity.this.getString(R.string.is) + "\u0020" + rightName.getText().toString() + "\u0020" + MainActivity.this.getString(R.string.won));
                    // Setting Icon to Dialog.
                    isRightWonDialog.setIcon(R.drawable.ppsk_logo);
                    // Setting Positive "Yes" Btn.
                    isRightWonDialog.setPositiveButton(R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent newGame = new Intent(getApplicationContext(), UserNamesInput.class);
                                    startActivity(newGame);
                                    // TO DO will reset all scores values to Zero.
                                    finish();
                                    // Congratulations dialog toast.
                                    Toast.makeText(getApplicationContext(),
                                            R.string.New_Names_Needed_To_Start, Toast.LENGTH_LONG)
                                            .show();
                                }
                            })
                            // Setting Negative "No" Btn.
                            .setNegativeButton(R.string.no,
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                            rightMatchScore--;
                                            displayForRight(rightMatchScore);
                                        }
                                    });
                    // Showing Alert Dialog.
                    isRightWonDialog.show();
                }
                rightMatchScore++;
                displayForRight(rightMatchScore);
            }
        });
        // Left side decrement button
        decLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (leftMatchScore == 0) {
                    // Show an error message as a toast
                    Toast.makeText(getApplicationContext(), leftName.getText().toString() + "\u0020" + MainActivity.this.getString(R.string.cannot_have_less_than_zero), Toast.LENGTH_SHORT).show();
                    // Exit this method early because there's nothing left to do
                    return;
                }
                leftMatchScore--;
                displayForLeft(leftMatchScore);
            }
        });
        // Right side decrement button
        decRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rightMatchScore == 0) {
                    // Show an error message as a toast
                    Toast.makeText(getApplicationContext(), rightName.getText().toString() + "\u0020" + MainActivity.this.getString(R.string.cannot_have_less_than_zero), Toast.LENGTH_SHORT).show();
                    // Exit this method early because there's nothing left to do
                    return;
                }
                rightMatchScore--;
                displayForRight(rightMatchScore);
            }
        });
//        standings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent standings = new Intent(MainActivity.this, Standings.class);
//                startActivity(standings);
//            }
//        });
    }


    // @Override the onCreateOptionsMenu method to inflate the tool_bar_menu.xml resource for the toolbar menu THEN
    // Return super true.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Overriding the onOptionsItemSelected for the tool bar menu,
    // create a switch cases to the onOptionsItemSelected boolean value,
    // Case for the NEW GAME Button
    // Case for the About "App icon" Button.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_game:
                AlertDialog.Builder closeAppDialog = new AlertDialog.Builder(MainActivity.this);
                // Setting Dialog Title.
                closeAppDialog.setTitle(R.string.Start_a_new_game);
                // Setting Dialog Message.
                closeAppDialog.setMessage(R.string.By_choosing_YES);
                // Setting Icon to Dialog.
                closeAppDialog.setIcon(R.drawable.ppsk_logo);
                // Setting Positive "Yes" Btn.
                closeAppDialog.setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent newGame = new Intent(getApplicationContext(), UserNamesInput.class);
                                startActivity(newGame);
                                // TO DO will reset all scores values to Zero.
                                finish();
                                // Congratulations dialog toast.
                                Toast.makeText(getApplicationContext(),
                                        R.string.New_Names_Needed_To_Start, Toast.LENGTH_LONG)
                                        .show();
                            }
                        })
                        // Setting Negative "No" Btn.
                        .setNegativeButton(R.string.no,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                // Showing Alert Dialog.
                closeAppDialog.show();
                break;
            // Case of the About button.
            case R.id.action_about:
                // Create a factory object as a LayoutInflater from the MainActivity.class
                LayoutInflater factory = LayoutInflater.from(this);
                // Create a View object to the factory LayoutInflater and use the .inflate method to the about_layout.xml, null for the root view.
                final View aboutDialogView = factory.inflate(R.layout.about_layout, null);
                // Create an AlertDialog object and pass this as the .Builder context params then create it by .create().
                final AlertDialog aboutDialog = new AlertDialog.Builder(this).create();
                // Sets the AlertDialog view to the aboutDialogView View object.
                aboutDialog.setView(aboutDialogView);
                // Assign a setOnClickListener (new View) to the Linkedin button to open my in URL with an ACTION_VIEW intent, and leave the user to choose a browser.
                aboutDialogView.findViewById(R.id.in_connect_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String moInUrl = "https://www.linkedin.com/in/wisemo/";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(moInUrl));
                        startActivity(i);
                        aboutDialog.dismiss();
                    }
                });
                // Assign a setOnClickListener (new View) to dismiss the about view.
                aboutDialogView.findViewById(R.id.about_back_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aboutDialog.dismiss();
                    }
                });
                // Make the About view background transparent.
                aboutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                aboutDialog.show();
                break;
            default:
                break;
        }
        return true;
    }

    // Overriding the onBackPressed method to show a "Close App" AlertDialog with Yes & No buttons.
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder closeAppDialog = new AlertDialog.Builder(MainActivity.this);
        // Setting Dialog Title.
        closeAppDialog.setTitle(R.string.close_the_app);
        // Setting Dialog Message.
        closeAppDialog.setMessage(R.string.are_you_sure);
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
                                dialog.dismiss();
                            }
                        });
        // Showing Alert Dialog.
        closeAppDialog.show();
    }

    // This method to display the left match score and take the current left score int as @params.
    public void displayForLeft(int currentLeftScore) {
        TextView scoreView = findViewById(R.id.left_score_tv);
        scoreView.setText(String.valueOf(currentLeftScore));
    }

    // This method to display the right match score and take the current right score int as @params.
    public void displayForRight(int currentRightScore) {
        TextView scoreView = findViewById(R.id.right_score_tv);
        scoreView.setText(String.valueOf(currentRightScore));
    }

    // This method to display the left wrong score and take the current left wrong score int as @params.
    public void displayLeftWrongs(int LeftWrongScore) {
        TextView scoreView = findViewById(R.id.left_wrong_tv);
        scoreView.setText(String.valueOf(LeftWrongScore));
    }

    // This method to display the left wrong score and take the current left wrong score int as @params.
    public void displayRightWrongs(int RightWrongScore) {
        TextView scoreView = findViewById(R.id.right_wrong_tv);
        scoreView.setText(String.valueOf(RightWrongScore));
    }
}
