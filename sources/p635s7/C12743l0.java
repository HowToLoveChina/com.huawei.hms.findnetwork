package p635s7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.p075vo.ShareAlbumData;
import com.huawei.android.hicloud.album.service.p075vo.ShareReceiverData;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import p031b7.C1122c;
import p650t7.C12956b0;
import p650t7.C12958c0;
import p650t7.C12992z;
import p764x6.AbstractC13709a;
import p765x7.C13721c;

/* renamed from: s7.l0 */
/* loaded from: classes2.dex */
public class C12743l0 extends AbstractC12758w {

    /* renamed from: l */
    public ShareAlbumData f58355l;

    /* renamed from: m */
    public List<ShareReceiverData> f58356m;

    /* renamed from: n */
    public List<ShareReceiverData> f58357n;

    /* renamed from: o */
    public int f58358o;

    /* renamed from: p */
    public CallbackHandler f58359p;

    public C12743l0(Context context, String str, ShareAlbumData shareAlbumData) throws Throwable {
        this.f58356m = null;
        this.f58357n = null;
        this.f58358o = -1;
        this.f60186b = context;
        this.f60189e = str;
        this.f58355l = shareAlbumData;
        this.f60187c = m80109h("/JPJX/CloudPhoto");
        this.f58397k = "share.update";
        if (shareAlbumData != null) {
            m80104c(shareAlbumData.getShareId());
        }
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: a */
    public void mo14589a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        jSONObject.put("ownerId", this.f58355l.getOwnerId());
        jSONObject.put("resource", PowerKitApplyUtil.GROUP_ALBUM);
        jSONObject.put("shareId", this.f58355l.getShareId());
        if (this.f58355l.getShareName() != null) {
            jSONObject.put("shareName", this.f58355l.getShareName());
        }
        List<ShareReceiverData> list = this.f58356m;
        if (list != null && list.size() > 0) {
            for (ShareReceiverData shareReceiverData : this.f58356m) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("receiverId", shareReceiverData.getReceiverId());
                jSONObject2.put("receiverAcc", shareReceiverData.getReceiverAcc());
                jSONArray.put(jSONObject2);
            }
        }
        jSONObject.put("delReceiverList", jSONArray);
        List<ShareReceiverData> list2 = this.f58357n;
        if (list2 != null && list2.size() > 0) {
            for (ShareReceiverData shareReceiverData2 : this.f58357n) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("receiverId", shareReceiverData2.getReceiverId());
                jSONObject3.put("receiverAcc", shareReceiverData2.getReceiverAcc());
                jSONArray2.put(jSONObject3);
            }
        }
        jSONObject.put("addReceiverList", jSONArray2);
        jSONObject.put("cmd", this.f58397k);
        if (!TextUtils.isEmpty(this.f58355l.getExpandString())) {
            jSONObject.put("expand", new JSONObject(this.f58355l.getExpandString()));
        }
        this.f60188d = jSONObject.toString();
    }

    @Override // p701v6.AbstractC13354a
    /* renamed from: n */
    public AbstractC13709a mo14591n() {
        int i10 = this.f58358o;
        if (i10 == -1) {
            this.f58397k = "Share.Albums.update.patchmetadata";
            C12992z c12992z = new C12992z(this.f58355l);
            c12992z.m82456i(this.f60189e);
            return c12992z;
        }
        if (1 == i10 || 2 == i10) {
            this.f58397k = "Share.Permissions.delete";
            C12958c0 c12958c0 = new C12958c0(this.f58355l, this.f58356m, i10, this.f58359p);
            c12958c0.m82456i(this.f60189e);
            return c12958c0;
        }
        this.f58397k = "Share.Permissions.create";
        C12956b0 c12956b0 = new C12956b0(this.f58355l, this.f58357n, this.f58359p);
        c12956b0.m82456i(this.f60189e);
        return c12956b0;
    }

    @Override // p635s7.AbstractC12758w
    /* renamed from: u */
    public Bundle mo15143u(String str) {
        Bundle bundleM82485a = C13721c.m82485a(str);
        bundleM82485a.putInt("modifyShareType", this.f58358o);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        List<ShareReceiverData> list = this.f58356m;
        if (list != null) {
            arrayList.addAll(list);
            bundleM82485a.putParcelableArrayList("UpdataShareReceiver", arrayList);
        } else {
            List<ShareReceiverData> list2 = this.f58357n;
            if (list2 != null) {
                arrayList.addAll(list2);
                bundleM82485a.putParcelableArrayList("UpdataShareReceiver", arrayList);
            }
        }
        bundleM82485a.putParcelable("ShareInfo", this.f58355l);
        bundleM82485a.putParcelableArrayList("ShareReceiverList", arrayList);
        return bundleM82485a;
    }

    public C12743l0(Context context, ShareAlbumData shareAlbumData, List<ShareReceiverData> list, List<ShareReceiverData> list2, int i10, CallbackHandler callbackHandler) throws Throwable {
        this.f60186b = context;
        this.f58355l = shareAlbumData;
        this.f58356m = list;
        this.f58357n = list2;
        this.f58358o = i10;
        this.f60187c = m80109h("/JPJX/CloudPhoto");
        this.f58397k = "share.update";
        this.f60189e = C1122c.m6755Z0("04006");
        m80115r();
        if (shareAlbumData != null) {
            m80104c(shareAlbumData.getShareId());
        }
        this.f58359p = callbackHandler;
    }
}
