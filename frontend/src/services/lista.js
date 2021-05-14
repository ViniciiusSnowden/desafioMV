import { http } from './config'

export default{

    listar:()=>{
        return http.get('lista')
    },
  
    salvar:(lista) => {
        return http.post('insert', lista)
    },

    atualizar:(lista) => {
        return http.put('update', lista)
    },

    deletar:(lista) => {
        return http.delete('delete', {data: lista})
    }

}
