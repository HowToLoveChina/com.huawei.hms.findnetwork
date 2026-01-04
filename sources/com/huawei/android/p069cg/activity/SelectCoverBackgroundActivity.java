package com.huawei.android.p069cg.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.album.service.p075vo.DayModeGroup;
import com.huawei.android.hicloud.drive.cloudphoto.model.Media;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.p071ui.EmptyLoadCoverBgRecyclerMediaAdapter;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p031b7.C1120a;
import p546p6.C12091d;
import sk.C12809f;

/* loaded from: classes2.dex */
public class SelectCoverBackgroundActivity extends UIActivity {

    /* renamed from: p */
    public EmptyLoadCoverBgRecyclerMediaAdapter f10292p;

    /* renamed from: q */
    public RecyclerView f10293q;

    /* renamed from: r */
    public RelativeLayout f10294r;

    /* renamed from: s */
    public NotchTopFitRelativeLayout f10295s;

    /* renamed from: t */
    public String f10296t;

    /* renamed from: u */
    public String f10297u;

    /* renamed from: v */
    public String f10298v;

    /* renamed from: w */
    public GridLayoutManager f10299w;

    /* renamed from: x */
    public Handler f10300x = new HandlerC2213a();

    /* renamed from: y */
    public RecyclerMediaAdapter.InterfaceC2353e f10301y = new C2214b();

    /* renamed from: com.huawei.android.cg.activity.SelectCoverBackgroundActivity$a */
    public class HandlerC2213a extends Handler {
        public HandlerC2213a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException, IllegalArgumentException {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 == 1004) {
                SelectCoverBackgroundActivity.this.m13694T1();
                return;
            }
            if (i10 == 1042) {
                int iFindLastVisibleItemPosition = SelectCoverBackgroundActivity.this.f10299w.findLastVisibleItemPosition();
                for (int iFindFirstVisibleItemPosition = SelectCoverBackgroundActivity.this.f10299w.findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition >= 0 && iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
                    SelectCoverBackgroundActivity.this.f10292p.mo723s(SelectCoverBackgroundActivity.this.f10293q.findViewHolderForLayoutPosition(iFindFirstVisibleItemPosition), iFindFirstVisibleItemPosition);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.SelectCoverBackgroundActivity$b */
    public class C2214b implements RecyclerMediaAdapter.InterfaceC2353e {
        public C2214b() {
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: a */
        public void mo13635a(View view, int i10) {
            if (C0209d.m1226Y0()) {
                C1120a.m6678w("SharePhotoUploadListActivity", "do not fast click");
                return;
            }
            Object objM14761R = SelectCoverBackgroundActivity.this.f10292p.m14761R(i10);
            if (objM14761R instanceof RecyclerMediaAdapter.C2356h) {
                MediaFileBean mediaFileBeanM14792a = ((RecyclerMediaAdapter.C2356h) objM14761R).m14792a();
                if (mediaFileBeanM14792a == null) {
                    C1120a.m6676e("SharePhotoUploadListActivity", "data not ready");
                    return;
                }
                Media mediaM14344o = mediaFileBeanM14792a.m14344o();
                if (mediaM14344o != null) {
                    Intent intent = new Intent(SelectCoverBackgroundActivity.this, (Class<?>) ShareBackGroundPreviewActivity.class);
                    intent.putExtra("param_media_id", mediaM14344o.getId());
                    intent.putExtra("image_path", mediaM14344o.getLocalBigThumbPath());
                    intent.putExtra("param_album_name", SelectCoverBackgroundActivity.this.f10297u);
                    intent.putExtra("select_type", SelectCoverBackgroundActivity.this.f10298v);
                    SelectCoverBackgroundActivity.this.startActivityForResult(intent, 106);
                }
            }
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: b */
        public void mo13636b(View view, int i10) {
            SelectCoverBackgroundActivity.this.f10292p.m14758K(SelectCoverBackgroundActivity.this.f10292p.m14761R(i10));
        }
    }

    /* renamed from: R1 */
    private void m13692R1(HiCloudSafeIntent hiCloudSafeIntent) {
        ActionBar actionBar;
        this.f10296t = hiCloudSafeIntent.getStringExtra("param_album_id");
        this.f10297u = hiCloudSafeIntent.getStringExtra("param_album_name");
        this.f10298v = hiCloudSafeIntent.getStringExtra("select_type");
        if (!TextUtils.isEmpty(this.f10297u) && (actionBar = getActionBar()) != null) {
            actionBar.setTitle(this.f10297u);
        }
        this.f10292p.m14696I0(this.f10296t);
        if (this.f10292p.mo721e() == 0) {
            this.f10292p.m14692E0(C12091d.m72280a0().m72401z0(this.f10296t + "select_cover_bg"), 2);
        }
        C12091d.m72280a0().m72318N(this.f10296t, this.f10300x);
    }

    /* renamed from: S1 */
    private void m13693S1() {
        this.f10293q = (RecyclerView) C12809f.m76829b(this, R$id.photos_album_recyclerview);
        this.f10294r = (RelativeLayout) C12809f.m76829b(this, R$id.rl_empty);
        this.f10295s = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        this.f10299w = gridLayoutManager;
        this.f10293q.setLayoutManager(gridLayoutManager);
        EmptyLoadCoverBgRecyclerMediaAdapter emptyLoadCoverBgRecyclerMediaAdapter = new EmptyLoadCoverBgRecyclerMediaAdapter(this);
        this.f10292p = emptyLoadCoverBgRecyclerMediaAdapter;
        emptyLoadCoverBgRecyclerMediaAdapter.m14775l0(C12091d.m72280a0().m72397x0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T1 */
    public void m13694T1() {
        if (this.f10292p != null) {
            List<DayModeGroup> listM72401z0 = C12091d.m72280a0().m72401z0(this.f10296t + "select_cover_bg");
            if (listM72401z0.isEmpty()) {
                this.f10293q.setVisibility(8);
                this.f10294r.setVisibility(0);
                return;
            }
            this.f10293q.setVisibility(0);
            this.f10292p.m14772i0(this.f10301y);
            this.f10292p.m14699L0(this.f10300x);
            this.f10293q.setAdapter(this.f10292p);
            this.f10292p.m14692E0(listM72401z0, 2);
            this.f10294r.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10295s);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C1120a.m6677i("SharePhotoUploadListActivity", "onActivityResult requestCode: " + i10 + ", resultCode: " + i11);
        if (i11 != 103 || intent == null) {
            return;
        }
        setResult(103, intent);
        Toast.makeText(this, R$string.toast_set_success, 0).show();
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f10292p.m14775l0(C12091d.m72280a0().m72397x0(this));
        m13694T1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_select_pic);
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        m13693S1();
        mo19005p1();
        m13692R1(hiCloudSafeIntent);
    }
}
