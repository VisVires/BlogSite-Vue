<template>
  <div id="tech-blog">
    <h2>{{ currPost.postTitle }}</h2>
    <p>{{ convertDate(currPost.postDate, 'full') }}</p>
    <div v-html="input"></div>
    <b-button-group>
      <b-button size="lg" variant="outline-secondary" type="button" @click="prevPage" :disabled="currentPage==0">Prev Post</b-button>
      <b-button size="lg" variant="outline-secondary" type="button" @click="nextPage" :disabled="currentPage >= pages -1">Next Post</b-button>
    </b-button-group>
    <hr>
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
      input: {},
      currPost: {},
      posts: [],
      currentPage: 0,
      pages: 0
    }
  },
  methods: {
    nextPage() {
      this.currentPage++
      this.currPost = this.posts[this.currentPage]
      this.input = dompurify.sanitize(marked(this.currPost.text))
    },
    prevPage() {
      this.currentPage--
      this.currPost = this.posts[this.currentPage]
      this.input = dompurify.sanitize(marked(this.currPost.text))
    }
  },
  mounted () {
    var baseUrl = process.env.VUE_APP_BASE_URL
    axios
      .get(baseUrl + '/techBlog')
      .then(response => {
        this.posts = response.data
        this.currPost = this.posts[0]
        this.pages = this.posts.length
        this.input = dompurify.sanitize(marked(this.currPost.text))
      })
  }
}
</script>
