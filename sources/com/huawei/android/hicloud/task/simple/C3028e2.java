package com.huawei.android.hicloud.task.simple;

import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.FilterDataForRecommend;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hicloud.messagecenter.bean.H5WindowMsgObj;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.messagecenter.operator.MessageH5DbOperator;
import com.huawei.hicloud.notification.bean.NotifyAgdParameters;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotifyBlackListManager;
import com.huawei.hicloud.notification.p106db.bean.HiCLoudNotifyBlackListConfig;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import fk.C9721b;
import hu.C10344c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0213f;
import p015ak.C0234s;
import p020ap.C1009d;
import p341hj.C10220d0;
import p341hj.C10250n0;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p778xk.C13821b;
import p778xk.C13823d;
import p836z8.C14157f;

/* renamed from: com.huawei.android.hicloud.task.simple.e2 */
/* loaded from: classes3.dex */
public class C3028e2 extends AbstractRunnableC12516b {

    /* renamed from: a */
    public Handler f13237a;

    /* renamed from: b */
    public C11060c f13238b;

    /* renamed from: com.huawei.android.hicloud.task.simple.e2$a */
    public class a extends Handler {

        /* renamed from: a */
        public final /* synthetic */ d f13239a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f13240b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, d dVar, CountDownLatch countDownLatch) {
            super(looper);
            this.f13239a = dVar;
            this.f13240b = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 6009) {
                this.f13239a.f13261a = C3028e2.this.m18316n(message.obj);
                this.f13239a.f13263c = 0;
                this.f13240b.countDown();
                return;
            }
            if (i10 != 6010) {
                this.f13240b.countDown();
                return;
            }
            this.f13239a.f13263c = 1;
            C11839m.m70688i("QueryH5WindowMessageTask", "getPackageId CHECK_FAIL msg.obj e.getMessage()：" + message.obj);
            this.f13240b.countDown();
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.e2$b */
    public class b extends Handler {

        /* renamed from: a */
        public final /* synthetic */ d f13242a;

        /* renamed from: b */
        public final /* synthetic */ CountDownLatch f13243b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, d dVar, CountDownLatch countDownLatch) {
            super(looper);
            this.f13242a = dVar;
            this.f13243b = countDownLatch;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 2001) {
                C11839m.m70688i("QueryH5WindowMessageTask", "getUserPackage success");
                this.f13242a.f13262b = C3028e2.this.m18323u(message);
                this.f13242a.f13263c = 0;
                this.f13243b.countDown();
                return;
            }
            if (i10 != 2101) {
                C11839m.m70688i("QueryH5WindowMessageTask", "getUserPackage other recall");
                this.f13243b.countDown();
            } else {
                C11839m.m70688i("QueryH5WindowMessageTask", "getUserPackage failed");
                this.f13242a.f13263c = 1;
                this.f13243b.countDown();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.e2$c */
    public static class c {

        /* renamed from: a */
        public int f13245a;

        /* renamed from: b */
        public String f13246b;

        /* renamed from: c */
        public String f13247c;

        /* renamed from: d */
        public String f13248d;

        /* renamed from: e */
        public String f13249e;

        /* renamed from: f */
        public String f13250f;

        /* renamed from: g */
        public String f13251g;

        /* renamed from: h */
        public String f13252h;

        /* renamed from: i */
        public String f13253i;

        /* renamed from: j */
        public String f13254j;

        /* renamed from: k */
        public int f13255k;

        /* renamed from: l */
        public String f13256l;

        /* renamed from: m */
        public int f13257m;

        /* renamed from: n */
        public boolean f13258n = false;

        /* renamed from: o */
        public boolean f13259o = false;

        /* renamed from: p */
        public boolean f13260p = true;
    }

    /* renamed from: com.huawei.android.hicloud.task.simple.e2$d */
    public static class d {

        /* renamed from: a */
        public String f13261a = "";

        /* renamed from: c */
        public int f13263c = -1;

        /* renamed from: b */
        public UserPackage f13262b = null;
    }

    public C3028e2(Handler handler) {
        this.f13237a = handler;
        m18322t();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b, SQLException {
        List<H5WindowMsgObj> h5WindowMsgList = MessageCenterManager.getInstance().getH5WindowMsgList();
        if (h5WindowMsgList != null) {
            HiCLoudNotifyBlackListConfig notifyBackListConfigLocal = NotifyBlackListManager.getInstance().getNotifyBackListConfigLocal();
            c cVarM18309f = null;
            for (H5WindowMsgObj h5WindowMsgObj : h5WindowMsgList) {
                if (h5WindowMsgObj == null) {
                    C11839m.m70689w("QueryH5WindowMessageTask", "no h5 window exist");
                } else {
                    int h5DialogAction = h5WindowMsgObj.getH5DialogAction();
                    C11839m.m70688i("QueryH5WindowMessageTask", "task start, action is: " + h5DialogAction);
                    if (NotifyBlackListManager.getInstance().isInBlackDialogList(notifyBackListConfigLocal, h5DialogAction, UserSpaceUtil.getUserTagsUseCache("QueryH5WindowMessageTask"))) {
                        C11839m.m70689w("QueryH5WindowMessageTask", "action in black list");
                    } else {
                        if (h5DialogAction == 0) {
                            cVarM18309f = m18313k(h5WindowMsgObj);
                        } else if (h5DialogAction == 2) {
                            cVarM18309f = m18314l(h5WindowMsgObj);
                        } else if (h5DialogAction == 3 || h5DialogAction == 9) {
                            cVarM18309f = m18309f(h5WindowMsgObj);
                        } else if (h5DialogAction == 4) {
                            cVarM18309f = m18308e(h5WindowMsgObj);
                        } else if (h5DialogAction == 1) {
                            cVarM18309f = m18312j(h5WindowMsgObj);
                        } else if (h5DialogAction == 5 || h5DialogAction == 6 || h5DialogAction == 11) {
                            cVarM18309f = m18311h(h5WindowMsgObj);
                        } else if (h5DialogAction == 8) {
                            cVarM18309f = m18310g(h5WindowMsgObj);
                        } else if (h5DialogAction == 12 || h5DialogAction == 13 || h5DialogAction == 14) {
                            cVarM18309f = m18315m(h5WindowMsgObj);
                        }
                        if (cVarM18309f == null) {
                            C11839m.m70689w("QueryH5WindowMessageTask", "h5 need data is null");
                        } else {
                            if (cVarM18309f.f13259o) {
                                m18324v(cVarM18309f, h5WindowMsgObj);
                                m18326z(m18318p(cVarM18309f));
                                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                                linkedHashMap.put(ContentRecord.UNIQUE_ID, h5WindowMsgObj.getUniqueId());
                                linkedHashMap.put("result", "success");
                                C13227f.m79492i1().m79567R("mecloud_query_h5_message_msg_result", linkedHashMap);
                                UBAAnalyze.m29947H("PVC", "mecloud_query_h5_message_msg_result", linkedHashMap);
                                return;
                            }
                            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
                            linkedHashMapM79497A.put(ContentRecord.UNIQUE_ID, h5WindowMsgObj.getUniqueId());
                            linkedHashMapM79497A.put("result", "fail");
                            C13227f.m79492i1().m79567R("mecloud_query_h5_message_msg_result", linkedHashMapM79497A);
                            UBAAnalyze.m29947H("PVC", "mecloud_query_h5_message_msg_result", linkedHashMapM79497A);
                            m18317o(cVarM18309f, h5WindowMsgObj.getUniqueId());
                        }
                    }
                }
            }
        } else {
            C11839m.m70686d("QueryH5WindowMessageTask", "no h5 msgObjList");
            LinkedHashMap<String, String> linkedHashMapM79497A2 = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A2.put("result", "no h5 msgObjList");
            C13227f.m79492i1().m79567R("mecloud_query_h5_message_msg_result", linkedHashMapM79497A2);
            UBAAnalyze.m29947H("PVC", "mecloud_query_h5_message_msg_result", linkedHashMapM79497A2);
        }
        m18325y();
    }

    /* renamed from: e */
    public final c m18308e(H5WindowMsgObj h5WindowMsgObj) {
        String gradeCode;
        c cVarM18319q = m18319q(h5WindowMsgObj);
        d dVarM18321s = m18321s("buildAfterExpired");
        if (dVarM18321s.f13263c != 0) {
            cVarM18319q.f13258n = false;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        UserPackage userPackage = dVarM18321s.f13262b;
        if (userPackage == null) {
            C11839m.m70687e("QueryH5WindowMessageTask", "userPackage is null");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        long serverTime = userPackage.getServerTime();
        if (C2783d.m16171q(effectivePackages, 1) != null) {
            C11839m.m70688i("QueryH5WindowMessageTask", "AlreadyExpired petalSpace is not null");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        CloudSpace cloudSpaceM16171q = C2783d.m16171q(effectivePackages, 0);
        if (serverTime == 0 || cloudSpaceM16171q == null || !cloudSpaceM16171q.getGradeCode().equals("N")) {
            C11839m.m70688i("QueryH5WindowMessageTask", "AlreadyExpired serverTime or normalSpace error");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        CloudSpace expiredPackage = userPackage.getExpiredPackage();
        if (expiredPackage == null) {
            C11839m.m70688i("QueryH5WindowMessageTask", "AlreadyExpired expiredSpace is null");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        if (expiredPackage.getGradeCode() != null) {
            gradeCode = expiredPackage.getGradeCode();
        } else {
            C11839m.m70687e("QueryH5WindowMessageTask", "expiredSpace have value but gradeCode is null");
            gradeCode = "";
        }
        String strValueOf = String.valueOf(Math.abs(expiredPackage.getEndTime() - serverTime));
        cVarM18319q.f13250f = gradeCode;
        cVarM18319q.f13251g = strValueOf;
        cVarM18319q.f13258n = false;
        cVarM18319q.f13259o = true;
        return cVarM18319q;
    }

    /* renamed from: f */
    public final c m18309f(H5WindowMsgObj h5WindowMsgObj) {
        String gradeCode;
        c cVarM18319q = m18319q(h5WindowMsgObj);
        d dVarM18321s = m18321s("buildBeforeExpire");
        if (dVarM18321s.f13263c != 0) {
            cVarM18319q.f13258n = false;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        UserPackage userPackage = dVarM18321s.f13262b;
        if (userPackage == null) {
            C11839m.m70687e("QueryH5WindowMessageTask", "userPackage is null");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
        if (C2783d.m16171q(effectivePackages, 1) != null) {
            C11839m.m70688i("QueryH5WindowMessageTask", "BeforeExpired petalSpace is not null");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        long serverTime = userPackage.getServerTime();
        CloudSpace cloudSpaceM16171q = C2783d.m16171q(effectivePackages, 0);
        if (serverTime == 0 || cloudSpaceM16171q == null || cloudSpaceM16171q.getGradeCode().equals("N")) {
            C11839m.m70688i("QueryH5WindowMessageTask", "BeforeExpired serverTime or normalSpace error");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        if (userPackage.getIsAutoPay() == 1) {
            C11839m.m70688i("QueryH5WindowMessageTask", "BeforeExpired is auto pay, no need to show");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        if (cloudSpaceM16171q.getGradeCode() != null) {
            gradeCode = cloudSpaceM16171q.getGradeCode();
        } else {
            C11839m.m70687e("QueryH5WindowMessageTask", "normalSpace have value but gradeCode is null");
            gradeCode = "";
        }
        String strValueOf = String.valueOf(Math.abs(cloudSpaceM16171q.getEndTime() - serverTime));
        cVarM18319q.f13250f = gradeCode;
        cVarM18319q.f13251g = strValueOf;
        cVarM18319q.f13258n = false;
        cVarM18319q.f13259o = true;
        return cVarM18319q;
    }

    /* renamed from: g */
    public final c m18310g(H5WindowMsgObj h5WindowMsgObj) {
        if (!CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(UserSpaceUtil.getGradeCodeUseCache("QueryH5WindowMessageTask"))) {
            return null;
        }
        c cVarM18319q = m18319q(h5WindowMsgObj);
        cVarM18319q.f13258n = false;
        cVarM18319q.f13259o = true;
        return cVarM18319q;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.MSG_CENTER_FIX;
    }

    /* renamed from: h */
    public final c m18311h(H5WindowMsgObj h5WindowMsgObj) {
        C11839m.m70688i("QueryH5WindowMessageTask", "buildCampaignCenter");
        if (h5WindowMsgObj.getMsgGotoUri() != null) {
            Uri uri = Uri.parse(h5WindowMsgObj.getMsgGotoUri());
            C11839m.m70686d("QueryH5WindowMessageTask", "buildCampaignCenter getH5DialogUrl" + h5WindowMsgObj.getMsgGotoUri());
            String strM63704b = C10344c.m63704b(uri, "taskActivityId");
            if (TextUtils.isEmpty(strM63704b)) {
                strM63704b = C13823d.m82904y().m82922f(C0213f.m1377a());
            }
            if ("CampaignActivity".equals(C10344c.m63704b(uri, "path")) && C13821b.m82867w().m82873F(strM63704b)) {
                C11839m.m70687e("QueryH5WindowMessageTask", "buildCampaignCenter activity is finished");
                new MessageH5DbOperator().setAlreadyRead(h5WindowMsgObj.getUniqueId());
                MessageCenterManager.getInstance().cancelCampaignMsgNotification();
                return null;
            }
        }
        c cVarM18319q = m18319q(h5WindowMsgObj);
        cVarM18319q.f13258n = false;
        cVarM18319q.f13259o = true;
        return cVarM18319q;
    }

    /* renamed from: j */
    public final c m18312j(H5WindowMsgObj h5WindowMsgObj) {
        c cVarM18319q = m18319q(h5WindowMsgObj);
        try {
            cVarM18319q.f13254j = h5WindowMsgObj.getMsgGotoUri();
            NotifyAgdParameters notifyAgdParameters = (NotifyAgdParameters) new Gson().fromJson(h5WindowMsgObj.getAgdParameters(), NotifyAgdParameters.class);
            if (notifyAgdParameters != null) {
                cVarM18319q.f13255k = notifyAgdParameters.getEnabled();
                cVarM18319q.f13256l = notifyAgdParameters.getSlotId();
                cVarM18319q.f13257m = notifyAgdParameters.getThreshold();
            }
        } catch (Exception e10) {
            C11839m.m70687e("QueryH5WindowMessageTask", "buildDownloadApp, json trans error, e: " + e10.toString());
        }
        cVarM18319q.f13258n = false;
        cVarM18319q.f13259o = true;
        return cVarM18319q;
    }

    /* renamed from: k */
    public final c m18313k(H5WindowMsgObj h5WindowMsgObj) {
        c cVarM18319q = m18319q(h5WindowMsgObj);
        d dVarM18320r = m18320r(this.f13238b);
        if (dVarM18320r.f13263c != 0) {
            cVarM18319q.f13258n = false;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        String str = dVarM18320r.f13261a;
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("QueryH5WindowMessageTask", "package id is null");
            cVarM18319q.f13258n = true;
            cVarM18319q.f13259o = false;
            return cVarM18319q;
        }
        cVarM18319q.f13249e = str;
        cVarM18319q.f13258n = false;
        cVarM18319q.f13259o = true;
        return cVarM18319q;
    }

    /* renamed from: l */
    public final c m18314l(H5WindowMsgObj h5WindowMsgObj) {
        c cVarM18319q = m18319q(h5WindowMsgObj);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("unique_id", h5WindowMsgObj.getUniqueId());
        linkedHashMapM79497A.put("resource_id", h5WindowMsgObj.getResourceInfo());
        linkedHashMapM79497A.put("actionType", String.valueOf(h5WindowMsgObj.getH5DialogAction()));
        linkedHashMapM79497A.put("notify_way_name", "appH5Window");
        boolean zM6119k = C1009d.m6109e().m6119k(h5WindowMsgObj.getParam(), h5WindowMsgObj.getRealTimeParam(), h5WindowMsgObj.getTrigger(), h5WindowMsgObj.getSupportTrigger(), linkedHashMapM79497A);
        C11839m.m70688i("QueryH5WindowMessageTask", "h5 dialog param satisfy = " + zM6119k);
        if (zM6119k) {
            cVarM18319q.f13259o = true;
            cVarM18319q.f13258n = false;
        } else {
            cVarM18319q.f13259o = false;
            cVarM18319q.f13258n = true;
        }
        if (!TextUtils.isEmpty(h5WindowMsgObj.getTrigger()) && 1 == h5WindowMsgObj.getSupportTrigger()) {
            cVarM18319q.f13260p = false;
        }
        return cVarM18319q;
    }

    /* renamed from: m */
    public final c m18315m(H5WindowMsgObj h5WindowMsgObj) {
        if (CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(UserSpaceUtil.getGradeCodeUseCache("QueryH5WindowMessageTask"))) {
            return m18314l(h5WindowMsgObj);
        }
        c cVarM18319q = m18319q(h5WindowMsgObj);
        C11839m.m70689w("QueryH5WindowMessageTask", "gradeCode != NN");
        cVarM18319q.f13258n = true;
        cVarM18319q.f13259o = false;
        return cVarM18319q;
    }

    /* renamed from: n */
    public final String m18316n(Object obj) {
        try {
            return ((FilterDataForRecommend) obj).getFilterAvailabalGradePackageList().get(0).getPackageIdList().get(0);
        } catch (Exception e10) {
            C11839m.m70688i("QueryH5WindowMessageTask", "dealGetPackagesBySpaceRuleSuccess object is invalid. e: " + e10.toString());
            return "";
        }
    }

    /* renamed from: o */
    public final void m18317o(c cVar, String str) {
        if (cVar == null) {
            C11839m.m70687e("QueryH5WindowMessageTask", "sendMsg data is null");
        } else {
            if (cVar.f13259o) {
                return;
            }
            if (cVar.f13258n) {
                C11839m.m70687e("QueryH5WindowMessageTask", "sendMsg needSetRead is true");
                MessageCenterManager.getInstance().setH5AsRead(str);
            }
            C11839m.m70687e("QueryH5WindowMessageTask", "sendMsg needShow is false");
        }
    }

    /* renamed from: p */
    public final Bundle m18318p(c cVar) {
        C11839m.m70687e("QueryH5WindowMessageTask", "sendMsg needShow is true");
        Bundle bundle = new Bundle();
        bundle.putInt("queryh5oknum", cVar.f13245a);
        bundle.putString("packageId", cVar.f13249e);
        Uri.Builder builderBuildUpon = Uri.parse(cVar.f13246b).buildUpon();
        builderBuildUpon.appendQueryParameter(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, C0234s.m1632j());
        cVar.f13246b = builderBuildUpon.toString();
        C11839m.m70686d("QueryH5WindowMessageTask", "H5 link: " + cVar.f13246b);
        bundle.putString("h5Uri", cVar.f13246b);
        bundle.putString("activeUri", cVar.f13254j);
        bundle.putString(NotifyConstants.Keys.NOTIFY_TYPE, cVar.f13247c);
        bundle.putString(NotifyConstants.Keys.NOTIFY_URI, cVar.f13248d);
        bundle.putString("gradeCode", cVar.f13250f);
        bundle.putString("expireTime", cVar.f13251g);
        bundle.putString(ContentRecord.UNIQUE_ID, cVar.f13252h);
        bundle.putString("resourceInfo", cVar.f13253i);
        bundle.putInt("agd_resource_enable", cVar.f13255k);
        bundle.putString("agd_resource_slot_id", cVar.f13256l);
        bundle.putInt("pps_threshold", cVar.f13257m);
        return bundle;
    }

    /* renamed from: q */
    public final c m18319q(H5WindowMsgObj h5WindowMsgObj) {
        c cVar = new c();
        cVar.f13245a = h5WindowMsgObj.getH5DialogAction();
        cVar.f13247c = h5WindowMsgObj.getMsgGotoType();
        cVar.f13248d = h5WindowMsgObj.getMsgGotoUri();
        cVar.f13246b = h5WindowMsgObj.getH5DialogUrl();
        cVar.f13252h = h5WindowMsgObj.getUniqueId();
        cVar.f13253i = h5WindowMsgObj.getResourceInfo();
        return cVar;
    }

    /* renamed from: r */
    public final d m18320r(C11060c c11060c) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d dVar = new d();
        new C10220d0(new a(Looper.getMainLooper(), dVar, countDownLatch), c11060c, 3, -1L, 2, null).m63381g();
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d("QueryH5WindowMessageTask", "getPackageId wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("QueryH5WindowMessageTask", "getPackageId syncLock wait catch InterruptedException.");
        }
        C11839m.m70688i("QueryH5WindowMessageTask", "getPackageId end, result = " + dVar.f13263c);
        C11839m.m70688i("QueryH5WindowMessageTask", "getPackageId end, packageId = " + dVar.f13261a);
        return dVar;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void release() {
        C12515a.m75110o().m75165a1(this);
    }

    /* renamed from: s */
    public final d m18321s(String str) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d dVar = new d();
        new C10250n0(new b(Looper.getMainLooper(), dVar, countDownLatch), this.f13238b, true, str).m63381g();
        try {
            if (!countDownLatch.await(5L, TimeUnit.SECONDS)) {
                C11839m.m70686d("QueryH5WindowMessageTask", "getUserPackage wait not finish");
            }
        } catch (InterruptedException unused) {
            C11839m.m70689w("QueryH5WindowMessageTask", "getUserPackage syncLock wait catch InterruptedException.");
        }
        C11839m.m70688i("QueryH5WindowMessageTask", "getUserPackage end, result = " + dVar.f13263c);
        return dVar;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }

    /* renamed from: t */
    public final void m18322t() {
        this.f13238b = C11058a.m66626a(C11058a.m66627b("07046"), "H5_WINDOW_QUERY", C13452e.m80781L().m80971t0());
    }

    /* renamed from: u */
    public final UserPackage m18323u(Message message) {
        if (message == null) {
            C11839m.m70687e("QueryH5WindowMessageTask", "processGetActivityEntrySuccess entry success, but msg is null");
            return null;
        }
        Object obj = message.obj;
        if (!(obj instanceof UserPackage)) {
            C11839m.m70687e("QueryH5WindowMessageTask", "process get activity entry success, but msg obj is not GetActivityEntryResp");
            return null;
        }
        UserPackage userPackage = (UserPackage) obj;
        if (userPackage.getResultCode() == 0) {
            return userPackage;
        }
        return null;
    }

    /* renamed from: v */
    public final void m18324v(c cVar, H5WindowMsgObj h5WindowMsgObj) {
        if (cVar.f13260p) {
            C11839m.m70688i("QueryH5WindowMessageTask", "refresh param before show h5");
            C14157f.m84942g().m84949i(h5WindowMsgObj.getParam(), h5WindowMsgObj.getRealTimeParam(), "RefreshParam");
        }
    }

    /* renamed from: y */
    public final void m18325y() {
        if (this.f13237a != null) {
            C11839m.m70688i("QueryH5WindowMessageTask", "senFailMsg");
            Handler handler = this.f13237a;
            handler.sendMessage(handler.obtainMessage(0));
        }
    }

    /* renamed from: z */
    public final void m18326z(Bundle bundle) {
        if (this.f13237a != null) {
            C11839m.m70688i("QueryH5WindowMessageTask", "sendSuccessMsg");
            Handler handler = this.f13237a;
            handler.sendMessage(handler.obtainMessage(1, bundle));
        }
    }
}
