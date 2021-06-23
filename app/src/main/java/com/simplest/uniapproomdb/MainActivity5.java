package com.simplest.uniapproomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    ArrayList<String> arrayList = new ArrayList<>();
    String tran, amot, travel;
    private RecyclerView recyclerView;
    ImageView menubtn;
    int onCheck;
    private List<Client> clientList = new ArrayList<>();
    private Context context;
    private ClientAdapter clientAdapter;
    private  Client client;


    // final Client client = (Client) getIntent().getSerializableExtra("client");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        // clientAdapter = new ClientAdapter(context, clientList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(clientAdapter);
       // buttonAddTask = findViewById(R.id.floatingActionButton);
        //menubtn = (ImageView) findViewById(R.id.menubt);

        /* menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menubtn();
            }
        });*/

      /*  buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                startActivity(intent);
            }
        });*/
        getTasks();

    }

    /*public void Menubtn() {
        PopupMenu p = new PopupMenu(MainActivity5.this, menubtn);
        p.getMenuInflater().inflate(R.menu.menu2, p.getMenu());
        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.update:
                        Intent intent1 = new Intent(MainActivity5.this, UpdateActivity.class);
                        startActivity(intent1);
                        return true;
                    case R.id.delete:
                        alert(client);
                        Toast.makeText(getApplicationContext(), "Testing", Toast.LENGTH_SHORT).show();
                       /* AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity5.this);
                        builder.setTitle("Are you sure you want to delete?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                               // deleteTask(client);
                                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                                startActivity(intent);
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });

                        AlertDialog ad = builder.create();
                        ad.show();*/
                      /*  return true;
                    default:
                        return true;
                }
            }
        });
        p.show();
    }*/


    private void getTasks() {
        class GetTasks extends AsyncTask<Void, Void, List<Client>> {
            @Override
            protected List<Client> doInBackground(Void... voids) {
                List<Client> clientList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDataBase()
                        .Dao()
                        .getAll();
                return clientList;
            }

            @Override
            protected void onPostExecute(List<Client> clients) {
                super.onPostExecute(clients);
                ClientAdapter adapter = new ClientAdapter(MainActivity5.this, clients);
                recyclerView.setAdapter(adapter);
            }

        }
        GetTasks gt = new GetTasks();
        gt.execute();

    }

  /*  private void alert(final Client client) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity5.this);
        builder.setTitle("Are you sure you want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteTask(client);
                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        AlertDialog ad = builder.create();
        ad.show();
    }


    public void deleteTask(final Client client) {
        class DeleteTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(getApplicationContext())
                        .getAppDataBase()
                        .Dao()
                        .delete(client);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                finish();
                // startActivity(new Intent(UpdateActivity.this, MainActivity5.class));
            }
        }

        DeleteTask dt = new DeleteTask();
        dt.execute();

    }*/

}


