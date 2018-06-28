package com.example.nds.podborodejdi2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PodborFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PodborFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PodborFragment extends Fragment


{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public ImageSwitcher imgsw1,imgsw2,imgsw3;
    private int position = 0;
    private Button btn_main;
    public static String TAG = "myTag";
    MainActivity.Footbolka footbolka_na_pokaz;
    MainActivity.Shtani shtani_na_pokaz;
    MainActivity.Obuv obuv_na_pokaz;
    MainActivity.Footbolka[] footbolkas= new MainActivity.Footbolka[3];


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ViewSwitcher.ViewFactory factory ;

    public PodborFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PodborFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PodborFragment newInstance(String param1, String param2) {
        PodborFragment fragment = new PodborFragment();
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
        View view =inflater.inflate(R.layout.fragment_podbor, null);
        btn_main = (Button) view.findViewById(R.id.pod_btn_main);

        imgsw1 = (ImageSwitcher) view.findViewById(R.id.pod_imgsw1);
        imgsw2 = (ImageSwitcher) view.findViewById(R.id.pod_imgsw2);
        imgsw3 = (ImageSwitcher) view.findViewById(R.id.pod_imgsw3);

        factory =new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(
                        new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                );
                return imageView;
            }
        };

        imgsw1.setFactory(factory);
        footbolka_na_pokaz=((MainActivity)getActivity()).getFootbolka();
        imgsw1.setImageResource(footbolka_na_pokaz.id);
        imgsw2.setFactory(factory);
        shtani_na_pokaz=((MainActivity)getActivity()).getShtani();
        imgsw2.setImageResource(shtani_na_pokaz.id);
        imgsw3.setFactory(factory);
        obuv_na_pokaz=((MainActivity)getActivity()).getObuv();
        imgsw3.setImageResource(obuv_na_pokaz.id);

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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

        void onFragmentInteraction(Uri uri);
    }
}
