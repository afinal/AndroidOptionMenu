package com.domain.shcontextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  SHContextMenu shContextMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shContextMenu = new SHContextMenu(this);
        List<ContextMenuItem> itemList = new ArrayList<>();
        itemList.add(new ContextMenuItem(getResources().getDrawable(R.drawable.ic_menu_all), "All"));
        itemList.add(new ContextMenuItem(getResources().getDrawable(R.drawable.ic_menu_attendance), "CheckIn"));
        itemList.add(new ContextMenuItem(getResources().getDrawable(R.drawable.ic_menu_cancel), "Cancel"));
        itemList.add(new ContextMenuItem(getResources().getDrawable(R.drawable.ic_menu_chat), "Chat"));
        itemList.add(new ContextMenuItem(getResources().getDrawable(R.drawable.ic_menu_complete), "Complete"));
        shContextMenu.setItemList(itemList);
        shContextMenu.setOnItemSelectListener(new SHContextMenu.OnItemSelectListener() {
            @Override
            public void onItemSelect(int position) {
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hello, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        shContextMenu.showMenu();
        return super.onOptionsItemSelected(item);
    }
}
