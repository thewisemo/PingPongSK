package com.example.android.pingpongsk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
    // Declaring some objects like TextViews, LinearLayout, Animation, ImageButton, Boolean.,.. etc.
    TextView leftName, rightName;
    LinearLayout leftSideLinearViewObj, rightSideLinearViewObj;
    Animation leftToRightAnimationObj, rightToLeftAnimationObj, leftRToLeftAnimationObj, rightLToRightAnimationObj;
    ImageButton swap, reset, standings, incLeft, decLeft, incRight, decRight;
    Boolean leftIsLeft = true;
    // For the reset & standings popup windows declaring the popup window objects,
    // Context variable,
    // The activity variable "which will be the bkg for the reset popup window,
    // The main parent RelativeLayout view group.
    PopupWindow resetPopupWindow, standingsPopupWindow;
    Context mContext;
    Activity mActivity;
    RelativeLayout mainParent;

    public static Point getLocationOnScreen(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0], location[1]);
    }

    public static Point getLvLocationOnScreen(LinearLayout view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0], location[1]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incLeft = findViewById(R.id.inc_left_one);
        incRight = findViewById(R.id.inc_right_one);
        decLeft = findViewById(R.id.dec_left_one);
        decRight = findViewById(R.id.dec_right_one);
        // Create an object to the tool bar and assign it to the id in the activity_main.xml THEN
        // set the suport to it as an action bar.
        Toolbar toolbar = findViewById(R.id.too_bar_view);
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
                    leftSideLinearViewObj.offsetLeftAndRight(50);
//                    leftSideLinearViewObj.layout(0,0,50,0);
//                    incLeft.startAnimation(leftToRightAnimationObj);
//                    decLeft.startAnimation(leftToRightAnimationObj);
                    rightSideLinearViewObj.startAnimation(rightToLeftAnimationObj);
                    rightSideLinearViewObj.offsetLeftAndRight(-50);
//                    rightSideLinearViewObj.layout(50,0,0,0);
//                    incRight.startAnimation(rightToLeftAnimationObj);
//                    decLeft.startAnimation(rightToLeftAnimationObj);
                    Point incbtnpoint, decbtnpoint, leftLinear, rightLinear;
                    incbtnpoint = getLocationOnScreen(incLeft);
                    decbtnpoint = getLocationOnScreen(decLeft);
                    leftLinear = getLvLocationOnScreen(leftSideLinearViewObj);
                    rightLinear = getLvLocationOnScreen(rightSideLinearViewObj);
                    Log.d("INC INTS FROM L TO R", "Point value: " + incbtnpoint);
                    Log.d("DEC INTS FROM L TO R", "Point value: " + decbtnpoint);
                    Log.d("LEFT LINEAR VIEW", "Point value: " + leftLinear);
                    Log.d("RIGHT LINEAR VIEW", "Point value: " + rightLinear);
                } else {
                    leftIsLeft = true;
                    leftSideLinearViewObj.startAnimation(leftRToLeftAnimationObj);
                    leftSideLinearViewObj.offsetLeftAndRight(-50);
//                    leftSideLinearViewObj.layout(50,0,0,0);
//                    incLeft.startAnimation(leftRToLeftAnimationObj);
//                    decLeft.startAnimation(leftRToLeftAnimationObj);
                    rightSideLinearViewObj.startAnimation(rightLToRightAnimationObj);
                    rightSideLinearViewObj.offsetLeftAndRight(50);
//                    rightSideLinearViewObj.layout(0,0,50,0);
//                    incRight.startAnimation(rightLToRightAnimationObj);
//                    decRight.startAnimation(rightLToRightAnimationObj);
                    Point incbtnpoint, decbtnpoint, leftLinear, rightLinear;
                    incbtnpoint = getLocationOnScreen(incLeft);
                    decbtnpoint = getLocationOnScreen(decLeft);
                    leftLinear = getLvLocationOnScreen(leftSideLinearViewObj);
                    rightLinear = getLvLocationOnScreen(rightSideLinearViewObj);
                    Log.d("INC INTS FROM R TO L", "Point value: " + incbtnpoint);
                    Log.d("DEC INTS FROM R TO L", "Point value: " + decbtnpoint);
                    Log.d("LEFT LINEAR VIEW", "Point value: " + leftLinear);
                    Log.d("RIGHT LINEAR VIEW", "Point value: " + rightLinear);
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
        // Standings ImageButton object code to
        // setOnClickListener with a new View by an intent to the standings.class
        standings = findViewById(R.id.standings_btn);
        standings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Standings.class);
                startActivity(i);
            }
        });


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
                closeAppDialog.setTitle("Start a new game ?");
                // Setting Dialog Message.
                closeAppDialog.setMessage("By choosing YES! you will loose all current scores and will choose enter new players");
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
                                        "New Names Needed To Start", Toast.LENGTH_LONG)
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
}
