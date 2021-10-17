package com.rakin.gcamstuff;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.StrictMode;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Updater {
    public static String CurrentVersion;


    public static String checkupdateVersionName() {  // Retrieves The Latest VersionName From Online
        try {

            URL url = new URL("https://raw.githubusercontent.com/rakinthegreat/GcamUpdater/main/LatestVersionName");
            // Set this link to your github file that contains the version name

            // Read text returned from the link
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                return (line);
            }

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return null;
    }

    public static void PromptforUpdate(Context context) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        PackageInfo str = null;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            final String versionName = String.valueOf(str.versionName);
            /*
             * versionName gives you the name of the installed application defined after
             * "versionName:"
             * in apktool.yml file
             */
            CurrentVersion = versionName;
            if (checkupdateVersionName() != null) {
                if (!versionName.contains(checkupdateVersionName())) {
                    UpdateDialog(context); // This Happens when update is required
                } else {
                    Toast.makeText(context, "This App is Up to Date!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Could Not Look for Updates!", Toast.LENGTH_SHORT).show();
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateDialog(Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Update Available!!!");
        alertDialogBuilder.setMessage("Your Current Version is " + CurrentVersion + " but the latest version is " + checkupdateVersionName() + ". Do you want to download?");
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                String url = updateVersionLink();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public static String updateVersionLink() {
        try {

            URL url = new URL("https://raw.githubusercontent.com/rakinthegreat/GcamUpdater/main/UpdateLink");
            // Set the link to the file containing update link from your Github Repo. You can include direct download link or webpages both.


            // read text returned by the file from link
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                return (line);
            }

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return "";
    }


}
