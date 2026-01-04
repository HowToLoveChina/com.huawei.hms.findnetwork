package com.huawei.phoneservice.feedbackcommon.utils;

import android.app.Activity;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.Sdk;
import com.huawei.phoneservice.faq.base.util.VideoCallBack;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackRequest;
import com.huawei.phoneservice.feedbackcommon.entity.FeedBackResponse;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackInfo;
import com.huawei.phoneservice.feedbackcommon.entity.FeedbackZipBean;
import com.huawei.phoneservice.feedbackcommon.entity.MediaEntity;
import com.huawei.phoneservice.feedbackcommon.p176db.FeedbackMediaData;
import com.huawei.phoneservice.feedbackcommon.photolibrary.MimeType;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import p214d2.C8988b;
import p214d2.C8991e;
import p507o2.InterfaceC11792e;
import p542p2.AbstractC12080g;
import p542p2.InterfaceC12082i;
import p564q2.InterfaceC12275b;
import p759x1.EnumC13676a;
import p829z1.C14078q;

/* loaded from: classes5.dex */
public final class SdkProblemManager implements OnReadListener, IProblemManager {

    /* renamed from: c */
    public static int f40283c = 50;

    /* renamed from: d */
    public static int f40284d = 4;

    /* renamed from: e */
    public static int f40285e = 1;

    /* renamed from: f */
    public static int f40286f = 100;

    /* renamed from: g */
    public static int f40287g = 10;

    /* renamed from: h */
    public static int f40288h = 50;

    /* renamed from: i */
    public static long f40289i = 512000;

    /* renamed from: j */
    public static String f40290j;

    /* renamed from: a */
    public WeakReference<SdkProblemListener> f40291a;

    /* renamed from: b */
    public List<OnReadListener> f40292b;

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$a */
    public class C8651a extends AbstractC12080g<File> {

        /* renamed from: d */
        public final /* synthetic */ boolean f40293d;

        /* renamed from: e */
        public final /* synthetic */ VideoCallBack f40294e;

        /* renamed from: f */
        public final /* synthetic */ Activity f40295f;

        /* renamed from: g */
        public final /* synthetic */ String f40296g;

        /* renamed from: h */
        public final /* synthetic */ String f40297h;

        public C8651a(boolean z10, VideoCallBack videoCallBack, Activity activity, String str, String str2) {
            this.f40293d = z10;
            this.f40294e = videoCallBack;
            this.f40295f = activity;
            this.f40296g = str;
            this.f40297h = str2;
        }

        @Override // p542p2.InterfaceC12082i
        /* renamed from: i */
        public void mo53348c(File file, InterfaceC12275b<? super File> interfaceC12275b) throws Throwable {
            if (file.length() >= 100) {
                SdkProblemManager.this.m53365o(file, this.f40295f, this.f40296g, this.f40297h, this.f40294e);
                return;
            }
            if (this.f40293d) {
                SdkProblemManager.this.m53362d(this.f40294e);
            } else {
                SdkProblemManager.this.m53366p(file, this.f40294e, this.f40295f, this.f40296g, this.f40297h);
            }
            file.delete();
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$b */
    public class C8652b implements InterfaceC11792e<File> {

        /* renamed from: a */
        public final /* synthetic */ VideoCallBack f40299a;

        public C8652b(VideoCallBack videoCallBack) {
            this.f40299a = videoCallBack;
        }

        @Override // p507o2.InterfaceC11792e
        /* renamed from: a */
        public boolean mo51694a(C14078q c14078q, Object obj, InterfaceC12082i<File> interfaceC12082i, boolean z10) {
            SdkProblemManager.this.m53362d(this.f40299a);
            return false;
        }

        @Override // p507o2.InterfaceC11792e
        /* renamed from: c */
        public boolean mo51695b(File file, Object obj, InterfaceC12082i<File> interfaceC12082i, EnumC13676a enumC13676a, boolean z10) {
            return false;
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$c */
    public class C8653c extends BaseSdkUpdateRequest<Object> {

        /* renamed from: c */
        public final /* synthetic */ Activity f40301c;

        /* renamed from: d */
        public final /* synthetic */ String f40302d;

        /* renamed from: e */
        public final /* synthetic */ String f40303e;

        /* renamed from: f */
        public final /* synthetic */ VideoCallBack f40304f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8653c(Object obj, Activity activity, String str, String str2, VideoCallBack videoCallBack) {
            super(obj);
            this.f40301c = activity;
            this.f40302d = str;
            this.f40303e = str2;
            this.f40304f = videoCallBack;
        }

        @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
        public void onCallback(String str, String str2, String str3, Object obj) {
            SdkProblemManager.this.m53361c(this.f40301c, this.f40302d, this.f40303e, true, this.f40304f);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$d */
    public class RunnableC8654d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Activity f40306a;

        /* renamed from: b */
        public final /* synthetic */ String f40307b;

        /* renamed from: c */
        public final /* synthetic */ String f40308c;

        /* renamed from: d */
        public final /* synthetic */ File f40309d;

        /* renamed from: e */
        public final /* synthetic */ VideoCallBack f40310e;

        public RunnableC8654d(Activity activity, String str, String str2, File file, VideoCallBack videoCallBack) {
            this.f40306a = activity;
            this.f40307b = str;
            this.f40308c = str2;
            this.f40309d = file;
            this.f40310e = videoCallBack;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            Activity activity = this.f40306a;
            if (activity == null || activity.isFinishing() || this.f40306a.isDestroyed()) {
                return;
            }
            SdkProblemManager.this.m53360b(this.f40306a, this.f40307b, this.f40308c, this.f40309d, this.f40310e);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$e */
    public class C8655e extends FaqCallback<FeedBackResponse.ProblemEnity> {

        /* renamed from: d */
        public final /* synthetic */ SdkFeedBackCallback f40312d;

        /* renamed from: e */
        public final /* synthetic */ FeedBackRequest f40313e;

        /* renamed from: f */
        public final /* synthetic */ Activity f40314f;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$e$a */
        public class a extends BaseSdkUpdateRequest<FeedBackRequest> {

            /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$e$a$a */
            public class C14491a extends FaqCallback<FeedBackResponse.ProblemEnity> {
                public C14491a(Class cls, Activity activity) {
                    super(cls, activity);
                }

                @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
                /* renamed from: h */
                public void onResult(Throwable th2, FeedBackResponse.ProblemEnity problemEnity) {
                    C8655e c8655e = C8655e.this;
                    if (th2 == null) {
                        SdkProblemManager.this.m53364f(problemEnity, c8655e.f40312d);
                    } else {
                        c8655e.f40312d.setThrowableView(th2);
                    }
                }
            }

            public a(FeedBackRequest feedBackRequest) {
                super(feedBackRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c */
            public void onCallback(String str, String str2, String str3, FeedBackRequest feedBackRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    feedBackRequest.setAccessToken(str3);
                    FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
                    Activity activity = C8655e.this.f40314f;
                    feedbackCommonManager.getDataFromDetail(activity, feedBackRequest, new C14491a(FeedBackResponse.ProblemEnity.class, activity));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8655e(Class cls, Activity activity, SdkFeedBackCallback sdkFeedBackCallback, FeedBackRequest feedBackRequest, Activity activity2) {
            super(cls, activity);
            this.f40312d = sdkFeedBackCallback;
            this.f40313e = feedBackRequest;
            this.f40314f = activity2;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FeedBackResponse.ProblemEnity problemEnity) {
            if (th2 == null) {
                SdkProblemManager.this.m53364f(problemEnity, this.f40312d);
                return;
            }
            if (!(th2 instanceof FaqWebServiceException) || ((FaqWebServiceException) th2).errorCode != 401 || !FaqSdk.getISdk().haveSdkErr("accessToken")) {
                this.f40312d.setThrowableView(th2);
            } else {
                FaqSdk.getISdk().registerUpdateListener(new a(this.f40313e));
                FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$f */
    public class C8656f extends FaqCallback<FeedBackResponse.ProblemEnity> {

        /* renamed from: d */
        public final /* synthetic */ List f40318d;

        /* renamed from: e */
        public final /* synthetic */ FeedBackRequest f40319e;

        /* renamed from: f */
        public final /* synthetic */ Activity f40320f;

        /* renamed from: g */
        public final /* synthetic */ SdkFeedBackCallback f40321g;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$f$a */
        public class a extends BaseSdkUpdateRequest<FeedBackRequest> {

            /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$f$a$a */
            public class C14492a extends FaqCallback<FeedBackResponse.ProblemEnity> {

                /* renamed from: d */
                public final /* synthetic */ FeedBackRequest f40324d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C14492a(Class cls, Activity activity, FeedBackRequest feedBackRequest) {
                    super(cls, activity);
                    this.f40324d = feedBackRequest;
                }

                @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
                /* renamed from: h */
                public void onResult(Throwable th2, FeedBackResponse.ProblemEnity problemEnity) throws Throwable {
                    if (th2 != null) {
                        C8656f.this.f40321g.setThrowableView(th2);
                        return;
                    }
                    if (problemEnity == null) {
                        C8656f c8656f = C8656f.this;
                        SdkProblemManager.this.m53367q(null, c8656f.f40321g);
                    } else {
                        C8656f.this.f40318d.add(problemEnity);
                        C8656f c8656f2 = C8656f.this;
                        SdkProblemManager.this.m53363e(this.f40324d, c8656f2.f40320f, c8656f2.f40321g, c8656f2.f40318d);
                    }
                }
            }

            public a(FeedBackRequest feedBackRequest) {
                super(feedBackRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c */
            public void onCallback(String str, String str2, String str3, FeedBackRequest feedBackRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    feedBackRequest.setAccessToken(str3);
                    FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
                    Activity activity = C8656f.this.f40320f;
                    feedbackCommonManager.getDataFromDetail(activity, feedBackRequest, new C14492a(FeedBackResponse.ProblemEnity.class, activity, feedBackRequest));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8656f(Class cls, Activity activity, List list, FeedBackRequest feedBackRequest, Activity activity2, SdkFeedBackCallback sdkFeedBackCallback) {
            super(cls, activity);
            this.f40318d = list;
            this.f40319e = feedBackRequest;
            this.f40320f = activity2;
            this.f40321g = sdkFeedBackCallback;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FeedBackResponse.ProblemEnity problemEnity) throws Throwable {
            if (th2 == null) {
                if (problemEnity == null) {
                    SdkProblemManager.this.m53367q(null, this.f40321g);
                    return;
                } else {
                    this.f40318d.add(problemEnity);
                    SdkProblemManager.this.m53363e(this.f40319e, this.f40320f, this.f40321g, this.f40318d);
                    return;
                }
            }
            if (!(th2 instanceof FaqWebServiceException) || ((FaqWebServiceException) th2).errorCode != 401 || !FaqSdk.getISdk().haveSdkErr("accessToken")) {
                this.f40321g.setThrowableView(th2);
            } else {
                FaqSdk.getISdk().registerUpdateListener(new a(this.f40319e));
                FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$g */
    public class C8657g extends FaqCallback<FeedBackResponse> {

        /* renamed from: d */
        public final /* synthetic */ List f40326d;

        /* renamed from: e */
        public final /* synthetic */ SdkFeedBackCallback f40327e;

        /* renamed from: f */
        public final /* synthetic */ FeedBackRequest f40328f;

        /* renamed from: g */
        public final /* synthetic */ Activity f40329g;

        /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$g$a */
        public class a extends BaseSdkUpdateRequest<FeedBackRequest> {

            /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$g$a$a */
            public class C14493a extends FaqCallback<FeedBackResponse> {
                public C14493a(Class cls, Activity activity) {
                    super(cls, activity);
                }

                @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
                /* renamed from: h */
                public void onResult(Throwable th2, FeedBackResponse feedBackResponse) {
                    if (th2 == null) {
                        C8657g.this.f40326d.addAll(feedBackResponse.getDataList());
                        C8657g c8657g = C8657g.this;
                        SdkProblemManager.this.m53367q(c8657g.f40326d, c8657g.f40327e);
                    } else {
                        boolean zIsEmpty = FaqCommonUtils.isEmpty(C8657g.this.f40326d);
                        C8657g c8657g2 = C8657g.this;
                        if (zIsEmpty) {
                            c8657g2.f40327e.setThrowableView(th2);
                        } else {
                            c8657g2.f40327e.setListView(c8657g2.f40326d);
                        }
                    }
                }
            }

            public a(FeedBackRequest feedBackRequest) {
                super(feedBackRequest);
            }

            @Override // com.huawei.phoneservice.faq.base.util.BaseSdkUpdateRequest
            /* renamed from: c */
            public void onCallback(String str, String str2, String str3, FeedBackRequest feedBackRequest) {
                if ("accessToken".equals(str)) {
                    FaqSdk.getISdk().unregisterUpdateListener(this);
                    feedBackRequest.setAccessToken(str3);
                    FeedbackCommonManager feedbackCommonManager = FeedbackCommonManager.INSTANCE;
                    Activity activity = C8657g.this.f40329g;
                    feedbackCommonManager.getFeedBackList(activity, feedBackRequest, new C14493a(FeedBackResponse.class, activity));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8657g(Class cls, Activity activity, List list, SdkFeedBackCallback sdkFeedBackCallback, FeedBackRequest feedBackRequest, Activity activity2) {
            super(cls, activity);
            this.f40326d = list;
            this.f40327e = sdkFeedBackCallback;
            this.f40328f = feedBackRequest;
            this.f40329g = activity2;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, FeedBackResponse feedBackResponse) {
            if (th2 == null) {
                this.f40326d.addAll(feedBackResponse.getDataList());
                SdkProblemManager.this.m53367q(this.f40326d, this.f40327e);
            } else if ((th2 instanceof FaqWebServiceException) && ((FaqWebServiceException) th2).errorCode == 401 && FaqSdk.getISdk().haveSdkErr("accessToken")) {
                FaqSdk.getISdk().registerUpdateListener(new a(this.f40328f));
                FaqSdk.getISdk().onSdkErr("accessToken", SdkProblemManager.getSdk().getSdk("accessToken"));
            } else if (FaqCommonUtils.isEmpty(this.f40326d)) {
                this.f40327e.setThrowableView(th2);
            } else {
                this.f40327e.setListView(this.f40326d);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$h */
    public static class C8658h {

        /* renamed from: a */
        public static final SdkProblemManager f40333a = new SdkProblemManager(null);
    }

    public SdkProblemManager() {
    }

    public /* synthetic */ SdkProblemManager(C8651a c8651a) {
        this();
    }

    @Keep
    public static String getFileProviderAuthorities() {
        return f40290j;
    }

    @Keep
    public static IProblemManager getManager() {
        return C8658h.f40333a;
    }

    @Keep
    public static int getMaxFileCount() {
        return f40284d;
    }

    @Keep
    public static int getMaxFileSize() {
        return f40288h;
    }

    @Keep
    public static int getMaxImageSize() {
        return f40287g;
    }

    @Keep
    public static int getMaxVideoCount() {
        return f40285e;
    }

    @Keep
    public static int getMaxVideoSize() {
        return f40286f;
    }

    @Keep
    public static long getMinCompressSize() {
        return f40289i;
    }

    @Keep
    public static int getPageSize() {
        return f40283c;
    }

    @Keep
    public static Sdk getSdk() {
        return FaqSdk.getSdk();
    }

    @Keep
    public static void setFileProviderAuthorities(String str) {
        f40290j = str;
    }

    @Keep
    public static void setMaxFileCount(int i10) {
        if (i10 > 0) {
            f40284d = Math.min(i10, 9);
        }
    }

    @Keep
    public static void setMaxFileSize(int i10) {
        f40288h = i10;
    }

    @Keep
    public static void setMaxImageSize(int i10) {
        if (i10 > 0) {
            f40287g = i10;
        }
    }

    @Keep
    public static void setMaxVideoCount(int i10) {
        if (i10 >= 0) {
            f40285e = Math.min(i10, 9);
        }
    }

    @Keep
    public static void setMaxVideoSize(int i10) {
        if (i10 > 0) {
            f40286f = i10;
        }
    }

    @Keep
    public static void setMinCompressSize(long j10) {
        if (j10 >= ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
            f40289i = j10;
        }
    }

    @Keep
    public static void setPageSize(int i10) {
        f40283c = i10;
    }

    /* renamed from: a */
    public final Long m53359a(String str) throws IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        return Long.valueOf(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)));
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void addReadListener(OnReadListener onReadListener) {
        if (this.f40292b == null) {
            this.f40292b = new ArrayList();
        }
        this.f40292b.add(onReadListener);
    }

    /* renamed from: b */
    public final void m53360b(Activity activity, String str, String str2, File file, VideoCallBack videoCallBack) throws Throwable {
        long jM53359a;
        try {
            if (FeedbackMediaData.getInstance(activity).getMediaEntityByAttach(str2) == null) {
                MediaEntity mediaEntity = new MediaEntity();
                if (MimeType.isVideoFromUrl(str)) {
                    mediaEntity.type = MimeType.getMimeType(str);
                    jM53359a = m53359a(file.getCanonicalPath());
                } else {
                    mediaEntity.type = MimeType.getMimeType(str);
                    jM53359a = 0L;
                }
                mediaEntity.duration = jM53359a;
                mediaEntity.attach = str2;
                mediaEntity.cache = file.getCanonicalPath();
                mediaEntity.path = file.getCanonicalPath();
                mediaEntity.updateTime = Long.valueOf(System.currentTimeMillis());
                mediaEntity.createTime = Long.valueOf(System.currentTimeMillis());
                mediaEntity.url = str;
                FeedbackMediaData.getInstance(activity).saveMediaEntity(mediaEntity);
            } else {
                FeedbackMediaData.getInstance(activity).updateCacheByAttach(str2, file.getCanonicalPath());
                if (MimeType.isVideoFromUrl(str)) {
                    FeedbackMediaData.getInstance(activity).updateDurationByAttach(str2, m53359a(file.getCanonicalPath()));
                }
            }
        } catch (IOException e10) {
            FaqLogger.m51840e("SdkProblemManager", e10.getMessage());
        }
        if (videoCallBack != null) {
            videoCallBack.setChangeImage(file, MimeType.isVideoFromUrl(str));
        }
    }

    /* renamed from: c */
    public final void m53361c(Activity activity, String str, String str2, boolean z10, VideoCallBack videoCallBack) {
        String sdk = getSdk().getSdk("accessToken");
        if (activity == null || TextUtils.isEmpty(sdk) || TextUtils.isEmpty(str)) {
            m53362d(videoCallBack);
        } else {
            ComponentCallbacks2C1546b.m8904t(activity.getApplicationContext()).m8978l().m8970s(new C8988b(str, new C8991e.a().m56830b("accessToken", sdk).m56831c())).skipMemoryCache(true).m8967p(new C8652b(videoCallBack)).m8962k(new C8651a(z10, videoCallBack, activity, str, str2));
        }
    }

    /* renamed from: d */
    public final void m53362d(VideoCallBack videoCallBack) {
        if (videoCallBack != null) {
            videoCallBack.setChangeImage(null, false);
        }
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void deleteHistory(Context context, String str, OnDeleteHistoryListener onDeleteHistoryListener) {
        new C8660b(context, str).m53388c(onDeleteHistoryListener);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void downLoadFile(Activity activity, String str, VideoCallBack videoCallBack, String str2) {
        m53361c(activity, str, str2, false, videoCallBack);
    }

    /* renamed from: e */
    public final void m53363e(FeedBackRequest feedBackRequest, Activity activity, SdkFeedBackCallback sdkFeedBackCallback, List<FeedBackResponse.ProblemEnity> list) throws Throwable {
        FaqLogger.m51840e("SdkProblemManager", "doRequestForChild");
        FeedbackCommonManager.INSTANCE.getFeedBackList(activity, feedBackRequest, new C8657g(FeedBackResponse.class, activity, list, sdkFeedBackCallback, feedBackRequest, activity));
    }

    /* renamed from: f */
    public final void m53364f(FeedBackResponse.ProblemEnity problemEnity, SdkFeedBackCallback sdkFeedBackCallback) {
        ArrayList arrayList;
        if (problemEnity != null) {
            arrayList = new ArrayList();
            arrayList.add(problemEnity);
        } else {
            arrayList = null;
        }
        sdkFeedBackCallback.setListView(arrayList);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void getDataFromSdk(Activity activity, String str, String str2, int i10, String str3, int i11, SdkFeedBackCallback sdkFeedBackCallback) throws Throwable {
        if (!FaqSdk.getISdk().hadAddress()) {
            sdkFeedBackCallback.setThrowableView(new FaqWebServiceException(-1, "No URL Address"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        FeedBackRequest feedBackRequest = new FeedBackRequest();
        feedBackRequest.setProblemId(str2);
        feedBackRequest.setAccessToken(getSdk().getSdk("accessToken"));
        feedBackRequest.setStartWith(str);
        feedBackRequest.setPageSize(i10);
        feedBackRequest.setProblemSourceCode(str3);
        feedBackRequest.setOrderType(i11);
        FaqLogger.m51840e("SdkProblemManager", "getDataFromSDK");
        if (TextUtils.isEmpty(str)) {
            m53368r(feedBackRequest, activity, sdkFeedBackCallback, arrayList);
        } else {
            m53363e(feedBackRequest, activity, sdkFeedBackCallback, arrayList);
        }
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void getFeedBackList(Context context, String str, int i10, String str2, int i11, OnHistoryListener onHistoryListener) {
        new C8669i(context, str, i10, str2, i11).m53454i(onHistoryListener);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void getReadState(Activity activity, String str, SdkFeedBackCallback sdkFeedBackCallback) {
        if (!FaqSdk.getISdk().hadAddress()) {
            sdkFeedBackCallback.setThrowableView(new FaqWebServiceException(-1, "No URL Address"));
            return;
        }
        FeedBackRequest feedBackRequest = new FeedBackRequest();
        feedBackRequest.setAccessToken(FaqSdk.getSdk().getSdk("accessToken"));
        feedBackRequest.setProblemId(str);
        FeedbackCommonManager.INSTANCE.getDataFromDetail(activity, feedBackRequest, new C8655e(FeedBackResponse.ProblemEnity.class, activity, sdkFeedBackCallback, feedBackRequest, activity));
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public SdkProblemListener getSdkListener() {
        WeakReference<SdkProblemListener> weakReference = this.f40291a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public String getSdkVersion() {
        return "25.5.0.1";
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void getSrCodeData(Activity activity, SdkFeedBackCallback sdkFeedBackCallback) {
        new C8663e(activity).m53409d(sdkFeedBackCallback);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void getUnread(Context context, String str, OnReadListener onReadListener) {
        getUnread(context, str, false, onReadListener);
    }

    /* renamed from: o */
    public final void m53365o(File file, Activity activity, String str, String str2, VideoCallBack videoCallBack) {
        new Thread(new RunnableC8654d(activity, str, str2, file, videoCallBack)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.FileReader, java.io.Reader, java.lang.Readable] */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m53366p(java.io.File r10, com.huawei.phoneservice.faq.base.util.VideoCallBack r11, android.app.Activity r12, java.lang.String r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "accessToken"
            java.lang.String r1 = "SdkProblemManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L84 java.io.FileNotFoundException -> L87
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L84 java.io.FileNotFoundException -> L87
            java.util.Scanner r10 = new java.util.Scanner     // Catch: java.lang.Throwable -> L82 java.io.FileNotFoundException -> L88
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L82 java.io.FileNotFoundException -> L88
        L14:
            boolean r3 = r10.hasNextLine()     // Catch: java.lang.Throwable -> L22 java.io.FileNotFoundException -> L80
            if (r3 == 0) goto L24
            java.lang.String r3 = r10.nextLine()     // Catch: java.lang.Throwable -> L22 java.io.FileNotFoundException -> L80
            r2.append(r3)     // Catch: java.lang.Throwable -> L22 java.io.FileNotFoundException -> L80
            goto L14
        L22:
            r9 = move-exception
            goto L7e
        L24:
            r10.close()
            r4.close()     // Catch: java.io.IOException -> L2b
            goto L33
        L2b:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r1, r10)
        L33:
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Throwable -> L7a
            com.google.gson.JsonElement r10 = com.google.gson.JsonParser.parseString(r10)     // Catch: java.lang.Throwable -> L7a
            com.google.gson.JsonObject r10 = r10.getAsJsonObject()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r1 = "responseCode"
            com.google.gson.JsonElement r10 = r10.get(r1)     // Catch: java.lang.Throwable -> L7a
            if (r10 != 0) goto L4b
            r9.m53362d(r11)     // Catch: java.lang.Throwable -> L7a
            return
        L4b:
            int r10 = r10.getAsInt()     // Catch: java.lang.Throwable -> L7a
            r1 = 401(0x191, float:5.62E-43)
            if (r10 != r1) goto L76
            com.huawei.phoneservice.faq.base.util.ISdk r10 = com.huawei.phoneservice.faq.base.util.FaqSdk.getISdk()     // Catch: java.lang.Throwable -> L7a
            com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$c r8 = new com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager$c     // Catch: java.lang.Throwable -> L7a
            r3 = 0
            r1 = r8
            r2 = r9
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r11
            r1.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7a
            r10.registerUpdateListener(r8)     // Catch: java.lang.Throwable -> L7a
            com.huawei.phoneservice.faq.base.util.ISdk r10 = com.huawei.phoneservice.faq.base.util.FaqSdk.getISdk()     // Catch: java.lang.Throwable -> L7a
            com.huawei.phoneservice.faq.base.util.Sdk r12 = getSdk()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r12 = r12.getSdk(r0)     // Catch: java.lang.Throwable -> L7a
            r10.onSdkErr(r0, r12)     // Catch: java.lang.Throwable -> L7a
            goto L7d
        L76:
            r9.m53362d(r11)     // Catch: java.lang.Throwable -> L7a
            goto L7d
        L7a:
            r9.m53362d(r11)
        L7d:
            return
        L7e:
            r3 = r10
            goto La4
        L80:
            r3 = r10
            goto L88
        L82:
            r9 = move-exception
            goto La4
        L84:
            r9 = move-exception
            r10 = r3
            goto La2
        L87:
            r4 = r3
        L88:
            r9.m53362d(r11)     // Catch: java.lang.Throwable -> L9f
            if (r3 == 0) goto L90
            r3.close()
        L90:
            if (r4 == 0) goto L9e
            r4.close()     // Catch: java.io.IOException -> L96
            goto L9e
        L96:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r1, r9)
        L9e:
            return
        L9f:
            r9 = move-exception
            r10 = r3
            r3 = r4
        La2:
            r4 = r3
            goto L7e
        La4:
            if (r3 == 0) goto La9
            r3.close()
        La9:
            if (r4 == 0) goto Lb7
            r4.close()     // Catch: java.io.IOException -> Laf
            goto Lb7
        Laf:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r1, r10)
        Lb7:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager.m53366p(java.io.File, com.huawei.phoneservice.faq.base.util.VideoCallBack, android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* renamed from: q */
    public final void m53367q(List<FeedBackResponse.ProblemEnity> list, SdkFeedBackCallback sdkFeedBackCallback) {
        if (FaqCommonUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        sdkFeedBackCallback.setListView(list);
    }

    /* renamed from: r */
    public final void m53368r(FeedBackRequest feedBackRequest, Activity activity, SdkFeedBackCallback sdkFeedBackCallback, List<FeedBackResponse.ProblemEnity> list) throws Throwable {
        FaqLogger.m51840e("SdkProblemManager", "doRequestForParent");
        FeedbackCommonManager.INSTANCE.getDataFromDetail(activity, feedBackRequest, new C8656f(FeedBackResponse.ProblemEnity.class, activity, list, feedBackRequest, activity, sdkFeedBackCallback));
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void reUploadZip(Context context, String str, long j10, String str2, NotifyUploadZipListener notifyUploadZipListener) {
        new C8673m(context, str, str2).m53560t(notifyUploadZipListener);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public CancelInterface reUploadZipWithCancel(Context context, String str, long j10, String str2, NotifyUploadZipListener notifyUploadZipListener) {
        C8673m c8673m = new C8673m(context, str, str2);
        c8673m.m53560t(notifyUploadZipListener);
        return c8673m.m53399a();
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.OnReadListener
    public void read(Throwable th2, String str) {
        List<OnReadListener> list = this.f40292b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f40292b.get(size).read(th2, str);
            }
        }
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void removeReadListener(OnReadListener onReadListener) {
        List<OnReadListener> list = this.f40292b;
        if (list != null) {
            list.remove(onReadListener);
        }
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void setRead(Context context, String str, OnReadListener onReadListener) {
        new C8670j(context, str, this).m53464c(onReadListener);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void setSdkListener(SdkProblemListener sdkProblemListener) {
        if (sdkProblemListener != null) {
            WeakReference<SdkProblemListener> weakReference = this.f40291a;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f40291a = new WeakReference<>(sdkProblemListener);
            return;
        }
        WeakReference<SdkProblemListener> weakReference2 = this.f40291a;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.f40291a = null;
        }
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void submit(Context context, boolean z10, List<String> list, List<FeedbackZipBean> list2, FeedbackInfo feedbackInfo, SubmitListener submitListener) {
        new C8671k(context, z10, list, list2, feedbackInfo).m53477f(submitListener);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public CancelInterface submitWithCancel(Context context, boolean z10, List<String> list, List<FeedbackZipBean> list2, FeedbackInfo feedbackInfo, SubmitListener submitListener) {
        C8671k c8671k = new C8671k(context, z10, list, list2, feedbackInfo);
        c8671k.m53477f(submitListener);
        return c8671k.m53399a();
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.OnReadListener
    public void unread(Throwable th2, String str, int i10) {
        List<OnReadListener> list = this.f40292b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f40292b.get(size).unread(th2, str, i10);
            }
        }
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void uploadAttachment(Context context, MediaEntity mediaEntity, NotifyUploadFileListener notifyUploadFileListener) {
        new C8672l(context, mediaEntity).m53497f(notifyUploadFileListener);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public CancelInterface uploadAttachmentWithCancel(Context context, MediaEntity mediaEntity, NotifyUploadFileListener notifyUploadFileListener) {
        C8672l c8672l = new C8672l(context, mediaEntity);
        c8672l.m53497f(notifyUploadFileListener);
        return c8672l.m53399a();
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void uploadZip(Context context, String str, long j10, String str2, NotifyUploadZipListener notifyUploadZipListener) {
        new C8673m(context, str, str2).m53541O(notifyUploadZipListener);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public CancelInterface uploadZipWithCancel(Context context, String str, long j10, String str2, NotifyUploadZipListener notifyUploadZipListener) {
        C8673m c8673m = new C8673m(context, str, str2);
        c8673m.m53541O(notifyUploadZipListener);
        return c8673m.m53399a();
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void zipCompress(Context context, ZipCompressListener zipCompressListener) {
        new AsyncTaskC8674n(context, zipCompressListener).execute(new Object[0]);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void zipCompressAgain(Context context, long j10, ZipCompressListener zipCompressListener) {
        new AsyncTaskC8674n(context, j10, zipCompressListener).execute(new Object[0]);
    }

    @Override // com.huawei.phoneservice.feedbackcommon.utils.IProblemManager
    public void getUnread(Context context, String str, boolean z10, OnReadListener onReadListener) {
        new C8666f(context, str, z10, this).m53428b(onReadListener);
    }
}
