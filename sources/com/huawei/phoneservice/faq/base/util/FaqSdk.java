package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlsCallBack;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.phoneservice.faq.base.EnumC8290b;
import com.huawei.phoneservice.faq.base.EnumC8291c;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.entity.Builder;
import com.huawei.phoneservice.faq.base.entity.C8297a;
import com.huawei.phoneservice.faq.base.entity.FaqSdkServiceUrlResponse;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigRequest;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqRestClient;
import com.huawei.phoneservice.faq.base.network.FaqSdkAddressApi;
import com.huawei.phoneservice.faq.base.network.SdkAppInfo;
import com.huawei.phoneservice.faq.base.tracker.HiAnalyticsUtils;
import com.huawei.phoneservice.faq.base.util.FaqHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class FaqSdk implements ISdk, Sdk, FaqHandler.CallBack {

    /* renamed from: a */
    public Application f38709a;

    /* renamed from: b */
    public Handler f38710b;

    /* renamed from: c */
    public volatile EnumC8290b f38711c;

    /* renamed from: d */
    public volatile EnumC8291c f38712d;

    /* renamed from: e */
    public WeakReference<SdkListener> f38713e;

    /* renamed from: f */
    public WeakReference<SdkClickListener> f38714f;

    /* renamed from: g */
    public Map<String, String> f38715g;

    /* renamed from: h */
    public Map<String, String> f38716h;

    /* renamed from: i */
    public String f38717i;

    /* renamed from: j */
    public Map<String, String> f38718j;

    /* renamed from: k */
    public FaqBaseCallback f38719k;

    /* renamed from: l */
    public List<SdkUpdateListener> f38720l;

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqSdk$a */
    public class C8319a extends FaqCallback<FaqSdkServiceUrlResponse> {

        /* renamed from: d */
        public final /* synthetic */ String f38721d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8319a(Class cls, Activity activity, String str) {
            super(cls, activity);
            this.f38721d = str;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FaqSdkServiceUrlResponse faqSdkServiceUrlResponse) throws Throwable {
            FaqSdk faqSdk;
            String str;
            if (th2 != null || faqSdkServiceUrlResponse == null) {
                FaqSdk.this.f38711c = EnumC8290b.NO_ADDRESS_SERVICE;
                faqSdk = FaqSdk.this;
                str = "no address, network err";
            } else {
                if (!FaqCommonUtils.isEmpty(faqSdkServiceUrlResponse.m51752c())) {
                    FaqSdk.this.m51869e(faqSdkServiceUrlResponse, this.f38721d);
                    return;
                }
                FaqSdk.this.f38711c = EnumC8290b.NO_ADDRESS;
                faqSdk = FaqSdk.this;
                str = "no address in countryCode data is null";
            }
            faqSdk.onSdkInit(-1, str);
            FaqLogger.print("SDK_ERROR", str);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqSdk$b */
    public class C8320b extends FaqCallback<ModuleConfigResponse> {
        public C8320b(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, ModuleConfigResponse moduleConfigResponse) throws Throwable {
            String linkAddress;
            String openType;
            ModuleConfigUtils.cleanSdkModuleList(FaqSdk.this.f38709a);
            if (th2 == null && moduleConfigResponse != null) {
                FaqSdk.this.f38711c = EnumC8290b.INIT_SUCCESS;
                List<ModuleConfigResponse.ModuleListBean> moduleList = moduleConfigResponse.getModuleList();
                if (!FaqCommonUtils.isEmpty(moduleList)) {
                    ModuleConfigUtils.genSdkModuleList(FaqSdk.this.f38709a, moduleList);
                    for (ModuleConfigResponse.ModuleListBean moduleListBean : moduleList) {
                        if ("2".equals(moduleListBean.getModuleCode())) {
                            linkAddress = moduleListBean.getLinkAddress();
                            openType = moduleListBean.getOpenType();
                            break;
                        }
                    }
                } else {
                    FaqSdk.this.f38711c = EnumC8290b.NO_MODULE;
                    FaqLogger.print("FaqSdk", "MODULE LIST IS NULL");
                }
            } else {
                FaqSdk.this.f38711c = EnumC8290b.NO_MODULE_SERVICE;
            }
            linkAddress = "";
            openType = "";
            if (FaqSdk.this.f38709a != null) {
                FaqSharePrefUtil.save(FaqSdk.this.f38709a, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_KEY, linkAddress);
                FaqSharePrefUtil.save(FaqSdk.this.f38709a, FaqSharePrefUtil.FAQ_IPCC_FILENAME, FaqSharePrefUtil.FAQ_IPCC_TYPE, openType);
            }
            FaqSdk.this.onSdkInit(0, null);
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqSdk$c */
    public class C8321c implements IQueryUrlsCallBack {

        /* renamed from: a */
        public final /* synthetic */ GrsClient f38724a;

        /* renamed from: b */
        public final /* synthetic */ String f38725b;

        public C8321c(GrsClient grsClient, String str) {
            this.f38724a = grsClient;
            this.f38725b = str;
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlsCallBack
        public void onCallBackFail(int i10) throws Throwable {
            FaqLogger.print("FaqSdk", "testsynGetGrsUrlsGRSIndependent method failed and the errorCode is" + i10);
            FaqLogger.m51836d("FaqSdk", "IS_CONSUMER");
            FaqSdk.this.f38711c = EnumC8290b.NO_GRS_ADDRESS;
            FaqSdk.this.onSdkInit(-1, "can not get address from GRS. errorCode" + i10);
            FaqLogger.print("FaqSdk", "can not get address from GRS. errorCode" + i10);
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlsCallBack
        public void onCallBackSuccess(Map<String, String> map) throws Throwable {
            FaqLogger.print("FaqSdk", "getGrsUrls success ");
            if (map == null || map.isEmpty()) {
                FaqLogger.m51840e("FaqSdk", "urlMap is null");
                return;
            }
            String strSynGetGrsUrl = this.f38724a.synGetGrsUrl(FaqConstants.GRS_LOGSERVER_SERVICE_NAME, "ROOT");
            if (!TextUtils.isEmpty(strSynGetGrsUrl)) {
                map.put("ROOT", strSynGetGrsUrl);
            }
            FaqUtil.m51892d(map, FaqSdk.this.f38715g);
            try {
                FaqSdk.this.m51871k(this.f38725b);
            } catch (Exception e10) {
                FaqSdk.this.f38711c = EnumC8290b.NO_ADDRESS_SERVICE;
                FaqSdk.this.onSdkInit(-1, "FaqSdk getServiceByNet " + e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqSdk$d */
    public static class C8322d {

        /* renamed from: a */
        public static final FaqSdk f38727a = new FaqSdk(null);
    }

    /* renamed from: com.huawei.phoneservice.faq.base.util.FaqSdk$e */
    public static class C8323e extends TimerTask {

        /* renamed from: a */
        public final SdkUpdateListener f38728a;

        public C8323e(SdkUpdateListener sdkUpdateListener) {
            this.f38728a = sdkUpdateListener;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws Throwable {
            this.f38728a.onSdkUpdate("accessToken", null, null);
            FaqLogger.print("FaqSdk", "GET TOKEN TIME OUT");
        }
    }

    public FaqSdk() {
        this.f38711c = EnumC8290b.INIT_FAIL;
        this.f38712d = EnumC8291c.INIT_PROGRESS;
        this.f38716h = new HashMap();
        this.f38718j = new HashMap();
    }

    /* renamed from: c */
    public static FaqSdk m51863c() {
        return C8322d.f38727a;
    }

    @Keep
    public static ISdk getISdk() {
        return m51863c();
    }

    @Keep
    public static Sdk getSdk() {
        return m51863c();
    }

    /* renamed from: h */
    private void m51866h(String str) throws Throwable {
        ModuleConfigRequest moduleConfigRequest = new ModuleConfigRequest(str, getSdk(FaqConstants.FAQ_EMUI_LANGUAGE), FaqUtil.getBrand(), getSdk(FaqConstants.FAQ_CHANNEL), getSdk().getSdk(FaqConstants.FAQ_SHASN), FaqDeviceUtils.getSpecialEmuiVersion(), getSdk("appVersion"), getSdk(FaqConstants.FAQ_MODEL), FaqDeviceUtils.getMachineType());
        FaqLogger.print("FaqSdk", moduleConfigRequest.toString());
        FaqSdkAddressApi.f38650d.m51788a(this.f38709a).m51785a(moduleConfigRequest, new C8320b(ModuleConfigResponse.class, null));
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public synchronized int apply() {
        if (this.f38715g == null || this.f38709a == null) {
            return -1;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(this.f38715g);
        this.f38716h.putAll(this.f38715g);
        concurrentHashMap.remove("accessToken");
        concurrentHashMap.remove(FaqConstants.FAQ_REFRESH);
        concurrentHashMap.remove(FaqConstants.FAQ_LOG_SERVER_SECRET_KEY);
        FaqSharePrefUtil.delete(this.f38709a, FaqConstants.SDK_SP_FILE_NAME, FaqConstants.SDK_SP_KEY);
        FaqSharePrefUtil.save(this.f38709a, FaqConstants.SDK_SP_FILE_NAME, FaqConstants.SDK_SP_KEY, new JSONObject(concurrentHashMap).toString());
        return 0;
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void canceledSubmit(Context context) {
        FaqRestClient.initRestClientAnno(context).canceledSubmit(context);
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public boolean clearDownloadFile(Application application) {
        if (FaqStringUtil.isEmpty(FaqFileUtils.getCompressFolder(application))) {
            return false;
        }
        String compressFolder = FaqFileUtils.getCompressFolder(application);
        return !TextUtils.isEmpty(compressFolder) && m51870i(FaqFileUtils.getDownloadFolder(application)) && m51870i(new File(compressFolder));
    }

    /* renamed from: d */
    public final void m51868d(GrsClient grsClient, String str) {
        grsClient.ayncGetGrsUrls(FaqConstants.GRS_SERVICE_NAME, new C8321c(grsClient, str));
    }

    /* renamed from: e */
    public final void m51869e(FaqSdkServiceUrlResponse faqSdkServiceUrlResponse, String str) throws Throwable {
        boolean z10;
        Iterator<FaqSdkServiceUrlResponse.ServiceUrl> it = faqSdkServiceUrlResponse.m51752c().iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            FaqSdkServiceUrlResponse.ServiceUrl next = it.next();
            if (str.equals(next.m51753c())) {
                FaqUtil.m51891c(next, this.f38715g);
                Application application = this.f38709a;
                if (application != null) {
                    HiAnalyticsUtils.m51803a(application, next.m51754d(), true, false);
                }
                z10 = !TextUtils.isEmpty("Y".equals(getSdk().getSdk(FaqConstants.FAQ_USE_OLD_DOMAIN)) ? next.m51755e() : next.m51756f());
            }
        }
        if ("Y".equals(getSdk().getSdk(FaqConstants.FAQ_IS_DEEPLICK))) {
            this.f38711c = EnumC8290b.INIT_SUCCESS;
            onSdkInit(0, null);
        } else {
            if (z10) {
                m51866h(str);
                return;
            }
            this.f38711c = EnumC8290b.NO_ADDRESS;
            onSdkInit(-1, "no address in countryCode:" + str);
            FaqLogger.print("SDK_ERROR", "no address in countryCode:");
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public FaqBaseCallback getCallback() {
        return this.f38719k;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public String getMap() {
        return new Gson().toJson(FaqUtil.m51890b(this.f38715g));
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public String getMapOnSaveInstance() {
        this.f38718j.clear();
        return new JSONObject(this.f38716h).toString();
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void getModuleList() throws Throwable {
        m51866h(this.f38717i);
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public int getSdkInitCode() {
        return this.f38711c.m51749b();
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public synchronized SdkListener getSdkListener() {
        WeakReference<SdkListener> weakReference = this.f38713e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public String getSdkVersion() {
        return "25.5.0.1";
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void getServiceUrl() throws Throwable {
        m51871k(this.f38717i);
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public boolean hadAddress() {
        return this.f38711c.m51751f();
    }

    @Override // com.huawei.phoneservice.faq.base.util.FaqHandler.CallBack
    public void handleMessage(int i10, Message message) {
        SdkListener sdkListener;
        if (i10 != 0) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            WeakReference<SdkListener> weakReference = this.f38713e;
            if (weakReference == null || weakReference.get() == null || (sdkListener = this.f38713e.get()) == null) {
                return;
            }
            sdkListener.onSdkErr((String) pair.first, (String) pair.second);
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public boolean haveSdkErr(String str) {
        SdkListener sdkListener;
        WeakReference<SdkListener> weakReference = this.f38713e;
        if (weakReference == null || this.f38710b == null || (sdkListener = weakReference.get()) == null) {
            return false;
        }
        return sdkListener.haveSdkErr(str);
    }

    /* renamed from: i */
    public final boolean m51870i(File file) throws Throwable {
        boolean zDelete = true;
        if (file == null || !file.exists()) {
            FaqLogger.print("FILE DELETE", "FILE IS NOT EXISTS" + file);
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        for (File file2 : fileArrListFiles) {
            zDelete &= file2.delete();
            if (!zDelete) {
                FaqLogger.print("FILE DELETE", "FILE CLEAR IS FAILED " + file2);
            }
        }
        return zDelete;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public int init(Activity activity, String str) {
        return init(activity.getApplication(), str, (SdkListener) null);
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public boolean initIsDone() {
        return this.f38712d == EnumC8291c.INIT_DONE;
    }

    /* renamed from: k */
    public final void m51871k(String str) throws Throwable {
        FaqLogger.print("FaqSdk getServiceByNet", "code:" + str);
        C8297a c8297a = new C8297a();
        c8297a.m51771a(str);
        FaqSdkAddressApi.f38650d.m51788a(this.f38709a).m51786b(c8297a, new C8319a(FaqSdkServiceUrlResponse.class, null, str));
    }

    /* renamed from: l */
    public final void m51872l(String str) {
        this.f38717i = str;
        SdkAppInfo.initAppInfo(this.f38709a);
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str);
        grsBaseInfo.setRegCountry(str);
        try {
            m51868d(new GrsClient(this.f38709a, grsBaseInfo), str);
        } catch (Exception e10) {
            this.f38711c = EnumC8290b.NO_GRS_ADDRESS;
            onSdkInit(-1, "can not get address from GRS " + e10.getMessage());
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void onClick(String str, String str2, Object obj) {
        SdkClickListener sdkClickListener;
        WeakReference<SdkClickListener> weakReference = this.f38714f;
        if (weakReference == null || (sdkClickListener = weakReference.get()) == null) {
            return;
        }
        sdkClickListener.onClick(str, str2, obj);
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void onSdkErr(String str, String str2) {
        Handler handler = this.f38710b;
        if (handler != null) {
            handler.removeMessages(0);
            Handler handler2 = this.f38710b;
            handler2.sendMessageDelayed(handler2.obtainMessage(0, new Pair(str, str2)), 1000L);
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void onSdkInit(int i10, String str) {
        SdkListener sdkListener;
        WeakReference<SdkListener> weakReference = this.f38713e;
        if (weakReference == null || (sdkListener = weakReference.get()) == null) {
            return;
        }
        this.f38712d = EnumC8291c.INIT_DONE;
        if (i10 != 0 || this.f38711c.m51749b() == 0) {
            sdkListener.onSdkInit(i10, this.f38711c.m51749b(), this.f38711c.m51750e() + str);
            return;
        }
        sdkListener.onSdkInit(-1, this.f38711c.m51749b(), this.f38711c.m51750e() + str);
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public Submit queryModuleList(Context context, ModuleConfigRequest moduleConfigRequest, Callback callback) {
        return FaqSdkAddressApi.f38650d.m51788a(context).m51785a(moduleConfigRequest, callback);
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void registerUpdateListener(SdkUpdateListener sdkUpdateListener) {
        if (this.f38720l == null) {
            this.f38720l = new ArrayList();
        }
        ((BaseSdkUpdateRequest) sdkUpdateListener).m51808b(new C8323e(sdkUpdateListener));
        this.f38720l.add(sdkUpdateListener);
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public void release() {
        WeakReference<SdkListener> weakReference = this.f38713e;
        if (weakReference != null) {
            weakReference.clear();
            this.f38713e = null;
        }
        WeakReference<SdkClickListener> weakReference2 = this.f38714f;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.f38714f = null;
        }
        List<SdkUpdateListener> list = this.f38720l;
        if (list != null) {
            list.clear();
            this.f38720l = null;
        }
        Map<String, String> map = this.f38715g;
        if (map != null) {
            map.clear();
            this.f38715g = null;
        }
        Handler handler = this.f38710b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f38710b = null;
        }
        this.f38711c = EnumC8290b.INIT_FAIL;
        this.f38709a = null;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public void saveMapOnSaveInstanceState(String str) {
        String strM51876a = FaqSharePrefUtil.m51876a(this.f38709a);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, String> map = this.f38715g;
        if (map == null) {
            this.f38715g = new Builder().setJson(str).build();
            if (!TextUtils.isEmpty(strM51876a)) {
                this.f38715g.put(FaqConstants.FAQ_EMUI_LANGUAGE, strM51876a);
                FaqSharePrefUtil.m51877b(this.f38709a, "");
            }
        } else {
            map.putAll(new Builder().setJson(str).build());
            if (!TextUtils.isEmpty(strM51876a)) {
                this.f38715g.put(FaqConstants.FAQ_EMUI_LANGUAGE, strM51876a);
                FaqSharePrefUtil.m51877b(this.f38709a, "");
            }
            Map<String, String> map2 = this.f38718j;
            if (map2 != null) {
                this.f38715g.putAll(map2);
            }
        }
        this.f38716h.putAll(this.f38715g);
        this.f38711c = EnumC8290b.INIT_SUCCESS;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public synchronized Sdk saveSdk(String str, String str2) {
        if (str != null) {
            try {
                String sdk = getSdk(str);
                Map<String, String> map = this.f38715g;
                if (map != null) {
                    if (str2 != null) {
                        map.put(str, str2);
                        Map<String, String> map2 = this.f38718j;
                        if (map2 != null) {
                            map2.put(str, str2);
                        }
                    }
                    List<SdkUpdateListener> list = this.f38720l;
                    if (list != null) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            this.f38720l.get(size).onSdkUpdate(str, sdk, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public void setCallback(FaqBaseCallback faqBaseCallback) {
        this.f38719k = faqBaseCallback;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public void setClickListener(SdkClickListener sdkClickListener) {
        if (sdkClickListener != null) {
            WeakReference<SdkClickListener> weakReference = this.f38714f;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f38714f = new WeakReference<>(sdkClickListener);
            return;
        }
        WeakReference<SdkClickListener> weakReference2 = this.f38714f;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.f38714f = null;
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public void setLanguage(String str) {
        FaqSharePrefUtil.m51877b(this.f38709a, str);
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public synchronized void setSdkListener(SdkListener sdkListener) {
        try {
            if (sdkListener != null) {
                WeakReference<SdkListener> weakReference = this.f38713e;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.f38713e = new WeakReference<>(sdkListener);
            } else {
                WeakReference<SdkListener> weakReference2 = this.f38713e;
                if (weakReference2 != null) {
                    weakReference2.clear();
                    this.f38713e = null;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public void setUriFromFaq(Uri uri) throws Throwable {
        if (uri != null) {
            try {
                if (!FaqConstants.HOST_NAME.equals(URI.create(uri.toString()).getHost())) {
                    FaqLogger.print("SDK INIT SET URI", " ERROR, HOST ILLEGAL !!!");
                    return;
                }
                if (this.f38715g == null) {
                    this.f38715g = new Builder().build();
                }
                this.f38715g.putAll(new Builder().setUri(uri).build());
            } catch (IllegalArgumentException unused) {
                FaqLogger.print("SDK INIT SET URI", "ERROR, IllegalArgumentException !!!");
            }
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void showReleaseLog(boolean z10) {
        FaqLogger.m51850l(z10, this.f38709a);
    }

    @Override // com.huawei.phoneservice.faq.base.util.ISdk
    public void unregisterUpdateListener(SdkUpdateListener sdkUpdateListener) {
        if (this.f38720l != null) {
            ((BaseSdkUpdateRequest) sdkUpdateListener).m51807a();
            this.f38720l.remove(sdkUpdateListener);
        }
    }

    public /* synthetic */ FaqSdk(C8319a c8319a) {
        this();
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public String getSdk(String str) throws Throwable {
        if (this.f38715g == null) {
            if (this.f38709a == null) {
                FaqLogger.print("FaqSdk", "CONTENXT IS NULL");
                return null;
            }
            this.f38715g = new Builder().setJson(FaqSharePrefUtil.getString(this.f38709a, FaqConstants.SDK_SP_FILE_NAME, FaqConstants.SDK_SP_KEY, "")).build();
        }
        Map<String, String> map = this.f38715g;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public int init(Application application, Uri uri, SdkListener sdkListener) throws Throwable {
        if (uri == null) {
            return -1;
        }
        try {
            if (FaqConstants.HOST_NAME.equals(URI.create(uri.toString()).getHost())) {
                return init(application, new Builder().setUri(uri), sdkListener);
            }
            FaqLogger.print("SDK INIT", "ERROR, HOST ILLEGAL !!!");
            return -1;
        } catch (IllegalArgumentException e10) {
            FaqLogger.m51840e("SDK INIT", e10.getMessage());
            return -1;
        }
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public int init(Application application, Builder builder, SdkListener sdkListener) {
        this.f38709a = application;
        this.f38711c = init() ? EnumC8290b.INIT_AGAIN : EnumC8290b.INIT_FAIL;
        this.f38712d = EnumC8291c.INIT_PROGRESS;
        if (sdkListener != null) {
            WeakReference<SdkListener> weakReference = this.f38713e;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f38713e = new WeakReference<>(sdkListener);
        }
        if (builder.isEmpty()) {
            this.f38711c = EnumC8290b.PARAMETER_ERROR;
            onSdkInit(-1, "ERROR, parameter EMPTY !!!");
            return -1;
        }
        Map<String, String> mapBuild = builder.build();
        this.f38715g = mapBuild;
        m51872l(mapBuild.get("country"));
        return 0;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public int init(Application application, String str, SdkListener sdkListener) throws Throwable {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "ERROR, uriStr EMPTY !!!";
        } else {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                return init(application, uri, sdkListener);
            }
            str2 = "ERROR, Uri NULL !!!";
        }
        FaqLogger.print("SDK INIT", str2);
        return -1;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public boolean init() {
        return this.f38711c != EnumC8290b.INIT_FAIL;
    }

    @Override // com.huawei.phoneservice.faq.base.util.Sdk
    public boolean init(Application application) {
        this.f38709a = application;
        this.f38710b = new FaqHandler(this);
        return this.f38711c != EnumC8290b.INIT_FAIL;
    }
}
