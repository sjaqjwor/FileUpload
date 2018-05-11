import axios from 'axios'
import {fileupload} from "./apiUrl"

export const imageUpload = (formData) =>{
    console.log(fileupload)
    console.log(formData)
    return new Promise((resolve,reject) =>{ 
        try{
            axios.post(fileupload,formData,"Content-type : multipart/form-data")
            .then(response =>{
                resolve(response)
            })
        } catch(error){
            reject(error)
        }
    })
};
