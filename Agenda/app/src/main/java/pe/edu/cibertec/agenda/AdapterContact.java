package pe.edu.cibertec.agenda;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContact  extends RecyclerView.Adapter<AdapterContact.ContactPrototype> {


    ArrayList<Contacto> items;

    public AdapterContact(ArrayList<Contacto> items) {
        this.items = items;
    }

    // Crea la vista en base el prototipo por cada celda

    @NonNull
    @Override
    public ContactPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View view;

        // esto sirve para jalar el diseño para la vista

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_contact,viewGroup,false);

        ContactPrototype contactPrototype = new ContactPrototype(view);


        return contactPrototype;


    }

    // carga la informacion por cada celda de acuerdo a la posicion

    @Override
    public void onBindViewHolder(@NonNull ContactPrototype contactPrototype, int position) {
        Contacto contacto = items.get(position);

        // si se cre la variable de arriba se modifica :
        contactPrototype.tvName.setText(contacto.getName());
        contactPrototype.tvCompany.setText(contacto.getCompany());
        contactPrototype.tvNumber.setText(String.valueOf(contacto.getNumber()));

    }

    //Indica la cantidad de registros en el Recycler View
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ContactPrototype extends RecyclerView.ViewHolder {

        TextView tvName, tvCompany, tvNumber;

        public ContactPrototype(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvNumber = itemView.findViewById(R.id.tvNumber);
        }
    }
}