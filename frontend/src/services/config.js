import axios from 'axios'

export const http = axios.create({
    baseURL:'https://apirest-desafiomv.herokuapp.com/api/'

})                  