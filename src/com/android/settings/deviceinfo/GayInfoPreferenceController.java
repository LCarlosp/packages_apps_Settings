 /* Copyright (C) 2021 NezukoOS
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
package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.android.settings.utils.NezukoSpecUtils;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class GayInfoPreferenceController extends AbstractPreferenceController implements
        PreferenceControllerMixin {


    private static final String KEY_STORAGE = "storage";
    private static final String KEY_CHIPSET = "chipset";
    private static final String KEY_BATTERY = "battery";
    private static final String KEY_DISPLAY = "display";

    public GayInfoPreferenceController(Context context) {
        super(context);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final Preference stPref = screen.findPreference(KEY_STORAGE);
        final Preference chipPref = screen.findPreference(KEY_CHIPSET);
        final Preference batPref = screen.findPreference(KEY_BATTERY);
        final Preference disPref = screen.findPreference(KEY_DISPLAY);

            final String stSummary = String.valueOf(NezukoSpecUtils.getTotalInternalMemorySize()) + "GB ROM + " + String.valueOf(NezukoSpecUtils.getTotalRAM()) + "GB RAM";
            stPref.setSummary(stSummary);
            chipPref.setSummary(NezukoSpecUtils.getProcessorModel());
            batPref.setSummary(NezukoSpecUtils.getBatteryCapacity(mContext) + " mAh");
            disPref.setSummary(NezukoSpecUtils.getScreenRes(mContext)); 
    }

    @Override
    public String getPreferenceKey() {
        return KEY_STORAGE;
    }
}