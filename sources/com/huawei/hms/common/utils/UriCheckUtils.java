package com.huawei.hms.common.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.io.File;
import p640sq.C12836o;

/* loaded from: classes8.dex */
public class UriCheckUtils {
    public static final int SCENE_CAMERA = 0;
    public static final int SCENE_GALLERY = 1;

    /* renamed from: a */
    private static boolean m30755a(Uri uri) {
        if (uri == null) {
            C12836o.m77099d("UriCheckUtils", "uri is invalid. uri is null.", true);
            return false;
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            C12836o.m77099d("UriCheckUtils", "uri is invalid. content uri's authority is empty.", true);
            return false;
        }
        if (!authority.startsWith("com.huawei.hms") && !authority.startsWith("com.huawei.hwid")) {
            return true;
        }
        C12836o.m77099d("UriCheckUtils", "uri is invalid. content uri's authority is " + authority, true);
        return false;
    }

    /* renamed from: b */
    private static boolean m30757b(String str) {
        if (TextUtils.isEmpty(str)) {
            C12836o.m77099d("UriCheckUtils", "uri is invalid. path is null.", true);
            return false;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            if (TextUtils.isEmpty(canonicalPath)) {
                C12836o.m77099d("UriCheckUtils", "uri is invalid. CanonicalPath is empty.", true);
                return false;
            }
            if (!canonicalPath.contains("./") && !canonicalPath.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
                if (canonicalPath.endsWith(CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT)) {
                    return true;
                }
                C12836o.m77099d("UriCheckUtils", "uri is invalid. path is private invalid suffix.", true);
                return false;
            }
            C12836o.m77099d("UriCheckUtils", "uri is invalid. path is private relative path.", true);
            return false;
        } catch (Throwable unused) {
            C12836o.m77099d("UriCheckUtils", "uri is invalid. path is error when read to file.", true);
            return false;
        }
    }

    public static boolean isUriValid(int i10, Uri uri) {
        if (uri == null) {
            C12836o.m77099d("UriCheckUtils", "uri is invalid. uri is null.", true);
            return false;
        }
        if ("content".equals(uri.getScheme())) {
            return m30755a(uri);
        }
        String path = uri.getPath();
        if (i10 == 0) {
            return m30757b(path);
        }
        if (1 == i10) {
            return m30756a(path);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m30756a(String str) {
        if (TextUtils.isEmpty(str)) {
            C12836o.m77099d("UriCheckUtils", "uri is invalid. path is null.", true);
            return false;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            if (TextUtils.isEmpty(canonicalPath)) {
                C12836o.m77099d("UriCheckUtils", "uri is invalid. CanonicalPath is empty.", true);
                return false;
            }
            if (canonicalPath.contains("data/data/com.huawei.hwid")) {
                C12836o.m77099d("UriCheckUtils", "uri is invalid. path is private FILTER_PRIVATE_DIR.", true);
                return false;
            }
            if (canonicalPath.contains("data/user") && canonicalPath.contains("com.huawei.hwid")) {
                C12836o.m77099d("UriCheckUtils", "uri is invalid. path is private data-user.", true);
                return false;
            }
            if (!canonicalPath.contains("./") && !canonicalPath.contains(FeedbackWebConstants.INVALID_FILE_NAME_PRE)) {
                if (!canonicalPath.endsWith(".xml") && !canonicalPath.endsWith(".js") && !canonicalPath.endsWith(".json") && !canonicalPath.endsWith(Event.EventConstants.PROPERTIES)) {
                    return true;
                }
                C12836o.m77099d("UriCheckUtils", "uri is invalid. path is private invalid suffix.", true);
                return false;
            }
            C12836o.m77099d("UriCheckUtils", "uri is invalid. path is private relative path.", true);
            return false;
        } catch (Throwable unused) {
            C12836o.m77099d("UriCheckUtils", "uri is invalid. path is error when read to file.", true);
            return false;
        }
    }
}
