package pe.edu.cibertec.proyectotarea;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaPrototype> {

    private List<Tarea> items;

    public TareaAdapter(List<Tarea> items) {
        this.items = items;
    }

    // Crea la vista en base el prototipo por cada celda

    @NonNull
    @Override
    public TareaPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view;

        // esto sirve para jalar el diseño para la vista

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_tarea, viewGroup, false);

        TareaPrototype tareaPrototype = new TareaPrototype(view);


        return tareaPrototype;

    }

    // carga la informacion por cada celda de acuerdo a la posicion
    @Override
    public void onBindViewHolder(@NonNull TareaPrototype tareaPrototype, int position) {
        Tarea tarea = items.get(position);

        // si se cre la variable de arriba se modifica :
        tareaPrototype.tvName.setText(tarea.getName());

    }

    //Indica la cantidad de registros en el Recycler View
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class TareaPrototype extends RecyclerView.ViewHolder {

        TextView tvName;
        CardView cvTarea;

        public TareaPrototype(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            cvTarea = itemView.findViewById(R.id.cvTarea);

            cvTarea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Gson gson = new Gson();
                    Intent intent = new Intent(v.getContext(), TareaActivity.class);
                    intent.putExtra("tarea", gson.toJson(items.get(getAdapterPosition())));
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}
