package com.jave_sistemas.produtos.controller;


import com.jave_sistemas.produtos.model.ProdutoModelo;
import com.jave_sistemas.produtos.model.RespostaModelo;
import com.jave_sistemas.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class Produtocontroller {

    @Autowired
    private ProdutoService produtoService;




    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo produtoModelo){
        return  produtoService.cadastrarAlterar(produtoModelo, "alterar");
    }


    // METODO PARA LISTAR PRODUTOS
    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return produtoService.listar();

    }


    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo produtoModelo){

        return produtoService.cadastrarAlterar(produtoModelo, "cadastrar");

    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable Long codigo){
        return produtoService.remover(codigo);

    }







}
