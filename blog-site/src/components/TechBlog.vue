<template>
  <div id="tech-blog">
    <div v-html="compiledMarkdown">These are words</div>
  </div>
</template>

<script>

import marked from 'marked'
import axios from 'axios'

export default {
  name: 'TechBlog',
  data () {
    return {
      input: ' ## _hello_',
      marked: []
    }
  },
  computed: {
    compiledMarkdown: function () {
      return marked(this.input)
    }
  },
  mounted () {
    var baseUrl = process.env.VUE_APP_BASE_URL
    axios
      .get(baseUrl + '/techBlog')
      .then(response => {
        this.marked = response.data
      })
  }
}
</script>
