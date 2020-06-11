<template>
  <div id="tech-blog">
    <h2>{{ post.postTitle }}</h2>
    <div v-html="input"></div>
  </div>
</template>

<script>

import marked from 'marked'
import axios from 'axios'
import dompurify from 'dompurify'

export default {
  name: 'TechBlog',
  data () {
    return {
      input: '',
      post: {}
    }
  },
  computed: {
    compiledMarkdown: function () {
      return marked()
    }
  },
  mounted () {
    var baseUrl = process.env.VUE_APP_BASE_URL
    axios
      .get(baseUrl + '/techBlog')
      .then(response => {
        this.post = response.data
        this.input = dompurify.sanitize(marked(this.post.text))
      })
  }
}
</script>
