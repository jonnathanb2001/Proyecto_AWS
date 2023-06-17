/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tendencias.proyectousuario.model.vm;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jonny
 */
@Data
@AllArgsConstructor
public class Asset {
    private byte[] content;
    private String contentType;
    
}
