package com.huawei.android.p069cg.logic.app;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.android.p069cg.logic.app.HmsSnsApp;
import com.huawei.android.p069cg.request.threadpool.AbstractC2331l;
import com.huawei.android.p069cg.request.threadpool.C2333n;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.api.entity.sns.Group;
import com.huawei.hms.support.api.entity.sns.GroupMem;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupMemListResp;
import com.huawei.hms.support.api.entity.sns.internal.GroupListReq;
import com.huawei.hms.support.api.entity.sns.internal.GroupMemListReq;
import com.huawei.hms.support.api.entity.sns.internal.UiIntentReq;
import com.huawei.hms.support.api.entity.sns.json.SnsOutIntent;
import com.huawei.hms.support.api.sns.json.Sns;
import com.huawei.hms.support.api.sns.json.SnsClient;
import com.huawei.hms.support.api.sns.json.SnsOptions;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0213f;
import p031b7.C1120a;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;

/* loaded from: classes2.dex */
public final class HmsSnsApp {

    public static class GroupCreateUIRunnable extends AbstractC2331l {

        /* renamed from: a */
        public Context f10976a;

        public GroupCreateUIRunnable(Context context) {
            super(null);
            this.f10976a = context;
        }

        /* renamed from: d */
        public static /* synthetic */ void m14433d(Exception exc) {
            C1120a.m6676e("HmsSnsApp", "GroupCreateUIRunnable getGroupCreatorIntent error: " + exc.toString());
        }

        /* renamed from: c */
        public final /* synthetic */ void m14434c(SnsOutIntent snsOutIntent) {
            Intent intent = snsOutIntent.getIntent();
            if (intent != null) {
                C1120a.m6677i("HmsSnsApp", "action:" + intent.getAction());
                try {
                    intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    this.f10976a.startActivity(intent);
                } catch (ActivityNotFoundException e10) {
                    C1120a.m6676e("HmsSnsApp", "GroupCreateUIRunnable getGroupCreatorIntent:" + e10.toString());
                }
            }
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
        public Object call() throws Exception {
            HmsSnsApp.m14420j().getGroupCreatorIntent(new C2281d()).addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.cg.logic.app.e
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f10984a.m14434c((SnsOutIntent) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.cg.logic.app.f
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    HmsSnsApp.GroupCreateUIRunnable.m14433d(exc);
                }
            });
            return null;
        }
    }

    /* renamed from: com.huawei.android.cg.logic.app.HmsSnsApp$b */
    public static class C2279b extends AbstractC2331l {

        /* renamed from: a */
        public Context f10977a;

        /* renamed from: b */
        public long f10978b;

        public C2279b(Context context, long j10) {
            super(null);
            this.f10977a = context;
            this.f10978b = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m14437c(SnsOutIntent snsOutIntent) {
            Intent intent = snsOutIntent.getIntent();
            if (intent != null) {
                C1120a.m6677i("HmsSnsApp", "action:" + intent.getAction() + " + mGroupId=" + this.f10978b);
                try {
                    intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
                    this.f10977a.startActivity(intent);
                } catch (ActivityNotFoundException e10) {
                    C1120a.m6676e("HmsSnsApp", "GroupMemberUIRunnable ActivityNotFoundException:" + e10.toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static /* synthetic */ void m14438d(Exception exc) {
            C1120a.m6676e("HmsSnsApp", "GroupMemberUIRunnable getUiIntent error: " + exc.toString());
        }

        @Override // com.huawei.android.p069cg.request.threadpool.AbstractCallableC2320a, java.util.concurrent.Callable
        public Object call() throws Exception {
            C1120a.m6677i("HmsSnsApp", "showGroupMemberUI groupId:" + this.f10978b);
            SnsClient snsClientM14420j = HmsSnsApp.m14420j();
            UiIntentReq uiIntentReq = new UiIntentReq();
            uiIntentReq.setType(2);
            uiIntentReq.setParam(this.f10978b);
            snsClientM14420j.getUiIntent(uiIntentReq, new C2281d()).addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.cg.logic.app.g
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    this.f10985a.m14437c((SnsOutIntent) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.cg.logic.app.h
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    HmsSnsApp.C2279b.m14438d(exc);
                }
            });
            return null;
        }
    }

    /* renamed from: com.huawei.android.cg.logic.app.HmsSnsApp$c */
    public static class C2280c {

        /* renamed from: a */
        public static HmsSnsApp f10979a = new HmsSnsApp();
    }

    /* renamed from: com.huawei.android.cg.logic.app.HmsSnsApp$d */
    public static class C2281d implements SnsClient.Callback {
        public C2281d() {
        }

        @Override // com.huawei.hms.support.api.sns.json.SnsClient.Callback
        public void notify(String str) {
            C1120a.m6677i("HmsSnsApp", "SnsCallBack notify");
        }
    }

    /* renamed from: h */
    public static HmsSnsApp m14419h() {
        return C2280c.f10979a;
    }

    /* renamed from: j */
    public static SnsClient m14420j() {
        return Sns.getSnsClient(C0213f.m1377a(), (SnsOptions) null);
    }

    /* renamed from: k */
    public static /* synthetic */ void m14421k(CountDownLatch countDownLatch, GetGroupMemListResp getGroupMemListResp) {
        countDownLatch.countDown();
        C1120a.m6677i("HmsSnsApp", "getGroupMemRespList success");
    }

    /* renamed from: l */
    public static /* synthetic */ void m14422l(CountDownLatch countDownLatch, Exception exc) {
        countDownLatch.countDown();
        C1120a.m6677i("HmsSnsApp", "getGroupMemRespList fail: " + exc.toString());
    }

    /* renamed from: m */
    public static /* synthetic */ void m14423m(CountDownLatch countDownLatch, GetGroupListResp getGroupListResp) {
        countDownLatch.countDown();
        C1120a.m6677i("HmsSnsApp", "getGroupRespList success");
    }

    /* renamed from: n */
    public static /* synthetic */ void m14424n(CountDownLatch countDownLatch, Exception exc) {
        countDownLatch.countDown();
        C1120a.m6676e("HmsSnsApp", "getGroupRespList error: " + exc.toString());
    }

    /* renamed from: e */
    public String[] m14425e() throws InterruptedException {
        List<Group> listM14427g = m14427g();
        if (listM14427g == null) {
            C1120a.m6676e("HmsSnsApp", "groupInfoList is null");
            return new String[0];
        }
        int size = listM14427g.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < listM14427g.size(); i10++) {
            Group group = listM14427g.get(i10);
            if (group != null) {
                C1120a.m6675d("HmsSnsApp", "getGroupList groupId:" + group.getGroupId() + ",groupName:" + group.getName());
                strArr[i10] = String.valueOf(group.getGroupId());
            }
        }
        C1120a.m6677i("HmsSnsApp", "getGroupList result:" + size);
        return strArr;
    }

    /* renamed from: f */
    public List<GroupMem> m14426f(long j10) throws InterruptedException {
        C1120a.m6677i("HmsSnsApp", "getGroupMemRespList");
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            SnsClient snsClientM14420j = m14420j();
            GroupMemListReq groupMemListReq = new GroupMemListReq();
            groupMemListReq.setGroupId(j10);
            Task<GetGroupMemListResp> groupMemList = snsClientM14420j.getGroupMemList(groupMemListReq, new C2281d());
            groupMemList.addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.cg.logic.app.c
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    HmsSnsApp.m14421k(countDownLatch, (GetGroupMemListResp) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.cg.logic.app.d
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    HmsSnsApp.m14422l(countDownLatch, exc);
                }
            });
            C1120a.m6677i("HmsSnsApp", "getGroupMemRespList await: " + countDownLatch.await(35L, TimeUnit.SECONDS));
            return groupMemList.getResult().getGroupMemList();
        } catch (Exception e10) {
            C1120a.m6676e("HmsSnsApp", "getGroupMemRespList exception: " + e10.toString());
            return null;
        }
    }

    /* renamed from: g */
    public List<Group> m14427g() throws InterruptedException {
        C1120a.m6677i("HmsSnsApp", "getGroupRespList");
        try {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            SnsClient snsClientM14420j = m14420j();
            GroupListReq groupListReq = new GroupListReq();
            groupListReq.setGroupType(0);
            Task<GetGroupListResp> groupList = snsClientM14420j.getGroupList(groupListReq, new C2281d());
            groupList.addOnSuccessListener(new InterfaceC8939g() { // from class: com.huawei.android.cg.logic.app.a
                @Override // p208cq.InterfaceC8939g
                public final void onSuccess(Object obj) {
                    HmsSnsApp.m14423m(countDownLatch, (GetGroupListResp) obj);
                }
            }).addOnFailureListener(new InterfaceC8938f() { // from class: com.huawei.android.cg.logic.app.b
                @Override // p208cq.InterfaceC8938f
                public final void onFailure(Exception exc) {
                    HmsSnsApp.m14424n(countDownLatch, exc);
                }
            });
            C1120a.m6677i("HmsSnsApp", "getGroupRespList await: " + countDownLatch.await(35L, TimeUnit.SECONDS));
            return groupList.getResult().getGroups();
        } catch (Exception e10) {
            C1120a.m6676e("HmsSnsApp", "getGroupRespList from SNSSDK error!error message:" + e10.toString());
            return null;
        }
    }

    /* renamed from: i */
    public boolean m14428i(Context context) throws PackageManager.NameNotFoundException {
        boolean z10 = false;
        if (context == null) {
            C1120a.m6678w("HmsSnsApp", "context is null");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 16384);
            if (packageInfo != null) {
                if (packageInfo.versionCode >= 20100200) {
                    z10 = true;
                }
            }
        } catch (PackageManager.NameNotFoundException | RuntimeException e10) {
            C1120a.m6676e("HmsSnsApp", "getIsSupportSns() meet exception." + e10.toString());
        }
        C1120a.m6675d("HmsSnsApp", "getIsSupportSns result:" + z10);
        return z10;
    }

    /* renamed from: o */
    public void m14429o(Context context) {
        C1120a.m6677i("HmsSnsApp", "showGroupCreateUI");
        C2333n.m14663f().m14674m(new GroupCreateUIRunnable(context.getApplicationContext()), true);
    }

    /* renamed from: p */
    public void m14430p(Context context, long j10) {
        C1120a.m6677i("HmsSnsApp", "showGroupMemberUI");
        C2333n.m14663f().m14674m(new C2279b(context.getApplicationContext(), j10), true);
    }

    public HmsSnsApp() {
    }
}
