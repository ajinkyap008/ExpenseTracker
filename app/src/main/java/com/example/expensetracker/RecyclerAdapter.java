package com.example.expensetracker;

import android.content.Context;
import android.database.Cursor;
import android.media.session.PlaybackState;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.Map;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContext;
    private Cursor cursor_head , cursor_info , cursor_category , cursor_details;

    public RecyclerAdapter(Context context , Cursor head_cursor , Cursor category_cursor , Cursor info_cursor , Cursor details_cursor){
        mContext = context ;
        cursor_category = category_cursor;
        cursor_details = details_cursor ;
        cursor_head = head_cursor ;
        cursor_info = info_cursor ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item , parent , false);
        ViewHolder  viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       if(!cursor_info.move(position) || !cursor_head.move(position) || !cursor_details.move(position) || !cursor_category.move(position)){
           return;
       }


        String head = cursor_head.getString(cursor_head.getColumnIndex("head_name"));
        String category = cursor_category.getString(cursor_category.getColumnIndex("category_name"));
        String bill_no = cursor_info.getString(cursor_info.getColumnIndex("bill_no"));
        String biller_name = cursor_info.getString(cursor_info.getColumnIndex("biler_name"));
        String address = cursor_info.getString(cursor_info.getColumnIndex("address"));
        String city = cursor_info.getString(cursor_info.getColumnIndex("city"));
        String amount = cursor_info.getString(cursor_info.getColumnIndex("amount"));
        String date = cursor_details.getString(cursor_details.getColumnIndex("date"));
        String time = cursor_details.getString(cursor_details.getColumnIndex("time"));
        String particular = cursor_details.getString(cursor_details.getColumnIndex("particular"));
        String remark = cursor_details.getString(cursor_details.getColumnIndex("remarks"));

        System.out.println("head :- " + head);
        System.out.println("category :- " + category);
        System.out.println("billno :- " + bill_no);
        System.out.println("bilername :- " + biller_name);
        System.out.println("address :- " + address);
        System.out.println("city :- " + city);
        System.out.println("amount :- " + amount);
        System.out.println("date :- " + date);
        System.out.println("time :- " + time);
        System.out.println("particular:- " + particular);
        System.out.println("remark :- " + remark);


        Log.d("check1", "onBindViewHolder: ");
        holder.tv_head.setText(head);
        Log.d("check2", "onBindViewHolder: ");
        holder.tv_category.setText(category);
        Log.d("check3", "onBindViewHolder: ");
        holder.tv_billno.setText(bill_no);
        Log.d("check4", "onBindViewHolder: ");
        holder.tv_biller_name.setText(biller_name);
        Log.d("check5", "onBindViewHolder: ");
        holder.tv_address.setText(address);
        Log.d("check6", "onBindViewHolder: ");
        holder.tv_city.setText(city);
        Log.d("check7", "onBindViewHolder: ");
        holder.tv_amount.setText(amount);
        Log.d("check8", "onBindViewHolder: ");
        holder.tv_date.setText(date);
        Log.d("check9", "onBindViewHolder: ");
        holder.tv_time.setText(time);
        Log.d("check10", "onBindViewHolder: ");
        holder.tv_partiular.setText(particular);
        Log.d("check11", "onBindViewHolder: ");
        holder.tv_remark.setText(remark);
        Log.d("check12", "onBindViewHolder: ");



    }

    @Override
    // Returns number of rows in recycler view.
    public int getItemCount() {
        return cursor_head.getCount();
    }


    // Managing the rows of Recycler View.
    // Keep track of view in rows.
    // All text view in individual rows.
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_billno , tv_amount , tv_date , tv_head , tv_category , tv_biller_name , tv_address , tv_city  , tv_time , tv_partiular , tv_remark ;
        ImageView img_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_billno = itemView.findViewById(R.id.bill_no) ;
            tv_date = itemView.findViewById(R.id.txt_date);
            tv_amount = itemView.findViewById(R.id.bill_amt);
            tv_head = itemView.findViewById(R.id.tv_head);
            tv_category = itemView.findViewById(R.id.tv_category);
            tv_biller_name = itemView.findViewById(R.id.biller_name);
            tv_address = itemView.findViewById(R.id.bill_add);
            tv_city = itemView.findViewById(R.id.bill_city);
            tv_time = itemView.findViewById(R.id.txt_time);
            tv_partiular = itemView.findViewById(R.id.bill_parti);
            tv_remark = itemView.findViewById(R.id.bill_remark);

        }
    }


}
