package com.huawei.hmf.tasks;

import android.app.Activity;
import java.util.concurrent.Executor;
import p208cq.InterfaceC8934b;
import p208cq.InterfaceC8936d;
import p208cq.InterfaceC8937e;
import p208cq.InterfaceC8938f;
import p208cq.InterfaceC8939g;
import p208cq.InterfaceC8940h;

/* loaded from: classes8.dex */
public abstract class Task<TResult> {
    public Task<TResult> addOnCanceledListener(Activity activity, InterfaceC8936d interfaceC8936d) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCompleteListener(Activity activity, InterfaceC8937e<TResult> interfaceC8937e) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public abstract Task<TResult> addOnFailureListener(Activity activity, InterfaceC8938f interfaceC8938f);

    public abstract Task<TResult> addOnFailureListener(InterfaceC8938f interfaceC8938f);

    public abstract Task<TResult> addOnFailureListener(Executor executor, InterfaceC8938f interfaceC8938f);

    public abstract Task<TResult> addOnSuccessListener(Activity activity, InterfaceC8939g<TResult> interfaceC8939g);

    public abstract Task<TResult> addOnSuccessListener(InterfaceC8939g<TResult> interfaceC8939g);

    public abstract Task<TResult> addOnSuccessListener(Executor executor, InterfaceC8939g<TResult> interfaceC8939g);

    public <TContinuationResult> Task<TContinuationResult> continueWith(InterfaceC8934b<TResult, TContinuationResult> interfaceC8934b) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(InterfaceC8934b<TResult, Task<TContinuationResult>> interfaceC8934b) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public abstract Exception getException();

    public abstract TResult getResult();

    public abstract <E extends Throwable> TResult getResultThrowException(Class<E> cls) throws Throwable;

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(InterfaceC8940h<TResult, TContinuationResult> interfaceC8940h) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public Task<TResult> addOnCanceledListener(InterfaceC8936d interfaceC8936d) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCompleteListener(InterfaceC8937e<TResult> interfaceC8937e) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, InterfaceC8934b<TResult, TContinuationResult> interfaceC8934b) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, InterfaceC8934b<TResult, Task<TContinuationResult>> interfaceC8934b) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, InterfaceC8940h<TResult, TContinuationResult> interfaceC8940h) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    public Task<TResult> addOnCanceledListener(Executor executor, InterfaceC8936d interfaceC8936d) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented.");
    }

    public Task<TResult> addOnCompleteListener(Executor executor, InterfaceC8937e<TResult> interfaceC8937e) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }
}
