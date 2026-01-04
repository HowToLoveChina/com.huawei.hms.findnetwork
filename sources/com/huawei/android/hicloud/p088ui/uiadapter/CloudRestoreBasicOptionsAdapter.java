package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudRestoreBasicOptionsAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p514o9.C11839m;
import p514o9.C11842p;
import p783xp.C13843a;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudRestoreBasicOptionsAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public Context f18655d;

    /* renamed from: e */
    public Resources f18656e;

    /* renamed from: g */
    public OnItemClickListener f18658g;

    /* renamed from: h */
    public OnContentClickListener f18659h;

    /* renamed from: i */
    public boolean f18660i;

    /* renamed from: j */
    public DisplayMetrics f18661j;

    /* renamed from: f */
    public List<CloudRestoreItem> f18657f = new ArrayList();

    /* renamed from: k */
    public AtomicBoolean f18662k = new AtomicBoolean(false);

    /* renamed from: l */
    public int f18663l = 0;

    public interface OnContentClickListener {
        /* renamed from: b */
        void mo24937b(CloudRestoreItem cloudRestoreItem, int i10);
    }

    public interface OnItemClickListener {
        /* renamed from: a */
        void mo24938a(CloudRestoreItem cloudRestoreItem, int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudRestoreBasicOptionsAdapter$a */
    public static class C4040a extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public ImageView f18664A;

        /* renamed from: B */
        public TextView f18665B;

        /* renamed from: C */
        public View f18666C;

        /* renamed from: D */
        public RelativeLayout f18667D;

        /* renamed from: u */
        public LinearLayout f18668u;

        /* renamed from: v */
        public CheckBox f18669v;

        /* renamed from: w */
        public RelativeLayout f18670w;

        /* renamed from: x */
        public ImageView f18671x;

        /* renamed from: y */
        public TextView f18672y;

        /* renamed from: z */
        public TextView f18673z;

        public C4040a(View view) {
            super(view);
            this.f18669v = (CheckBox) C12809f.m76831d(view, R$id.restore_item_checkbox);
            this.f18670w = (RelativeLayout) C12809f.m76831d(view, R$id.rl_content);
            this.f18671x = (ImageView) C12809f.m76831d(view, R$id.restore_item_icon);
            this.f18672y = (TextView) C12809f.m76831d(view, R$id.restore_item_appId);
            this.f18673z = (TextView) C12809f.m76831d(view, R$id.restore_item_description);
            this.f18664A = (ImageView) C12809f.m76831d(view, R$id.iv_option_arrow);
            this.f18665B = (TextView) C12809f.m76831d(view, R$id.restore_item_compatibility_text);
            this.f18666C = C12809f.m76831d(view, R$id.list_item_divider);
            this.f18668u = (LinearLayout) C12809f.m76831d(view, R$id.restore_content_list_item);
            this.f18667D = (RelativeLayout) C12809f.m76831d(view, R$id.restore_item_arrow);
        }
    }

    public CloudRestoreBasicOptionsAdapter(Context context, boolean z10) {
        this.f18655d = context;
        this.f18660i = z10;
        if (context != null) {
            this.f18656e = context.getResources();
        }
        this.f18661j = C11842p.m70876w(this.f18655d);
    }

    /* renamed from: I */
    private Object m24921I(int i10) {
        return this.f18657f.get(i10);
    }

    /* renamed from: N */
    public static /* synthetic */ boolean m24922N(String str) {
        return C0241z.m1685c(str) != 0;
    }

    /* renamed from: G */
    public final void m24923G(C4040a c4040a, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        c4040a.f18669v.setChecked(cloudRestoreItem.getAction() != 2);
        c4040a.f18669v.setContentDescription(m24924H(cloudRestoreItem));
        c4040a.f18672y.setText(m24924H(cloudRestoreItem));
        String appId = cloudRestoreItem.getAppId();
        c4040a.f18671x.setImageDrawable(RestoreUtil.getRestoreItemDrawable(cloudRestoreItem, appId));
        if (cloudRestoreItem.isShowChildList()) {
            m24936V(c4040a, cloudRestoreItem);
        } else {
            int count = cloudRestoreItem.getCount();
            long size = cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
            if (cloudRestoreItem.m29187M() && !this.f18660i && !cloudRestoreItem.isHarmonyNext()) {
                size = cloudRestoreItem.getSize();
            }
            String strReplace = this.f18656e.getQuantityString(R$plurals.backup_detail_gallery_num1, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)));
            String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this.f18655d, size));
            if ((!cloudRestoreItem.isVirtual() || "music".equals(appId)) && !cloudRestoreItem.is3rdAppType()) {
                if (count != 0 && size != 0 && m24928M(cloudRestoreItem)) {
                    c4040a.f18673z.setText(this.f18656e.getString(R$string.count_and_size, strReplace, strM1157C0));
                } else if (count != 0 && m24928M(cloudRestoreItem)) {
                    c4040a.f18673z.setText(strReplace);
                } else if (size != 0) {
                    c4040a.f18673z.setText(strM1157C0);
                }
            } else if (cloudRestoreItem.getProgressShowType() == 2) {
                c4040a.f18673z.setText(this.f18656e.getString(R$string.count_and_size, strReplace, strM1157C0));
            } else if (count != 0 && cloudRestoreItem.getProgressShowType() == 1) {
                c4040a.f18673z.setText(strReplace);
            } else if (size == 0 || cloudRestoreItem.getProgressShowType() == 0) {
                c4040a.f18673z.setText(strM1157C0);
            } else {
                c4040a.f18673z.setText(strM1157C0);
            }
        }
        if (!C11842p.m70753O0(this.f18655d)) {
            int iM83055G = (C13843a.m83055G(this.f18655d) - ((int) C11842p.m70844o(this.f18655d, RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE))) - c4040a.f18669v.getMeasuredWidth();
            c4040a.f18673z.setMaxWidth(iM83055G);
            c4040a.f18672y.setMaxWidth(iM83055G);
        }
        c4040a.f18669v.setAlpha((float) (!cloudRestoreItem.isCompatible() ? 0.4d : 1.0d));
        c4040a.f18668u.setEnabled(cloudRestoreItem.isCompatible());
        c4040a.f18668u.setAlpha((float) (cloudRestoreItem.isCompatible() ? 1.0d : 0.4d));
    }

    /* renamed from: H */
    public final String m24924H(CloudRestoreItem cloudRestoreItem) {
        Context context;
        String combineUid = cloudRestoreItem.getCombineUid();
        return (TextUtils.isEmpty(combineUid) || !combineUid.contains("&")) ? cloudRestoreItem.getAppName() : (!Arrays.stream(combineUid.split("&")).anyMatch(new Predicate() { // from class: ae.s0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreBasicOptionsAdapter.m24922N((String) obj);
            }
        }) || (context = this.f18655d) == null) ? cloudRestoreItem.getAppName() : context.getString(R$string.item_contains_twin_label, cloudRestoreItem.getAppName());
    }

    /* renamed from: J */
    public List<CloudRestoreItem> m24925J() {
        return this.f18657f;
    }

    /* renamed from: K */
    public final void m24926K(C4040a c4040a, final CloudRestoreItem cloudRestoreItem, final int i10) throws Resources.NotFoundException {
        DisplayMetrics displayMetrics;
        c4040a.f18670w.setTag(Integer.valueOf(i10));
        c4040a.f18668u.setOnClickListener(new View.OnClickListener() { // from class: ae.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f610a.m24929O(cloudRestoreItem, i10, view);
            }
        });
        c4040a.f18670w.setClickable(false);
        if (cloudRestoreItem.isShowChildList()) {
            if (cloudRestoreItem.isCompatible()) {
                c4040a.f18670w.setClickable(true);
                c4040a.f18670w.setOnClickListener(new View.OnClickListener() { // from class: ae.r0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f618a.m24930P(cloudRestoreItem, i10, view);
                    }
                });
                c4040a.f18664A.setVisibility(0);
            } else {
                c4040a.f18664A.setVisibility(8);
            }
            int iM29205t = cloudRestoreItem.m29205t();
            if (m24927L(cloudRestoreItem) && cloudRestoreItem.m29202r() != null) {
                iM29205t = cloudRestoreItem.m29202r().size();
            }
            c4040a.f18665B.setText(this.f18656e.getQuantityString(R$plurals.backup_recover_how_many_apps_not_support, iM29205t, Integer.valueOf(iM29205t)));
            c4040a.f18665B.setVisibility(cloudRestoreItem.m29183K() ? 0 : 8);
        } else {
            c4040a.f18664A.setVisibility(8);
            c4040a.f18665B.setText(R$string.backup_recover_app_not_support);
            c4040a.f18665B.setVisibility(cloudRestoreItem.isCompatible() ? 8 : 0);
        }
        if (C0209d.m1195O(this.f18655d) < 1.75f && (displayMetrics = this.f18661j) != null && displayMetrics.widthPixels > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c4040a.f18667D.getLayoutParams();
            if (c4040a.f18665B.getVisibility() == 0) {
                layoutParams.width = this.f18661j.widthPixels / 4;
            } else if (c4040a.f18664A.getVisibility() == 0) {
                layoutParams.width = this.f18661j.widthPixels / 10;
            } else {
                layoutParams.width = 0;
            }
            c4040a.f18667D.setLayoutParams(layoutParams);
        }
        List<CloudRestoreItem> list = this.f18657f;
        if (list != null && list.size() - 1 == i10) {
            c4040a.f18666C.setVisibility(8);
        }
        m24923G(c4040a, cloudRestoreItem);
    }

    /* renamed from: L */
    public final boolean m24927L(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.isHarmonyNext() && "thirdApp".equals(cloudRestoreItem.getAppId());
    }

    /* renamed from: M */
    public final boolean m24928M(CloudRestoreItem cloudRestoreItem) {
        return (cloudRestoreItem == null || !new ArrayList(C14333b.m85452H()).contains(cloudRestoreItem.getAppId()) || cloudRestoreItem.isHarmonyNext()) ? false : true;
    }

    /* renamed from: O */
    public final /* synthetic */ void m24929O(CloudRestoreItem cloudRestoreItem, int i10, View view) {
        OnItemClickListener onItemClickListener = this.f18658g;
        if (onItemClickListener != null) {
            onItemClickListener.mo24938a(cloudRestoreItem, i10);
        }
    }

    /* renamed from: P */
    public final /* synthetic */ void m24930P(CloudRestoreItem cloudRestoreItem, int i10, View view) {
        OnContentClickListener onContentClickListener = this.f18659h;
        if (onContentClickListener != null) {
            onContentClickListener.mo24937b(cloudRestoreItem, i10);
        }
    }

    /* renamed from: Q */
    public void m24931Q(int i10) {
        C11839m.m70688i("CloudRestoreBasicOptionsAdapter", "setBmDataType items " + i10);
        if (i10 != 2) {
            this.f18662k.set(true);
        }
        this.f18663l = i10;
        m5213j();
    }

    /* renamed from: R */
    public void m24932R(AtomicBoolean atomicBoolean) {
        this.f18662k = atomicBoolean;
        m5213j();
    }

    /* renamed from: S */
    public void m24933S(List<CloudRestoreItem> list) {
        C11839m.m70688i("CloudRestoreBasicOptionsAdapter", "setItemList items " + list.size());
        if (this.f18657f == null) {
            this.f18657f = new ArrayList();
        }
        this.f18657f.clear();
        this.f18657f.addAll(list);
        m5213j();
    }

    /* renamed from: T */
    public void m24934T(OnContentClickListener onContentClickListener) {
        this.f18659h = onContentClickListener;
    }

    /* renamed from: U */
    public void m24935U(OnItemClickListener onItemClickListener) {
        this.f18658g = onItemClickListener;
    }

    /* renamed from: V */
    public final void m24936V(C4040a c4040a, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        String string;
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null) {
            return;
        }
        int size = listM29202r.size();
        int count = cloudRestoreItem.getCount();
        long size2 = cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
        if (m24927L(cloudRestoreItem)) {
            count = 0;
            size2 = 0;
        }
        String quantityString = this.f18656e.getQuantityString(R$plurals.backup_app_data_count, size, Integer.valueOf(size));
        if (size2 > 0) {
            string = C0213f.m1377a().getString(R$string.backup_option_third_value, Integer.valueOf(count), quantityString, C0209d.m1157C0(C0223k.m1524g(C0213f.m1377a(), size2)));
        } else {
            string = C0213f.m1377a().getString(R$string.backup_option_value_no_size, Integer.valueOf(count), quantityString);
        }
        c4040a.f18673z.setText(string);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<CloudRestoreItem> list = this.f18657f;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        if (this.f18663l == 2 && this.f18657f.size() > 3 && !this.f18662k.get() && this.f18657f.size() > 2) {
            return 2;
        }
        return this.f18657f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        return super.mo749g(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        List<CloudRestoreItem> list;
        if (this.f18656e == null || (list = this.f18657f) == null || i10 >= list.size()) {
            return;
        }
        Object objM24921I = m24921I(i10);
        if (objM24921I == null) {
            C11839m.m70687e("CloudRestoreBasicOptionsAdapter", "getItem, is null");
            abstractC0833c0.f4327a.setVisibility(8);
        } else if (objM24921I instanceof CloudRestoreItem) {
            m24926K((C4040a) abstractC0833c0, (CloudRestoreItem) objM24921I, i10);
            abstractC0833c0.f4327a.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        return new C4040a(C0209d.m1195O(this.f18655d) >= 1.75f ? LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_backup_content_detail_font_scale, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_backup_content_detail, viewGroup, false));
    }
}
