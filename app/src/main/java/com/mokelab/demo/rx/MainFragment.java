package com.mokelab.demo.rx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mokelab.demo.rx.observable.ObservableFragment;

/**
 * Main fragment
 */
public class MainFragment extends ListFragment {
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] label = getResources().getStringArray(R.array.main_labels);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, label);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
        case 0:
            showFragment(ObservableFragment.newInstance());
            break;
        }
    }

    private void showFragment(Fragment next) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.addToBackStack("");
        transaction.replace(R.id.container, next);

        transaction.commit();
    }
}
