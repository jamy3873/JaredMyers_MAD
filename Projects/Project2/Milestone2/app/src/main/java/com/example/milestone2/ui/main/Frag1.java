package com.example.milestone2.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.milestone2.CharProfile;
import com.example.milestone2.R;

public class Frag1 extends Fragment {
    private CharProfile thisChar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        thisChar = (CharProfile) getArguments().getSerializable("myChar");
        if (thisChar != null) {
            Log.i("Character:",thisChar.characterName);
        }

        return inflater.inflate(R.layout.frag1_layout, container, false);
    }
}
