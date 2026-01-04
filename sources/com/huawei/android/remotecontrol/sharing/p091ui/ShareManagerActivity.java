package com.huawei.android.remotecontrol.sharing.p091ui;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.remotecontrol.http.PhoneFinderServer;
import com.huawei.android.remotecontrol.p093ui.BaseActivity;
import com.huawei.android.remotecontrol.p093ui.widget.ListItemPatterm;
import com.huawei.android.remotecontrol.sdk.R$color;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import com.huawei.android.remotecontrol.sharing.bean.FriendInfo;
import com.huawei.android.remotecontrol.sharing.bean.SharingMemberItem;
import com.huawei.android.remotecontrol.sharing.p091ui.ShareManagerActivity;
import com.huawei.android.remotecontrol.sharing.p091ui.widgte.ShareTimePickerDialog;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import eg.AbstractC9478g;
import fk.C9721b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0226l0;
import p514o9.C11841o;
import p514o9.C11842p;
import p520of.C11853c;
import p521og.C11877j;
import p521og.C11881n;
import p575qe.C12347f;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12369f;
import p616rk.C12515a;
import p664u0.C13108a;
import p681uj.C13195l;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import sk.C12809f;
import wf.C13603h;
import wf.C13604i;
import wf.InterfaceC13596a;

/* loaded from: classes4.dex */
public class ShareManagerActivity extends BaseActivity implements InterfaceC13596a {

    /* renamed from: A */
    public C4405c f20165A;

    /* renamed from: B */
    public final ReentrantLock f20166B = new ReentrantLock(true);

    /* renamed from: C */
    public boolean f20167C = false;

    /* renamed from: D */
    public int f20168D = -1;

    /* renamed from: E */
    public AlertDialog f20169E;

    /* renamed from: F */
    public ShareTimePickerDialog f20170F;

    /* renamed from: G */
    public AlertDialog f20171G;

    /* renamed from: r */
    public HiCloudExceptionView f20172r;

    /* renamed from: s */
    public NotchTopFitRelativeLayout f20173s;

    /* renamed from: t */
    public NotchFitRelativeLayout f20174t;

    /* renamed from: u */
    public NotchFitRelativeLayout f20175u;

    /* renamed from: v */
    public NotchFitRelativeLayout f20176v;

    /* renamed from: w */
    public SlideRecyclerView f20177w;

    /* renamed from: x */
    public List<SharingMemberItem> f20178x;

    /* renamed from: y */
    public C13603h f20179y;

    /* renamed from: z */
    public HandlerC4408f f20180z;

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$a */
    public class C4403a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ boolean f20181a;

        /* renamed from: b */
        public final /* synthetic */ ListItemPatterm f20182b;

        public C4403a(boolean z10, ListItemPatterm listItemPatterm) {
            this.f20181a = z10;
            this.f20182b = listItemPatterm;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            final boolean zM70971f = C11853c.m70968g().m70971f(C0213f.m1377a());
            final boolean z10 = this.f20181a;
            final ListItemPatterm listItemPatterm = this.f20182b;
            C0226l0.m1584d(new Runnable() { // from class: xf.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61990a.m26599d(zM70971f, z10, listItemPatterm);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m26599d(boolean z10, boolean z11, ListItemPatterm listItemPatterm) {
            if (z10) {
                C13981a.m83989i("ShareManagerActivity", "clearAccountInfo");
                AbstractC12139d.m72767f(C0213f.m1377a(), true);
                ShareManagerActivity.this.m26595w2(z11, listItemPatterm);
            } else {
                C13981a.m83988e("ShareManagerActivity", "checkClientTaKey fail");
                listItemPatterm.setSwitchLoading(false);
                listItemPatterm.setSwitchStatus(!z11);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$b */
    public static class C4404b extends AbstractC12367d {

        /* renamed from: a */
        public final SharingMemberItem f20184a;

        /* renamed from: b */
        public final Context f20185b;

        public C4404b(Context context, SharingMemberItem sharingMemberItem) {
            this.f20184a = sharingMemberItem;
            this.f20185b = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            if (this.f20184a == null) {
                C13981a.m83988e("ShareManagerActivity", "delete friend item is empty");
                return;
            }
            FriendInfo friendInfo = new FriendInfo();
            friendInfo.setFriendUserId(this.f20184a.getUserId());
            try {
                C13981a.m83989i("ShareManagerActivity", "delete friend task result:" + new PhoneFinderServer(this.f20185b).m26195f(friendInfo));
            } catch (C9721b e10) {
                C13981a.m83988e("ShareManagerActivity", "ShareGrantDeleteTask error: " + e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$c */
    public class C4405c extends AbstractC12369f {

        /* renamed from: a */
        public boolean f20186a;

        public C4405c(long j10, long j11) {
            super(j10, j11);
            this.f20186a = false;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f20186a || ShareManagerActivity.this.isFinishing()) {
                C13981a.m83989i("ShareManagerActivity.FreshShareTimeTask", "task stop");
                return;
            }
            if (ShareManagerActivity.this.f20179y == null || ShareManagerActivity.this.f20177w.getAdapter() == null) {
                C13981a.m83988e("ShareManagerActivity.FreshShareTimeTask", "mRecyclerAdapter null");
                return;
            }
            C13981a.m83989i("ShareManagerActivity.FreshShareTimeTask", "task start");
            Iterator<WeakReference<TextView>> it = ShareManagerActivity.this.f20179y.m81763N().iterator();
            while (it.hasNext()) {
                try {
                    final TextView textView = it.next().get();
                    if (textView == null) {
                        it.remove();
                    } else if (textView.isShown()) {
                        int iIntValue = ((Integer) textView.getTag()).intValue();
                        SharingMemberItem sharingMemberItemM81761L = ShareManagerActivity.this.f20179y.m81761L(iIntValue);
                        if (sharingMemberItemM81761L == null) {
                            C13981a.m83987d("ShareManagerActivity.FreshShareTimeTask", "sharingMemberItem get null");
                        } else if (sharingMemberItemM81761L.getRemainingTime() != Long.MAX_VALUE && sharingMemberItemM81761L.getRemainingTime() != -1) {
                            long jM81783a = C13604i.m81782e().m81783a(sharingMemberItemM81761L, System.currentTimeMillis());
                            if (jM81783a > 0) {
                                sharingMemberItemM81761L.setRemainingTime(jM81783a);
                                final String strM71354d = C11881n.m71354d(ShareManagerActivity.this, jM81783a, R$string.share_remain_time);
                                C13981a.m83987d("ShareManagerActivity.FreshShareTimeTask", strM71354d);
                                textView.post(new Runnable() { // from class: xf.q
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        textView.setText(strM71354d);
                                    }
                                });
                            } else {
                                sharingMemberItemM81761L.setSharingOpen(false);
                                sharingMemberItemM81761L.setRemainingTime(-1L);
                                Message messageObtain = Message.obtain();
                                messageObtain.what = 0;
                                messageObtain.arg1 = iIntValue;
                                ShareManagerActivity.this.f20180z.sendMessage(messageObtain);
                            }
                        }
                    }
                } catch (Exception e10) {
                    C13981a.m83988e("ShareManagerActivity.FreshShareTimeTask", "task error: " + e10.getMessage());
                }
            }
        }

        /* renamed from: e */
        public void m26602e(boolean z10) {
            this.f20186a = z10;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$d */
    public class C4406d extends AbstractC12367d {

        /* renamed from: a */
        public final SharingMemberItem f20188a;

        /* renamed from: b */
        public final ListItemPatterm f20189b;

        /* renamed from: c */
        public final int f20190c;

        /* renamed from: d */
        public final int f20191d;

        /* renamed from: e */
        public final int f20192e;

        public C4406d(ShareManagerActivity shareManagerActivity, SharingMemberItem sharingMemberItem, ListItemPatterm listItemPatterm, int i10) {
            this(sharingMemberItem, listItemPatterm, i10, Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        /* renamed from: d */
        public /* synthetic */ void m26604d(int i10) {
            this.f20189b.setSwitchLoading(false);
            boolean z10 = i10 == 0;
            this.f20188a.setSharingOpen(z10);
            if (z10) {
                int i11 = this.f20191d;
                if (i11 != Integer.MAX_VALUE) {
                    ShareManagerActivity shareManagerActivity = ShareManagerActivity.this;
                    C11841o.m70706b(shareManagerActivity, C11881n.m71353c(shareManagerActivity, this.f20192e, i11, R$string.set_custom_success), 0);
                }
                SharingMemberItem sharingMemberItem = this.f20188a;
                sharingMemberItem.setRemainingTime(sharingMemberItem.getShareInterval());
            } else {
                this.f20188a.setShareInterval(0L);
                this.f20188a.setRemainingTime(-1L);
                int i12 = 3021 == i10 ? R$string.share_locate_friend_not_exist : 3027 == i10 ? R$string.add_friend_sender_limited : 3028 == i10 ? R$string.share_locate_receiver_sender_max : !C0209d.m1333z1(ShareManagerActivity.this) ? R$string.share_location_network_error_toast : R$string.recovery_no_data_server_error;
                ShareManagerActivity shareManagerActivity2 = ShareManagerActivity.this;
                C11841o.m70706b(shareManagerActivity2, shareManagerActivity2.getResources().getString(i12), 0);
            }
            ShareManagerActivity.this.f20179y.m5214k(this.f20190c);
            String str = this.f20188a.getMemberType() == 1 ? "mecloud_findmyphone_click_location_share_family" : "mecloud_findmyphone_click_location_share_friend";
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
            String str2 = str;
            C13230i.m79504I().m79590k0(str2, "1", "2", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", str2, "1", "19", "1", "2", linkedHashMap);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f20188a == null) {
                return;
            }
            final int iM81792k = C13604i.m81782e().m81792k(this.f20188a);
            C13981a.m83989i("ShareManagerActivity", "ShareGrantAddTask resultCode:" + iM81792k);
            C0226l0.m1585e(new Runnable() { // from class: xf.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61996a.m26604d(iM81792k);
                }
            }, 500L);
        }

        public C4406d(SharingMemberItem sharingMemberItem, ListItemPatterm listItemPatterm, int i10, int i11, int i12) {
            this.f20188a = sharingMemberItem;
            this.f20189b = listItemPatterm;
            this.f20190c = i10;
            this.f20191d = i11;
            this.f20192e = i12;
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$e */
    public class C4407e extends AbstractC12367d {

        /* renamed from: a */
        public final ListItemPatterm f20194a;

        /* renamed from: b */
        public final SharingMemberItem f20195b;

        /* renamed from: c */
        public final int f20196c;

        public C4407e(ListItemPatterm listItemPatterm, SharingMemberItem sharingMemberItem, int i10) {
            this.f20194a = listItemPatterm;
            this.f20195b = sharingMemberItem;
            this.f20196c = i10;
        }

        /* renamed from: d */
        public /* synthetic */ void m26606d(boolean z10) {
            this.f20194a.setSwitchLoading(false);
            if (z10) {
                this.f20195b.setSharingOpen(false);
                this.f20195b.setShareInterval(0L);
                this.f20195b.setRemainingTime(-1L);
            } else {
                this.f20195b.setSharingOpen(true);
                ShareManagerActivity shareManagerActivity = ShareManagerActivity.this;
                C11841o.m70706b(shareManagerActivity, shareManagerActivity.getResources().getString(R$string.recovery_no_data_server_error), 0);
            }
            ShareManagerActivity.this.f20179y.m5214k(this.f20196c);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            final boolean zM81786d = C13604i.m81782e().m81786d(this.f20195b);
            C0226l0.m1584d(new Runnable() { // from class: xf.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61998a.m26606d(zM81786d);
                }
            });
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$f */
    public static class HandlerC4408f extends Handler {

        /* renamed from: a */
        public WeakReference<ShareManagerActivity> f20198a;

        public HandlerC4408f(ShareManagerActivity shareManagerActivity) {
            this.f20198a = new WeakReference<>(shareManagerActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ShareManagerActivity shareManagerActivity = this.f20198a.get();
            if (shareManagerActivity == null || shareManagerActivity.isFinishing() || message.what != 0) {
                return;
            }
            shareManagerActivity.f20179y.m5214k(message.arg1);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$g */
    public class C4409g extends AbstractC12367d {
        public C4409g() {
        }

        /* renamed from: d */
        public /* synthetic */ void m26608d(List list) {
            if (!C0209d.m1205R0(list)) {
                C13981a.m83989i("ShareManagerActivity", "sharingMemberItems size:" + list.size());
                ShareManagerActivity.this.f20178x.addAll(list);
            }
            ShareManagerActivity.this.m26597z2();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            final List<SharingMemberItem> listM81788g = C13604i.m81782e().m81788g();
            C0226l0.m1585e(new Runnable() { // from class: xf.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62000a.m26608d(listM81788g);
                }
            }, 500L);
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$h */
    public class C4410h extends AbstractC12367d {

        /* renamed from: a */
        public final ListItemPatterm f20200a;

        /* renamed from: b */
        public final boolean f20201b;

        public C4410h(ListItemPatterm listItemPatterm, boolean z10) {
            this.f20200a = listItemPatterm;
            this.f20201b = z10;
        }

        /* renamed from: e */
        public /* synthetic */ void m26611e(int i10) {
            this.f20200a.setSwitchLoading(false);
            this.f20200a.setSwitchStatus(i10 == 0);
            if (i10 == 0) {
                ShareManagerActivity.this.f20179y.m81781f0(true);
                C12515a.m75110o().m75172d(ShareManagerActivity.this.new C4409g());
                C12515a.m75110o().m75172d(ShareManagerActivity.this.new C4411i(true));
                C11877j.m71295p1(C12347f.m74285n().m74301m(), true);
                Intent intent = new Intent("com.huawei.hidisk.remotecontrol.intent.location.share.state");
                intent.putExtra(MapKeyNames.RESULT_CODE, true);
                C13108a.m78878b(ShareManagerActivity.this).m78881d(intent);
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (this.f20201b) {
                final int iM81790i = C13604i.m81782e().m81790i();
                C13981a.m83989i("ShareManagerActivity", "openLocationShareSwitch:" + iM81790i);
                C0226l0.m1585e(new Runnable() { // from class: xf.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f62002a.m26611e(iM81790i);
                    }
                }, 500L);
                return;
            }
            final int iM81785c = C13604i.m81782e().m81785c();
            C13981a.m83989i("ShareManagerActivity", "closeLocationShareSwitch:" + iM81785c);
            C0226l0.m1585e(new Runnable() { // from class: xf.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62004a.m26612f(iM81785c);
                }
            }, 500L);
        }

        /* renamed from: f */
        public final /* synthetic */ void m26612f(int i10) {
            this.f20200a.setSwitchLoading(false);
            this.f20200a.setSwitchStatus(i10 != 0);
            if (i10 == 0) {
                ShareManagerActivity.this.f20179y.m81781f0(false);
                ShareManagerActivity.this.f20179y.m81772W();
                ShareManagerActivity.this.f20178x.clear();
                ShareManagerActivity.this.m26585g2();
                ShareManagerActivity.this.f20179y.m5213j();
                C11877j.m71295p1(C12347f.m74285n().m74301m(), false);
                Intent intent = new Intent("com.huawei.hidisk.remotecontrol.intent.location.share.state");
                intent.putExtra(MapKeyNames.RESULT_CODE, false);
                C13108a.m78878b(ShareManagerActivity.this).m78881d(intent);
            }
        }
    }

    /* renamed from: com.huawei.android.remotecontrol.sharing.ui.ShareManagerActivity$i */
    public class C4411i extends AbstractC12367d {

        /* renamed from: a */
        public final boolean f20203a;

        public C4411i(boolean z10) {
            this.f20203a = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13604i.m81782e().m81789h();
            ShareManagerActivity.this.m26584E2(this.f20203a);
        }
    }

    /* renamed from: B1 */
    private void m26555B1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.locate_share_tile);
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
    }

    /* renamed from: i2 */
    private void m26573i2() {
        if (this.f20178x == null) {
            this.f20178x = new ArrayList();
        }
        boolean zM71267g0 = C11877j.m71267g0(this);
        this.f20179y = new C13603h(this, null, zM71267g0, this);
        if (zM71267g0) {
            m26579y2();
        } else {
            m26597z2();
        }
        this.f20180z = new HandlerC4408f(this);
    }

    /* renamed from: j2 */
    private void m26574j2() {
        this.f20173s = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f20177w = (SlideRecyclerView) C12809f.m76829b(this, R$id.recycler_view_list);
        this.f20174t = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.recycle_view_content);
        this.f20177w.setLayoutManager(new LinearLayoutManager(this));
        this.f20172r = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        this.f20175u = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.data_query_loading);
        this.f20176v = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.set_query_server_info_nonet);
    }

    /* renamed from: k2 */
    public static /* synthetic */ void m26575k2(ListItemPatterm listItemPatterm, DialogInterface dialogInterface) {
        if (listItemPatterm == null) {
            return;
        }
        listItemPatterm.setSwitchLoading(false);
        listItemPatterm.setCheckedProgrammatically(true);
    }

    /* renamed from: m2 */
    public static /* synthetic */ void m26576m2(ListItemPatterm listItemPatterm, DialogInterface dialogInterface, int i10) {
        if (listItemPatterm != null) {
            listItemPatterm.setSwitchLoading(false);
            listItemPatterm.setCheckedProgrammatically(true);
        }
    }

    /* renamed from: y2 */
    private void m26579y2() {
        C11842p.m70712A2(this.f20175u, true);
        C11842p.m70712A2(this.f20176v, false);
        C11842p.m70712A2(this.f20177w, false);
        C12515a.m75110o().m75172d(new C4409g());
    }

    /* renamed from: A2 */
    public final void m26580A2(final int i10, final ListItemPatterm listItemPatterm, final SharingMemberItem sharingMemberItem) {
        String[] strArr = {getString(R$string.set_share_time_always), getString(R$string.set_share_time_custom)};
        this.f20168D = -1;
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setTitle(R$string.set_share_time).setSingleChoiceItems(strArr, this.f20168D, new DialogInterface.OnClickListener() { // from class: xf.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f61974a.m26588n2(i10, listItemPatterm, sharingMemberItem, dialogInterface, i11);
            }
        }).setPositiveButton(getString(R$string.conform), new DialogInterface.OnClickListener() { // from class: xf.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f61978a.m26589o2(sharingMemberItem, listItemPatterm, i10, dialogInterface, i11);
            }
        }).setNegativeButton(getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: xf.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                listItemPatterm.setCheckedProgrammatically(false);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: xf.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                listItemPatterm.setCheckedProgrammatically(false);
            }
        }).create();
        this.f20169E = alertDialogCreate;
        alertDialogCreate.show();
        this.f20169E.getButton(-1).setEnabled(false);
    }

    /* renamed from: B2 */
    public final void m26581B2(final int i10, final ListItemPatterm listItemPatterm, final SharingMemberItem sharingMemberItem) {
        ShareTimePickerDialog shareTimePickerDialog = new ShareTimePickerDialog(this);
        this.f20170F = shareTimePickerDialog;
        shareTimePickerDialog.setButton(-1, getString(R$string.conform), new DialogInterface.OnClickListener() { // from class: xf.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f61984a.m26590r2(sharingMemberItem, listItemPatterm, i10, dialogInterface, i11);
            }
        });
        this.f20170F.setButton(-2, getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: xf.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f61988a.m26591s2(dialogInterface, i11);
            }
        });
        this.f20170F.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: xf.o
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f61989a.m26592t2(dialogInterface);
            }
        });
        this.f20170F.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: xf.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f61971a.m26593u2(dialogInterface);
            }
        });
        this.f20170F.show();
        this.f20170F.getButton(-1).setEnabled(false);
    }

    /* renamed from: C2 */
    public final void m26582C2() {
        try {
            startActivityForResult(new Intent(this, (Class<?>) AddFriendsActivity.class), 0);
        } catch (Exception e10) {
            C13981a.m83988e("ShareManagerActivity", "startInviteFriendsActivity exception: " + e10.getMessage());
        }
    }

    /* renamed from: D2 */
    public final void m26583D2() {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
            C13230i.m79504I().m79590k0("mecloud_findmyphone_click_family_manger", "", "", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_family_manger", "1", "19", "", "", linkedHashMap);
            Intent intentM79271I = C13195l.m79271I(this, "hwid://com.huawei.hwid/FamilyShare");
            if (intentM79271I == null) {
                C13981a.m83988e("ShareManagerActivity", "hmsPackage is invalid!");
            } else {
                intentM79271I.putExtra("callingpackage", getPackageName());
                startActivityForResult(intentM79271I, 0);
            }
        } catch (Exception e10) {
            C13981a.m83988e("ShareManagerActivity", "startFamilyShareActivity exception: " + e10.getMessage());
        }
    }

    /* renamed from: E2 */
    public void m26584E2(boolean z10) {
        this.f20166B.lock();
        try {
            if (this.f20165A == null) {
                this.f20165A = new C4405c(z10 ? 30L : 1L, 15L);
                C12515a.m75110o().m75172d(this.f20165A);
            }
        } finally {
            this.f20166B.unlock();
        }
    }

    @Override // wf.InterfaceC13596a
    /* renamed from: S */
    public void mo26171S(View view, int i10, int i11, boolean z10) {
        C13981a.m83989i("ShareManagerActivity", "onItemCheckedChanged:" + i11 + ",position:" + i10);
        ViewParent parent = view.getParent().getParent().getParent();
        ListItemPatterm listItemPatterm = parent instanceof ListItemPatterm ? (ListItemPatterm) parent : null;
        if (listItemPatterm == null) {
            C13981a.m83988e("ShareManagerActivity", "listItemPatterm is null");
            return;
        }
        if (m26596x2()) {
            listItemPatterm.setSwitchStatus(!z10);
            return;
        }
        if (i11 == 0) {
            m26594v2(z10, listItemPatterm);
            return;
        }
        if (i11 == 2) {
            SharingMemberItem sharingMemberItemM81762M = this.f20179y.m81762M(i10, 2);
            C13981a.m83987d("ShareManagerActivity", "family item:" + sharingMemberItemM81762M.getAliasName());
            if (z10) {
                m26580A2(i10, listItemPatterm, sharingMemberItemM81762M);
                return;
            } else {
                m26586h2(listItemPatterm, i10, sharingMemberItemM81762M);
                return;
            }
        }
        if (i11 == 4) {
            SharingMemberItem sharingMemberItemM81762M2 = this.f20179y.m81762M(i10, 4);
            C13981a.m83987d("ShareManagerActivity", "friend item:" + sharingMemberItemM81762M2.getAliasName());
            if (z10) {
                m26580A2(i10, listItemPatterm, sharingMemberItemM81762M2);
            } else {
                m26586h2(listItemPatterm, i10, sharingMemberItemM81762M2);
            }
        }
    }

    @Override // wf.InterfaceC13596a
    /* renamed from: a */
    public void mo26175a(View view, int i10, int i11) {
        C13981a.m83989i("ShareManagerActivity", "onItemClick:" + i11 + ",position:" + i10);
        if (C0209d.m1226Y0()) {
            C13981a.m83990w("ShareManagerActivity", "click too fast");
            return;
        }
        if (m26596x2()) {
            return;
        }
        if (i11 == 1) {
            m26583D2();
            return;
        }
        if (i11 == 5) {
            m26582C2();
            return;
        }
        if (i11 == 4) {
            SharingMemberItem sharingMemberItemM81761L = this.f20179y.m81761L(i10);
            this.f20179y.m81771V(i10);
            this.f20177w.closeMenu();
            C12515a.m75110o().m75172d(new C4404b(this, sharingMemberItemM81761L));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
            C13230i.m79504I().m79590k0("mecloud_findmyphone_click_delete_friend", "2", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_delete_friend", "1", "19", "2", "1", linkedHashMap);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20173s);
        arrayList.add(this.f20174t);
        arrayList.add(this.f20172r);
        return arrayList;
    }

    /* renamed from: g2 */
    public void m26585g2() {
        this.f20166B.lock();
        try {
            C4405c c4405c = this.f20165A;
            if (c4405c != null) {
                c4405c.m26602e(true);
                this.f20165A.cancel();
                this.f20165A = null;
            }
        } finally {
            this.f20166B.unlock();
        }
    }

    /* renamed from: h2 */
    public final void m26586h2(ListItemPatterm listItemPatterm, int i10, SharingMemberItem sharingMemberItem) {
        if (sharingMemberItem == null) {
            return;
        }
        listItemPatterm.setSwitchLoading(true);
        C12515a.m75110o().m75172d(new C4407e(listItemPatterm, sharingMemberItem, i10));
    }

    /* renamed from: l2 */
    public final /* synthetic */ void m26587l2(ListItemPatterm listItemPatterm, DialogInterface dialogInterface, int i10) {
        if (dialogInterface != null) {
            AlertDialog alertDialog = this.f20171G;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f20171G = null;
            }
            C12515a.m75110o().m75172d(new C4410h(listItemPatterm, false));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
            C13230i.m79504I().m79590k0("mecloud_findmyphone_click_location_share_switch", "2", "1", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_location_share_switch", "1", "19", "2", "1", linkedHashMap);
        }
    }

    /* renamed from: n2 */
    public final /* synthetic */ void m26588n2(int i10, ListItemPatterm listItemPatterm, SharingMemberItem sharingMemberItem, DialogInterface dialogInterface, int i11) {
        this.f20168D = i11;
        if (i11 == 0) {
            this.f20169E.getButton(-1).setEnabled(true);
        } else if (i11 == 1) {
            m26581B2(i10, listItemPatterm, sharingMemberItem);
        }
    }

    /* renamed from: o2 */
    public final /* synthetic */ void m26589o2(SharingMemberItem sharingMemberItem, ListItemPatterm listItemPatterm, int i10, DialogInterface dialogInterface, int i11) {
        C4406d c4406d;
        sharingMemberItem.setShareStartTime(C13604i.m81782e().m81784b(System.currentTimeMillis()));
        if (this.f20168D == 0) {
            sharingMemberItem.setShareInterval(Long.MAX_VALUE);
            c4406d = new C4406d(this, sharingMemberItem, listItemPatterm, i10);
        } else {
            c4406d = null;
        }
        listItemPatterm.setSwitchLoading(true);
        C12515a.m75110o().m75172d(c4406d);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0 && i11 == -1) {
            this.f20179y.m81772W();
            this.f20178x.clear();
            m26585g2();
            m26579y2();
        }
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C13981a.m83989i("ShareManagerActivity", "onCreate");
        super.onCreate(bundle);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        m26555B1();
        setContentView(R$layout.location_share_manager);
        m26574j2();
        m26573i2();
        mo19005p1();
    }

    @Override // com.huawei.android.remotecontrol.p093ui.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C13981a.m83989i("ShareManagerActivity", "onDestroy");
        super.onDestroy();
        AlertDialog alertDialog = this.f20169E;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        ShareTimePickerDialog shareTimePickerDialog = this.f20170F;
        if (shareTimePickerDialog != null) {
            shareTimePickerDialog.dismiss();
            this.f20170F = null;
        }
        AlertDialog alertDialog2 = this.f20171G;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f20171G = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void onPause() {
        C13981a.m83989i("ShareManagerActivity", "onPause");
        this.f20167C = true;
        m26585g2();
        super.onPause();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C13981a.m83989i("ShareManagerActivity", "onResume");
        C12515a.m75110o().m75172d(new C4411i(!this.f20167C));
        this.f20167C = false;
        super.onResume();
        if (this.f20172r == null) {
            C13981a.m83988e("ShareManagerActivity", "mExceptionView is null");
        } else {
            m26596x2();
        }
    }

    /* renamed from: r2 */
    public final /* synthetic */ void m26590r2(SharingMemberItem sharingMemberItem, ListItemPatterm listItemPatterm, int i10, DialogInterface dialogInterface, int i11) {
        AlertDialog alertDialog = this.f20169E;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f20169E.dismiss();
        }
        sharingMemberItem.setShareStartTime(C13604i.m81782e().m81784b(System.currentTimeMillis()));
        int minute = this.f20170F.getMinute();
        int hour = this.f20170F.getHour();
        sharingMemberItem.setShareInterval(C11881n.m71355e(minute, hour));
        C4406d c4406d = new C4406d(sharingMemberItem, listItemPatterm, i10, hour, minute);
        listItemPatterm.setSwitchLoading(true);
        C12515a.m75110o().m75172d(c4406d);
    }

    /* renamed from: s2 */
    public final /* synthetic */ void m26591s2(DialogInterface dialogInterface, int i10) {
        this.f20169E.getButton(-1).setEnabled(false);
    }

    /* renamed from: t2 */
    public final /* synthetic */ void m26592t2(DialogInterface dialogInterface) {
        this.f20169E.getButton(-1).setEnabled(false);
    }

    /* renamed from: u2 */
    public final /* synthetic */ void m26593u2(DialogInterface dialogInterface) {
        this.f20170F = null;
    }

    /* renamed from: v2 */
    public final void m26594v2(boolean z10, ListItemPatterm listItemPatterm) {
        C13981a.m83989i("ShareManagerActivity", "processLocationShareSwitch:" + z10);
        if (listItemPatterm == null) {
            C13981a.m83989i("ShareManagerActivity", "listItemPatterm is null");
            return;
        }
        listItemPatterm.setSwitchLoading(true);
        if (!C11853c.m70968g().m70972h(this) || TextUtils.isEmpty(AbstractC12139d.m72766e(this).getDeviceID())) {
            C12515a.m75110o().m75172d(new C4403a(z10, listItemPatterm));
        } else {
            C13981a.m83989i("ShareManagerActivity", "processLocationShareSwitch");
            m26595w2(z10, listItemPatterm);
        }
    }

    /* renamed from: w2 */
    public final void m26595w2(boolean z10, final ListItemPatterm listItemPatterm) {
        if (z10) {
            C12515a.m75110o().m75172d(new C4410h(listItemPatterm, true));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
            C13230i.m79504I().m79590k0("mecloud_findmyphone_click_location_share_switch", "1", "2", C13452e.m80781L().m80971t0(), linkedHashMap);
            UBAAnalyze.m29979g0("PVP", "mecloud_findmyphone_click_location_share_switch", "1", "19", "1", "2", linkedHashMap);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R$string.close_share_location_dialog_title));
        builder.setMessage(getResources().getString(R$string.close_share_location_dialog_message));
        builder.setPositiveButton(R$string.common_btn_close, new DialogInterface.OnClickListener() { // from class: xf.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f61969a.m26587l2(listItemPatterm, dialogInterface, i10);
            }
        });
        builder.setNegativeButton(R$string.text_pf_offline_dialog_negative, new DialogInterface.OnClickListener() { // from class: xf.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ShareManagerActivity.m26576m2(listItemPatterm, dialogInterface, i10);
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: xf.h
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ShareManagerActivity.m26575k2(listItemPatterm, dialogInterface);
            }
        });
        AlertDialog alertDialog = this.f20171G;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog alertDialogCreate = builder.create();
            this.f20171G = alertDialogCreate;
            C11842p.m70890z1(this, alertDialogCreate);
            this.f20171G.setCanceledOnTouchOutside(false);
            try {
                this.f20171G.show();
                this.f20171G.getButton(-1).setTextColor(getColor(R$color.expansion_service_prompt_text_color));
            } catch (Exception unused) {
                C13981a.m83988e("ShareManagerActivity", "show closeShareLocationDialog bad window");
            }
        }
    }

    /* renamed from: x2 */
    public final boolean m26596x2() {
        if (C0209d.m1333z1(this)) {
            this.f20172r.m23914a();
            return false;
        }
        this.f20172r.m23919i();
        return true;
    }

    /* renamed from: z2 */
    public final void m26597z2() {
        this.f20179y.m81779d0(this.f20178x);
        this.f20177w.setAdapter(this.f20179y);
        C11842p.m70712A2(this.f20175u, false);
        C11842p.m70712A2(this.f20176v, false);
        C11842p.m70712A2(this.f20177w, true);
    }
}
