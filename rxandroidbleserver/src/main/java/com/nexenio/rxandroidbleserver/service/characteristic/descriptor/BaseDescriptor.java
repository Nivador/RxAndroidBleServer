package com.nexenio.rxandroidbleserver.service.characteristic.descriptor;

import android.bluetooth.BluetoothGattDescriptor;

import com.nexenio.rxandroidbleserver.request.RxBleReadRequest;
import com.nexenio.rxandroidbleserver.request.RxBleWriteRequest;
import com.nexenio.rxandroidbleserver.request.descriptor.RxBleDescriptorReadRequest;
import com.nexenio.rxandroidbleserver.request.descriptor.RxBleDescriptorWriteRequest;
import com.nexenio.rxandroidbleserver.response.RxBleServerResponse;
import com.nexenio.rxandroidbleserver.service.value.BaseValueContainer;

import java.util.UUID;

import androidx.annotation.NonNull;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class BaseDescriptor extends BaseValueContainer implements RxBleDescriptor {

    protected final BluetoothGattDescriptor gattDescriptor;

    public BaseDescriptor(@NonNull UUID uuid, int permissions) {
        this.gattDescriptor = new BluetoothGattDescriptor(uuid, permissions);
    }

    public BaseDescriptor(@NonNull BluetoothGattDescriptor gattDescriptor) {
        this.gattDescriptor = gattDescriptor;
    }

    @Override
    public UUID getUuid() {
        return gattDescriptor.getUuid();
    }

    @Override
    public BluetoothGattDescriptor getGattDescriptor() {
        return gattDescriptor;
    }

    @Override
    public Single<RxBleServerResponse> createReadRequestResponse(@NonNull RxBleDescriptorReadRequest request) {
        return createReadRequestResponse((RxBleReadRequest) request);
    }

    @Override
    public Maybe<RxBleServerResponse> createWriteRequestResponse(@NonNull RxBleDescriptorWriteRequest request) {
        return createWriteRequestResponse((RxBleWriteRequest) request);
    }

    @Override
    public String toString() {
        return "BaseDescriptor{" +
                "sharedValue=" + sharedValueProvider.getValue().blockingGet() +
                '}';
    }

}
