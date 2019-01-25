package akndmr.github.io.colorprefutil;

import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String PREF_COLOR = "pref_color";
    public static final String COLOR_SELECTED = "color_selected";
    public static final String COLOR_LIGHT_SELECTED = "color_light_selected";
    public static final String THEME_SELECTED = "theme_selected";

    int colorSelected, colorSelectedLight;

    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor editor;

    Button mButton, mButtonAsphalt, mButtonBlue, mButtonRed, mButtonThemeGreen, mButtonThemePurple;
    ConstraintLayout mConstraintLayout;
    TextView mTextView;
    EditText mEditText;
    ImageView mImageViewIcon;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set theme before setContentView
        mSharedPreferences = getSharedPreferences(PREF_COLOR, MODE_PRIVATE);
        int themeSelected = mSharedPreferences.getInt(THEME_SELECTED, R.style.AppTheme);
        ColorPrefUtil.changeThemeStyle(this, themeSelected);

        setContentView(R.layout.activity_main);

        editor = mSharedPreferences.edit();
        colorSelected = mSharedPreferences.getInt(COLOR_SELECTED, R.color.colorPrimary);
        colorSelectedLight = mSharedPreferences.getInt(COLOR_LIGHT_SELECTED, R.color.textColor);


        bindViews();
        bindListeners();

        ColorPrefUtil.changeColorOfTabLayout(this, mTabLayout, colorSelected, colorSelectedLight, R.color.textColor, R.color.textColor);
      //  ColorPrefUtil.changeTextColorOfChildViews(this, mConstraintLayout, colorSelected, colorSelectedLight);
        ColorPrefUtil.changeTextColorOfSingleView(this, mTextView, colorSelected, colorSelectedLight);
        ColorPrefUtil.changeTextColorOfSingleView(this, mEditText, colorSelected, colorSelectedLight);
        ColorPrefUtil.changeTintColorOfIcon(this, mImageViewIcon, colorSelected);
        ColorPrefUtil.changeBackgroundColorOfSingleView(this, mButton, colorSelected);
    }

    public void bindViews(){
        mTabLayout = findViewById(R.id.tabLayout);
        mConstraintLayout = findViewById(R.id.cl_container);
        mImageViewIcon = findViewById(R.id.imageView);
        mButtonAsphalt = findViewById(R.id.btnAsphalt);
        mButtonBlue = findViewById(R.id.btnBlue);
        mButtonRed = findViewById(R.id.btnRed);
        mButtonThemeGreen = findViewById(R.id.btnThemeGreen);
        mButtonThemePurple = findViewById(R.id.btnThemePurple);
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
        mEditText = findViewById(R.id.editText);
    }

    public void bindListeners(){
        mButtonAsphalt.setOnClickListener(this);
        mButtonBlue.setOnClickListener(this);
        mButtonRed.setOnClickListener(this);
        mButtonThemeGreen.setOnClickListener(this);
        mButtonThemePurple.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnAsphalt:
                editor.putInt(COLOR_SELECTED, R.color.colorAsphalt);
                editor.putInt(COLOR_LIGHT_SELECTED, R.color.colorAsphaltLight);
                editor.commit();
                //showMessage("btnAsphalt");
                recreate();
                break;
            case R.id.btnBlue:
                editor.putInt(COLOR_SELECTED, R.color.colorBlue);
                editor.putInt(COLOR_LIGHT_SELECTED, R.color.colorBlueLight);
                editor.commit();
                //showMessage("btnBlue");
                recreate();
                break;
            case R.id.btnRed:
                editor.putInt(COLOR_SELECTED, R.color.colorRed);
                editor.putInt(COLOR_LIGHT_SELECTED, R.color.colorRedLight);
                editor.commit();
                //showMessage("btnRed");
                recreate();
                break;
            case R.id.btnThemeGreen:
                editor.putInt(THEME_SELECTED, R.style.AppTheme);
                editor.commit();
                //showMessage("Green theme selected");
                recreate();
                break;
            case R.id.btnThemePurple:
                editor.putInt(THEME_SELECTED, R.style.AppThemePurple);
                editor.commit();
                //showMessage("Purple theme selected");
                recreate();
                break;

        }
    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
