package com.huawei.fastengine.fastview;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.startfastappengine.bean.Options;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;

/* loaded from: classes5.dex */
public class NavigationUtils {
    private static final String ACTIONBAR_LOCK_CUSTOMIZE = "ActionbarLockCustomize";
    private static final String ACTIONBAR_LOCK_STATUS = "ActionbarLockStatus";
    private static final String HW_SHORTCUT_POLICY = "hw_shortcut_policy";
    public static final String MAIL_SCHEMA_PREF = "mailto:";
    public static final String SMS_SCHEMA_PREF = "sms";
    private static final String TAG = "NavigationUtils";
    public static final String TEL_SCHEMA_PREF = "tel:";

    public static boolean jumpBySchema(Context context, String str, Options options) {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getScheme())) {
            return false;
        }
        return openFile(context, uri, options);
    }

    public static boolean jumpToMail(Context context, String str) {
        String strSubstring = str.substring(7);
        try {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(MAIL_SCHEMA_PREF));
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            intent.putExtra("android.intent.extra.EMAIL", new String[]{strSubstring});
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, " jumpToMail error: ActivityNotFoundException");
            return false;
        }
    }

    public static boolean jumpToSms(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, " jumpToSms error: ActivityNotFoundException");
            return false;
        }
    }

    public static boolean jumpToTel(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, " jumpToTel error: ActivityNotFoundException");
            return false;
        }
    }

    public static boolean openFile(Context context, Uri uri, Options options) {
        String str;
        Intent intent;
        try {
            intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            }
            intent.setAction("android.intent.action.VIEW");
        } catch (ActivityNotFoundException unused) {
            str = " openFile error: ActivityNotFoundException";
            FastViewLogUtils.m28724e(TAG, str);
            return true;
        } catch (SecurityException unused2) {
            str = " startActivity failed, have no read uri permission";
            FastViewLogUtils.m28724e(TAG, str);
            return true;
        }
        if (uri == null) {
            FastViewLogUtils.m28724e(TAG, "openFile uri null");
            return false;
        }
        intent.addFlags(1);
        intent.putExtra(ACTIONBAR_LOCK_CUSTOMIZE, options.getActionbarLockCustomize());
        intent.putExtra(ACTIONBAR_LOCK_STATUS, options.isActionbarLockStatus());
        intent.setData(uri);
        context.startActivity(intent);
        return true;
    }
}
