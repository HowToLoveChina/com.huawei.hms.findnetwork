package com.huawei.android.remotecontrol;

import android.content.Context;
import bf.AbstractC1177c;
import cf.C1425a;
import com.huawei.android.remotecontrol.alarm.C4328a;
import com.huawei.android.remotecontrol.alarm.C4329b;
import com.huawei.android.remotecontrol.controller.cmd.ExecuteCmdBuilder;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import java.lang.reflect.InvocationTargetException;
import p289fg.C9691a;
import p366if.C10481f;
import p427kf.C11047a;
import p427kf.C11048b;
import p427kf.C11049c;
import p772xe.C13779d;
import p809yg.C13981a;
import p841ze.C14288b;
import p841ze.C14289c;
import p842zf.C14296d;
import p843zg.C14300a;
import se.C12779a;
import ve.C13412d;

/* loaded from: classes4.dex */
public class CMCmdBuilder implements ExecuteCmdBuilder.IBuilder {
    static {
        ExecuteCmdBuilder.registerBuilder(new CMCmdBuilder());
    }

    @Override // com.huawei.android.remotecontrol.controller.cmd.ExecuteCmdBuilder.IBuilder
    public AbstractC1177c executeCmd(Context context, PushCmdParser pushCmdParser) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (pushCmdParser == null) {
            C13981a.m83988e("CMCmdBuilder", "Receive PushCmd and executeCmd,but parser is null");
            return null;
        }
        String operation = pushCmdParser.getOperation();
        C13981a.m83989i("CMCmdBuilder", "Receive PushCmd and executeCmd operation:" + operation);
        if ("locate".equals(operation)) {
            C14300a.m85168a(operation);
            return C10481f.m64431g(context, pushCmdParser, true, "common_locate");
        }
        if ("bell".equals(operation)) {
            return new C12779a(pushCmdParser, context);
        }
        if ("clear".equals(operation)) {
            return new C14288b(pushCmdParser, context);
        }
        if ("inactive".equals(operation)) {
            return new C1425a(pushCmdParser, context);
        }
        if ("openLostPattern".equals(operation)) {
            C11048b c11048b = new C11048b(pushCmdParser, context);
            c11048b.m7428V(1);
            return c11048b;
        }
        if ("editLostPattern".equals(operation)) {
            return new C11047a(pushCmdParser, context);
        }
        if ("stopLostPattern".equals(operation)) {
            return new C11049c(pushCmdParser, context);
        }
        if ("cancelClear".equals(operation)) {
            return new C14289c(pushCmdParser, context);
        }
        if ("perDevicelocate".equals(operation)) {
            return new C13779d(pushCmdParser, context, null);
        }
        if ("perDevicebell".equals(operation)) {
            return new C4328a(pushCmdParser, context);
        }
        if ("cancelPerDevicebell".equals(operation)) {
            return new C4329b(pushCmdParser, context);
        }
        if ("perDeviceInactive".equals(operation)) {
            return new C13412d(pushCmdParser, context);
        }
        if ("shareLocate".equals(operation)) {
            C14300a.m85168a(operation);
            return C10481f.m64434j(context, pushCmdParser);
        }
        if ("pullUpFindNetwork".equals(operation)) {
            return new C14296d(pushCmdParser, context);
        }
        if ("trustRingChange".equals(operation)) {
            return new C9691a(pushCmdParser, context);
        }
        C13981a.m83989i("CMCmdBuilder", "executeCmd object is null");
        return null;
    }
}
