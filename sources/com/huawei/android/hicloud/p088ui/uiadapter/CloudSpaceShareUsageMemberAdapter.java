package com.huawei.android.hicloud.p088ui.uiadapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.FamilyDetailInfo;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0223k;
import p035bk.C1248a;
import p514o9.C11829c;
import p514o9.C11842p;
import p616rk.C12515a;
import p709vj.C13452e;
import p732w8.C13555f;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudSpaceShareUsageMemberAdapter extends CloudSpaceShareUsageBaseAdapter {

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudSpaceShareUsageMemberAdapter$b */
    public static class C4045b {

        /* renamed from: a */
        public ImageView f18710a;

        /* renamed from: b */
        public TextView f18711b;

        /* renamed from: c */
        public TextView f18712c;

        /* renamed from: d */
        public View f18713d;

        public C4045b() {
        }

        /* renamed from: i */
        public ImageView m24995i() {
            return this.f18710a;
        }

        /* renamed from: j */
        public TextView m24996j() {
            return this.f18711b;
        }

        /* renamed from: k */
        public TextView m24997k() {
            return this.f18712c;
        }
    }

    public CloudSpaceShareUsageMemberAdapter(Context context) {
        super(context);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.CloudSpaceShareUsageBaseAdapter
    /* renamed from: a */
    public void mo989a(List<FamilyDetailInfo> list) {
        super.mo989a(list);
    }

    /* renamed from: b */
    public final int m24986b() {
        return ((this.f18709c instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f18709c)) ? C11842p.m70857r0() : C11842p.m70877w0();
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
        C4045b c4045b;
        Bitmap bitmapM70501B = null;
        byte b10 = 0;
        if (view == null) {
            c4045b = new C4045b();
            viewM76832e = C0209d.m1195O(this.f18709c) >= 2.0f ? C12809f.m76832e(this.f18707a, R$layout.family_member_list_item_font_scale) : C12809f.m76832e(this.f18707a, R$layout.family_member_list_item);
            c4045b.f18710a = (ImageView) C12809f.m76831d(viewM76832e, R$id.family_member_image);
            c4045b.f18711b = (TextView) C12809f.m76831d(viewM76832e, R$id.family_member_name);
            c4045b.f18712c = (TextView) C12809f.m76831d(viewM76832e, R$id.family_member_usage);
            c4045b.f18713d = C12809f.m76831d(viewM76832e, R$id.member_interval);
            viewM76832e.setTag(c4045b);
        } else {
            viewM76832e = view;
            c4045b = (C4045b) view.getTag();
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
            c4045b.f18710a.setImageBitmap(C1248a.m7477h(this.f18709c.getResources(), R$drawable.img_defaultavatar_list_gray));
        } else {
            c4045b.f18710a.setImageBitmap(C11842p.m70860s(bitmapM70501B));
        }
        if (TextUtils.equals(C13452e.m80781L().m80971t0(), String.valueOf(familyDetailInfo.getUid()))) {
            c4045b.f18711b.setText(this.f18709c.getString(R$string.own_member, familyDetailInfo.getName()));
        } else {
            c4045b.f18711b.setText(familyDetailInfo.getName());
        }
        c4045b.f18711b.setMaxWidth(m24986b());
        if (familyDetailInfo.getEnable()) {
            c4045b.f18712c.setText(C0223k.m1524g(this.f18709c, familyDetailInfo.getUsed()));
        } else {
            c4045b.f18712c.setText(this.f18709c.getString(R$string.not_join));
        }
        if (i10 == this.f18708b.size() - 1) {
            c4045b.f18713d.setVisibility(8);
        } else {
            c4045b.f18713d.setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c4045b.m24995i());
        arrayList.add(c4045b.m24996j());
        arrayList.add(c4045b.m24997k());
        C12806c.m76817h(this.f18709c, arrayList);
        return viewM76832e;
    }
}
