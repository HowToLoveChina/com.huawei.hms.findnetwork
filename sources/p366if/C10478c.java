package p366if;

import android.content.Context;
import android.os.Message;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import p809yg.C13981a;
import p841ze.InterfaceC14290d;

/* renamed from: if.c */
/* loaded from: classes4.dex */
public class C10478c extends AbstractC10482g {
    public C10478c(PushCmdParser pushCmdParser, Context context) {
        super(pushCmdParser, context);
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: I0 */
    public void mo64403I0() {
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: o0 */
    public boolean mo64412o0(Message message, int i10, int i11) {
        return false;
    }

    @Override // p366if.AbstractC10482g, bf.AbstractC1177c
    /* renamed from: z */
    public void mo7440z() {
        C13981a.m83990w("EmptyLocateObject", "empty command execute!");
        InterfaceC14290d interfaceC14290d = this.f50516B;
        if (interfaceC14290d != null) {
            interfaceC14290d.mo85127a();
            this.f50516B = null;
        }
    }

    @Override // p366if.AbstractC10482g
    /* renamed from: z0 */
    public void mo64414z0() {
    }
}
