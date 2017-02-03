/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sibentek.comercial.binder;

import com.sibentek.comercial.model.Cliente;
import com.sibentek.comercial.model.vo.ClienteVO;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * @author william
 */
public class ClienteBinder {
    public static Collection<ClienteVO> bindFromModel(Collection<Cliente> clientes){
        if(clientes == null)return null;
        return clientes.stream().map(ClienteBinder::bindToView)
                .collect(Collectors.toList());
    }
    
    public static ClienteVO bindToView(Cliente cliente){
        return ClienteVO.builder()
                .id(cliente.getId())
                .cpf(cliente.getCpf())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .dataNasc(cliente.getDataNasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .build();
    }
}
