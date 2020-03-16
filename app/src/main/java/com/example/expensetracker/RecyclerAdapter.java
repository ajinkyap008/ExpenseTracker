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

import java.util.ArrayList;
import java.util.Map;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContext;
    private Cursor cursor_head , cursor_info , cursor_category , cursor_details;
    ArrayList<String> list = new ArrayList<String>();

    int k = 0;

    public RecyclerAdapter(Context context , ArrayList<String>arrayList , Cursor head_cursor){
        mContext = context ;
        list = arrayList;
        cursor_head = head_cursor;
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


       String head = "", category = "" , bill_no = "", biller_name = "", address = "", city ="" , amount = "", date = "", time ="", particular  ="", remark ="";

        int i = 0;
       //int k = 0;

       // list.size()/11 as there are 11 items in view..eg.head , category , bill_no etc.
       // if not done so..recycler view gets filled with last entry in database.
       //Not correct entirely though..gives wrong o/p for large enteries.


        //int i=0;
       while(i <list.size()/11) {

           //i = 0;

           Log.d("infor1", "onBindViewHolder: " + i + " " + k + " " + list.size());

           i+=k;

           Log.d("infor2", "onBindViewHolder: " + i + " " + k);

           if(i>=list.size())
               break;

           head = list.get(i++);
           Log.d("list1", "onBindViewHolder: " + i);
           category = list.get(i++);
           Log.d("list2", "onBindViewHolder: " + i);
           bill_no = list.get(i++);
           Log.d("lis3t", "onBindViewHolder: " + i);
           biller_name = list.get(i++);
           Log.d("list4", "onBindViewHolder: " + i);
           address = list.get(i++);
           Log.d("list5", "onBindViewHolder: " + i);
           city = list.get(i++);
           Log.d("list6", "onBindViewHolder: " + i);
           amount = list.get(i++);
           Log.d("list7", "onBindViewHolder: " + i);
           date = list.get(i++);
           Log.d("list8", "onBindViewHolder: " + i);
           time = list.get(i++);
           Log.d("list9", "onBindViewHolder: " + i);
           particular = list.get(i++);
           Log.d("list10", "onBindViewHolder: " + i);
           remark = list.get(i++);
           Log.d("list11", "onBindViewHolder: " + i);

        /*
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
        String remark = cursor_details.getString(cursor_details.getColumnIndex("remarks"));*/

           /*System.out.println("head :- " + head);
           System.out.println("category :- " + category);
           System.out.println("billno :- " + bill_no);
           System.out.println("bilername :- " + biller_name);
           System.out.println("address :- " + address);
           System.out.println("city :- " + city);
           System.out.println("amount :- " + amount);
           System.out.println("date :- " + date);
           System.out.println("time :- " + time);
           System.out.println("particular:- " + particular);
           System.out.println("remark :- " + remark);*/

           Log.d("Recycler_head", "onBindViewHolder: "  + head + " " + i + " " + list.size());
           Log.d("Recycler_category", "onBindViewHolder: "  + category + " " + i);
           Log.d("Recycler_billno", "onBindViewHolder: "  + bill_no + " " + i);
           Log.d("Recycler_billname", "onBindViewHolder: "  + biller_name + " " + i);
           Log.d("Recycler_address", "onBindViewHolder: "  + address + " " + i);
           Log.d("Recycler_city", "onBindViewHolder: "  + city + " " + i);
           Log.d("Recycler_amount", "onBindViewHolder: "  + amount + " " + i);
           Log.d("Recycler_time", "onBindViewHolder: "  + time + " " + i);
           Log.d("Recycler_date", "onBindViewHolder: "  + date + " " + i);
           Log.d("Recycler_particular", "onBindViewHolder: "  + particular + " " + i);
           Log.d("Recycler_remark", "onBindViewHolder: "  + remark + " " + i);


           Log.d("check1", "onBindViewHolder: " + head);
           holder.tv_head.setText(head);
           Log.d("check2", "onBindViewHolder: " + category);
           holder.tv_category.setText(category);
           Log.d("check3", "onBindViewHolder: " + bill_no);
           holder.tv_billno.setText(bill_no);
           Log.d("check4", "onBindViewHolder: " + biller_name);
           holder.tv_biller_name.setText(biller_name);
           Log.d("check5", "onBindViewHolder: " + address);
           holder.tv_address.setText(address);
           Log.d("check6", "onBindViewHolder: " + city);
           holder.tv_city.setText(city);
           Log.d("check7", "onBindViewHolder: " + amount);
           holder.tv_amount.setText(amount);
           Log.d("check8", "onBindViewHolder: " + date);
           holder.tv_date.setText(date);
           Log.d("check9", "onBindViewHolder: " + time);
           holder.tv_time.setText(time);
           Log.d("check10", "onBindViewHolder: " + particular);
           holder.tv_partiular.setText(particular);
           Log.d("check11", "onBindViewHolder: " + remark);
           holder.tv_remark.setText(remark);
           Log.d("check12", "onBindViewHolder: ");

           k+=11;

       }

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

            Log.d("viewholder", "ViewHolder: ");

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
