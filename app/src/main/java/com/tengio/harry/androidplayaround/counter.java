package com.tengio.harry.androidplayaround;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.EditText;
import java.util.ArrayList;


public class counter extends AppCompatActivity {



    private ListView listView;
    private ArrayAdapter listAdapter;
    private ArrayList<String> todoList = new ArrayList<String>();
    private EditText inputText;
    private FloatingActionButton fab;

    private void updateState() {
        // Create ArrayAdapter using the list & provide component
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.arrayAdapter_textview, todoList);
        // Set the ArrayAdapter as the ListView's adapter.
        listView.setAdapter(listAdapter);
        //Clear the text field
        inputText.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initListView();
        initInputText();
        initButtons();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputText.getText().length() > 0) {
                    addItemToList();
                    updateState();
                }
            }
        });
    }
    public void deleteButtonHandler(View v)
    {
        //get the row the clicked button is in
        ConstraintLayout vwParentRow = (ConstraintLayout)v.getParent();
        vwParentRow.removeView((ConstraintLayout)v.getParent());
    }

    private void addItemToList() {
        todoList.add(todoList.size(), inputText.getText().toString());
    }

    private void initListView() {
        listView = new ListView(this);
        listView = (ListView) findViewById(R.id.list_view);
    }

    private void initInputText() {
        inputText = new EditText(this);
        inputText = (EditText) findViewById(R.id.edit_text_field);
    }

    private void initButtons() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_counter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
