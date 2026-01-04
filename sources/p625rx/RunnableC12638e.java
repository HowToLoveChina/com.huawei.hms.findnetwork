package p625rx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.ohos.localability.base.AlertDialogActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.ArrayList;
import ohos.ohos.ohos.ohos.ohos.C11885a;
import ohos.ohos.ohos.ohos.ohos.C11891f;

/* renamed from: rx.e */
/* loaded from: classes9.dex */
public class RunnableC12638e implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Intent f58091a;

    /* renamed from: b */
    public final /* synthetic */ int f58092b;

    /* renamed from: c */
    public final /* synthetic */ C11885a f58093c;

    /* renamed from: d */
    public final /* synthetic */ Context f58094d;

    /* renamed from: e */
    public final /* synthetic */ C11891f f58095e;

    public RunnableC12638e(C11891f c11891f, Intent intent, int i10, C11885a c11885a, Context context) {
        this.f58095e = c11891f;
        this.f58091a = intent;
        this.f58092b = i10;
        this.f58093c = c11885a;
        this.f58094d = context;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        try {
            Log.d("AbilityProxy", "wait 5 seconds to avoid update dialog problem");
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Log.e("AbilityProxy", "Thread sleep InterruptedException");
        }
        ArrayList<? extends Parcelable> arrayListM71410c = this.f58095e.m71410c(this.f58091a);
        if (arrayListM71410c == null || arrayListM71410c.isEmpty()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("dialogName", 2);
        bundle.putInt("requestCode", this.f58092b);
        bundle.putParcelableArrayList("newVersionAbilityInfos", arrayListM71410c);
        bundle.putParcelable("abilityData", this.f58093c);
        bundle.putParcelable("abilityIntent", this.f58091a);
        Intent intent = new Intent(this.f58094d, (Class<?>) AlertDialogActivity.class);
        intent.putExtras(bundle);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        this.f58094d.startActivity(intent);
    }
}
