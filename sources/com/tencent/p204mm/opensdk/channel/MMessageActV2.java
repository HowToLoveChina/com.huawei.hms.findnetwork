package com.tencent.p204mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.tencent.p204mm.opensdk.channel.p205a.C8918b;
import com.tencent.p204mm.opensdk.constants.Build;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import com.tencent.p204mm.opensdk.utils.C8931d;
import com.tencent.p204mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public String toString() {
            return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
        }
    }

    public static boolean send(Context context, Args args) {
        String str;
        if (context == null || args == null) {
            str = "send fail, invalid argument";
        } else if (C8931d.m56649b(args.targetPkgName)) {
            str = "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName;
        } else {
            if (C8931d.m56649b(args.targetClassName)) {
                args.targetClassName = args.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
            }
            Log.m56638d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName);
            Intent intent = new Intent();
            intent.setClassName(args.targetPkgName, args.targetClassName);
            Bundle bundle = args.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, args.content);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C8918b.m56625a(args.content, Build.SDK_INT, packageName));
            intent.putExtra(ConstantsAPI.TOKEN, args.token);
            int i10 = args.flags;
            if (i10 == -1) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK).addFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
            } else {
                intent.setFlags(i10);
            }
            try {
                context.startActivity(intent);
                Log.m56638d(TAG, "send mm message, intent=".concat(String.valueOf(intent)));
                return true;
            } catch (Exception e10) {
                str = "send fail, ex = " + e10.getMessage();
            }
        }
        Log.m56639e(TAG, str);
        return false;
    }
}
