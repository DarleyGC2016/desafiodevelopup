package br.com.stefanini.models;

/**
 * @author danilo
 * @version 0.1.0
 * @email maratona@stefanini.com
 * @created 23/09/2021 on 20:18
 */
public enum CargoEnum {
    JR(1,"Analista de Sistemas Jr."),
    PL(2,"Analista de Sistemas Pl."),
    SR(3,"Analista de Sistemas Sr.")
    ;
    private int codigo;
    private String descricao;

    CargoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CargoEnum findByCargo(String cargo) {
        CargoEnum cargoEnum = null;
        for (CargoEnum cargoEnum2 : CargoEnum.values()) {
            if(cargoEnum2.getDescricao().equals(cargo)){
                cargoEnum = cargoEnum2;
                return cargoEnum;
            }
        }
        return cargoEnum;

    }

    public static String findByCargoStr(CargoEnum cargoEnum) {
        for (CargoEnum cargoEnum2 : CargoEnum.values()) {
            if(cargoEnum2.equals(cargoEnum)){
                return cargoEnum2.getDescricao();
            }
        }
        return null;

    }
}
