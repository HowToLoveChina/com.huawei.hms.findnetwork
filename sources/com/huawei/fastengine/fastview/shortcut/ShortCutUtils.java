package com.huawei.fastengine.fastview.shortcut;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.fastengine.fastview.Config;
import com.huawei.fastengine.fastview.download.utils.IoUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ShortCutUtils {
    private static final String AUTHORITY = "com.huawei.android.launcher.settings";
    private static final Uri CONTENT_URI = Uri.parse("content://com.huawei.android.launcher.settings/favorites?notify=true");
    private static final Uri CONTENT_URI_DRAWER = Uri.parse("content://com.huawei.android.launcher.settings/drawer_favorites?notify=true");
    private static final String INTENT_BUNDLE_KEY_RPK_LOADER_PACKAGE_NAME = "rpk_load_package";
    private static final String TAG = "ShortCutUtils";

    private static Intent findRpkShortCutInList(String str, List<String> list) throws URISyntaxException {
        ComponentName component;
        Bundle extras;
        for (String str2 : list) {
            if (str2 != null) {
                try {
                    Intent uri = Intent.parseUri(str2, 0);
                    if (uri != null && (component = uri.getComponent()) != null) {
                        if (Config.getPackageName().equals(component.getPackageName()) && (extras = uri.getExtras()) != null) {
                            String string = extras.getString("shortcut_id", null);
                            if (string == null) {
                                string = extras.getString(INTENT_BUNDLE_KEY_RPK_LOADER_PACKAGE_NAME, null);
                            }
                            if (str.equals(string)) {
                                return uri;
                            }
                        }
                    }
                } catch (URISyntaxException unused) {
                    FastViewLogUtils.m28724e(TAG, "findRpkShortCutInList: Exception");
                }
            }
        }
        return null;
    }

    public static boolean findRpkShortCutIntent(Context context, String str) throws URISyntaxException {
        if (context == null || TextUtils.isEmpty(str)) {
            FastViewLogUtils.m28724e(TAG, "hasShortcut, parameter is null");
            return false;
        }
        Intent intentFindRpkShortCutInList = findRpkShortCutInList(str, queryAllShortCutInfo(context, CONTENT_URI));
        if (intentFindRpkShortCutInList == null) {
            intentFindRpkShortCutInList = findRpkShortCutInList(str, queryAllShortCutInfo(context, CONTENT_URI_DRAWER));
        }
        return intentFindRpkShortCutInList != null;
    }

    public static List<String> queryAllShortCutInfo(Context context, Uri uri) throws IOException {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"title", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK)));
                    }
                }
            } catch (SecurityException unused) {
                FastViewLogUtils.m28723e("SecurityException");
            } catch (Exception unused2) {
                FastViewLogUtils.m28724e(TAG, "isShortcutExist: Exception.");
            }
            return arrayList;
        } finally {
            IoUtils.closeStream(cursorQuery);
        }
    }
}
