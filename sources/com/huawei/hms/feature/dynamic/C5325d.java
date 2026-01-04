package com.huawei.hms.feature.dynamic;

import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.huawei.hms.feature.dynamic.d */
/* loaded from: classes8.dex */
public final class C5325d {

    /* renamed from: b */
    public static final String f24705b = "d";

    /* renamed from: c */
    public static final C5325d f24706c = new C5325d();

    /* renamed from: a */
    public Set<String> f24707a;

    /* renamed from: a */
    public static C5325d m31884a() {
        return f24706c;
    }

    /* renamed from: a */
    public void m31885a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("installed_module_name");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            Logger.m30744w(f24705b, "Get installed module name failed.");
            this.f24707a = new HashSet();
            return;
        }
        Logger.m30740i(f24705b, "Installed module name:" + stringArrayList);
        this.f24707a = new HashSet(stringArrayList);
    }
}
