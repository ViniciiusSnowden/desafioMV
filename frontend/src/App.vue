<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper  cyan darken-3" >
        <a href="#" class="brand-logo center">Café da Manha</a>
      </div>
    </nav>

    <div class="container">
     
        <ul>
          <li v-for="(erro, index) of  errors" :key="index">
            campo <b>{{erro.field }}</b> - {{erro.defaultMessege}}
          </li>

        </ul>
      <div style="margin: 50px 0px 50px 0px">
      <form @submit.prevent="salvar">
          <label>Nome *</label>
          <input type="text" placeholder="Digite seu nome e sobrenome" v-model="produto.name">
          <label>CPF *</label>
          <input type="text" placeholder="Digite seu CPF" v-model="produto.cpf">
          <label>Opção 1 *</label>
          <input type="text" placeholder="Digite a um" v-model="produto.opCafe1">
          <label>Opção 2 *</label>
          <input type="text" placeholder="Digite a dois" v-model="produto.opCafe2">
          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>
        
      </form>
      </div>
      <table class="striped">

        <thead>

          <tr>
            <th>NOME</th>
            <th>CPF</th>
            <th>OPÇÃO 1</th>
            <th>OPÇÃO 2</th>
            <th>AÇÕES</th>
          </tr>

        </thead>

        <tbody >

          <tr v-for="produto of produtos" :key="produto.id">
            
            <td>{{ produto.name}}</td>
            <td>{{ produto.cpf}}</td>
            <td>{{ produto.opCafe1}}</td>
            <td>{{ produto.opCafe2}}</td>
            <td>AÇÕES</td>
            <td>
              <button @click="editar(produto)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button  @click="remover(produto)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
import Lista from './services/lista'

export default {

  data(){
    return{
      produto:{
        id: '',
        name:'',
        cpf:'',
        opCafe1:'',
        opCafe2:''
        },

       produtos:[],
       errors: []
      }
  },
  
  mounted(){
      this.listar()

    
  },
  methods:{
      
    
    listar(){
      Lista.listar().then(resposta => {
        this.produtos = resposta.data
      })
    },

    salvar(){

      if(!this.produto.id){
          Lista.salvar(this.produto).then(resposta => {
          this.produto = {}
          alert("Salvo com Sucesso", resposta)
          this.listar()
          this.errors = []
          }).catch(e => {
            this.errors = e.response.data.errors
        })
      }else{
        Lista.atualizar(this.produto).then(resposta => {
          this.produto = {}
          alert("Atualizado com Sucesso", resposta)
          this.listar()
          this.errors = []
          }).catch(e => {
            this.errors = e.response.data.errors
        })

      }

     
    },
      editar(produto){
        this.produto = produto

      },
      remover(produto){

      if(confirm('Deseja excluir o produto ?')){
          Lista.deletar(produto).then(resposta =>{
            console.log(resposta)
            this.listar();
            this.errors = []
            }).catch(e =>{
                this.errors = e.response.data.errors
        })
        }
      }
    }
}
</script>

<style>

</style>
