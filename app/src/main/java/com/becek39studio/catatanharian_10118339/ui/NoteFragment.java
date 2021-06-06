package com.becek39studio.catatanharian_10118339.ui;

//Tanggal Pengerjaan 5 Juni 2021, 10118339, MUHAMMAD AL ARDLIKA PRIHASISWANA, IF8

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.becek39studio.catatanharian_10118339.R;
import com.becek39studio.catatanharian_10118339.dao.NoteDAO;
import com.becek39studio.catatanharian_10118339.database.table.TableNote;
import com.becek39studio.catatanharian_10118339.model.Note;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteFragment extends Fragment {

    EditText editJudul, editKategori, editIsiCatatan;
    Button btnSave, btnDelete;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteFragment newInstance(String param1, String param2) {
        NoteFragment fragment = new NoteFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note, container, false);

        editJudul = (EditText)view.findViewById(R.id.editJudul);
        editKategori = (EditText)view.findViewById(R.id.editKategori);
        editIsiCatatan = (EditText)view.findViewById(R.id.editCatatan);
        btnSave = (Button) view.findViewById(R.id.action_save);
        btnDelete = (Button) view.findViewById(R.id.action_delete);

        if (getArguments() == null){
            btnDelete.setVisibility(View.GONE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCatatan();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCatatan();
            }
        });

        if (getArguments() != null){
            recoveryCatatan();
        }
        setHasOptionsMenu(true);

        return view;
    }


    private void recoveryCatatan(){
        Bundle args = getArguments();
        NoteDAO noteDAO = new NoteDAO(getActivity());
        ArrayList<Note> catatans = noteDAO.select(TableNote.FIELD_ID +"= ?", new String[]{String.valueOf(args.getInt(TableNote.FIELD_ID))});
        if (catatans.size() > 0){
            Note catatan = catatans.get(0);
            editJudul.setText(catatan.getJudul());
            editKategori.setText(catatan.getKategori());
            editIsiCatatan.setText(catatan.getIsi_catatan());
        }
    }

    private void saveCatatan(){
        NoteDAO noteDAO = new NoteDAO(getActivity());
        Note catatan = new Note();
        catatan.setJudul(editJudul.getText().toString().trim());
        catatan.setKategori(editKategori.getText().toString().trim());
        catatan.setIsi_catatan(editIsiCatatan.getText().toString().trim());

        if (getArguments() != null){
            catatan.setId(getArguments().getInt(TableNote.FIELD_ID));
            noteDAO.update(catatan);
        }else {
            noteDAO.insert(catatan);
        }popThisFragments();
    }

    public void deleteCatatan(){
        NoteDAO catatanDAO = new NoteDAO(getActivity());
        catatanDAO.delete(getArguments().getInt(TableNote.FIELD_ID));
        popThisFragments();
    }

    private void popThisFragments(){
        recoveryCatatan();
        getActivity().getSupportFragmentManager().popBackStack("home", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}