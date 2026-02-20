package com.ejemplo.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Hamburguesa {

    private final String tipoPan;
    private final String tipoCarne;

    private final String queso;
    private final List<String> ingredientesAdicionales;

    private Hamburguesa(Builder builder) {
        this.tipoPan = builder.tipoPan;
        this.tipoCarne = builder.tipoCarne;
        this.queso = builder.queso;
        this.ingredientesAdicionales = Collections.unmodifiableList(new ArrayList<>(builder.ingredientesAdicionales));
    }

    public String getTipoPan() {
        return tipoPan;
    }

    public String getTipoCarne() {
        return tipoCarne;
    }

    public String getQueso() {
        return queso;
    }

    public List<String> getIngredientesAdicionales() {
        return ingredientesAdicionales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hamburguesa {\n");
        sb.append("  Pan: ").append(tipoPan).append("\n");
        sb.append("  Carne: ").append(tipoCarne).append("\n");

        if (queso != null) {
            sb.append("  Queso: ").append(queso).append("\n");
        } else {
            sb.append("  Queso: (sin queso)\n");
        }

        if (ingredientesAdicionales.isEmpty()) {
            sb.append("  Ingredientes adicionales: (ninguno)\n");
        } else {
            sb.append("  Ingredientes adicionales: ").append(ingredientesAdicionales).append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

    public static final class Builder {

        private final String tipoPan;
        private final String tipoCarne;

        private String queso = null;
        private final List<String> ingredientesAdicionales = new ArrayList<>();

        public Builder(String tipoPan, String tipoCarne) {
            this.tipoPan = validarNoVacio(tipoPan, "tipoPan");
            this.tipoCarne = validarNoVacio(tipoCarne, "tipoCarne");
        }

        public Builder conQueso(String queso) {
            this.queso = validarNoVacio(queso, "queso");
            return this;
        }

        public Builder agregarIngrediente(String ingrediente) {
            this.ingredientesAdicionales.add(validarNoVacio(ingrediente, "ingrediente"));
            return this;
        }

        public Hamburguesa build() {
            return new Hamburguesa(this);
        }

        private static String validarNoVacio(String value, String fieldName) {
            Objects.requireNonNull(value, fieldName + " no puede ser null");
            String trimmed = value.trim();
            if (trimmed.isEmpty()) {
                throw new IllegalArgumentException(fieldName + " no puede estar vacío");
            }
            return trimmed;
        }
    }
}
