package com.sibentek.comercial.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sibentek.comercial.model.Orcamento;
import com.sibentek.comercial.model.OrcamentoItem;
import com.sibentek.comercial.service.GestaoOrcamentosService;
import com.sibentek.comercial.util.jsf.FacesUtil;
import java.util.List;
import javax.annotation.PostConstruct;

@Named
@ViewScoped
public class CadastroOrcamentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private GestaoOrcamentosService gestaoOrcamentos;
    private Orcamento orcamento = new Orcamento();
    private OrcamentoItem item;
    private List<Orcamento> orcamentos;

    @PostConstruct
    public void init() {
        orcamentos = gestaoOrcamentos.listar();
    }

    public void novoItem() {
        item = new OrcamentoItem();
    }

    public void adicionarItem() {
        orcamento.getItens().add(item);
        item.setOrcamento(orcamento);
    }

    public void salvar() {
        gestaoOrcamentos.salvar(orcamento);
        orcamento = new Orcamento();

        FacesUtil.addInfoMessage("Orçamento salvo com sucesso!");
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public OrcamentoItem getItem() {
        return item;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

}
