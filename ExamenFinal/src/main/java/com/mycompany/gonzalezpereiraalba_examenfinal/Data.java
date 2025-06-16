
package com.mycompany.gonzalezpereiraalba_examenfinal;

import java.io.Serializable;

/**
 *
 * @author a24exame-dam-f
 */
public class Data implements Serializable {
    private String medicamento;
    private String proveedor;
    private String stock;

    public Data() {
    }

    public Data(String nombre, String medicamento, String stock) {
        this.medicamento = nombre;
        this.proveedor = medicamento;
        this.stock = stock;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "medicamento=" + medicamento + ", proveedor=" + proveedor + ", stock=" + stock;
    }
    
    
}
