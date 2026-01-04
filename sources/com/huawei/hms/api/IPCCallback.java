package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class IPCCallback extends IAIDLCallback.Stub {
    private static final String TAG = "IPCCallback";
    private final DatagramTransport.InterfaceC6400a mCallback;
    private final Class<? extends IMessageEntity> mResponseClass;

    public IPCCallback(Class<? extends IMessageEntity> cls, DatagramTransport.InterfaceC6400a interfaceC6400a) {
        this.mResponseClass = cls;
        this.mCallback = interfaceC6400a;
    }

    @Override // com.huawei.hms.core.aidl.IAIDLCallback
    public void call(DataBuffer dataBuffer) throws RemoteException {
        IMessageEntity iMessageEntityNewResponseInstance;
        if (dataBuffer == null || TextUtils.isEmpty(dataBuffer.URI)) {
            HMSLog.m36986e(TAG, "In call, URI cannot be empty.");
            throw new RemoteException();
        }
        MessageCodec messageCodecFind = CodecLookup.find(dataBuffer.getProtocol());
        if (dataBuffer.getBodySize() > 0) {
            iMessageEntityNewResponseInstance = newResponseInstance();
            if (iMessageEntityNewResponseInstance != null) {
                messageCodecFind.decode(dataBuffer.getBody(), iMessageEntityNewResponseInstance);
            }
        } else {
            iMessageEntityNewResponseInstance = null;
        }
        DatagramTransport.InterfaceC6400a interfaceC6400a = this.mCallback;
        if (interfaceC6400a != null) {
            if (dataBuffer.header == null) {
                interfaceC6400a.mo36643a(0, iMessageEntityNewResponseInstance);
                return;
            }
            ResponseHeader responseHeader = new ResponseHeader();
            messageCodecFind.decode(dataBuffer.header, responseHeader);
            this.mCallback.mo36643a(responseHeader.getStatusCode(), iMessageEntityNewResponseInstance);
        }
    }

    public IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> cls = this.mResponseClass;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e10) {
            HMSLog.m36986e(TAG, "In newResponseInstance, instancing exception." + e10.getMessage());
            return null;
        }
    }
}
