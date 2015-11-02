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

package com.android.settings.nuclear.bloq;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.util.SparseArray;
import android.provider.SearchIndexableResource;
import android.content.Context;

import com.android.settings.R;
import com.android.internal.logging.MetricsLogger;

import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.search.SearchIndexableRaw;
import com.android.settings.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import java.io.File;
import java.io.IOException;

public class bloq extends SettingsPreferenceFragment implements Indexable {
/*	    private static final String KEY_SHORT = "lockscreen_shortcuts";
    private static final String KEY_INFO = "owner_info_settings";
    private static final String KEY_WALLP = "lockscreen_wallpaper";
    private static final String KEY_SHORTSE = "lockscreen_shortcuts_settings";
    private static final String KEY_TAP = "double_tap_sleep_anywhere";

 private static SparseArray<String> allKeyTitles(Context context) {
        final SparseArray<String> rt = new SparseArray<String>();
        rt.put(R.string.lockscreen_shortcuts_title, KEY_SHORT);
        rt.put(R.string.owner_info_settings_title, KEY_INFO);
        rt.put(R.string.lockscreen_wallpaper_title, KEY_WALLP);
        rt.put(R.string.lockscreen_targets_message, KEY_SHORTSE);
        rt.put(R.string.double_tap_sleep_anywhere_title, KEY_TAP);

        return rt;
    }
*/
  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.nuclear_bloq);


    }

    @Override
    protected int getMetricsCategory() {
        return 1;
    }
       /* // === Indexing ===

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
                    data.screenTitle = res.getString(R.string.nuclear_bloq_title);
                    result.add(data);
                }
                return result;
            }


        public List<String> getNonIndexableKeys(Context context) {
            final ArrayList<String> rt = new ArrayList<String>();
            if (!Utils.isVoiceCapable(context)) {
                rt.add(KEY_SHORT);
                rt.add(KEY_INFO);
                rt.add(KEY_WALLP);
                rt.add(KEY_SHORTSE);
                rt.add(KEY_TAP);
            }
            return rt;
        }
    };
*/

}
