package com.example.contador.launcher;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contador.R;

import java.util.List;

public class LauncherMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_launcher_main);

        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> installedApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        ListView listView = findViewById(R.id.listview_apps);
        AppAdapter appAdapter = new AppAdapter(this,R.layout.item_list_launcher, installedApps);
        listView.setAdapter(appAdapter);
    }
}