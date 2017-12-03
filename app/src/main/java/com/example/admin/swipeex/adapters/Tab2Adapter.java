package com.example.admin.swipeex.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import com.example.admin.swipeex.R;
import com.example.admin.swipeex.models.Tab1Model;


import java.util.ArrayList;

/**
 * Created by Dell on 12/2/2017.
 */

public class Tab2Adapter extends RecyclerView.Adapter<Tab2Adapter.ViewHolder> {

    View view;
    ArrayList<Tab1Model> dataList = new ArrayList<>();
    ArrayList<Tab1Model> filterList = new ArrayList<>();

    public Tab2Adapter(ArrayList<Tab1Model> dataList) {
        this.dataList = dataList;
        this.filterList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab2_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tab1Model data = filterList.get(position);
        holder.tv_title.setText(data.getItems());
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }


    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    filterList = dataList;
                } else {

                    ArrayList<Tab1Model> filteredList1 = new ArrayList<>();

                    for (Tab1Model dataModel : dataList) {

                        if (dataModel.getItems().toLowerCase().contains(charString)) {

                            filteredList1.add(dataModel);
                        }
                    }

                    filterList = filteredList1;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList = (ArrayList<Tab1Model>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
