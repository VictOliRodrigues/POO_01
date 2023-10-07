package Exercicio_01;

import javax.swing.*;

public class Carro {

    //Variáveis
    private String marca;
    private int anoFabricacao;
    private String cor;


    //Cadastro
    boolean cadastrarCarro() {
        setMarca(JOptionPane.showInputDialog("Qual a marca do veículo?"));
        setAnoFabricacao(Integer.parseInt(JOptionPane.showInputDialog("Qual o ano de fablicação do veículo?")));
        setCor(JOptionPane.showInputDialog("Qual a cor do veículo?"));
        return validaCadastro();
    }


    //Validação de cadastro
    boolean validaCadastro() {
        if (marca.equals("")) {
            JOptionPane.showMessageDialog(null, "O nome não pode ser em branco!");
            return false;
        }
        if (anoFabricacao <= 1950 || anoFabricacao >= 2023) {
            JOptionPane.showMessageDialog(null, "Ano inválido!");
            return false;
        }
        if (cor.equals("")) {
            JOptionPane.showMessageDialog(null, "Cor não pode ficar em branco!");
            return false;
        }
        return true;
    }


    //Exibir dados
    public String exibirDados(){
        return "Marca: " + marca + "\nCor: " + cor + "\nAno de fab: " + anoFabricacao + ".\n\n";
    }


    //Gets e Sets
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}