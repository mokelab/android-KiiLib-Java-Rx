package com.mokelab.demo.rx.observable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Fragment for Observable
 */
public class ObservableFragment extends Fragment {
    public static ObservableFragment newInstance() {
        ObservableFragment fragment = new ObservableFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // load from observable
        UserRepository repo = new UserRepository();

        int userId = 1234;
        repo.getUser(userId).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(User user) {
                Toast.makeText(getActivity(), user.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
