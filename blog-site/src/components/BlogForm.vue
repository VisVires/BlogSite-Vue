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
          v-model="form.text"
          required
          placeholder="Enter text the rendered HTML will show in the text-box below"
          @input="compileMarkdown"
          :value="form.text"
        ></b-form-textarea>
      </b-form-group>

      <b-button-group>
        <b-button size="lg" variant="outline-secondary" type="submit">Submit</b-button>
        <b-button size="lg" variant="outline-secondary" type="reset">Reset</b-button>
      </b-button-group>

    </b-form>
    <br>
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
      markdown: '',
      show: true
    }
  },
  methods: {
    setDate: function () {
      var today = new Date();
      var date = today.getFullYear()+'-'+('0'+ (today.getMonth()+1)).slice(-2)+'-'+('0' + today.getDate()).slice(-2);
      var time = today.getHours() + ":" + ('0'+ today.getMinutes()).slice(-2) + ":" + ('0'+ today.getSeconds()).slice(-2);
      this.form.postDate = date+'T'+time+'.000+00:00';
    },
    onSubmit(evt) {
      evt.preventDefault()
      this.setDate()
      alert(JSON.stringify(this.form))
      this.sendFormInfo()
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
      this.markdown = ''
    },
    sendFormInfo: function () {
      var baseUrl = process.env.VUE_APP_BASE_URL
      axios
        .post(baseUrl + '/techBlog', this.form)
        .then(response => {
          this.data = response.data
          console.log(this.data)
      })
    },
    compileMarkdown: function() {
      this.markdown = marked(this.form.text);
    }
  }
}
</script>
