.class Leii$1;
.super Ljava/lang/Object;
.source "eii.java"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Leii;->runUpdate(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Leii;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Leii;Landroid/content/Context;)V
    .registers 3
    .param p1, "this$0"    # Leii;

    .prologue
    .line 30
    iput-object p1, p0, Leii$1;->this$0:Leii;

    iput-object p2, p0, Leii$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceClick(Landroid/preference/Preference;)Z
    .registers 3
    .param p1, "preference"    # Landroid/preference/Preference;

    .prologue
    .line 33
    iget-object v0, p0, Leii$1;->val$context:Landroid/content/Context;

    invoke-static {v0}, Lcom/rakin/gcamstuff/Updater;->PromptforUpdate(Landroid/content/Context;)V

    .line 34
    const/4 v0, 0x0

    return v0
.end method
