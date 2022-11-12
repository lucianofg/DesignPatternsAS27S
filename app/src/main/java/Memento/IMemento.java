/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

import java.time.LocalDateTime;

/**
 *
 * @author luciano
 */
public interface IMemento {
    public void restore();
    
    public LocalDateTime getCreationDate();
}
