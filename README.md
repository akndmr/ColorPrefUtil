# ColorPrefUtil
![Release](https://jitpack.io/v/akndmr/ColorPrefUtil.svg)

ColorPrefUtil for Android

Easily change theme & background or text colors of views.

<div class="row">
<div class="col-lg-10">
<h2><strong>Setup</strong></h2>
<p><strong>Gradle</strong></p>
<p><strong>Step 1.</strong>&nbsp;Add the JitPack repository to your build file</p>
<div role="tabpanel">
<div class="tab-content">
<div id="gradle" class="tab-pane active" role="tabpanel">
<p>Add it in your root build.gradle at the end of repositories:</p>
<pre class="kode language-css code-toolbar"><code class=" kode language-css">	<span class="token selector">allprojects</span> <span class="token punctuation">{</span>
		<span class="token selector">repositories</span> <span class="token punctuation">{</span>
			<span class="token selector">...
			maven</span> <span class="token punctuation">{</span> url <span class="token string">'https://jitpack.io'</span> <span class="token punctuation">}</span>
		<span class="token punctuation">}</span>
	<span class="token punctuation">}</span></code></pre>
</div>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-lg-8">
<p><strong>Step 2.</strong>&nbsp;Add the dependency</p>
</div>
</div>
<div class="row">
<div class="col-lg-10">
<div role="tabpanel">
<div class="tab-content depTabs">
<div class="tab-pane depTab gradle active" role="tabpanel">
<pre class="kode code-toolbar  language-css"><code id="depCodeGradle" class=" kode  language-css">	<span class="token selector">dependencies</span> <span class="token punctuation">{</span>
	        implementation <span class="token string">'com.github.akndmr:ColorPrefUtil:1.0.1'</span>
	<span class="token punctuation">}<br /></span></code></pre>
</div>
</div>
</div>
</div>
</div>
<div class="row">
<div class="col-lg-10">
<h2><strong>Usage</strong></h2>
</div>
</div>
<div class="row">
<div class="col-lg-10">
<div role="tabpanel">
<div class="tab-content depTabs">
<div class="tab-pane depTab gradle active" role="tabpanel">
<h4><strong>Changing Theme</strong></h4>
<p><strong>styles.xml</strong></p>
<pre>&lt;style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar"&gt;<br />    &lt;!-- Customize your theme here. --&gt;<br />    &lt;item name="colorPrimary"&gt;@color/colorPrimary&lt;/item&gt;<br />    &lt;item name="colorPrimaryDark"&gt;@color/colorPrimaryDark&lt;/item&gt;<br />    &lt;item name="colorAccent"&gt;@color/colorAccent&lt;/item&gt;<br />&lt;/style&gt;<br /><br />&lt;style name="AppThemePurple" parent="Theme.AppCompat.Light.DarkActionBar"&gt;<br />    &lt;item name="colorPrimary"&gt;@color/colorPrimaryPurple&lt;/item&gt;<br />    &lt;item name="colorPrimaryDark"&gt;@color/colorPrimaryDarkPurple&lt;/item&gt;<br />    &lt;item name="colorAccent"&gt;@color/colorAccentPurple&lt;/item&gt;<br />&lt;/style&gt;</pre>
<p>&nbsp;</p>
<p><strong>MainActivity.java</strong></p>
<pre>@Override<br />protected void onCreate(Bundle savedInstanceState) {<br />    super.onCreate(savedInstanceState);<br /><br />    // Set theme before setContentView<br />    mSharedPreferences = getSharedPreferences(PREF_COLOR, MODE_PRIVATE);<br />    int themeSelected = mSharedPreferences.getInt(THEME_SELECTED, R.style.AppTheme);<br />    ColorPrefUtil.changeThemeStyle(this, themeSelected);<br /><br />    setContentView(R.layout.activity_main);<br /><br />//...<br />}<br /><br /></pre>
<pre class="kode code-toolbar  language-css"><code id="depCodeGradle" class=" kode  language-css"><span class="token punctuation">&nbsp;</span></code></pre>
</div>
</div>
</div>
</div>
</div>
