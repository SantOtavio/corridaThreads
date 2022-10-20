//package br.sc.senai.sidtickets.factory;
//
//
//import br.sc.senai.sidtickets.model.entities.VeiculosPassagem;
//
//public class VeiculosPassagemFactory {
//    public static VeiculosPassagem getTipoVeiculo(String tipoVeiculo) {
//        if (tipoVeiculo == null) {
//            return null;
//        }
//        return switch (tipoVeiculo) {
//            case "Ônibus" -> new Onibus();
//            case "Trem" -> new Trem();
//            case "Avião" -> new Aviao();
//            default -> null;
//        };
//    }
//}
