package com.huawei.phoneservice.feedbackcommon.photolibrary;

import android.content.ContentResolver;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Keep;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MetaCreativeType;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqStringUtil;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import p438l.C11208b;

/* loaded from: classes5.dex */
public enum MimeType {
    JPEG(com.huawei.openalliance.p169ad.constant.MimeType.JPEG, m53311f("jpg", "jpeg")),
    PNG(com.huawei.openalliance.p169ad.constant.MimeType.PNG, m53311f("png")),
    GIF(com.huawei.openalliance.p169ad.constant.MimeType.GIF, m53311f(MetaCreativeType.GIF)),
    BMP("image/x-ms-bmp", m53311f("bmp")),
    WEBP("image/webp", m53311f("webp")),
    MNG("image/x-jng", m53311f("mng")),
    MPEG("video/mpeg", m53311f("mpeg", "mpg", "mpe")),
    MP4(com.huawei.openalliance.p169ad.constant.MimeType.MP4, m53311f("mp4", "m4v")),
    QUICKTIME("video/quicktime", m53311f("mov")),
    THREEGPP("video/3gpp", m53311f("3gp", "3gpp")),
    THREEGPP2("video/3gpp2", m53311f("3g2", "3gpp2")),
    MKV("video/x-matroska", m53311f("mkv")),
    WEBM("video/webm", m53311f("webm")),
    TS("video/mp2ts", m53311f("ts")),
    AVI("video/avi", m53311f("avi")),
    ASF("video/x-ms-asf", m53311f("asf")),
    WMV("video/x-ms-wmv", m53311f("wmv", "wmx", "wvx")),
    MOVIE("video/x-sgi-movie", m53311f("movie")),
    RV("video/vnd.rn-realvideo", m53311f("rv"));


    /* renamed from: v */
    public static final List<String> f40262v = Arrays.asList("bmp", "jpg", "jpeg", "png", "webp", "mng", MetaCreativeType.GIF, "mp4", "3gp", "avi", "3g2", "mpg", "mpe", "mov", "asf", "wmv", "wmx", "wvx", "movie", "ts", "rmvb", "rv", "flv", "mkv");

    /* renamed from: a */
    public final String f40264a;

    /* renamed from: b */
    public final Set<String> f40265b;

    MimeType(String str, Set set) {
        this.f40264a = str;
        this.f40265b = set;
    }

    /* renamed from: b */
    public static String m53309b(ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        if ("content".equals(uri.getScheme())) {
            try {
                Cursor cursorQuery = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            if (cursorQuery.getColumnIndex("_data") > -1) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                                cursorQuery.close();
                                return string;
                            }
                            cursorQuery.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return uri.getPath();
    }

    /* renamed from: e */
    public static String m53310e(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
    }

    /* renamed from: f */
    public static Set<String> m53311f(String... strArr) {
        return new C11208b(Arrays.asList(strArr));
    }

    @Keep
    public static String getMimeType(String str) throws Throwable {
        if (TextUtils.isEmpty(m53310e(str))) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            if (str != null) {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(12);
                    if (!TextUtils.isEmpty(strExtractMetadata)) {
                        if (m53312h(strExtractMetadata)) {
                            return strExtractMetadata;
                        }
                    }
                } catch (IllegalArgumentException | IllegalStateException | Exception e10) {
                    FaqLogger.m51840e("MimeType", e10.getMessage());
                }
            }
        } else {
            String strM53310e = m53310e(str);
            if (!TextUtils.isEmpty(strM53310e) && m53312h(strM53310e)) {
                return strM53310e;
            }
        }
        return com.huawei.openalliance.p169ad.constant.MimeType.JPEG;
    }

    @Keep
    public static String getSuffixFromUrl(String str) {
        if (FaqStringUtil.isEmpty(str)) {
            return null;
        }
        return URLConnection.guessContentTypeFromName(str);
    }

    /* renamed from: h */
    public static boolean m53312h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return f40262v.contains(str.split("/")[r3.length - 1]);
        } catch (Exception unused) {
            return false;
        }
    }

    @Keep
    public static boolean isImageFromUrl(String str) {
        if (FaqStringUtil.isEmpty(str)) {
            return false;
        }
        return m53313k(getSuffixFromUrl(str));
    }

    @Keep
    public static boolean isVideo(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(Constants.VIDEO_SUB_DIR);
    }

    @Keep
    public static boolean isVideoFromUrl(String str) {
        if (FaqStringUtil.isEmpty(str)) {
            return false;
        }
        return isVideo(getSuffixFromUrl(str));
    }

    /* renamed from: k */
    public static boolean m53313k(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("image");
    }

    @Keep
    public static Set<MimeType> ofAll() {
        return EnumSet.allOf(MimeType.class);
    }

    @Keep
    public static Set<MimeType> ofImage() {
        return EnumSet.of(JPEG, PNG, GIF, BMP, WEBP, MNG);
    }

    @Keep
    public static Set<MimeType> ofVideo() {
        return EnumSet.of(MPEG, MP4, QUICKTIME, THREEGPP, THREEGPP2, MKV, WEBM, TS, AVI, ASF, WMV, MOVIE, RV);
    }

    @Keep
    public boolean checkType(ContentResolver contentResolver, Uri uri) throws Throwable {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        if (uri == null) {
            return false;
        }
        String extensionFromMimeType = singleton.getExtensionFromMimeType(contentResolver.getType(uri));
        String strM53309b = null;
        boolean z10 = false;
        for (String str : this.f40265b) {
            if (str.equals(extensionFromMimeType)) {
                return true;
            }
            if (!z10) {
                strM53309b = m53309b(contentResolver, uri);
                if (!TextUtils.isEmpty(strM53309b)) {
                    strM53309b = strM53309b.toLowerCase(Locale.US);
                }
                z10 = true;
            }
            if (strM53309b != null && strM53309b.endsWith(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f40264a;
    }
}
