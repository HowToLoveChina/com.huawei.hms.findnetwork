package p016an;

import android.database.Cursor;
import cn.C1461a;
import com.huawei.hicloud.bean.GraySwitch;
import fk.C9721b;
import java.util.ArrayList;
import java.util.List;
import p292fn.C9733f;
import p709vj.C13452e;

/* renamed from: an.a */
/* loaded from: classes6.dex */
public class C0313a extends AbstractC0315c<GraySwitch> {
    @Override // p016an.AbstractC0315c
    /* renamed from: a */
    public GraySwitch getVo(Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        int i10 = cursor.getInt(2);
        GraySwitch graySwitch = new GraySwitch();
        graySwitch.setFunctionId(string);
        graySwitch.setParameters(string2);
        graySwitch.setStatus(i10);
        return graySwitch;
    }

    /* renamed from: b */
    public List<GraySwitch> m1899b(String str) {
        try {
            return queryResult4Vo("select functionId, parameters, status from feature_gray where functionId=?;", new String[]{str});
        } catch (C9721b e10) {
            C1461a.m8360w("FeatureGrayOperator", "queryGraySwitchs error." + e10.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public final void m1900c() {
        C13452e.m80781L().m80859T1(Boolean.valueOf(C9733f.m60705z().m60720O("enableAuthCode")));
    }

    public void clear() {
        try {
            execSQL("delete from feature_gray;");
        } catch (C9721b e10) {
            C1461a.m8360w("FeatureGrayOperator", "clear freq_control_time error." + e10.getMessage());
        }
    }

    /* renamed from: d */
    public void m1901d(List<GraySwitch> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() == 0) {
            return;
        }
        for (GraySwitch graySwitch : list) {
            arrayList.add(new String[]{graySwitch.getFunctionId(), graySwitch.getParameters(), String.valueOf(graySwitch.getStatus())});
        }
        try {
            execSQL4Batch("replace into feature_gray(functionId, parameters, status) VALUES(?, ?, ?);", arrayList);
        } catch (C9721b e10) {
            C1461a.m8360w("FeatureGrayOperator", "replace time error." + e10.getMessage());
        }
        m1900c();
    }
}
