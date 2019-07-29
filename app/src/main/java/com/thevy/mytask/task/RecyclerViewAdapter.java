package com.thevy.mytask.task;

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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private List<Task> data = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, List<Task> data) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.task.setText(data.get(position).taskContent);
        holder.countCont.setText(String.valueOf(data.get(position).countCont));
        holder.countInMonth.setText(String.valueOf(data.get(position).countInMonth));
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
        TextView task;
        TextView countCont;
        TextView countInMonth;
        RelativeLayout line;
        CheckBox checkBox;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            task = (TextView) itemView.findViewById(R.id.task_content);
            countCont = (TextView) itemView.findViewById(R.id.task_countCont);
            countInMonth = (TextView) itemView.findViewById(R.id.task_countInMonth);
            line = (RelativeLayout) itemView.findViewById(R.id.line);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
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
