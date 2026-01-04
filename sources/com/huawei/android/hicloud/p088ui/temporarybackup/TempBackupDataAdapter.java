package com.huawei.android.hicloud.p088ui.temporarybackup;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.bean.RuleConfig;
import com.huawei.android.hicloud.cloudbackup.process.util.C2629f;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.temporarybackup.TempBackupDataAdapter;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.HNConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;
import p015ak.C0223k;
import p211d.C8968a;
import p292fn.C9733f;
import p514o9.C11839m;
import p618rm.C12580p;
import p618rm.C12590s0;
import p840zd.C14200d1;
import p840zd.C14229k2;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TempBackupDataAdapter extends RecyclerView.AbstractC0838h<RecyclerView.AbstractC0833c0> {

    /* renamed from: d */
    public final boolean f18379d;

    /* renamed from: e */
    public List<BackupOptionItem> f18380e = new ArrayList();

    /* renamed from: f */
    public Context f18381f;

    /* renamed from: g */
    public boolean f18382g;

    /* renamed from: h */
    public UpdateOptionStatusListener f18383h;

    /* renamed from: i */
    public View f18384i;

    /* renamed from: j */
    public View.OnClickListener f18385j;

    /* renamed from: k */
    public Animation f18386k;

    /* renamed from: l */
    public String f18387l;

    /* renamed from: m */
    public String f18388m;

    public interface UpdateOptionStatusListener {
        /* renamed from: d */
        void mo24495d(int i10, BackupOptionItem backupOptionItem);
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataAdapter$a */
    public class C4000a extends RecyclerView.AbstractC0833c0 {
        public C4000a(View view) {
            super(view);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.temporarybackup.TempBackupDataAdapter$b */
    public static class C4001b extends RecyclerView.AbstractC0833c0 {

        /* renamed from: u */
        public TextView f18390u;

        /* renamed from: v */
        public TextView f18391v;

        public C4001b(View view) {
            super(view);
            this.f18390u = (TextView) C12809f.m76831d(view, R$id.tv_temp_backup_check_title);
            this.f18391v = (TextView) C12809f.m76831d(view, R$id.tv_temp_backup_check_des);
        }
    }

    public TempBackupDataAdapter(View.OnClickListener onClickListener) {
        this.f18385j = onClickListener;
        m24489R();
        boolean z10 = !C9733f.m60705z().m60720O("disableCloudBackupTempHiddenAlbum");
        this.f18379d = z10;
        C11839m.m70688i("TempBackupDataAdapter", "isBackupHideGallery: " + z10);
    }

    /* renamed from: M */
    public static String m24476M(Context context, BackupOptionItem backupOptionItem) {
        String appId = backupOptionItem.getAppId();
        String appName = backupOptionItem.getAppName();
        return backupOptionItem.getParent().equals("virtualApp") ? TextUtils.isEmpty(appName) ? CloudBackupLanguageUtil.getVirtualName(appId) : appName : C14333b.m85483r().containsKey(appId) ? TextUtils.isEmpty(appName) ? C2783d.m16079E(context, appId) : appName : TextUtils.isEmpty(appName) ? C14333b.f63653e.containsKey(appId) ? C2783d.m16079E(context, appId) : C12590s0.m75884o0(backupOptionItem, new C14229k2(), context) : appName;
    }

    /* renamed from: T */
    public static /* synthetic */ boolean m24477T(String str, BackupOptionItem backupOptionItem) {
        return str.equalsIgnoreCase(backupOptionItem.getAppId());
    }

    /* renamed from: U */
    public static /* synthetic */ int m24478U(BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        return C12580p.m75586t(backupOptionItem.getAppId(), backupOptionItem2.getAppId());
    }

    /* renamed from: V */
    public static /* synthetic */ void m24479V(AtomicInteger atomicInteger, AtomicReference atomicReference, Context context, AtomicReference atomicReference2, BackupOptionItem backupOptionItem) {
        int andIncrement = atomicInteger.getAndIncrement();
        if (andIncrement == 2) {
            atomicReference.set(m24476M(context, backupOptionItem));
        } else if (andIncrement == 3) {
            atomicReference2.set(m24476M(context, backupOptionItem));
        }
    }

    /* renamed from: W */
    public static /* synthetic */ boolean m24480W(String str, BackupOptionItem backupOptionItem) {
        return TextUtils.equals(backupOptionItem.getAppId(), str);
    }

    /* renamed from: Y */
    public static /* synthetic */ int m24481Y(String str, BackupOptionItem backupOptionItem, BackupOptionItem backupOptionItem2) {
        boolean z10 = TextUtils.equals(str, backupOptionItem.getAppId()) || backupOptionItem.getBackupSwitch();
        boolean z11 = TextUtils.equals(str, backupOptionItem2.getAppId()) || backupOptionItem2.getBackupSwitch();
        if (z10 || !z11) {
            return (!z10 || z11) ? 0 : -1;
        }
        return 1;
    }

    /* renamed from: J */
    public void m24482J(View view) {
        if (view != null) {
            this.f18384i = view;
        }
    }

    /* renamed from: K */
    public final List<BackupOptionItem> m24483K(List<BackupOptionItem> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BackupOptionItem backupOptionItem = (BackupOptionItem) it.next();
            if (SplitAppUtil.hasSplitAppSuffix(backupOptionItem.getAppId())) {
                String splitOriAppId = SplitAppUtil.getSplitOriAppId(backupOptionItem.getAppId());
                String splitAppType = SplitAppUtil.getSplitAppType(backupOptionItem.getAppId());
                if (SplitAppUtil.isTwinApp(splitAppType, splitOriAppId)) {
                    backupOptionItem.setOriBackupAppName(splitOriAppId);
                    backupOptionItem.setSplitApkType(splitAppType);
                    List arrayList2 = map.get(splitOriAppId) != null ? (List) map.get(splitOriAppId) : new ArrayList();
                    if (arrayList2 != null) {
                        arrayList2.add(backupOptionItem);
                        map.put(splitOriAppId, arrayList2);
                    }
                    it.remove();
                }
            }
        }
        if (!map.isEmpty()) {
            for (final String str : map.keySet()) {
                Optional optionalFindFirst = arrayList.stream().filter(new Predicate() { // from class: zd.v0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return TempBackupDataAdapter.m24477T(str, (BackupOptionItem) obj);
                    }
                }).findFirst();
                if (optionalFindFirst.isPresent()) {
                    BackupOptionItem backupOptionItem2 = (BackupOptionItem) optionalFindFirst.get();
                    List<BackupOptionItem> list2 = (List) map.get(str);
                    if (list2 != null) {
                        list2.sort(new Comparator() { // from class: zd.w0
                            @Override // java.util.Comparator
                            public final int compare(Object obj, Object obj2) {
                                return TempBackupDataAdapter.m24478U((BackupOptionItem) obj, (BackupOptionItem) obj2);
                            }
                        });
                        backupOptionItem2.setTwinAppsList(list2);
                        list.removeAll(list2);
                        list.addAll(list.indexOf(backupOptionItem2) + 1, list2);
                    }
                }
            }
        }
        return list;
    }

    /* renamed from: L */
    public void m24484L(final Context context) {
        if (context == null) {
            C11839m.m70688i("TempBackupDataAdapter", "initHearViewTips context is null");
            return;
        }
        this.f18387l = context.getString(R$string.temp_backup_check_title);
        Resources resources = context.getResources();
        if (resources == null) {
            C11839m.m70688i("TempBackupDataAdapter", "initHearViewTips resources is null");
            return;
        }
        int intExact = Math.toIntExact(this.f18380e.stream().filter(new C2629f()).count());
        int i10 = intExact > 3 ? 3 : intExact;
        String string = context.getString(C14333b.m85486u().get("sysdata").intValue());
        final AtomicReference atomicReference = new AtomicReference("");
        final AtomicReference atomicReference2 = new AtomicReference("");
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        this.f18380e.stream().filter(new C2629f()).limit(i10).forEach(new Consumer() { // from class: zd.t0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                TempBackupDataAdapter.m24479V(atomicInteger, atomicReference, context, atomicReference2, (BackupOptionItem) obj);
            }
        });
        if (intExact == 1 || TextUtils.isEmpty((CharSequence) atomicReference.get())) {
            this.f18388m = resources.getQuantityString(R$plurals.temp_backup_check_des, intExact, string, Integer.valueOf(intExact));
            return;
        }
        if (intExact == 2 || TextUtils.isEmpty((CharSequence) atomicReference2.get())) {
            this.f18388m = resources.getQuantityString(R$plurals.temp_backup_check_des, intExact, resources.getString(R$string.sync_data_merge_confirm_tips_double, string, atomicReference.get()), Integer.valueOf(intExact));
        } else if (intExact == 3) {
            this.f18388m = resources.getQuantityString(R$plurals.temp_backup_check_des, intExact, resources.getString(R$string.sync_data_merge_confirm_tips_triple, string, atomicReference.get(), atomicReference2.get()), Integer.valueOf(intExact));
        } else {
            this.f18388m = resources.getQuantityString(R$plurals.temp_backup_check_des_other, intExact, resources.getString(R$string.sync_data_merge_confirm_tips_triple, string, atomicReference.get(), atomicReference2.get()), Integer.valueOf(intExact));
        }
    }

    /* renamed from: N */
    public List<BackupOptionItem> m24485N() {
        return this.f18380e;
    }

    /* renamed from: O */
    public BackupOptionItem m24486O(int i10) {
        int i11 = i10 - 2;
        if (i11 < 0 || i11 >= this.f18380e.size()) {
            return null;
        }
        return this.f18380e.get(i11);
    }

    /* renamed from: P */
    public BackupOptionItem m24487P(final String str) {
        return this.f18380e.stream().filter(new Predicate() { // from class: zd.s0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TempBackupDataAdapter.m24480W(str, (BackupOptionItem) obj);
            }
        }).findFirst().orElse(null);
    }

    /* renamed from: Q */
    public int m24488Q(BackupOptionItem backupOptionItem) {
        int iIndexOf = this.f18380e.indexOf(backupOptionItem);
        if (iIndexOf != -1) {
            return iIndexOf + 2;
        }
        return 0;
    }

    /* renamed from: R */
    public final void m24489R() {
        this.f18386k = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f18386k.setInterpolator(new LinearInterpolator());
        this.f18386k.setDuration(RuleConfig.DEFAULT_BACKUP_RESTORE_TAR_COUNT);
        this.f18386k.setRepeatMode(1);
        this.f18386k.setRepeatCount(-1);
    }

    /* renamed from: S */
    public final void m24490S(Context context) {
        if (TextUtils.isEmpty(this.f18387l)) {
            m24484L(context);
        } else {
            C11839m.m70689w("TempBackupDataAdapter", "already init");
        }
    }

    /* renamed from: X */
    public final /* synthetic */ void m24491X(BackupOptionItem backupOptionItem, int i10, CompoundButton compoundButton, boolean z10) {
        if (this.f18383h != null) {
            backupOptionItem.setBackupSwitch(z10);
            if (!z10) {
                List<BackupOptionItem> twinAppsList = backupOptionItem.getTwinAppsList();
                if (!twinAppsList.isEmpty()) {
                    Iterator<BackupOptionItem> it = twinAppsList.iterator();
                    while (it.hasNext()) {
                        BackupOptionItem backupOptionItemM24487P = m24487P(it.next().getAppId());
                        if (backupOptionItemM24487P != null) {
                            backupOptionItemM24487P.setPreBackupSwitch(backupOptionItemM24487P.getBackupSwitch());
                            backupOptionItemM24487P.setBackupSwitch(false);
                            m5214k(m24488Q(backupOptionItemM24487P));
                        }
                    }
                }
            }
            backupOptionItem.setOperateTime(System.currentTimeMillis());
            backupOptionItem.setOperateType(1);
            this.f18383h.mo24495d(i10, backupOptionItem);
        }
    }

    /* renamed from: Z */
    public void m24492Z(Context context, List<BackupOptionItem> list, final String str) {
        this.f18380e.clear();
        this.f18380e.addAll(list);
        this.f18380e.sort(new Comparator() { // from class: zd.u0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TempBackupDataAdapter.m24481Y(str, (BackupOptionItem) obj, (BackupOptionItem) obj2);
            }
        });
        this.f18380e = m24483K(this.f18380e);
        m24490S(context);
        m5213j();
    }

    /* renamed from: a0 */
    public void m24493a0() {
        this.f18382g = true;
    }

    /* renamed from: b0 */
    public void m24494b0(UpdateOptionStatusListener updateOptionStatusListener) {
        this.f18383h = updateOptionStatusListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f18380e.size() + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: g */
    public int mo749g(int i10) {
        if (i10 == 0) {
            return 99999;
        }
        return i10 == 1 ? 100000 : 200000;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: s */
    public void mo723s(RecyclerView.AbstractC0833c0 abstractC0833c0, final int i10) {
        final BackupOptionItem backupOptionItemM24486O;
        if (i10 == 0) {
            ImageView imageView = (ImageView) C12809f.m76831d(this.f18384i, R$id.img_outer_ring);
            if (imageView != null) {
                imageView.startAnimation(this.f18386k);
                return;
            }
            return;
        }
        if (abstractC0833c0 instanceof C4001b) {
            C4001b c4001b = (C4001b) abstractC0833c0;
            if (TextUtils.isEmpty(this.f18387l) || TextUtils.isEmpty(this.f18388m)) {
                C11839m.m70688i("TempBackupDataAdapter", "updateHeaderView om title is null");
                c4001b.f18390u.setVisibility(8);
                c4001b.f18391v.setVisibility(8);
                return;
            } else {
                c4001b.f18390u.setText(this.f18387l);
                c4001b.f18391v.setText(this.f18388m);
                c4001b.f18390u.setVisibility(0);
                c4001b.f18391v.setVisibility(0);
                return;
            }
        }
        if (!(abstractC0833c0 instanceof C14200d1) || (backupOptionItemM24486O = m24486O(i10)) == null) {
            return;
        }
        C14200d1 c14200d1 = (C14200d1) abstractC0833c0;
        String appId = backupOptionItemM24486O.getAppId();
        if (SplitAppUtil.hasSplitAppSuffix(appId)) {
            c14200d1.f63381w.setVisibility(0);
            appId = SplitAppUtil.getSplitOriAppId(appId);
        } else {
            c14200d1.f63381w.setVisibility(8);
        }
        c14200d1.f63382x.setText(m24476M(this.f18381f, backupOptionItemM24486O));
        if (backupOptionItemM24486O.getParent().equals("virtualApp")) {
            c14200d1.f63380v.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId, null));
        } else if (C14333b.m85483r().containsKey(appId)) {
            c14200d1.f63380v.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId));
        } else {
            c14200d1.f63380v.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(appId));
        }
        c14200d1.f63383y.setVisibility(8);
        if ("baseData".equals(appId)) {
            c14200d1.f63374A.setVisibility(0);
            c14200d1.f63384z.setVisibility(8);
            c14200d1.f63374A.setOnClickListener(this.f18385j);
            c14200d1.f63374A.setAlpha(0.6f);
        } else {
            c14200d1.f63374A.setVisibility(8);
            c14200d1.f63384z.setVisibility(0);
        }
        long dataBytes = backupOptionItemM24486O.getDataBytes() + backupOptionItemM24486O.getCodeBytes();
        String strM1524g = C0223k.m1524g(this.f18381f, dataBytes);
        if (backupOptionItemM24486O.isLoadDataSucceed() || this.f18382g) {
            if (dataBytes <= 0) {
                strM1524g = this.f18381f.getString(R$string.backup_option_no_data);
            }
        } else if (dataBytes <= 0) {
            strM1524g = this.f18381f.getString(R$string.backup_loading);
        }
        c14200d1.f63375B.setText(strM1524g);
        c14200d1.f63384z.setOnCheckedChangeListener(null);
        if (!HNConstants.DataType.MEDIA.equals(appId) || this.f18379d) {
            c14200d1.f63376C.setVisibility(8);
        } else {
            String string = this.f18381f.getString(R$string.backup_gallery_tip);
            c14200d1.f63376C.setVisibility(0);
            c14200d1.f63376C.setText(string);
        }
        c14200d1.f63384z.setChecked(backupOptionItemM24486O.getBackupSwitch());
        c14200d1.f63384z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: zd.r0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f63458a.m24491X(backupOptionItemM24486O, i10, compoundButton, z10);
            }
        });
        if (this.f18380e.indexOf(backupOptionItemM24486O) == this.f18380e.size() - 1) {
            c14200d1.f63378E.setVisibility(8);
            c14200d1.f63379u.setBackground(C8968a.m56743b(this.f18381f, R$drawable.card_view_bg_bottom_radius));
        } else {
            c14200d1.f63378E.setVisibility(0);
            c14200d1.f63379u.setBackground(C8968a.m56743b(this.f18381f, R$drawable.card_view_bg_no_radius));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: u */
    public RecyclerView.AbstractC0833c0 mo724u(ViewGroup viewGroup, int i10) {
        this.f18381f = viewGroup.getContext();
        return i10 == 99999 ? new C4000a(this.f18384i) : i10 == 100000 ? new C4001b(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.temp_back_up_header, viewGroup, false)) : new C14200d1(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.temp_backup_data_item, viewGroup, false));
    }
}
