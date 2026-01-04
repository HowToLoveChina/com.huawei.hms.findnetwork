package ae;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudSpaceShareUsageBaseAdapter;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.FamilyDetailInfo;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p035bk.C1248a;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p616rk.C12515a;
import p709vj.C13452e;
import p732w8.C13555f;
import sk.C12806c;
import sk.C12809f;

/* renamed from: ae.x0 */
/* loaded from: classes3.dex */
public class C0180x0 extends CloudSpaceShareUsageBaseAdapter {

    /* renamed from: d */
    public Handler f697d;

    /* renamed from: ae.x0$a */
    public class a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ FamilyDetailInfo f698a;

        public a(FamilyDetailInfo familyDetailInfo) {
            this.f698a = familyDetailInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("CloudSpaceShareUsageOwnerAdapter", "familyInviteButton click too fast");
            } else {
                C0180x0.this.m990d(this.f698a.getUid());
            }
        }
    }

    /* renamed from: ae.x0$b */
    public static class b {

        /* renamed from: a */
        public ImageView f700a;

        /* renamed from: b */
        public RelativeLayout f701b;

        /* renamed from: c */
        public RelativeLayout f702c;

        /* renamed from: d */
        public TextView f703d;

        /* renamed from: e */
        public TextView f704e;

        /* renamed from: f */
        public TextView f705f;

        /* renamed from: g */
        public HwButton f706g;

        /* renamed from: h */
        public View f707h;

        public b() {
        }

        /* renamed from: q */
        public ImageView m1007q() {
            return this.f700a;
        }

        /* renamed from: r */
        public TextView m1008r() {
            return this.f703d;
        }

        /* renamed from: s */
        public TextView m1009s() {
            return this.f704e;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public C0180x0(Context context, Handler handler) {
        super(context);
        this.f697d = handler;
    }

    /* renamed from: c */
    private int m988c() {
        return ((this.f18709c instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f18709c)) ? C11842p.m70857r0() : C11842p.m70877w0();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.CloudSpaceShareUsageBaseAdapter
    /* renamed from: a */
    public void mo989a(List<FamilyDetailInfo> list) {
        super.mo989a(list);
    }

    /* renamed from: d */
    public final void m990d(long j10) {
        if (this.f697d == null) {
            return;
        }
        Context context = this.f18709c;
        if (context == null || C0209d.m1333z1(context)) {
            Message messageObtainMessage = this.f697d.obtainMessage();
            messageObtainMessage.what = FamilyShareConstants.MessageCode.GET_USERPACKAGE_FOR_INVITE_FAMILY_MEMBER;
            messageObtainMessage.obj = Long.valueOf(j10);
            this.f697d.sendMessage(messageObtainMessage);
            return;
        }
        Message messageObtain = Message.obtain(this.f697d);
        messageObtain.what = FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
        messageObtain.arg1 = 1105;
        this.f697d.sendMessage(messageObtain);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18708b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (i10 < 0 || i10 >= this.f18708b.size()) {
            return null;
        }
        return this.f18708b.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewM76832e;
        b bVar;
        Bitmap bitmapM70501B = null;
        byte b10 = 0;
        if (view == null) {
            bVar = new b(b10 == true ? 1 : 0);
            viewM76832e = C0209d.m1195O(this.f18709c) >= 2.0f ? C12809f.m76832e(this.f18707a, R$layout.family_owner_list_item_font_scale) : C12809f.m76832e(this.f18707a, R$layout.family_owner_list_item);
            bVar.f700a = (ImageView) C12809f.m76831d(viewM76832e, R$id.family_member_image);
            bVar.f703d = (TextView) C12809f.m76831d(viewM76832e, R$id.family_member_name);
            bVar.f704e = (TextView) C12809f.m76831d(viewM76832e, R$id.family_member_usage);
            bVar.f707h = C12809f.m76831d(viewM76832e, R$id.member_interval);
            bVar.f705f = (TextView) C12809f.m76831d(viewM76832e, R$id.family_member_name_not_join);
            bVar.f706g = (HwButton) C12809f.m76831d(viewM76832e, R$id.member_invite_button);
            bVar.f701b = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.member_joined_layout);
            bVar.f702c = (RelativeLayout) C12809f.m76831d(viewM76832e, R$id.member_not_join_layout);
            viewM76832e.setTag(bVar);
        } else {
            viewM76832e = view;
            bVar = (b) view.getTag();
        }
        FamilyDetailInfo familyDetailInfo = this.f18708b.get(i10);
        String imageURL = familyDetailInfo.getImageURL();
        if (imageURL != null) {
            String str = this.f18709c.getFilesDir() + FamilyShareConstants.FAMILY_IMAGE_FILE_PATH + imageURL.hashCode();
            if (!new File(str).exists()) {
                C12515a.m75110o().m75175e(new C13555f(str, imageURL), false);
            }
            bitmapM70501B = C11829c.m70501B(str);
        }
        if (bitmapM70501B == null) {
            bVar.f700a.setImageBitmap(C1248a.m7477h(this.f18709c.getResources(), R$drawable.img_defaultavatar_list_gray));
        } else {
            bVar.f700a.setImageBitmap(C11842p.m70860s(bitmapM70501B));
        }
        if (TextUtils.equals(C13452e.m80781L().m80971t0(), String.valueOf(familyDetailInfo.getUid()))) {
            TextView textView = bVar.f703d;
            Context context = this.f18709c;
            int i11 = R$string.own_member;
            textView.setText(context.getString(i11, familyDetailInfo.getName()));
            bVar.f705f.setText(this.f18709c.getString(i11, familyDetailInfo.getName()));
        } else {
            bVar.f703d.setText(familyDetailInfo.getName());
            bVar.f705f.setText(familyDetailInfo.getName());
        }
        bVar.f703d.setMaxWidth(m988c());
        if (familyDetailInfo.getEnable()) {
            bVar.f702c.setVisibility(8);
            bVar.f701b.setVisibility(0);
            bVar.f704e.setText(C0223k.m1524g(this.f18709c, familyDetailInfo.getUsed()));
        } else {
            bVar.f702c.setVisibility(0);
            bVar.f701b.setVisibility(8);
            bVar.f706g.setOnClickListener(new a(familyDetailInfo));
            bVar.f704e.setText(this.f18709c.getString(R$string.not_join));
        }
        if (i10 == this.f18708b.size() - 1) {
            bVar.f707h.setVisibility(8);
        } else {
            bVar.f707h.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.m1008r());
        arrayList.add(bVar.m1007q());
        arrayList.add(bVar.m1009s());
        C12806c.m76817h(this.f18709c, arrayList);
        return viewM76832e;
    }
}
