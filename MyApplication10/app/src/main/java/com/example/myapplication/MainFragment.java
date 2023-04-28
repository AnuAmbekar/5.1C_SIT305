package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements RecyclerViewAdapter.ItemClickListener{

    private ArrayList<NewsClass> newsClassList = new ArrayList<>();
    private ArrayList<ImageClass> imageClassList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters

    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_main, container, false);
        createData();
        createHorizontal();
        createRecyclerHView(itemView);
        createRecyclerView(itemView);
        return itemView;
    }

    public void createData() {
        newsClassList.add(new NewsClass("Title1", "Title1Text1", R.drawable.news1));
        newsClassList.add(new NewsClass("Title2", "Title1Text2", R.drawable.news2));
        newsClassList.add(new NewsClass("Title3", "Title1Text3", R.drawable.news3));
        newsClassList.add(new NewsClass("Title4", "Title1Text4", R.drawable.news1));
        newsClassList.add(new NewsClass("Title5", "Title1Text5", R.drawable.news2));
        newsClassList.add(new NewsClass("Title6", "Title1Text6", R.drawable.news3));
        newsClassList.add(new NewsClass("Title7", "Title1Text7", R.drawable.news1));
        newsClassList.add(new NewsClass("Title8", "Title1Text8", R.drawable.news2));
        newsClassList.add(new NewsClass("Title9", "Title1Text9", R.drawable.news3));
    }

    public void createHorizontal() {
        imageClassList.add(new ImageClass(R.drawable.news1));
        imageClassList.add(new ImageClass(R.drawable.news2));
        imageClassList.add(new ImageClass(R.drawable.news3));
    }

    public void createRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter((List<NewsClass>) newsClassList, (RecyclerViewAdapter.ItemClickListener) this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void createRecyclerHView(View view) {
        RecyclerView recyclerViewHorizontal = view.findViewById(R.id.recyclerViewHorizontal);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHorizontal.setLayoutManager(layoutManager1);
        RecyclerViewAdapterH recyclerViewAdapterH = new RecyclerViewAdapterH(imageClassList);
        recyclerViewHorizontal.setAdapter(recyclerViewAdapterH);


    }
    @Override
    public void onItemClick(NewsClass newsClass) {
        Fragment fragment = ClickFragment.newInstance(newsClass.getTitle());
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("main_fragment"));

        fragmentTransaction.add(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null).commit();
    }
}