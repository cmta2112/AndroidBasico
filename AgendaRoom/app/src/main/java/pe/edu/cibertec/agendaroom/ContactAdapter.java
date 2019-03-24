package pe.edu.cibertec.agendaroom;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactPrototype> {

    private List<Contact> items;

    public ContactAdapter(List<Contact> items) {
        this.items = items;

    }

    @NonNull
    @Override
    public ContactPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;

        // inflate para q se muestre o cobre vida
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_contact, viewGroup, false);

        ContactPrototype contactPrototype = new ContactPrototype(view);
        return contactPrototype;
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactPrototype contactPrototype, final int position) {
        contactPrototype.tvName.setText(items.get(position).getName());

        contactPrototype.cvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obteniendo el contacto seleccionado
                Contact contact = items.get(position);

                //Oteniendo el id del contacto
                int id = contact.getId();
                String name = contact.getName();
                String telephone = contact.getTelephone();


                Intent intent = new Intent(v.getContext(), ContactActivity.class);

                //Enviando el id del contacto
                intent.putExtra("id", id);
                intent.putExtra("name",name);
                intent.putExtra("telephone",telephone);

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ContactPrototype extends RecyclerView.ViewHolder {
        TextView tvName;
        CardView cvContact;

        public ContactPrototype(@NonNull final View itemView) {
            super(itemView);

            cvContact = itemView.findViewById(R.id.cvContact);
            tvName = itemView.findViewById(R.id.tvName);


        }
    }
}
