package com.huawei.android.p069cg.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.drive.cloudphoto.model.Album;
import com.huawei.android.hicloud.drive.cloudphoto.model.Inviter;
import com.huawei.android.hicloud.drive.cloudphoto.model.Permission;
import com.huawei.android.hicloud.p088ui.activity.UIActivity;
import com.huawei.android.hicloud.p088ui.common.UnionSwitch;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout;
import com.huawei.android.p069cg.R$color;
import com.huawei.android.p069cg.R$dimen;
import com.huawei.android.p069cg.R$id;
import com.huawei.android.p069cg.R$layout;
import com.huawei.android.p069cg.R$string;
import com.huawei.android.p069cg.p071ui.UnionSwitchNetCheck;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0224k0;
import p031b7.C1120a;
import p031b7.C1136q;
import p031b7.C1140u;
import p336he.C10159j;
import p399jk.AbstractC10896a;
import p471m6.C11415a;
import p471m6.C11422h;
import p486n6.DialogC11637b;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p546p6.C12091d;
import p581qk.AbstractC12367d;
import p604r7.C12469b;
import p616rk.C12515a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;
import p834z6.C14148h;
import sk.C12809f;

/* loaded from: classes2.dex */
public class ShareAlbumManageActivity extends UIActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: n0 */
    public static final List<String> f10522n0 = Arrays.asList("father", "mother", "grandpa", "grandma", "grandfather", "grandmother");

    /* renamed from: A */
    public ImageView f10523A;

    /* renamed from: B */
    public RelativeLayout f10524B;

    /* renamed from: C */
    public ImageView f10525C;

    /* renamed from: D */
    public UnionSwitchNetCheck f10526D;

    /* renamed from: E */
    public UnionSwitch f10527E;

    /* renamed from: F */
    public AlertDialog f10528F;

    /* renamed from: G */
    public Button f10529G;

    /* renamed from: H */
    public Button f10530H;

    /* renamed from: I */
    public RelativeLayout f10531I;

    /* renamed from: J */
    public ImageView f10532J;

    /* renamed from: K */
    public RelativeLayout f10533K;

    /* renamed from: L */
    public RelativeLayout f10534L;

    /* renamed from: M */
    public RelativeLayout f10535M;

    /* renamed from: N */
    public Inviter f10536N;

    /* renamed from: O */
    public RelativeLayout f10537O;

    /* renamed from: P */
    public RelativeLayout f10538P;

    /* renamed from: Q */
    public RelativeLayout f10539Q;

    /* renamed from: R */
    public TextView f10540R;

    /* renamed from: S */
    public boolean f10541S;

    /* renamed from: T */
    public RecyclerView f10542T;

    /* renamed from: U */
    public TextView f10543U;

    /* renamed from: V */
    public TextView f10544V;

    /* renamed from: W */
    public Dialog f10545W;

    /* renamed from: X */
    public TextView f10546X;

    /* renamed from: Y */
    public List<C11422h> f10547Y;

    /* renamed from: Z */
    public String f10548Z;

    /* renamed from: a0 */
    public String f10549a0;

    /* renamed from: b0 */
    public String f10550b0;

    /* renamed from: c0 */
    public String f10551c0;

    /* renamed from: d0 */
    public String f10552d0;

    /* renamed from: e0 */
    public boolean f10553e0;

    /* renamed from: f0 */
    public List<C11422h> f10554f0;

    /* renamed from: g0 */
    public String f10555g0;

    /* renamed from: h0 */
    public String f10556h0;

    /* renamed from: j0 */
    public C11415a f10558j0;

    /* renamed from: k0 */
    public List<C11422h> f10559k0;

    /* renamed from: p */
    public RecyclerView f10562p;

    /* renamed from: q */
    public C14148h f10563q;

    /* renamed from: r */
    public C14148h f10564r;

    /* renamed from: u */
    public TextView f10567u;

    /* renamed from: v */
    public TextView f10568v;

    /* renamed from: w */
    public TextView f10569w;

    /* renamed from: x */
    public ImageView f10570x;

    /* renamed from: y */
    public TextView f10571y;

    /* renamed from: z */
    public TextView f10572z;

    /* renamed from: s */
    public NotchTopFitRelativeLayout f10565s = null;

    /* renamed from: t */
    public NotchFitRelativeLayout f10566t = null;

    /* renamed from: i0 */
    public boolean f10557i0 = false;

    /* renamed from: l0 */
    public Intent f10560l0 = new Intent();

    /* renamed from: m0 */
    public Handler f10561m0 = new HandlerC2240a();

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumManageActivity$a */
    public class HandlerC2240a extends Handler {
        public HandlerC2240a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C1120a.m6675d("ShareAlbumManageActivity", "handleMessage what: " + message.what);
            int i10 = message.what;
            if (i10 == 1005) {
                if (message.arg1 == 4312) {
                    ShareAlbumManageActivity shareAlbumManageActivity = ShareAlbumManageActivity.this;
                    C11841o.m70706b(shareAlbumManageActivity, shareAlbumManageActivity.getString(R$string.server_error), 0);
                }
                List list = (List) message.obj;
                if (list.isEmpty()) {
                    ShareAlbumManageActivity.this.f10531I.setVisibility(8);
                    return;
                } else {
                    ShareAlbumManageActivity.this.f10531I.setVisibility(0);
                    ShareAlbumManageActivity.this.f10567u.setText(ShareAlbumManageActivity.this.getString(R$string.album_people_waiting_approval, String.valueOf(list.size())));
                    return;
                }
            }
            if (i10 == 1007) {
                if (message.arg1 == 4312) {
                    ShareAlbumManageActivity shareAlbumManageActivity2 = ShareAlbumManageActivity.this;
                    C11841o.m70706b(shareAlbumManageActivity2, shareAlbumManageActivity2.getString(R$string.server_error), 0);
                }
                List list2 = (List) message.obj;
                if (list2 == null || list2.size() == 0) {
                    return;
                }
                ShareAlbumManageActivity.this.m13919n2(list2);
                ShareAlbumManageActivity.this.m13918m2();
                return;
            }
            if (i10 == 1009) {
                ShareAlbumManageActivity.this.f10558j0 = (C11415a) message.obj;
                ShareAlbumManageActivity.this.f10560l0.putExtra("param_media_id", ShareAlbumManageActivity.this.f10558j0.m68362a().getCoverImage());
                ShareAlbumManageActivity.this.m13916k2();
                return;
            }
            if (i10 == 2000) {
                C12091d.m72280a0().m72359i1(ShareAlbumManageActivity.this);
                return;
            }
            if (i10 == 1041) {
                ShareAlbumManageActivity.this.setResult(102);
                ShareAlbumManageActivity.this.finish();
                return;
            }
            if (i10 == 1003) {
                ShareAlbumManageActivity.this.f10536N = (Inviter) message.obj;
                if (ShareAlbumManageActivity.this.f10536N != null) {
                    ShareAlbumManageActivity shareAlbumManageActivity3 = ShareAlbumManageActivity.this;
                    shareAlbumManageActivity3.f10555g0 = shareAlbumManageActivity3.f10536N.getInviterId();
                    TextView textView = ShareAlbumManageActivity.this.f10540R;
                    ShareAlbumManageActivity shareAlbumManageActivity4 = ShareAlbumManageActivity.this;
                    textView.setText(shareAlbumManageActivity4.getString(R$string.album_manage_invitate_code, shareAlbumManageActivity4.f10555g0));
                    ShareAlbumManageActivity.this.f10539Q.setVisibility(0);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumManageActivity$b */
    public class C2241b extends AbstractC12367d {
        public C2241b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            String str;
            String str2;
            String strM80971t0 = C13452e.m80781L().m80971t0();
            String kinship = "";
            if (ShareAlbumManageActivity.this.f10558j0 != null) {
                String remark = "";
                for (Permission permission : ShareAlbumManageActivity.this.f10558j0.m68362a().getPermissions()) {
                    if (TextUtils.equals(permission.getUserId(), strM80971t0)) {
                        kinship = permission.getKinship();
                        remark = permission.getRemark();
                    }
                }
                str = kinship;
                str2 = remark;
            } else {
                str = "";
                str2 = str;
            }
            try {
                Inviter inviterM74749c = C12469b.m74746l().m74749c(ShareAlbumManageActivity.this.f10548Z, str, str2, "upload", Inviter.INVITE_CODE, true);
                if (inviterM74749c != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1003;
                    messageObtain.obj = inviterM74749c;
                    ShareAlbumManageActivity.this.f10561m0.sendMessage(messageObtain);
                }
            } catch (Exception e10) {
                C1120a.m6677i("ShareAlbumManageActivity", "initData inviter " + e10.getMessage());
            }
        }
    }

    /* renamed from: com.huawei.android.cg.activity.ShareAlbumManageActivity$c */
    public static class DialogInterfaceOnClickListenerC2242c implements DialogInterface.OnClickListener {

        /* renamed from: a */
        public boolean f10575a;

        /* renamed from: b */
        public Activity f10576b;

        /* renamed from: c */
        public int f10577c;

        /* renamed from: d */
        public String f10578d;

        /* renamed from: e */
        public String f10579e;

        /* renamed from: f */
        public Handler f10580f;

        public DialogInterfaceOnClickListenerC2242c(Activity activity, boolean z10, String str, String str2, int i10, Handler handler) {
            this.f10575a = z10;
            this.f10576b = activity;
            this.f10578d = str;
            this.f10579e = str2;
            this.f10577c = i10;
            this.f10580f = handler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f10576b == null) {
                AbstractC10896a.m65887i("ShareAlbumManageActivity", "mActivity null");
                return;
            }
            if (!this.f10575a) {
                AbstractC10896a.m65887i("ShareAlbumManageActivity", "dialog cancel");
                return;
            }
            if (this.f10577c == 0) {
                C11839m.m70688i("ShareAlbumManageActivity", "delete shareAlbumId:" + this.f10578d);
                C13224c.m79487f1().m79593q0("CLICK_SHARE_ALBUM_DELETE");
                C12091d.m72280a0().m72389u(this.f10578d, this.f10580f, this.f10576b);
                return;
            }
            C11839m.m70688i("ShareAlbumManageActivity", "quit shareAlbumId:" + this.f10578d);
            C13224c.m79487f1().m79593q0("CLICK_SHARE_ALBUM_QUIT");
            C12091d.m72280a0().m72339X0(this.f10578d, this.f10579e, this.f10580f);
        }
    }

    /* renamed from: B1 */
    private void m13890B1() {
        if (this.f10541S) {
            this.f10543U.setText(R$string.album_manage_title);
        } else {
            this.f10543U.setText(R$string.setting_general_title);
        }
    }

    /* renamed from: i2 */
    private void m13907i2() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            Toast.makeText(this, R$string.alert_net_disconnect_20160420, 0).show();
        }
        C12091d.m72280a0().m72320O(this.f10548Z, this.f10561m0);
        C12091d.m72280a0().m72344b0(this.f10548Z, this.f10561m0);
        C11415a c11415a = this.f10558j0;
        if (c11415a != null && c11415a.m68362a() != null) {
            C12091d.m72280a0().m72324Q(this.f10548Z, this.f10558j0.m68362a().getAlbumOwnerId(), this.f10561m0);
        }
        C12515a.m75110o().m75175e(new C2241b(), false);
    }

    /* renamed from: b2 */
    public final List<C11422h> m13908b2(List<C11422h> list) {
        HashMap map = new HashMap();
        for (C11422h c11422h : list) {
            c11422h.m68439e(false);
            map.put(c11422h.m68436b().getKinship(), c11422h);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        for (String str : f10522n0) {
            if (map.containsKey(str)) {
                C11422h c11422h2 = (C11422h) map.get(str);
                if (TextUtils.equals(this.f10556h0, c11422h2.m68436b().getKinship())) {
                    arrayList.add(c11422h2);
                } else if (TextUtils.equals(strM80971t0, c11422h2.m68436b().getUserId())) {
                    arrayList2.add(c11422h2);
                } else {
                    arrayList3.add(c11422h2);
                }
            } else {
                arrayList4.add(m13912f2(str));
            }
        }
        ArrayList arrayList5 = new ArrayList();
        arrayList5.addAll(arrayList);
        arrayList5.addAll(arrayList2);
        arrayList5.addAll(arrayList3);
        arrayList5.addAll(arrayList4);
        return arrayList5;
    }

    /* renamed from: c2 */
    public final void m13909c2(View view) {
        if (this.f10541S) {
            Intent intent = new Intent(this, (Class<?>) AlbumShareInviteActivity.class);
            intent.putExtra("param_album_id", this.f10548Z);
            if (view.getTag() == null) {
                return;
            }
            int iIntValue = ((Integer) view.getTag()).intValue();
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            if (this.f10553e0) {
                C11422h c11422h = this.f10554f0.get(iIntValue);
                if (c11422h != null) {
                    intent.putExtra("param_album_relation", c11422h.m68435a());
                }
                linkedHashMapM79497A.put("album_invite_src", "3");
            } else {
                linkedHashMapM79497A.put("album_invite_src", "2");
            }
            linkedHashMapM79497A.put("album_type", String.valueOf(this.f10558j0.m68362a().getType()));
            C13224c.m79487f1().m79594r0("SHOW_INVITE_DETAIL_PAGE", linkedHashMapM79497A);
            startActivity(intent);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: d1 */
    public List<View> mo13289d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f10566t);
        arrayList.add(this.f10565s);
        return arrayList;
    }

    /* renamed from: d2 */
    public final void m13910d2(View view) {
        if (this.f10541S) {
            Intent intent = new Intent(this, (Class<?>) ShareAlbumMemberManagActivity.class);
            int iIntValue = ((Integer) view.getTag()).intValue();
            C11422h c11422h = this.f10553e0 ? this.f10554f0.get(iIntValue) : this.f10559k0.get(iIntValue);
            intent.putExtra("param_owner_id", this.f10558j0.m68362a().getAlbumOwnerId());
            intent.putExtra("param_member_id", c11422h.m68436b().getId());
            intent.putExtra("param_user_id", c11422h.m68436b().getUserId());
            intent.putExtra("param_album_id", this.f10548Z);
            C0224k0.m1544N(this, intent, 103);
        }
    }

    /* renamed from: e2 */
    public final void m13911e2(View view) {
        C11415a c11415a;
        int id2 = view.getId();
        if (id2 == R$id.rl_inivite_content) {
            m13930y2();
            return;
        }
        if (id2 == R$id.album_delete_button) {
            m13927v2();
            return;
        }
        if (id2 == R$id.rl_add) {
            m13909c2(view);
            return;
        }
        if (id2 == R$id.album_quit_button) {
            m13929x2();
            return;
        }
        if (id2 == R$id.member_layout) {
            if ((this.f10553e0 && !TextUtils.equals(this.f10551c0, "other")) || (c11415a = this.f10558j0) == null || c11415a.m68362a() == null) {
                return;
            }
            Intent intent = new Intent(this, (Class<?>) ShareAlbumInfoTypingctivity.class);
            intent.putExtra("typing_source", 103);
            intent.putExtra("param_album_id", this.f10548Z);
            intent.putExtra("param_owner_id", this.f10558j0.m68362a().getAlbumOwnerId());
            intent.putExtra("param_applicant_remark", this.f10572z.getText());
            intent.putExtra("param_permission_user_id", C13452e.m80781L().m80971t0());
            startActivityForResult(intent, 103);
        }
    }

    /* renamed from: f2 */
    public final C11422h m13912f2(String str) {
        C11422h c11422h = new C11422h();
        c11422h.m68441g(str);
        c11422h.m68440f(true);
        return c11422h;
    }

    /* renamed from: g2 */
    public final void m13913g2(List<C11422h> list, String str, String str2) {
        if (TextUtils.equals(str2, str)) {
            return;
        }
        Iterator<C11422h> it = list.iterator();
        int i10 = 0;
        while (it.hasNext() && !TextUtils.equals(it.next().m68436b().getUserId(), str2)) {
            i10++;
        }
        this.f10559k0.add(list.get(i10));
        list.remove(i10);
    }

    /* renamed from: h2 */
    public final void m13914h2(boolean z10, boolean z11) {
        if (z10) {
            this.f10529G.setVisibility(0);
            this.f10530H.setVisibility(8);
            this.f10533K.setVisibility(8);
            return;
        }
        this.f10529G.setVisibility(8);
        this.f10530H.setVisibility(0);
        this.f10531I.setVisibility(8);
        this.f10533K.setVisibility(0);
        if (z11) {
            this.f10571y.setText(getString(R$string.album_baby_relationship));
        } else {
            this.f10571y.setText(getString(R$string.album_my_remark));
        }
        m13925t2();
    }

    /* renamed from: j2 */
    public final boolean m13915j2() {
        return (this.f10558j0 == null || this.f10559k0 == null) ? false : true;
    }

    /* renamed from: k2 */
    public final void m13916k2() {
        this.f10568v.setText(this.f10558j0.m68363b());
        this.f10553e0 = this.f10558j0.m68362a().getShareType().intValue() == 1;
        m13928w2();
        m13923r2();
        this.f10546X.setText(getString(this.f10553e0 ? R$string.space_display_family_title : R$string.album_member));
        String albumOwnerId = this.f10558j0.m68362a().getAlbumOwnerId();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        for (Permission permission : this.f10558j0.m68362a().getPermissions()) {
            if (TextUtils.equals(permission.getUserId(), strM80971t0)) {
                this.f10552d0 = permission.getId();
            }
        }
        boolean zEquals = TextUtils.equals(albumOwnerId, strM80971t0);
        this.f10541S = zEquals;
        m13914h2(zEquals, this.f10553e0);
        m13890B1();
    }

    /* renamed from: l2 */
    public final void m13917l2(List<C11422h> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        m13919n2(arrayList);
        m13916k2();
        m13918m2();
    }

    /* renamed from: m2 */
    public final void m13918m2() {
        C1120a.m6675d("ShareAlbumManageActivity", "refreshMemberData");
        if (m13915j2()) {
            String albumOwnerId = this.f10558j0.m68362a().getAlbumOwnerId();
            this.f10541S = TextUtils.equals(albumOwnerId, C13452e.m80781L().m80971t0());
            C11839m.m70688i("ShareAlbumManageActivity", "refreshMemberData: isBaby:" + this.f10553e0 + "isOwner: " + this.f10541S);
            m13926u2();
            m13924s2(this.f10541S);
            boolean z10 = this.f10541S;
            if (z10 && !this.f10553e0) {
                C11422h c11422h = new C11422h();
                c11422h.m68439e(true);
                this.f10559k0.add(c11422h);
                this.f10563q.m84929E(this.f10558j0);
                this.f10563q.m84928D(this.f10559k0);
                this.f10526D.setCheckedProgrammatically(this.f10558j0.m68362a().getPrivilege().intValue() == 0);
                return;
            }
            if (!z10 && !this.f10553e0) {
                this.f10563q.m84929E(this.f10558j0);
                this.f10563q.m84928D(this.f10559k0);
                this.f10537O.setVisibility(8);
                this.f10538P.setVisibility(8);
                return;
            }
            if (this.f10553e0) {
                this.f10547Y = new ArrayList();
                ArrayList arrayList = new ArrayList();
                for (C11422h c11422h2 : this.f10559k0) {
                    Permission permissionM68436b = c11422h2.m68436b();
                    if (permissionM68436b != null) {
                        if (TextUtils.equals(albumOwnerId, permissionM68436b.getUserId())) {
                            this.f10556h0 = c11422h2.m68436b().getKinship();
                        }
                        if (TextUtils.equals(permissionM68436b.getKinship(), "other") || TextUtils.isEmpty(permissionM68436b.getKinship())) {
                            this.f10547Y.add(c11422h2);
                        } else {
                            arrayList.add(c11422h2);
                        }
                    }
                }
                if (!this.f10541S) {
                    m13920o2(arrayList);
                    return;
                }
                this.f10526D.setCheckedProgrammatically(this.f10558j0.m68362a().getPrivilege().intValue() == 0);
                this.f10534L.setVisibility(0);
                this.f10535M.setVisibility(0);
                C11422h c11422h3 = new C11422h();
                c11422h3.m68439e(true);
                this.f10547Y.add(c11422h3);
                this.f10534L.setVisibility(0);
                this.f10535M.setVisibility(0);
                this.f10564r.m84929E(this.f10558j0);
                this.f10564r.m84928D(this.f10547Y);
                this.f10554f0 = m13908b2(arrayList);
                this.f10563q.m84929E(this.f10558j0);
                this.f10563q.m84928D(this.f10554f0);
            }
        }
    }

    /* renamed from: n2 */
    public final void m13919n2(List<C11422h> list) {
        m13931z2(list);
    }

    /* renamed from: o2 */
    public final void m13920o2(List<C11422h> list) {
        this.f10537O.setVisibility(8);
        this.f10538P.setVisibility(8);
        if (this.f10547Y.size() > 0) {
            this.f10534L.setVisibility(0);
            this.f10535M.setVisibility(0);
            this.f10564r.m84929E(this.f10558j0);
            this.f10564r.m84928D(this.f10547Y);
        } else {
            this.f10535M.setVisibility(8);
            this.f10534L.setVisibility(8);
        }
        if (list.size() > 0) {
            this.f10563q.m84929E(this.f10558j0);
            this.f10563q.m84928D(list);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        C1120a.m6677i("ShareAlbumManageActivity", "onActivityResult requestCode: " + i10 + ", resultCode: " + i11);
        super.onActivityResult(i10, i11, intent);
        if (i10 == 105) {
            C12091d.m72280a0().m72320O(this.f10548Z, this.f10561m0);
            this.f10557i0 = true;
        }
        if (i10 == 104) {
            C1120a.m6677i("ShareAlbumManageActivity", "need refresh");
            m13907i2();
        }
        if (i11 == 101) {
            m13907i2();
            this.f10557i0 = true;
        }
        if (i10 == 103 && i11 == -1) {
            this.f10572z.setText(new SafeIntent(intent).getStringExtra("result"));
            this.f10557i0 = true;
            m13907i2();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int id2 = compoundButton.getId();
        if (id2 == R$id.upload_switch) {
            C11415a c11415a = this.f10558j0;
            if (c11415a == null) {
                C1120a.m6678w("ShareAlbumManageActivity", "onCheckedChanged album is null");
                return;
            }
            Album albumM68362a = c11415a.m68362a();
            if (z10) {
                albumM68362a.setPrivilege(0);
            } else {
                albumM68362a.setPrivilege(1);
            }
            C12091d.m72280a0().m72317M0(albumM68362a, this.f10561m0, this);
            return;
        }
        if (id2 == R$id.top_switch) {
            if (z10) {
                C13224c.m79487f1().m79593q0("CLICK_SHARE_ALBUM_MANAGE_TOP_SWITH");
                this.f10549a0 = this.f10548Z;
                C11841o.m70706b(this, getString(R$string.album_top_msg), 0);
            } else {
                this.f10549a0 = "";
                C11841o.m70706b(this, getString(R$string.album_cancel_top_msg), 0);
            }
            C1136q.d.m7134K(this.f10549a0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.ic_back_hot_space) {
            if (this.f10557i0) {
                setResult(101, this.f10560l0);
            }
            finish();
        }
        if (C1140u.m7195g(this)) {
            return;
        }
        if (id2 == R$id.tv_num_to_approve) {
            Intent intent = new Intent(this, (Class<?>) ShareAlbumApprovalManageActivity.class);
            intent.putExtra("param_album_id", this.f10548Z);
            startActivityForResult(intent, 104);
            return;
        }
        if (id2 == R$id.ic_member_head) {
            m13910d2(view);
            return;
        }
        if (id2 != R$id.rl_album_top && id2 != R$id.ic_share_cover && id2 != R$id.baby_cover && id2 != R$id.tv_effect_date && id2 != R$id.tv_name) {
            m13911e2(view);
        } else if (this.f10541S) {
            Intent intent2 = new Intent(this, (Class<?>) ShareAlbumInfoEditActivity.class);
            intent2.putExtra("param_album_id", this.f10548Z);
            startActivityForResult(intent2, 105);
        }
    }

    public void onClick2(View view) {
        if (C0209d.m1226Y0() || C1140u.m7195g(this)) {
            return;
        }
        int id2 = view.getId();
        if (id2 == R$id.ic_member_head) {
            if (this.f10541S) {
                Intent intent = new Intent(this, (Class<?>) ShareAlbumMemberManagActivity.class);
                C11422h c11422h = this.f10547Y.get(((Integer) view.getTag()).intValue());
                intent.putExtra("param_album_id", this.f10548Z);
                intent.putExtra("param_member_id", c11422h.m68436b().getId());
                intent.putExtra("param_user_id", c11422h.m68436b().getUserId());
                C0224k0.m1544N(this, intent, 103);
                return;
            }
            return;
        }
        if (id2 == R$id.rl_add) {
            Intent intent2 = new Intent(this, (Class<?>) AlbumShareInviteActivity.class);
            intent2.putExtra("param_album_id", this.f10548Z);
            intent2.putExtra("param_album_relation", "other");
            startActivity(intent2);
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("album_invite_src", "4");
            linkedHashMapM79497A.put("album_type", String.valueOf(this.f10558j0.m68362a().getType()));
            C13224c.m79487f1().m79594r0("SHOW_INVITE_DETAIL_PAGE", linkedHashMapM79497A);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m13925t2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10548Z = new C10343b(new SafeIntent(getIntent()).getExtras()).m63694p("param_album_id");
        setContentView(R$layout.activity_album_manager);
        this.f10562p = (RecyclerView) C12809f.m76829b(this, R$id.rc_member_list);
        this.f10565s = (NotchTopFitRelativeLayout) C12809f.m76829b(this, R$id.top_notch_fit_layout);
        this.f10566t = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f10567u = (TextView) C12809f.m76829b(this, R$id.tv_num_to_approve);
        UnionSwitchNetCheck unionSwitchNetCheck = (UnionSwitchNetCheck) C12809f.m76829b(this, R$id.upload_switch);
        this.f10526D = unionSwitchNetCheck;
        unionSwitchNetCheck.setOnCheckedChangeListener(this);
        UnionSwitch unionSwitch = (UnionSwitch) C12809f.m76829b(this, R$id.top_switch);
        this.f10527E = unionSwitch;
        unionSwitch.setOnCheckedChangeListener(this);
        this.f10537O = (RelativeLayout) C12809f.m76829b(this, R$id.rl_upload);
        this.f10538P = (RelativeLayout) C12809f.m76829b(this, R$id.rl_upload_desc);
        this.f10531I = (RelativeLayout) C12809f.m76829b(this, R$id.owner_layout);
        this.f10532J = (ImageView) C12809f.m76829b(this, R$id.member_item_image);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76829b(this, R$id.member_layout);
        this.f10533K = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: k6.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52075a.onClick(view);
            }
        });
        this.f10571y = (TextView) C12809f.m76829b(this, R$id.my_album_name);
        this.f10572z = (TextView) C12809f.m76829b(this, R$id.my_album_name_value);
        this.f10534L = (RelativeLayout) C12809f.m76829b(this, R$id.rl_other_title);
        this.f10535M = (RelativeLayout) C12809f.m76829b(this, R$id.rl_other_member);
        RecyclerView recyclerView = (RecyclerView) C12809f.m76829b(this, R$id.rc_other_list);
        this.f10542T = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        C14148h c14148h = new C14148h(this, new View.OnClickListener() { // from class: k6.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f52076a.onClick2(view);
            }
        });
        this.f10564r = c14148h;
        this.f10542T.setAdapter(c14148h);
        List<C11422h> listM72316M = C12091d.m72280a0().m72316M();
        this.f10558j0 = C12091d.m72280a0().m72338X();
        this.f10539Q = (RelativeLayout) C12809f.m76829b(this, R$id.rl_invite_code);
        ((RelativeLayout) C12809f.m76829b(this, R$id.rl_inivite_content)).setOnClickListener(this);
        this.f10540R = (TextView) C12809f.m76829b(this, R$id.tv_invite_code);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.tv_name);
        this.f10568v = textView;
        textView.setOnClickListener(this);
        this.f10569w = (TextView) C12809f.m76829b(this, R$id.tv_effect_date);
        this.f10570x = (ImageView) C12809f.m76829b(this, R$id.head_arrow);
        ((RelativeLayout) C12809f.m76829b(this, R$id.rl_album_top)).setOnClickListener(this);
        this.f10569w.setOnClickListener(this);
        this.f10567u.setOnClickListener(this);
        ImageView imageView = (ImageView) C12809f.m76829b(this, R$id.ic_share_cover);
        this.f10523A = imageView;
        imageView.setOnClickListener(this);
        this.f10524B = (RelativeLayout) C12809f.m76829b(this, R$id.rl_share_cover);
        ImageView imageView2 = (ImageView) C12809f.m76829b(this, R$id.ic_baby_cover);
        this.f10525C = imageView2;
        imageView2.setOnClickListener(this);
        this.f10562p.setLayoutManager(new GridLayoutManager(this, 4));
        this.f10563q = new C14148h(this, this);
        Button button = (Button) C12809f.m76829b(this, R$id.album_delete_button);
        this.f10529G = button;
        button.setOnClickListener(this);
        Button button2 = (Button) C12809f.m76829b(this, R$id.album_quit_button);
        this.f10530H = button2;
        button2.setOnClickListener(this);
        this.f10562p.setAdapter(this.f10563q);
        C12809f.m76829b(this, R$id.ic_back_hot_space).setOnClickListener(this);
        this.f10543U = (TextView) C12809f.m76829b(this, R$id.action_bar_title);
        View viewM76829b = C12809f.m76829b(this, R$id.action_bar_end_task_frm);
        viewM76829b.setOnClickListener(this);
        viewM76829b.setVisibility(0);
        this.f10544V = (TextView) C12809f.m76829b(this, R$id.action_bar_end_task);
        String strM7155s = C1136q.d.m7155s();
        this.f10549a0 = strM7155s;
        this.f10527E.setCheckedProgrammatically(TextUtils.equals(this.f10548Z, strM7155s));
        this.f10546X = (TextView) C12809f.m76829b(this, R$id.tv_member);
        m13917l2(listM72316M);
        C11839m.m70688i("ShareAlbumManageActivity", "onCreate: " + this.f10548Z);
        mo19005p1();
        m22368H1();
        m13907i2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f10528F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyDown(i10, keyEvent);
        }
        C11839m.m70688i("ShareAlbumManageActivity", "onBack Pressed");
        if (this.f10557i0) {
            setResult(101, this.f10560l0);
            finish();
        }
        return mo13429v1(i10, keyEvent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            C11839m.m70688i("ShareAlbumManageActivity", "onHome Pressed");
            if (this.f10557i0) {
                setResult(101, this.f10560l0);
                finish();
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C13224c.m79487f1().m79593q0("SHOW_SHARE_ALBUM_MANAGE");
    }

    /* renamed from: p2 */
    public final void m13921p2() {
        if (TextUtils.equals(this.f10551c0, "other")) {
            this.f10532J.setVisibility(0);
        } else {
            this.f10532J.setVisibility(4);
        }
    }

    /* renamed from: q2 */
    public final void m13922q2(C11422h c11422h, String str) {
        if (!TextUtils.equals(this.f10551c0, "other") && !TextUtils.isEmpty(c11422h.m68436b().getKinship())) {
            this.f10572z.setText(C1140u.m7193e(this, this.f10551c0));
        } else if (TextUtils.isEmpty(str)) {
            this.f10572z.setText(c11422h.m68436b().getDisplayName());
        } else {
            this.f10572z.setText(str);
        }
    }

    /* renamed from: r2 */
    public final void m13923r2() {
        C4644l createdTime = this.f10558j0.m68362a().getCreatedTime();
        if (createdTime != null) {
            this.f10569w.setText(getString(R$string.album_create_time, C10159j.m63334j(new Date(createdTime.m28458c()))));
        }
        boolean z10 = this.f10558j0.m68362a().getShareType().intValue() == 1;
        this.f10553e0 = z10;
        if (z10) {
            C4644l birthday = this.f10558j0.m68362a().getBabyInfo().getBirthday();
            if (birthday != null) {
                this.f10569w.setText(C12091d.m72280a0().m72332U(this, System.currentTimeMillis(), birthday.m28458c()));
            }
            m13921p2();
        }
    }

    /* renamed from: s2 */
    public final void m13924s2(boolean z10) {
        if (z10) {
            this.f10570x.setVisibility(0);
        } else {
            this.f10570x.setVisibility(8);
        }
    }

    /* renamed from: t2 */
    public final void m13925t2() {
        Resources resources = getResources();
        if (resources == null) {
            return;
        }
        int iM70752O = resources.getConfiguration().orientation == 2 ? C11842p.m70752O(this) : C11842p.m70758Q(this);
        TextView textView = this.f10571y;
        if (textView == null) {
            return;
        }
        int desiredWidth = (iM70752O - ((int) Layout.getDesiredWidth(this.f10571y.getText(), 0, this.f10571y.getText().length(), textView.getPaint()))) - (resources.getDimensionPixelSize(R$dimen.cloud_space_16_dp) * 2);
        int i10 = R$dimen.cloud_space_12_dp;
        this.f10572z.setMaxWidth((desiredWidth - (resources.getDimensionPixelSize(i10) * 2)) - (resources.getDimensionPixelSize(i10) * 2));
    }

    /* renamed from: u2 */
    public final void m13926u2() {
        for (C11422h c11422h : this.f10559k0) {
            if (TextUtils.equals(c11422h.m68436b().getUserId(), C13452e.m80781L().m80971t0())) {
                this.f10550b0 = c11422h.m68436b().getUserId();
                this.f10552d0 = c11422h.m68436b().getId();
                this.f10551c0 = c11422h.m68436b().getKinship();
                String remark = c11422h.m68436b().getRemark();
                if (TextUtils.isEmpty(remark)) {
                    this.f10572z.setText(c11422h.m68436b().getDisplayName());
                } else {
                    this.f10572z.setText(remark);
                }
                if (this.f10553e0) {
                    m13922q2(c11422h, remark);
                    return;
                }
                return;
            }
        }
    }

    /* renamed from: v2 */
    public final void m13927v2() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(getString(R$string.album_delete_notice)).setPositiveButton(R$string.album_delete_button, new DialogInterfaceOnClickListenerC2242c(this, true, this.f10548Z, this.f10552d0, 0, this.f10561m0)).setNegativeButton(R$string.cancel, new DialogInterfaceOnClickListenerC2242c(this, false, this.f10548Z, this.f10552d0, 0, this.f10561m0)).create();
        this.f10528F = alertDialogCreate;
        alertDialogCreate.show();
        this.f10528F.getButton(-1).setTextColor(getColor(R$color.album_delete_member_color));
        this.f10528F.getButton(-2).setTextColor(getColor(R$color.color_0091ff));
    }

    /* renamed from: w2 */
    public final void m13928w2() {
        C1120a.m6677i("ShareAlbumManageActivity", "showHeadPic isBaby: " + this.f10553e0);
        if (this.f10553e0) {
            this.f10523A.setVisibility(8);
            this.f10524B.setVisibility(8);
            this.f10525C.setVisibility(0);
            C1140u.m7201m(this, this.f10558j0.m68362a(), this.f10525C);
            return;
        }
        this.f10523A.setVisibility(0);
        this.f10524B.setVisibility(0);
        this.f10525C.setVisibility(8);
        C1140u.m7204p(this, this.f10558j0.m68362a(), this.f10523A);
    }

    /* renamed from: x2 */
    public final void m13929x2() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            C1140u.m7197i(this);
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).setMessage(getString(R$string.album_exit_notice)).setPositiveButton(R$string.album_exit_button, new DialogInterfaceOnClickListenerC2242c(this, true, this.f10548Z, this.f10552d0, 1, this.f10561m0)).setNegativeButton(R$string.cancel, new DialogInterfaceOnClickListenerC2242c(this, false, this.f10548Z, this.f10552d0, 1, this.f10561m0)).create();
        this.f10528F = alertDialogCreate;
        alertDialogCreate.show();
        this.f10528F.getButton(-1).setTextColor(getColor(R$color.album_delete_member_color));
        this.f10528F.getButton(-2).setTextColor(getColor(R$color.color_0091ff));
    }

    /* renamed from: y2 */
    public final void m13930y2() {
        if (TextUtils.isEmpty(this.f10555g0)) {
            return;
        }
        String strM7192d = C1140u.m7192d(this.f10555g0);
        DialogC11637b dialogC11637b = new DialogC11637b(this, this.f10558j0.m68362a(), this.f10555g0, strM7192d);
        this.f10545W = dialogC11637b;
        dialogC11637b.show();
        C13224c.m79487f1().m79593q0("SHOW_MANAGE_INVITE_CODE_DIALOG");
        C1140u.m7189a(this, strM7192d);
    }

    /* renamed from: z2 */
    public final void m13931z2(List<C11422h> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String albumOwnerId = this.f10558j0.m68362a().getAlbumOwnerId();
        Iterator<C11422h> it = list.iterator();
        int i10 = 0;
        while (it.hasNext() && !TextUtils.equals(it.next().m68436b().getUserId(), albumOwnerId)) {
            i10++;
        }
        ArrayList arrayList = new ArrayList();
        this.f10559k0 = arrayList;
        arrayList.add(list.get(i10));
        list.remove(i10);
        m13913g2(list, albumOwnerId, C13452e.m80781L().m80971t0());
        this.f10559k0.addAll(list);
    }
}
