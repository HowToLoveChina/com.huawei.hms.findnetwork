package com.huawei.android.hicloud.cloudbackup.process.util;

import p514o9.C11839m;
import p617rl.C12534r;

/* loaded from: classes2.dex */
public class SplitAppSettingSingleInstance {
    private static final SplitAppSettingSingleInstance INSTANCE = new SplitAppSettingSingleInstance();
    private static final String TAG = "SplitAppSettingSingleInstance";
    private C12534r settingHelper;

    private SplitAppSettingSingleInstance() {
        initConfig();
    }

    public static SplitAppSettingSingleInstance getInstance() {
        return INSTANCE;
    }

    private void initConfig() {
        this.settingHelper = C12534r.m75443g();
    }

    public boolean isSupportSplitBackUp(String str, String str2) {
        C12534r c12534r = this.settingHelper;
        if (c12534r != null) {
            return c12534r.m75451m(str, str2);
        }
        C11839m.m70689w(TAG, "isSupportSplitBackUp settingHelper is null");
        return false;
    }

    public boolean isSupportSplitRestore(String str, String str2) {
        C12534r c12534r = this.settingHelper;
        if (c12534r != null) {
            return c12534r.m75452n(str, str2);
        }
        C11839m.m70689w(TAG, "isSupportRestore settingHelper is null");
        return false;
    }
}
