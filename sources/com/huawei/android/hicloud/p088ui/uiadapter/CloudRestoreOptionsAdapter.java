package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.huawei.android.hicloud.cloudbackup.bean.CloudRestoreOptionHeaderBean;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudRestoreOptionsAdapter;
import com.huawei.android.hicloud.p088ui.views.CloudRestoreBasicView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13466f;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudRestoreOptionsAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public Context f18674d;

    /* renamed from: e */
    public Boolean f18675e;

    /* renamed from: f */
    public Boolean f18676f;

    /* renamed from: g */
    public Integer f18677g;

    /* renamed from: h */
    public Resources f18678h;

    /* renamed from: i */
    public List<Object> f18679i;

    /* renamed from: j */
    public View.OnClickListener f18680j;

    /* renamed from: k */
    public OnItemClickListener f18681k;

    /* renamed from: l */
    public CloudRestoreBasicView.OnBaseItemCheckedListener f18682l;

    /* renamed from: m */
    public View.OnTouchListener f18683m;

    /* renamed from: n */
    public boolean f18684n;

    /* renamed from: o */
    public DisplayMetrics f18685o;

    /* renamed from: p */
    public AtomicBoolean f18686p;

    /* renamed from: q */
    public int f18687q;

    /* renamed from: r */
    public CloudRecoveryItem f18688r;

    /* renamed from: s */
    public int f18689s;

    public interface OnItemClickListener {
        void onItemClick(int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudRestoreOptionsAdapter$a */
    public class ViewOnClickListenerC4041a implements View.OnClickListener {

        /* renamed from: a */
        public final /* synthetic */ int f18690a;

        public ViewOnClickListenerC4041a(int i10) {
            this.f18690a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CloudRestoreOptionsAdapter.this.f18681k != null) {
                CloudRestoreOptionsAdapter.this.f18681k.onItemClick(this.f18690a);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudRestoreOptionsAdapter$b */
    public static class C4042b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f18692u;

        /* renamed from: v */
        public CloudRestoreBasicView f18693v;

        /* renamed from: w */
        public CheckBox f18694w;

        /* renamed from: x */
        public SpanClickText f18695x;

        public C4042b(View view) {
            super(view);
            this.f18692u = (TextView) C12809f.m76831d(view, R$id.tv_recovery_data);
            this.f18695x = (SpanClickText) C12809f.m76831d(this.f4327a, R$id.basic_data_upgrade_tips);
            this.f18693v = (CloudRestoreBasicView) C12809f.m76831d(view, R$id.restore_basic_view);
            this.f18694w = (CheckBox) C12809f.m76831d(view, R$id.cb_all);
            m24974V();
        }

        /* renamed from: U */
        public static /* synthetic */ void m24973U() {
            if (C0209d.m1226Y0()) {
                C11839m.m70688i("CloudRestoreOptionsAdapter", "link click to fast");
                return;
            }
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("event", "upgrade now");
            C13225d.m79490f1().m79567R("action_restore_notification_delete_data_remind", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "action_restore_notification_delete_data_remind", "1", "30", linkedHashMapM79497A);
            Bundle bundle = new Bundle();
            bundle.putInt("from_where", 19);
            C13230i.m79522d1(bundle, "1", "action_restore_notification_delete_data_remind");
            C12126b.m72707c("2", bundle);
        }

        /* renamed from: V */
        public final void m24974V() {
            SpanClickText.ISpanClickListener iSpanClickListener = new SpanClickText.ISpanClickListener() { // from class: ae.w0
                @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
                public final void onClick() {
                    CloudRestoreOptionsAdapter.C4042b.m24973U();
                }
            };
            if (C13466f.m81073d().m81077e("operationControl", -1) != 1) {
                this.f18695x.setVisibility(8);
                return;
            }
            this.f18695x.setVisibility(0);
            String string = C0213f.m1377a().getString(R$string.get_premium);
            this.f18695x.m15931c(string, iSpanClickListener);
            this.f18695x.m15934g(C0213f.m1377a().getString(R$string.service_expiration_tip1, string), false);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.uiadapter.CloudRestoreOptionsAdapter$c */
    public static class C4043c extends RecyclerView.AbstractC0833c0 {

        /* renamed from: A */
        public TextView f18696A;

        /* renamed from: B */
        public ImageView f18697B;

        /* renamed from: C */
        public TextView f18698C;

        /* renamed from: D */
        public View f18699D;

        /* renamed from: E */
        public RelativeLayout f18700E;

        /* renamed from: u */
        public LinearLayout f18701u;

        /* renamed from: v */
        public CheckBox f18702v;

        /* renamed from: w */
        public RelativeLayout f18703w;

        /* renamed from: x */
        public ImageView f18704x;

        /* renamed from: y */
        public ImageView f18705y;

        /* renamed from: z */
        public TextView f18706z;

        public C4043c(View view) {
            super(view);
            this.f18702v = (CheckBox) C12809f.m76831d(view, R$id.restore_item_checkbox);
            this.f18703w = (RelativeLayout) C12809f.m76831d(view, R$id.rl_content);
            this.f18704x = (ImageView) C12809f.m76831d(view, R$id.restore_item_icon);
            this.f18705y = (ImageView) C12809f.m76831d(view, R$id.restore_item_icon_badge);
            this.f18706z = (TextView) C12809f.m76831d(view, R$id.restore_item_appId);
            this.f18696A = (TextView) C12809f.m76831d(view, R$id.restore_item_description);
            this.f18697B = (ImageView) C12809f.m76831d(view, R$id.iv_option_arrow);
            this.f18698C = (TextView) C12809f.m76831d(view, R$id.restore_item_compatibility_text);
            this.f18699D = C12809f.m76831d(view, R$id.list_item_divider);
            this.f18701u = (LinearLayout) C12809f.m76831d(view, R$id.restore_content_list_item);
            this.f18700E = (RelativeLayout) C12809f.m76831d(view, R$id.restore_item_arrow);
        }
    }

    public CloudRestoreOptionsAdapter(Context context, boolean z10, boolean z11, boolean z12, int i10) {
        Boolean bool = Boolean.FALSE;
        this.f18675e = bool;
        this.f18676f = bool;
        this.f18677g = 0;
        this.f18679i = new ArrayList();
        this.f18686p = new AtomicBoolean(false);
        this.f18689s = 0;
        this.f18674d = context;
        this.f18675e = Boolean.valueOf(z11);
        this.f18676f = Boolean.valueOf(z12);
        this.f18677g = Integer.valueOf(i10);
        this.f18684n = z10;
        Context context2 = this.f18674d;
        if (context2 != null) {
            this.f18678h = context2.getResources();
        }
        this.f18685o = C11842p.m70876w(this.f18674d);
    }

    /* renamed from: G */
    private String m24951G(CloudRestoreItem cloudRestoreItem) {
        Context context;
        String combineUid = cloudRestoreItem.getCombineUid();
        return (TextUtils.isEmpty(combineUid) || !combineUid.contains("&")) ? cloudRestoreItem.getAppName() : (!Arrays.stream(combineUid.split("&")).anyMatch(new Predicate() { // from class: ae.v0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreOptionsAdapter.m24952L((String) obj);
            }
        }) || (context = this.f18674d) == null) ? cloudRestoreItem.getAppName() : context.getString(R$string.item_contains_twin_label, cloudRestoreItem.getAppName());
    }

    /* renamed from: L */
    public static /* synthetic */ boolean m24952L(String str) {
        return C0241z.m1685c(str) != 0;
    }

    /* renamed from: F */
    public final void m24953F(C4043c c4043c, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        int iM81077e = C13466f.m81073d().m81077e("operationControl", -1);
        boolean z10 = false;
        c4043c.f18702v.setChecked(cloudRestoreItem.getAction() != 2);
        c4043c.f18702v.setContentDescription(m24951G(cloudRestoreItem));
        c4043c.f18706z.setText(m24951G(cloudRestoreItem));
        String appId = cloudRestoreItem.getAppId();
        if (SplitAppUtil.hasSplitAppSuffix(appId)) {
            c4043c.f18705y.setVisibility(0);
        } else {
            c4043c.f18705y.setVisibility(8);
        }
        c4043c.f18704x.setImageDrawable(RestoreUtil.getRestoreItemDrawable(cloudRestoreItem, SplitAppUtil.hasSplitAppSuffix(appId) ? SplitAppUtil.getSplitOriAppId(appId) : appId));
        if (cloudRestoreItem.isShowChildList()) {
            m24966U(c4043c, cloudRestoreItem);
        } else {
            int count = cloudRestoreItem.getCount();
            long size = cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
            if (m24958M(cloudRestoreItem)) {
                size = cloudRestoreItem.getSize();
            }
            String strReplace = this.f18678h.getQuantityString(R$plurals.backup_detail_gallery_num1, count, Integer.valueOf(count)).replace(String.valueOf(count), C13843a.m83104z(Integer.valueOf(count)));
            String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this.f18674d, size));
            if ((!cloudRestoreItem.isVirtual() || "music".equals(appId)) && !cloudRestoreItem.is3rdAppType()) {
                if (count != 0 && size != 0 && !cloudRestoreItem.isHarmonyNext()) {
                    c4043c.f18696A.setText(this.f18678h.getString(R$string.count_and_size, strReplace, strM1157C0));
                } else if (count != 0 && !cloudRestoreItem.isHarmonyNext()) {
                    c4043c.f18696A.setText(strReplace);
                } else if (size != 0) {
                    c4043c.f18696A.setText(strM1157C0);
                }
            } else if (cloudRestoreItem.getProgressShowType() == 2) {
                c4043c.f18696A.setText(this.f18678h.getString(R$string.count_and_size, strReplace, strM1157C0));
            } else if (count != 0 && cloudRestoreItem.getProgressShowType() == 1) {
                c4043c.f18696A.setText(strReplace);
            } else if (size == 0 || cloudRestoreItem.getProgressShowType() == 0) {
                c4043c.f18696A.setText(strM1157C0);
            } else {
                c4043c.f18696A.setText(strM1157C0);
            }
        }
        if (!C11842p.m70753O0(this.f18674d)) {
            int iM83055G = (C13843a.m83055G(this.f18674d) - ((int) C11842p.m70844o(this.f18674d, RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE))) - c4043c.f18702v.getMeasuredWidth();
            c4043c.f18696A.setMaxWidth(iM83055G);
            c4043c.f18706z.setMaxWidth(iM83055G);
        }
        double d10 = 0.4d;
        c4043c.f18702v.setAlpha((float) ((cloudRestoreItem.isCompatible() && m24957K(iM81077e)) ? 1.0d : 0.4d));
        LinearLayout linearLayout = c4043c.f18701u;
        if (cloudRestoreItem.isCompatible() && m24957K(iM81077e)) {
            z10 = true;
        }
        linearLayout.setEnabled(z10);
        LinearLayout linearLayout2 = c4043c.f18701u;
        if (cloudRestoreItem.isCompatible() && m24957K(iM81077e)) {
            d10 = 1.0d;
        }
        linearLayout2.setAlpha((float) d10);
    }

    /* renamed from: H */
    public List<Object> m24954H() {
        return this.f18679i;
    }

    /* renamed from: I */
    public final void m24955I(C4042b c4042b, CloudRestoreOptionHeaderBean cloudRestoreOptionHeaderBean) {
        if (c4042b == null || cloudRestoreOptionHeaderBean == null) {
            return;
        }
        if (!TextUtils.isEmpty(cloudRestoreOptionHeaderBean.getRecordBackupTime())) {
            c4042b.f18692u.setVisibility(0);
            c4042b.f18692u.setText(cloudRestoreOptionHeaderBean.getRecordBackupTime());
        }
        c4042b.f18694w.setChecked(cloudRestoreOptionHeaderBean.isMainSwitchCheck());
        c4042b.f18694w.setEnabled(cloudRestoreOptionHeaderBean.isMainSwitchEnable());
        c4042b.f18694w.setOnClickListener(this.f18680j);
        c4042b.f18694w.setAlpha((float) (!cloudRestoreOptionHeaderBean.isMainSwitchEnable() ? 0.4d : 1.0d));
        String strM1157C0 = C0209d.m1157C0(C0223k.m1526i(C0213f.m1377a(), cloudRestoreOptionHeaderBean.getSelectedSize(), 1024, false, false));
        if (cloudRestoreOptionHeaderBean.getBmDataType() == 0) {
            c4042b.f18694w.setText(this.f18674d.getString(R$string.restore_slected_size, strM1157C0));
        } else {
            CheckBox checkBox = c4042b.f18694w;
            Context context = this.f18674d;
            checkBox.setText(context.getString(R$string.backup_select, context.getString(R$string.full_data_new), C0223k.m1529l(strM1157C0)));
        }
        if (cloudRestoreOptionHeaderBean.hasAppData()) {
            c4042b.f18694w.setVisibility(0);
            if (this.f18675e.booleanValue() || (this.f18676f.booleanValue() && this.f18677g.intValue() == 0)) {
                c4042b.f18695x.setVisibility(8);
            }
        } else {
            c4042b.f18695x.setVisibility(8);
            c4042b.f18694w.setVisibility(8);
        }
        if (cloudRestoreOptionHeaderBean.getBmDataType() == 3) {
            c4042b.f18693v.setVisibility(8);
            return;
        }
        CloudRestoreItem baseDataItem = cloudRestoreOptionHeaderBean.getBaseDataItem();
        if (baseDataItem == null) {
            c4042b.f18693v.setVisibility(8);
            return;
        }
        if (TextUtils.equals(baseDataItem.getAppId(), "bmBaseData")) {
            c4042b.f18693v.setEntryType(this.f18687q);
            c4042b.f18693v.setCloudRecoveryItem(this.f18688r);
            c4042b.f18693v.m25740v(baseDataItem, cloudRestoreOptionHeaderBean.getBmDataType(), this.f18686p);
            c4042b.f18693v.setVisibility(0);
            c4042b.f18693v.setOnBaseItemCheckChangedListener(this.f18682l);
        }
    }

    /* renamed from: J */
    public final void m24956J(C4043c c4043c, CloudRestoreItem cloudRestoreItem, int i10) throws Resources.NotFoundException {
        DisplayMetrics displayMetrics;
        c4043c.f18703w.setTag(Integer.valueOf(i10));
        c4043c.f18701u.setOnClickListener(new ViewOnClickListenerC4041a(i10));
        if (cloudRestoreItem.isShowChildList()) {
            if (cloudRestoreItem.isCompatible()) {
                c4043c.f18703w.setOnClickListener(this.f18680j);
                c4043c.f18703w.setOnTouchListener(this.f18683m);
                c4043c.f18697B.setVisibility(0);
            } else {
                c4043c.f18697B.setVisibility(8);
            }
            c4043c.f18698C.setText(this.f18678h.getQuantityString(R$plurals.backup_recover_how_many_apps_not_support, cloudRestoreItem.m29205t(), Integer.valueOf(cloudRestoreItem.m29205t())));
            c4043c.f18698C.setVisibility(cloudRestoreItem.m29183K() ? 0 : 8);
        } else {
            c4043c.f18697B.setVisibility(8);
            c4043c.f18698C.setText(R$string.backup_recover_app_not_support);
            if (SplitAppUtil.isTwinApp(cloudRestoreItem.getSplitApkType(), cloudRestoreItem.getOriBackupAppName())) {
                TextView textView = c4043c.f18698C;
                int i11 = R$string.backup_recover_all_apps_not_support;
                textView.setText(i11);
                if (C0209d.m1269j1()) {
                    c4043c.f18698C.setText(i11);
                }
            }
            c4043c.f18698C.setVisibility(cloudRestoreItem.isCompatible() ? 8 : 0);
        }
        if (C0209d.m1195O(this.f18674d) < 1.75f && (displayMetrics = this.f18685o) != null && displayMetrics.widthPixels > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c4043c.f18700E.getLayoutParams();
            if (c4043c.f18698C.getVisibility() == 0) {
                layoutParams.width = this.f18685o.widthPixels / 4;
            } else if (c4043c.f18697B.getVisibility() == 0) {
                layoutParams.width = this.f18685o.widthPixels / 10;
            } else {
                layoutParams.width = 0;
            }
            c4043c.f18700E.setLayoutParams(layoutParams);
        }
        if (this.f18679i != null && r0.size() - 1 == i10) {
            c4043c.f18699D.setVisibility(8);
        }
        m24953F(c4043c, cloudRestoreItem);
    }

    /* renamed from: K */
    public final boolean m24957K(int i10) {
        if (!(i10 == 1)) {
            return true;
        }
        boolean zBooleanValue = this.f18675e.booleanValue();
        if (this.f18676f.booleanValue() && this.f18677g.intValue() == 0) {
            return true;
        }
        return zBooleanValue;
    }

    /* renamed from: M */
    public final boolean m24958M(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.m29187M() && (!this.f18684n || (cloudRestoreItem != null && this.f18689s == 2));
    }

    /* renamed from: N */
    public void m24959N(CloudRecoveryItem cloudRecoveryItem) {
        this.f18688r = cloudRecoveryItem;
        if (cloudRecoveryItem != null) {
            this.f18689s = cloudRecoveryItem.getBmDataType();
        }
    }

    /* renamed from: O */
    public void m24960O(int i10) {
        this.f18687q = i10;
    }

    /* renamed from: P */
    public void m24961P(List<Object> list) {
        if (this.f18679i == null) {
            this.f18679i = new ArrayList();
        }
        this.f18679i.clear();
        this.f18679i.addAll(list);
        m5213j();
    }

    /* renamed from: Q */
    public void m24962Q(View.OnClickListener onClickListener) {
        this.f18680j = onClickListener;
    }

    /* renamed from: R */
    public void m24963R(CloudRestoreBasicView.OnBaseItemCheckedListener onBaseItemCheckedListener) {
        this.f18682l = onBaseItemCheckedListener;
    }

    /* renamed from: S */
    public void m24964S(OnItemClickListener onItemClickListener) {
        this.f18681k = onItemClickListener;
    }

    /* renamed from: T */
    public void m24965T(View.OnTouchListener onTouchListener) {
        this.f18683m = onTouchListener;
    }

    /* renamed from: U */
    public final void m24966U(C4043c c4043c, CloudRestoreItem cloudRestoreItem) throws Resources.NotFoundException {
        String string;
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null) {
            return;
        }
        int size = listM29202r.size();
        int count = cloudRestoreItem.getCount();
        long size2 = cloudRestoreItem.getSize() + cloudRestoreItem.getAsize();
        String quantityString = this.f18678h.getQuantityString(R$plurals.backup_app_data_count, size, Integer.valueOf(size));
        if (size2 > 0) {
            string = C0213f.m1377a().getString(R$string.backup_option_third_value, Integer.valueOf(count), quantityString, C0209d.m1157C0(C0223k.m1524g(C0213f.m1377a(), size2)));
        } else {
            string = C0213f.m1377a().getString(R$string.backup_option_value_no_size, Integer.valueOf(count), quantityString);
        }
        c4043c.f18696A.setText(string);
    }

    /* renamed from: V */
    public void m24967V(RecyclerView recyclerView, int i10) {
        List<Object> list;
        if (this.f18678h == null || (list = this.f18679i) == null || i10 >= list.size()) {
            C11839m.m70687e("CloudRestoreOptionsAdapter", "updateViewIcon,view or list is null");
            return;
        }
        Object obj = this.f18679i.get(i10);
        if (obj instanceof CloudRestoreItem) {
            RecyclerView.AbstractC0833c0 abstractC0833c0FindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(i10);
            if (abstractC0833c0FindViewHolderForLayoutPosition instanceof C4043c) {
                m24953F((C4043c) abstractC0833c0FindViewHolderForLayoutPosition, (CloudRestoreItem) obj);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        List<Object> list = this.f18679i;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        if (this.f18679i.get(i10) instanceof CloudRestoreOptionHeaderBean) {
            return 1;
        }
        return super.mo749g(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10) throws Resources.NotFoundException {
        List<Object> list;
        Object obj;
        if (this.f18678h == null || (list = this.f18679i) == null || i10 >= list.size() || (obj = this.f18679i.get(i10)) == null) {
            return;
        }
        if (obj instanceof CloudRestoreItem) {
            m24956J((C4043c) abstractC0833c0, (CloudRestoreItem) obj, i10);
        } else if (obj instanceof CloudRestoreOptionHeaderBean) {
            m24955I((C4042b) abstractC0833c0, (CloudRestoreOptionHeaderBean) obj);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        if (i10 == 1) {
            return new C4042b(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_restore_option_header, viewGroup, false));
        }
        return new C4043c(C0209d.m1195O(this.f18674d) >= 1.75f ? LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_backup_content_detail_font_scale, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_backup_content_detail, viewGroup, false));
    }
}
