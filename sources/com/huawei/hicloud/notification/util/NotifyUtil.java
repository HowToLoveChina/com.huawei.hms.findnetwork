package com.huawei.hicloud.notification.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import ck.C1443a;
import com.google.flatbuffers.reflection.BaseType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.bean.DestopPopupPolicy;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.NotepadAppInfo;
import com.huawei.hicloud.bean.SilenceDurationBean;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextRestoreConstants;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HNCloudConfig;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeGoto;
import com.huawei.hicloud.notification.p106db.bean.NoticeWithActivityGoto;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.ServiceShownStatus;
import com.huawei.hicloud.notification.p106db.bean.SyncConfigString;
import com.huawei.hicloud.notification.p106db.operator.DriveConfigLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.DriveConfigOperator;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
import com.huawei.hicloud.notification.receiver.CommonNotifyReceiver;
import com.huawei.hicloud.notify.R$string;
import com.huawei.hicloud.okhttp.callback.AbstractC4975a;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.SystemProperties;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import gp.C10028c;
import hu.C10344c;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mn.C11498b;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0216g0;
import p015ak.C0224k0;
import p015ak.C0234s;
import p015ak.C0235t;
import p015ak.C0238w;
import p292fn.C9733f;
import p292fn.C9734g;
import p429kk.C11058a;
import p429kk.C11060c;
import p527on.C11976a;
import p664u0.C13108a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p778xk.C13823d;
import pk.C12158a;

/* loaded from: classes6.dex */
public class NotifyUtil {
    private static final String DEEPLINK_URL_LANG_KEY = "&lang=";
    private static final String DEEPLINK_URL_PARAMETER_KEY = "url";
    private static final String DEEPLINK_URL_SPACENEEDED_KEY = "&spaceNeeded=";
    private static final String DEFAULT_END_TIME = "07:00:00";
    private static final String DEFAULT_START_TIME = "23:00:00";
    public static final String HINOTE_PKG_NAME = "com.huawei.hinote";
    public static final String HI_NOTE_SYNC_TYPE = "hinote";
    public static final String MAIN_TEXT_TYPE_DEFAULT = "main_text";
    public static final String MAIN_TEXT_TYPE_NOTI = "noti_main_text";
    public static final String MAIN_TEXT_TYPE_V3 = "v3_main_text";
    public static final String MAIN_TEXT_V4 = "v4_main_text";
    public static final String MAIN_TEXT_V5 = "v5_main_text";
    private static final String NOTE_PAD_SYNC_TYPE = "notepad";
    private static final String NO_QUERY_URL_SPACENEEDED_KEY = "?spaceNeeded=";
    public static final String PACKAGE_NAME = "packageNames";
    private static final String PKG_NAME_KEY = "packageName";
    private static final Map<String, String> PKG_SIGNATURE_MAP = new ConcurrentHashMap();
    public static final String SERVICE_ID = "serviceIds";
    private static final String SIGN_HASH_KEY = "signHash";
    public static final String SIGN_NAME = "signNames";
    private static final String TAG = "NotifyUtil";
    public static final String TITLE_TYPE_DEFAULT = "title";
    public static final String TITLE_TYPE_NOTI = "noti_title";
    public static final String TITLE_V4 = "v4_title";
    public static final String TITLE_V5 = "v5_title";

    public static String appendUriParam(URI uri, String str) {
        URI uri2;
        String query = uri.getQuery();
        if (query != null) {
            str = query + "&" + str;
        }
        try {
            uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str, uri.getFragment());
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "appendUriParam Exception" + e10.toString());
            uri2 = null;
        }
        if (uri2 == null) {
            return null;
        }
        return uri2.toString();
    }

    public static PendingIntent buildExtraNoticePendingIntent(Context context, ExtraNotificationBean extraNotificationBean, Intent intent, int i10) {
        if (context == null) {
            NotifyLogger.m29914e(TAG, "buildExtraNoticePendingIntent context is null");
            return null;
        }
        NoticeGoto noticeGoto = extraNotificationBean.getNoticeGoto();
        String notiType = noticeGoto.getNotiType();
        String notiUri = noticeGoto.getNotiUri();
        return (TextUtils.isEmpty(notiType) || TextUtils.isEmpty(notiUri) || !notiType.equals("application") || !notiUri.equals(NotifyConstants.HICLOUD_GALLERY)) ? C0209d.m1248e0(context, i10, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK) : PendingIntent.getBroadcast(context, 10002, intent, HwRecyclerView.ITEM_TYPE_NO_SCALE_TITLE_MASK);
    }

    private static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            cArr2[i11] = cArr[(b10 >>> 4) & 15];
            cArr2[i11 + 1] = cArr[b10 & BaseType.Obj];
        }
        return new String(cArr2);
    }

    private static boolean checkAndAddService(ArrayList<SyncConfigService> arrayList, List<SyncConfigService> list, StringBuilder sb2, Context context) {
        boolean z10 = false;
        for (int i10 = 0; i10 < list.size(); i10++) {
            SyncConfigService syncConfigService = list.get(i10);
            if (syncConfigService == null) {
                NotifyLogger.m29914e(TAG, "getShownSyncServiceItems service is null");
            } else {
                String id2 = syncConfigService.getId();
                if (TextUtils.isEmpty(id2)) {
                    NotifyLogger.m29914e(TAG, "getShownSyncServiceItems service id is null");
                } else {
                    NotifyLogger.m29913d(TAG, "getShownSyncServiceItems, service id = " + id2);
                    ServiceShownStatus serviceShownStatusIsShowSyncServiceItem = isShowSyncServiceItem(context, syncConfigService);
                    if (serviceShownStatusIsShowSyncServiceItem.isShown) {
                        syncConfigService.setTitleText(serviceShownStatusIsShowSyncServiceItem.titleText);
                        syncConfigService.setIconDrawable(serviceShownStatusIsShowSyncServiceItem.iconDrawable);
                        syncConfigService.setShowDivider(true);
                        arrayList.add(syncConfigService);
                    } else {
                        sb2.append("getShownSyncServiceItems service not shown, errorInfo = ");
                        sb2.append(serviceShownStatusIsShowSyncServiceItem.errorInfo);
                        sb2.append(",");
                        NotifyLogger.m29914e(TAG, "getShownSyncServiceItems service not shown, error info is: " + serviceShownStatusIsShowSyncServiceItem.errorInfo);
                        z10 = true;
                    }
                }
            }
        }
        return z10;
    }

    private static boolean checkDeepLink(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29915i(TAG, "checkDeepLink uriType is null.");
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            NotifyLogger.m29915i(TAG, "checkDeepLink uriStr is null.");
            if (!"detail".equals(str) && !NotifyConstants.DETAIL2.equals(str) && !NotifyConstants.DETAIL3.equals(str)) {
                NotifyLogger.m29915i(TAG, "checkDeepLink not detail.");
                return true;
            }
        }
        NotifyLogger.m29915i(TAG, "checkDeepLink uriType and uriStr not null.");
        return false;
    }

    public static boolean checkIsUriModuleEnable(Context context, String str, String str2, NoticeGoto noticeGoto) {
        if (checkDeepLink(str, str2)) {
            NotifyLogger.m29916w(TAG, "uriType or uriStr is null.");
            String type = noticeGoto.getType();
            String uri = noticeGoto.getUri();
            if (context == null) {
                NotifyLogger.m29914e(TAG, "checkIsUriModuleEnable context is null.");
                return false;
            }
            if (!new HiCloudLink(context).checkModuleEnable(type, uri)) {
                NotifyLogger.m29915i(TAG, "link disable type=" + noticeGoto.getType() + ", uri=" + noticeGoto.getUri());
                return false;
            }
        }
        return true;
    }

    private static boolean checkNotepadSignatures(Context context, String str) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            NotifyLogger.m29914e(TAG, "checkNotepadSignatures: getConfigFromLocalFile returns null.");
            return false;
        }
        String notepadAppInfos = hiCloudSysParamMapM60757p.getNotepadAppInfos();
        if (C4633d0.m28404a(notepadAppInfos)) {
            NotifyLogger.m29916w(TAG, "notepad signature config not exist.");
            return false;
        }
        List<NotepadAppInfo> notepadAppInfos2 = parseNotepadAppInfos(notepadAppInfos);
        if (notepadAppInfos2.isEmpty()) {
            NotifyLogger.m29916w(TAG, "notepad signatures config is null or empty.");
            return false;
        }
        for (NotepadAppInfo notepadAppInfo : notepadAppInfos2) {
            if (str.equals(notepadAppInfo.getPackageName())) {
                String signHash = notepadAppInfo.getSignHash();
                if (TextUtils.isEmpty(signHash)) {
                    NotifyLogger.m29916w(TAG, "config sign hash for pkg " + str + " is empty.");
                    return false;
                }
                Map<String, String> map = PKG_SIGNATURE_MAP;
                String signForPkgName = map.get(str);
                if (C4633d0.m28404a(signForPkgName)) {
                    signForPkgName = getSignForPkgName(context, str);
                    if (TextUtils.isEmpty(signForPkgName)) {
                        NotifyLogger.m29916w(TAG, "getSignForPkgName returns empty, pkg " + str);
                        return false;
                    }
                    map.put(str, signForPkgName);
                    NotifyLogger.m29915i(TAG, "get local sign hash success");
                }
                boolean zContains = signHash.contains(signForPkgName);
                NotifyLogger.m29915i(TAG, "is local sign hash equals config hash? " + zContains);
                return zContains;
            }
        }
        NotifyLogger.m29915i(TAG, "can not find pkg " + str + "'s config sign.");
        return false;
    }

    public static boolean checkPackageNameValid(Context context, SyncConfigService syncConfigService) {
        if (!isFingerPrintEmpty(syncConfigService)) {
            if (isAppFingerPrintValid(context, syncConfigService)) {
                return true;
            }
            NotifyLogger.m29914e(TAG, "signature not valid. service id: " + syncConfigService.getId());
            return false;
        }
        for (String str : syncConfigService.getApplications()) {
            if (!C0209d.m1230Z1(context, str)) {
                NotifyLogger.m29914e(TAG, "not system app, packageName: " + str);
                return false;
            }
        }
        return true;
    }

    public static boolean checkSilentNotifyTime(SilenceDurationBean silenceDurationBean) {
        if (silenceDurationBean == null) {
            NotifyLogger.m29914e(TAG, "checkSilentNotifyTime silentDurationBean is null");
            return false;
        }
        String startTime = silenceDurationBean.getStartTime();
        String endTime = silenceDurationBean.getEndTime();
        NotifyLogger.m29913d(TAG, "checkSilentNotifyTime, startTime: " + startTime + ", endTime: " + endTime);
        return checkTimeRange(startTime, endTime);
    }

    public static boolean checkSilentNotifyTimeWithDefault(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = DEFAULT_START_TIME;
            str2 = DEFAULT_END_TIME;
        }
        return checkTimeRange(str, str2);
    }

    public static boolean checkTimeRange(String str, String str2) {
        return checkTimeRange(str, str2, Constants.TIME_FORMAT_WITHOUT_MILLS);
    }

    private static boolean checkTimeRangeTwo(Date date, Date date2, Date date3) {
        if (date == null || date2 == null || date3 == null) {
            NotifyLogger.m29914e(TAG, "checkTimeRange parse result is null");
            return false;
        }
        if (date2.after(date3)) {
            if (!date.after(date3) || !date.before(date2)) {
                return true;
            }
        } else if (date2.before(date3) && date.after(date2) && date.before(date3)) {
            return true;
        }
        return false;
    }

    public static void downloadFileToPath(String str, String str2, C4896a c4896a) throws C9721b {
        String strM72864a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "ownloadFile failed, DownloadReq info is illegal.");
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile == null) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "get file parent path failed.");
        }
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "file parent create failed.");
        }
        try {
            strM72864a = C12158a.m72864a(str2, Constants.UTF_8);
        } catch (C9721b unused) {
            NotifyLogger.m29914e(TAG, "url decode exception");
            strM72864a = null;
        }
        if (TextUtils.isEmpty(strM72864a)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "url is null or empty after urldecoder");
        }
        C11976a.m72086g(strM72864a, c4896a, null);
    }

    public static void downloadFileToPathSilent(String str, String str2, AbstractC4975a abstractC4975a) {
        String strM72864a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            NotifyLogger.m29914e(TAG, "downloadFile failed, DownloadReq info is illegal.");
            return;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile == null) {
            NotifyLogger.m29914e(TAG, "get local parent path failed.");
            return;
        }
        if (!parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
            NotifyLogger.m29914e(TAG, "local parent create failed.");
            return;
        }
        try {
            strM72864a = C12158a.m72864a(str2, Constants.UTF_8);
        } catch (C9721b unused) {
            NotifyLogger.m29914e(TAG, "url decode exception");
            strM72864a = null;
        }
        if (TextUtils.isEmpty(strM72864a)) {
            NotifyLogger.m29914e(TAG, "url is null or empty after URLDecoder");
            return;
        }
        try {
            C11976a.m72086g(strM72864a, abstractC4975a, null);
        } catch (C9721b e10) {
            NotifyLogger.m29914e(TAG, "catch error " + e10.toString());
        }
    }

    private static String filterMainText(NoticeContent noticeContent, boolean z10, boolean z11, int i10) {
        return z10 ? getFreeUserNoticeMainText(noticeContent, z11, i10) : getPayUserNoticeMainText(noticeContent, z11, i10);
    }

    public static String filterNoticeMainText(NoticeContent noticeContent, boolean z10, boolean z11, String str, int i10) {
        if (noticeContent == null) {
            NotifyLogger.m29914e(TAG, "filterNoticeMainText, popupContent is null");
            return null;
        }
        String strFilterMainText = filterMainText(noticeContent, z10, z11, i10);
        return C4633d0.m28404a(strFilterMainText) ? MAIN_TEXT_TYPE_NOTI.equals(str) ? getNoticeStringV4(noticeContent.getNotiMainText(), i10) : MAIN_TEXT_TYPE_V3.equals(str) ? getNoticeStringV4(noticeContent.getV3MainText(), i10) : MAIN_TEXT_V4.equals(str) ? getNoticeStringV4(noticeContent.getV4MainText(), i10) : MAIN_TEXT_V5.equals(str) ? getNoticeStringV4(noticeContent.getBackupV5MainText(), i10) : getNoticeStringV4(noticeContent.getMainText(), i10) : strFilterMainText;
    }

    public static String filterNoticeTitle(NoticeContent noticeContent, boolean z10, boolean z11, String str, int i10) {
        if (noticeContent == null) {
            NotifyLogger.m29914e(TAG, "filterNoticeTitle, popupContent is null");
            return null;
        }
        String strFilterTitle = filterTitle(noticeContent, z10, z11, i10);
        return C4633d0.m28404a(strFilterTitle) ? TITLE_TYPE_NOTI.equals(str) ? getNoticeStringV4(noticeContent.getNotiTitle(), i10) : TITLE_V4.equals(str) ? getNoticeStringV4(noticeContent.getV4Title(), i10) : TITLE_V5.equals(str) ? getNoticeStringV4(noticeContent.getBackupV5PopTitle(), i10) : getNoticeStringV4(noticeContent.getTitle(), i10) : strFilterTitle;
    }

    private static String filterTitle(NoticeContent noticeContent, boolean z10, boolean z11, int i10) {
        return z10 ? getFreeUserNoticeTitle(noticeContent, z11, i10) : getPayUserNoticeTitle(noticeContent, z11, i10);
    }

    public static List<String> getAllShownSyncServiceId(Context context) {
        NotifyLogger.m29915i(TAG, "getAllShownSyncServiceId ");
        ArrayList arrayList = new ArrayList();
        arrayList.add("addressbook");
        arrayList.add("browser");
        arrayList.add("calendar");
        arrayList.add(NOTE_PAD_SYNC_TYPE);
        arrayList.add("wlan");
        arrayList.add("atlas");
        arrayList.addAll(getShownSyncServiceId(context));
        return arrayList;
    }

    public static Intent getBrowserIntent(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        return intent;
    }

    private static String getDeepLinkQuery(String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "getDeepLinkQuery parameter is empty.");
            return str;
        }
        try {
            if (!TextUtils.isEmpty(new URL(str).getQuery())) {
                return str + DEEPLINK_URL_SPACENEEDED_KEY + j10 + DEEPLINK_URL_LANG_KEY + C0234s.m1628f();
            }
            NotifyLogger.m29914e(TAG, "getDeepLinkQuery query is empty.");
            return str + NO_QUERY_URL_SPACENEEDED_KEY + j10 + DEEPLINK_URL_LANG_KEY + C0234s.m1628f();
        } catch (MalformedURLException e10) {
            NotifyLogger.m29914e(TAG, "getDeepLinkQuery err : " + e10.getMessage());
            return str;
        }
    }

    public static DestopPopupPolicy getDesktopUnlockFrequency() {
        NotifyLogger.m29915i(TAG, "getDesktopUnlockFrequency enter");
        DestopPopupPolicy destopPopupPolicy = new DestopPopupPolicy();
        try {
            DestopPopupPolicy destopPopupPolicyM60761t = C9733f.m60705z().m60761t();
            if (destopPopupPolicyM60761t == null) {
                NotifyLogger.m29915i(TAG, "getDesktopUnlockFrequency, desktopUnlockedFrequency is null");
                return destopPopupPolicy;
            }
            int screenUnlockCheckInteval = destopPopupPolicyM60761t.getScreenUnlockCheckInteval();
            int screenUnlockCheckTimes = destopPopupPolicyM60761t.getScreenUnlockCheckTimes();
            NotifyLogger.m29915i(TAG, "getDesktopUnlockFrequency, frequency: " + screenUnlockCheckInteval + ", numberTimes: " + screenUnlockCheckTimes);
            if (screenUnlockCheckInteval > 0 && screenUnlockCheckTimes > 0) {
                return destopPopupPolicyM60761t;
            }
            NotifyLogger.m29915i(TAG, "getDesktopUnlockFrequency, result is error");
            return destopPopupPolicy;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getDesktopUnlockFrequency failed, e: " + e10.getMessage());
            return destopPopupPolicy;
        }
    }

    public static Intent getDlAppWebViewIntent(Context context, String str) {
        NotifyLogger.m29913d(TAG, "getDlAppWebViewIntent");
        if (str != null) {
            str = str + "&clientVersion=" + C1443a.f6213a;
        }
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
        intent.putExtra("no_need_param", true);
        intent.putExtra("url", str);
        intent.putExtra("title", context.getString(R$string.HiCloud_app_name));
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", 2);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SCALE_CARD_MASK);
        return intent;
    }

    public static PendingIntent getExtraNoticePendingIntent(Context context, ExtraNotificationBean extraNotificationBean, int i10, int i11, String str) {
        return getExtraNoticePendingIntent(context, extraNotificationBean, i10, i11, str, "");
    }

    public static Intent getExtraNoticePendingNeedIntent(Context context, ExtraNotificationBean extraNotificationBean, String str) {
        if (extraNotificationBean == null) {
            NotifyLogger.m29916w(TAG, "getExtraNoticePendingNeedIntent extraNotificationBean is null");
            return null;
        }
        NoticeGoto noticeGoto = extraNotificationBean.getNoticeGoto();
        String notiType = noticeGoto.getNotiType();
        String notiUri = noticeGoto.getNotiUri();
        if (!checkIsUriModuleEnable(context, notiType, notiUri, noticeGoto)) {
            NotifyLogger.m29916w(TAG, "getExtraNoticePendingNeedIntent uri is empty or moudlue not enable");
            return null;
        }
        Intent gotoIntent = getGotoIntent(context, notiType, notiUri);
        if (gotoIntent == null) {
            NotifyLogger.m29915i(TAG, "getExtraNoticePendingNeedIntent intent is null.");
            return null;
        }
        if ("detail".equals(notiType)) {
            NotifyLogger.m29915i(TAG, "getExtraNoticePendingNeedIntent notitype is detail.");
            return null;
        }
        C13222a.m79470l(gotoIntent, "4");
        C13230i.m79525e1(gotoIntent, "4", "6");
        gotoIntent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        gotoIntent.putExtra("user_tags_key", C13622a.m81963i());
        gotoIntent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, extraNotificationBean.getPercentage());
        gotoIntent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "DYNAMIC_NOTIFY_CLICK");
        gotoIntent.putExtra(HNConstants.C4906BI.DATA_TYPE_ID, "" + extraNotificationBean.getId());
        if (!TextUtils.isEmpty(str)) {
            gotoIntent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, str);
        }
        NotifyLogger.m29915i(TAG, "notification = " + extraNotificationBean.getNoticeType());
        return gotoIntent;
    }

    private static String getFreeUserNoticeMainText(NoticeContent noticeContent, boolean z10, int i10) {
        return z10 ? getNoticeStringV4(noticeContent.getAutoFreeMainText(), i10) : getNoticeStringV4(noticeContent.getHandFreeMainText(), i10);
    }

    private static String getFreeUserNoticeTitle(NoticeContent noticeContent, boolean z10, int i10) {
        return z10 ? getNoticeString(noticeContent.getAutoFreeTitle(), i10) : getNoticeString(noticeContent.getHandFreeTitle(), i10);
    }

    public static Intent getGotoIntent(Context context, String str, String str2) {
        return getGotoIntent(context, str, str2, null);
    }

    public static ArrayList<SyncConfigService> getNotShownSyncServiceItems(Context context) throws Throwable {
        NotifyLogger.m29915i(TAG, "getNotShownSyncServiceItems ");
        List<SyncConfigService> allServices = new SyncConfigOperator().getAllServices();
        ArrayList<SyncConfigService> arrayList = new ArrayList<>();
        if (C0209d.m1205R0(allServices)) {
            NotifyLogger.m29915i(TAG, "getNotShownSyncServiceItems no added sync module. ");
        } else {
            for (int i10 = 0; i10 < allServices.size(); i10++) {
                SyncConfigService syncConfigService = allServices.get(i10);
                if (syncConfigService == null) {
                    NotifyLogger.m29914e(TAG, "getNotShownSyncServiceItems service is null");
                } else {
                    String id2 = syncConfigService.getId();
                    if (TextUtils.isEmpty(id2)) {
                        NotifyLogger.m29914e(TAG, "getNotShownSyncServiceItems service id is null");
                    } else {
                        NotifyLogger.m29913d(TAG, "getNotShownSyncServiceItems, service id = " + id2);
                        if (!isShowSyncServiceItem(context, syncConfigService).isShown) {
                            arrayList.add(syncConfigService);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static String getNoticeString(String str, int i10) {
        if (SpaceInsuffNoticeV4Manager.getInstance().checkMultiLanguage(i10, str)) {
            return SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(str, i10);
        }
        if (SpaceNoticeV3Manager.getInstance().checkMultiLanguage(str)) {
            return SpaceNoticeV3Manager.getInstance().getStringUseLock(str);
        }
        NotifyLogger.m29914e(TAG, "prepareSpaceNotEnoughDialog checkMultiLanguage failed");
        return null;
    }

    private static String getNoticeStringV4(String str, int i10) {
        if (SpaceInsuffNoticeV4Manager.getInstance().checkMultiLanguage(i10, str)) {
            return SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(str, i10);
        }
        NotifyLogger.m29914e(TAG, "getNoticeStringV4 checkMultiLanguage failed");
        String stringUseLock = SpaceInsuffNoticeV4Manager.getInstance().getStringUseLock(str, i10);
        if (TextUtils.isEmpty(stringUseLock)) {
            return null;
        }
        NotifyLogger.m29914e(TAG, "getNoticeStringV4 get default language");
        return stringUseLock;
    }

    public static NotificationCompat.Builder getNotificationBuilder(boolean z10, String str) {
        Context contextM1377a = C0213f.m1377a();
        return z10 ? C0235t.m1645e().m1647f(contextM1377a, str, "2", contextM1377a.getString(R$string.channel_backup_notification)) : C0238w.m1663f().m1668i(contextM1377a, str);
    }

    public static Intent getOperWebViewIntent(Context context, String str, int i10) {
        NotifyLogger.m29913d(TAG, "getOperWebViewIntent");
        Intent intent = new Intent();
        intent.setAction(NotifyConstants.Action.HICLOUD_WEBVIEW_ACTION);
        C0209d.m1302r2(intent, "com.huawei.hidisk");
        intent.putExtra("srcChannel", "0");
        intent.putExtra("salChannel", "0");
        intent.putExtra("url", str);
        intent.putExtra("title", context.getString(R$string.HiCloud_app_name));
        intent.putExtra("is_support_orientation", true);
        intent.putExtra("isEnableJs", true);
        intent.putExtra("launch_web_type", i10);
        return intent.resolveActivity(context.getPackageManager()) == null ? getBrowserIntent(str) : intent;
    }

    private static String getPayUserNoticeMainText(NoticeContent noticeContent, boolean z10, int i10) {
        return z10 ? getNoticeString(noticeContent.getAutoPayMainText(), i10) : getNoticeString(noticeContent.getHandPayMainText(), i10);
    }

    private static String getPayUserNoticeTitle(NoticeContent noticeContent, boolean z10, int i10) {
        return z10 ? getNoticeString(noticeContent.getAutoPayTitle(), i10) : getNoticeString(noticeContent.getHandPayTitle(), i10);
    }

    public static String getReportSceneId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
        }
        return "";
    }

    public static List<String> getSamesLambda(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null) {
            NotifyLogger.m29914e(TAG, "str1 or str2 is empty");
            return new ArrayList();
        }
        final HashSet hashSet = new HashSet(Arrays.asList(strArr));
        return (List) Arrays.asList(strArr2).stream().filter(new Predicate() { // from class: com.huawei.hicloud.notification.util.a
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return NotifyUtil.lambda$getSamesLambda$0(hashSet, (String) obj);
            }
        }).collect(Collectors.toList());
    }

    public static Map<String, List<String>> getShownDriveServiceInfo(Context context) {
        DriveConfigService next;
        NotifyLogger.m29915i(TAG, "getShownSyncServiceId");
        ArrayList<DriveConfigService> shownDriveServiceItems = getShownDriveServiceItems(context);
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<DriveConfigService> it = shownDriveServiceItems.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (!TextUtils.isEmpty(next.getId())) {
                arrayList.add(next.getId());
            }
            if (next.getPkgNames() != null) {
                for (String str : next.getPkgNames()) {
                    arrayList2.add(str);
                }
            }
            if (next.getSignHash() != null) {
                for (String str2 : next.getSignHash()) {
                    arrayList3.add(str2);
                }
            }
        }
        map.put(SERVICE_ID, arrayList);
        map.put(PACKAGE_NAME, arrayList2);
        map.put(SIGN_NAME, arrayList3);
        return map;
    }

    public static ArrayList<DriveConfigService> getShownDriveServiceItems(Context context) {
        NotifyLogger.m29915i(TAG, "getShownDriveServiceItems");
        StringBuilder sb2 = new StringBuilder("{");
        sb2.append("report Time = " + System.currentTimeMillis() + ",");
        List<DriveConfigService> allServices = new DriveConfigOperator().getAllServices();
        JsonElement jsonTree = new Gson().toJsonTree(allServices);
        String string = jsonTree != null ? jsonTree.toString() : "";
        sb2.append(" all services = ");
        sb2.append(string);
        sb2.append(",");
        ArrayList<DriveConfigService> arrayList = new ArrayList<>();
        if (C0224k0.a.m1575d(SystemProperties.HW_SC_BUILD_OS_API_VERSION, 0) < 8) {
            NotifyLogger.m29915i(TAG, "getShownDriveServiceItems rom is not support");
            return arrayList;
        }
        if (allServices.isEmpty()) {
            NotifyLogger.m29915i(TAG, "getShownDriveServiceItems driveServices is empty");
        } else {
            boolean z10 = false;
            for (int i10 = 0; i10 < allServices.size(); i10++) {
                DriveConfigService driveConfigService = allServices.get(i10);
                if (driveConfigService == null) {
                    NotifyLogger.m29914e(TAG, "getShownDriveServiceItems service is null");
                } else {
                    String id2 = driveConfigService.getId();
                    if (TextUtils.isEmpty(id2)) {
                        NotifyLogger.m29914e(TAG, "getShownDriveServiceItems service id is null");
                    } else {
                        ServiceShownStatus serviceShownStatusIsShowDriveServiceItem = isShowDriveServiceItem(context, driveConfigService);
                        if (serviceShownStatusIsShowDriveServiceItem.isShown) {
                            driveConfigService.setTitleText(serviceShownStatusIsShowDriveServiceItem.titleText);
                            if (driveConfigService.isSubUser() || C0209d.m1166E1()) {
                                driveConfigService.setShowDivider(true);
                                arrayList.add(driveConfigService);
                            } else {
                                sb2.append("sub user disable serviceId : ");
                                sb2.append(id2);
                                sb2.append("}");
                                NotifyLogger.m29915i(TAG, "getShownDriveServiceItems module do not support sub user module = " + id2);
                                C10028c.m62182c0().m62336h2(id2, false);
                            }
                        } else {
                            sb2.append("getShownDriveServiceItems service not shown, errorInfo = ");
                            sb2.append(serviceShownStatusIsShowDriveServiceItem.errorInfo);
                            sb2.append(",");
                            NotifyLogger.m29914e(TAG, "getShownDriveServiceItems error info is: " + serviceShownStatusIsShowDriveServiceItem.errorInfo + ", service id =" + id2);
                            C10028c.m62182c0().m62336h2(id2, false);
                        }
                        z10 = true;
                    }
                }
            }
            if (z10) {
                processReport(context, sb2);
            }
        }
        NotifyLogger.m29915i(TAG, "getShownDriveServiceItems count = " + arrayList.size());
        return arrayList;
    }

    public static List<String> getShownSyncServiceId(Context context) {
        NotifyLogger.m29915i(TAG, "getShownSyncServiceId ");
        ArrayList<SyncConfigService> shownSyncServiceItems = getShownSyncServiceItems(context);
        ArrayList arrayList = new ArrayList();
        for (SyncConfigService syncConfigService : shownSyncServiceItems) {
            if (syncConfigService != null && !TextUtils.isEmpty(syncConfigService.getId())) {
                arrayList.add(syncConfigService.getId());
            }
        }
        return arrayList;
    }

    public static ArrayList<SyncConfigService> getShownSyncServiceItems(Context context) {
        NotifyLogger.m29915i(TAG, "getShownSyncServiceItems ");
        StringBuilder sb2 = new StringBuilder("{");
        sb2.append("report Time = " + System.currentTimeMillis() + ",");
        List<SyncConfigService> allServices = new SyncConfigOperator().getAllServices();
        JsonElement jsonTree = new Gson().toJsonTree(allServices);
        String string = jsonTree != null ? jsonTree.toString() : "";
        sb2.append(" all services = ");
        sb2.append(string);
        sb2.append(",");
        ArrayList<SyncConfigService> arrayList = new ArrayList<>();
        if (C0209d.m1205R0(allServices)) {
            NotifyLogger.m29915i(TAG, "getShownSyncServiceItems no added sync module. ");
        } else if (checkAndAddService(arrayList, allServices, sb2, context)) {
            processReport(context, sb2);
        }
        if (arrayList.size() <= 0) {
            NotifyLogger.m29915i(TAG, "getShownSyncServiceItems get OM services is empty");
        } else {
            NotifyLogger.m29915i(TAG, "getShownSyncServiceItems get OM services success, OM items count = " + arrayList.size());
        }
        return arrayList;
    }

    public static String getSignForPkgName(Context context, String str) {
        if (context == null || str == null) {
            NotifyLogger.m29914e(TAG, "getSignForPkgName: context or pkgName is null");
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                NotifyLogger.m29914e(TAG, "getSignForPkgName: packageManager is null");
                return "";
            }
            Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
            if (signatureArr != null && signatureArr.length >= 1) {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
                if (x509Certificate == null) {
                    NotifyLogger.m29914e(TAG, "getSignForPkgName: cert is null");
                    return "";
                }
                PublicKey publicKey = x509Certificate.getPublicKey();
                if (publicKey != null) {
                    return bytesToString(publicKey.getEncoded());
                }
                NotifyLogger.m29914e(TAG, "getSignForPkgName: publicKey is null");
                return "";
            }
            NotifyLogger.m29914e(TAG, "getSignForPkgName: signs is null or signs.length < 1");
            return "";
        } catch (PackageManager.NameNotFoundException unused) {
            NotifyLogger.m29914e(TAG, "getSignForPkgName: NameNotFoundException pkgName =" + str);
            return "";
        } catch (RuntimeException e10) {
            NotifyLogger.m29914e(TAG, "getSignForPkgName: RuntimeException = " + e10.toString());
            return "";
        } catch (CertificateException e11) {
            NotifyLogger.m29914e(TAG, "getSignForPkgName: CertificateException = " + e11.toString());
            return "";
        }
    }

    public static long getSilentNotifyEndTimeMillis() throws ParseException {
        NotifyLogger.m29915i(TAG, "getSilentNotifyEndTimeSeconds enter");
        NotificationConfig config = new HNCloudConfig().getConfig();
        String endTime = (config == null || config.getUnValidDuration() == null) ? "" : config.getUnValidDuration().getEndTime();
        if (TextUtils.isEmpty(endTime)) {
            endTime = DEFAULT_END_TIME;
        }
        String validTargetTime = getValidTargetTime(endTime);
        NotifyLogger.m29915i(TAG, "getSilentNotifyEndTimeSeconds, endTime: " + validTargetTime);
        try {
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            LocalTime localTime = localDateTimeNow.toLocalTime();
            LocalTime localTime2 = LocalTime.parse(validTargetTime, DateTimeFormatter.ofPattern(Constants.TIME_FORMAT_WITHOUT_MILLS));
            LocalDateTime localDateTimeWith = localDateTimeNow.with((TemporalAdjuster) localTime2);
            if (localTime.isAfter(localTime2)) {
                localDateTimeWith = localDateTimeWith.plusDays(1L);
            }
            long millis = Duration.between(localDateTimeNow, localDateTimeWith).toMillis();
            NotifyLogger.m29915i(TAG, "getSilentNotifyEndTimeSeconds exit, differenceInMillis: " + millis);
            return millis > 0 ? millis : C5863b6.g.f26453g;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getSilentNotifyEndTimeSeconds, parse failed: " + e10.getMessage());
            return C5863b6.g.f26453g;
        }
    }

    public static String getSpiltStr(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < strArr.length - 1; i10++) {
            stringBuffer.append(strArr[i10]);
            stringBuffer.append(",");
        }
        stringBuffer.append(strArr[strArr.length - 1]);
        return stringBuffer.toString();
    }

    public static String getStringFromConfig(String str, boolean z10, List<CommonLanguageDbString> list) {
        return getStringFromConfig(str, true, z10, list);
    }

    public static String getStringFromDriveConfig(String str) {
        String currentLanguage = HNUtil.getCurrentLanguage();
        List<SyncConfigString> listQueryString = new DriveConfigLanguageOperator().queryString(currentLanguage, HNUtil.getCurrentBaseLanguage(), HNConstants.Language.EN_STANDARD, str);
        if (listQueryString == null || listQueryString.size() <= 0) {
            NotifyLogger.m29914e(TAG, "getStringFromDriveConfig no language configs, stringId = " + str);
            return null;
        }
        SyncConfigString syncConfigString = null;
        SyncConfigString syncConfigString2 = null;
        for (SyncConfigString syncConfigString3 : listQueryString) {
            String country = syncConfigString3.getCountry();
            if (country == null) {
                NotifyLogger.m29914e(TAG, "tmpLanguageName null, stringId=" + str);
            } else if (country.equals(currentLanguage)) {
                syncConfigString2 = syncConfigString3;
            } else if (country.equals(HNConstants.Language.EN_STANDARD)) {
                syncConfigString = syncConfigString3;
            }
        }
        if (syncConfigString != null) {
            listQueryString.remove(syncConfigString);
        }
        if (syncConfigString2 != null) {
            NotifyLogger.m29915i(TAG, "fullMatchString stringId=" + str);
            listQueryString.remove(syncConfigString2);
            syncConfigString = syncConfigString2;
        } else if (listQueryString.size() > 0) {
            NotifyLogger.m29915i(TAG, "partMatch stringId=" + str);
            SyncConfigString syncConfigString4 = listQueryString.get(0);
            syncConfigString = syncConfigString4 != null ? syncConfigString4 : null;
        } else {
            NotifyLogger.m29915i(TAG, "no match, using default stringId=" + str);
        }
        if (syncConfigString != null) {
            return syncConfigString.getValue();
        }
        return null;
    }

    public static String getStringFromSyncConfig(String str) {
        String currentLanguage = HNUtil.getCurrentLanguage();
        List<SyncConfigString> listQueryString = new SyncConfigLanguageOperator().queryString(currentLanguage, HNUtil.getCurrentBaseLanguage(), HNConstants.Language.EN_STANDARD, str);
        if (C0209d.m1205R0(listQueryString)) {
            NotifyLogger.m29914e(TAG, "getStringFromSyncConfig no language configs,stringId=" + str);
            return null;
        }
        SyncConfigString syncConfigString = null;
        SyncConfigString syncConfigString2 = null;
        for (SyncConfigString syncConfigString3 : listQueryString) {
            String country = syncConfigString3.getCountry();
            if (country == null) {
                NotifyLogger.m29914e(TAG, "tmpLanguageName null, stringId=" + str);
            } else if (country.equals(currentLanguage)) {
                syncConfigString2 = syncConfigString3;
            } else if (country.equals(HNConstants.Language.EN_STANDARD)) {
                syncConfigString = syncConfigString3;
            }
        }
        if (syncConfigString != null) {
            listQueryString.remove(syncConfigString);
        }
        if (syncConfigString2 != null) {
            NotifyLogger.m29915i(TAG, "fullMatchString stringId=" + str);
            listQueryString.remove(syncConfigString2);
            syncConfigString = syncConfigString2;
        } else if (listQueryString.size() > 0) {
            NotifyLogger.m29915i(TAG, "partMatch stringId=" + str);
            SyncConfigString syncConfigString4 = listQueryString.get(0);
            syncConfigString = syncConfigString4 != null ? syncConfigString4 : null;
        } else {
            NotifyLogger.m29915i(TAG, "no match, using default stringId=" + str);
        }
        if (syncConfigString != null) {
            return syncConfigString.getValue();
        }
        return null;
    }

    public static ArrayList<DriveConfigService> getSubpageList(Context context, boolean z10) {
        ArrayList<DriveConfigService> arrayList = new ArrayList<>();
        ArrayList<DriveConfigService> arrayList2 = new ArrayList<>();
        ArrayList<DriveConfigService> shownDriveServiceItems = getShownDriveServiceItems(context);
        if (shownDriveServiceItems.isEmpty()) {
            NotifyLogger.m29915i(TAG, "getShowSubpageList services is empty");
            return shownDriveServiceItems;
        }
        for (int i10 = 0; i10 < shownDriveServiceItems.size(); i10++) {
            DriveConfigService driveConfigService = shownDriveServiceItems.get(i10);
            if (driveConfigService != null) {
                if (isSupportDriveSubpage(driveConfigService)) {
                    arrayList.add(driveConfigService);
                } else {
                    arrayList2.add(driveConfigService);
                }
            }
        }
        return z10 ? arrayList : arrayList2;
    }

    public static List<String> getSyncTypes() {
        NotifyLogger.m29915i(TAG, "getSyncTypes");
        ArrayList arrayList = new ArrayList();
        arrayList.add("addressbook");
        arrayList.add("browser");
        arrayList.add("calendar");
        arrayList.add(NOTE_PAD_SYNC_TYPE);
        arrayList.add("wlan");
        arrayList.add("atlas");
        return arrayList;
    }

    private static String getValidTargetTime(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.TIME_FORMAT_WITHOUT_MILLS, Locale.getDefault());
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(str);
            return str;
        } catch (ParseException unused) {
            return DEFAULT_END_TIME;
        }
    }

    public static Intent geteFinalDeepLinkIntent(String str, long j10) {
        try {
            Uri uri = Uri.parse(str);
            if (TextUtils.isEmpty(uri.getHost())) {
                NotifyLogger.m29916w(TAG, "geteFinalDeepLinkIntent deeplinkUri host is empty!");
                return null;
            }
            if (TextUtils.isEmpty(uri.getAuthority())) {
                NotifyLogger.m29916w(TAG, "geteFinalDeepLinkIntent deeplinkUri authority is empty!");
                return null;
            }
            Set<String> setM63705c = C10344c.m63705c(uri);
            Uri.Builder builderBuildUpon = uri.buildUpon();
            if (setM63705c.contains("url")) {
                builderBuildUpon.clearQuery();
                for (String str2 : setM63705c) {
                    if (!TextUtils.isEmpty(str2)) {
                        String strM63704b = C10344c.m63704b(uri, str2);
                        if (str2.equals("url")) {
                            strM63704b = getDeepLinkQuery(strM63704b, j10);
                        }
                        builderBuildUpon.appendQueryParameter(str2, strM63704b);
                    }
                }
            }
            return Intent.parseUri(builderBuildUpon.toString(), 1);
        } catch (RuntimeException | URISyntaxException e10) {
            NotifyLogger.m29914e(TAG, "geteFinalDeepLinkIntent err : " + e10.toString());
            return null;
        }
    }

    public static boolean isAppFingerPrintValid(Context context, String str, String str2) {
        NotifyLogger.m29915i(TAG, "isAppFingerPrintValid: syncType " + str + ", pkgName " + str2);
        if (("com.example.android.notepad".equals(str2) || NextRestoreConstants.PKG_NAME_MEMO.equals(str2)) && HI_NOTE_SYNC_TYPE.equals(str)) {
            if (checkNotepadSignatures(context, str2)) {
                NotifyLogger.m29915i(TAG, "notepad has signature match.");
                return true;
            }
            NotifyLogger.m29915i(TAG, "notepad has no signature match, return false.");
            return false;
        }
        SyncConfigOperator syncConfigOperator = new SyncConfigOperator();
        SyncConfigService serviceById = (HINOTE_PKG_NAME.equals(str2) && NOTE_PAD_SYNC_TYPE.equals(str)) ? syncConfigOperator.getServiceById(HI_NOTE_SYNC_TYPE) : syncConfigOperator.getServiceById(str);
        if (serviceById == null) {
            NotifyLogger.m29914e(TAG, "isAppFingerPrintValid: service config is null. syncType:" + str);
            return false;
        }
        String[] applications = serviceById.getApplications();
        if (!TextUtils.isEmpty(str2) && applications.length != 0 && isContainsPkg(serviceById.getApplications(), str2)) {
            return !isFingerPrintEmpty(serviceById) && isAppFingerPrintValid(context, serviceById);
        }
        NotifyLogger.m29914e(TAG, "isAppFingerPrintValid: pkg not in service's applications.");
        return false;
    }

    private static boolean isContainsPkg(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDialogSilent(Context context, BaseNotifyBean baseNotifyBean) {
        if (C0209d.m1185K1(context)) {
            return false;
        }
        return isSilentNotifyTime(baseNotifyBean);
    }

    public static boolean isDriveApplicationLegal(Context context, DriveConfigService driveConfigService) {
        NotifyLogger.m29915i(TAG, "isDriveApplicationLegal");
        if (context == null || driveConfigService == null) {
            NotifyLogger.m29914e(TAG, "isDriveApplicationLegal: context or service is null");
            return false;
        }
        String[] pkgNames = driveConfigService.getPkgNames();
        String[] signHash = driveConfigService.getSignHash();
        if (pkgNames.length == 0 || signHash.length == 0) {
            NotifyLogger.m29914e(TAG, "pkgNames or signHashFormOm is empty");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : pkgNames) {
            arrayList.add(getSignForPkgName(context, str));
        }
        if (getSamesLambda((String[]) arrayList.toArray(new String[0]), signHash).size() != 0) {
            return true;
        }
        NotifyLogger.m29914e(TAG, "no same signHash");
        return false;
    }

    public static boolean isDriveSerivceResourcOk(DriveConfigService driveConfigService) {
        if (driveConfigService == null) {
            NotifyLogger.m29916w(TAG, "drive service is null");
            return false;
        }
        if (TextUtils.isEmpty(driveConfigService.getId())) {
            NotifyLogger.m29916w(TAG, "drive service id is null");
            return false;
        }
        String strServiceGetMultiLanguageName = serviceGetMultiLanguageName(driveConfigService.getName());
        if (TextUtils.isEmpty(strServiceGetMultiLanguageName)) {
            NotifyLogger.m29916w(TAG, "no multi language text, drive service id is " + driveConfigService.getId());
            return false;
        }
        driveConfigService.setTitleText(strServiceGetMultiLanguageName);
        Bitmap bitmapServiceGetIconBitmap = serviceGetIconBitmap(driveConfigService);
        if (bitmapServiceGetIconBitmap != null) {
            driveConfigService.setIconDrawable(new BitmapDrawable((Resources) null, bitmapServiceGetIconBitmap));
            return true;
        }
        NotifyLogger.m29916w(TAG, "no icon, drive service id is " + driveConfigService.getId());
        return false;
    }

    public static boolean isFingerPrintEmpty(SyncConfigService syncConfigService) {
        String[] fingerPrints = syncConfigService.getFingerPrints();
        if (fingerPrints.length == 0) {
            NotifyLogger.m29916w(TAG, "the finger print list is empty");
            return true;
        }
        for (String str : fingerPrints) {
            if (TextUtils.isEmpty(str)) {
                NotifyLogger.m29916w(TAG, "finger print item is empty");
                return true;
            }
        }
        return false;
    }

    private static boolean isFingerPrintSame(Context context, SyncConfigService syncConfigService) {
        String[] applications = syncConfigService.getApplications();
        if (applications.length == 0) {
            NotifyLogger.m29913d(TAG, "the pkg names is empty");
            return true;
        }
        List listAsList = Arrays.asList(syncConfigService.getFingerPrints());
        for (String str : applications) {
            Map<String, String> map = PKG_SIGNATURE_MAP;
            String signForPkgName = map.get(str);
            if (TextUtils.isEmpty(signForPkgName)) {
                signForPkgName = getSignForPkgName(context, str);
                if (TextUtils.isEmpty(signForPkgName)) {
                    return false;
                }
                map.put(str, signForPkgName);
            }
            if (listAsList.contains(signForPkgName)) {
                return true;
            }
        }
        return false;
    }

    private static ServiceShownStatus isShowDriveServiceItem(Context context, DriveConfigService driveConfigService) {
        ServiceShownStatus serviceShownStatus = new ServiceShownStatus();
        serviceShownStatus.isShown = false;
        if (!serviceSupportMinDriveVersion(driveConfigService)) {
            serviceShownStatus.errorInfo = "not support min sync version.";
            return serviceShownStatus;
        }
        if (!serviceSupportDriveAbility(context, driveConfigService)) {
            serviceShownStatus.errorInfo = "not support SyncAbility.";
            return serviceShownStatus;
        }
        if (!omConfigSupportMinVersion(driveConfigService)) {
            serviceShownStatus.errorInfo = "not support OmConfigVersion.";
            return serviceShownStatus;
        }
        if (!isDriveApplicationLegal(context, driveConfigService)) {
            serviceShownStatus.errorInfo = "not support DriveApplicationLegal.";
            return serviceShownStatus;
        }
        if (!serviceEnable(driveConfigService.getId())) {
            serviceShownStatus.errorInfo = "service not enable.";
            return serviceShownStatus;
        }
        String strServiceGetMultiLanguageName = serviceGetMultiLanguageName(driveConfigService.getName());
        if (TextUtils.isEmpty(strServiceGetMultiLanguageName)) {
            serviceShownStatus.errorInfo = "no multi language text";
            return serviceShownStatus;
        }
        serviceShownStatus.titleText = strServiceGetMultiLanguageName;
        Bitmap bitmapServiceGetIconBitmap = serviceGetIconBitmap(driveConfigService);
        if (bitmapServiceGetIconBitmap == null) {
            serviceShownStatus.errorInfo = "no icon.";
            return serviceShownStatus;
        }
        serviceShownStatus.iconDrawable = new BitmapDrawable((Resources) null, bitmapServiceGetIconBitmap);
        serviceShownStatus.isShown = true;
        return serviceShownStatus;
    }

    private static ServiceShownStatus isShowSyncServiceItem(Context context, SyncConfigService syncConfigService) {
        ServiceShownStatus serviceShownStatus = new ServiceShownStatus();
        serviceShownStatus.isShown = false;
        if (syncConfigService == null) {
            serviceShownStatus.errorInfo = "service is null";
            return serviceShownStatus;
        }
        String id2 = syncConfigService.getId();
        if (TextUtils.isEmpty(id2)) {
            serviceShownStatus.errorInfo = "service id is null";
            return serviceShownStatus;
        }
        if (!checkPackageNameValid(context, syncConfigService)) {
            serviceShownStatus.errorInfo = "service not valid, serviceId: " + id2;
            return serviceShownStatus;
        }
        if (!serviceSupportCurrentEncrypt(syncConfigService)) {
            serviceShownStatus.errorInfo = "service not support current encrypt status. service id = " + id2;
            return serviceShownStatus;
        }
        if (!serviceSupportMinSyncVersion(syncConfigService)) {
            serviceShownStatus.errorInfo = "service not support current encrypt min sync version. service id = " + id2;
            return serviceShownStatus;
        }
        if (!serviceSupportSyncAbility(context, syncConfigService)) {
            serviceShownStatus.errorInfo = "package not support SyncAbility. service id = " + id2;
            return serviceShownStatus;
        }
        if (!serviceEnable(syncConfigService.getId())) {
            serviceShownStatus.errorInfo = "service not enable. service id = " + id2;
            return serviceShownStatus;
        }
        if (!serviceSupportSubUser(syncConfigService)) {
            serviceShownStatus.errorInfo = "sub user disable. serviceId : " + id2;
            return serviceShownStatus;
        }
        if (TextUtils.equals(syncConfigService.getId(), "huaweiaireader") && !C0224k0.m1567v()) {
            serviceShownStatus.errorInfo = "current system not harmonyOs, not shown switch. serviceId : " + id2;
            return serviceShownStatus;
        }
        String strServiceGetMultiLanguageName = serviceGetMultiLanguageName(syncConfigService);
        if (TextUtils.isEmpty(strServiceGetMultiLanguageName)) {
            serviceShownStatus.errorInfo = "no multi language text, service id is " + syncConfigService.getId();
            return serviceShownStatus;
        }
        serviceShownStatus.titleText = strServiceGetMultiLanguageName;
        Bitmap bitmapServiceGetIconBitmap = serviceGetIconBitmap(syncConfigService);
        if (bitmapServiceGetIconBitmap != null) {
            serviceShownStatus.iconDrawable = new BitmapDrawable((Resources) null, bitmapServiceGetIconBitmap);
            serviceShownStatus.isShown = true;
            return serviceShownStatus;
        }
        serviceShownStatus.errorInfo = "no icon, service id is " + syncConfigService.getId();
        return serviceShownStatus;
    }

    public static boolean isSilentDelay() {
        return C9733f.m60705z().m60720O("dialogSilentDelay");
    }

    public static boolean isSilentNotifyTime() {
        String startTime;
        String endTime;
        NotificationConfig config = new HNCloudConfig().getConfig();
        if (config == null || config.getUnValidDuration() == null) {
            startTime = "";
            endTime = "";
        } else {
            startTime = config.getUnValidDuration().getStartTime();
            endTime = config.getUnValidDuration().getEndTime();
        }
        return checkSilentNotifyTimeWithDefault(startTime, endTime);
    }

    public static boolean isSupportDriveSubpage(DriveConfigService driveConfigService) {
        try {
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "styleConfigSupportMinVersion Exception" + e10.getMessage());
        }
        return Integer.parseInt(driveConfigService.getStyle()) == 1;
    }

    public static boolean isSyncSerivceResourcOk(SyncConfigService syncConfigService) {
        if (syncConfigService == null) {
            NotifyLogger.m29916w(TAG, "sync service is null");
            return false;
        }
        if (TextUtils.isEmpty(syncConfigService.getId())) {
            NotifyLogger.m29916w(TAG, "sync service id is null");
            return false;
        }
        String strServiceGetMultiLanguageName = serviceGetMultiLanguageName(syncConfigService);
        if (TextUtils.isEmpty(strServiceGetMultiLanguageName)) {
            NotifyLogger.m29916w(TAG, "no multi language text, sync service id is " + syncConfigService.getId());
            return false;
        }
        syncConfigService.setTitleText(strServiceGetMultiLanguageName);
        Bitmap bitmapServiceGetIconBitmap = serviceGetIconBitmap(syncConfigService);
        if (bitmapServiceGetIconBitmap != null) {
            syncConfigService.setIconDrawable(new BitmapDrawable((Resources) null, bitmapServiceGetIconBitmap));
            return true;
        }
        NotifyLogger.m29916w(TAG, "no icon, sync service id is " + syncConfigService.getId());
        return false;
    }

    public static boolean isTargetAppInWhitelist(Context context, Uri uri, String str) {
        if (context == null || uri == null || uri.getAuthority() == null) {
            NotifyLogger.m29916w(TAG, "isTargetAppInWhitelist context or uri is null");
            return false;
        }
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            NotifyLogger.m29915i(TAG, "not find uri: " + uri.toString());
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str2 = applicationInfo.packageName;
        NotifyLogger.m29915i(TAG, "provider packageName is: " + str2);
        boolean zIsAppFingerPrintValid = isAppFingerPrintValid(context, str, str2);
        NotifyLogger.m29915i(TAG, "isTargetAppInWhitelist: isAppFingerPrintValid " + zIsAppFingerPrintValid);
        return zIsAppFingerPrintValid;
    }

    public static /* synthetic */ boolean lambda$getSamesLambda$0(Set set, String str) {
        return !set.add(str);
    }

    public static void notifyBuildReportCollect(Intent intent, NotificationWithActivity notificationWithActivity, NoticeWithActivityGoto noticeWithActivityGoto, String str) {
        intent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, str);
        intent.putExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, true);
        intent.putExtra(HNConstants.C4906BI.FROM_NOTIFY, true);
        intent.putExtra(HNConstants.C4906BI.BI_KEY_CLICK_FROM_NOTIFY, "DYNAMIC_NOTIFY_CLICK");
        intent.putExtra(HNConstants.C4906BI.DATA_TYPE_ID, "" + notificationWithActivity.getId());
        intent.putExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, "2");
        intent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
        intent.putExtra("user_tags_key", C13622a.m81963i());
        intent.putExtra("scene_id", getReportSceneId(notificationWithActivity.getNoticeType()));
        Bundle bundle = new Bundle();
        String notiType = (TextUtils.equals("detail", noticeWithActivityGoto.getNotiType()) || TextUtils.equals("close", noticeWithActivityGoto.getNotiType())) ? noticeWithActivityGoto.getNotiType() : noticeWithActivityGoto.getNotiUri();
        bundle.putInt(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, SpaceNoticeCommonSpUtil.getInstance().getCType(notificationWithActivity.getNoticeType()));
        bundle.putString(HNConstants.C4906BI.KEY_OF_GOTO_URI_VALUE, notiType);
        intent.putExtra(HNConstants.C4906BI.DATA_OF_ACTIVITY_INFO, bundle);
    }

    private static boolean omConfigSupportMinVersion(DriveConfigService driveConfigService) {
        try {
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "omConfigSupportMinVersion Exception" + e10.getMessage());
        }
        return Integer.parseInt(driveConfigService.getVersion()) == 1;
    }

    private static List<NotepadAppInfo> parseNotepadAppInfos(String str) {
        try {
            List list = (List) new Gson().fromJson(str, List.class);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof LinkedTreeMap) {
                    LinkedTreeMap linkedTreeMap = (LinkedTreeMap) obj;
                    String str2 = (String) linkedTreeMap.get("packageName");
                    String str3 = (String) linkedTreeMap.get(SIGN_HASH_KEY);
                    NotepadAppInfo notepadAppInfo = new NotepadAppInfo();
                    notepadAppInfo.setPackageName(str2);
                    notepadAppInfo.setSignHash(str3);
                    arrayList.add(notepadAppInfo);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            NotifyLogger.m29914e(TAG, "parseNotepadAppInfos: error when fromGson notepadAppInfos.");
            return new ArrayList();
        }
    }

    public static boolean procFlowControlException(C9721b c9721b, String str) {
        boolean zM60720O = C9733f.m60705z().m60720O("downloadOMConfigFileFlowControl");
        NotifyLogger.m29915i(TAG, "procFlowControlException  configPoint: " + str + "  e.getCode: " + c9721b.m60659c() + "  e.getStatus: " + c9721b.m60663g() + "  isGrayFlowControlOpen: " + zM60720O);
        if (!zM60720O) {
            return false;
        }
        if (c9721b.m60659c() == 304) {
            C9734g.m60767a().m60769c(str);
            return false;
        }
        if (c9721b.m60663g() != 503) {
            return false;
        }
        C10028c.m62182c0().m62402u3(SystemClock.elapsedRealtime() - C10028c.m62182c0().m62409w0(str), str);
        C10028c.m62182c0().m62261P3(str);
        C10028c.m62182c0().m62357l3(SystemClock.elapsedRealtime(), str);
        C10028c.m62182c0().m62310c(str);
        C11498b.m68645a().m68647c();
        C11498b.m68645a().m68646b();
        return true;
    }

    private static void processReport(Context context, StringBuilder sb2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, NotifyConstants.CloudSyncItemReportConstants.SYNC_ITEM_SHOWN_REPORT_STATUS_SP_NAME, 0);
        long j10 = sharedPreferencesM1382b.getLong(NotifyConstants.CloudSyncItemReportConstants.LAST_REPORT_TIME, 0L);
        SharedPreferences.Editor editorEdit = sharedPreferencesM1382b.edit();
        if (jCurrentTimeMillis - j10 < 43200000) {
            int i10 = sharedPreferencesM1382b.getInt(NotifyConstants.CloudSyncItemReportConstants.REPORT_COUNT, 0) + 1;
            if (i10 <= 10) {
                editorEdit.putString(String.valueOf(i10), sb2.toString());
                editorEdit.putInt(NotifyConstants.CloudSyncItemReportConstants.REPORT_COUNT, i10);
                editorEdit.apply();
                return;
            }
            return;
        }
        int i11 = sharedPreferencesM1382b.getInt(NotifyConstants.CloudSyncItemReportConstants.REPORT_COUNT, 0);
        if (i11 > 0) {
            for (int i12 = 1; i12 <= i11; i12++) {
                sb2.append(sharedPreferencesM1382b.getString(String.valueOf(i12), ""));
            }
        }
        editorEdit.clear().commit();
        editorEdit.putLong(NotifyConstants.CloudSyncItemReportConstants.LAST_REPORT_TIME, jCurrentTimeMillis).commit();
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07007"), "07007", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        HashMap map = new HashMap();
        map.put("reportInfo", sb2.toString());
        C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
    }

    public static void reportCloudSpaceActivityShow(Context context, NotificationWithActivity notificationWithActivity, boolean z10) throws JSONException {
        JSONObject jSONObjectM79482j = C13223b.m79482j(context, "DYNAMIC_NOTIFY_SHOW", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79482j.put("notify_id", notificationWithActivity.getId());
            jSONObjectM79482j.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, notificationWithActivity.getActivityType());
            jSONObjectM79482j.put("notify_type", "1");
            jSONObjectM79482j.put(HNConstants.C4906BI.BI_PERCENTAGE, notificationWithActivity.getPercentage());
            jSONObjectM79482j.put("scene_id", getReportSceneId(notificationWithActivity.getNoticeType()));
        } catch (JSONException e10) {
            NotifyLogger.m29914e(TAG, "ERROR OCCUR:" + e10.getMessage());
        }
        C13227f.m79492i1().m79602z(jSONObjectM79482j);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_SHOW", "4", "6", jSONObjectM79482j);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("type", String.valueOf(notificationWithActivity.getId()));
        linkedHashMapM79497A.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, String.valueOf(notificationWithActivity.getActivityType()));
        linkedHashMapM79497A.put("is_silent_noti", String.valueOf(z10));
        linkedHashMapM79497A.put(HNConstants.C4906BI.BI_PERCENTAGE, String.valueOf(notificationWithActivity.getPercentage()));
        linkedHashMapM79497A.put("scene_id", getReportSceneId(notificationWithActivity.getNoticeType()));
        C13227f.m79492i1().m79591l0("mecloud_notify_cloudspace_show", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "mecloud_notify_cloudspace_show", "4", "6", linkedHashMapM79497A);
        NotificationReportUtil.reportSpaceNotifyActivityShow(linkedHashMapM79497A);
    }

    public static void reportStrError(Context context, String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06011"), "06011", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(str);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(context, c11060cM66626a, linkedHashMap);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "reportStrError err = " + e10.getMessage());
        }
    }

    public static void sendForceUpgradeBroadcast() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "sendForceUpgradeBroadcast context null");
        } else {
            C13108a.m78878b(contextM1377a).m78881d(new Intent(NotifyConstants.Broadcacst.ACTION_PROCESS_FORCE_UPGRADE));
        }
    }

    public static void sendForceUpgradeFromServerCodeBroadcast(int i10) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "sendForceUpgradeFromServerCodeBroadcast context null");
            return;
        }
        Intent intent = new Intent(NotifyConstants.Broadcacst.ACTION_PROCESS_FORCE_UPGRADE_FROM_SERVER_CODE);
        intent.putExtra(NotifyConstants.Broadcacst.FORCE_GRADE_ERROR_CODE, i10);
        C13108a.m78878b(contextM1377a).m78881d(intent);
    }

    public static void sendShowNotifyBroadcast(Bundle bundle) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "sendSyncLimitConfigBroadcast context null");
            return;
        }
        Intent intent = new Intent(NotifyConstants.Broadcacst.ACTION_SHOW_NOTIFY_FOR_ALBUM);
        intent.putExtras(bundle);
        C13108a.m78878b(contextM1377a).m78881d(intent);
    }

    public static void sendSyncLimitConfigBroadcast(int i10, int i11, int i12, int i13) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "sendSyncLimitConfigBroadcast context null");
            return;
        }
        Intent intent = new Intent(NotifyConstants.Broadcacst.ACTION_SYNC_LIMIT_CONFIG);
        intent.putExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_DOWNLOAD_MAX_NUM, i12);
        intent.putExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_UPLOAD_MAX_NUM, i10);
        intent.putExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_UPLOAD_MAX_SIZE, i11);
        intent.putExtra(NotifyConstants.Broadcacst.SYNC_LIMIT_CONFIG_DOWNLOAD_NUM, i13);
        C13108a.m78878b(contextM1377a).m78881d(intent);
    }

    private static boolean serviceEnable(String str) {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "service id is null or empty ");
            return false;
        }
        return C10028c.m62182c0().m62395t1("funcfg_" + str);
    }

    private static Bitmap serviceGetIconBitmap(SyncConfigService syncConfigService) {
        if (syncConfigService == null) {
            return null;
        }
        String iconPath = syncConfigService.getIconPath();
        if (TextUtils.isEmpty(iconPath)) {
            NotifyLogger.m29914e(TAG, "filePath is null or empty");
            return null;
        }
        Bitmap bitmapM1311u = C0209d.m1311u(iconPath);
        if (bitmapM1311u != null) {
            return bitmapM1311u;
        }
        NotifyLogger.m29914e(TAG, "bitmap is null, service id is " + syncConfigService.getId());
        return null;
    }

    private static String serviceGetMultiLanguageName(SyncConfigService syncConfigService) {
        if (syncConfigService == null) {
            return null;
        }
        String name = syncConfigService.getName();
        if (TextUtils.isEmpty(name)) {
            NotifyLogger.m29914e(TAG, "name is null or empty");
            return null;
        }
        String stringFromSyncConfig = getStringFromSyncConfig(name);
        if (!TextUtils.isEmpty(stringFromSyncConfig)) {
            return stringFromSyncConfig;
        }
        NotifyLogger.m29914e(TAG, "no multi language text, service id is " + syncConfigService.getId());
        return null;
    }

    private static boolean serviceSupportCurrentEncrypt(SyncConfigService syncConfigService) {
        if (syncConfigService == null) {
            return false;
        }
        boolean zM62420y1 = C10028c.m62182c0().m62420y1();
        NotifyLogger.m29915i(TAG, "serviceSupportCurrentEncrypt, isNoEncryptionProcess = " + zM62420y1);
        int supportServer = syncConfigService.getSupportServer();
        NotifyLogger.m29915i(TAG, "serviceSupportCurrentEncrypt, supportServerStatus " + supportServer);
        if (supportServer == 0) {
            return false;
        }
        if (supportServer != 1) {
            if (supportServer != 2) {
                if (supportServer != 3) {
                    return false;
                }
            } else if (zM62420y1) {
                return false;
            }
        } else if (!zM62420y1) {
            return false;
        }
        return true;
    }

    private static boolean serviceSupportDriveAbility(Context context, DriveConfigService driveConfigService) {
        if (driveConfigService == null) {
            return false;
        }
        String[] pkgNames = driveConfigService.getPkgNames();
        if (pkgNames.length <= 0) {
            NotifyLogger.m29914e(TAG, "serviceSupportDriveAbility: packageNames is 0");
            return false;
        }
        for (String str : pkgNames) {
            NotifyLogger.m29915i(TAG, "serviceSupportDriveAbility: " + str);
            if (TextUtils.isEmpty(str)) {
                NotifyLogger.m29914e(TAG, "serviceSupportDriveAbility: packageName is empty");
            } else if (C0209d.m1218V1(context, str)) {
                return true;
            }
        }
        NotifyLogger.m29915i(TAG, "serviceSupportDriveAbility: not support DriveAbility");
        return false;
    }

    private static boolean serviceSupportMinDriveVersion(DriveConfigService driveConfigService) {
        int minSyncVersion = driveConfigService.getMinSyncVersion();
        NotifyLogger.m29915i(TAG, "min version is " + minSyncVersion + ", Current version is 102");
        return minSyncVersion >= 100 && 102 >= minSyncVersion;
    }

    private static boolean serviceSupportMinSyncVersion(SyncConfigService syncConfigService) {
        boolean zM62420y1 = C10028c.m62182c0().m62420y1();
        NotifyLogger.m29915i(TAG, "serviceSupportMinSyncVersion, isNoEncryptionProcess = " + zM62420y1);
        if (zM62420y1) {
            int minSyncVersion = syncConfigService.getMinSyncVersion();
            NotifyLogger.m29915i(TAG, "NoEncryptionProcess, service min sync version is " + minSyncVersion + ", Current sync version is 103");
            return minSyncVersion >= 100 && 103 >= minSyncVersion;
        }
        int minSyncVersionObs = syncConfigService.getMinSyncVersionObs();
        NotifyLogger.m29915i(TAG, "EncryptionProcess, service min sync version obs is " + minSyncVersionObs + ", Current sync version obs is 103");
        return minSyncVersionObs >= 100 && 103 >= minSyncVersionObs;
    }

    private static boolean serviceSupportSubUser(SyncConfigService syncConfigService) {
        if (syncConfigService.isSubUser() || C0209d.m1166E1()) {
            return true;
        }
        NotifyLogger.m29915i(TAG, "getShownSyncServiceItems module do not support sub user, but current is sub user");
        return false;
    }

    private static boolean serviceSupportSyncAbility(Context context, SyncConfigService syncConfigService) {
        if (syncConfigService == null) {
            return false;
        }
        String[] applications = syncConfigService.getApplications();
        if (applications.length <= 0) {
            NotifyLogger.m29914e(TAG, "serviceSupportSyncAbility: packageNames length is 0");
            return false;
        }
        for (String str : applications) {
            NotifyLogger.m29915i(TAG, "serviceSupportSyncAbility: = " + str);
            if (TextUtils.isEmpty(str)) {
                NotifyLogger.m29914e(TAG, "serviceSupportSyncAbility: packageName is null or empty");
            } else if (C0209d.m1221W1(context, str)) {
                return true;
            }
        }
        NotifyLogger.m29914e(TAG, "serviceSupportSyncAbility: packages not support SyncAbility");
        return false;
    }

    public static boolean checkTimeRange(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            NotifyLogger.m29914e(TAG, "checkTimeRange startTime or endTime is null");
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3, Locale.getDefault());
        try {
            return checkTimeRangeTwo(simpleDateFormat.parse(simpleDateFormat.format(new Date())), simpleDateFormat.parse(str), simpleDateFormat.parse(str2));
        } catch (ParseException e10) {
            NotifyLogger.m29914e(TAG, "checkTimeRange ParseException exception: " + e10.toString());
            return false;
        }
    }

    public static PendingIntent getExtraNoticePendingIntent(Context context, ExtraNotificationBean extraNotificationBean, int i10, int i11, String str, String str2) {
        if (extraNotificationBean == null) {
            NotifyLogger.m29916w(TAG, "getExtraNoticePendingIntent extraNotificationBean is null");
            return null;
        }
        Intent extraNoticePendingNeedIntent = getExtraNoticePendingNeedIntent(context, extraNotificationBean, str);
        if (extraNoticePendingNeedIntent == null) {
            NotifyLogger.m29914e(TAG, "getExtraNoticePendingIntent getPendingNeedIntent is null.");
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            extraNoticePendingNeedIntent.putExtra("unique_id", str2);
        }
        extraNoticePendingNeedIntent.putExtra(HNConstants.C4906BI.BI_NOTIFY_TYPE, "2");
        extraNoticePendingNeedIntent.putExtra(HNConstants.C4906BI.BI_CLOUD_SPACE_TYPE, "1");
        extraNoticePendingNeedIntent.putExtra(HNConstants.C4906BI.BI_PERCENTAGE, extraNotificationBean.getPercentage());
        extraNoticePendingNeedIntent.putExtra("user_tags_key", C13622a.m81963i());
        extraNoticePendingNeedIntent.putExtra("scene_id", getReportSceneId(extraNotificationBean.getNoticeType()));
        C13222a.m79471m(extraNoticePendingNeedIntent, i11);
        C0216g0.m1402e(context).m1408F(extraNoticePendingNeedIntent, extraNotificationBean.getNoticeType() + "_" + extraNotificationBean.getId());
        return buildExtraNoticePendingIntent(context, extraNotificationBean, extraNoticePendingNeedIntent, i10);
    }

    public static Intent getGotoIntent(Context context, String str, String str2, String str3) {
        Intent intent;
        if (context == null) {
            NotifyLogger.m29914e(TAG, "getGotoIntent context is null");
            return null;
        }
        if (NotifyConstants.HICLOUD_DLAPP.equals(str2)) {
            if (TextUtils.isEmpty(str3)) {
                NotifyLogger.m29914e(TAG, "getGotoIntent h5ActivityUrl is null");
                return null;
            }
            try {
                return getDlAppWebViewIntent(context, str3);
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "getNoticeActivityGotoIntent e:" + e10.toString());
                return null;
            }
        }
        if (NotifyConstants.HICLOUD_CENTER.equals(str2)) {
            return C13823d.m82904y().m82934r(6);
        }
        intent = new Intent();
        str.hashCode();
        switch (str) {
            case "detail":
                intent.setAction(NotifyConstants.Action.SPACE_GUIDE_ACTION);
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                break;
            case "application":
                if (!NotifyConstants.HICLOUD_GALLERY.equals(str2)) {
                    Class<?> cls = NotifyConstants.getGotoAppMapping().get(str2);
                    if (cls != null) {
                        intent.setClass(context, cls);
                        if (NotifyConstants.BUY_MORE.equals(str2)) {
                            intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
                            intent.putExtra("from_where", 11);
                            break;
                        }
                    } else {
                        NotifyLogger.m29914e(TAG, "no uri match, return null, uri is: " + str2);
                        break;
                    }
                } else {
                    intent.setClass(context, CommonNotifyReceiver.class);
                    intent.setAction(CommonNotifyReceiver.COMMON_ACTION);
                    intent.putExtra("requestId", 10002);
                    break;
                }
                break;
            case "detail2":
                intent.setAction(NotifyConstants.Action.SPACE_CLOUDBACKUP_GUIDE_ACTION);
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                break;
            case "detail3":
                intent.setAction(NotifyConstants.Action.SPACE_INSUFFICIENT_NEW_ACTIVITY_ACTION);
                C0209d.m1302r2(intent, "com.huawei.hidisk");
                intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
                break;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getStringFromConfig(java.lang.String r9, boolean r10, boolean r11, java.util.List<com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString> r12) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.util.NotifyUtil.getStringFromConfig(java.lang.String, boolean, boolean, java.util.List):java.lang.String");
    }

    public static NotificationCompat.Builder getNotificationBuilder(boolean z10, String str, int i10, String str2) {
        Context contextM1377a = C0213f.m1377a();
        if (z10) {
            return C0235t.m1645e().m1649h(contextM1377a, str, "2", contextM1377a.getString(R$string.channel_backup_notification), i10, str2);
        }
        return C0238w.m1663f().m1670k(contextM1377a, str, i10, str2);
    }

    public static Bitmap serviceGetIconBitmap(DriveConfigService driveConfigService) {
        if (driveConfigService == null) {
            return null;
        }
        String iconPath = driveConfigService.getIconPath();
        if (TextUtils.isEmpty(iconPath)) {
            NotifyLogger.m29914e(TAG, "filePath is null or empty");
            return null;
        }
        Bitmap bitmapM1311u = C0209d.m1311u(iconPath);
        if (bitmapM1311u != null) {
            return bitmapM1311u;
        }
        NotifyLogger.m29914e(TAG, "bitmap is null, service id is " + driveConfigService.getId());
        return null;
    }

    public static boolean isSilentNotifyTime(BaseNotifyBean baseNotifyBean) {
        if (baseNotifyBean == null) {
            NotifyLogger.m29914e(TAG, "isSilentNotify, notifyBean is null");
            return false;
        }
        List<SilenceDurationBean> silencePeriod = baseNotifyBean.getSilencePeriod();
        if (silencePeriod == null) {
            NotifyLogger.m29914e(TAG, "isSilentNotify, silenceDurations is null");
            return false;
        }
        Iterator<SilenceDurationBean> it = silencePeriod.iterator();
        while (it.hasNext()) {
            if (checkSilentNotifyTime(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String serviceGetMultiLanguageName(String str) {
        if (C4633d0.m28404a(str)) {
            NotifyLogger.m29914e(TAG, "driveConfigText is null or empty");
            return "";
        }
        String stringFromDriveConfig = getStringFromDriveConfig(str);
        if (!TextUtils.isEmpty(stringFromDriveConfig)) {
            return stringFromDriveConfig;
        }
        NotifyLogger.m29914e(TAG, "no multi language text");
        return "";
    }

    public static boolean isTargetAppInWhitelist(Context context, Uri uri) throws Throwable {
        if (context == null || uri == null || uri.getAuthority() == null) {
            NotifyLogger.m29916w(TAG, "isTargetAppInWhitelist context or uri is null");
            return false;
        }
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            NotifyLogger.m29916w(TAG, "not find uri: " + uri.toString());
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            NotifyLogger.m29916w(TAG, "applicationInfo is null");
            return false;
        }
        String str = applicationInfo.packageName;
        NotifyLogger.m29915i(TAG, "provider packageName is: " + str);
        boolean zIsAppFingerPrintValid = isAppFingerPrintValid(context, str);
        NotifyLogger.m29915i(TAG, "isTargetAppInWhitelist: isAppFingerPrintValid " + zIsAppFingerPrintValid);
        return zIsAppFingerPrintValid;
    }

    public static boolean isAppFingerPrintValid(Context context, String str) throws Throwable {
        NotifyLogger.m29915i(TAG, "isAppFingerPrintValid: pkgName " + str);
        List<SyncConfigService> allServices = new SyncConfigOperator().getAllServices();
        if (allServices != null && !allServices.isEmpty()) {
            SyncConfigService syncConfigService = null;
            for (SyncConfigService syncConfigService2 : allServices) {
                if (syncConfigService2 != null) {
                    String[] applications = syncConfigService2.getApplications();
                    if (!TextUtils.isEmpty(str) && applications.length != 0 && isContainsPkg(applications, str)) {
                        syncConfigService = syncConfigService2;
                    }
                }
            }
            if (syncConfigService != null) {
                return !isFingerPrintEmpty(syncConfigService) && isAppFingerPrintValid(context, syncConfigService);
            }
            NotifyLogger.m29914e(TAG, "isAppFingerPrintValid: service config is null.");
            return false;
        }
        NotifyLogger.m29914e(TAG, "isAppFingerPrintValid: service config is null.");
        return false;
    }

    public static boolean isAppFingerPrintValid(Context context, SyncConfigService syncConfigService) {
        if (isFingerPrintEmpty(syncConfigService)) {
            NotifyLogger.m29916w(TAG, "the finger print is empty");
            return false;
        }
        if (isFingerPrintSame(context, syncConfigService)) {
            return true;
        }
        NotifyLogger.m29916w(TAG, "the finger print is not same");
        return false;
    }
}
