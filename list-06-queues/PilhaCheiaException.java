/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Questao01;

/**
 *
 * @author larim
 */
public class PilhaCheiaException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public PilhaCheiaException() {
        super("Pilha cheia");
    }
    
}
