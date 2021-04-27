package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private List<Integer> mImageIds;
    private int mIndex;

    public static final String IMAGE_ID_LIST ="image_ids";
    public static final String LIST_INDEX ="list_index";

    public BodyPartFragment(){

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState!= null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View  rootView= inflater.inflate(R.layout.fragment_body_part,container,false);
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);
        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mIndex));
        }else{
            Log.v("BodyPartFragment","This fragments has a null list of imageIds");
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex < mImageIds.size()-1){
                    mIndex++;
                }else{
                    mIndex = 0;
                }
                imageView.setImageResource(mImageIds.get(mIndex));
            }
        });


        return rootView ;
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmIndex(int mIndex) {
        this.mIndex = mIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>)mImageIds);
        currentState.putInt(LIST_INDEX,mIndex);
    }
}
