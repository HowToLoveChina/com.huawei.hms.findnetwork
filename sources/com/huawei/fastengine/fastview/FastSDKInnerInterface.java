package com.huawei.fastengine.fastview;

import android.content.Context;
import com.huawei.fastengine.fastview.startfastappengine.bean.Options;
import com.huawei.fastengine.fastview.startfastappengine.storage.FastAppPreferences;

/* loaded from: classes5.dex */
public class FastSDKInnerInterface {
    public static Options getJumpOptions(Context context) {
        String string = FastAppPreferences.getInstance(context).getString(FastAppPreferences.KEY_ACTIONBAR_LOCK_CUSTOMIZE, "default");
        boolean z10 = FastAppPreferences.getInstance(context).getBoolean(FastAppPreferences.KEY_ACTIONBAR_LOCK_STATUS, false);
        Options options = new Options();
        options.setActionbarLockStatus(z10);
        options.setActionbarLockCustomize(string);
        return options;
    }
}
