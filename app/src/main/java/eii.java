import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.rakin.gcamstuff.Updater;

/*
 * You have to Find a Smali Class that extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener
 * It usually starts like:
 *
.class public final Leii;
.super Landroid/preference/PreferenceFragment;
.source "PG"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;
 *
 * The .super Landroid/preference/PreferenceFragment; and .implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener; are keys to finding these types of smali classes.
 * The Settings UI related class is usually perfect for this.
 * In terms of Gcam 8.2.204, eii.smali is the required smali
 *
 * You have to copy the runUpdate(Context context) method and rest that are instructed. Make sure you copy the eii$1.smali too.
 */

public final class eii extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    public final void runUpdate(Context context) {
        Preference preference = (Preference) findPreference("check_for_updates_key"); // A preference with this key is there in camera_preferences.xml which you have to copy.
        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {  // Checks if the preference is clicked
                Updater.PromptforUpdate(context); // This starts the processes of Updater.smali
                return false;
            }
        });
    }

    /*
     * The Below Methods are available By Default
     * In the onResume() method, add runupdate(getActivity)
     * Usually in Smali, the method starts like:
     *
    invoke-super {p0}, Landroid/preference/PreferenceFragment;->onResume()V

    invoke-virtual {p0}, Leii;->getActivity()Landroid/app/Activity;

    move-result-object v0
    *
    * All you have to do is add after the move-result-object v0 line:
    *
     invoke-virtual {p0, v0}, Leii;->runUpdate(Landroid/content/Context;)V
    *
     * onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) method exists by default. No need to touch that.
     * That's all with this smali.
     */

    @Override
    public void onResume() {
        super.onResume();
        runUpdate(getActivity());
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }
}