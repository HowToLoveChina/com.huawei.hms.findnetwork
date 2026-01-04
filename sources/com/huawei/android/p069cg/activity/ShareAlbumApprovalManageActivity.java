package com.huawei.android.p069cg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p471m6.C11416b;
import p514o9.C11839m;
import p546p6.C12091d;
import p834z6.C14150j;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumApprovalManageActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public RecyclerView f10346p;

    /* renamed from: q */
    public C14150j f10347q;

    /* renamed from: t */
    public String f10350t;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f10348r = null;

    /* renamed from: s */
    public NotchFitRelativeLayout f10349s = null;

    /* renamed from: u */
    public boolean f10351u = false;

    /* renamed from: v */
    public Handler f10352v = new HandlerC2218a();

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumApprovalManageActivity$a */
    public class HandlerC2218a extends Handler {
        public HandlerC2218a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("ShareAlbumApprovalManageActivity", "handleMessage " + message.what);
            if (message.what == 1005) {
                List<C11416b> list = (List) message.obj;
                if (ShareAlbumApprovalManageActivity.this.f10351u && (list == null || list.isEmpty())) {
                    ShareAlbumApprovalManageActivity.this.finish();
                } else {
                    ShareAlbumApprovalManageActivity.this.f10347q.m84935D(list);
                }
            }
        }
    }

    /* renamed from: N1 */
    private void m13745N1() {
        C12091d.m72280a0().m72344b0(this.f10350t, this.f10352v);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10349s);
        arrayList.add(this.f10348r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 104) {
            this.f10351u = true;
            m13745N1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C0209d.m1226Y0() && view.getId() == R$id.rl_approval_item) {
            C11416b c11416bM84936E = this.f10347q.m84936E(((Integer) view.getTag()).intValue());
            Intent intent = new Intent(this, (Class<?>) ShareAlbumApplicationInfoActivity.class);
            intent.putExtra("param_approval_id", c11416bM84936E.m68379b().getApplicantId());
            intent.putExtra("param_album_id", this.f10350t);
            startActivityForResult(intent, 104);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10350t = new C10343b(new SafeIntent(getIntent()).getExtras()).m63694p("param_album_id");
        setContentView(R$layout.activity_share_approval_manager);
        this.f10346p = (RecyclerView) C12809f.m76829b(this, R$id.rc_approve_list);
        this.f10348r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10349s = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10346p.setLayoutManager(new LinearLayoutManager(this));
        C14150j c14150j = new C14150j(this, new View.OnClickListener() { // from class: k6.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52071a.onClick(view);
            }
        });
        this.f10347q = c14150j;
        this.f10346p.setAdapter(c14150j);
        C11839m.m70688i("ShareAlbumApprovalManageActivity", "onCreate");
        getActionBar().setTitle(R$string.album_to_approve_list);
        mo19005p1();
        mo19982C1();
        m13745N1();
    }
}
