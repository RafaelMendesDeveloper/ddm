//package com.example.contador.taco;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//import android.database.Cursor;
//
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.contador.R;
//
//public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
//    private final Cursor cursor;
//
//    public FoodAdapter(Cursor cursor){
//        this.cursor = cursor;
//    }
//
//    @NonNull
//    @Override
//    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTipe){
//      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
//      return new FoodViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position){
//        if(cursor.moveToPosition(position)){
//            String foodName = cursor.getString(cursor.getColumnIndex("nome_alimento"));
//            holder.nameTextView.setText(foodName);
//        }
//    }
//
//    @Override
//    public int getItemCount(){
//        return cursor.getCount();
//    }
//
//    static class FoodViewHolder extends RecyclerView.ViewHolder {
//        TextView nameTextView;
//
//        FoodViewHolder(View itemView){
//            super(itemView);
//            nameTextView = itemView.findViewById(R.id.text_food_name);
//        }
//    }
//}
