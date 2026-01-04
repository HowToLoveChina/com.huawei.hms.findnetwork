package p703v8;

import com.google.gson.Gson;
import com.huawei.hicloud.base.bean.FamilyDetailInfoResult;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: v8.g */
/* loaded from: classes2.dex */
public class C13370g {
    /* renamed from: a */
    public FamilyDetailInfoResult m80270a() {
        try {
            return (FamilyDetailInfoResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78750n(), FamilyDetailInfoResult.class);
        } catch (Exception e10) {
            C11839m.m70687e("GetFamilyDetailInfoRequestor", "get familydetailinfo requestor exception:" + e10.toString());
            return null;
        }
    }
}
