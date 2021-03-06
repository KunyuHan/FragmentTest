package com.kunyuhan.robot.fragmenttest;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by anroid on 2017/4/10.
 */

    public class BookListFragment extends ListFragment {
    private   Callbacks mCallbacks;
    public interface Callbacks
    {
        public void onItemSelected(Integer id);
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),android.R.layout.simple_list_item_activated_1,android.R.id.text1,BookContent.ITEMS));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(!(activity instanceof  Callbacks))
        {
            throw  new IllegalStateException("BookListFragment所在的Activity必须实现Callbacks接口！");

        }
        mCallbacks = (Callbacks)activity;
    }
    @Override
    public  void onDetach()
    {
        super.onDetach();
        mCallbacks = null;
    }
    @Override
    public  void onListItemClick(ListView listView,View view,int postion,long id)
    {
        super.onListItemClick( listView,view, postion, id);
        mCallbacks.onItemSelected(BookContent.ITEMS.get(postion).id);
    }
    public  void setActivityOnItemClick(boolean activateOnItemClick)
    {
        getListView().setChoiceMode(activateOnItemClick? ListView.CHOICE_MODE_SINGLE:ListView.CHOICE_MODE_NONE);
    }
}
