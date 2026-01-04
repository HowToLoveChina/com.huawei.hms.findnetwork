package com.huawei.android.hicloud.p088ui.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.p088ui.activity.CloudRestoreChildOptionsActivity;
import com.huawei.android.hicloud.p088ui.uiadapter.CloudRestoreBasicOptionsAdapter;
import com.huawei.android.hicloud.p088ui.uiextend.UnionCheckBox;
import com.huawei.android.hicloud.p088ui.views.CloudRestoreBasicView;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.p103ui.uiextend.ExpandRecyclerView;
import com.huawei.hicloud.cloudbackup.model.CloudRecoveryItem;
import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import de.C9080g;
import es.C9537b;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudRestoreBasicView extends RelativeLayout implements CloudRestoreBasicOptionsAdapter.OnItemClickListener, CloudRestoreBasicOptionsAdapter.OnContentClickListener {

    /* renamed from: a */
    public Context f19425a;

    /* renamed from: b */
    public View f19426b;

    /* renamed from: c */
    public LinearLayout f19427c;

    /* renamed from: d */
    public TextView f19428d;

    /* renamed from: e */
    public UnionCheckBox f19429e;

    /* renamed from: f */
    public CloudRestoreBasicOptionsAdapter f19430f;

    /* renamed from: g */
    public ExpandRecyclerView f19431g;

    /* renamed from: h */
    public AtomicBoolean f19432h;

    /* renamed from: i */
    public int f19433i;

    /* renamed from: j */
    public CloudRecoveryItem f19434j;

    /* renamed from: k */
    public CloudRestoreItem f19435k;

    /* renamed from: l */
    public OnBaseItemCheckedListener f19436l;

    public interface OnBaseItemCheckedListener {
        /* renamed from: b0 */
        void mo19907b0(CloudRestoreItem cloudRestoreItem, boolean z10);
    }

    public CloudRestoreBasicView(Context context) {
        this(context, null, 0, 0);
    }

    /* renamed from: m */
    public static /* synthetic */ boolean m25729m(CloudRestoreItem cloudRestoreItem) {
        return "thirdApp".equals(cloudRestoreItem.getAppId());
    }

    /* renamed from: o */
    public static /* synthetic */ boolean m25731o(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.getAction() != 2;
    }

    /* renamed from: q */
    public static /* synthetic */ boolean m25732q(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.getAction() != 2;
    }

    /* renamed from: s */
    public static /* synthetic */ boolean m25734s(CloudRestoreItem cloudRestoreItem) {
        return cloudRestoreItem.getAction() != 2;
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudRestoreBasicOptionsAdapter.OnItemClickListener
    /* renamed from: a */
    public void mo24938a(CloudRestoreItem cloudRestoreItem, int i10) {
        if (cloudRestoreItem == null) {
            C11839m.m70689w("CloudRestoreBasicView", "onSubSwitchClick restoreItem null");
            return;
        }
        cloudRestoreItem.setAction(cloudRestoreItem.getAction() != 2 ? 2 : 0);
        CloudRestoreBasicOptionsAdapter cloudRestoreBasicOptionsAdapter = this.f19430f;
        if (cloudRestoreBasicOptionsAdapter == null) {
            return;
        }
        cloudRestoreBasicOptionsAdapter.m5214k(i10);
        boolean zAnyMatch = this.f19430f.m24925J().stream().anyMatch(new Predicate() { // from class: de.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreBasicView.m25732q((CloudRestoreItem) obj);
            }
        });
        this.f19435k.setAction(zAnyMatch ? 0 : 2);
        OnBaseItemCheckedListener onBaseItemCheckedListener = this.f19436l;
        if (onBaseItemCheckedListener != null) {
            onBaseItemCheckedListener.mo19907b0(cloudRestoreItem, zAnyMatch);
        }
    }

    @Override // com.huawei.android.hicloud.ui.uiadapter.CloudRestoreBasicOptionsAdapter.OnContentClickListener
    /* renamed from: b */
    public void mo24937b(CloudRestoreItem cloudRestoreItem, int i10) {
        if (cloudRestoreItem == null) {
            C11839m.m70689w("CloudRestoreBasicView", "onContentClick item = null");
            return;
        }
        if (C0209d.m1226Y0()) {
            C11839m.m70688i("CloudRestoreBasicView", "onListItemClick isFastClick");
            return;
        }
        C11839m.m70688i("CloudRestoreBasicView", "onListItemClick item " + cloudRestoreItem.getAppName() + " name " + cloudRestoreItem.getAppId());
        String appId = cloudRestoreItem.getAppId();
        appId.hashCode();
        if (appId.equals("thirdApp") && (this.f19425a instanceof Activity)) {
            Intent intent = new Intent((Activity) this.f19425a, (Class<?>) CloudRestoreChildOptionsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f19433i);
            bundle.putString("current_app_id", appId);
            bundle.putParcelable("backup_content_detail_list", this.f19434j);
            intent.putExtras(bundle);
            ((Activity) this.f19425a).startActivityForResult(intent, 10000);
        }
    }

    public View getContentView() {
        return this.f19426b;
    }

    /* renamed from: k */
    public final boolean m25735k(List<CloudRestoreItem> list) {
        List<CloudRestoreItem> listM29202r;
        if (list == null) {
            return false;
        }
        List list2 = (List) list.stream().filter(new Predicate() { // from class: de.k
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreBasicView.m25729m((CloudRestoreItem) obj);
            }
        }).collect(Collectors.toList());
        if (list2 == null || list2.size() == 0 || list2.get(0) == null || ((CloudRestoreItem) list2.get(0)).isHarmonyNext() || (listM29202r = ((CloudRestoreItem) list2.get(0)).m29202r()) == null) {
            return true;
        }
        List list3 = (List) listM29202r.stream().filter(new Predicate() { // from class: de.l
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((CloudRestoreItem) obj).isCompatible();
            }
        }).collect(Collectors.toList());
        if (C9537b.m59560a(list3)) {
            return true;
        }
        return list3.stream().anyMatch(new Predicate() { // from class: de.m
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreBasicView.m25731o((CloudRestoreItem) obj);
            }
        });
    }

    /* renamed from: l */
    public final void m25736l(Context context) {
        this.f19426b = View.inflate(context, R$layout.cloud_restore_backup_base_data, this);
        this.f19429e = (UnionCheckBox) C12809f.m76831d(this, R$id.cb_all_select);
        this.f19427c = (LinearLayout) C12809f.m76831d(this, R$id.ll_expand);
        TextView textView = (TextView) C12809f.m76831d(this, R$id.tv_expand);
        this.f19428d = textView;
        textView.setCompoundDrawablePadding(C11842p.m70840n(context, 8));
        this.f19427c.setOnClickListener(new View.OnClickListener() { // from class: de.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45841a.m25737p(view);
            }
        });
        ExpandRecyclerView expandRecyclerView = (ExpandRecyclerView) C12809f.m76831d(this, R$id.expand_ry_basic_data);
        this.f19431g = expandRecyclerView;
        expandRecyclerView.setNestedScrollingEnabled(true);
        this.f19431g.setLayoutManager(new LinearLayoutManager(this.f19425a));
        this.f19431g.setOverScrollMode(2);
        CloudRestoreBasicOptionsAdapter cloudRestoreBasicOptionsAdapter = new CloudRestoreBasicOptionsAdapter(this.f19425a, true);
        this.f19430f = cloudRestoreBasicOptionsAdapter;
        cloudRestoreBasicOptionsAdapter.m24935U(this);
        this.f19430f.m24934T(this);
        this.f19431g.setAdapter(this.f19430f);
        this.f19429e.setOnCheckedChangeListener(new C9080g(this));
        String strM1526i = C0223k.m1526i(C0213f.m1377a(), 0L, 1024, false, false);
        UnionCheckBox unionCheckBox = this.f19429e;
        Context context2 = this.f19425a;
        unionCheckBox.setText(context2.getString(R$string.backup_select, context2.getString(R$string.base_service_data), C0223k.m1529l(strM1526i)));
        setClickable(false);
    }

    /* renamed from: p */
    public final /* synthetic */ void m25737p(View view) {
        if (this.f19430f == null) {
            return;
        }
        this.f19432h.set(!r2.get());
        this.f19430f.m24932R(this.f19432h);
        this.f19428d.setText(this.f19432h.get() ? R$string.collapse : R$string.cloud_disk_more);
        this.f19428d.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f19432h.get() ? getResources().getDrawable(R$drawable.up_arrow) : getResources().getDrawable(R$drawable.down_arrow), (Drawable) null);
    }

    public void setCloudRecoveryItem(CloudRecoveryItem cloudRecoveryItem) {
        this.f19434j = cloudRecoveryItem;
    }

    public void setEntryType(int i10) {
        this.f19433i = i10;
    }

    public void setOnBaseItemCheckChangedListener(OnBaseItemCheckedListener onBaseItemCheckedListener) {
        this.f19436l = onBaseItemCheckedListener;
    }

    /* renamed from: t */
    public final void m25738t(CompoundButton compoundButton, boolean z10) {
        C11839m.m70689w("CloudRestoreBasicView", "select all " + z10);
        this.f19435k.setAction(z10 ? 0 : 2);
        OnBaseItemCheckedListener onBaseItemCheckedListener = this.f19436l;
        if (onBaseItemCheckedListener != null) {
            onBaseItemCheckedListener.mo19907b0(this.f19435k, z10);
        }
    }

    /* renamed from: u */
    public final void m25739u(CloudRestoreItem cloudRestoreItem, boolean z10) {
        List<CloudRestoreItem> listM24925J;
        CloudRestoreBasicOptionsAdapter cloudRestoreBasicOptionsAdapter = this.f19430f;
        if (cloudRestoreBasicOptionsAdapter == null || (listM24925J = cloudRestoreBasicOptionsAdapter.m24925J()) == null) {
            return;
        }
        long sizeFromListData = RestoreUtil.getSizeFromListData(listM24925J, true);
        List list = (List) listM24925J.stream().filter(new Predicate() { // from class: de.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((CloudRestoreItem) obj).isCompatible();
            }
        }).collect(Collectors.toList());
        if (C9537b.m59560a(list)) {
            return;
        }
        boolean zAllMatch = list.stream().allMatch(new Predicate() { // from class: de.i
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudRestoreBasicView.m25734s((CloudRestoreItem) obj);
            }
        });
        String strM1526i = C0223k.m1526i(C0213f.m1377a(), sizeFromListData, 1024, false, false);
        UnionCheckBox unionCheckBox = this.f19429e;
        Context context = this.f19425a;
        int i10 = R$string.backup_select;
        int i11 = R$string.base_service_data;
        unionCheckBox.setText(context.getString(i10, context.getString(i11), C0223k.m1529l(strM1526i)));
        String strM1157C0 = C0209d.m1157C0(strM1526i);
        UnionCheckBox unionCheckBox2 = this.f19429e;
        Context context2 = this.f19425a;
        unionCheckBox2.setText(context2.getString(i10, context2.getString(i11), C0223k.m1529l(strM1157C0)));
        this.f19429e.setOnCheckedChangeListener(null);
        this.f19429e.setChecked(zAllMatch && m25735k(listM24925J));
        this.f19429e.setOnCheckedChangeListener(new C9080g(this));
    }

    /* renamed from: v */
    public void m25740v(CloudRestoreItem cloudRestoreItem, int i10, AtomicBoolean atomicBoolean) {
        this.f19435k = cloudRestoreItem;
        this.f19432h = atomicBoolean != null ? atomicBoolean : new AtomicBoolean(false);
        if (cloudRestoreItem == null) {
            this.f19426b.setVisibility(8);
            C11839m.m70689w("CloudRestoreBasicView", "setBaseData restoreItem  null");
            return;
        }
        List<CloudRestoreItem> listM29202r = cloudRestoreItem.m29202r();
        if (listM29202r == null) {
            this.f19426b.setVisibility(8);
            C11839m.m70689w("CloudRestoreBasicView", "setBaseData restoreItem child null");
            return;
        }
        if (i10 != 2 || listM29202r.size() <= 3) {
            this.f19427c.setVisibility(8);
        } else {
            this.f19427c.setVisibility(0);
        }
        this.f19426b.setVisibility(0);
        if (this.f19430f == null) {
            CloudRestoreBasicOptionsAdapter cloudRestoreBasicOptionsAdapter = new CloudRestoreBasicOptionsAdapter(this.f19425a, true);
            this.f19430f = cloudRestoreBasicOptionsAdapter;
            this.f19431g.setAdapter(cloudRestoreBasicOptionsAdapter);
        }
        this.f19430f.m24931Q(i10);
        this.f19430f.m24932R(atomicBoolean);
        this.f19430f.m24933S(listM29202r);
        m25739u(cloudRestoreItem, false);
    }

    public CloudRestoreBasicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public CloudRestoreBasicView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public CloudRestoreBasicView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f19425a = context;
        m25736l(context);
    }
}
