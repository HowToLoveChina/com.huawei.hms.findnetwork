package com.huawei.android.p069cg.activity;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.bean.MediaFileBean;
import com.huawei.android.p069cg.dialog.AlbumUploadingDialog;
import com.huawei.android.p069cg.p071ui.ImagesGridView;
import com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter;
import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.p148ui.SafeIntent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1123d;
import p031b7.C1140u;
import p471m6.C11417c;
import p471m6.C11425k;
import p514o9.C11841o;
import p546p6.C12091d;
import p546p6.C12097j;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes2.dex */
public class UploadShareAlbumActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: q */
    public NotchTopFitRelativeLayout f10681q;

    /* renamed from: r */
    public NotchFitRelativeLayout f10682r;

    /* renamed from: s */
    public ImagesGridView f10683s;

    /* renamed from: t */
    public RecyclerMediaAdapter f10684t;

    /* renamed from: u */
    public String f10685u;

    /* renamed from: v */
    public List<MediaFileBean> f10686v;

    /* renamed from: w */
    public RelativeLayout f10687w;

    /* renamed from: x */
    public TextView f10688x;

    /* renamed from: y */
    public AlbumUploadingDialog f10689y;

    /* renamed from: z */
    public Album f10690z;

    /* renamed from: p */
    public boolean f10680p = true;

    /* renamed from: A */
    public Handler f10678A = new HandlerC2254a();

    /* renamed from: B */
    public RecyclerMediaAdapter.InterfaceC2353e f10679B = new C2255b();

    /* renamed from: com.huawei.android.cg.activity.UploadShareAlbumActivity$a */
    public class HandlerC2254a extends Handler {
        public HandlerC2254a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1035) {
                C1120a.m6675d("UploadShareAlbumActivity", "MSG_ADD_UPLOAD_TASK_FINISH result=" + message.arg1);
                if (UploadShareAlbumActivity.this.f10689y != null) {
                    UploadShareAlbumActivity.this.f10689y.dismiss();
                }
                if (message.arg1 == 1) {
                    return;
                }
                UploadShareAlbumActivity.this.m14003X1();
                return;
            }
            if (i10 == 100) {
                if (message.arg2 == 1007) {
                    UploadShareAlbumActivity uploadShareAlbumActivity = UploadShareAlbumActivity.this;
                    C11841o.m70706b(uploadShareAlbumActivity, uploadShareAlbumActivity.getString(R$string.album_no_upload_permission), 0);
                    return;
                }
                return;
            }
            if (i10 == 1037) {
                List<C11425k> list = (List) message.obj;
                if (list.size() == 0) {
                    return;
                }
                UploadShareAlbumActivity.this.f10684t.m14766a0(list, 2);
                return;
            }
            if (i10 == 0) {
                UploadShareAlbumActivity.this.m13999R1();
            } else if (i10 == 2000) {
                C12091d.m72280a0().m72359i1(UploadShareAlbumActivity.this);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.UploadShareAlbumActivity$b */
    public class C2255b implements RecyclerMediaAdapter.InterfaceC2353e {
        public C2255b() {
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: a */
        public void mo13635a(View view, int i10) {
        }

        @Override // com.huawei.android.p069cg.p071ui.RecyclerMediaAdapter.InterfaceC2353e
        /* renamed from: b */
        public void mo13636b(View view, int i10) {
            Object objM14761R = UploadShareAlbumActivity.this.f10684t.m14761R(i10);
            UploadShareAlbumActivity.this.f10684t.m14758K(objM14761R);
            try {
                UploadShareAlbumActivity.this.m14002U1((RecyclerMediaAdapter.C2356h) objM14761R);
            } catch (Exception e10) {
                C1120a.m6676e("UploadShareAlbumActivity", "onDeleteIconClick " + e10.getMessage());
            }
        }
    }

    /* renamed from: V1 */
    private void m13996V1() {
        String stringExtra = new SafeIntent(getIntent()).getStringExtra("param_album_id");
        C1120a.m6675d("UploadShareAlbumActivity", "initData albumId " + stringExtra);
        this.f10690z = C12091d.m72280a0().m72310I(stringExtra);
        C1120a.m6675d("UploadShareAlbumActivity", "intent mIsFromCreateEntry " + this.f10680p);
        if (this.f10680p) {
            C12091d.m72280a0().m72303E0(this, 546);
        }
    }

    /* renamed from: W1 */
    private void m13997W1() {
        this.f10681q = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10682r = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_all);
        this.f10683s = (ImagesGridView) C12809f.m76829b(this, R$id.rv_upload_share_album);
        RecyclerMediaAdapter recyclerMediaAdapter = new RecyclerMediaAdapter(this);
        this.f10684t = recyclerMediaAdapter;
        recyclerMediaAdapter.m14772i0(this.f10679B);
        this.f10683s.setLayoutManager(new GridLayoutManager(this, 5));
        this.f10684t.m14775l0(5);
        this.f10683s.setAdapter(this.f10684t);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.ic_back_hot_space);
        this.f10687w = relativeLayout;
        relativeLayout.setOnClickListener(this);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_complete);
        this.f10688x = textView;
        textView.setOnClickListener(this);
        m14005Z1();
    }

    /* renamed from: Q1 */
    public final long m13998Q1() {
        List<MediaFileBean> list = this.f10686v;
        long jM14337i = 0;
        if (list == null) {
            C1120a.m6676e("UploadShareAlbumActivity", "checkDataSize mUploadData is null");
            return 0L;
        }
        Iterator<MediaFileBean> it = list.iterator();
        while (it.hasNext()) {
            jM14337i += it.next().m14337i();
        }
        return jM14337i;
    }

    /* renamed from: R1 */
    public final void m13999R1() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        AlbumUploadingDialog albumUploadingDialog = new AlbumUploadingDialog(this);
        this.f10689y = albumUploadingDialog;
        albumUploadingDialog.show();
        C12091d.m72280a0().m72374p(this.f10690z, this.f10686v, this.f10678A, this);
        m14004Y1();
    }

    /* renamed from: S1 */
    public final void m14000S1() {
        C11417c c11417c = new C11417c();
        c11417c.m68402s(true);
        C12091d.m72280a0().m72363k1(this, this.f10678A, this.f10686v, c11417c, "album_id_upload_select");
    }

    /* renamed from: T1 */
    public final List<Uri> m14001T1(Bundle bundle) {
        return (List) bundle.get("select-item-list");
    }

    /* renamed from: U1 */
    public final void m14002U1(RecyclerMediaAdapter.C2356h c2356h) {
        if (c2356h == null || c2356h.m14792a() == null) {
            C1120a.m6676e("UploadShareAlbumActivity", "handleDeleteUploadData item is null ");
            return;
        }
        MediaFileBean mediaFileBean = new MediaFileBean();
        mediaFileBean.m14318U(c2356h.m14792a().m14331f());
        mediaFileBean.m14351s0(c2356h.m14792a().m14350s());
        MediaFileBean mediaFileBean2 = null;
        for (MediaFileBean mediaFileBean3 : this.f10686v) {
            if (mediaFileBean3.m14331f().equals(mediaFileBean.m14331f()) && mediaFileBean3.m14350s().equals(mediaFileBean.m14350s())) {
                mediaFileBean2 = mediaFileBean3;
            }
        }
        if (mediaFileBean2 == null) {
            C1120a.m6676e("UploadShareAlbumActivity", "handleDeleteUploadData tempBean is null");
            return;
        }
        this.f10686v.remove(mediaFileBean2);
        if (this.f10686v.size() == 0) {
            C12091d.m72280a0().m72303E0(this, 546);
        }
    }

    /* renamed from: X1 */
    public final void m14003X1() {
        C12091d.m72280a0().m72321O0(this);
        Intent intent = new Intent(this, (Class<?>) ShareAlbumHomePageActivity.class);
        intent.putExtra("param_album_id", this.f10690z.getId());
        intent.putExtra("param_album_type", this.f10690z.getShareType());
        intent.putExtra("param_owner_id", this.f10690z.getAlbumOwnerId());
        C0224k0.m1542L(this, intent);
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    /* renamed from: Y1 */
    public final void m14004Y1() {
        int i10;
        int i11;
        C1120a.m6675d("UploadShareAlbumActivity", "reportClickCompleteEvent eventCode action_code_click_upload_complete");
        List<MediaFileBean> list = this.f10686v;
        if (list == null || list.size() <= 0) {
            i10 = 0;
            i11 = 0;
        } else {
            Iterator<MediaFileBean> it = this.f10686v.iterator();
            i10 = 0;
            i11 = 0;
            while (it.hasNext()) {
                if (3 == it.next().m14338j()) {
                    i11++;
                } else {
                    i10++;
                }
            }
        }
        BaseLogger.m28730d("UploadShareAlbumActivity", "videoCount " + i11, " picCount " + i10 + " mIsFromCreateEntry " + this.f10680p);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("is_from_create_entry", String.valueOf(this.f10680p));
        linkedHashMapM79497A.put("share_type", String.valueOf(0));
        linkedHashMapM79497A.put("upload_pic_count", String.valueOf(i10));
        linkedHashMapM79497A.put("upload_video_count", String.valueOf(i11));
        C13224c.m79487f1().m79592m0("action_code_click_upload_complete", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_code_click_upload_complete", "1", "from_cloud_album_appeal_main", linkedHashMapM79497A);
    }

    /* renamed from: Z1 */
    public final void m14005Z1() {
        this.f10688x.setAlpha(1.0f);
        this.f10688x.setEnabled(true);
        this.f10688x.setClickable(true);
    }

    /* renamed from: a2 */
    public final void m14006a2(Bundle bundle) {
        StringBuilder sb2 = new StringBuilder("Bundle{");
        for (String str : bundle.keySet()) {
            sb2.append(" ");
            sb2.append(str);
            sb2.append(" => ");
            sb2.append(bundle.get(str));
            sb2.append(";");
        }
        sb2.append(" }Bundle");
        C1120a.m6675d("showBundleData", sb2.toString());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10681q);
        arrayList.add(this.f10682r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 != 546 || i11 != -1) {
            if (i10 != 306) {
                if (i11 == 0) {
                    m14003X1();
                    return;
                }
                return;
            } else {
                if (this.f10684t == null || this.f10686v == null) {
                    return;
                }
                this.f10686v = C1122c.m6736T("album_id_upload_select");
                m14000S1();
                return;
            }
        }
        if (intent != null) {
            try {
                m14006a2(intent.getExtras());
                Bundle extras = intent.getExtras();
                this.f10685u = extras.getString("select-item-list-key");
                this.f10686v = C12091d.m72280a0().m72340Y(this, m14001T1(extras));
                m14000S1();
            } catch (Exception e10) {
                C1120a.m6676e("UploadShareAlbumActivity", "onActivityResult exception: " + e10.toString());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1120a.m6676e("UploadShareAlbumActivity", "fast click");
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.ic_back_hot_space) {
            if (NetworkUtil.isNetworkAvailable(this)) {
                C12091d.m72280a0().m72305F0(this, 546, this.f10685u, this.f10686v);
                return;
            } else {
                finish();
                return;
            }
        }
        if (id2 == R$id.tv_complete) {
            if (!NetworkUtil.isNetworkAvailable(this)) {
                C1140u.m7197i(this);
                return;
            }
            if (C1123d.m6855a(this) == 4) {
                m13999R1();
                return;
            }
            long jM13998Q1 = m13998Q1();
            String fileSize = Formatter.formatFileSize(this, jM13998Q1);
            int iM1357g = C0212e0.m1357g(this, "mobile_data_tips_sp", "current_tips_setting_type", 0);
            if (iM1357g == 0) {
                C12097j.m72480b().m72482c(this, fileSize, 4, this.f10678A);
                return;
            }
            if (iM1357g != 1) {
                if (iM1357g != 2) {
                    return;
                }
                m13999R1();
            } else if (jM13998Q1 > C1122c.f5368v) {
                C12097j.m72480b().m72482c(this, fileSize, 4, this.f10678A);
            } else {
                m13999R1();
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10680p = bundle.getBoolean("is_from_create_entry");
        }
        setContentView(R$layout.layout_upload_share_album);
        m13996V1();
        m13997W1();
        mo19005p1();
        m22368H1();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlbumUploadingDialog albumUploadingDialog = this.f10689y;
        if (albumUploadingDialog != null) {
            albumUploadingDialog.dismiss();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("trans_upload_data");
        this.f10686v = parcelableArrayList;
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            return;
        }
        m14000S1();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_from_create_entry", false);
        bundle.putParcelableArrayList("trans_upload_data", (ArrayList) this.f10686v);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: v1 */
    public boolean mo13429v1(int i10, KeyEvent keyEvent) {
        C12091d.m72280a0().m72305F0(this, 546, this.f10685u, this.f10686v);
        return true;
    }
}
