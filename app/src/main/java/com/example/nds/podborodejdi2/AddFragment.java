package com.example.nds.podborodejdi2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btn_save,btn_load;
    TextInputEditText txtinp;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
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
        View view =inflater.inflate(R.layout.fragment_add, null);
        btn_save = (Button) view.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        txtinp = (TextInputEditText)view.findViewById(R.id.txtinp);
        btn_load = (Button) view.findViewById(R.id.btn_load);
        btn_load.setOnClickListener(this);

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

    public void writeToFile(View v) {

        Log.d("myTag", "writeToFile");

        String string = "My test string";

        try {
            FileOutputStream outputStream = v.getContext().openFileOutput("mFileName", MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();

        } catch (Exception e) {
            Log.d("myTag", "Произошла ошибка при записи");
        }
    }

    public void readFile(View v) {

        Log.d("myTag", "readFile");

        FileInputStream stream = null;
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            stream = v.getContext().openFileInput("mFileName");

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            } finally {
                stream.close();
            }

            Log.d("myTag", "Data from file: " + sb.toString());

        } catch (Exception e) {
            Log.d("myTag", "Файла нет или произошла ошибка при чтении");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_save:
                writeToFile(v);
                break;
                case R.id.btn_load:
                    readFile(v);
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
