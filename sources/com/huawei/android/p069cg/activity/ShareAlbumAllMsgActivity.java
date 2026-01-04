package com.huawei.android.p069cg.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.hicloud.notification.util.HiCloudLink;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0234s;
import p031b7.C1120a;
import p471m6.C11423i;
import p514o9.C11827a;
import p514o9.C11839m;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import p684un.C13224c;
import p834z6.C14149i;
import sk.C12809f;
import tm.C13040c;

/* loaded from: classes2.dex */
public class ShareAlbumAllMsgActivity extends UIActivity implements View.OnClickListener {

    /* renamed from: p */
    public RecyclerView f10304p;

    /* renamed from: q */
    public C14149i f10305q;

    /* renamed from: r */
    public NotchTopFitRelativeLayout f10306r = null;

    /* renamed from: s */
    public NotchFitRelativeLayout f10307s = null;

    /* renamed from: t */
    public Handler f10308t = new HandlerC2215a();

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumAllMsgActivity$a */
    public class HandlerC2215a extends Handler {
        public HandlerC2215a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C11839m.m70688i("ShareAlbumAllMsgActivity", "handleMessage " + message.what);
            int i10 = message.what;
            if (i10 == 1028) {
                List<C11423i> list = (List) message.obj;
                ShareAlbumAllMsgActivity.this.f10305q.m84932D(list);
                C12091d.m72280a0().m72345b1(list);
                ShareAlbumAllMsgActivity.this.m13699P1();
                return;
            }
            if (i10 == 1045) {
                String str = (String) message.obj;
                if (TextUtils.isEmpty(str)) {
                    C11839m.m70687e("ShareAlbumAllMsgActivity", "host null ");
                    return;
                }
                try {
                    new HiCloudLink(ShareAlbumAllMsgActivity.this).flyTo("web", str + "/cch5/hidisk/sharedalbum/sharedalbum/index.html?country=" + C11827a.m70479d() + Constants.LANGUAGE + C0234s.m1632j());
                } catch (ActivityNotFoundException e10) {
                    C11839m.m70687e("ShareAlbumAllMsgActivity", "browser ActivityNotFoundException : " + e10);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumAllMsgActivity$b */
    public class C2216b extends AbstractC12367d {
        public C2216b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String strM78621M;
            try {
                strM78621M = C13040c.m78609F().m78621M();
            } catch (C9721b e10) {
                C11839m.m70687e("ShareAlbumAllMsgActivity", "getUrl exception:" + e10);
                strM78621M = "";
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1045;
            messageObtain.obj = strM78621M;
            ShareAlbumAllMsgActivity.this.f10308t.sendMessage(messageObtain);
        }
    }

    /* renamed from: O1 */
    private void m13697O1() {
        C12091d.m72280a0().m72326R(this.f10308t);
    }

    /* renamed from: N1 */
    public final void m13698N1() {
        C12515a.m75110o().m75175e(new C2216b(), false);
    }

    /* renamed from: P1 */
    public void m13699P1() {
        C1120a.m6677i("ShareAlbumAllMsgActivity", "sendRefreshBroadCase");
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.join.share.album.refresh");
        C13108a.m78878b(this).m78881d(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10307s);
        arrayList.add(this.f10306r);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 104) {
            C1120a.m6677i("ShareAlbumAllMsgActivity", "need refresh");
            m13697O1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 != R$id.view_button && id2 != R$id.rl_approval_item) {
            if (id2 == R$id.view_detail) {
                m13698N1();
                return;
            }
            return;
        }
        C11423i c11423iM84933E = this.f10305q.m84933E(((Integer) view.getTag()).intValue());
        if (c11423iM84933E.m68446c().getMessageType().intValue() == 1) {
            Intent intent = new Intent(this, (Class<?>) ShareAlbumApplicationInfoActivity.class);
            intent.putExtra("param_approval_id", c11423iM84933E.m68446c().getApplicantId());
            intent.putExtra("param_album_id", c11423iM84933E.m68446c().getAlbumId());
            startActivityForResult(intent, 104);
            return;
        }
        if (c11423iM84933E.m68446c().getMessageType().intValue() == 2) {
            Intent intent2 = new Intent(this, (Class<?>) ShareAlbumHomePageActivity.class);
            intent2.putExtra("param_album_id", c11423iM84933E.m68446c().getAlbumId());
            startActivityForResult(intent2, 104);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_share_album_msg);
        this.f10304p = (RecyclerView) C12809f.m76829b(this, R$id.rc_approve_list);
        this.f10306r = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10307s = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10304p.setLayoutManager(new LinearLayoutManager(this));
        this.f10305q = new C14149i(this, new View.OnClickListener() { // from class: k6.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52069a.onClick(view);
            }
        });
        C13224c.m79487f1().m79593q0("SHOW_ALBUM_ALL_MSG_PAGE");
        this.f10304p.setAdapter(this.f10305q);
        C11839m.m70688i("ShareAlbumAllMsgActivity", "onCreate");
        getActionBar().setTitle(R$string.album_msg);
        mo19005p1();
        mo19982C1();
        m13697O1();
    }
}
