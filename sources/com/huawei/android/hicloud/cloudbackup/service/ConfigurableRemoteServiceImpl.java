package com.huawei.android.hicloud.cloudbackup.service;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;
import com.huawei.cloud.base.util.C4633d0;
import p015ak.C0213f;
import p371ik.C10527a;
import p514o9.C11839m;
import p620rp.InterfaceC12614b;
import p686up.InterfaceC13233a;

/* loaded from: classes2.dex */
public class ConfigurableRemoteServiceImpl implements InterfaceC12614b {
    private static final String CALL_URL = "content://com.huawei.android.ds.cloudbackup.provider";
    private static final String TAG = "ConfigurableRemoteUtils";

    @Override // p620rp.InterfaceC12614b
    public void clearAll() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            try {
                contextM1377a.getApplicationContext().getContentResolver().call(Uri.parse(CALL_URL), "configurable_clear_all", (String) null, new Bundle());
            } catch (Exception e10) {
                C11839m.m70688i(TAG, "clearAll Exception: " + e10.getMessage());
            }
        }
    }

    @Override // p620rp.InterfaceC12614b
    public <T extends InterfaceC13233a> void clearConfigurable(Class<T> cls) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            try {
                Uri uri = Uri.parse(CALL_URL);
                Bundle bundle = new Bundle();
                bundle.putSerializable("type", cls);
                contextM1377a.getApplicationContext().getContentResolver().call(uri, "configurable_clear", (String) null, bundle);
            } catch (Exception e10) {
                C11839m.m70688i(TAG, "clearConfigurable Exception: " + e10.getMessage());
            }
        }
    }

    @Override // p620rp.InterfaceC12614b
    public <T extends InterfaceC13233a> T getConfigurable(Class<T> cls) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            try {
                Uri uri = Uri.parse(CALL_URL);
                Bundle bundle = new Bundle();
                bundle.putSerializable("type", cls);
                String string = contextM1377a.getApplicationContext().getContentResolver().call(uri, "configurable_get", (String) null, bundle).getString("data");
                if (!C4633d0.m28404a(string)) {
                    return (T) C10527a.m64629g(string, cls);
                }
            } catch (Exception e10) {
                C11839m.m70688i(TAG, "getConfigurable Exception: " + e10.getMessage());
            }
        }
        return null;
    }

    @Override // p620rp.InterfaceC12614b
    public <T extends InterfaceC13233a> void saveConfigurable(Class<T> cls, T t10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            try {
                Uri uri = Uri.parse(CALL_URL);
                Bundle bundle = new Bundle();
                bundle.putSerializable("type", cls);
                bundle.putString(SyncProtocol.Constant.UPDATE, C10527a.m64633k(t10));
                contextM1377a.getApplicationContext().getContentResolver().call(uri, "configurable_save", (String) null, bundle);
            } catch (Exception e10) {
                C11839m.m70688i(TAG, "saveConfigurable Exception: " + e10.getMessage());
            }
        }
    }
}
