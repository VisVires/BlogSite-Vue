<template>
  <div id="tech-blog">
    <h2>{{ post.postTitle }}</h2>
    <div v-html="input"></div>
    <b-pagination-nav
      number-of-pages="10"
      base-url="#"
    ></b-pagination-nav>
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
      input: [],
      post: {},
      currentPage: 0
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
