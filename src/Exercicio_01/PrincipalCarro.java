package Exercicio_01;

import javax.swing.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {


        ArrayList<Carro> carros = new ArrayList<>();

        String menuPrincipal =
                "1- Cadastrar carros.\n" +
                "2- Listar carros.\n" +
                "3- Sair.";
        String menuListas =
                "1- Listar por período de fabricação.\n" +
                "2- Listar por marca.\n" +
                "3- Listar por cor.\n" +
                "4- Voltar.";
        int opMenuPrincipal = 0;
        do {
            int opMenuListas = 0;
            opMenuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            if (opMenuPrincipal == 1){
                Carro c = new Carro();
                if (c.cadastrarCarro()){
                    carros.add(c);
                }
            }
            if (opMenuPrincipal == 2 ){
                do {
                    opMenuListas = Integer.parseInt(JOptionPane.showInputDialog(menuListas));
                    if (opMenuListas == 1){
                        listarPorPeriodo(carros);
                    }
                    if (opMenuListas == 2){
                        listarPorMarca(carros);
                    }
                    if (opMenuListas == 3){
                        listarPorCor(carros);
                    }
                }while (opMenuListas != 4);
            }
        } while (opMenuPrincipal != 3);
    }
    static void listarPorPeriodo(ArrayList<Carro>carros){
        int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano inicial?"));
        int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano final?"));
        String dados = "";
        int total = 0;
            for (Carro c : carros){
                if (c.getAnoFabricacao() >= anoInicial && c.getAnoFabricacao() <= anoFinal){
                dados += c.exibirDados();
                total ++;
            }
        }
        dados += calcPercentual(carros.size(), total);
        JOptionPane.showMessageDialog(null, dados);
    }
    static void listarPorMarca(ArrayList<Carro>carros){
        String marca = JOptionPane.showInputDialog("Qual a marca que deseja listar?");
        String dados = "";
        int total = 0;
        for (Carro c : carros){
            if (c.getMarca().equalsIgnoreCase(marca)){
                dados += c.exibirDados();
                total++;
            }
        }
        dados += calcPercentual(carros.size(), total);
        JOptionPane.showMessageDialog(null, dados);
    }
    static void listarPorCor(ArrayList<Carro>carros){
        String cor = JOptionPane.showInputDialog("Qual a cor deseja listar");
        String dados = "";
        int total = 0;
        for (Carro c : carros){
            if (c.getCor().equalsIgnoreCase(cor)){
                dados += c.exibirDados();
                total++;
            }
        }
        dados += calcPercentual(carros.size(), total);
        JOptionPane.showMessageDialog(null, dados);
    }
    static String calcPercentual(int total, int encontrados) {
        double percentual = (double)encontrados / (double)total * 100;
        return "Percentual em relação ao total: "+percentual+"%";
    }
}