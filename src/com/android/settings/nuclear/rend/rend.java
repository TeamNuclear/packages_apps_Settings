/*
 *<!-- Copyright (C) 2012-2014 Resurrection Remix ROM Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.nuclear.rend;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.os.SystemProperties;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.preference.SeekBarPreference;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.Display;
import android.view.Window;
import android.widget.Toast;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.search.SearchIndexableRaw;
import com.android.settings.Utils;
import android.util.SparseArray;
import android.content.res.Resources;
/*import com.android.settings.util.AbstractAsyncSuCMDProcessor;
import com.android.settings.util.CMDProcessor;
import com.android.settings.util.Helpers;*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


import java.io.File;
import java.io.IOException;
import java.io.DataOutputStream;

public class rend extends SettingsPreferenceFragment  {
    private ListPreference mScrollingCachePref;
	private static final String TAG = "RendSettings";

	private static final String CATEGORY_PERFORMANCE = "performance_category";

	private static final String KEY_SYNAPSE = "key_synapse";
	/*private static final String KEY_KERNEL_ADIUTOR = "key_kernel_adiutor";
    private static final String KEY_SELINUX = "selinux_switch";

    private static final String SCROLLINGCACHE_PREF = "pref_scrollingcache";
    private static final String SCROLLINGCACHE_PERSIST_PROP = "persist.sys.scrollingcache";
    private static final String SCROLLINGCACHE_DEFAULT = "1";
     private static final String SELINUX = "selinux";
 */
   /* private static SparseArray<String> allKeyTitles(Context context) {
        final SparseArray<String> rt = new SparseArray<String>();
        rt.put(R.string.synapse_title, KEY_SYNAPSE);
        rt.put(R.string.kernel_adiutor_title, KEY_KERNEL_ADIUTOR);
        rt.put(R.string.selinux_switch_title, KEY_SELINUX);

        return rt;
    }*/


   // private SwitchPreference mSelinux;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.nuclear_rend);
        /*PreferenceScreen prefSet = getPreferenceScreen();

        Boolean checkPerformance = Settings.System.getInt(getContentResolver(), Settings.System.PERFORMANCE_APP, 0) == 1;

        if(checkPerformance) {
        	PreferenceScreen synapse = (PreferenceScreen) findPreference(KEY_SYNAPSE);
        	getPreferenceScreen().removePreference(synapse);
        } else {
        	PreferenceScreen kernelAdiutor = (PreferenceScreen) findPreference(KEY_KERNEL_ADIUTOR);
        	getPreferenceScreen().removePreference(kernelAdiutor);
        }
      */
        // Scrolling cache
     /*   mScrollingCachePref = (ListPreference) prefSet.findPreference(SCROLLINGCACHE_PREF);
        mScrollingCachePref.setValue(SystemProperties.get(SCROLLINGCACHE_PERSIST_PROP,
                SystemProperties.get(SCROLLINGCACHE_PERSIST_PROP, SCROLLINGCACHE_DEFAULT)));
        mScrollingCachePref.setOnPreferenceChangeListener(this);  

        //SELinux
        mSelinux = (SwitchPreference) findPreference(SELINUX);
        mSelinux.setOnPreferenceChangeListener(this);

        if (CMDProcessor.runSuCommand("getenforce").getStdout().contains("Enforcing")) {
            mSelinux.setChecked(true);
            mSelinux.setSummary(R.string.selinux_enforcing_title);
        } else {
            mSelinux.setChecked(false);
            mSelinux.setSummary(R.string.selinux_permissive_title);
        }*/
    }
    @Override
    protected int getMetricsCategory() {
        return 1;
    }

    /*@Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference.getKey().equals(KEY_SYNAPSE)) {
            final String appPackageName = "com.af.synapse";
            try {
                getActivity().getPackageManager().getPackageInfo(appPackageName, 0);
            } catch (PackageManager.NameNotFoundException e) {
                try {
                    getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (ActivityNotFoundException ex) {
                    getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                return true;
            }
            return false;
        } else if (preference.getKey().equals(KEY_KERNEL_ADIUTOR)) {
            final String appPackageName = "com.grarak.kerneladiutor";
            try {
                getActivity().getPackageManager().getPackageInfo(appPackageName, 0);
            } catch (PackageManager.NameNotFoundException e) {
                try {
                    getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (ActivityNotFoundException ex) {
                    getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                return true;

            }
            return false;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }*/

       /* public boolean onPreferenceChange(Preference preference, Object newValue) {
        
             

         if (preference == mScrollingCachePref) {
            if (newValue != null) {
                SystemProperties.set(SCROLLINGCACHE_PERSIST_PROP, (String)newValue);
            return true;
               }

           } else if (preference == mSelinux) {
            if (newValue.toString().equals("true")) {
                CMDProcessor.runSuCommand("setenforce 1");
                mSelinux.setSummary(R.string.selinux_enforcing_title);
            } else if (newValue.toString().equals("false")) {
                CMDProcessor.runSuCommand("setenforce 0");
                mSelinux.setSummary(R.string.selinux_permissive_title);
            }
            return true;
       }
     
          return false;
   }
          


                // === Indexing ===

    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider() {

            @Override
            public List<SearchIndexableRaw> getRawDataToIndex(Context context, boolean enabled) {
                final SparseArray<String> keyTitles = allKeyTitles(context);
                final int N = keyTitles.size();
                final List<SearchIndexableRaw> result = new ArrayList<SearchIndexableRaw>(N);
                final Resources res = context.getResources();
                for (int i = 0; i < N; i++) {
                    final SearchIndexableRaw data = new SearchIndexableRaw(context);
                    data.key = keyTitles.valueAt(i);
                    data.title = res.getString(keyTitles.keyAt(i));
                    data.screenTitle = res.getString(R.string.nuclear_cat_title);
                    result.add(data);
                }
                return result;
            }


        public List<String> getNonIndexableKeys(Context context) {
            final ArrayList<String> rt = new ArrayList<String>();
            if (!Utils.isVoiceCapable(context)) {
                rt.add(KEY_SYNAPSE);
                rt.add(KEY_KERNEL_ADIUTOR);
                rt.add(KEY_SELINUX);

            
               }
            return rt;
        }
    };*/
}
