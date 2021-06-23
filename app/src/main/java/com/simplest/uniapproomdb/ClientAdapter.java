package com.simplest.uniapproomdb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private static final Object MODE_PRIVATE = 1;
    private Context context;
    private List<Client> clientList;
   // SharedPreferences sp;
    //SharedPreferences.Editor editor;
    //String Num;
    //private Client client;


    public ClientAdapter(Context context, List<Client> clientList) {
        this.context = context;
        this.clientList = clientList;
    }

    @Override

    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_client, parent, false);
        return new ClientViewHolder(view);

        // SharedPreferences sp = getSharedPreferences("Key", MODE_PRIVATE);
        //Num = sp.getString("Num", " ");
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ClientViewHolder holder, int position) {
       // sp = getSharedPreferences("Key", MODE_PRIVATE);
       // Num = sp.getString("Num", " ");
        Client client = clientList.get(position);
        holder.textView.setText(client.getName() +
                "\n" + client.getAddress() + "\n" + client.getEmail() + "\n" +
                client.getPhone() + "\n" + client.getSex() + "\n" + "Policy Type:" + " " + client.getTravel() + "\n" + " From:" + client.getFrom() + " " + "To:" + client.getTo() + "\n" +
                client.getReg() +" "+ client.getColor() +" "+ client.getModel() + "\n" + client.getUploadpic() + "\n" + client.getNextName() + "\n" +
                client.getNextMail() + "\n" + client.getNextPhone()+ "\n" );
                //+ "Policy No: UIC/HRO/TRA/" + client.getNUMBER() + "/02/21");
       // + "\n" + client.getClaimEmail() + "\n" + client.getPolicyName() + client.getPicture() + client.getPolicyNo() + client.getDate() + client.getDeath() + client.getDetails());

    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    // class ClientViewHolder extends RecyclerView.ViewHolder{
    class ClientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewStatus, textView, textViewDesc, textViewFinishBy;
        ImageView menubtn;


        public ClientViewHolder(View itemView) {
            super(itemView);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
            textView = itemView.findViewById(R.id.textView);
            menubtn = (ImageView) itemView.findViewById(R.id.menubt);
            // itemView.setOnClickListener(new View.OnClickListener() {

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            PopupMenu p = new PopupMenu(context, menubtn);
            p.getMenuInflater().inflate(R.menu.menu2, p.getMenu());
            p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.update:
                            Client client = clientList.get(getAdapterPosition());
                            Intent intent1 = new Intent(context, UpdateActivity.class);
                            intent1.putExtra("client", client);
                            context.startActivity(intent1);
                            return true;
                        case R.id.delete:
                            client = clientList.get(getAdapterPosition());
                            alert(client);
                            Toast.makeText(context.getApplicationContext(), "Testing", Toast.LENGTH_SHORT).show();
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
                            return true;
                        case R.id.claim:
                            Intent intent3 = new Intent(context, ClaimActivity.class);
                            context.startActivity(intent3);
                            return true;
                            default:
                            return true;
                    }
                }
            });
            p.show();
        }
            // Client client = clientList.get(getAdapterPosition());
            // Intent intent = new Intent(context, UpdateActivity.class);
            // intent.putExtra("client", client);
            // context.startActivity(intent);
            //Toast.makeText(context, clientList.get(position), Toast.LENGTH_SHORT).show();
        }
    private void alert(final Client client) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteTask(client);
                Intent intent = new Intent(context, MainActivity4.class);
               context.startActivity(intent);
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
                DatabaseClient.getInstance(context.getApplicationContext())
                        .getAppDataBase()
                        .Dao()
                        .delete(client);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(context.getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
                finish();
                Intent intent2 = new Intent(context, UpdateActivity.class);
                context.startActivity(intent2);
            }

            private void finish() {
            }


        }

        DeleteTask dt = new DeleteTask();
        dt.execute();

    }



}



