package cits.application.vendor.sample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.recyclerholder> {

    Context ct;
    String str;
    public recyclerAdapter(Context context, String str){
        this.ct = context;
        this.str = str;
    }
    @NonNull
    @Override
    public recyclerholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new recyclerholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Integer.parseInt(str);
    }
    public class recyclerholder extends RecyclerView.ViewHolder{
        Button button;
        TextView editText;
        public recyclerholder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.btn1);
            editText= itemView.findViewById(R.id.text);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ct);
                    builder.setTitle("Give input");
                    builder.setCancelable(false);
                    final EditText edit = new EditText(ct);
                    builder.setView(edit);
                    builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editText.setText(edit.getText());
                             dialog.dismiss();
                        }
                    });
                     builder.show();
                }
            });
        }

    }
}
