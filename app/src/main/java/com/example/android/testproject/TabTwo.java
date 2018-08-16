package com.example.android.testproject;

import android.content.pm.PackageManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.security.Permission;
import java.util.Random;

import static android.Manifest.permission.CAMERA;

public class TabTwo extends Fragment {

    public TabTwo(){}

    SeekBar seekBar;
    ImageView imageView;
    Random random = new Random();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.second_fragment,container,false);

            seekBar = (SeekBar)view.findViewById(R.id.seek);
            imageView = (ImageView) view.findViewById(R.id.imageview);

            return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(ContextCompat.checkSelfPermission(getContext(),CAMERA)== PackageManager.PERMISSION_GRANTED){
                    String str = "ic_" + random.nextInt(11);
                    imageView.setImageDrawable(getResources().getDrawable(getContext().getResources().getIdentifier(str, "drawable",
                            getContext().getApplicationInfo().packageName)));
                }
                else if (shouldShowRequestPermissionRationale(CAMERA)){

                    Snackbar snackbar = Snackbar.make(view,"Please enable storage permission",Snackbar.LENGTH_INDEFINITE);
                    snackbar.setAction("OK",new OkListener());
                    snackbar.show();
                    //requestPermissions(new String[]{CAMERA},100);
                }
                else
                {
                    requestPermissions(new String[]{CAMERA},100);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public class OkListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            requestPermissions(new String[]{CAMERA},100);
        }
    }
}
