/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaprogressivo;

/**
 *
 * @author everton.rodrigues
 */
import java.util.Scanner;
import java.util.Calendar;


public class ScanCalendario {
    
    public static void main(String[] args) {
       
        int idade;
        int ano_atual;
        int ano_nascimento;
        
        Scanner entrada = new Scanner(System.in);
      
        // pergunta a idade e armazena
        System.out.println("Digite sua idade: ");
        idade = entrada.nextInt();
       
        //Criando um objeto do tipo Calendar, o 'calendario' e armazenando o ano atual
        Calendar calendario = Calendar.getInstance();
        ano_atual=calendario.get(Calendar.YEAR);
        ano_nascimento= ano_atual - idade;
        
        System.out.printf("Ano_atual:"+ano_atual+"-"+ idade+"\n");
        System.out.printf("Você nasceu em " + ano_nascimento + "\n");
        
        System.out.println("--------------------------------36: ");
        
        //Sem variavel idade
        Scanner entrada1 = new Scanner(System.in);
        
        System.out.println("Digite sua idade: ");
        Calendar calendario1 = Calendar.getInstance();
        
        System.out.printf("Você nasceu em " + (calendario.get(Calendar.YEAR) - entrada.nextInt()) + "\n");
        
        
        
        
        
        
       
    }
}

