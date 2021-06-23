package com.simplest.uniapproomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class Delete extends AppCompatActivity {
    private RecyclerView recyclerView;
    ImageView menubtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        menubtn = findViewById(R.id.menubt);

        final Client client = (Client) getIntent().getSerializableExtra("client");

       menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Delete.this);
                builder.setTitle("Are you sure you want to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteTask(client);
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
        });
       // getTasks();
        //deleteTask();

    }
   /* private void getTasks() {
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
                ClientAdapter adapter = new ClientAdapter(Delete.this, clients);
                recyclerView.setAdapter(adapter);
            }

        }
        GetTasks gt = new GetTasks();
        gt.execute();

    }*/
    private void deleteTask(final Client client) {
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

    }

}


