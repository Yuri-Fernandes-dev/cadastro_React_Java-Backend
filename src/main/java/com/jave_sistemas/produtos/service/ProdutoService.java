package com.jave_sistemas.produtos.service;


import com.jave_sistemas.produtos.model.ProdutoModelo;
import com.jave_sistemas.produtos.model.RespostaModelo;
import com.jave_sistemas.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RespostaModelo respostaModelo;




    //listar produtos
    public Iterable<ProdutoModelo> listar(){
        return  produtoRepository.findAll();

    }


    // METODO PARA CADASTRAR PRODUTOS
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo produtoModelo, String acao){ // esse responseEntity te da o direito de enviar msg para o front


        if(produtoModelo.getNome().equals("")){ // == igual
            respostaModelo.setMensagem("O nome do produto é Obrigatório");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);

        } else if (produtoModelo.getMarca().equals("")) {
            respostaModelo.setMensagem( "o nome da marca é obrigatório");
            return  new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);

        }else {
            if( acao.equals(("cadastrar"))){
                return  new ResponseEntity<ProdutoModelo>(produtoRepository.save(produtoModelo), HttpStatus.CREATED);
            }else{
                return  new ResponseEntity<ProdutoModelo>(produtoRepository.save(produtoModelo), HttpStatus.OK);

            }
        }


    }

    public ResponseEntity<RespostaModelo> remover(Long codigo){
        produtoRepository.deleteById(codigo);

        respostaModelo.setMensagem("O produto foi removido");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }





}
