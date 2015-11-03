/*
 * about.java
 * 
 * Copyright 2014 westcrip <westcrip@westcrip-altankrk>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
package com.android.settings.nuclear.about;

import android.app.Activity;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceChangeListener;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import android.view.IWindowManager;
import android.view.Display;
import android.view.Window;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.R;
import com.android.settings.Utils;
    
public class about extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {
			
public static final String TAG = "about";
    
private static final String NS_ROM_SHARE = "share";
    
    Preference mForumUrl;
    Preference mKernelUrl;
    Preference mSourceUrl;
    Preference mDonateUrl;
    Preference mChangeUrl;
    Preference mSourcebaseUrl;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.nuclear_about);
        PreferenceScreen prefSet = getPreferenceScreen();
        ContentResolver resolver = getContentResolver();
        mKernelUrl = findPreference("ns_kernel");
        mForumUrl = findPreference("ns_forum");
        mSourceUrl = findPreference("ns_source");
        mDonateUrl = findPreference("ns_donate");
        mChangeUrl = findPreference("ns_change");
        mSourcebaseUrl = findPreference("ns_sourcebase");
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
        return false;
    }
    
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mForumUrl) {
            launchUrl("http://forum.xda-developers.com/oneplus-one/development/nuclearslim-t3133741");
        } else if (preference == mKernelUrl) {
            launchUrl("http://forum.xda-developers.com/oneplus-one/development/radioactivekernel-team-nuclear-t3119830");
        } else if (preference == mSourceUrl) {
            launchUrl("https://github.com/TeamNuclear");
        } else if (preference == mDonateUrl) {
            launchUrl("http://paypal.me/TeamNuclear");
        } else if (preference == mSourcebaseUrl) {
            launchUrl("https://github.com/SlimRoms");
        } else if (preference == mChangeUrl) {
            launchUrl("https://www.androidfilehost.com/?w=files&flid=38721");
        } else if (preference.getKey().equals(NS_ROM_SHARE)) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            //intent.putExtra(Intent.EXTRA_TEXT, String.format(
            //     getActivity().getString(R.string.share_message)));
            //startActivity(Intent.createChooser(intent, getActivity().getString(R.string.share_chooser_title)));
        }  else {
            // If not handled, let preferences handle it.
            return super.onPreferenceTreeClick(preferenceScreen, preference);
    }
         return true; 
    }
    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent donate = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(donate);
    }
}
