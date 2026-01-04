package com.huawei.android.hicloud.p088ui.uiadapter;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hicloud.base.bean.SyncItemInfo;
import com.huawei.hicloud.notification.constants.HNConstants;
import gp.C10028c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import p015ak.C0209d;
import p020ap.C1008c;
import p336he.C10155f;
import p422k9.C11019b;

/* loaded from: classes3.dex */
public class BaseDataItemRecyclerAdapter extends SyncItemRecyclerAdapter {

    /* renamed from: o */
    public Context f18599o;

    public BaseDataItemRecyclerAdapter(Context context) {
        super(context);
        this.f18599o = context;
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter
    /* renamed from: G */
    public void mo24837G(final LinkedHashMap<String, SyncItemInfo> linkedHashMap) {
        if (this.f18913g == null) {
            this.f18912f.clear();
            m5213j();
            return;
        }
        final ArrayList arrayList = new ArrayList();
        new ArrayList(C1008c.m6035v().m6036A(this.f18599o)).forEach(new Consumer() { // from class: ae.i0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f487a.m24839Q(linkedHashMap, arrayList, (String) obj);
            }
        });
        this.f18912f.clear();
        this.f18912f.addAll(arrayList);
        m5213j();
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter
    /* renamed from: I */
    public boolean mo24838I(String str) {
        List<String> listM6037B = C1008c.m6035v().m6037B(this.f18599o);
        if (TextUtils.equals(str, "wlan")) {
            return !C10028c.m62183d0(this.f18599o).m62395t1("funcfg_wlan") || listM6037B.contains(str);
        }
        if (TextUtils.equals(str, "addressbook")) {
            return (C10155f.m63302z() && C11019b.m66371t().m66401U("funcfg_contacts") && !listM6037B.contains(str)) ? false : true;
        }
        if (TextUtils.equals(str, "notepad")) {
            return (C10155f.m63252E() && C11019b.m66371t().m66401U("funcfg_notes") && C0209d.m1215U1(this.f18599o) && !listM6037B.contains(str)) ? false : true;
        }
        if (TextUtils.equals(str, "browser")) {
            return !C10155f.m63296t(this.f18599o) || C0209d.m1293p1() || listM6037B.contains(str);
        }
        if (TextUtils.equals(str, "calendar")) {
            return (C10155f.m63297u() && C11019b.m66371t().m66401U("funcfg_calendar") && !listM6037B.contains(str)) ? false : true;
        }
        if (TextUtils.equals(str, HNConstants.DataType.MEDIA)) {
            return true;
        }
        return listM6037B.contains(str);
    }

    /* renamed from: Q */
    public final /* synthetic */ void m24839Q(LinkedHashMap linkedHashMap, ArrayList arrayList, String str) {
        if (!linkedHashMap.containsKey(str) || mo24840R(str)) {
            return;
        }
        arrayList.add((SyncItemInfo) linkedHashMap.get(str));
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter
    /* renamed from: R */
    public boolean mo24840R(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return mo24838I(str);
    }

    @Override // com.huawei.android.hicloud.p088ui.uiadapter.SyncItemRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.AbstractC0838h
    /* renamed from: e */
    public int mo721e() {
        return this.f18912f.size();
    }
}
