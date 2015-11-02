/*
 * Copyright (C) 2014 The LiquidSmooth Project
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

package com.android.settings.nuclear;

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
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.search.SearchIndexableRaw;
import com.android.settings.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainSettings extends SettingsPreferenceFragment implements Indexable {
    private static final String KEY_PERSO = "perso";
    private static final String KEY_REND = "rend";
    private static final String KEY_SECUR = "secur";
    private static final String KEY_BLOQ = "bloq";
    private static final String KEY_MISC = "misc";



    /*    private static SparseArray<String> allKeyTitles(Context context) {
        final SparseArray<String> rt = new SparseArray<String>();
        rt.put(R.string.nuclear_perso_title, KEY_PERSO);
        rt.put(R.string.nuclear_cat_title, KEY_REND);
        rt.put(R.string.app_security_title, KEY_SECUR);
        rt.put(R.string.nuclear_bloq_title, KEY_BLOQ);
        rt.put(R.string.misc_category_title, KEY_MISC);

        return rt;
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.nuclear_main_settings);

        Resources res = getResources();

    /*    SettingConfirmationHelper.request(
            getActivity(),
            Settings.System.PERFORMANCE_APP,
            res.getString(R.string.performance_app_title),
            res.getString(R.string.performance_app_message),
            res.getString(R.string.kernel_adiutor_title),
            res.getString(R.string.synapse_title),
            null,
            null
        );*/
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
                    data.screenTitle = res.getString(R.string.nuclear_settings_title);
                    result.add(data);
                }
                return result;
            }


        public List<String> getNonIndexableKeys(Context context) {
            final ArrayList<String> rt = new ArrayList<String>();
            if (!Utils.isVoiceCapable(context)) {
                rt.add(KEY_REND);
                rt.add(KEY_PERSO);
                rt.add(KEY_BLOQ);
                rt.add(KEY_MISC);
            }
            return rt;
        }
    };*/
}