<template>
  <div id="blog-form">
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="blog-group-1" label="Blog Title:" label-for="blog-input-1">
        <b-form-input
          id="blog-input-1"
          v-model="form.postTitle"
          required
          placeholder="Enter Title"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="blog-group-2" label="Post:" label-for="blog-input-2">
        <b-form-textarea
          id="blog-input-2"
          v-model="form.post"
          required
          placeholder="Enter text"
          @input="compileMarkdown"
          :value="form.post"
        ></b-form-textarea>
      </b-form-group>

      <b-button v-on:click="compileMarkdown">Preview</b-button>
      <b-button type="submit">Submit</b-button>
      <b-button type="reset">Reset</b-button>
    </b-form>
    <b-card>
      <div v-html="markdown"></div>
    </b-card>
  </div>
</template>

<script>

import marked from 'marked'
import axios from 'axios'

export default {
  name: 'BlogForm',
  data () {
    return {
      responseData: {},
      form : {
        postTitle: '',
        text: '',
        postDate: ''
      },
      markdown: '# This is the markdown preview',
      show: true
    }
  },
  methods: {
    setDate: function () {
      var today = new Date();
      var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
      var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
      this.form.postDate = date+'T'+time+'.000+00:00';
    },
    onSubmit(evt) {
      evt.preventDefault()
      this.setDate()
      alert(JSON.stringify(this.form))
    },
    onReset(evt) {
      evt.preventDefault()
      // Reset our form values
      this.form.postTitle = ''
      this.form.text = ''
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
    sendFormInfo: function () {
      var baseUrl = process.env.VUE_APP_BASE_URL
      axios
        .post(baseUrl + '/techBlog', this.form)
        .then(response => {
          this.responseData = response.data
      })
    },
    compileMarkdown: function() {
      this.markdown = marked(this.form.post);
      console.log(this.markdown)
    }
  }
}
</script>
