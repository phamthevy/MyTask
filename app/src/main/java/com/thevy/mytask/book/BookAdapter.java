package com.thevy.mytask.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.thevy.mytask.R;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.RecyclerViewHolder>{

    private List<Book> data = new ArrayList<>();
    private Context mContext;

    public BookAdapter(Context mContext, List<Book> data) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_book, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.title.setText(data.get(position).title);
        holder.author.setText(String.valueOf(data.get(position).author));
        holder.dayRead.setText(String.valueOf(data.get(position).dayRead));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickedListener != null){
                    onItemClickedListener.onItemClick(position, holder.checkBox.isChecked());
                }
            }
        });
//        holder.line.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.line.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorAccent));
//                if (onItemClickedListener != null) {
//                    onItemClickedListener.onItemClick(holder.task.getText().toString());
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        TextView dayRead;
        TextView dayStart;
        RelativeLayout line;
        CheckBox checkBox;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
//            task = (TextView) itemView.findViewById(R.id.task_content);
//            countCont = (TextView) itemView.findViewById(R.id.task_countCont);
//            countInMonth = (TextView) itemView.findViewById(R.id.task_countInMonth);
//            line = (RelativeLayout) itemView.findViewById(R.id.line);
//            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }

    public interface OnItemClickedListener {
        void onItemClick(int position, boolean isChecked);
    }

    private OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }
}
