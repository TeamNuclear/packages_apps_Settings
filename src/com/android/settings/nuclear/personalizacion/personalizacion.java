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

package com.android.settings.nuclear.personalizacion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import java.io.File;
import java.io.IOException;

public class personalizacion extends SettingsPreferenceFragment {
	    /*private static final String KEY_INTER = "interface";
    private static final String KEY_NAVIG = "navigation";
    private static final String KEY_GEST = "gesture_anywhere";
    private static final String KEY_ANIMA = "animaciones";

 private static SparseArray<String> allKeyTitles(Context context) {
        final SparseArray<String> rt = new SparseArray<String>();
        rt.put(R.string.interface_settings_title, KEY_INTER);
        rt.put(R.string.navigation_settings_title, KEY_NAVIG);
        rt.put(R.string.gesture_anywhere_title, KEY_GEST);
        rt.put(R.string.animaciones_settings_title, KEY_ANIMA);

        return rt;
    }
*/

  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.nuclear_personalizacion);
    }
    @Override
    protected int getMetricsCategory() {
        return 1;
    }
            /*// === Indexing ===

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
                    data.screenTitle = res.getString(R.string.nuclear_perso_title);
                    result.add(data);
                }
                return result;
            }


        public List<String> getNonIndexableKeys(Context context) {
            final ArrayList<String> rt = new ArrayList<String>();
            if (!Utils.isVoiceCapable(context)) {
                rt.add(KEY_INTER);
                rt.add(KEY_NAVIG);
                rt.add(KEY_GEST);
                rt.add(KEY_ANIMA);
            }
            return rt;
        }
    };*/
}
