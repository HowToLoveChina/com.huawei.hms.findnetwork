package com.huawei.fastengine.fastview;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.fastengine.fastview.activitymgr.QuickCardActivityMgr;
import com.huawei.fastengine.fastview.card.DownloadCardCallback;
import com.huawei.fastengine.fastview.card.bean.CardInfo;
import com.huawei.fastengine.fastview.card.helpler.CardHelper;
import com.huawei.fastengine.fastview.download.download.DownloadActivity;
import com.huawei.fastengine.fastview.download.download.DownloadCallbackManager;
import com.huawei.fastengine.fastview.download.download.DownloadListener;
import com.huawei.fastengine.fastview.download.download.DownloadManager;
import com.huawei.fastengine.fastview.download.download.bean.DownloadRequest;
import com.huawei.fastengine.fastview.download.utils.PackageUtils;
import com.huawei.fastengine.fastview.download.utils.StringUtils;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.fastengine.fastview.preload.PreloadManager;
import com.huawei.fastengine.fastview.shortcut.ShortCutCallback;
import com.huawei.fastengine.fastview.shortcut.ShortCutManager;
import com.huawei.fastengine.fastview.shortcut.ShortCutUtils;
import com.huawei.fastengine.fastview.showrpkdetail.ShowRpkDetail;
import com.huawei.fastengine.fastview.startfastappengine.JumpActivity;
import com.huawei.fastengine.fastview.startfastappengine.bean.Options;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkInfo;
import com.huawei.fastengine.fastview.startfastappengine.bean.RpkPageInfo;
import com.huawei.fastengine.fastview.startfastappengine.storage.FastAppPreferences;
import com.huawei.fastengine.fastview.startfastappengine.storage.StorageManager;
import com.huawei.fastengine.fastview.startfastappengine.storage.StorageType;
import com.huawei.fastengine.fastview.util.ThreadUtil;
import com.huawei.fastengine.fastview.weakup.WeakUpCallback;
import com.huawei.fastengine.fastview.weakup.WeakUpManagement;
import com.huawei.fastengine.internal.DistributeType;
import com.huawei.fastengine.internal.FastSdkLoader;
import com.huawei.fastsdk.AbsQuickCardAction;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import p664u0.C13108a;

/* loaded from: classes5.dex */
public class FastSDKEngine {
    private static final String AUTO_CREATE_SHORTCUT = "2";
    private static final int CREATE_SHORTCUT_MIN_VERSION = 20502000;
    private static final String DEEPLINK_SCHEME = "hwfastapp";
    private static final String DONT_CREATE_SHORTCUT = "0";
    private static final String HAP_SCHEME = "hap";
    private static final String HW_ACTIONBAR_LOCK_CUSTOMIZE = "hw_actionbar_lock_customize";
    private static final String HW_ACTIONBAR_LOCK_STATUS = "hw_actionbar_lock_status";
    private static final String HW_SHORTCUT_POLICY = "hw_shortcut_policy";
    private static final String HW_SHORTCUT_POLICY_DEFAUT = "defaut";
    private static final String HW_SHORTCUT_POLICY_NONE = "none";
    private static final String HW_SHORTCUT_POLICY_NOT_WHEN_QUIT = "not_when_quit";
    private static final int LITE_MODE_MIN_VERSION = 10201301;
    private static final String NONE_CREATE_SHORTCUT = "3";
    private static final int NO_INSTALL = 1;

    /* renamed from: OK */
    public static final int f21611OK = 0;
    private static final String SHOULD_CREATE_SHORTCUT = "1";
    private static final int STARTRPKPAGENEW_MIN_VERSION = 10007000;
    private static final int SUPPORT_RPKTYPE_DEFAULT = 0;
    private static final int SUPPORT_RPKTYPE_STREAM = 1;
    private static final String TAG = "FastSDKEngine";
    private static final int USER_EXP_MIN_VERSION = 10200000;
    private static int runMode;
    private static ArrayList<String> restrictComponentAPIList = new ArrayList<>();
    private static ArrayList<String> restrictModuleAPIList = new ArrayList<>();
    private static RouterEventReceiver mBroadcastReceiver = null;
    private static volatile boolean sIsInit = false;
    private static boolean isNeedCBGCert = false;
    private static boolean isNeedDialog = false;
    private static int maxJSCacheFileCount = 20;
    private static Map<String, Class<? extends AbsQuickCardAction>> actionsMap = new HashMap();

    /* renamed from: com.huawei.fastengine.fastview.FastSDKEngine$1 */
    public static class C46841 implements DownloadCallbackManager.CallbackResult {
        public C46841() {
        }

        @Override // com.huawei.fastengine.fastview.download.download.DownloadCallbackManager.CallbackResult
        public void onCallback(int i10) {
            DownloadCallback downloadCallback = downloadCallback;
            if (downloadCallback != null) {
                downloadCallback.onResult(i10);
            }
        }
    }

    /* renamed from: com.huawei.fastengine.fastview.FastSDKEngine$2 */
    public static class C46852 implements DownloadListener {
        final /* synthetic */ DownloadCardCallback val$callback;
        final /* synthetic */ File val$cardFile;
        final /* synthetic */ Context val$context;

        /* renamed from: com.huawei.fastengine.fastview.FastSDKEngine$2$1 */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C46852 c46852 = C46852.this;
                cardInfo.setCardJsFile(file);
                C46852 c468522 = C46852.this;
                downloadCardCallback.onResult(cardInfo);
                CardHelper.limitCardCacheJsFile(context, FastSDKEngine.getMaxJSCacheFileCount());
            }
        }

        /* renamed from: com.huawei.fastengine.fastview.FastSDKEngine$2$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                downloadCardCallback.onError(-1);
            }
        }

        public C46852(File file, DownloadCardCallback downloadCardCallback, Context context) {
            file = file;
            downloadCardCallback = downloadCardCallback;
            context = context;
        }

        @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
        public void failure(int i10) {
            ThreadUtil.INST.excuteInMainThread(new Runnable() { // from class: com.huawei.fastengine.fastview.FastSDKEngine.2.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    downloadCardCallback.onError(-1);
                }
            });
        }

        @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
        public void progress(int i10, int i11) {
        }

        @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
        public void success(File file) {
            ThreadUtil.INST.excuteInMainThread(new Runnable() { // from class: com.huawei.fastengine.fastview.FastSDKEngine.2.1
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C46852 c46852 = C46852.this;
                    cardInfo.setCardJsFile(file);
                    C46852 c468522 = C46852.this;
                    downloadCardCallback.onResult(cardInfo);
                    CardHelper.limitCardCacheJsFile(context, FastSDKEngine.getMaxJSCacheFileCount());
                }
            });
        }
    }

    public interface DownloadCallback {
        public static final int COMPLETED = 0;
        public static final int FAILURE = 2;
        public static final int USER_CANCEL = 1;

        void onResult(int i10);
    }

    public interface IInitCallback {
        public static final int INIT_FAIL = -1;
        public static final int INIT_SUC = 0;

        void initRes(int i10);
    }

    public interface LaunchErrorCode {
        public static final int NOT_INSTALL = -1;
        public static final int PARAMETER_ERROR = -2;
        public static final int SUCCESS = 0;
    }

    public static class LaunchOption {
        private int shortCutStrategy = -1000;
        private boolean latestNeed = true;
        private String actionbarLockCustomize = "default";
        private boolean actionbarLockStatus = false;
        private int loadingPolicy = 0;

        public String getActionbarLockCustomize() {
            return this.actionbarLockCustomize;
        }

        public int getLoadingPolicy() {
            return this.loadingPolicy;
        }

        public int getShortCutStrategy() {
            return this.shortCutStrategy;
        }

        public boolean isActionbarLockStatus() {
            return this.actionbarLockStatus;
        }

        public boolean isLatestNeed() {
            return this.latestNeed;
        }

        public void setActionbarLockCustomize(String str) {
            this.actionbarLockCustomize = str;
        }

        public void setActionbarLockStatus(boolean z10) {
            this.actionbarLockStatus = z10;
        }

        public void setLatestNeed(boolean z10) {
            this.latestNeed = z10;
        }

        public void setLoadingPolicy(int i10) {
            this.loadingPolicy = i10;
        }

        public void setShortCutStrategy(int i10) {
            this.shortCutStrategy = i10;
        }
    }

    public static boolean canUseRpkPageNew(Context context, String str) {
        if (context != null) {
            return getVersionCode(context, str) > STARTRPKPAGENEW_MIN_VERSION;
        }
        Log.e(TAG, "getVersion err, context is null");
        return false;
    }

    public static void clearStorage(Context context, String str, List<StorageType> list) throws IOException {
        StorageManager.clearStorage(context, str, list);
    }

    public static void createShortcut(Context context, String str, String str2, String str3, ShortCutCallback shortCutCallback) {
        if (!hasShortcut(context, str)) {
            ShortCutManager.getInstance().createShortcut(context, str, str2, str3, shortCutCallback);
        } else {
            FastViewLogUtils.m28724e(TAG, "createShortcut error: shortcut exist");
            shortCutCallback.onCreateShortCut(5);
        }
    }

    public static void destroy(Context context) {
        QuickCardActivityMgr.INST.release();
        C13108a.m78878b(context).m78883f(mBroadcastReceiver);
    }

    public static void downloadCard(Context context, String str, DownloadCardCallback downloadCardCallback) {
        if (context == null || TextUtils.isEmpty(str)) {
            downloadCardCallback.onError(-3);
            return;
        }
        CardInfo cardInfoByUrl = CardHelper.parseCardInfoByUrl(str);
        if (cardInfoByUrl.getApiLevel() > CardHelper.getPlatformVersionCode(context)) {
            downloadCardCallback.onError(-2);
            return;
        }
        File cardFile = CardHelper.getCardFile(context, str);
        if (cardFile != null && cardFile.exists()) {
            cardInfoByUrl.setCardJsFile(cardFile);
            downloadCardCallback.onResult(cardInfoByUrl);
        } else {
            if (cardFile == null) {
                downloadCardCallback.onError(-4);
                return;
            }
            DownloadRequest downloadRequest = new DownloadRequest();
            downloadRequest.setNeedCheck(false);
            downloadRequest.setUrl(str);
            downloadRequest.setTimeOut(5000);
            downloadRequest.setOutFile(cardFile);
            DownloadManager.getInstance().downloadAsync(downloadRequest, context, new DownloadListener() { // from class: com.huawei.fastengine.fastview.FastSDKEngine.2
                final /* synthetic */ DownloadCardCallback val$callback;
                final /* synthetic */ File val$cardFile;
                final /* synthetic */ Context val$context;

                /* renamed from: com.huawei.fastengine.fastview.FastSDKEngine$2$1 */
                public class AnonymousClass1 implements Runnable {
                    public AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C46852 c46852 = C46852.this;
                        cardInfo.setCardJsFile(file);
                        C46852 c468522 = C46852.this;
                        downloadCardCallback.onResult(cardInfo);
                        CardHelper.limitCardCacheJsFile(context, FastSDKEngine.getMaxJSCacheFileCount());
                    }
                }

                /* renamed from: com.huawei.fastengine.fastview.FastSDKEngine$2$2 */
                public class AnonymousClass2 implements Runnable {
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        downloadCardCallback.onError(-1);
                    }
                }

                public C46852(File cardFile2, DownloadCardCallback downloadCardCallback2, Context context2) {
                    file = cardFile2;
                    downloadCardCallback = downloadCardCallback2;
                    context = context2;
                }

                @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
                public void failure(int i10) {
                    ThreadUtil.INST.excuteInMainThread(new Runnable() { // from class: com.huawei.fastengine.fastview.FastSDKEngine.2.2
                        public AnonymousClass2() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            downloadCardCallback.onError(-1);
                        }
                    });
                }

                @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
                public void progress(int i10, int i11) {
                }

                @Override // com.huawei.fastengine.fastview.download.download.DownloadListener
                public void success(File file) {
                    ThreadUtil.INST.excuteInMainThread(new Runnable() { // from class: com.huawei.fastengine.fastview.FastSDKEngine.2.1
                        public AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            C46852 c46852 = C46852.this;
                            cardInfo.setCardJsFile(file);
                            C46852 c468522 = C46852.this;
                            downloadCardCallback.onResult(cardInfo);
                            CardHelper.limitCardCacheJsFile(context, FastSDKEngine.getMaxJSCacheFileCount());
                        }
                    });
                }
            });
        }
    }

    public static void downloadEngine(Context context, String str, DownloadCallback downloadCallback) {
        if (context == null || str == null || downloadCallback == null) {
            throw new NullPointerException("params is null");
        }
        String strAdd = DownloadCallbackManager.getInstance().add(new DownloadCallbackManager.CallbackResult() { // from class: com.huawei.fastengine.fastview.FastSDKEngine.1
            public C46841() {
            }

            @Override // com.huawei.fastengine.fastview.download.download.DownloadCallbackManager.CallbackResult
            public void onCallback(int i10) {
                DownloadCallback downloadCallback2 = downloadCallback;
                if (downloadCallback2 != null) {
                    downloadCallback2.onResult(i10);
                }
            }
        });
        DownloadActivity.setDownloadUrl(strAdd, str);
        Intent intent = new Intent(context, (Class<?>) DownloadActivity.class);
        intent.putExtra("callbackId", strAdd);
        if (context instanceof Activity) {
            ((Activity) context).startActivity(intent);
        } else {
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            context.startActivity(intent);
        }
    }

    public static void enableQuickCard() {
        runMode = 1;
    }

    public static Map<String, Class<? extends AbsQuickCardAction>> getActionsMap() {
        return actionsMap;
    }

    public static int getCardShortcutPolicy(Context context) {
        if (context != null) {
            return FastAppPreferences.getInstance(context).getInt(FastAppPreferences.KEY_CREATESHORTCUT, 0);
        }
        FastViewLogUtils.m28724e(TAG, "getCardShortcutPolicy context null");
        return 0;
    }

    public static int getMaxJSCacheFileCount() {
        return maxJSCacheFileCount;
    }

    private static RpkPageInfo getRpkPackageName(Context context, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "getRpkPackageName, interruptedLink is empty.");
            return null;
        }
        try {
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter("i");
            if (TextUtils.isEmpty(queryParameter)) {
                Log.e(TAG, "getRpkPackageName, interruptedLink can not get 'i'(rpk package name).");
                return null;
            }
            String queryParameter2 = uri.getQueryParameter("p");
            String queryParameter3 = uri.getQueryParameter(VideoPlayFlag.PLAY_IN_ALL);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("hwfastapp://");
            sb2.append(queryParameter);
            sb2.append("/");
            if (!TextUtils.isEmpty(queryParameter2)) {
                sb2.append(queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                sb2.append(Constants.QUESTION_STR);
                sb2.append(queryParameter3);
            }
            String string = sb2.toString();
            FastViewLogUtils.m28722d(TAG, "getRpkPackageName, translate deeplink : " + string);
            RpkPageInfo rpkPageInfo = getRpkPageInfo(context, Uri.parse(string));
            if (rpkPageInfo != null) {
                rpkPageInfo.setSourcePackage(str2);
                rpkPageInfo.setInterruptedUri(str);
            }
            return rpkPageInfo;
        } catch (UnsupportedOperationException unused) {
            FastViewLogUtils.m28724e(TAG, "getRpkPackageName UnsupportedOperationException");
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0143 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x015a A[Catch: Exception -> 0x01aa, TryCatch #0 {Exception -> 0x01aa, blocks: (B:107:0x0067, B:109:0x006f, B:111:0x0075, B:112:0x007e, B:114:0x0084, B:116:0x0094, B:117:0x0098, B:119:0x009e, B:120:0x00a3, B:121:0x00a9, B:123:0x00b4, B:125:0x00df, B:131:0x00f6, B:162:0x014e, B:163:0x0152, B:164:0x0156, B:165:0x015a, B:133:0x00fa, B:136:0x0104, B:139:0x010e, B:142:0x0118, B:145:0x0122, B:148:0x012c, B:151:0x0136, B:166:0x015d, B:168:0x016e, B:169:0x0171, B:171:0x017d, B:172:0x0188, B:173:0x018b), top: B:179:0x0067 }] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.fastengine.fastview.startfastappengine.bean.RpkPageInfo getRpkPageInfo(android.content.Context r12, android.net.Uri r13) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.fastengine.fastview.FastSDKEngine.getRpkPageInfo(android.content.Context, android.net.Uri):com.huawei.fastengine.fastview.startfastappengine.bean.RpkPageInfo");
    }

    public static int getRunMode() {
        return runMode;
    }

    public static int getSupportRpkType(Context context) throws PackageManager.NameNotFoundException {
        FastViewLogUtils.m28726i(TAG, "getSupportRpkType start");
        int i10 = 1;
        if (context == null) {
            FastViewLogUtils.m28724e(TAG, "getSupportRpkType context is null");
            return 1;
        }
        if (!PackageUtils.isEngineInstalledIngoreVersion(context)) {
            return 1;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            FastViewLogUtils.m28724e(TAG, "getSupportRpkType packageManager is null");
            return 1;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(Config.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    i10 = bundle.getInt(Config.FASTAPP_SUPPORT_RPKTYPE_DATA, 0);
                }
            } else {
                FastViewLogUtils.m28724e(TAG, "appInfo is null");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, "getSupportRpkType error");
        }
        FastViewLogUtils.m28726i(TAG, "getSupportRpkType " + i10);
        return i10;
    }

    public static int getVersion(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        int i10 = -1;
        if (context == null) {
            Log.e(TAG, "getVersion err, context is null");
            return -1;
        }
        FastSdkLoader.HostMode hostMode = DistributeType.HostMode;
        FastSdkLoader.HostMode hostMode2 = FastSdkLoader.HostMode.Lite;
        if (hostMode == hostMode2 && getVersionCode(context, Config.getPackageName()) < LITE_MODE_MIN_VERSION) {
            FastViewLogUtils.m28724e(TAG, "Fast APP version code is lower then 10201301");
            return -1;
        }
        Log.e(TAG, "DistributeType.HostMode " + hostMode);
        if (hostMode == FastSdkLoader.HostMode.Full) {
            return VersionInfo.PLATFORM_VERSION;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(Config.getPackageName(), 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    i10 = bundle.getInt("com.huawei.fastapp.apilevel", -1);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                return -1;
            }
        }
        return (hostMode != hostMode2 && i10 >= 1078) ? VersionInfo.PLATFORM_VERSION : i10;
    }

    public static int getVersionCode(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null) {
            Log.e(TAG, "getVersion err, context is null");
            return -1;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, "package not found.");
            return -1;
        }
    }

    public static boolean hasShortcut(Context context, String str) {
        return ShortCutUtils.findRpkShortCutIntent(context, str);
    }

    public static void initialize(Application application, IInitCallback iInitCallback) {
        long jCurrentTimeMillis;
        int i10;
        String str;
        Log.i(TAG, "initialize begin");
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        String packageName = Config.getPackageName();
        if (StringUtils.isEmpty(packageName)) {
            Log.e(TAG, "getVersion err, packageName is empty");
            if (iInitCallback != null) {
                iInitCallback.initRes(-1);
            }
        }
        if (packageName.equals(application.getPackageName())) {
            Log.e(TAG, "getVersion err, application cannot be " + packageName);
            if (iInitCallback != null) {
                iInitCallback.initRes(-1);
                return;
            }
            return;
        }
        FastSdkLoader.HostMode hostMode = DistributeType.HostMode;
        if (hostMode == FastSdkLoader.HostMode.Lite && getVersionCode(application, Config.getPackageName()) < LITE_MODE_MIN_VERSION) {
            if (iInitCallback != null) {
                iInitCallback.initRes(-1);
                return;
            }
            return;
        }
        try {
            FastSdkLoader.init(application, hostMode, restrictComponentAPIList, restrictModuleAPIList, isNeedCBGCert, isNeedDialog);
            registerBroadcastReceiver(application);
            Log.i(TAG, "initialize INIT_SUC");
            QuickCardActivityMgr.INST.init(application);
            iInitCallback.initRes(0);
            sIsInit = true;
            jCurrentTimeMillis = System.currentTimeMillis();
            i10 = 0;
            str = "initialize Success";
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "initialize package not found.");
            iInitCallback.initRes(-1);
            jCurrentTimeMillis = System.currentTimeMillis();
            i10 = -1;
            str = "initialize package not found.";
        } catch (IllegalAccessException unused2) {
            Log.e(TAG, "initialize error.");
            iInitCallback.initRes(-1);
            jCurrentTimeMillis = System.currentTimeMillis();
            i10 = -1;
            str = "initialize error.";
        } catch (UnsatisfiedLinkError unused3) {
            Log.e(TAG, "initialize UnsatisfiedLinkError.");
            iInitCallback.initRes(-1);
            jCurrentTimeMillis = System.currentTimeMillis();
            i10 = -1;
            str = "initialize UnsatisfiedLinkError.";
        }
        QuickCardAnalytic.reportSDKInit(application, jCurrentTimeMillis2, jCurrentTimeMillis, i10, str);
    }

    public static boolean isCreateShortcutSupport(Context context) {
        return getVersionCode(context, Config.getPackageName()) >= CREATE_SHORTCUT_MIN_VERSION;
    }

    public static boolean isInitialized() {
        return sIsInit;
    }

    public static int launchFastAppByDeeplink(Context context, String str, LaunchOption launchOption) throws JSONException {
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "launchFastAppByDeeplink, parameter is null!");
            return -2;
        }
        if (!PackageUtils.isEngineInstalled(context)) {
            Log.e(TAG, "FastEngine is not installed");
            return -1;
        }
        RpkPageInfo rpkPageInfo = getRpkPageInfo(context, Uri.parse(str));
        if (rpkPageInfo == null) {
            Log.e(TAG, "can not parse rpk info");
            return -2;
        }
        if (launchOption != null) {
            if (launchOption.getShortCutStrategy() != -1000) {
                rpkPageInfo.setCreateShortCut(launchOption.getShortCutStrategy());
            }
            rpkPageInfo.setLatestNeed(launchOption.isLatestNeed());
            Options options = new Options();
            options.setActionbarLockCustomize(launchOption.getActionbarLockCustomize());
            options.setActionbarLockStatus(launchOption.isActionbarLockStatus());
            options.setLoadingPolicy(launchOption.getLoadingPolicy());
            rpkPageInfo.setOptions(options);
        }
        OpenFastAppEngine.getInstance().openFastApp(context, rpkPageInfo, false);
        return 0;
    }

    public static void launchFastAppCenterFromAppGallery(Context context, Bundle bundle) {
        StartFastAPPEngine.getInstance().openFastappManagement(context, bundle);
    }

    public static void launchFastAppFromAppGallery(Context context, RpkInfo rpkInfo) {
        StartFastAPPEngine.getInstance().openFastApp(context, rpkInfo);
    }

    public static void onShowRpkDetail(RpkInfo rpkInfo, Context context) {
        FastViewLogUtils.m28726i(TAG, "onShowRpkDetail start");
        if (rpkInfo == null || context == null) {
            FastViewLogUtils.m28724e(TAG, "onShowRpkDetail rpkInfo or context is null");
        }
        if (getSupportRpkType(context) == 1) {
            String packageName = rpkInfo.getPackageName();
            ShowRpkDetail showRpkDetail = ShowRpkDetail.getInstance();
            showRpkDetail.setPackageName(packageName);
            showRpkDetail.setContext(context);
            showRpkDetail.bindService(context);
        }
    }

    public static void openEngineByInterruptedLink(Context context, String str, String str2) throws JSONException {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "openEngineByInterruptedLink, parameter is null!");
            return;
        }
        if (!PackageUtils.isEngineInstalled(context)) {
            Log.w(TAG, "openEngineByInterruptedLink, Engine is not installed, do nothing.");
            return;
        }
        RpkPageInfo rpkPackageName = getRpkPackageName(context, str, str2);
        if (rpkPackageName == null) {
            Log.e(TAG, "openEngineByInterruptedLink, getRpkPackageName err!");
            return;
        }
        Log.i(TAG, "begin openEngineByInterruptedLink");
        rpkPackageName.setCreateShortCut(true);
        rpkPackageName.setLatestNeed(false);
        OpenFastAppEngine.getInstance().openFastApp(context.getApplicationContext(), rpkPackageName, false);
    }

    public static void preloadQuickApp(Context context, String str) {
        new PreloadManager().preloadQuickApp(context, str);
    }

    public static void registerActions(String str, Class<? extends AbsQuickCardAction> cls) {
        actionsMap.put(str, cls);
    }

    private static void registerBroadcastReceiver(Context context) {
        Log.i(TAG, "registerBroadcastReceiver");
        mBroadcastReceiver = new RouterEventReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RouterEventReceiver.ACTION_ROUTER_EVENT_PUSH_FOR_WIDGET);
        C13108a.m78878b(context).m78880c(mBroadcastReceiver, intentFilter);
    }

    public static void restrictComponentAPI(ArrayList<String> arrayList) {
        restrictComponentAPIList.addAll(arrayList);
    }

    public static void restrictModuleAPI(ArrayList<String> arrayList) {
        restrictModuleAPIList.addAll(arrayList);
    }

    public static void setCardShortcutPolicy(int i10, Context context) {
        if (context == null) {
            FastViewLogUtils.m28724e(TAG, "setCardShortcutPolicy context null");
        } else {
            FastAppPreferences.getInstance(context).putInt(FastAppPreferences.KEY_CREATESHORTCUT, i10);
        }
    }

    public static void setIsNeedCBGCert(boolean z10) {
        isNeedCBGCert = z10;
    }

    public static void setIsNeedDialog(boolean z10) {
        isNeedDialog = z10;
    }

    public static void setJumpOptions(Context context, Options options) {
        if (context == null) {
            FastViewLogUtils.m28724e(TAG, "setJumpOptions Context null");
            return;
        }
        if (options != null) {
            FastAppPreferences.getInstance(context).putString(FastAppPreferences.KEY_ACTIONBAR_LOCK_CUSTOMIZE, options.getActionbarLockCustomize());
            FastAppPreferences.getInstance(context).putBoolean(FastAppPreferences.KEY_ACTIONBAR_LOCK_STATUS, options.isActionbarLockStatus());
        } else {
            FastViewLogUtils.m28724e(TAG, "setJumpOptions options null");
            FastAppPreferences.getInstance(context).putString(FastAppPreferences.KEY_ACTIONBAR_LOCK_CUSTOMIZE, "default");
            FastAppPreferences.getInstance(context).putBoolean(FastAppPreferences.KEY_ACTIONBAR_LOCK_STATUS, false);
        }
    }

    public static void setMaxJSCacheFileCount(int i10) {
        if (i10 <= 0) {
            i10 = 20;
        }
        maxJSCacheFileCount = i10;
    }

    public static void setQuickCardMode() {
        runMode = 1;
    }

    public static boolean supportUserExp(Context context, String str) {
        if (context != null) {
            return getVersionCode(context, str) > USER_EXP_MIN_VERSION;
        }
        Log.e(TAG, "getVersion err, context is null");
        return false;
    }

    public static void weakUpQuickAppCenter(Context context, WeakUpCallback weakUpCallback) {
        FastViewLogUtils.m28726i(TAG, "weakUpQuickAppCenter");
        if (WeakUpManagement.getInstance().isRepeatCall()) {
            FastViewLogUtils.m28726i(TAG, "isRepeatCall");
            weakUpCallback.onResult(true);
            return;
        }
        FastViewLogUtils.m28726i(TAG, "weakUpQuickAppCenter by jumpactivity");
        WeakUpManagement.getInstance().registerCallback(weakUpCallback);
        Intent intent = new Intent();
        intent.setClass(context, JumpActivity.class);
        intent.putExtra(JumpActivity.INTENT_FOR_WEAK_UP, true);
        if (!(context instanceof Activity)) {
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        }
        try {
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        } catch (ActivityNotFoundException unused) {
            FastViewLogUtils.m28724e(TAG, "ActivityNotFoundException");
        }
    }

    public static void enableQuickCard(int i10) {
        runMode = i10;
    }
}
