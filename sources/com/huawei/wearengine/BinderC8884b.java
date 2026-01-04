package com.huawei.wearengine;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.wearengine.IdentityStoreCallback;
import p752wu.C13641c;
import su.C12860b;

/* renamed from: com.huawei.wearengine.b */
/* loaded from: classes9.dex */
public class BinderC8884b extends IdentityStoreCallback.AbstractBinderC8878a {

    /* renamed from: a */
    public final /* synthetic */ C8887d f45270a;

    public BinderC8884b(C8887d c8887d) {
        this.f45270a = c8887d;
    }

    @Override // com.huawei.wearengine.IdentityStoreCallback.AbstractBinderC8878a
    /* renamed from: e */
    public void mo56494e(String str) {
        if (TextUtils.isEmpty(str)) {
            C12860b.m77205i("WearEngineClientInner", "storePermissionIdentity permissionIdentity isEmpty");
            return;
        }
        Context contextM82014a = C13641c.m82014a();
        if (contextM82014a == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = contextM82014a.getSharedPreferences("WearEngine_Permission_Identify_Store", 0).edit();
        editorEdit.putString("WearEnginePermissionIdentity", str);
        editorEdit.commit();
    }
}
