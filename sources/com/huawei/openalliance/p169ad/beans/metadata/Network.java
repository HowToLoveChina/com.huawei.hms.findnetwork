package com.huawei.openalliance.p169ad.beans.metadata;

import android.content.Context;
import android.util.Pair;
import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import java.util.ArrayList;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class Network {

    @InterfaceC6929a
    private List<CellInfo> cellInfo;
    private int type;

    public Network() {
        this.type = 0;
        this.cellInfo = new ArrayList(4);
    }

    /* renamed from: a */
    public int m40359a() {
        return this.type;
    }

    /* renamed from: b */
    public List<CellInfo> m40360b() {
        return this.cellInfo;
    }

    public Network(Context context, boolean z10) {
        Pair<Integer, Pair<String, String>> pairM47832f;
        this.type = 0;
        this.cellInfo = new ArrayList(4);
        this.type = C7775bv.m47830d(context);
        if (!z10 || (pairM47832f = C7775bv.m47832f(context)) == null) {
            return;
        }
        CellInfo cellInfo = new CellInfo();
        cellInfo.m39877a(pairM47832f);
        this.cellInfo.add(cellInfo);
    }
}
