package org.mdiaz.appfacturas.modelo;

import javax.print.DocFlavor;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoId;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.id = ++ultimoId;
        this.fecha = new Date();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItem(ItemFactura item){
        if (indiceItems < MAX_ITEMS){
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal(){
        float total = 0.0f;
        for (ItemFactura item : this.items){
            if (item == null){
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder sb = new StringBuilder("Factura N: ");
        sb.append(id)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t CUIL: ")
                .append(cliente.getCuil())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n");


        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha de emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");;

        for (ItemFactura item : this.getItems()){
            if (item == null){
                continue;
            }
            sb.append(item).append("\n");

        }
        sb.append("\n Gran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
