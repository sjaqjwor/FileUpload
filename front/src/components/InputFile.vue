<template>
  <div>
    <input type="file" style="display:none" multiple ref="fileInput" @change="selectImage">
    <button @click="$refs.fileInput.click()">이미지 선택</button>
    <button type="button" @click="submit">웹툰 업로드</button>
  </div>
</template>

<script>
import {imageUpload} from "../actions/apiCall";

export default {
  name: "InputFile",
  data() {
    return {
      fileList: [],
      id: 11,
      k: 4,
      form: new FormData()
    };
  },
  methods: {
    selectImage(e) {
      let files = e.target.files;
      if (!files.length) {
        return false;
      }
      console.log("asdsad",files.length)
      for(let a=0;a<files.length;a++){
        console.log(files[a].name)
        this.fileList.push(files[a]);
      }
    },
    submit: async function name() {
      if (!this.fileList.length) {
        alert("이미지를 선택해주세요");
        return false;
      }
      for (let a = 0; a < this.fileList.length; a++) {
        this.form.append("files",this.fileList[a]);
      }
      this.form.append("userId", this.id);
      this.form.append("webtoonId", this.k);
      console.log("Asdasdasd",this.form)
      let result = await imageUpload(this.form)
      if(result.status==200){
        alert("파일 업로드 완성")
      }else{
        alert(result.status)
      }
    }
  }
};
</script>

