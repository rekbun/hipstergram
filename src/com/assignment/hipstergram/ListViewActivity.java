package com.assignment.hipstergram;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.sql.SQLException;
import java.util.List;

public class ListViewActivity extends ListActivity {
    private ImageDataSource dataSource;
    List<ImageBlock> values;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource=new ImageDataSource(this);
        try {
            dataSource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        values=dataSource.getAllImagesInfo();
        final SimpleArrayAdapter adapter=new SimpleArrayAdapter(this,android.R.layout.simple_list_item_1,values);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                openActivity(position);
            }

        });

        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
                final ImageBlock item = (ImageBlock) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                dataSource.deleteImage(values.get(position).id);
                                values.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                               return;
                            }
                        });
                return false;
            }
        });
    }


    public void openActivity(int position) {
        Intent intent=new Intent(this,ShowImage.class);
        intent.putExtra("path",values.get(position).getPath());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        try {
            dataSource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        dataSource.close();
        super.onPause();
    }
}
