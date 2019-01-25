package akndmr.github.io.colorprefutil;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Akın DEMİR on 25.01.2019.
 */
public class ColorPrefUtil {

    /**
     *  Change activity theme
     *  Call this before @setContentView
     *
     *   @param styleId is your custom style id
     *   eg. R.style.AppThemeBlue
     */
    public static void changeThemeStyle(@NonNull Context context, @NonNull Integer styleId){
        context.setTheme(styleId);
    }


    /**
     *  Change backgroundColor (android:background) of child views
     *  This applies to each childView of given parent
     *
     *  @param parentView is the parent view
     *  @param colorId is the background color id (eg. R.color.bg)
     */
    public static void changeBackgroundColorOfChildViews(@NonNull Context context, @NonNull ViewGroup parentView, @NonNull Integer colorId){
        for(int i=0; i < parentView.getChildCount(); i++){
            parentView.getChildAt(i).setBackgroundColor(ContextCompat.getColor(context, colorId));
        }
    }


    /**
     *  Change backgroundColor (android:background) of view
     *
     *  @param view is the view
     *  @param colorId is the background color id (eg. R.color.bg)
     */
    public static void changeBackgroundColorOfSingleView(@NonNull Context context, @NonNull View view, @NonNull Integer colorId){
        view.setBackgroundColor(ContextCompat.getColor(context, colorId));
    }


    /**
     *  Change textColor (android:textColor) of child views
     *  This applies to each TextView and EditText childs of given parent
     *
     *  @param parentView is the parent view
     *  @param textColorId is the text color of TextView or EditText
     *  @param hintColorId is the hint text color of TextView or EditText
     *  if @hintColorId is null, it gets default hint text color
     */
    public static void changeTextColorOfChildViews(@NonNull Context context, @NonNull ViewGroup parentView, @NonNull Integer textColorId, @Nullable Integer hintColorId){
        for(int i=0; i < parentView.getChildCount(); i++){
            View v = parentView.getChildAt(i);

            if(v instanceof EditText){
                ((EditText)v).setTextColor(ContextCompat.getColor(context, textColorId));
                if(hintColorId != null){
                    ((EditText)v).setHintTextColor(ContextCompat.getColor(context, hintColorId));
                }
            }
            else if(v instanceof TextView){
                ((TextView)v).setTextColor(ContextCompat.getColor(context, textColorId));
                if(hintColorId != null){
                    ((TextView)v).setHintTextColor(ContextCompat.getColor(context, hintColorId));
                }
            }
        }
    }



    /**
     *  Change textColor (android:textColor) of child views
     *  This applies to each TextView and EditText childs of given parent
     *
     *  @param view is the view either TextView or EditText
     *  @param textColorId is the text color of TextView or EditText
     *  @param hintColorId is the hint text color of TextView or EditText
     *  if @hintColorId is null, it gets default theme hint text color
     */
    public static void changeTextColorOfSingleView(@NonNull Context context, @NonNull View view, @NonNull Integer textColorId, @Nullable Integer hintColorId){
        if(view instanceof EditText){
            ((EditText)view).setTextColor(ContextCompat.getColor(context, textColorId));
            if(hintColorId != null){
                ((EditText)view).setHintTextColor(ContextCompat.getColor(context, hintColorId));
            }
        }
        else if(view instanceof TextView){
            ((TextView)view).setTextColor(ContextCompat.getColor(context, textColorId));
            if(hintColorId != null){
                ((TextView)view).setHintTextColor(ContextCompat.getColor(context, hintColorId));
            }
        }
    }


    /**
     *  Change backgroundDrawable (android:background) of child views
     *  This applies to each childView of given parent
     *
     *  @param parentView is the parent view
     *  @param drawableId is the background drawable id (eg. R.drawable.image1)
     */
    public static void changeBackgroundDrawableOfChildViews(@NonNull Context context, @NonNull ViewGroup parentView, @NonNull Integer drawableId){
        for(int i=0; i < parentView.getChildCount(); i++){
            parentView.getChildAt(i).setBackground(ContextCompat.getDrawable(context, drawableId));
        }
    }


    /**
     *  Change backgroundDrawable (android:background) of single view
     *
     *  @param view is the view
     *  @param drawableId is the background drawable id (eg. R.drawable.image1)
     */
    public static void changeBackgroundDrawableOfSingleView(@NonNull Context context, @NonNull View view, @NonNull Integer drawableId){
        view.setBackground(ContextCompat.getDrawable(context, drawableId));
    }


    /**
     *  Change tint color of an icon (android:tint)
     *  For #API < 21 add "vectorDrawables.useSupportLibrary = true"
     *  inside defaultConfig block in build.gradle
     *
     *  @param icon is the icon imageview
     *  @param tintColorId is the background color id (eg. R.color.accent)
     */
    public static void changeTintColorOfIcon(@NonNull Context context, @NonNull ImageView icon, @NonNull Integer tintColorId){

        DrawableCompat.setTint(
                icon.getDrawable(),
                ContextCompat.getColor(context, tintColorId)
        );
    }


    /**
     *  Change icon tint and text colors of NavigationView
     *
     *  @param iconColorId is the icon tint color id
     *  @param textColorId is the text color. If null, #iconColorId will apply
     */
    public static void changeColorOfItemsOfNavView(@NonNull NavigationView navigationView, @NonNull Integer iconColorId, @Nullable Integer textColorId){

        if(textColorId != null){
            ColorStateList colorStateListIcon = ColorStateList.valueOf(iconColorId);
            ColorStateList colorStateListText = ColorStateList.valueOf(textColorId);
            navigationView.setItemIconTintList(colorStateListIcon);
            navigationView.setItemTextColor(colorStateListText);
        }
        else{
            ColorStateList colorStateList = ColorStateList.valueOf(iconColorId);
            navigationView.setItemIconTintList(colorStateList);
            navigationView.setItemTextColor(colorStateList);
        }
    }


    /**
     *  Change icon tint and text colors of NavigationView
     *
     *  @param backgroundColorId is the color TabLayout's background
     *  @param tabNormalTextColorId is the normal text color
     *  @param tabSelectedTextColorId is the selected tab text color
     */
    public static void changeColorOfTabLayout(@NonNull Context context, @NonNull TabLayout tabLayout, @NonNull Integer backgroundColorId,
                                       @NonNull Integer tabNormalTextColorId,
                                       @NonNull Integer tabSelectedTextColorId,
                                       @NonNull Integer tabSelectedIndicatorColorId){
        tabLayout.setBackgroundColor(ContextCompat.getColor(context, backgroundColorId));
        tabLayout.setTabTextColors(ContextCompat.getColor(context, tabNormalTextColorId), ContextCompat.getColor(context, tabSelectedTextColorId));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(context, tabSelectedIndicatorColorId));
    }
}
