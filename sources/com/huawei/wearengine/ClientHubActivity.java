package com.huawei.wearengine;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import p752wu.C13641c;
import su.C12860b;

/* loaded from: classes9.dex */
public class ClientHubActivity extends Activity {
    /* renamed from: a */
    public final void m56492a(int i10, String str) {
        C12860b.m77205i("ClientHubActivity", "errorReturn:" + str + ", resultCode:" + i10);
        setResult(i10);
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C12860b.m77203g("ClientHubActivity", "onActivityResult requestCode:" + i10 + ", resultCode:" + i11);
        if (i10 == 19900) {
            C12860b.m77203g("ClientHubActivity", "onActivityResult finish");
            setResult(i11);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException {
        String str;
        C12860b.m77203g("ClientHubActivity", "ClientHubActivity onCreate");
        super.onCreate(bundle);
        C13641c.m82019f(this);
        Intent intent = getIntent();
        if (intent == null) {
            C12860b.m77205i("ClientHubActivity", "checkIntent intent is null");
            m56492a(5, "invalid intent");
            return;
        }
        String stringExtra = intent.getStringExtra("target_json");
        String stringExtra2 = intent.getStringExtra("start_request_json");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            m56492a(5, "ClientHubActivity start authNameJson is empty or requestDataJsonString is empty");
            return;
        }
        C12860b.m77203g("ClientHubActivity", "startJumpActivity");
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            String string = jSONObject.getString("target_package_name");
            String string2 = jSONObject.getString("target_activity_name");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                str = "targetPackageName or targetActivityName is empty";
            } else {
                Intent intent2 = new Intent();
                intent2.setPackage(string);
                intent2.setClassName(string, string2);
                intent2.putExtra("start_request_json", stringExtra2);
                Intent intentM82015b = C13641c.m82015b(intent2);
                if (intentM82015b == null) {
                    str = "createExplicitActivityIntent, intent is null.";
                } else {
                    try {
                        startActivityForResult(intentM82015b, 19900);
                        return;
                    } catch (ActivityNotFoundException unused) {
                        str = "startJumpActivity not find JumpActivity";
                    }
                }
            }
        } catch (JSONException unused2) {
            str = "startJumpActivity JSONException";
        }
        m56492a(12, str);
    }
}
