.class public final Leii;
.super Landroid/preference/PreferenceFragment;
.source "eii.java"

# interfaces
.implements Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/preference/PreferenceFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onResume()V
    .registers 2

    .prologue
    .line 60
    invoke-super {p0}, Landroid/preference/PreferenceFragment;->onResume()V

    .line 61
    invoke-virtual {p0}, Leii;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {p0, v0}, Leii;->runUpdate(Landroid/content/Context;)V

    .line 62
    return-void
.end method

.method public onSharedPreferenceChanged(Landroid/content/SharedPreferences;Ljava/lang/String;)V
    .registers 3
    .param p1, "sharedPreferences"    # Landroid/content/SharedPreferences;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 66
    return-void
.end method

.method public final runUpdate(Landroid/content/Context;)V
    .registers 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 29
    const-string v1, "check_for_updates_key"

    invoke-virtual {p0, v1}, Leii;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v0

    .line 30
    .local v0, "preference":Landroid/preference/Preference;
    new-instance v1, Leii$1;

    invoke-direct {v1, p0, p1}, Leii$1;-><init>(Leii;Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroid/preference/Preference;->setOnPreferenceClickListener(Landroid/preference/Preference$OnPreferenceClickListener;)V

    .line 37
    return-void
.end method
