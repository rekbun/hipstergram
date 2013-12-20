package com.assignment.hipstergram;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.sql.SQLException;
import java.util.List;

public class ListViewActivity extends ListActivity {
    private ImageDataSource dataSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataSource=new ImageDataSource(this);
        try {
            dataSource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<ImageBlock> values=dataSource.getAllImagesInfo();
        ArrayAdapter<ImageBlock> adapter=new ArrayAdapter<ImageBlock>(this,android.R.layout.simple_list_item_1,values);
        setListAdapter(adapter);
    }


    public void openActivity(View view) {
        Intent intent=new Intent(this,ShowImage.class);
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
