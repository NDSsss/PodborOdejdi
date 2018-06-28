package com.example.nds.podborodejdi2;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LookFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LookFragment extends Fragment
implements View.OnClickListener
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ImageView imgw1,imgw2,imgw3;
    ImageButton btn_imgw1l,btn_imgw1r,btn_imgw2l,btn_imgw2r,btn_imgw3l,btn_imgw3r;
    MainActivity.Footbolka[] footbolkas= new MainActivity.Footbolka[20];
    MainActivity.Shtani[] shtanis = new MainActivity.Shtani[20];
    MainActivity.Obuv[] obuvs= new MainActivity.Obuv[20];
    int curr_footbolka=0,curr_shtani=0,curr_obuv=0;

    public void img_btn_click(View view) {
    }

    public LookFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LookFragment newInstance(String param1, String param2) {
        LookFragment fragment = new LookFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_look, null);
        //Log.d(TAG,String.valueOf(footbolkas[0].id));


        imgw1=(ImageView) view.findViewById(R.id.look_imgw1);
        imgw2=(ImageView) view.findViewById(R.id.look_imgw2);
        imgw3=(ImageView) view.findViewById(R.id.look_imgw3);

        btn_imgw1l = (ImageButton) view.findViewById(R.id.look_imgw1l);
        btn_imgw1l.setOnClickListener(this);
        btn_imgw1r = (ImageButton) view.findViewById(R.id.look_imgw1r);
        btn_imgw1r.setOnClickListener(this);
        btn_imgw2l = (ImageButton) view.findViewById(R.id.look_imgw2l);
        btn_imgw2l.setOnClickListener(this);
        btn_imgw2r = (ImageButton) view.findViewById(R.id.look_imgw2r);
        btn_imgw2r.setOnClickListener(this);
        btn_imgw3l = (ImageButton) view.findViewById(R.id.look_imgw3l);
        btn_imgw3l.setOnClickListener(this);
        btn_imgw3r = (ImageButton) view.findViewById(R.id.look_imgw3r);
        btn_imgw3r.setOnClickListener(this);

        for (int i = 0; i < 3; i++) {
            footbolkas[i]= new MainActivity.Footbolka();
            shtanis[i]=new MainActivity.Shtani();
            obuvs[i]=new MainActivity.Obuv();
        }

        footbolkas=((MainActivity)getActivity()).getAllFootbolkas();
        imgw1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imgw1.setImageResource(footbolkas[curr_footbolka].id);
        shtanis=((MainActivity)getActivity()).getAllShtanis();
        imgw2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imgw2.setImageResource(shtanis[curr_shtani].id);
        obuvs=((MainActivity)getActivity()).getAllObuvs();
        imgw3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imgw3.setImageResource(obuvs[curr_obuv].id);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.look_imgw1l:
                if(curr_footbolka>0)
                    curr_footbolka--;
                else
                    curr_footbolka=2;
                imgw1.setImageResource(footbolkas[curr_footbolka].id);
                break;
            case R.id.look_imgw1r:
                if(curr_footbolka<2)
                    curr_footbolka++;
                else
                    curr_footbolka=0;
                imgw1.setImageResource(footbolkas[curr_footbolka].id);
                break;
            case R.id.look_imgw2l:
                if(curr_shtani>0)
                    curr_shtani--;
                else
                    curr_shtani=2;
                imgw2.setImageResource(shtanis[curr_shtani].id);
                break;
            case R.id.look_imgw2r:
                if(curr_shtani<2)
                    curr_shtani++;
                else
                    curr_shtani=0;
                imgw2.setImageResource(shtanis[curr_shtani].id);
                break;
            case R.id.look_imgw3l:
                if(curr_obuv>0)
                    curr_obuv--;
                else
                    curr_obuv=2;
                imgw3.setImageResource(obuvs[curr_obuv].id);
                break;
            case R.id.look_imgw3r:
                if(curr_obuv<2)
                    curr_obuv++;
                else
                    curr_obuv=0;
                imgw3.setImageResource(obuvs[curr_obuv].id);
                break;
        }

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
