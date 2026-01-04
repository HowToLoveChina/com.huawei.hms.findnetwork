package com.huawei.secure.android.common.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10342a;
import p787xt.C13865a;

/* loaded from: classes5.dex */
public class SafeFragmentActivity extends FragmentActivity {

    /* renamed from: y */
    public static final String f40660y = "SafeFragmentActivity";

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "finish exception : " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        try {
            super.finishAffinity();
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "finishAffinity: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        try {
            return new SafeIntent(super.getIntent());
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "getIntent: " + e10.getMessage(), true);
            return new SafeIntent(new Intent());
        }
    }

    @Override // android.app.Activity
    public Uri getReferrer() {
        try {
            return super.getReferrer();
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "getReferrer: " + e10.getMessage(), true);
            return null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        try {
            super.onActivityResult(i10, i11, new SafeIntent(intent));
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "onActivityResult exception : " + e10.getMessage(), true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C10342a.m63675a(super.getIntent())) {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "onDestroy exception : " + e10.getMessage(), true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        if (C10342a.m63675a(intent)) {
            C13865a.m83189c(f40660y, "onNewIntent : hasIntentBomb");
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onRestart() {
        if (C10342a.m63675a(super.getIntent())) {
            C13865a.m83189c(f40660y, "onRestart : hasIntentBomb");
        }
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (C10342a.m63675a(super.getIntent())) {
            C13865a.m83189c(f40660y, "onResume : hasIntentBomb");
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (C10342a.m63675a(super.getIntent())) {
            C13865a.m83189c(f40660y, "onStart : hasIntentBomb");
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (C10342a.m63675a(super.getIntent())) {
            C13865a.m83189c(f40660y, "onStop : hasIntentBomb");
        }
        super.onStop();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "startActivities: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            super.startActivity(new SafeIntent(intent));
        } catch (Exception unused) {
            C13865a.m83189c(f40660y, "startActivity Exception ");
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i10) {
        try {
            super.startActivityForResult(new SafeIntent(intent), i10);
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "startActivity: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i10) {
        try {
            return super.startActivityIfNeeded(intent, i10);
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "startActivityIfNeeded: " + e10.getMessage(), true);
            return false;
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        try {
            super.startActivities(intentArr, bundle);
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "startActivities: " + e10.getMessage(), true);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        try {
            super.startActivity(new SafeIntent(intent), bundle);
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "startActivity: " + e10.getMessage(), true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        try {
            super.startActivityForResult(new SafeIntent(intent), i10, bundle);
        } catch (Exception e10) {
            C13865a.m83191e(f40660y, "startActivity: " + e10.getMessage(), true);
        }
    }
}
