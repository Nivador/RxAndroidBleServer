package com.nexenio.rxandroidbleserver;

import android.bluetooth.BluetoothGattServer;

import com.nexenio.rxandroidbleserver.client.RxBleClient;
import com.nexenio.rxandroidbleserver.service.RxBleService;

import java.util.Set;
import java.util.UUID;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface RxBleServer {

    Single<BluetoothGattServer> getGattServer();

    Completable provideServices();

    Completable provideServicesAndAdvertise(@NonNull UUID uuid1, @NonNull UUID uuid2);

    Completable advertise(@NonNull UUID uuid1, @NonNull UUID uuid2);

    Completable addService(@NonNull RxBleService service);

    Completable removeService(@NonNull RxBleService service);

    Set<RxBleService> getServices();

    Set<RxBleClient> getClients();

    Completable connect(@NonNull RxBleClient client);

    Completable disconnect(@NonNull RxBleClient client);

    Observable<RxBleClient> observerClientConnectionStateChanges();

    Observable<RxBleClient> observerClientNotifications();

    Observable<Integer> observerClientMtu();

}
