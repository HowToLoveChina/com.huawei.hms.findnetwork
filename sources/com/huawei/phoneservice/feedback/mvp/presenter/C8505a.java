package com.huawei.phoneservice.feedback.mvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.constant.MimeType;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigRequest;
import com.huawei.phoneservice.faq.base.entity.ModuleConfigResponse;
import com.huawei.phoneservice.faq.base.network.FaqCallback;
import com.huawei.phoneservice.faq.base.network.FaqWebServiceException;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqDeviceUtils;
import com.huawei.phoneservice.faq.base.util.FaqFileUtils;
import com.huawei.phoneservice.faq.base.util.FaqHandler;
import com.huawei.phoneservice.faq.base.util.FaqLanguageUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import com.huawei.phoneservice.faq.base.util.FaqUtil;
import com.huawei.phoneservice.faq.base.util.ModuleConfigUtils;
import com.huawei.phoneservice.feedback.entity.C8470a;
import com.huawei.phoneservice.feedback.entity.C8471b;
import com.huawei.phoneservice.feedback.entity.C8473d;
import com.huawei.phoneservice.feedback.mvp.base.AbstractC8495d;
import com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a;
import com.huawei.phoneservice.feedback.p175ui.ProductSuggestionActivity;
import com.huawei.phoneservice.feedbackcommon.entity.MediaEntity;
import com.huawei.phoneservice.feedbackcommon.p176db.FeedbackMediaData;
import com.huawei.phoneservice.feedbackcommon.photolibrary.internal.entity.MediaItem;
import com.huawei.phoneservice.feedbackcommon.utils.CancelInterface;
import com.huawei.phoneservice.feedbackcommon.utils.CompressTask;
import com.huawei.phoneservice.feedbackcommon.utils.FeedbackCommonManager;
import com.huawei.phoneservice.feedbackcommon.utils.SdkProblemManager;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.a */
/* loaded from: classes5.dex */
public class C8505a extends AbstractC8495d<InterfaceC8499a> implements FaqHandler.CallBack {

    /* renamed from: s */
    public List<C8471b> f39654s;

    /* renamed from: t */
    public LinkedList<MediaEntity> f39655t;

    /* renamed from: u */
    public long f39656u;

    /* renamed from: v */
    public LinkedList<Pair<Integer, MediaEntity>> f39657v;

    /* renamed from: w */
    public List<String> f39658w;

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.a$a */
    public class a extends FaqCallback<C8473d> {
        public a(Class cls, Activity activity) {
            super(cls, activity);
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8473d c8473d) {
            if (th2 != null || c8473d == null) {
                ((InterfaceC8499a) C8505a.this.f39653r).mo52772v(FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
                return;
            }
            C8505a.this.f39654s.clear();
            List<C8471b> list = c8473d.f39540a;
            if (list != null && !list.isEmpty()) {
                C8505a.this.f39654s.addAll(c8473d.f39540a);
            }
            ((InterfaceC8499a) C8505a.this.f39653r).mo52770b(C8505a.this.f39654s);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.a$b */
    public class b implements CompressTask.TaskCallBack {

        /* renamed from: a */
        public final /* synthetic */ Pair f39660a;

        public b(Pair pair) {
            this.f39660a = pair;
        }

        @Override // com.huawei.phoneservice.feedbackcommon.utils.CompressTask.TaskCallBack
        public void compressDone(Throwable th2, String str) {
            MediaEntity mediaEntity = (MediaEntity) this.f39660a.second;
            mediaEntity.cache = str;
            mediaEntity.type = MimeType.JPEG;
            if (C8505a.this.f39655t.size() > ((Integer) this.f39660a.first).intValue()) {
                C8505a.this.f39655t.set(((Integer) this.f39660a.first).intValue(), (MediaEntity) this.f39660a.second);
            }
            C8505a.m52784f(C8505a.this, new File(str).length());
            C8505a.this.f39644i.sendEmptyMessage(3);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.a$c */
    public class c extends FaqCallback<ModuleConfigResponse> {

        /* renamed from: d */
        public final /* synthetic */ Context f39662d;

        /* renamed from: e */
        public final /* synthetic */ String f39663e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Class cls, Activity activity, Context context, String str) {
            super(cls, activity);
            this.f39662d = context;
            this.f39663e = str;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, ModuleConfigResponse moduleConfigResponse) {
            if (th2 != null || moduleConfigResponse == null) {
                C8505a c8505a = C8505a.this;
                ((InterfaceC8499a) (th2 != null ? c8505a.f39653r : c8505a.f39653r)).mo52772v(FaqConstants.FaqErrorCode.CONNECT_SERVER_ERROR);
            } else {
                ModuleConfigUtils.genSdkModuleList(this.f39662d, moduleConfigResponse.getModuleList());
                C8505a.this.m52807u(this.f39662d, this.f39663e);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.mvp.presenter.a$d */
    public class d extends FaqCallback<C8470a> {

        /* renamed from: d */
        public final /* synthetic */ String f39665d;

        /* renamed from: e */
        public final /* synthetic */ Context f39666e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Class cls, Activity activity, String str, Context context) {
            super(cls, activity);
            this.f39665d = str;
            this.f39666e = context;
        }

        @Override // com.huawei.phoneservice.faq.base.network.FaqCallback
        /* renamed from: h */
        public void onResult(Throwable th2, C8470a c8470a) {
            if (th2 != null || c8470a == null) {
                ((InterfaceC8499a) C8505a.this.f39653r).mo52771c(th2 instanceof FaqWebServiceException ? ((FaqWebServiceException) th2).errorCode : -1);
            } else {
                C8505a.this.m52800j(this.f39666e, new ModuleConfigRequest(FaqLanguageUtils.getSystemCountry(), FaqLanguageUtils.getLanguage(), FaqUtil.getBrand(), this.f39665d, SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_SHASN), FaqDeviceUtils.getSpecialEmuiVersion(), SdkProblemManager.getSdk().getSdk("appVersion"), SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_MODEL), FaqDeviceUtils.getMachineType()), this.f39665d);
            }
        }
    }

    public C8505a(InterfaceC8499a interfaceC8499a, Context context, Activity activity) {
        super(interfaceC8499a);
        this.f39654s = new ArrayList();
        this.f39655t = new LinkedList<>();
        this.f39656u = 0L;
        this.f39657v = new LinkedList<>();
        this.f39658w = new ArrayList(SdkProblemManager.getMaxFileCount());
        this.f39645j = context;
        this.f39646k = activity;
    }

    /* renamed from: f */
    public static /* synthetic */ long m52784f(C8505a c8505a, long j10) {
        long j11 = c8505a.f39656u + j10;
        c8505a.f39656u = j11;
        return j11;
    }

    /* renamed from: s */
    private void m52788s(String str) {
        this.f39647l = 0;
        this.f39648m = null;
        ((InterfaceC8499a) this.f39653r).mo52754a();
        ((InterfaceC8499a) this.f39653r).mo52756c(str);
        this.f39640e = false;
        if (SdkProblemManager.getManager().getSdkListener() != null) {
            SdkProblemManager.getManager().getSdkListener().onSubmitResult(-1, null, ((InterfaceC8499a) this.f39653r).mo52764c().getProblemId(), ((InterfaceC8499a) this.f39653r).mo52764c().getSrCode(), str);
        }
    }

    /* renamed from: A */
    public void m52792A() {
        LinkedList<MediaEntity> linkedList = this.f39655t;
        if (linkedList == null) {
            this.f39655t = new LinkedList<>();
        } else {
            linkedList.clear();
        }
        LinkedList<Pair<Integer, MediaEntity>> linkedList2 = this.f39657v;
        if (linkedList2 == null) {
            this.f39657v = new LinkedList<>();
        } else {
            linkedList2.clear();
        }
        this.f39656u = 0L;
    }

    /* renamed from: C */
    public List<C8471b> m52793C() {
        return this.f39654s;
    }

    /* renamed from: E */
    public void m52794E() {
        if (this.f39647l == 0) {
            this.f39647l = 1;
        }
    }

    /* renamed from: G */
    public void m52795G() {
        if (this.f39647l == 1) {
            this.f39647l = 0;
            return;
        }
        if (this.f39647l == 2) {
            this.f39647l = 0;
            m52762d(this.f39658w);
        } else {
            if (this.f39647l != 3 || TextUtils.isEmpty(this.f39648m)) {
                return;
            }
            this.f39647l = 0;
            Handler handler = this.f39644i;
            if (handler != null) {
                handler.sendMessage(handler.obtainMessage(7, this.f39648m));
            }
        }
    }

    /* renamed from: I */
    public void m52796I() {
        Handler handler = this.f39644i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        CancelInterface cancelInterface = this.f39652q;
        if (cancelInterface != null) {
            cancelInterface.isCancel(true);
        }
        ((InterfaceC8499a) this.f39653r).mo52754a();
        this.f39640e = false;
        this.f39641f = true;
        if (SdkProblemManager.getManager().getSdkListener() != null) {
            SdkProblemManager.getManager().getSdkListener().onSubmitResult(-1, null, ((InterfaceC8499a) this.f39653r).mo52764c().getProblemId(), ((InterfaceC8499a) this.f39653r).mo52764c().getSrCode(), "");
        }
        this.f39647l = 0;
        CancelInterface cancelInterface2 = this.f39652q;
        if (cancelInterface2 != null) {
            cancelInterface2.isCancel(false);
        }
    }

    /* renamed from: J */
    public void m52797J() {
        SdkProblemManager.getManager().zipCompress(this.f39645j, this);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8497f
    /* renamed from: a */
    public void mo52765a() {
        this.f39644i = new FaqHandler(this);
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.InterfaceC8497f
    /* renamed from: b */
    public void mo52766b() {
        Handler handler = this.f39644i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f39644i = null;
        }
    }

    @Override // com.huawei.phoneservice.feedback.mvp.base.AbstractC8494c
    /* renamed from: e */
    public void mo52763e(boolean z10) {
        this.f39650o = z10;
        if (FaqCommonUtils.isEmpty(this.f39655t)) {
            m52762d(this.f39658w);
        } else {
            m52806r(this.f39655t.getFirst());
        }
    }

    /* renamed from: h */
    public void m52798h(int i10, int i11) {
        this.f39642g = i10;
        this.f39643h = i11;
    }

    @Override // com.huawei.phoneservice.faq.base.util.FaqHandler.CallBack
    public void handleMessage(int i10, Message message) {
        if (i10 == 100) {
            this.f39652q = SdkProblemManager.getManager().reUploadZipWithCancel(this.f39645j, this.f39637b, ((InterfaceC8499a) this.f39653r).mo52764c().getLogsSize(), ((InterfaceC8499a) this.f39653r).mo52764c().getZipFileName(), this);
            return;
        }
        if (i10 == 3) {
            if (!FaqCommonUtils.isEmpty(this.f39657v)) {
                m52805o(this.f39657v.removeFirst());
                return;
            } else {
                ((InterfaceC8499a) this.f39653r).mo52768a(false);
                ((InterfaceC8499a) this.f39653r).mo52764c().setFilesSize(this.f39656u);
                return;
            }
        }
        if (i10 == 4) {
            String str = (String) message.obj;
            this.f39658w.add(str);
            ((InterfaceC8499a) this.f39653r).mo52769b(str);
            int size = this.f39658w.size();
            if (size < this.f39655t.size()) {
                m52806r(this.f39655t.get(size));
                return;
            } else {
                m52762d(this.f39658w);
                return;
            }
        }
        if (i10 != 5) {
            if (i10 == 6) {
                this.f39647l = 0;
                this.f39648m = null;
                String str2 = (String) message.obj;
                ((InterfaceC8499a) this.f39653r).mo52754a();
                ((InterfaceC8499a) this.f39653r).mo52767a(str2);
                this.f39640e = false;
                return;
            }
            if (i10 != 7) {
                return;
            }
        }
        String str3 = (String) message.obj;
        if (this.f39647l == 0) {
            m52788s(str3);
        } else {
            this.f39647l = 3;
            this.f39648m = str3;
        }
    }

    /* renamed from: i */
    public void m52799i(Context context) {
        ((InterfaceC8499a) this.f39653r).mo52768a(true);
        List<MediaItem> medias = ((InterfaceC8499a) this.f39653r).mo52764c().getMedias();
        m52792A();
        m52809w(medias);
        if (!FaqCommonUtils.isEmpty(this.f39657v)) {
            m52805o(this.f39657v.removeFirst());
        } else {
            ((InterfaceC8499a) this.f39653r).mo52768a(false);
            ((InterfaceC8499a) this.f39653r).mo52764c().setFilesSize(this.f39656u);
        }
    }

    /* renamed from: j */
    public final void m52800j(Context context, ModuleConfigRequest moduleConfigRequest, String str) {
        FaqSdk.getISdk().queryModuleList(context, moduleConfigRequest, new c(ModuleConfigResponse.class, (Activity) context, context, str));
    }

    /* renamed from: k */
    public void m52801k(Context context, String str) {
        m52760b(context, str, new a(C8473d.class, (Activity) context));
    }

    /* renamed from: l */
    public void m52802l(Context context, String str, long j10, String str2) {
        FeedbackCommonManager.INSTANCE.queryForHD(context, j10, str2, new d(C8470a.class, (Activity) context, str, context));
    }

    /* renamed from: m */
    public void m52803m(Context context, String str, String str2, String str3) throws Throwable {
        try {
            m52802l(context, str, Long.valueOf(str2).longValue(), str3);
        } catch (NumberFormatException unused) {
            FaqLogger.m51836d("FeedBackPresenter", "NumberFormatException");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        if (com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r2.f39655t) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
    
        if (com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r2.f39655t) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
    
        m52806r(r2.f39655t.getFirst());
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        m52762d(r2.f39658w);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m52804n(android.content.Context r3, boolean r4) {
        /*
            r2 = this;
            V r0 = r2.f39653r
            com.huawei.phoneservice.feedback.mvp.contract.a r0 = (com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a) r0
            r0.mo52757e()
            r0 = 1
            r2.f39640e = r0
            r0 = 0
            r2.f39641f = r0
            r2.f39647l = r0
            java.util.List<java.lang.String> r0 = r2.f39658w
            r0.clear()
            V r0 = r2.f39653r
            com.huawei.phoneservice.feedback.mvp.contract.a r0 = (com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a) r0
            com.huawei.phoneservice.feedback.entity.FeedbackBean r0 = r0.mo52764c()
            int r0 = r0.getFlag()
            r2.f39639d = r0
            java.lang.String r3 = com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants.getZipFilePath(r3)
            r2.f39637b = r3
            if (r4 == 0) goto L72
            int r3 = r2.f39639d
            r4 = 2
            if (r3 != r4) goto L69
            java.io.File r3 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = r2.f39637b
            r4.append(r0)
            java.lang.String r0 = java.io.File.separator
            r4.append(r0)
            V r0 = r2.f39653r
            com.huawei.phoneservice.feedback.mvp.contract.a r0 = (com.huawei.phoneservice.feedback.mvp.contract.InterfaceC8499a) r0
            com.huawei.phoneservice.feedback.entity.FeedbackBean r0 = r0.mo52764c()
            java.lang.String r0 = r0.getZipFileName()
            r4.append(r0)
            java.lang.String r0 = ".zip"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            java.lang.String r4 = r2.f39637b
            long r0 = r3.length()
            java.lang.String r3 = r3.getName()
            r2.m52761c(r4, r0, r3)
            goto L8b
        L69:
            java.util.LinkedList<com.huawei.phoneservice.feedbackcommon.entity.MediaEntity> r3 = r2.f39655t
            boolean r3 = com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r3)
            if (r3 != 0) goto L86
            goto L7a
        L72:
            java.util.LinkedList<com.huawei.phoneservice.feedbackcommon.entity.MediaEntity> r3 = r2.f39655t
            boolean r3 = com.huawei.phoneservice.faq.base.util.FaqCommonUtils.isEmpty(r3)
            if (r3 != 0) goto L86
        L7a:
            java.util.LinkedList<com.huawei.phoneservice.feedbackcommon.entity.MediaEntity> r3 = r2.f39655t
            java.lang.Object r3 = r3.getFirst()
            com.huawei.phoneservice.feedbackcommon.entity.MediaEntity r3 = (com.huawei.phoneservice.feedbackcommon.entity.MediaEntity) r3
            r2.m52806r(r3)
            goto L8b
        L86:
            java.util.List<java.lang.String> r3 = r2.f39658w
            r2.m52762d(r3)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.mvp.presenter.C8505a.m52804n(android.content.Context, boolean):void");
    }

    /* renamed from: o */
    public final void m52805o(Pair<Integer, MediaEntity> pair) {
        String compressFolder = FaqFileUtils.getCompressFolder(this.f39645j);
        Handler handler = this.f39644i;
        if (handler != null) {
            handler.post(new CompressTask(this.f39645j, ((MediaEntity) pair.second).path, compressFolder, new b(pair)));
        }
    }

    /* renamed from: r */
    public final void m52806r(MediaEntity mediaEntity) {
        if (this.f39641f) {
            return;
        }
        this.f39652q = SdkProblemManager.getManager().uploadAttachmentWithCancel(this.f39645j, mediaEntity, this);
    }

    /* renamed from: u */
    public final void m52807u(Context context, String str) {
        m52801k(context, str);
    }

    /* renamed from: v */
    public void m52808v(Context context, boolean z10) {
        if (this.f39645j instanceof ProductSuggestionActivity) {
            ((InterfaceC8499a) this.f39653r).mo52770b((List<C8471b>) null);
        } else if (z10 || ModuleConfigUtils.isEmpty()) {
            m52800j(context, new ModuleConfigRequest(SdkProblemManager.getSdk().getSdk("country"), SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_EMUI_LANGUAGE), FaqUtil.getBrand(), SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_CHANNEL), SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_SHASN), FaqDeviceUtils.getSpecialEmuiVersion(), SdkProblemManager.getSdk().getSdk("appVersion"), SdkProblemManager.getSdk().getSdk(FaqConstants.FAQ_MODEL), FaqDeviceUtils.getMachineType()), null);
        } else {
            m52801k(context, null);
        }
    }

    /* renamed from: w */
    public final void m52809w(List<MediaItem> list) {
        long j10;
        long size;
        LinkedList<Pair<Integer, MediaEntity>> linkedList;
        Pair<Integer, MediaEntity> pair;
        int size2 = list.size();
        int i10 = 0;
        while (i10 < size2) {
            MediaItem mediaItem = list.get(i10);
            String filePath = mediaItem.getFilePath();
            if (TextUtils.isEmpty(filePath)) {
                list.remove(i10);
                size2--;
                i10--;
            } else {
                MediaEntity mediaEntityByPath = FeedbackMediaData.getInstance(this.f39645j).getMediaEntityByPath(filePath);
                if (!mediaItem.isImage() || mediaItem.getSize() <= SdkProblemManager.getMinCompressSize()) {
                    if (mediaEntityByPath == null) {
                        mediaEntityByPath = new MediaEntity(mediaItem, filePath, mediaItem.getUri());
                    }
                    mediaEntityByPath.cache = filePath;
                    mediaEntityByPath.duration = Long.valueOf(mediaItem.isVideo() ? mediaItem.getDuration() : 0L);
                    j10 = this.f39656u;
                    size = mediaItem.getSize();
                } else {
                    if (mediaEntityByPath == null) {
                        mediaEntityByPath = new MediaEntity(mediaItem, filePath, mediaItem.getUri());
                        linkedList = this.f39657v;
                        pair = new Pair<>(Integer.valueOf(i10), mediaEntityByPath);
                    } else if (mediaEntityByPath.noCache()) {
                        linkedList = this.f39657v;
                        pair = new Pair<>(Integer.valueOf(i10), mediaEntityByPath);
                    } else {
                        File file = new File(mediaEntityByPath.cache);
                        if (file.exists()) {
                            j10 = this.f39656u;
                            size = file.length();
                        } else {
                            linkedList = this.f39657v;
                            pair = new Pair<>(Integer.valueOf(i10), mediaEntityByPath);
                        }
                    }
                    linkedList.add(pair);
                    this.f39655t.add(mediaEntityByPath);
                }
                this.f39656u = j10 + size;
                this.f39655t.add(mediaEntityByPath);
            }
            i10++;
        }
    }

    /* renamed from: y */
    public boolean m52810y() {
        return !this.f39640e;
    }
}
