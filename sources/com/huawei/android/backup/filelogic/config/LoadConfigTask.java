package com.huawei.android.backup.filelogic.config;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.File;
import p029b5.InterfaceC1118k;

/* loaded from: classes.dex */
public class LoadConfigTask {

    /* renamed from: a */
    public Context f9525a;

    public LoadConfigTask(Context context) {
        this.f9525a = context;
    }

    /* renamed from: a */
    public boolean m12606a(InterfaceC1118k interfaceC1118k, File file, String str) {
        boolean zMo6615f = false;
        if (interfaceC1118k == null) {
            return false;
        }
        if (file != null) {
            C2111d.m12653i("LoadAppControlStrategyTask", "parse param from cloud file.");
            zMo6615f = interfaceC1118k.mo6617i(file);
        }
        if (!zMo6615f || interfaceC1118k.getVersion() <= 1) {
            C2111d.m12653i("LoadAppControlStrategyTask", "parse param from assets source file.");
            zMo6615f = interfaceC1118k.mo6615f(this.f9525a, str);
        }
        C2111d.m12654j("LoadAppControlStrategyTask", "parse param result is:", Boolean.valueOf(zMo6615f));
        return zMo6615f;
    }
}
