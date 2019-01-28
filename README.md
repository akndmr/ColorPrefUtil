# ColorPrefUtil
![Release](https://jitpack.io/v/akndmr/ColorPrefUtil.svg)

ColorPrefUtil for Android

Easily change theme & background or text colors of views.

![enter image description here](https://raw.githubusercontent.com/akndmr/ColorPrefUtil/master/ColorPrefUtil.gif)

## **Setup**

**Gradle**

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency
```
	dependencies {
	        implementation 'com.github.akndmr:ColorPrefUtil:1.0.1'
	}
```

## [](https://github.com/akndmr/ColorPrefUtil/blob/master/README.md#usage)**Usage**

#### [](https://github.com/akndmr/ColorPrefUtil/blob/master/README.md#changing-theme)**Changing Theme**

First, you need to set different styles for different color themes - if you want to change theme(setTheme(R.style.id)).

**styles.xml**

    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">  
        <!-- Customize your theme here. -->  
        <item name="colorPrimary">@color/colorPrimary</item>  
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>  
        <item name="colorAccent">@color/colorAccent</item>  
    </style>  
      
    <style name="AppThemePurple" parent="Theme.AppCompat.Light.DarkActionBar">  
        <item name="colorPrimary">@color/colorPrimaryPurple</item>  
        <item name="colorPrimaryDark">@color/colorPrimaryDarkPurple</item>  
        <item name="colorAccent">@color/colorAccentPurple</item>  
    </style>

**MainActivity.java**

    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
      
        // Set theme before setContentView  
        mSharedPreferences = getSharedPreferences(PREF_COLOR, MODE_PRIVATE);  
        int themeSelected = mSharedPreferences.getInt(THEME_SELECTED, R.style.AppTheme);  
        ColorPrefUtil.changeThemeStyle(this, themeSelected);  
      
        setContentView(R.layout.activity_main);  
      
    //...  
    }  

 
 
#### [](https://github.com/akndmr/ColorPrefUtil/blob/master/README.md#changing-backgroundcolor-of-single-or-all-views)**Changing BackgroundColor of Single View and All Views**

First, you need to set different styles for different color themes.

**MainActivity.java**

    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
      
    // Single view  
    mButton = findViewById(R.id.button);  
    ColorPrefUtil.changeBackgroundColorOfSingleView(this, mButton, colorSelected);  
      
    // All views inside parent layout
    mConstraintLayout = findViewById(R.id.cl_container);
    ColorPrefUtil.changeBackgroundColorOfChildViews(this, mConstraintLayout, colorSelected);  
    }

**Changing Text Color of Single View and All Views**

    // All views inside given parent layout
      ColorPrefUtil.changeTextColorOfChildViews(this, mConstraintLayout, colorSelected, colorSelectedLight);  
     
     // Single view
      ColorPrefUtil.changeTextColorOfSingleView(this, mTextView, colorSelected, colorSelectedLight);

**Changing Tint Color of Icons (ImageView)**

    ColorPrefUtil.changeTintColorOfIcon(this, mImageViewIcon, colorSelected);

**Changing Background Drawable of Single View and All Views**
*You can set custom background drawables for views.*

    ColorPrefUtil.changeBackgroundDrawableOfChildViews(this, mConstraintLayout, colorSelected);  
    ColorPrefUtil.changeBackgroundDrawableOfSingleView(this, mButton, R.drawable.ic_assignment);

**Changing Item Colors of NavigationView**
*Change icon tint color and text colors of Nav view.*

    ColorPrefUtil.changeColorOfItemsOfNavView(mNavigationView, iconColorId, textColorId);

**Changing Colors of TabLayout**
*Change TabLayout background, selected tab, indicator, text colors.*

    ColorPrefUtil.changeColorOfTabLayout(this, mTabLayout, colorSelected, colorSelectedLight, R.color.textColor, R.color.textColor);
    
   

**LICENSE**

MIT License

Copyright (c) 2019 Akın Demir

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  
SOFTWARE.
