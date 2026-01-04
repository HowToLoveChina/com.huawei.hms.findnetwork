package p732w8;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.base.bean.InviteFamilyMemberResult;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p652t9.EnumC12999a;
import to.C13049a;

/* renamed from: w8.w */
/* loaded from: classes2.dex */
public class C13572w extends AbstractC12367d {

    /* renamed from: a */
    public Handler f61065a;

    /* renamed from: b */
    public long[] f61066b;

    public C13572w(Handler handler, long[] jArr) {
        this.f61065a = handler;
        this.f61066b = jArr;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        Message messageObtain = Message.obtain(this.f61065a);
        try {
            InviteFamilyMemberResult inviteFamilyMemberResult = (InviteFamilyMemberResult) new Gson().fromJson(new C13049a(EnumC12999a.CLOUD_MORE, null).m78710I(this.f61066b), InviteFamilyMemberResult.class);
            messageObtain.what = FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_SUCCESS;
            messageObtain.obj = inviteFamilyMemberResult;
            Bundle bundle = new Bundle();
            bundle.putLongArray(FamilyShareConstants.INVITE_FAMILY_MEMBER_REQUEST_UID_KEY, this.f61066b);
            messageObtain.setData(bundle);
        } catch (JsonSyntaxException e10) {
            C11839m.m70687e("InviteFamilyMemberTask", "InviteFamilyMemberTask json exception:" + e10.toString());
        } catch (C9721b e11) {
            C11839m.m70687e("InviteFamilyMemberTask", "InviteFamilyMemberTask exception:" + e11.toString());
            messageObtain.what = FamilyShareConstants.MessageCode.INVITE_FAMILY_MEMBER_FAILED;
            messageObtain.arg1 = e11.m60663g();
        }
        this.f61065a.sendMessage(messageObtain);
    }
}
