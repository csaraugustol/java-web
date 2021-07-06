/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.atividade.appcarro.Carro;

/**
 *
 * @author cesar
 */
public class Carro {
    String nome ,ar ,cambio ,vidro ,alarme ,pintura ,tetoSolar ,cetralMult, motor; 
    
    public Carro() {
    }

    public Carro(String nome, String ar, String cambio, String vidro, String alarme, String pintura, String tetoSolar, String cetralMult, String motor) {
        this.nome = nome;
        this.ar = ar;
        this.cambio = cambio;
        this.vidro = vidro;
        this.alarme = alarme;
        this.pintura = pintura;
        this.tetoSolar = tetoSolar;
        this.cetralMult = cetralMult;
        this.motor = motor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getVidro() {
        return vidro;
    }

    public void setVidro(String vidro) {
        this.vidro = vidro;
    }

    public String getAlarme() {
        return alarme;
    }

    public void setAlarme(String alarme) {
        this.alarme = alarme;
    }

    public String getPintura() {
        return pintura;
    }

    public void setPintura(String pintura) {
        this.pintura = pintura;
    }

    public String getTetoSolar() {
        return tetoSolar;
    }

    public void setTetoSolar(String tetoSolar) {
        this.tetoSolar = tetoSolar;
    }

    public String getCetralMult() {
        return cetralMult;
    }

    public void setCetralMult(String cetralMult) {
        this.cetralMult = cetralMult;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
    
    
    
        public double precoCarro(){
            if(nome.equalsIgnoreCase("Argo")){
                return 30000;
            }else if(nome.equalsIgnoreCase("Kicks")){
                return 50000;
            }else if(nome.equalsIgnoreCase("Toro")){
                return 80000;
            }else{
                return 0;
            }
        }
        
        public double valorAr(){
        if(ar.equalsIgnoreCase("sim")){
                return 3000;
            }else {
                return 0;
            }
        }
        
        public double valorCambio(){
        if(cambio.equalsIgnoreCase("sim")){
                return 5000;
            }else {
                return 0;
            }
        }
        
        public double valorAlarme(){
        if(alarme.equalsIgnoreCase("sim")){
                return 800;
            }else {
                return 0;
            }
        }
        
        public double valorPintura(){
        if(pintura.equalsIgnoreCase("Comemorativa") || pintura.equalsIgnoreCase("Especial") || pintura.equalsIgnoreCase("Metalica")){
                return 2500;
            }else {
                return 0;
            }
        }
        
        public double valorTetoSolar(){
        if(tetoSolar.equalsIgnoreCase("sim")){
                return 4000;
            }else {
                return 0;
            }
        }
        
        public double valorCentralMult(){
        if(tetoSolar.equalsIgnoreCase("sim")){
                return 1800;
            }else {
                return 0;
            }
        }
        
        
       public double somaPrecoCarroComAcessorios(){
           return precoCarro() + valorAr() + valorCambio() + valorAlarme() + valorPintura() + valorTetoSolar() + valorCentralMult();
        }
       
       public double calculaIpi(){
       if(nome.equalsIgnoreCase("Argo") || nome.equalsIgnoreCase("Toro") && motor.equalsIgnoreCase("1.0")){
                return somaPrecoCarroComAcessorios() * 1.10;
            }else if(nome.equalsIgnoreCase("Argo") || nome.equalsIgnoreCase("Toro") && motor.equalsIgnoreCase("1.5")){
                return somaPrecoCarroComAcessorios() * 1.20;
            }else  if(nome.equalsIgnoreCase("Kicks") && motor.equalsIgnoreCase("1.0")){
                return somaPrecoCarroComAcessorios() * 1.20;
            }else{
                return somaPrecoCarroComAcessorios() * 1.30;
            }
       }
}
