package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import aq.C1011a;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudWishAdapter;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$menu;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudWish;
import com.huawei.secure.android.common.intent.SafeIntent;
import huawei.android.app.HwProgressDialog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p053ce.C1423a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p783xp.C13843a;
import p802y8.C13918b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudWishActivity extends UIActivity implements View.OnClickListener, CloudWishAdapter.OnItemClickListener, CloudWishAdapter.OnItemLongClickListener, CloudWishAdapter.OnCheckClickListener {

    /* renamed from: A */
    public CloudWishAdapter f14629A;

    /* renamed from: B */
    public AlertDialog f14630B;

    /* renamed from: C */
    public HwProgressDialog f14631C;

    /* renamed from: D */
    public HandlerC3256b f14632D;

    /* renamed from: E */
    public String f14633E;

    /* renamed from: F */
    public boolean f14634F = true;

    /* renamed from: G */
    public int f14635G = 0;

    /* renamed from: p */
    public View f14636p;

    /* renamed from: q */
    public View f14637q;

    /* renamed from: r */
    public RecyclerView f14638r;

    /* renamed from: s */
    public View f14639s;

    /* renamed from: t */
    public View f14640t;

    /* renamed from: u */
    public View f14641u;

    /* renamed from: v */
    public View f14642v;

    /* renamed from: w */
    public View f14643w;

    /* renamed from: x */
    public AutoSizeButton f14644x;

    /* renamed from: y */
    public AutoSizeButton f14645y;

    /* renamed from: z */
    public AutoSizeButton f14646z;

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudWishActivity$a */
    public class C3255a extends RecyclerView.AbstractC0850t {

        /* renamed from: c0 */
        public int f14647c0 = 0;

        /* renamed from: d0 */
        public final /* synthetic */ LinearLayoutManager f14648d0;

        public C3255a(LinearLayoutManager linearLayoutManager) {
            this.f14648d0 = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            LinearLayoutManager linearLayoutManager;
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 != 0 || (linearLayoutManager = this.f14648d0) == null) {
                return;
            }
            int itemCount = linearLayoutManager.getItemCount();
            if (!CloudWishActivity.this.f14634F || TextUtils.isEmpty(CloudWishActivity.this.f14633E) || CloudWishActivity.this.m20284n2() || this.f14647c0 != itemCount - 1) {
                return;
            }
            CloudWishActivity.this.f14634F = false;
            if (CloudWishActivity.this.f14629A != null) {
                CloudWishActivity.this.f14629A.m25013S();
                CloudWishActivity.this.f14629A.m5214k(CloudWishActivity.this.f14629A.mo721e() - 1);
            }
            CloudWishActivity.this.invalidateOptionsMenu();
            if (CloudWishActivity.this.f14632D != null) {
                CloudWishActivity.this.f14632D.sendEmptyMessageDelayed(102, 1500L);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0850t
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            LinearLayoutManager linearLayoutManager = this.f14648d0;
            if (linearLayoutManager != null) {
                this.f14647c0 = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.CloudWishActivity$b */
    public static class HandlerC3256b extends Handler {

        /* renamed from: a */
        public final WeakReference<CloudWishActivity> f14650a;

        public HandlerC3256b(CloudWishActivity cloudWishActivity) {
            super(Looper.getMainLooper());
            this.f14650a = new WeakReference<>(cloudWishActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CloudWishActivity cloudWishActivity = this.f14650a.get();
            if (cloudWishActivity == null) {
                C11839m.m70689w("CloudWishActivity", "activity null");
                return;
            }
            int i10 = message.what;
            C11839m.m70688i("CloudWishActivity", "handleMessage: " + i10);
            if (i10 == 101) {
                cloudWishActivity.m20288r2();
                return;
            }
            if (i10 == 102) {
                cloudWishActivity.m20287q2();
                return;
            }
            if (i10 == 103) {
                cloudWishActivity.m20281i2(message.obj);
                return;
            }
            if (i10 == 104) {
                cloudWishActivity.m20280h2();
            } else if (i10 == 105) {
                cloudWishActivity.m20279g2();
            } else if (i10 == 106) {
                cloudWishActivity.m20278f2();
            }
        }
    }

    /* renamed from: A2 */
    private void m20246A2() {
        C11839m.m70688i("CloudWishActivity", "showNoNetwork");
        RecyclerView recyclerView = this.f14638r;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.f14639s;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f14640t;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.f14641u;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f14642v;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.f14643w;
        if (view5 != null) {
            view5.setVisibility(0);
        }
        invalidateOptionsMenu();
    }

    /* renamed from: B1 */
    private void m20247B1() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.wish_list);
            int i10 = R$color.hicloud_hmos_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(getColor(R$color.hicloud_hmos_bg));
    }

    /* renamed from: B2 */
    private void m20248B2() {
        C11839m.m70688i("CloudWishActivity", "showView");
        RecyclerView recyclerView = this.f14638r;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        View view = this.f14639s;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f14640t;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.f14641u;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f14642v;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.f14643w;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        invalidateOptionsMenu();
    }

    /* renamed from: l2 */
    private void m20263l2() {
        CloudWishAdapter cloudWishAdapter = new CloudWishAdapter(this);
        this.f14629A = cloudWishAdapter;
        cloudWishAdapter.m25009O(this);
        this.f14629A.m25010P(this);
        this.f14629A.m25008N(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f14638r.addItemDecoration(C1423a.m8274a(this).m8277d(40).m8278e(40).m8276c(0.3f));
        this.f14638r.setAdapter(this.f14629A);
        this.f14638r.setLayoutManager(linearLayoutManager);
        this.f14638r.addOnScrollListener(new C3255a(linearLayoutManager));
    }

    /* renamed from: m2 */
    private void m20264m2() {
        this.f14636p = C12809f.m76829b(this, R$id.main_layout);
        this.f14637q = C12809f.m76829b(this, R$id.content_layout);
        this.f14638r = (RecyclerView) C12809f.m76829b(this, R$id.wish_rv);
        this.f14639s = C12809f.m76829b(this, R$id.empty_layout);
        this.f14640t = C12809f.m76829b(this, R$id.query_layout);
        this.f14641u = C12809f.m76829b(this, R$id.query_loading_layout);
        this.f14642v = C12809f.m76829b(this, R$id.query_error_layout);
        this.f14643w = C12809f.m76829b(this, R$id.query_network_layout);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f14644x = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f14645y = (AutoSizeButton) C12809f.m76829b(this, R$id.btn_wish_add);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.btn_wish_delete);
        this.f14646z = autoSizeButton2;
        autoSizeButton2.setOnClickListener(this);
        C11842p.m70874v1(this, this.f14644x);
        C11842p.m70866t1(this, this.f14645y);
        C11842p.m70866t1(this, this.f14646z);
        if (!C13918b.m83437m().m83450t()) {
            this.f14645y.setVisibility(8);
        } else {
            this.f14645y.setVisibility(0);
            this.f14645y.setOnClickListener(this);
        }
    }

    /* renamed from: v2 */
    private void m20266v2() {
        C11839m.m70688i("CloudWishActivity", "showDeleteDialog");
        if (this.f14630B == null) {
            this.f14630B = new AlertDialog.Builder(this).setTitle(getString(R$string.wish_list_delete_wish)).setMessage(getString(R$string.wish_list_delete_wish_msg)).setPositiveButton(getString(R$string.wish_list_delete), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.a5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f16473a.m20285o2(dialogInterface, i10);
                }
            }).setNegativeButton(getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.activity.b5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    dialogInterface.dismiss();
                }
            }).create();
        }
        this.f14630B.show();
    }

    /* renamed from: z2 */
    private void m20267z2() {
        C11839m.m70688i("CloudWishActivity", "showLoading");
        RecyclerView recyclerView = this.f14638r;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.f14639s;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f14640t;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.f14641u;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        View view4 = this.f14642v;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.f14643w;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        invalidateOptionsMenu();
    }

    /* renamed from: C2 */
    public final void m20268C2() {
        C11839m.m70688i("CloudWishActivity", "startAddActivity");
        startActivityForResult(new Intent(this, (Class<?>) CloudWishAddActivity.class), 1000);
    }

    /* renamed from: D2 */
    public final void m20269D2(CloudWish cloudWish) {
        if (cloudWish == null) {
            C11839m.m70689w("CloudWishActivity", "data null");
            return;
        }
        C11839m.m70688i("CloudWishActivity", "startDetailActivity");
        SafeIntent safeIntent = new SafeIntent(new Intent(this, (Class<?>) CloudWishDetailActivity.class));
        safeIntent.putExtra("title", cloudWish.getTitle());
        safeIntent.putExtra("content", cloudWish.getContent());
        safeIntent.putExtra(CallLogCons.DATE, cloudWish.getCreateTime());
        startActivity(safeIntent);
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter.OnItemLongClickListener
    /* renamed from: F */
    public boolean mo20270F(CloudWishAdapter cloudWishAdapter, CloudWish cloudWish, int i10) throws Resources.NotFoundException {
        C11839m.m70688i("CloudWishActivity", "onItemLongClick");
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudWishActivity", "click too fast");
            return false;
        }
        CloudWishAdapter cloudWishAdapter2 = this.f14629A;
        if (cloudWishAdapter2 != null && cloudWishAdapter2.m25006L()) {
            C11839m.m70688i("CloudWishActivity", "is loading");
            return false;
        }
        if (!m20284n2()) {
            m20275c2();
        }
        m20272Z1(i10);
        return false;
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter.OnCheckClickListener
    /* renamed from: Y */
    public void mo20271Y(CloudWish cloudWish, int i10) throws Resources.NotFoundException {
        m20272Z1(i10);
    }

    /* renamed from: Z1 */
    public final void m20272Z1(int i10) throws Resources.NotFoundException {
        C11839m.m70688i("CloudWishActivity", "checkDeleteItem");
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter == null) {
            return;
        }
        CloudWish cloudWishM25004J = cloudWishAdapter.m25004J(i10);
        cloudWishM25004J.setChecked(!cloudWishM25004J.isChecked());
        if (cloudWishM25004J.isChecked()) {
            this.f14629A.m25003I().add(cloudWishM25004J);
        } else {
            this.f14629A.m25003I().remove(cloudWishM25004J);
        }
        m20291u2();
        invalidateOptionsMenu();
        this.f14629A.m5214k(i10);
    }

    /* renamed from: a2 */
    public final void m20273a2() {
        List<CloudWish> listM25003I;
        C11839m.m70688i("CloudWishActivity", "deleteCheckList");
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter == null || (listM25003I = cloudWishAdapter.m25003I()) == null || listM25003I.isEmpty()) {
            return;
        }
        m20292w2();
        for (int i10 = 0; i10 < listM25003I.size(); i10++) {
            C13918b.m83437m().m83439A(this.f14632D, listM25003I.get(i10).getId());
        }
    }

    /* renamed from: b2 */
    public final void m20274b2() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R$string.not_selected));
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R$drawable.actionbar_cancel_box);
        }
    }

    /* renamed from: c2 */
    public void m20275c2() {
        C11839m.m70688i("CloudWishActivity", "enableEditMode");
        m20289s2();
        AutoSizeButton autoSizeButton = this.f14645y;
        if (autoSizeButton != null) {
            autoSizeButton.setVisibility(8);
        }
        AutoSizeButton autoSizeButton2 = this.f14646z;
        if (autoSizeButton2 != null) {
            autoSizeButton2.setVisibility(0);
        }
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter != null) {
            cloudWishAdapter.m25007M(true);
        }
        m20274b2();
        invalidateOptionsMenu();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14636p);
        arrayList.add(this.f14637q);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m20276d2() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R$string.wish_list);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(0);
        }
    }

    /* renamed from: e2 */
    public void m20277e2() {
        AutoSizeButton autoSizeButton;
        C11839m.m70688i("CloudWishActivity", "exitEditMode");
        m20289s2();
        if (C13918b.m83437m().m83450t() && (autoSizeButton = this.f14645y) != null) {
            autoSizeButton.setVisibility(0);
        }
        AutoSizeButton autoSizeButton2 = this.f14646z;
        if (autoSizeButton2 != null) {
            autoSizeButton2.setVisibility(8);
        }
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter != null) {
            cloudWishAdapter.m25007M(false);
        }
        m20276d2();
        invalidateOptionsMenu();
    }

    /* renamed from: f2 */
    public final void m20278f2() {
        int i10 = this.f14635G + 1;
        this.f14635G = i10;
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter == null || i10 != cloudWishAdapter.m25003I().size()) {
            return;
        }
        this.f14635G = 0;
        this.f14629A.m25003I().clear();
        m20283k2();
        m20288r2();
    }

    /* renamed from: g2 */
    public final void m20279g2() {
        int i10 = this.f14635G + 1;
        this.f14635G = i10;
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter == null || i10 != cloudWishAdapter.m25003I().size()) {
            return;
        }
        this.f14635G = 0;
        this.f14629A.m25003I().clear();
        m20283k2();
        m20288r2();
    }

    /* renamed from: h2 */
    public final void m20280h2() {
        m20294y2();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* renamed from: i2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m20281i2(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = "handleGetSuccessMsg"
            java.lang.String r1 = "CloudWishActivity"
            p514o9.C11839m.m70688i(r1, r0)
            boolean r0 = r6 instanceof java.lang.String
            r2 = 0
            if (r0 == 0) goto L4b
            java.lang.String r6 = (java.lang.String) r6
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch: java.lang.Exception -> L2e
            r0.<init>()     // Catch: java.lang.Exception -> L2e
            java.lang.Class<com.huawei.cloud.pay.model.GetCloudWishResp> r3 = com.huawei.cloud.pay.model.GetCloudWishResp.class
            java.lang.Object r6 = r0.fromJson(r6, r3)     // Catch: java.lang.Exception -> L2e
            com.huawei.cloud.pay.model.GetCloudWishResp r6 = (com.huawei.cloud.pay.model.GetCloudWishResp) r6     // Catch: java.lang.Exception -> L2e
            if (r6 == 0) goto L4b
            java.util.List r0 = r6.getWishes()     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L4b
            java.util.List r0 = r6.getWishes()     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = r6.getNextCursor()     // Catch: java.lang.Exception -> L2c
            goto L48
        L2c:
            r6 = move-exception
            goto L30
        L2e:
            r6 = move-exception
            r0 = r2
        L30:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "handleGetSuccessMsg: "
            r3.append(r4)
            java.lang.String r6 = r6.getMessage()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            p514o9.C11839m.m70687e(r1, r6)
        L48:
            r6 = r2
            r2 = r0
            goto L4c
        L4b:
            r6 = r2
        L4c:
            r0 = 0
            if (r2 == 0) goto L83
            int r1 = r2.size()
            if (r1 <= 0) goto L83
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r3 = 1
            if (r1 != 0) goto L68
            r5.f14633E = r6
            r5.f14634F = r3
            com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter r6 = r5.f14629A
            if (r6 == 0) goto L71
            r6.m25012R()
            goto L71
        L68:
            r5.f14634F = r0
            com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter r6 = r5.f14629A
            if (r6 == 0) goto L71
            r6.m25011Q()
        L71:
            com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter r6 = r5.f14629A
            if (r6 == 0) goto L78
            r6.m25001G(r2)
        L78:
            r5.m20248B2()
            vj.e r6 = p709vj.C13452e.m80781L()
            r6.m80824K1(r3)
            goto Lab
        L83:
            java.lang.String r6 = r5.f14633E
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L9f
            r5.f14634F = r0
            com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter r6 = r5.f14629A
            if (r6 == 0) goto L94
            r6.m25011Q()
        L94:
            r5.m20293x2()
            vj.e r6 = p709vj.C13452e.m80781L()
            r6.m80824K1(r0)
            goto Lab
        L9f:
            r5.f14634F = r0
            com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter r6 = r5.f14629A
            if (r6 == 0) goto La8
            r6.m25011Q()
        La8:
            r5.m20248B2()
        Lab:
            com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter r5 = r5.f14629A
            if (r5 == 0) goto Lb2
            r5.m5213j()
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.CloudWishActivity.m20281i2(java.lang.Object):void");
    }

    /* renamed from: j2 */
    public final void m20282j2() {
        AlertDialog alertDialog = this.f14630B;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f14630B.dismiss();
    }

    /* renamed from: k2 */
    public final void m20283k2() {
        HwProgressDialog hwProgressDialog = this.f14631C;
        if (hwProgressDialog == null || !hwProgressDialog.isShowing()) {
            return;
        }
        this.f14631C.hide();
    }

    /* renamed from: n2 */
    public final boolean m20284n2() {
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        return cloudWishAdapter != null && cloudWishAdapter.m25005K();
    }

    /* renamed from: o2 */
    public final /* synthetic */ void m20285o2(DialogInterface dialogInterface, int i10) {
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudWishActivity", "click too fast");
        } else {
            m20273a2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1000 && i11 == -1) {
            m20288r2();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (m20284n2()) {
            m20277e2();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CloudWishAdapter cloudWishAdapter;
        C11839m.m70688i("CloudWishActivity", "click");
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudWishActivity", "click too fast");
            return;
        }
        int id2 = view.getId();
        if (R$id.btn_wish_add == id2) {
            if (m20284n2()) {
                return;
            }
            m20268C2();
        } else if (R$id.btn_wish_delete != id2) {
            if (R$id.set_no_net_btn == id2) {
                C11829c.m70612r1(this);
            }
        } else {
            if (!m20284n2() || (cloudWishAdapter = this.f14629A) == null || cloudWishAdapter.m25003I().size() <= 0) {
                return;
            }
            m20266v2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14644x);
        C11842p.m70866t1(this, this.f14645y);
        C11842p.m70866t1(this, this.f14646z);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C11839m.m70688i("CloudWishActivity", "onCreate");
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        this.f14632D = new HandlerC3256b(this);
        setContentView(R$layout.activity_wish_list_manager);
        m20247B1();
        m20264m2();
        mo19005p1();
        m20263l2();
        m20288r2();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R$menu.wish_menu, menu);
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        m20282j2();
        m20283k2();
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Resources.NotFoundException {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            if (m20284n2()) {
                m20277e2();
                return true;
            }
            finish();
            return true;
        }
        if (itemId != R$id.select_all_wish) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (!m20284n2()) {
            return true;
        }
        m20290t2();
        invalidateOptionsMenu();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem menuItemFindItem = menu.findItem(R$id.select_all_wish);
        RecyclerView recyclerView = this.f14638r;
        if (recyclerView != null && recyclerView.getVisibility() == 0 && m20284n2()) {
            menuItemFindItem.setVisible(true);
            CloudWishAdapter cloudWishAdapter = this.f14629A;
            if (cloudWishAdapter == null || cloudWishAdapter.m25002H().size() != this.f14629A.m25003I().size()) {
                menuItemFindItem.setIcon(R$drawable.hidisk_ic_menu_all);
            } else {
                menuItemFindItem.setIcon(R$drawable.hidisk_ic_menu_alls);
            }
        } else {
            menuItemFindItem.setVisible(false);
        }
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        C11839m.m70686d("CloudWishActivity", "onResume");
        super.onResume();
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudWishAdapter.OnItemClickListener
    /* renamed from: p */
    public void mo20286p(CloudWishAdapter cloudWishAdapter, CloudWish cloudWish, int i10) {
        C11839m.m70688i("CloudWishActivity", "onItemClick");
        if (C0209d.m1226Y0()) {
            C11839m.m70689w("CloudWishActivity", "click too fast");
        } else if (m20284n2()) {
            C11839m.m70686d("CloudWishActivity", "edit mode");
        } else {
            m20269D2(cloudWish);
        }
    }

    /* renamed from: q2 */
    public final void m20287q2() {
        C11839m.m70688i("CloudWishActivity", "loadMoreWishList");
        if (!C0209d.m1333z1(this)) {
            m20246A2();
        } else {
            m20277e2();
            C13918b.m83437m().m83441C(this.f14632D, this.f14633E);
        }
    }

    /* renamed from: r2 */
    public final void m20288r2() {
        List<CloudWish> listM25002H;
        C11839m.m70688i("CloudWishActivity", "refreshWishList");
        if (!C0209d.m1333z1(this)) {
            m20246A2();
            return;
        }
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter != null && (listM25002H = cloudWishAdapter.m25002H()) != null) {
            listM25002H.clear();
        }
        this.f14633E = "";
        m20267z2();
        m20277e2();
        C13918b.m83437m().m83441C(this.f14632D, this.f14633E);
    }

    /* renamed from: s2 */
    public final void m20289s2() {
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter != null) {
            List<CloudWish> listM25002H = cloudWishAdapter.m25002H();
            for (int i10 = 0; i10 < listM25002H.size(); i10++) {
                listM25002H.get(i10).setChecked(false);
            }
            if (this.f14629A.m25003I() != null) {
                this.f14629A.m25003I().clear();
            }
        }
    }

    /* renamed from: t2 */
    public final void m20290t2() throws Resources.NotFoundException {
        List<CloudWish> listM25002H;
        C11839m.m70688i("CloudWishActivity", "selectAll");
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter == null || (listM25002H = cloudWishAdapter.m25002H()) == null) {
            return;
        }
        if (listM25002H.size() == this.f14629A.m25003I().size()) {
            for (int i10 = 0; i10 < listM25002H.size(); i10++) {
                listM25002H.get(i10).setChecked(false);
            }
            this.f14629A.m25003I().clear();
        } else {
            for (int i11 = 0; i11 < listM25002H.size(); i11++) {
                listM25002H.get(i11).setChecked(true);
            }
            this.f14629A.m25003I().clear();
            this.f14629A.m25003I().addAll(listM25002H);
        }
        m20291u2();
        invalidateOptionsMenu();
        this.f14629A.m5213j();
    }

    /* renamed from: u2 */
    public final void m20291u2() throws Resources.NotFoundException {
        String string;
        CloudWishAdapter cloudWishAdapter = this.f14629A;
        if (cloudWishAdapter == null) {
            return;
        }
        int size = cloudWishAdapter.m25003I().size();
        if (size > 0) {
            string = getResources().getQuantityString(R$plurals.select_title_new, size, C1011a.m6163c(Integer.valueOf(size)));
        } else {
            string = getString(R$string.not_selected);
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle(string);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: w2 */
    public final void m20292w2() {
        if (this.f14631C == null) {
            HwProgressDialog hwProgressDialog = new HwProgressDialog(this);
            this.f14631C = hwProgressDialog;
            hwProgressDialog.setMessage(getString(R$string.hicloud_notepad_deleting));
            this.f14631C.setCanceledOnTouchOutside(false);
            this.f14631C.setCancelable(false);
        }
        this.f14631C.show();
    }

    /* renamed from: x2 */
    public final void m20293x2() {
        C11839m.m70688i("CloudWishActivity", "showEmpty");
        RecyclerView recyclerView = this.f14638r;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.f14639s;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f14640t;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.f14641u;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f14642v;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.f14643w;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        invalidateOptionsMenu();
    }

    /* renamed from: y2 */
    public final void m20294y2() {
        C11839m.m70688i("CloudWishActivity", "showFail");
        RecyclerView recyclerView = this.f14638r;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.f14639s;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f14640t;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.f14641u;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f14642v;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        View view5 = this.f14643w;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        invalidateOptionsMenu();
    }
}
