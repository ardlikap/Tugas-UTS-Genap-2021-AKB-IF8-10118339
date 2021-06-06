package com.becek39studio.catatanharian_10118339.ui;

//Tanggal Pengerjaan 4 Juni 2021, 10118339, MUHAMMAD AL ARDLIKA PRIHASISWANA, IF8

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.becek39studio.catatanharian_10118339.R;
import com.becek39studio.catatanharian_10118339.dao.NoteDAO;
import com.becek39studio.catatanharian_10118339.database.table.TableNote;
import com.becek39studio.catatanharian_10118339.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView ListView01;
    ArrayList<Note> notes = new ArrayList<>();
    FloatingActionButton actionButton;
    EditText editJudul, editKategori, editIsiCatatan;
    Button btnSave, btnDelete;
    AlertDialog.Builder form;
    LayoutInflater inflate;
    View formView;

    private HomeViewModel homeViewModel;

    public HomeFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, ListView01, false);
        actionButton = (FloatingActionButton) view.findViewById(R.id.fab);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.noteFragment);
            }
        });

        ListView01 = (ListView) view.findViewById(R.id.listView);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = notes.get(position);
                Bundle bundle = new Bundle();
                bundle.putInt(TableNote.FIELD_ID, note.getId());
                Navigation.findNavController(view).navigate(R.id.noteFragment, bundle);
                //replaceFragment(bundle);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        NoteDAO noteDAO = new NoteDAO(getActivity());
        notes = noteDAO.select(null, null);
        ListView01.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, notes));
        super.onResume();
    }


}