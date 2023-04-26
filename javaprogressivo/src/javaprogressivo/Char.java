/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaprogressivo;

import java.util.Scanner;

/**
 *
 * @author teste
 */
public class Char {
    
    
  
    public static void main(String[] args){
        /*char letra_J = 74;
        char letra_P = 6;
        char letra_Q = 81;
        char letra_R = 82;
        char letra_S = 83;
        System.out.printf("%c %c %c %c %c\n",letra_J, letra_P,letra_Q,letra_R,letra_S);
   */
        int numero_J = 74;
        char letra_J = (char) numero_J;
        char letra_P = 80;
        char letra_i = 'i';
        System.out.printf("%c%c%c%c %c%c%c%c%c%c%c%c%c%c%c\n",
                                    letra_J,97,118,97, letra_P, 'r',
                                    111,103,114,101,'s','s',letra_i,
                                    118, 111);
        
        //Como armazenar um caractere (char) que o usuário digitou
        System.out.println("Digite aqui -> ");
        Scanner entrada = new Scanner(System.in);
        char caractere;

        caractere = entrada.nextLine().charAt(0);
        System.out.println("motra caractere digitado:"+caractere);
    }
}
    
    
    


